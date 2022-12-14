package database;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.images.Artwork;

import javax.imageio.ImageIO;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 *  Uses the Eager Instantiation version of the Singleton design pattern.
 *  Java executes the static initializer when the class is first loaded.
 *  Private default constructor prevents creation of subsequent songLibraries.
 */
public class SongLibrary implements SaveSongAccessInterface, GetSongAccessInterface {

    private static final SongLibrary SONG_LIBRARY = new SongLibrary("./src/main/java/database/songs.csv");
    private final BufferedImage DEFAULT_COVER;
    private final HashMap<Integer, SongDsData> library;
    private final String filepath;

    private final String SONG_PATH = "src/songLib";

    // Temporary cache of songs uploaded during current login cycle.
    private final ArrayList<SongDsData> uploadQueue;

    /**
     * Global static method to retrieve the single instance of songLibrary.
     * @return The instance of songLibrary.
     */
    public static SongLibrary getInstance(){
        return SONG_LIBRARY;
    }

    /**
     * Private constructor for singleton
     * @param filepath path to the .csv file
     */
    private SongLibrary(String filepath){
        this.filepath = filepath;

        BufferedImage tempCover;
        try {
            tempCover = ImageIO.read(new File(Paths.get("").toAbsolutePath() +
                    "/src/songLib/cover/no_genre.png"));
        } catch (IOException e) {
            tempCover = null;
            System.out.println(e.getMessage() + " - failed to find default cover.");
        }
        this.DEFAULT_COVER = tempCover;

        this.library = readFile();
        this.uploadQueue = new ArrayList<>();
    }

    /**
     * Saves the updated song library to the database.
     */
    public void saveLibrary(){
        if(!uploadQueue.isEmpty()) try{

            // Update songLib
            for(SongDsData song: uploadQueue){
                String songPath = this.SONG_PATH + "/" + song.getID() + ".mp3";
                Files.copy(song.getSong().getFile().toPath(), Paths.get(songPath));
                song.setFile(songPath);
            }

            uploadQueue.clear();

            // Update songLibrary.csv
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true));
            for(SongDsData song: library.values()){
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
    private HashMap<Integer, SongDsData> readFile(){
        HashMap<Integer, SongDsData> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String rawLine;
            while ((rawLine = br.readLine()) != null) {

                String[] songInfo = rawLine.split(",");
                int id = Integer.parseInt(songInfo[0]);
                String uploader = songInfo[1];

                SongDsData song = readSongFromMetadata(id, uploader, new MP3File(songInfo[2].replaceAll("\\\\", "/")));
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
     * @return a map of the songs in the database
     */
    private HashMap<Integer, SongDsData> createFile(){
        File csv = new File(filepath);
        HashMap<Integer, SongDsData> map = new HashMap<>();
        try{
            if(csv.createNewFile()){
                BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
                File rawLib = new File(SONG_PATH);
                for(File rawSong: Objects.requireNonNull(rawLib.listFiles())){

                    String idStr = rawSong.getName();
                    int id = Integer.parseInt(idStr.substring(0, idStr.length() - 4));
                    String uploader = "admin";
                    SongDsData song = readSongFromMetadata(id, uploader, new MP3File(rawSong));

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
    private SongDsData readSongFromMetadata(int id, String uploader, MP3File rawSong){

        Tag tag = rawSong.getTag();
        BufferedImage cover = this.DEFAULT_COVER;

        String name = format(tag.getFields(FieldKey.TITLE).get(0).toString());
        String[] artistList = format(tag.getFields(FieldKey.ARTIST).get(0).toString()).split(";");
        String genre = format(tag.getFields(FieldKey.GENRE).get(0).toString());

        try {
            Artwork rawCover = tag.getFirstArtwork();
            if(rawCover != null) cover = (BufferedImage) rawCover.getImage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new SongDsData(id, name, artistList, genre, rawSong.getFile(), cover, uploader);
    }

    /**
     * Corrects metadata read to remove extra text.
     * @param line Line to be formatted.
     * @return Correctly formatted line.
     */
    private String format(String line){
        if(line.length() < 3) return "Unknown";
        else return line.replace("Text=\"", "").replace("\";", "").trim();
    }

    /**
     * @return Collection of all songs.
     */
    @Override
    public Collection<SongDsData> getLibrary() {
        return this.library.values();
    }

    /**
     * @param uploader The uploader of the song.
     * @param filepath The file path of the uploaded song.
     * @return true iff save was successful.
     */
    @Override
    public boolean saveSong(String uploader, String filepath){
        System.out.println("saving");
        try {
            int id = -1;
            int UPPER_ID_LIMIT = 10000;
            while (exists(id) || id == -1) id = ThreadLocalRandom.current().nextInt(0, UPPER_ID_LIMIT);
            SongDsData newSong = readSongFromMetadata(id, uploader, new MP3File(filepath));
            if(!exists(newSong)){
                library.put(id, newSong);
                uploadQueue.add(newSong);
                return true;
            }
            return false;
        } catch (TagException | CannotReadException | InvalidAudioFrameException | ReadOnlyFileException | IOException e){
            return false;
        }
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
     * @return true iff a song with the given name and artists exists.
     */
    public boolean exists(SongDsData song){
        return exists(song.getSong().getName(), song.getSong().getArtistList());
    }

    /**
     * @param name the name of the song.
     * @param artistList the list of contributing artists.
     * @return true iff a song with the given ID exists.
     */
    public boolean exists(String name, String[] artistList){
        for(SongDsData song: getLibrary()){
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
    public SongDsData getSong(int id){
        return this.library.get(id);
    }


    public String[][] getString(){
        int i=0;
        String[][] strLib = new String[library.size()][4];
        for(SongDsData song: getLibrary()){
            strLib[i] = song.getString();
            i++;
        }
        return strLib;
    }

    public String[][] getString(ArrayList<Integer> ids){
        String[][] strLib = new String[ids.size()][4];
        for(int i=0;i<ids.size();i++) strLib[i] = getSong(ids.get(i)).getString();
        return strLib;
    }

    public String[][] getString(String username){
        ArrayList<Integer> ids = new ArrayList<>();
        for(SongDsData song: getLibrary()) if(song.getSong().getUploader().equals(username)) ids.add(song.getID());
        return getString(ids);
    }
}
