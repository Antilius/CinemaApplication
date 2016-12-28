package Memory;

import java.io.File;
import java.util.ArrayList;

public interface ConnectWithMemory {
    
    public void saveInFile(ArrayList list);
    public ArrayList readFromFile(File file);
}
