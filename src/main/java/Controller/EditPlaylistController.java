package Controller;
import InputBoundary.editPlaylistInputBoundary;
import InputData.editPlaylistInputData;
import ViewModel.PlaylistDsView;
import ViewModel.UserDsView;

/**
 * Interface adapters layer controller for edit playlists use case.
 */
public class EditPlaylistController {

    private final editPlaylistInputBoundary EditPlaylistInteractor;


    /**
     * @param EditPlaylistInteractor the use case interactor for editing playlists
     */
    public EditPlaylistController(editPlaylistInputBoundary EditPlaylistInteractor){
        this.EditPlaylistInteractor = EditPlaylistInteractor;
    }

    /**
     * To add multiple occurrences of a Song from a playlist you must call this method that number of times
     * @param user User object passed in from view
     * @param playlist Playlist object to add a song to
     * @param song Specific song object to add
     */
    public void addSong(UserDsView user, PlaylistDsView playlist, int song){
        editPlaylistInputData inputData = new editPlaylistInputData(user.getUsername(),playlist.getId(),song);
        EditPlaylistInteractor.addSong(inputData);
    }
    /**
     *To remove multiple occurrences of a Song from a playlist you must call this method that number of times
     * @param user User object passed in from view
     * @param playlistID Playlist object to remove a song from
     * @param song Specific song object to remove
     */
    public void removeSong(UserDsView user, int playlistID, int song){
        editPlaylistInputData inputData = new editPlaylistInputData(user.getUsername(),playlistID,song);
        EditPlaylistInteractor.removeSong(inputData);
    }
}
