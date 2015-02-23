package m3.uf5.xml;

import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;

/**
 * Llegirem d'un fitxer xml i passarem les dades al POJO que li correspon
 *
 * @author Montse
 */
public class Ex3 {

    public static void main(String[] args) {
        XStream xs = new XStream();

        xs.alias("LlistaPersonesCiutat", LlistaPersones.class);
        xs.alias("DadesPersona", Persona.class);
        xs.addImplicitCollection(LlistaPersones.class, "llista");
        
        LlistaPersones lp = null;
        try {
            lp = (LlistaPersones) xs.fromXML(new FileInputStream("d:\\personesXML.xml"));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(lp.getLlista());

    }
}
