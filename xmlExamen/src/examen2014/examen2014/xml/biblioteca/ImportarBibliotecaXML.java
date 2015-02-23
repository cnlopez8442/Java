package examen2014.examen2014.xml.biblioteca;

import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Montse
 */
public class ImportarBibliotecaXML {

    public static void main(String[] args) {
        XStream xs = new XStream();
        Biblioteca b;

        xs.alias("llibre", Llibre.class);
        xs.alias("biblioteca", Biblioteca.class);

        xs.addImplicitCollection(Biblioteca.class, "llibres");
        xs.addImplicitCollection(Llibre.class, "autors");

        xs.alias("autor", String.class);

        try {
            b = (Biblioteca) xs.fromXML(new FileInputStream("d:biblioteca.xml"));
            System.out.println(b);

        } catch (FileNotFoundException e) {
            System.out.println("Fitxer no trobat;");
        }

    }
}
