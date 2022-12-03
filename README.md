## Communify
<p float="left">
  <img src="https://github.com/CSC207-2022F-UofT/course-project-team-communify/blob/main/src/main/java/View/assets/logo_red_full.png" width="200" />
</p>

Communify is a music platform that aims to collaborize music streaming – allowing users to join live “space” radioes and recommend songs to "space" radios. Generally, it allows users to listen to music and create private playlists. On top of all user features, artists can upload music on their artist dashboard. Communify will also provide recommendations based on the individual songs or playlists and have collaborative ‘spaces’ – public radios that users can both listen to and contribute to.


## Running the project
It's pretty easy!
1. Download the files
2. Run src/main/java/Main.java
3. Have fun!

## Features
- you can log in as an _ARTIST_ and a _REGULAR USER_ (i.e. a listener)
- Regular User account for testing has username User1 and password Password1
- as an artist, you can upload songs that regular users can listen to
- regular users can create and listen to playlists. the create playlist view portion has yet to be pushed to main, so just try listening to the existing playlists for now. in a playlist, you can skip, pause, and resume playing songs. 
- there is also the search for a song feature. you can add the songs found to a space -- which is similar to a radio -- as well as the playlists, but the add to playlist has yet to be added to the view. so just try adding them to the space for now!
- you can, of course, listen to the space. if there are songs "added", those will be played first, but it will randomly play songs if there isn't anything queued (like a radio!). you can't skip or pause songs when listening to the radio, though.

## Feature Developers
| Name  | Responsibility |
| :-------------: | :-------------: |
| Rafael | Recommendation Algorithm |
| Manya  | Search Engine  |
| Nick | Playlist creation and curating |
| Christina| Artist Dashboard  |
| Rohan | Audio System |
| Sarah | Space (listening to & adding to) |
| Jessica | Login/Register |

## Comments to the TAs!

### Autograder & GitHub Actions
We remade the default Autograder GitHub Action because it was having some difficulty playing song files, so all our tests failed. Some tests still fail the autograder, because it runs the tests simultaneously. This matters because there is a single MusicPlayer entity that will be handling all this information simultaneously, and sometimes it returns the wrong information from another test. However, all of the tests will pass on a local repo when run individually. 

### Code Coverage Overview (To Complete) 

Controllers: 
- MusicEngineController 100% method coverage, 96% line coverage
- RegisterController 100%
- RegisterArtistController 100%
- LoginController 100%
- SearchController 100%
- EditSongController 100%
- GetArtistSongController 50% TODO

Database:
All database files contain a createFile() called when the csv it uses does not exist. Cannot be tested easily.
- PlaylistLibrary 90%
- SongLibrary 88%
- UserList 90%


Entities:
- UserFactory 100%
- User 100%
- RegularUser 100%
- ArtistUser 100%

Input Datas: 
- SpaceInputData 100%
- LoginInputData 100%
- RegisterInputData 100%
- RegisterArtistInputData 100%
- SearchInputData 100%
- EditPlaylistInputData 100%
- GetArtistSongInputData 0%

Output Datas: 
- LoginOutputData 100%
- SearchOutputData 100%
- EditPlaylistOutputData 100%
- GetArtistSongOutputData 0%

Presenters: 
- SpacePresenter 100%
- UserPresenter 100%
- SearchPresenter 100%
- ArtistPresenter 0%
- EditSongPresenter 100%
- GetArtistSongPresenter 50%

Use Cases: 
- PlaySpaceInteractor 100% method coverage, 93% line coverage
- Login 100%
- RegisterInteractor 100%
- RegisterArtistInteractor 100%
- SearchInteractor 100%
- EditSongInteractor 100%
- GetArtistSongInteractor 50%

View Models: 
- MusicEngineViewModel 57% method coverage, 78% line coverage. what's missing is some action buttons like pause, skip, play, recommendations, and get sync.
- SearchViewModel 100%

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

