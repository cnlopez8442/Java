package examen2014.examen2014.xml.biblioteca;

import java.util.TreeSet;

/**
 *
 * @author Montse
 */
public class Llibre implements Comparable{
    private String titol;
    private TreeSet<String> autors=new TreeSet();
    private int any;
    
    @Override
    public String toString(){
        return titol+" "+autors+" "+any;
    }
    
    
    @Override
    public int compareTo(Object o){
        Llibre l=(Llibre)o;
        return any-l.any;
    }
}

