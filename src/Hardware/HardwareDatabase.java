package Hardware;

import java.util.Vector;

/**
 * Created by matthewelbing on 3/24/16.
 */
public class HardwareDatabase {
    //Dies machen nicht zu sein ein Vector<Object>.  Dies können sein etwas ob es ist mehr logisch.  Für Beispeil
    //ein Cpu objeckt ist benutzt stattdessen von Vector<Object> unten.
    public Cpu CPU;
    private Vector<Object> Gpu;
    private Vector<Object> Memory;
    private Vector<Object> Storage;
    private Vector<Object> board;
    //TODO autogenerate table references so that casting can be correctly implemented

}
