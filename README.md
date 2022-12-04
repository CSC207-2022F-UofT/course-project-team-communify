## Communify
<p float="left">
  <img src="https://github.com/CSC207-2022F-UofT/course-project-team-communify/blob/main/src/main/java/view/assets/logo_red_full.png" width="200" alt="Communify logo"/>
</p>

Communify is a music platform that aims to make music streaming more collaborative – allowing users to join live “space” radios and recommend songs to "space" radios. Generally, it allows users to listen to music and create private playlists. On top of all user features, artists can upload music on their artist dashboard. Communify will also provide recommendations based on the individual songs or playlists and have collaborative ‘spaces’ – public radios that users can both listen to and contribute to.


## Running the project
It's pretty easy!
1. Download the files
2. Run src/main/java/Main.java
3. Have fun!

**Note:** certain functions of the program are _very_ slow - we are working on this. Give the program a few seconds when logging-in, or adding/removing songs from playlists.

## Features
- you can log in as an _ARTIST_ and a _REGULAR USER_ (i.e. a listener)
- Regular User account for testing has username User1 and password Password1
- as an artist, you can upload songs that regular users can listen to
- regular users can create and listen to playlists. the create playlist view portion has yet to be pushed to main, so just try listening to the existing playlists for now. in a playlist, you can skip, pause, and resume playing songs. 
- there is also the search for a song feature. you can add the songs found to a space -- which is similar to a radio -- as well as the playlists, but the add to playlist has yet to be added to the view. so just try adding them to the space for now!
- you can, of course, listen to the space. if there are songs "added", those will be played first, but it will randomly play songs if there isn't anything queued (like a radio!). you can't skip or pause songs when listening to the radio, though.

## Feature Developers
|   Name    |          Responsibility          |
|:---------:|:--------------------------------:|
|  Rafael   |     Recommendation Algorithm     |
|   Manya   |          Search Engine           |
|   Nick    |  Playlist creation and curating  |
| Christina |         Artist Dashboard         |
|   Rohan   |           Audio System           |
|   Sarah   | Space (listening to & adding to) |
|  Jessica  |          Login/Register          |

## Comments to the TAs!

### Autograder & GitHub Actions
We remade the default Autograder GitHub Action because it was having some difficulty playing song files, so all our tests failed. Some tests still fail the autograder, because it runs the tests simultaneously. This matters because there is a single MusicPlayer entity that will be handling all this information simultaneously, and sometimes it returns the wrong information from another test. However, all the tests will pass on a local repo when run individually. 

### Code Coverage Overview (To Complete) 
Controllers: 
- EditPlaylistController 100%
- EditSongController 100%
- GetArtistSongController 100%
- LoginController 100%
- MusicEngineController 100%
- NewPlayistController 33% TODO
- PlaylistController 0% TODO
- RegisterArtistController 100%
- RegisterController 100%
- SearchController 100%


Database:
All database files contain a createFile() called when the csv it uses does not exist. Cannot be tested easily.
- PlaylistLibrary 90%
- PlaylistDsData 100%
- SongDsData 63% TODO
- SongLibrary 88%
- UserDsData 100%
- UserList 90%


Entities:
- ArtistUser 100%
- JPlayer 80%
- MusicPlayer 92%
- Playlist 94%
- RegularUser 100%
- Song 95%
- User 100%
- UserFactory 100%


Input Datas: 
- EditPlaylistInputData 100%
- GetArtistSongInputData 100%
- LoginInputData 100%
- NewPlaylistInputData 100%
- PlaylistInputData 100%
- PlaySpaceInputData 100%
- RegisterArtistInputData 100%
- RegisterInputData 100%
- SearchInputData 100%
- SongInputData 91%
- UploadSongInputData 100%


Output Datas: 
- EditPlaylistOutputData 100%
- EditSongOutputData 100%
- GetArtistSongOutputData 100%
- LoginOutputData 100%
- NewPlaylistOutputData 100%
- SearchOutputData 100%
- SongOutputData 88%


Presenters: 
- ArtistPresenter 100%
- EditSongPresenter 100%
- GetArtistSongPresenter 100%
- PlaylistPresenter 100%
- SearchPresenter 100%
- SongPresenter 100%
- SpacePresenter 100%
- UserPresenter 100%


Use Cases: 
- CreatePlaylistInteractor 100%
- EditPlaylistInteractor 100%
- EditSongInteractor 100%
- GetArtistSongInteractor 100%
- LoginInteractor 100%
- NextSongInteractor 100%
- PauseSongInteractor 100%
- PlayPlaylistInteractor 100%
- PlaySongInteractor 100%
- PlaySpaceInteractor 100%
- RecommendSongInteractor 100%
- RegisterArtistInteractor 100%
- RegisterInteractor 100%
- SearchInteractor 100%
- ShufflePlaylistInteractor 0% TODO


View Models: 
- ArtistViewModel 100%
- MusicEngineViewModel 78%
- PlaylistViewModel 94%
- SearchViewModel 100%
- UserViewModel 85%

### Design Patterns Used
- Singleton, multiple times in classes such as UserList, PlaylistLibrary, SongLibrary
- A facade, removing the Swing code from Main.java
- A factory, creating both types of user (regular and Artist)

### Examples of SOLID 
- Single Responsibility Principle: each of our classes have a single, defined purpose.
- Open/Closed Principle: any case of an extended class has no modification of the original superclass
- Liskov Substitution Principle: When defining our instance variables, we used the super classes for the datatypes so that we can use different implementations in the future.
- Interface Segregation Principle: our databases have multiple interfaces such that client code only has access to the methods that it needs
- Dependency Inversion: we used dependency inversion frequently throughout the project (i.e. input/output boundaries, database access layers)

