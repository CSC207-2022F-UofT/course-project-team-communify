package InputData;

import java.util.ArrayList;

public class PlaySpaceInputData {

    private final ArrayList<SongInputData> spaceSongList;

    public PlaySpaceInputData(ArrayList<SongInputData> spaceSongList) {
        this.spaceSongList = spaceSongList;
    }

    public ArrayList<SongInputData> getSpaceSongList(){
        return this.spaceSongList;
    }
}
