package Validate.HardwareTools.Storage;


import java.io.File;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class Storage {
    public boolean verifyStorage() {
        File testFile = new File("/test.txt");
        if (testFile.exists()) {
            return true;
        } else {
            return false;
        }

    }
}
