package functie;

import java.util.Vector;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

import algoritm.AlgoritmPatruBiti;
import algoritm.AlgoritmTreiBiti;
import algoritm.AlgoritmDoiBiti;

public class MintermenMaxtermen implements Calcul{
	
	private Vector<Integer> functie_mintermen =  new Vector<Integer>();
    private static MintermenMaxtermen Object;
	
	public AlgoritmDoiBiti Initializare_doi(int[] val)
	{
		AlgoritmDoiBiti two =  new AlgoritmDoiBiti(val);
		return two;
	}
	public AlgoritmTreiBiti Initializare_trei(int[] val)
	{
		AlgoritmTreiBiti three =  new AlgoritmTreiBiti(val);
		return  three;
	}
	public AlgoritmPatruBiti Initializare_patru(int[] val)
	{
		AlgoritmPatruBiti four =  new AlgoritmPatruBiti(val);
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
	    	logger.info("S-a accesat instanta Singleton din MINTERMEN si MAXTERMEN");
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

