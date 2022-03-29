package editor;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import parser.CitireDate;
import parser.ScriereFisier;


public class Aplicatie {

	    public static void main(String[] args)
	    {
	        Logger logger = Logger.getLogger(DiagramaKV.class.getName());
	        Supplier<String> StrSupplier= () -> new String("S-a accesat DiagramaKV cu succes!");



	    	ScriereFisier scriere = new ScriereFisier();
	    	scriere.scriere_fisier();

	    	CitireDate citire_date =  new CitireDate();
	    	try {
				citire_date.read_json();
			}catch (IOException e) {

				e.printStackTrace();
			}

	    	 logger.log(Level.INFO,
	                   StrSupplier);

	    }


}
