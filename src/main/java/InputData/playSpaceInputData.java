package InputData;

import java.util.ArrayList;
import java.util.List;

public class playSpaceInputData {

    private final List<songInputData> spaceSongList;

    public playSpaceInputData(List<songInputData> spaceSongList) {
        this.spaceSongList = spaceSongList;
    }

    public List<songInputData> getSpaceSongList(){
        return this.spaceSongList;
    }
}
