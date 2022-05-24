package functie;

import java.util.Vector;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

import algoritm.AlgoritmFour;
import algoritm.AlgoritmThree;
import algoritm.AlgoritmTwo;

public class MintermenMaxtermen implements Calcul{
	
	private Vector<Integer> functie_mintermen =  new Vector<Integer>();
    private static MintermenMaxtermen Object;
	
	public AlgoritmTwo Initializare_doi(int[] val)
	{
		AlgoritmTwo two =  new AlgoritmTwo(val);
		return two;
	}
	public AlgoritmThree Initializare_trei(int[] val)
	{
		AlgoritmThree three =  new AlgoritmThree(val);
		return  three;
	}
	public AlgoritmFour Initializare_patru(int[] val)
	{
		AlgoritmFour four =  new AlgoritmFour(val);
		return  four;
	}
	public MintermenMaxtermen()
	{
		super();
	}
	public static MintermenMaxtermen getInstance() {
		final Logger logger = Logger.getLogger(MintermenMaxtermen.class);
		PropertyConfigurator.configure("log4j.properties");
	      if(Object == null) {
	    	logger.info("S-a accesat instanta Singleton din MINTERMEN");
	    	  Object = new MintermenMaxtermen();
	      }
	       return Object;
	   }
    
	
	public Vector<Integer> getMintermen() {
		return functie_mintermen;
	}
	public void setMintermen(Vector<Integer> mintermen) {
		this.functie_mintermen = mintermen;
	}
	
	
}

