# RVTask

The objective of this task is to connect to the an API and show a list of characters into a RecyclerView, showing the image (by URL), the name and the status of each character.


 

API -> https://rickandmortyapi.com/documentation/


 


	
Use just public libraries for connect to a REST API and showing images into a IImageView elements. Nothing like Instagram Android SDK or other Bag of Tricks.
	You can use Internet as much as you like BUT you can’t copy/paste code. You should share your screen to see what are you looking at.
	The application must not crash and be responsive to input from the user anytime.
	Do not use deprecated libraries/classes/methods
	You are free for use Java, Kotlin, coroutines, androidx, Jetpack’s architecture components., RxJava, MVVM, etc. Just justify



 

EXTRA POINTS: If you make the list endless.

EXTRA POINTS: If you make the list like a grid.

EXTRA POINTS: If you implement click con each item and show a modal window with more information (pick any)

GET https://rickandmortyapi.com/api/character/
```json
{
   "info":{
      "count":671,
      "pages":34,
      "next":"https://rickandmortyapi.com/api/character/?page=2",
      "prev":null
   },
   "results":[
      {
         "id":1,
         "name":"Rick Sanchez",
         "status":"Alive",
         "species":"Human",
         "type":"",
         "gender":"Male",
         "image":"https://rickandmortyapi.com/api/character/avatar/1.jpeg"
      }
   ]
}
```

GET https://rickandmortyapi.com/api/character/{character_id}
```json
{
   "id":78,
   "name":"Cowboy Rick",
   "status":"Alive",
   "species":"Human",
   "type":"",
   "gender":"Male",
   "image":"https://rickandmortyapi.com/api/character/avatar/78.jpeg",
}
```
