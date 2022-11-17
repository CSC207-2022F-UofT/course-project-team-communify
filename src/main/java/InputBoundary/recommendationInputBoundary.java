package InputBoundary;

/**
 * Application Business Rules layer interface to be implemented by a Use Case
 * to allow communication between use cases and UI input (dependency inversion).
 */
public interface recommendationInputBoundary {
    /**
     * Requests a recommendation.
     */
    public void recommendation();
}
