package Database;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
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
public class songLibrary implements SaveSongAccessInterface, GetSongAccessInterface {

    private static final songLibrary SONG_LIBRARY = new songLibrary("./src/main/java/Database/songs.csv");
    private final HashMap<Integer, songDsData> library;
    private final String filepath;

    private final int UPPER_ID_LIMIT = 10000;

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

                songDsData song = readSongFromMetadata(id, uploader, new MP3File(songInfo[2]));
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

        return new songDsData(id, name, artistList, genre, rawSong.getFile(), cover, uploader);
    }

    /**
     * Corrects metadata read to remove extra text.
     * @param line Line to be formatted.
     * @return Correctly formatted line.
     */
    private String format(String line){
        if(line.length() < 3) return "Unknown";
        else return line.substring(7, line.length() - 5);
    }

    /**
     * @return Collection of all songs.
     */
    @Override
    public Collection<songDsData> getLibrary() {
        return this.library.values();
    }

    /**
     * @param uploader The uploader of the song.
     * @param filepath The file path of the uploaded song.
     * @return true iff save was successful.
     */
    @Override
    public boolean saveSong(String uploader, String filepath){
        try {
            int id = -1;
            while (!exists(id)) id = ThreadLocalRandom.current().nextInt(0, UPPER_ID_LIMIT);
            songDsData newSong = readSongFromMetadata(id, uploader, new MP3File(filepath));
            if(!exists(newSong)){
                library.put(id, newSong);
                return true;
            }
            return false;
        } catch (TagException | CannotReadException | InvalidAudioFrameException | ReadOnlyFileException | IOException e){
            return false;
        }
    }
    
    
     /**
     * @param id the unique id of the song to be deleted.
     * @return true iff delete was successful.
     */
    @Override
    public boolean deleteSong(int id){
        if(exists(id)){
            library.remove(id);
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
        return this.library.containsKey(id);
    }

    /**
     * @param song the songDsData representing song.
     * @return true iff a song with the given ID exists.
     */
    public boolean exists(songDsData song){
        return exists(song.getSong().getName(), song.getSong().getArtistList());
    }

    /**
     * @param name the name of the song.
     * @param artistList the list of contributing artists.
     * @return true iff a song with the given ID exists.
     */
    public boolean exists(String name, String[] artistList){
        for(songDsData song: getLibrary()){
            if(song.getSong().getName().equals(name) && Arrays.equals(artistList, song.getSong().getArtistList())){
                return true;
            }
        }
        return false;
    }

    /**
     * @param id the unique int ID of a given song.
     * @return Song inside a songDsData with matching ID, or null if it does not exist.
     */
    @Override
    public songDsData getSong(int id){
        return this.library.get(id);
    }

    public String[][] getString(){
        int i=0;
        String[][] strLib = new String[library.size()][4];
        for(songDsData song: getLibrary()){
            strLib[i] = song.getString();
            i++;
        }
        return strLib;
    }

    public String[][] getString(int[] ids){
        String[][] strLib = new String[ids.length][4];
        for(int i=0;i<ids.length;i++) strLib[i] = getSong(ids[i]).getString();
        return strLib;
    }
}
