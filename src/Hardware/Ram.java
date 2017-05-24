package Hardware;

/**
 * Created by matthewelbing on 24.05.17.
 */
public class Ram {
    private long RamGroese;

    public Ram(){
        RamGroese = Runtime.getRuntime().freeMemory();
    }

    public long getRamGroese() {
        return RamGroese;
    }
}

