package Boot;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class Init {
    /*
     * Entry point for the bootloader.  Services should be started here
     */
    public void init(){
        InitializeHardware initializeHardware = new InitializeHardware();
        initializeHardware.initializeCpu();
        initializeHardware.initializeGpu();
        initializeHardware.initializeNand();
        initializeHardware.initilizeMotherboard();
        initializeHardware.initilizeRam();

        new InitializeKernel().startKernelAndDependencies();

    }

}
