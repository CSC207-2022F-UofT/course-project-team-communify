package UseCase;

import Entities.Song;
import Entities.Space;
import InputData.spaceInputData;

/**
 * use case for adding a song to a space
 */
public class addSpace {

    /**
     * @param spaceInputData space and song required to add a song to a space
     */
    private void addSongToSpace(spaceInputData spaceInputData){
        // get values
        Space space = spaceInputData.getSpace();
        Song song = spaceInputData.getSong();

        // use case
        space.addSongToSongList(song);

        // no return value to the presenter required
    }
}
