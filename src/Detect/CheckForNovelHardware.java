package Detect;

import java.io.*;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class CheckForNovelHardware { //Dies ist nicht fertig.  Dies ist macht für später Zeit.
    //Dies ist für die GPU starten
    public boolean isGpuPresent(String GPU_id) {
        return GPU_id != null;
    }
    public String getGpuInfo() {
        String card_id = "";
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("lspci", "-vnn", "|", "grep", "-A", "12");
            Process procDxId = processBuilder.start();
            procDxId.waitFor();

            InputStream is = procDxId.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String GPU_dxdiag_info = "";
            String GPU_dxdiag_info_i;
            while ((GPU_dxdiag_info_i = bufferedReader.readLine()) != null){
                GPU_dxdiag_info = GPU_dxdiag_info_i;
            }
            for (int i = 0; i < GPU_dxdiag_info.length(); i++) {
                if (GPU_dxdiag_info.substring(i, i + 9).equals("Card name")) {
                    card_id = GPU_dxdiag_info.substring(i, i + 9);
                }
            }
            return card_id;

        } catch (Exception e) { //Trahen alles fahler nicht verlassen, nicht fertig
            e.printStackTrace();
        }
        return card_id;
    }

    //Dies ist für die CPU starten
    public boolean isCpuPresent(String CPU_id){
        return (getCpuInfo() != null  && getCpuInfo().equals(""));
    }

    public String getCpuInfo(){
        String cpu_data = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/proc/cpuinfo"));

            String line = "";
            while (true){
                line = reader.readLine();
                if (line != null) cpu_data += line;
                else break;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cpu_data;
    }

}
