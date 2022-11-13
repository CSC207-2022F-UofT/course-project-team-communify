package UseCase;
import Entities.Song;
import InputBoundary.editPlaylistInputBoundary;
import InputData.editPlaylistInputData;

public class editPlaylist implements editPlaylistInputBoundary{

    /**
    * @param inputData contains contains information to edit the playlist for removeSong(), addSong(), changePrivacy(),
     *                  and changeName()
     *
    */
    //TODO: Update use case like with crate playlist
    public String removeSong(editPlaylistInputData inputData) {
        if (inputData.getPlaylist().getOwner() == inputData.getUser()) {
            for (Song s : inputData.getPlaylist().getSongList())
                if (s.getID() == inputData.getSongID()) {
                    inputData.getPlaylist().removeSong(s);
                    break;
                }
        }
        return inputData.getSong().getName()+" removed ";
    }

    // TODO: Work on view later
    public String addSong(editPlaylistInputData inputData){
        if(inputData.getPlaylist().getOwner() == inputData.getUser()) {
            inputData.getPlaylist().addSong(inputData.getSong());
        }
        return inputData.getSong().getName()+" added!";
    }

    public String changeName (editPlaylistInputData inputData){
        if (inputData.getPlaylist().getOwner() == inputData.getUser()) {
            inputData.getPlaylist().setName(inputData.getNewName());
        }
        return "Name changed!";
    }
}

