package ViewModel;

import java.awt.image.BufferedImage;

public interface SongDsView {
    void setName(String name);

    void setCover(BufferedImage cover);

    void setId(int id);

    void setGenre(String genre);

    void setArtists(String[] artists);
}
