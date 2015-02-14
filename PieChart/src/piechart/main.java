package piechart;

import java.io.File;
import java.util.HashMap;

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
