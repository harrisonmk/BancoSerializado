package controle;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serelizalizar {

    public  void serializar(String path, Object obj) throws Exception {
        FileOutputStream outFile = new FileOutputStream(path);
        try (ObjectOutputStream s = new ObjectOutputStream(outFile)) {
            s.writeObject(obj);
        }

    }

}
