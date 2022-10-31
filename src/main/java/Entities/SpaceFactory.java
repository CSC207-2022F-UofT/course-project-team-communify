package Entities;

import java.util.ArrayList;

public class SpaceFactory {

    public Space createSpace(ArrayList<Song> songList){
        return new Space(songList);
    }

}
