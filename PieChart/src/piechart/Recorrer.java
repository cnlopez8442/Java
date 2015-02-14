package piechart;

import java.io.File;
import java.util.HashMap;

public class Recorrer {
	
    public HashMap<String, Double> recorregutPreordre(File fitxer) {
    		HashMap<String, Double> extensions = new HashMap<String, Double>();
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
                    double bytes = f.length();
	        			double kilobytes = (bytes / 1024);
	        			double megabytes = (kilobytes / 1024);
	        			double gigabytes = (megabytes / 1024);
	        			double terabytes = (gigabytes / 1024);
	        			double petabytes = (terabytes / 1024);
	        			double exabytes = (petabytes / 1024);
	        			double zettabytes = (exabytes / 1024);
	        			double yottabytes = (zettabytes / 1024);
	        			
	        			if(extensions.containsKey(extensio)){
	        				extensions.put(extensio, extensions.get(extensio)+kilobytes);
	        			}else{
	        				extensions.put(extensio, kilobytes);
	        			}
                } /* no era directori*/
            } /* per cada fitxer*/

        }/*ja no queden fitxers*/
			return extensions;
    }

}
