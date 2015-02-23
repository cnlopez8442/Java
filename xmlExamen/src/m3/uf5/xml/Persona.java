
package m3.uf5.xml;

import java.io.Serializable;


public class Persona implements Serializable{
    private String nom;
    private int edat;
    
    public Persona(){}

    public Persona(String n, int e){
        nom=n;
        edat=e;
    }
    
    public String toString(){
        return nom + " "+edat;
    }

   
    public String getNom() {
        return nom;
    }

    
    public int getEdat() {
        return edat;
    }
}
