package InputBoundary;

import InputData.loginInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the login use case.
 */
public interface loginInputBoundary {
    /**
     * @param loginID the input data for logging in
     * @return true if the login is successful
     */
    boolean login(loginInputData loginID);
}
