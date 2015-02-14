package piechart;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {

	public static void main(String[] args) {

		Select ventana = new Select();
		File file = ventana.getArchivo();
        
		Recorrer recorrer = new Recorrer();
		HashMap<String, Double> extensions = recorrer.recorregutPreordre(file);
		
		Piechart piechart = new Piechart();
		piechart.PieChart(extensions);
	}

}
