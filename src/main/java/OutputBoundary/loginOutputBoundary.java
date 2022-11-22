package OutputBoundary;

import OutputData.loginOutputData;

/**
 * Use case layer output boundary that allows communication between presenters and the login use case.
 */
public interface loginOutputBoundary {
    /**
     * @param data the data to return to the view after a login
     */
    void userLogIn(loginOutputData data);
}
