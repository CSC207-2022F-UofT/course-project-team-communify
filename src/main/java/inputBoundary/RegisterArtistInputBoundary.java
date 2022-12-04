package inputBoundary;

import inputData.RegisterArtistInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the register user use case.
 */
public interface RegisterArtistInputBoundary {
    /**
     * @param artistInputData the input data of the new artist
     * @return true if the register is successful
     */
    boolean register(RegisterArtistInputData artistInputData);
}
