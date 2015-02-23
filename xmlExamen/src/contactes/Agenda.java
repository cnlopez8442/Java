
package contactes;

import java.util.ArrayList;


public class Agenda {
    private int any;
    private ArrayList<Contacte> agenda=new ArrayList<Contacte>();
    public Agenda(int a){
        any=a;     
    }
    
    public void afegirContacte(Contacte c){
        agenda.add(c);
    }
    
    @Override
    public String toString(){
        String contactes="";
        for(Contacte c:agenda){
            contactes+=c+"\n";
        }
        return any+"\n"+contactes;
    }
}
