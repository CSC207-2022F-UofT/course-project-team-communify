package UseCase;
import Entities.Playlist;
import Entities.Song;
import Entities.User;

import java.util.ArrayList;

public class editPlaylist {



    public boolean isCollaborator(User user, Playlist playlist){
        ArrayList<User> collabList = playlist.showCollaborators();
        boolean isCollaborator = false;
        for (User editor:collabList){
            if (editor == user){
                isCollaborator = true;
            }
        }
        return  isCollaborator;
    }
    public void removeSong(User user, Song song, Playlist playlist){
        boolean isCollaborator = isCollaborator(user,playlist);
        if(playlist.getOwner() == user || isCollaborator)
            for (Song s: playlist.songList){
                if(s == song){
                    playlist.songList.remove(s);
                    break;
                }
            }

        // potentially do something that says "You dont have permission to add or remove from playlist"
        // do later
    }
    public void addSong(User user, Song song, Playlist playlist){
        boolean isCollaborator = isCollaborator(user,playlist);
        if(playlist.getOwner() == user || isCollaborator){
            playlist.songList.add(song);
        }
    }
}
