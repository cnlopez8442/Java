package extensions;

import java.io.File;

/**
 * Exemple per fer un recorregut d'un directori en el sistema operatiu
 * Utilitzo una funcio recursiva
 * @author Montse
 */
public class Exemple3 {

    private static void recorregutPreordre(File fitxer) {
        if (fitxer != null) {
            File[] contingut = fitxer.listFiles();
            for (File f : contingut) {
                if (f.isDirectory()) {
                    /* recorregut recursiu en preordre*/
                    recorregutPreordre(f);
                } else {
                    String nom = f.getName();
                    int posPunt = nom.lastIndexOf(".");
                    //Ojo, no funciona per fitxers que no tinguin extensió
                    //Cal revisar-ho
                    String extensio = nom.substring(posPunt + 1, nom.length()).toUpperCase();
                    System.out.println("Nom: " + nom + " extensio: " + extensio);
                } /* no era directori*/
            } /* per cada fitxer*/

        }/*ja no queden fitxers*/
    }

    public static void main(String[] args) {
        //exemple qualsevol, depen de cada maquina i s.o.
        recorregutPreordre(new File("C:\\Users\\Montse\\Documents\\m3.uf1"));
    }
}
