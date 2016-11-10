package Validate.HardwareTools.Cache;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class Cache {
    public boolean verifyCache() {
        String processorID = System.getenv("PROCESSOR_IDENTIFIER");
        String arch = System.getenv("PROCESSOR_ARCHITECTURE");
        int proccessorCount = Integer.parseInt(System.getenv("NUMBER_OF_PROCESSORS"));
        if (processorID != null || processorID != "" || arch != "" || proccessorCount != 0 || arch != null) {
            System.out.println("CPU functional");
            return true;
        } else {
            System.out.println("Hardware Fault");
            return false;
        }
    }
}
