package tierramedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintItinerarios {

	public static void main(String[] args)	throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter("TMFiles/itinerarios.txt"));
	     
	    salida.println(); //hay que decir que quiero que imprima
	
		salida.close(); 

	}

}
