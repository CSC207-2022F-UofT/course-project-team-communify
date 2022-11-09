package UseCase;
import Entities.Song;
import InputBoundary.editPlaylistInputBoundary;
import InputData.editPlaylistInputData;
public class editPlaylist implements editPlaylistInputBoundary{

    /**
    * @param inputdata contains contains information to edit the playlist for removeSong(), addSong(), changePrivacy(),
     *                  and changeName()
     *
    */
    public String removeSong(editPlaylistInputData inputData) {
        if (inputData.getPlaylist().getOwner() == inputData.getUser()) {
            for (Song s : inputData.getPlaylist().getSongList())
                if (s.getID() == inputData.getSongID()) {
                    inputData.getPlaylist().removeSong(s);
                    break;
                }
            return inputData.getSong().getName()+" removed ";
        }
        else {
            return "You don't have permission to edit this playlist!";
        }
    }
    // TODO: Work on view later
    public String addSong(editPlaylistInputData inputData){
        if(inputData.getPlaylist().getOwner() == inputData.getUser()) {
            inputData.getPlaylist().addSong(inputData.getSong());
            return inputData.getSong().getName()+" added!";
        }
        else{
            return "You don't have permission to edit this playlist!";
        }
    }

    public String changePrivacy(editPlaylistInputData inputData) {
        if (inputData.getPlaylist().getOwner() == inputData.getUser()) {
            inputData.getPlaylist().setPrivacy(inputData.getPrivacy());
            return "Privacy changed!";
        }
        else{
            return "You don't have permission to edit this playlist!";
        }
    }
        public String changeName (editPlaylistInputData inputData){
            if (inputData.getPlaylist().getOwner() == inputData.getUser()) {
                inputData.getPlaylist().setName(inputData.getNewName());
                return "Name changed!";
            }
            else{
                return "You don't have permission to edit this playlist!";
            }
        }

}

