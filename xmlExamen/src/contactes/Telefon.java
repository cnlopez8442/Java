
package contactes;


public class Telefon {
    private int prefix;
    private int numero;
    
    public Telefon(int pre, int tel){
        prefix=pre;
        numero=tel;
    }
    
    @Override
    public String toString(){
        return prefix+"-"+numero;
    }
}
