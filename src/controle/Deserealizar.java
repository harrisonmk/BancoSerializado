package controle;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserealizar {

    public Object deserializar(String path) throws Exception {
    FileInputStream inFile = new FileInputStream(path);
    ObjectInputStream d = new ObjectInputStream(inFile);
    Object o = d.readObject();
    d.close();
    return o;
    } 




}
