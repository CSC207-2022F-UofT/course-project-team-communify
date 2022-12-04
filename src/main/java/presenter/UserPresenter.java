package presenter;

import inputData.PlaylistInputData;
import inputData.SongInputData;
import outputBoundary.LoginOutputBoundary;
import outputData.LoginOutputData;
import viewModel.PlaylistDsView;
import viewModel.SongDsView;
import viewModel.UserDsView;
import viewModel.UserViewModel;

/**
 * Interface adapters layer presenter for displaying login use case output.
 */
public class UserPresenter implements LoginOutputBoundary {
    private final UserViewModel viewModel;
    private final UserDsView output;

    /**
     * @param vm the login register view model
     * @param out the output data for a newly logged-in user
     */
    public UserPresenter(UserViewModel vm, UserDsView out){
        this.viewModel = vm;
        this.output = out;
    }

    /**
     * @param data the data to return to the view after a login
     */
    @Override
    public void userLogIn(LoginOutputData data){
        this.output.setUsername(data.getUsername());
        for (PlaylistInputData p : data.getPlaylists()){
            PlaylistDsView playlist = this.output.getNewPlaylist();
            playlist.setId(p.getId());
            playlist.setName(p.getName());
            for (SongInputData s : p.getSongInputList()){
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
