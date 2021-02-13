
package menuserializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream  extends ObjectOutputStream{

    protected void writeStreamHeader() throws IOException{
        // no escribe en la cabecera
    }
    
    public MiObjectOutputStream() throws IOException {
        super();
    }

    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
}
