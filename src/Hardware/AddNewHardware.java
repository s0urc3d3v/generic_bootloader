package Hardware;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class AddNewHardware {
    private static LinkedHashMap<Integer, String> hardwareMap = new LinkedHashMap<>();

    /**
     * Adds a new hardware device to the memory hardware database
     * @param type (int) hardware type
     * @param hardwareName (String) Name of hardware
     */
    public static void addHardwareDevice(int type, String hardwareName){
        hardwareMap.put(type, hardwareName);
    }

    /**
     * Writes the memory hardware database to the hardware database file
     */
    public static void writeHardwareDatabase(){
        for (int i = 0; i < hardwareMap.size(); i++) {
            String hardware = "";
            switch ((int) hardwareMap.keySet().toArray()[i]){
                case (0):
                    hardware = "cpu";
                    break;
                case (1):
                    hardware = "gpu";
                    break;
                case (2):
                    hardware = "memory";
                    break;
                case (3):
                    hardware = "storage";
                    break;
                case (4):
                    hardware = "motherboard";
                    break;
                case (5):
                    hardware = "other";
                     break;
            }
            try {
                Files.write(Paths.get("hardware"), (hardware + ":" + hardwareMap.get(i) + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Updates the memory map of hardware from the hardware database file
     */
    public static void readHardwareDatabase(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("hardware"));
            String line = reader.readLine();
            if (line != null){
                for (int i = 0; i < line.length(); i++){
                    if (line.charAt(i) == ':'){
                        switch (line.substring(0, i - 1)){
                            case ("cpu"):
                                hardwareMap.put(0, line.substring(i + 1));
                                break;
                            case ("gpu"):
                                hardwareMap.put(1, line.substring(i + 1));
                                break;
                            case ("memory"):
                                hardwareMap.put(2, line.substring(i + 1));
                                break;
                            case ("storage"):
                                hardwareMap.put(3, line.substring(i + 1));
                                break;
                            case ("motherboard"):
                                hardwareMap.put(4, line.substring(i + 1));
                                break;
                            case ("other"):
                                hardwareMap.put(5, line.substring(i + 1));
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
