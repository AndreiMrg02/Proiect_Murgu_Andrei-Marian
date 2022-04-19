package functie;


import java.util.LinkedHashMap;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Maxtermen implements Calcul {

	

	private Vector<Integer> functie_maxtermen =  new Vector<Integer>();
	private Vector<Integer> value =  new Vector<Integer>();
    private static Maxtermen Object;
    Vector<String> sir_biti =  new Vector<String>();
    LinkedHashMap<String,Integer> map =  new LinkedHashMap<String,Integer>();   
	String auxiliar_sir_biti =  new String();
	
	public static Maxtermen getInstance() {

		final Logger logger = Logger.getLogger(Maxtermen.class);
		PropertyConfigurator.configure("log4j.properties");
	      if(Object == null) {
	    	logger.info("S-a accesat instanta Singleton din Maxtermen");
	    	  Object = new Maxtermen();
	      }
	       return Object;
	   }
    
	private Maxtermen()
	{
		super();
	}
	public void functie_calcul(int n_Bits) {
		for(int i = 0; i < Math.pow(2, n_Bits); i++)
		{
			value.add(i,1);	
		}
		for(int i = 0; i < Math.pow(2, n_Bits); i++)
		{

			for (Integer name : functie_maxtermen) {
				if( i ==  name )
				{
					value.set(i,0);
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
	public void functie_calcul_tastatura()
	{
		 
	}
	public Vector<Integer> getMaxtermen() {
		return functie_maxtermen;
	}
	public void setMaxtermen(Vector<Integer> maxtermen) {
		this.functie_maxtermen = maxtermen;
	}
	public Vector<Integer> getValue() {
		return value;
	}
	public void setValue(Vector<Integer> value) {
		this.value = value;
	}
}