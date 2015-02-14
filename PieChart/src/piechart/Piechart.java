package piechart;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class Piechart extends JFrame implements ActionListener{
	private JButton[] b = new JButton[3];
	
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
        JButton[] b = new JButton[3];
        b[0] = new JButton("Select");
        b[1] = new JButton("X+");
        b[2] = new JButton("Y+");
        frame.setLayout(new GridLayout(1, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
         //grid layout per a taules
        for (int i = 0; i < 3; i++) {
            frame.add(b[i]);
            b[i].addActionListener(this); //per controlar els events sobre el boto
            //s'ha d'implementar l'escolta dels events
        }
        frame.setPreferredSize(new Dimension(640,480));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        for (int i = 0; i < 3; i++) {
        		System.out.println("source: "+e.getSource());
        		System.out.println("przycisk: "+b[0]);
            if (e.getSource() == b[i]) {
				switch (i) {
                    case 0:
	                    	 Select ventana = new Select();
	                		 File file = ventana.getArchivo();
                        break;
                    case 1:
                    		System.out.println("hola");
                        break;
                    case 2:
                    		System.out.println("hola");
                        break;
                }
            }
        }
	}
}
