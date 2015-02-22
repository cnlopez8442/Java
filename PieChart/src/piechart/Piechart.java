package piechart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

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

public class Piechart extends JFrame {
	private static TreeMap<String, Double> mapa = null;
	private static long unidad;
	private static int max = 0;

	public static TreeMap<String, Double> getMapa() {
		return mapa;
	}

	public static void setMapa(TreeMap<String, Double> mapa) {
		Piechart.mapa = mapa;
	}

	public static long getUnidad() {
		return unidad;
	}

	public static void setUnidad(long unidad) {
		Piechart.unidad = unidad;
	}

	public static int getMax() {
		return max;
	}

	public static void setMax(int max) {
		Piechart.max = max;
	}

	public DefaultPieDataset modificar(TreeMap<String, Double> mapa) {
		this.mapa = mapa;
		
		if (unidad == 1) {
			unidad = 1024;
		} else if (unidad == 2) {
			unidad = 1024 * 1024;
		} else {
			unidad = 1;
		}

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		if (max == 0) {
			for (String s : mapa.keySet()) {
				pieDataset.setValue(s, this.mapa.get(s) / unidad);
			}
		} else {
			int contador = mapa.size()-1;
			double suma = 0;
			for (String s : mapa.keySet()) {
				if (contador < max) {
					pieDataset.setValue(s, mapa.get(s) / unidad);
					
				} else {
					suma = suma + mapa.get(s);
					contador--;
				}
			}
			if (suma > 0) {
				pieDataset.setValue("OTROS", suma / unidad);
			}
		}

		return pieDataset;
	}


	public void PieChart(TreeMap<String, Double> mapa) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		if (this.mapa == null)
			this.mapa = mapa;
		else {
			mapa = getMapa();
		}
		for (String s : mapa.keySet()) {
			pieDataset.setValue(s, mapa.get(s));
		}

		final JFreeChart chart = ChartFactory.createPieChart3D(
				"Michal Sobocinski Extensions", pieDataset, true, true, true);
		final PiePlot3D p = (PiePlot3D) chart.getPlot();
		p.setForegroundAlpha(0.5f);
		ChartFrame frame1 = new ChartFrame(
				"Michal Sobocinski Grafic Extensions", chart);

		ChartPanel panel = new ChartPanel(chart);

		frame1.setLayout(null);
		frame1.setSize(400, 450);
		frame1.setVisible(true);

		JMenuBar mb = new JMenuBar();
		frame1.setLayout(new BorderLayout());
		frame1.add(mb, BorderLayout.SOUTH);
		mb.setVisible(true);

		mb.setBounds(8, 4, 500, 540);
		
		JMenu menu = new JMenu("Unidades");
		mb.add(menu);

		JMenuItem size1 = new JMenuItem("Bytes");
		JMenuItem size2 = new JMenuItem("KB");
		JMenuItem size3 = new JMenuItem("MB");
		menu.add(size1);
		menu.add(size2);
		menu.add(size3);
		JMenu menu1 = new JMenu("Extensiones");
		mb.add(menu1);
		JMenuItem extensiones1 = new JMenuItem("3");
		JMenuItem extensiones2 = new JMenuItem("Todos");
		menu1.add(extensiones1);
		menu1.add(extensiones2);
		JMenu menu3 = new JMenu("Nuevo directorio");
		mb.add(menu3);
		JMenuItem carpeta = new JMenuItem("Seleccionar nuevo directorio");
		menu3.add(carpeta);

		size1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				unidad = 0;
				setMapa(getMapa());
				DefaultPieDataset pieDataset = modificar(getMapa());
				p.setDataset(pieDataset);
				chart.setTitle("Extensiones en bytes");
			}
		});

		size2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				unidad = 1;
				setMapa(getMapa());
				DefaultPieDataset pieDataset = modificar(getMapa());
				p.setDataset(pieDataset);
				chart.setTitle("Extensiones en kbytes");
			}
		});

		size3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				unidad = 2;
				setMapa(getMapa());
				DefaultPieDataset pieDataset = modificar(getMapa());
				p.setDataset(pieDataset);
				chart.setTitle("Extensiones en mbytes");
			}
		});

		extensiones1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				max = 3;
				setMapa(getMapa());
				DefaultPieDataset pieDataset = modificar(getMapa());
				p.setDataset(pieDataset);

			}
		});

		extensiones2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				max = 0;
				setMapa(getMapa());
				DefaultPieDataset pieDataset = modificar(getMapa());
				p.setDataset(pieDataset);
			}
		});
		carpeta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Select select = new Select();
				File fitxer = select.getArchivo();
				Recorrer r = new Recorrer();
				TreeMap<String, Double> mapas = r.recorregutPreordre(fitxer);
				DefaultPieDataset peuDataset = modificar(mapas);
				setMapa(mapas);
				p.setDataset(peuDataset);
				chart.setTitle("Michal Sobocinski Grafic Extensions");
			}
		});

	}

}
