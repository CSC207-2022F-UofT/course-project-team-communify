package outputBoundary;

import outputData.LoginOutputData;

/**
 * Use case layer output boundary that allows communication between presenters and the login use case.
 */
public interface LoginOutputBoundary {
    /**
     * @param data the data to return to the view after a login
     */
    void userLogIn(LoginOutputData data);
}
