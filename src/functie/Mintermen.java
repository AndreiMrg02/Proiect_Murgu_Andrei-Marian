package functie;

import java.util.LinkedHashMap;
import java.util.Vector;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

public class Mintermen implements Calcul {
	
	private Vector<Integer> functie_mintermen =  new Vector<Integer>();
	private Vector<Integer> value =  new Vector<Integer>();
	Vector<String> sir_biti =  new Vector<String>();
	LinkedHashMap<String,Integer> map =  new LinkedHashMap<String,Integer>();
	String auxiliar_sir_biti =  new String();



	public static Mintermen getInstance() {
		final Logger logger = Logger.getLogger(Mintermen.class);
		PropertyConfigurator.configure("log4j.properties");
	      if(Object == null) {
	    	logger.info("S-a accesat instanta Singleton din MINTERMEN");
	    	  Object = new Mintermen();
	      }
	       return Object;
	   }
    
	public Mintermen()
	{
		super();
	}
	
	public LinkedHashMap<String, Integer> getMap() {
		return map;
	}

	public void setMap(LinkedHashMap<String, Integer> map) {
		this.map = map;
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
	 	for (String i : map.keySet()) 
	 	{
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
	
	public Iterator getIterator() {
		return new Iterator_mintermen();
		}
	private class Iterator_mintermen implements Iterator
	{
		boolean verificare;
	int index;

    @Override
    public boolean hasNext() {
    
       if(index < map.size())
       {
          return true;
       }
       return false;
    }

    @Override
    public Object next() {
    	verificare = false;
    	while(this.hasNext() && verificare == false)
    	{
    		if(value.get(index) == 1)
    		{
    			verificare = true;
    		}
    		else
    		{
    			verificare = false;
    			index++;
    		}
    	}
       if(this.hasNext())
       {
    	   return sir_biti.get(index++);
       }
       return null;
    	}		
	}
}

