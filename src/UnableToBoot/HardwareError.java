package UnableToBoot;

/**
 * Created by matthewelbing on 3/24/16.
 */
public interface HardwareError {
    void alertUser();
    void diagnoseError(int currentError);
}
