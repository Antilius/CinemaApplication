package Memory;

import java.io.File;
import java.util.ArrayList;

public interface ConnectWithMemory {
    
    public void saveInFile(ArrayList list, File file);
    public ArrayList readFromFile(File file);
}
