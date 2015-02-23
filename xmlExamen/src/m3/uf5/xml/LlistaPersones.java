
package m3.uf5.xml;

import java.util.ArrayList;


public class LlistaPersones {
    private ArrayList<Persona> llista=new ArrayList<Persona>();
    public LlistaPersones(){
        
    }
    public void afegir(Persona p){
        llista.add(p);
    }
    
    public ArrayList<Persona> getLlista(){
        return llista;
    }
    
}
