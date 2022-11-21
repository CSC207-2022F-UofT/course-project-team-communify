package Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
public class userList implements GetUserAccessInterface, SaveUserAccessInterface, LoginUserAccessInterface {
    private static final userList USER_LIST =
            new userList("./src/main/java/Database/artists.csv",
                    "./src/main/java/Database/users.csv");
    Map<String, userDsData> userDatabase;
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
    private Map<String, userDsData> loadUsers() {
        Map<String, userDsData> db = new HashMap<>();
        Scanner in;

        try {
            in = new Scanner(new File(artistFilepath));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] data = line.split(",");
                if (data.length > 0) {
                    if (data.length == 3)
                        db.put(data[1], new userDsData(data[1], data[2], data[0], new String[0]));
                    else
                        db.put(data[1], new userDsData(data[1], data[2], data[0], data[3].split(";")));
                }
            }
            in.close();

            in = new Scanner(new File(regularFilepath));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] data = line.split(",");
                if (data.length > 1)
                    if (data.length == 2){
                        db.put(data[0], new userDsData(data[0], data[1], "".split(";")));
                    } else {
                        db.put(data[0], new userDsData(data[0], data[1], data[2].split(";")));
                    }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Creating new databases");
            createFile(regularFilepath);
            createFile(artistFilepath);
        }

        return db;
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
    public void save(userDsData u) {
        userDatabase.put(u.getUsername(), u);
        writeFile();
    }

    /**
     * @param username username to be queried in the database
     * @return User object with submitted username, or null if that User does not exist
     */
    @Override
    public userDsData getUser(String username) {
        if (userDatabase.containsKey(username))
            return userDatabase.get(username);
        return null;
    }

    /**
     * Method called by save() which writes any newly created users to the .csv files.
     */
    private void writeFile() {
        ArrayList<String> regular = new ArrayList<>();
        ArrayList<String> artist = new ArrayList<>();

        for (String username : userDatabase.keySet()){
            userDsData u = userDatabase.get(username);
            String[] user = u.buildOutput();
            String line = String.join(",", user);

            if (user.length <= 3) regular.add(line);
            else artist.add(line);
        }

        try {
            FileWriter output = new FileWriter(regularFilepath, false);
            for (String line : regular)
                output.write(line + "\n");
            output.close();

            output = new FileWriter(artistFilepath, false);
            for (String line : artist)
                output.write(line + "\n");
            output.close();
        } catch (IOException e) {
            System.out.println("Writing db failed");
        }
    }

    /**
     * A method to check whether a User exists by username.
     *
     * @param username username to be queried in the database
     * @return true if and only if there exists a User of the name submitted
     */
    @Override
    public boolean exists(String username) {
        return userDatabase.containsKey(username);
    }

    /**
     * @param username username of User password to check submitted password against
     * @param password password to be compared to database
     * @return true if and only if the submitted password matches the password in the database
     */
    @Override
    public boolean checkPassword(String username, String password) {
        if (userDatabase.containsKey(username))
            return userDatabase.get(username).getPassword().equals(password);
        return false;
    }
}