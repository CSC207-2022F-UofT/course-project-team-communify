package Presenter;
import OutputBoundary.NewPlaylistOutputBoundary;
import OutputBoundary.EditPlaylistOutputBoundary;
import OutputData.EditPlaylistOutputData;
import OutputData.NewPlaylistOutputData;
import View.InMemoryUser;
import ViewModel.PlaylistDsView;
import ViewModel.SongDsView;
import ViewModel.UserDsView;
import ViewModel.PlaylistViewModel;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Interface adapters layer presenter for displaying edit playlists use case output.
 */
public class PlaylistPresenter implements NewPlaylistOutputBoundary, EditPlaylistOutputBoundary {

    private String outputMessage;

    private final PlaylistViewModel viewModel;
    private final UserDsView user;

    /**
     *
     * @param viewModel view model to store output message in
     * @param inMemoryUser a blank new user
     */
    public PlaylistPresenter(PlaylistViewModel viewModel, InMemoryUser inMemoryUser){
        //this.outputMessage = outputData.getCreatedMessage();
        this.viewModel = viewModel;
        this.outputMessage = "";
        this.user = inMemoryUser;
    }

    /**
     *
     * @return confirmation of string creation
     */
    public String getOutputMessage(){
        return outputMessage;
    }
    /**
     * @param outputData outputData object containing confirmation message.
     */
    public void setPlaylistCreationConfirmation(NewPlaylistOutputData outputData){
        this.outputMessage = outputData.getCreatedMessage();
        this.viewModel.setOutputMessage(this.outputMessage);
    }

    /**
     * @param outputData the data to build the playlist from
     * @return the new playlist
     */
    private PlaylistDsView buildPlaylist(EditPlaylistOutputData outputData) {
        PlaylistDsView playlist = user.getNewPlaylist();
        playlist.setId(outputData.getPlaylistID());
        playlist.setName(outputData.getPlaylistName());

        List<Integer> songIDs = outputData.getSongIDs();
        List<String> songNames = outputData.getSongNames();
        List<String[]> songArtists = outputData.getSongArtists();
        List<String> songGenres = outputData.getSongGenres();
        List<BufferedImage> songCovers = outputData.getSongCovers();

        for (int i = 0; i < songIDs.size(); i++){
            SongDsView song = playlist.getNewSong();
            song.setId(songIDs.get(i));
            song.setArtists(songArtists.get(i));
            song.setGenre(songGenres.get(i));
            song.setCover(songCovers.get(i));
            song.setName(songNames.get(i));
            playlist.addSong(song);
        }

        return playlist;
    }

    /**
     * @param outputData the output to set as confirmation for edited playlist
     */
    public void setEditPlaylistConfirmation(EditPlaylistOutputData outputData){
        this.outputMessage = outputData.getPlaylistEditedConfirmation();
        this.viewModel.setCurrPlaylist(buildPlaylist(outputData));
        this.viewModel.setOutputMessage(this.outputMessage);
    }
}