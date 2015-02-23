package m3.uf5.xml;

import com.thoughtworks.xstream.XStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Montse
 */
public class Ex1 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        File fitxer = new File("d:\\personesJava.dat");
        FileInputStream fi = new FileInputStream(fitxer);
        ObjectInputStream data = new ObjectInputStream(fi);

        LlistaPersones lp = new LlistaPersones();

        try {
            while (true) {
                Persona p = (Persona) data.readObject();
                lp.afegir(p);
            }
        } catch (EOFException e) {
        }
        data.close();
        //lp conté les persones llegides del fitxer

        try {
            XStream xs = new XStream();
            xs.alias("LlistaPersonesCiutat", LlistaPersones.class);
            xs.alias("DadesPersona", Persona.class);
           xs.addImplicitCollection(LlistaPersones.class, "llista");
            
            xs.toXML(lp, new FileOutputStream("d:\\personesXML.xml"));
            System.out.println("creant xml...");
        } catch (Exception e) {
        }
    }
}
