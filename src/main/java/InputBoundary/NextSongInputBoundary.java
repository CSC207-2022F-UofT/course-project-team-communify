package inputBoundary;

import inputData.PlaylistInputData;

/**
 * Use case layer input boundary that allows communication between outer layers and the next song use case.
 */
public interface NextSongInputBoundary {
    /**
     * Method to skip to the next song in a playlist, if there is one.
     * @return the new playlist playing interactor
     */
    PlayPlaylistInputBoundary skipSong();

    /**
     * @param data the new playlist to skip songs on
     */
    void updatePlaylist(PlaylistInputData data);
}
