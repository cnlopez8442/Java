package m3.uf5.xml;

import com.thoughtworks.xstream.XStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

/**
 *
 * @author Montse
 */
public class Ex2 {

    public static void main(String[] args) {

        File fitxer = new File("d:\\personesJava.dat");
        XStream xs = new XStream();

        try {
            FileInputStream fi = new FileInputStream(fitxer);
            ObjectInputStream data = new ObjectInputStream(fi);
            String xml = "";
             xs.alias("Persona", Persona.class);
            try {
                while (true) {
                    Persona p = (Persona) data.readObject();
                    xml += xs.toXML(p)+"\n";

                }
            } catch (EOFException e) {
            }
            data.close();
            System.out.println(xml);

            PrintWriter pr = new PrintWriter("d:\\personesXML2.xml");
            pr.print(xml);
            pr.close();

            System.out.println("creant xml...");
        } catch (Exception e) {
        }
    }
}
