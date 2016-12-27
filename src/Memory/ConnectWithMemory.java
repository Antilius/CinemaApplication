/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memory;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Hubert
 */
public interface ConnectWithMemory {
    
    public void saveInFile(ArrayList list);
    public ArrayList readFromFile(File file);
}
