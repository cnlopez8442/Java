package contactes;

import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/** Classe que crea un objecte de la classe Agenda i el converteix a un
 *  fitxer .xml a través de la classe XStream i el seu mètode toXML().
 *  La classe Agenda, conté una llista de contactes i cada contacte una
 *  llista de telèfons.
 * 
 *  @see contactes.Agenda
 *  @see contactes.Contacte
 *  @see contactes.Telefon
 * 
 * @author Montse
 * @version febrer 2014
 */
public class Ex1_ExportarAgendaXML {

    public static void main(String[] args) {
        //crear contacte 1
        Contacte c1 = new Contacte("Josep Gomis", "C/Ponts, 45");
        c1.afegirTelefon(new Telefon(34, 933526767));
        c1.afegirTelefon(new Telefon(34, 677123123));

        //crear contacte 2
        Contacte c2 = new Contacte("Joan Cucurulla", "Avda. Diagonal, 230");
        c2.afegirTelefon(new Telefon(45, 123456));
        c2.afegirTelefon(new Telefon(45, 666111222));

        //crear agenda
        Agenda ag = new Agenda(2013);
        ag.afegirContacte(c1);
        ag.afegirContacte(c2);

        //Utilització de la classe XSTream per passar a xml
        XStream xs = new XStream();
 
        xs.alias("agenda", Agenda.class);
        xs.addImplicitCollection(Agenda.class, "agenda");
        
        xs.addImplicitCollection(Contacte.class, "telefons");
        
        xs.alias("contacte", Contacte.class);
        xs.alias("telefon", Telefon.class);
        
     //   System.out.println(xs.toXML(ag));
        try {
            xs.toXML(ag, new FileOutputStream("d:\\ContactesXML.xml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Fitxer no trobat");
        }

    }
}
