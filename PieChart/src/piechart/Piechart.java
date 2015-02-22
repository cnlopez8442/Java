package piechart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class Piechart extends JFrame{
	 private static HashMap<String, Double> mapa;
	    private static long unitat;
	    private static int max = 0;
	
	public DefaultPieDataset modificar() {
        /* Unitats: 0 -> bytes / 1 -> kbytes / 2 -> mbytes*/
        if (unitat == 1) {
            unitat = 1024;
        } else if (unitat == 2) {
            unitat = 1048576;
        } else {
            unitat = 1;
        }

        /* Es defineix un nou modificador de dades i l'omplim segons les prefencies d'unitats i maxim 
         d'extencions. I també suma les extensons que són iguals
         */
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        if (max == 0) {
            for (String s : mapa.keySet()) {
                pieDataset.setValue(s, mapa.get(s) / unitat);
            }
        } else {
            int contador = 0;
            double suma = 0;
            for (String s : mapa.keySet()) {
                if (contador < max) {
                    pieDataset.setValue(s, mapa.get(s) / unitat);
                    contador++;
                } else {
                    suma = suma + mapa.get(s);
                }
            }
            if (suma > 0) {
                pieDataset.setValue("altres", suma / unitat);
            }
        }

        return pieDataset;
    }

//	private JButton[] b = new JButton[3];
	
	public void PieChart(HashMap<String, Double> mapa) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (String s : mapa.keySet()) {
            pieDataset.setValue(s, mapa.get(s));
        }

        final JFreeChart chart = ChartFactory.createPieChart3D("Michal Sobocinski Extensions", pieDataset, true, true, true);
        final PiePlot3D p = (PiePlot3D) chart.getPlot();
        p.setForegroundAlpha(0.5f);
        ChartFrame frame1 = new ChartFrame("Michal Sobocinski Grafic Extensions", chart);
//        frame1.setVisible(true);
//        frame1.setSize(300, 300);
        ChartPanel panel = new ChartPanel(chart);
        
        frame1.setLayout(null);
        frame1.setSize(400, 450);
        frame1.setVisible(true);
        
        JMenuBar mb = new JMenuBar();
        frame1.setLayout(new BorderLayout());
        frame1.add(mb, BorderLayout.SOUTH);
        mb.setVisible(true);

        mb.setBounds(8, 4, 500, 540);
        /* Crear el menu amb els seus submenus*/
        JMenu menu = new JMenu("Unitats");
        mb.add(menu);

        JMenuItem tamany1 = new JMenuItem("bytes");
        JMenuItem tamany2 = new JMenuItem("kbytes");
        JMenuItem tamany3 = new JMenuItem("mbytes");
        menu.add(tamany1);
        menu.add(tamany2);
        menu.add(tamany3);
        JMenu menu1 = new JMenu("Extensions");
        mb.add(menu1);
        JMenuItem extensions1 = new JMenuItem("5");
        JMenuItem extensions2 = new JMenuItem("10");
        JMenuItem extensions3 = new JMenuItem("Totes");
        menu1.add(extensions1);
        menu1.add(extensions2);
        menu1.add(extensions3);
        JMenu menu3 = new JMenu("Nova carpeta");
        mb.add(menu3);
        JMenuItem carpeta = new JMenuItem("Seleccionar nova carpeta");
        menu3.add(carpeta);
        /* Definir les accions dels botons dels submenus*/
        /* Veure tamanys en bytes, kbytes i mbytes*/
        tamany1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                unitat = 0;
                DefaultPieDataset pieDataset = modificar();
                p.setDataset(pieDataset);
                chart.setTitle("Extensions en bytes");
            }
        });

        tamany2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                unitat = 1;
                DefaultPieDataset pieDataset = modificar();
                p.setDataset(pieDataset);
                chart.setTitle("Extensions en kbytes");
            }
        });

        tamany3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                unitat = 2;
                DefaultPieDataset pieDataset = modificar();
                p.setDataset(pieDataset);
                chart.setTitle("Extensions en mbytes");
            }
        });

        /* Limitar a 5, 10 o totes les extensions*/
        extensions1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                max = 5;
                DefaultPieDataset pieDataset = modificar();
                p.setDataset(pieDataset);

            }
        });

        extensions2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                max = 10;
                DefaultPieDataset pieDataset = modificar();
                p.setDataset(pieDataset);
            }
        });

        extensions3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                max = 0;
                DefaultPieDataset pieDataset = modificar();
                p.setDataset(pieDataset);
            }
        });
        /* Seleccionar nova carpeta.*/
        carpeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	Select select = new Select();
                File fitxer = select.getArchivo();
//                mapa = new HashMap<>();
                Recorrer r = new Recorrer();            
                HashMap<String, Double>  mapa=r.recorregutPreordre(fitxer);
                DefaultPieDataset peuDataset = modificar();
                p.setDataset(peuDataset);
                chart.setTitle("Extensions en bytes");
            }
        });
        
        //        JFrame frame = new JFrame("Michal Sobocinski Grafic Extensions");
//        JButton[] b = new JButton[3];
//        b[0] = new JButton("Select");
//        b[1] = new JButton("X+");
//        b[2] = new JButton("Y+");
//        frame.setLayout(new GridLayout(1, 3));
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(panel);
//        
//         //grid layout per a taules
//        for (int i = 0; i < 3; i++) {
//            frame.add(b[i]);
//            b[i].addActionListener(this); //per controlar els events sobre el boto
//            //s'ha d'implementar l'escolta dels events
//        }
//        frame.setPreferredSize(new Dimension(640,480));
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//        for (int i = 0; i < 3; i++) {
//        		System.out.println("source: "+e.getSource());
//        		System.out.println("przycisk: "+b[0]);
//            if (e.getSource() == b[i]) {
//				switch (i) {
//                    case 0:
//	                    	 Select ventana = new Select();
//	                		 File file = ventana.getArchivo();
//                        break;
//                    case 1:
//                    		System.out.println("hola");
//                        break;
//                    case 2:
//                    		System.out.println("hola");
//                        break;
//                }
//            }
//        }
//	}
}
