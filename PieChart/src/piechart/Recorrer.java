package piechart;

import java.io.File;

public class Recorrer {
	
    public void recorregutPreordre(File fitxer) {
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

}
