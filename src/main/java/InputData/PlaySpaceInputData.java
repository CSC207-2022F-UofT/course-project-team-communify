package inputData;

import java.util.List;

/**
 * Application Business Rules layer data structure for submitting space input to use cases.
 */
public class PlaySpaceInputData {

    private final List<SongInputData> spaceSongList;

    /**
     * @param spaceSongList the songs in the space
     */
    public PlaySpaceInputData(List<SongInputData> spaceSongList) {
        this.spaceSongList = spaceSongList;
    }

    /**
     * @return the songs in the space
     */
    public List<SongInputData> getSpaceSongList(){
        return this.spaceSongList;
    }
}
