package extensions;

import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Primer exemple per veure com mostrar en un gràfic de sectors el contingut
 * d'un mapa. En aquest cas guardem els noms de les extensions i la longitud
 * dels fitxers. Perquè funcioni el gràfic, s'ha d'importar al projecte les
 * llibreries externes jfreechar-1.0.14.jar i jcommon-1.0.17.jar
 * @gener 2014
 * @author Montse
 */
public class Exemple1 {

    public static void main(String[] args) {

        //Creem un mapa i l'omplim de valors 
        HashMap<String, Long> mapa = new HashMap<String, Long>();
        //En aquest exemple, la longitud dels fitxers està en Kb
        mapa.put("BMP", 1290L);
        mapa.put("JPG", 1430L);
        mapa.put("DOC", 250L);
        mapa.put("DOCX", 5600L);
        mapa.put("GIF", 300L);
        mapa.put("XSL",560L);
        mapa.put("XML",4000L);
        mapa.put("TXT",455L);

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (String s : mapa.keySet()) {
            pieDataset.setValue(s, mapa.get(s));
        }

        JFreeChart chart = ChartFactory.createPieChart3D("Exemple 1Extensions", pieDataset, true, true, true);
        PiePlot3D p = (PiePlot3D) chart.getPlot();
        p.setForegroundAlpha(0.5f);
        ChartFrame frame1 = new ChartFrame("Grafic Extensions", chart);
        frame1.setVisible(true);
        frame1.setSize(300, 300);

    }
}
