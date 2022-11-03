package Database;

import Entities.RegularUser;
import Entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * User database class in the Frameworks & Drivers layer that follows the singleton design pattern, and
 * implements an interface in the Application Business Rules layer for dependency inversion purposes.
 * Note: since this is a singleton class, the constructor is private, and it can NOT be created with the
 * new keyword outside this class.
 */
public class userList implements userAccessInterface {
    private static final userList USER_LIST =
            new userList("./src/main/java/Database/artists.csv",
                    "./src/main/java/Database/users.csv");
    Map<String, User> userDatabase;
    String regularFilepath;
    String artistFilepath;

    /**
     * Global static method to retrieve the single instance of the playlistLibrary.
     *
     * @return the single instance of the playlist library database
     */
    public static userList getInstance() {
        return USER_LIST;
    }

    private userList(String aFilepath, String rFilepath) {
        this.regularFilepath = rFilepath;
        this.artistFilepath = aFilepath;
        userDatabase = loadUsers();
    }

    /**
     * Method to read the .csv files from the instance variable paths and return the saved users.
     *
     * @return a hashmap containing all users saved in the .csv files keyed with String usernames
     */
    private Map<String, User> loadUsers() {
        Map<String, User> db = new HashMap<>();

        for (User u : loadRegularUsers()) {
            db.put(u.getUsername(), u);
        }

        for (User u : loadArtistUsers()) {
            db.put(u.getUsername(), u);
        }

        return db;
    }

    /**
     * A helper method for loadUsers() to build artist users from the data from the .csv file.
     *
     * @return ArrayList containing all saved ArtistUsers
     */
    private ArrayList<User> loadArtistUsers() {
        ArrayList<User> result = new ArrayList<>();
        Scanner in;

        try {
            in = new Scanner(new File(artistFilepath));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] data = line.split(",");

                // TODO: finish once user classes created
                // return a new artist with data in data[]
            }
        } catch (FileNotFoundException e) {
            System.out.println("Creating new artist database");
            createFile(regularFilepath);
        }

        return result;
    }

    /**
     * A helper method for loadUsers() to build regular users from the data from the .csv file.
     *
     * @return ArrayList containing all saved RegularUsers
     */
    private ArrayList<User> loadRegularUsers() {
        ArrayList<User> result = new ArrayList<>();
        Scanner in;

        try {
            in = new Scanner(new File(regularFilepath));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] data = line.split(",");

                // TODO: finish once user classes created
                // return a new user with data in data[]
            }
        } catch (FileNotFoundException e) {
            System.out.println("Creating new user database");
            createFile(regularFilepath);
        }

        return result;
    }

    /**
     * A helper method for loadUsers() which creates a blank .csv database if the file is not found.
     *
     * @param fp The filepath of the .csv database.
     */
    private void createFile(String fp) {
        File db = new File(fp);
        try {
            System.out.println(db.createNewFile());
        } catch (IOException ex) {
            System.out.println("Failed db creation");
        }
    }

    /**
     * Saves a new user to the database.
     *
     * @param u newly created User object to be saved to the database
     */
    @Override
    public void save(User u) {
        userDatabase.put(u.getUsername(), u);
        writeFile();
    }

    /**
     * @param username username to be queried in the database
     * @return User object with submitted username, or null if that User does not exist
     */
    @Override
    public User getUser(String username) {
        if (userDatabase.containsKey(username))
            return userDatabase.get(username);
        // TODO: this case should never happen
        return new RegularUser("a", "b");
    }

    /**
     * Method called by saveUser() which writes any newly created users to the .csv files.
     */
    private void writeFile() {
        // TODO: implement
    }

    /**
     * A method to check whether a User exists by username.
     *
     * @param username username to be queried in the database
     * @return true if and only if there exists a User of the name submitted
     */
    @Override
    public boolean exists(String username) {
        return userDatabase.get(username) != null;
    }

    /**
     * @param username username of User password to check submitted password against
     * @param password password to be compared to database
     * @return true if and only if the submitted password matches the password in the database
     */
    @Override
    public boolean checkPassword(String username, String password) {
        return userDatabase.get(username).getPassword().equals(password);
    }
}