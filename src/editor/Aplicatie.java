package editor;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import functie.Calcul;
import parser.CitireDate;
import parser.ScriereFisier;


public class Aplicatie {

	    public static void main(String[] args)
	    {
	        Logger logger = Logger.getLogger(DiagramaKV.class.getName());
	        Supplier<String> StrSupplier= () -> new String("S-a accesat DiagramaKV cu succes!");
	        DiagramaKV kv =  new DiagramaKV();
	        kv.getTerm("Maxtermen").functie_calcul();
	        
	        try {
				kv.read_json();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	ScriereFisier scriere = new ScriereFisier();
	    	scriere.scriere_fisier();

	    	 logger.log(Level.INFO,
	                   StrSupplier);

	    }


}
