package inputBoundary;

import inputData.GetArtistSongInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the get artist songs use case.
 */
public interface GetArtistSongInputBoundary {
    /**
     * @param asid the artist's song IDs
     */
    void getArtistSong(GetArtistSongInputData asid);
}