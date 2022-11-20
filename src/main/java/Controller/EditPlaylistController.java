package Controller;
import Entities.RegularUser;
import Entities.Playlist;
import Entities.Song;
import InputBoundary.EditPlaylistInputBoundary;
import InputData.EditPlaylistInputData;

public class EditPlaylistController {

    private final EditPlaylistInputBoundary EditPlaylistInteractor;


    public EditPlaylistController(EditPlaylistInputBoundary EditPlaylistInteractor){
        this.EditPlaylistInteractor = EditPlaylistInteractor;
    }

    /**
     * To add multiple occurrences of a Song from a playlist you must call this method that number of times
     * @param user User object passed in from view
     * @param playlist Playlist object to add a song to
     * @param song Specific song object to add
     */
    public void addSong(RegularUser user, Playlist playlist, Song song){
        EditPlaylistInputData inputData = new EditPlaylistInputData(user,playlist,song);
        EditPlaylistInteractor.addSong(inputData);
    }
    /**
     *To remove multiple occurrences of a Song from a playlist you must call this method that number of times
     * @param user User object passed in from view
     * @param playlist Playlist object to remove a song from
     * @param song Specific song object to remove
     */
    public void removeSong(RegularUser user, Playlist playlist, Song song){
        EditPlaylistInputData inputData = new EditPlaylistInputData(user,playlist,song);
        EditPlaylistInteractor.removeSong(inputData);
    }
}
