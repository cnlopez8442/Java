
package contactes;

import java.util.ArrayList;


public class Contacte {
    private String nom;
    private String adreça;
    private ArrayList<Telefon> telefons=new ArrayList<Telefon>();
   
    public Contacte(String n, String a){
        nom=n;
        adreça=a;
    }
    public void afegirTelefon(Telefon tel){
        telefons.add(tel);
    }
    
    @Override
    public String toString(){
        String txt=nom +"\n"+ adreça+"\n";
        for(Telefon t:telefons){
            txt+="TLF:"+t+"\n";
        }
        return txt;
        
    }
}
