package InputBoundary;

import InputData.getArtistSongInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the get artist songs use case.
 */
public interface getArtistSongInputBoundary {
    /**
     * @param asid the artist's song IDs
     */
    void getArtistSong(getArtistSongInputData asid);
}