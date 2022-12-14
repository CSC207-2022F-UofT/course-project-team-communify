package entities;

/**
 * Abstract User entity to represent the multiple types of Users in the program.
 */
public abstract class User {
    private final String username;
    private final String password;

    /**
     * @param username string username of the user
     * @param password string password of the user
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * @return the Username of the User
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the Password of the User
     */
    public String getPassword() {
        return password;
    }
}
