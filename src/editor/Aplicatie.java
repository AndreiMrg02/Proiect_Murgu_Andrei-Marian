package editor;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import functie.Calcul;

public class Aplicatie {

	    public static void main(String[] args)
	    {
	   
	        DiagramaKV kv =  new DiagramaKV();
	        
	        try {
				kv.read_json();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//		    	ScriereFisier scriere = new ScriereFisier();
//		    	scriere.scriere_fisier();

	    }


}
