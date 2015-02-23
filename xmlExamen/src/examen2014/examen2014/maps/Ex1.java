package examen2014.examen2014.maps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


/**
 *
 * @author Montse
 */
public class Ex1 {

    private HashMap<String, HashSet> mapa = new HashMap();

    
    public static File getFile(){
        File fitxer=null;
        //per agafar el look and feel del sistema operatiu nadiu
        String nativeLF = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(nativeLF);
        } catch (Exception e) {
        }

        JFileChooser selector = new JFileChooser();
      //  selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int ok = selector.showOpenDialog(null);
        /* showOpenDialog pot retornar tres valors
         * JFileChooser.CANCEL_OPTION
         * JFileChooser.APPROVE_OPTION
         * JFileCHooser.ERROR_OPTION 
         */
        if (ok != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Adéu");
        } else {
            fitxer = selector.getSelectedFile();
            System.out.println("El nom del directori seleccionat es");
            System.out.println(fitxer);

        }
        return fitxer;
    }
    public void omplirMapa() {
        HashSet<String> sinonims;
        try {
            //la funció nextLine() falla si el text conté accents
            //i només llegim amb Scanner i File, és necessita un FileInputStream
            File fitxer=getFile();
          //  Scanner entrada = new Scanner(new FileInputStream("d:\\sinonims.txt"), "UTF-8");
             Scanner entrada = new Scanner(fitxer);
            while (entrada.hasNextLine()) {
                sinonims = new HashSet();
                String linia = entrada.nextLine();
                //el format del fitxer es 
                //paraula: sinonim1 sinonim2 sinonim3 etc
                String[] paraula = linia.split(": ");
                String[] paraules = paraula[1].split(" ");
                for (int i = 0; i < paraules.length; i++) {
                 //   System.out.println(paraules[i]);
                    sinonims.add(paraules[i]);
                }
                mapa.put(paraula[0], sinonims);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Fitxer no trobat");
        }
    }

    public void buscarSinonims() {
        
        Scanner teclat = new Scanner(System.in);
        System.out.println("Paraula a buscar el sinònim?");
        String busca = teclat.next();
        HashSet t=mapa.get(busca);
        if(t!=null){ System.out.println("Els sinònims de "+busca+" són "+t);
        }
        else {
            System.out.println("No tenim aquesta paraula al diccionari");
        }
    }

    public void buscarParaules() {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Paraula a buscar de qui és sinònim?");
        String busca = teclat.next();
        ArrayList<String> llista = new ArrayList();
        for (String paraula : mapa.keySet()) {
            //per cada clau, obtenir els values = sinonims
            HashSet t = mapa.get(paraula);
            if (t.contains(busca)) {
               // System.out.println("contains");
                llista.add(paraula);
            }
        }
        System.out.println(busca + " forma part dels sinònims de: " + llista);
    }

    public static void main(String[] args) {
        Ex1 ex = new Ex1();
        ex.omplirMapa();
        ex.buscarSinonims();
        ex.buscarParaules();
    }
}
