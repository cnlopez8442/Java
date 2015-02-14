package piechart;

import java.util.HashMap;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class Piechart {
	public void PieChart(HashMap<String, Double> mapa) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (String s : mapa.keySet()) {
            pieDataset.setValue(s, mapa.get(s));
        }

        JFreeChart chart = ChartFactory.createPieChart3D("Michal Sobocinski Extensions", pieDataset, true, true, true);
        PiePlot3D p = (PiePlot3D) chart.getPlot();
        p.setForegroundAlpha(0.5f);
        ChartFrame frame1 = new ChartFrame("Michal Sobocinski Grafic Extensions", chart);
//        frame1.setVisible(true);
//        frame1.setSize(300, 300);
        ChartPanel panel = new ChartPanel(chart);
        JFrame frame = new JFrame("Michal Sobocinski Grafic Extensions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
