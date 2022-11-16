package UseCase;
import Database.playlistDsData;
import Entities.Playlist;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import Database.playlistAccessInterface;
import Database.playlistLibrary;
import OutputBoundary.newPlaylistOutputBoundary;
import OutputData.newPlaylistOutputData;

public class createPlaylist implements newPlaylistInputBoundary {
        private newPlaylistOutputBoundary outputBoundary;
//        private String message;
    public createPlaylist(newPlaylistOutputBoundary outputBoundary){
        this.outputBoundary = outputBoundary;
//        this.message = "";
    }
//    private final newPlaylistOutputBoundary newPlaylistOutputBoundary;
//    public createPlaylist(newPlaylistOutputBoundary newPlaylistOutputBoundary){
//        this.newPlaylistOutputBoundary = newPlaylistOutputBoundary;
//    }
    /**
     * @param newplaylistInputData holds necessary data to instantiate a new playlist
     * if hasFirstSong() is false, then newPlaylist() will instantiate an empty playlist and vice versa if it's value
     * is true
     */
    public void newPlaylist(newPlaylistInputData newplaylistInputData) {
        Playlist playlist;
        playlistAccessInterface library = playlistLibrary.getInstance();
        if (!newplaylistInputData.hasFirstSong()) {
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(),
                    newplaylistInputData.getOwner());
        }
        else{
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(), newplaylistInputData.getOwner(),
                     newplaylistInputData.getFirstSong());
        }
        newplaylistInputData.getOwner().addPlaylist(playlist);
        // save the newly created playlist to the RegularUser's playlist list
        library.savePlaylist(new playlistDsData(playlist));

        //TODO #1: new potential implementation of sending confirmation message via outputdata, check correctness
        //TODO #2: Regain will to live
        //TODO #3: delete commented lines when finalizing this implementation

        //generate output data
        newPlaylistOutputData outputData = new newPlaylistOutputData("Playlist created!");
        // this.newPlaylistOutputBoundary.playlistCreationConfirmation(outputData);
        // this.outputBoundary.getPlaylistCreationConfirmation(outputData);

        //set message attribute to output data
        this.outputBoundary.setPlaylistCreationConfirmation(outputData);
//        this.message = this.outputBoundary.getPlaylistCreationConfirmation(outputData);

        // return "Playlist created!";
    }
//    public String showConfirmation(){
//        return this.message;
//    }
}

