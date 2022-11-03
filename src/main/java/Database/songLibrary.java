package Database;

import Entities.Song;

public class songLibrary {
    /**
     * Method to get a Song by its unique identifier
     * @param id the unique identifier of the Song to be returned
     * @return Song object with matching id
     */
    public Song getSong(int id){
        // TODO: replace dummy implementation
        return new Song(id, null, null, 0,
                null, null, false, null);
    }

}
