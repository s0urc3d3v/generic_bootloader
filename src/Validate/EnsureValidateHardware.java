package Validate;

import UnableToBoot.NandError;

import java.io.File;
import java.io.IOException;

import static java.lang.Runtime.getRuntime;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class EnsureValidateHardware {
    /**
     * Checks the validity of the Nand by testing read and write conditions
     * @return (Boolean) Valid NAND?
     */
    public boolean checkNand(){
        File writeTestFile = new File("validateNand");
        File readTestFile = new File("TestFile");
        try {
            writeTestFile.createNewFile();
        }
        catch (IOException IOException){
            NandError nandError = new NandError();
            nandError.alertUser();
            nandError.diagnoseError(1);
            return false;
        }
        if (!readTestFile.canRead()){
            NandError nandError = new NandError();
            nandError.alertUser();
            nandError.diagnoseError(2);
            return false;

        }
        writeTestFile.delete();
        return true;
    }

    /**
     * Check if memory can be read and written to;
     * @return (Boolean) ram RW status
     */
    public boolean checkRAM(){
        try {
            Process RamTestProcess = Runtime.getRuntime().exec("./ram_test"); //c executable checking validity of memory
            int out = RamTestProcess.waitFor();
            return (out == 0 && Runtime.getRuntime().totalMemory() > 0 && Runtime.getRuntime().freeMemory() > 0);
        } catch (Exception e) { //TODO remove generic exception
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Checks registers and logic gates on the CPU
     * @return (boolean) CPU register and logic gates are valid
     */
    public boolean checkCPU(){
        //Check logic gates
        int x = 5+5;
        try {
            Process cpuRegisterTest = Runtime.getRuntime().exec("./cpu_register_test");
            int output = cpuRegisterTest.waitFor();
            return (output == 5 && x == 10 && Runtime.getRuntime().availableProcessors() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean checkGPU(){
        //if exists
        //TODO validate GPU
        return true;
    }
    public boolean checkMotherboard(){
        //TODO Find out if this can be generalized past checking if device boots with arbitrary hardwar
    }

}
