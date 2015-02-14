package piechart;

import java.io.File;

public class main {

	public static void main(String[] args) {

		Select ventana = new Select();
		File file = ventana.getArchivo();
		
		Recorrer recorrer = new Recorrer();
		recorrer.recorregutPreordre(file);
	}

}
