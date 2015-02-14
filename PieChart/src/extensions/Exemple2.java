package extensions;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Exemple 2 per veure com escollir un fitxer del sistema operatiu amb una
 * interfície gràfica
 *
 * @author Montse
 * @version gener 2014
 */
public class Exemple2 {

    public static void main(String[] args) {

        //per agafar el look and feel del sistema operatiu nadiu
        String nativeLF = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(nativeLF);
        } catch (Exception e) {
        }

        JFileChooser selector = new JFileChooser();
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int ok = selector.showOpenDialog(null);
        /* showOpenDialog pot retornar tres valors
         * JFileChooser.CANCEL_OPTION
         * JFileChooser.APPROVE_OPTION
         * JFileCHooser.ERROR_OPTION 
         */
        if (ok != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Adéu");
        } else {
            File fitxer = selector.getSelectedFile();
            System.out.println("El nom del directori seleccionat es");
            System.out.println(fitxer);

        }
    }

}
