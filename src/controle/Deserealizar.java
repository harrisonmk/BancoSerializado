package controle;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserealizar {

    public  Object deserializar(String path) throws Exception {
    FileInputStream inFile = new FileInputStream(path);
    Object o;
        try (ObjectInputStream d = new ObjectInputStream(inFile)) {
            o = d.readObject();
        }
    return o;
    } 




}
