package Boot;

import Validate.EnsureValidateHardware;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class InitializeHardware {
    /*
    Start hardware services here after validating them
     */
    private EnsureValidateHardware hardwareVerifier = new EnsureValidateHardware();

    public void initializeCpu(){
        hardwareVerifier.checkCPU();
    }

    public void initializeGpu(){
        hardwareVerifier.checkGPU();
    }

    public void initializeNand(){
        hardwareVerifier.checkNand();
    }

    public void initilizeRam(){
        hardwareVerifier.checkRAM();
    }

    public void initilizeMotherboard(){
        hardwareVerifier.checkMotherboard();
    }

}
