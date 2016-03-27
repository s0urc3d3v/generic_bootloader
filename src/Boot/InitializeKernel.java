package Boot;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class InitializeKernel {
    public void startKernelAndDependencies(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("kernelData"));]
            while (true) {
                String line = reader.readLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ':' && line.substring(0, i - 1).equals("service_path")) {
                        Runtime.getRuntime().exec("./" + line.substring(i + 1));
                    } else if (line.charAt(i) == ':' && line.substring(0, i - 1).equals("service_path")){
                        for (int j = 0; j < line.substring(i + 1).length(); j++) {
                            if (line.charAt(j) == ','){
                                for (int k = 0; k < line.substring(j + 1).length(); k++) {
                                    if (line.charAt(j) == ','){
                                        Runtime.getRuntime().exec("./" + line.substring(j,k));
                                    }
                                }
                            }
                        }
                    }
                    else break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
