package Detect;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class Init {
    CheckForNovelHardware checkForNovelHardware = new CheckForNovelHardware();
    InitHardware initHardware = new InitHardware();
    ValidateExistingHardware validateExistingHardware = new ValidateExistingHardware();

    public void init(){
        checkForNovelHardware.isGpuPresent(checkForNovelHardware.getGpuInfo());
    }
}
