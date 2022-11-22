package InputData;

import java.util.List;

/**
 * Application Business Rules layer data structure for submitting space input to use cases.
 */
public class playSpaceInputData {

    private final List<songInputData> spaceSongList;

    /**
     * @param spaceSongList the songs in the space
     */
    public playSpaceInputData(List<songInputData> spaceSongList) {
        this.spaceSongList = spaceSongList;
    }

    /**
     * @return the songs in the space
     */
    public List<songInputData> getSpaceSongList(){
        return this.spaceSongList;
    }
}
