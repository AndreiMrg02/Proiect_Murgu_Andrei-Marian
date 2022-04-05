package functie;

import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import editor.TruthTable;

public class Mintermen implements Calcul {
	
	private Vector<Integer> functie_mintermen =  new Vector<Integer>();
	private Vector<Integer> value =  new Vector<Integer>();
	Vector<String> sir_biti =  new Vector<String>();
	LinkedHashMap<String,Integer> map =  new LinkedHashMap<String,Integer>();
	String auxiliar_sir_biti =  new String();
	
	public static Mintermen getInstance() {

    	Logger logger = Logger.getLogger(Mintermen.class.getName());
    	
   	    Supplier<String> StrSupplier= () -> new String("S-a accesat instanta Mintermen!");
	      if(Object == null) {
	    	  logger.log(Level.INFO,
	                   StrSupplier);
	    	  Object = new Mintermen();
	      }
	       return Object;
	   }
    
	private Mintermen()
	{
		super();
	}
	public void functie_calcul(int n_Bits) {
		for(int i = 0; i < Math.pow(2, n_Bits); i++)
		{
			value.add(i,0);	
		}
		for(int i = 0; i < Math.pow(2, n_Bits); i++)
		{

			for (Integer name : functie_mintermen) {
				if( i ==  name )
				{
					value.set(i,1);
				}		
			}
	
		}
		for (int i = 0 ; i != (1 << n_Bits)  ; i++) {
			
			auxiliar_sir_biti = Integer.toBinaryString(i);
		    while (auxiliar_sir_biti.length() != n_Bits) {
		    	auxiliar_sir_biti =  '0'+ auxiliar_sir_biti;
		    }
		    sir_biti.add(auxiliar_sir_biti);
	 	}

	 	
	 	for(int i = 0; i < Math.pow(2, n_Bits); i++)
		{
	 		map.put(sir_biti.get(i), value.get(i));	
		}
	 	 for (String i : map.keySet()) {
	 	      System.out.println( i + " " + map.get(i));
	 	    }
	 	
	
	}
	public Vector<Integer> getMintermen() {
		return functie_mintermen;
	}
	public void setMintermen(Vector<Integer> mintermen) {
		this.functie_mintermen = mintermen;
	}
	
	public Vector<String> makeTable(int n_Bits)
	{
	 	
		return sir_biti;
		
	}
	public Vector<String> getSir_biti() {
		return sir_biti;
	}
	public String getAuxiliar_sir_biti() {
		return auxiliar_sir_biti;
	}
	public void setAuxiliar_sir_biti(String auxiliar_sir_biti) {
		this.auxiliar_sir_biti = auxiliar_sir_biti;
	}
	public void setSir_biti(Vector<String> sir_biti) {
		this.sir_biti = sir_biti;
	}

    private static Mintermen Object;
	         
	public Vector<Integer> getValue() {
		return value;
	}
	public void setValue(Vector<Integer> value) {
		this.value = value;
	}

}