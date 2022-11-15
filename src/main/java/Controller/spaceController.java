package Controller;

import Entities.MusicPlayer;
import InputBoundary.playSpaceInputBoundary;
import InputData.playSpaceInputData;
import InputData.songInputData;
import OutputData.songOutputData;
import Presenter.spacePresenter;
import UseCase.playSpaceInteractor;

import java.util.ArrayList;


/**
 * Controller for use cases related to the Space.
 */
public class spaceController {
    private final playSpaceInputBoundary playSpaceInteractor;
    private final ArrayList<songInputData> spaceSongList;
    private final Presenter.spacePresenter spacePresenter; // not OutputBoundary because in the same layer as Controller


    /**
     * Constructor.
     * @param spacePresenter presenter for use case
     */
    public spaceController(spacePresenter spacePresenter){
        this.spacePresenter = spacePresenter;
        this.spaceSongList = new ArrayList<>();
        this.playSpaceInteractor = new playSpaceInteractor(this.spacePresenter,
                new playSpaceInputData(this.spaceSongList));
    }

    /**
     * function calling the use case for playing the space
     */
    public void playSpace(){
        playSpaceInputData playSpaceInputData = new playSpaceInputData(this.spaceSongList);
        this.playSpaceInteractor.playSpace(playSpaceInputData);
    }

    /**
     * function calling the use case for adding a song to the space
     * @param songInputData input data for adding a song to the space
     */
    public void spaceAddSong(songInputData songInputData){
        Integer songToAddID = songInputData.getSong().getID();
        for (songInputData currSongInputData : this.spaceSongList){
            Integer currSongID = currSongInputData.getSong().getID();
            if (currSongID.equals(songToAddID)){
                return;  // if the song is already in the playlist, do nothing
                // TODO: make this cooler (i.e. upvote algo) if time
            }
        }
        this.spaceSongList.add(songInputData);  // song is not in list, so append to the end
    }

    // TODO: write unit tests

}
