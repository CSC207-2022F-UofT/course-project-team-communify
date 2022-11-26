package InputBoundary;

import InputData.RegisterInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the register use case.
 */
public interface RegisterInputBoundary {
    /**
     * @param registerInputData the input data of the new user
     * @return true if the register is successful
     */
    boolean register(RegisterInputData registerInputData);
}
