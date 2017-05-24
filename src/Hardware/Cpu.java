package Hardware;

/**
 * Created by matthewelbing on 10.11.16.
 */
public class Cpu {
    private String proccessorName;
    private String proccesorArch;
    private int coreEnumeration;

    public Cpu() {
        this.proccessorName = System.getenv("PROCESSOR_IDENTIFIER");
        this.proccesorArch = System.getenv("PROCESSOR_ARCHITECTURE");
        this.coreEnumeration = Integer.parseInt(System.getenv("NUMBER_OF_PROCESSORS"));
    }

    @Override
    public String toString() { //Für debugging
        return "Cpu{" +
                "proccessorName='" + proccessorName + '\'' +
                ", proccesorArch='" + proccesorArch + '\'' +
                ", coreEnumeration=" + coreEnumeration +
                '}';
    }

    public String getProccessorName() {
        return proccessorName;
    }

    public String getProccesorArch() {
        return proccesorArch;
    }

    public int getCoreEnumeration() {
        return coreEnumeration;
    }
}
