package com.example.encoratask.repository

import android.util.Log
import com.example.encoratask.model.Character
import com.example.encoratask.repository.network.APICharacter
import com.example.encoratask.repository.network.CharacterResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class APICharacterImpl @Inject constructor (val APIservice: APICharacter) {

    fun getData() = callbackFlow<List<Character>> {
        val responseObservable = APIservice.getCharacters()
            responseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<CharacterResponse>{
                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onSuccess(t: CharacterResponse?) {
                        t?.let {
                          if (it.results.isNotEmpty()){
                              channel.trySendBlocking(it.results)
                          }
                        }
                    }

                    override fun onError(e: Throwable?) {
                        if (e != null) {
                            Log.d("tag","Error NetworkOperation: -> ${e.message}")
                        }
                    }

                }).apply { awaitClose() } }

    }