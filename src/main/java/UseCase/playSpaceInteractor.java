package UseCase;

import Entities.Song;
import InputData.spaceInputData;
import OutputData.songOutputData;
import java.io.File;

/**
 * use case for playing a space
 */
public class playSpaceInteractor {

    private final OutputBoundary.spacePlayedOutputBoundary spacePlayedOutputBoundary;

    /**
     * constructor
     * @param spacePlayedOutputBoundary wrapper for the spacePresenter object to follow clean architecture
     */
    public playSpaceInteractor(OutputBoundary.spacePlayedOutputBoundary spacePlayedOutputBoundary){
        this.spacePlayedOutputBoundary = spacePlayedOutputBoundary;
    }

    /**
     * calls playSong's actuallyPlaySong function
     * @param spaceInputData object containing space and song required for playing the space.
     */
    private void playSpace(spaceInputData spaceInputData){
        // get values
        Song song = spaceInputData.getSong();
        File songFile = song.getFile();

        // play song
        // playAudioInteractor audio = new playAudioInteractor();
        // audio.playAudio(songFile);

        // construct return data and call OutputBoundary/Presenter
        songOutputData songOutputData = new songOutputData(song);
        this.spacePlayedOutputBoundary.spacePlayed(songOutputData);

        // TODO: test
    }

}
