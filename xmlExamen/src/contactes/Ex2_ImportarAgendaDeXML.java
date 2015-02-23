package contactes;

import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex2_ImportarAgendaDeXML {

    public static void main(String[] args) {
        try {
            FileInputStream fi = new FileInputStream("d:ContactesXML.xml");
            XStream xs = new XStream();
            xs.alias("agenda", Agenda.class);
            xs.addImplicitCollection(Agenda.class, "agenda");
            
            xs.addImplicitCollection(Contacte.class, "telefons");
            
            xs.alias("contacte", Contacte.class);
            xs.alias("telefon", Telefon.class);
            
            Agenda ag = (Agenda) xs.fromXML(fi);
            System.out.println(ag);
        } catch (FileNotFoundException ex) {
        }
    }
}
