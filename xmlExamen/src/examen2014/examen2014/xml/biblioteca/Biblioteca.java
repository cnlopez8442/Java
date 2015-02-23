package examen2014.examen2014.xml.biblioteca;

import java.util.TreeSet;

/**
 *
 * @author Montse
 */
public class Biblioteca{
    private String adresa;
    private TreeSet <Llibre> llibres=new TreeSet();
    
    @Override
    public String toString(){
        String txt=adresa+"\n";
        for(Llibre l: llibres){
        txt+=l+"\n";
        }
        return txt;
    }

    
}
