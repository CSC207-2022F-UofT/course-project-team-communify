package Presenter;

import InputData.playlistInputData;
import InputData.songInputData;
import OutputBoundary.loginOutputBoundary;
import OutputData.loginOutputData;
import ViewModel.PlaylistDsView;
import ViewModel.SongDsView;
import ViewModel.UserDsView;
import ViewModel.userViewModel;

/**
 * Interface adapters layer presenter for displaying login use case output.
 */
public class userPresenter implements loginOutputBoundary {
    private final userViewModel viewModel;
    private final UserDsView output;

    /**
     * @param vm the login register view model
     * @param out the output data for a newly logged-in user
     */
    public userPresenter(userViewModel vm, UserDsView out){
        this.viewModel = vm;
        this.output = out;
    }

    /**
     * @param data the data to return to the view after a login
     */
    @Override
    public void userLogIn(loginOutputData data){
        this.output.setUsername(data.getUsername());
        for (playlistInputData p : data.getPlaylists()){
            PlaylistDsView playlist = this.output.getNewPlaylist();
            playlist.setId(p.getId());
            playlist.setName(p.getName());
            for (songInputData s : p.getSongInputList()){
                SongDsView song = playlist.getNewSong();
                song.setArtists(s.getArtistList());
                song.setCover(s.getCover());
                song.setGenre(s.getGenre());
                song.setId(s.getId());
                song.setName(s.getName());
                playlist.addSong(song);
            }
            this.output.addPlaylist(playlist);
        }
        this.viewModel.updateCurrentUser(this.output);
    }
}
