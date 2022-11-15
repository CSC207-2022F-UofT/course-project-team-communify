package Database;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Objects;
import java.util.HashMap;
import java.io.*;

/**
 *  Uses the Eager Instantiation version of the Singleton design pattern.
 *  Java executes the static initializer when the class is first loaded.
 *  Private default constructor prevents creation of subsequent songLibraries.
 */
public class songLibrary implements songAccessInterface{

    private static final songLibrary SONG_LIBRARY = new songLibrary("./src/main/java/Database/songs.csv");
    private final HashMap<Integer, songDsData> library;
    private final String filepath;

    /**
     * Global static method to retrieve the single instance of songLibrary.
     * @return The instance of songlibrary.
     */
    public static songLibrary getInstance(){
        return SONG_LIBRARY;
    }

    private songLibrary(String filepath){
        this.filepath = filepath;
        this.library = readFile();

    }

    /**
     * Saves the current version of the songLibrary to songs.csv
     */
    public void saveFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
            for(songDsData song: library.values()){
                bw.write(song.buildToWrite());
            }
            bw.close();
        }
        catch(IOException e){
            System.out.println("IOException: " + e);
        }
    }

    /**
     * Reads song.csv and returns a Hashmap of all songs.
     * @return Hashmap mapping integer ID of a song to its respective songDsData.
     */
    private HashMap<Integer, songDsData> readFile(){
        HashMap<Integer, songDsData> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String rawLine;
            while ((rawLine = br.readLine()) != null) {

                String[] songInfo = rawLine.split(",");
                int id = Integer.parseInt(songInfo[0]);
                String uploader = songInfo[1];

                songDsData song = readSongFromMetadata(id, uploader, new MP3File(songInfo[2].replace('\\', '/')));
                map.put(id, song);

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e + ". Creating new file.");
            return createFile();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        } catch (TagException | CannotReadException | InvalidAudioFrameException | ReadOnlyFileException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    /**
     * if songs.csv does not exist, createFile will 1) create it, and
     * 2) write into both the csv and SONG_LIBRARY.
     */
    private HashMap<Integer, songDsData> createFile(){
        File csv = new File(filepath);
        HashMap<Integer, songDsData> map = new HashMap<>();
        try{
            if(csv.createNewFile()){
                BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
                File rawLib = new File("src/songLib");
                for(File rawSong: Objects.requireNonNull(rawLib.listFiles())){

                    String idStr = rawSong.getName();
                    int id = Integer.parseInt(idStr.substring(0, idStr.length() - 4));
                    String uploader = "admin";
                    songDsData song = readSongFromMetadata(id, uploader, new MP3File(rawSong));

                    map.put(id, song);
                    bw.write(song.buildToWrite());
                }
                bw.close();
            }
        } catch (TagException | CannotReadException  | InvalidAudioFrameException | ReadOnlyFileException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            System.out.println("Failed to create songs.csv." + e);
        } catch (NullPointerException e){
            System.out.println("Failed to read folder." + e);
        }
        return map;
    }

    /**
     * @param id The id of the song.
     * @param uploader The username of the song uploader.
     * @param rawSong The mp3 file of a given song.
     * @return The songDsData entity representing rawSong.
     */
    private songDsData readSongFromMetadata(int id, String uploader, MP3File rawSong){

        Tag tag = rawSong.getTag();
        BufferedImage cover = (BufferedImage) tag.getFirstArtwork();
        //TODO: OR set as default cover
        String name = format(tag.getFields(FieldKey.TITLE).toString());
        String[] artistList = format(tag.getFields(FieldKey.ARTIST).toString()).split(";");
        String genre = format(tag.getFields(FieldKey.GENRE).toString());

        return new songDsData(id, name, artistList, 0, genre, rawSong.getFile(), cover, uploader);
    }

    /**
     * Corrects metadata read to remove extra text.
     * @param line Line to be formatted.
     * @return Correctly formatted line.
     */
    private String format(String line){
        return line.substring(7, line.length() - 5);
    }

    /**
     * @return Collection of all songs.
     */
    @Override
    public Collection<songDsData> getLibrary() {
        return library.values();
    }

    /**
     * @param song New Song object to be saved to the database.
     * @return true iff save was successful.
     */
    @Override
    public boolean saveSong(songDsData song) {
        if(!library.containsKey(song.getID())){
            library.put(song.getID(), song);
            return true;
        }
        return false;
    }

    /**
     * @param id the unique int ID of a given song.
     * @return true iff a song with the given ID exists.
     */
    @Override
    public boolean exists(int id) {
        return library.containsKey(id);
    }

    /**
     * @param id the unique int ID of a given song.
     * @return Song inside a songDsData with matching ID, or null if it does not exist.
     */
    @Override
    public songDsData getSong(int id){
        return library.get(id);
    }
}
