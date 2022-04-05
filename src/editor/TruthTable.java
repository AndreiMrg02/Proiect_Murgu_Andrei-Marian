package editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import functie.Mintermen;

public class TruthTable implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Mintermen position;
    private ArrayList<ArrayList<Integer>> bits;
    private static TruthTable Object;
    
    public static TruthTable getInstance() {

    	Logger logger = Logger.getLogger(TruthTable.class.getName());
    	
   	    Supplier<String> StrSupplier= () -> new String("S-a accesat instanta TruthTable!");
	      if(Object == null) {
	    	  logger.log(Level.INFO,
	                   StrSupplier);
	    	  Object = new TruthTable();
	      }
	       return Object;
	   }
    
	
	private TruthTable() {
		super();
	}
	public TruthTable(Mintermen mintermen, ArrayList<ArrayList<Integer>> bits) {
		super();
		this.setPosition(mintermen);
		this.bits = bits;
	}
	public ArrayList<ArrayList<Integer>> getBits() {
		return bits;
	}
	public void setBits(ArrayList<ArrayList<Integer>> bits) {
		this.bits = bits;
	}

	public Mintermen getPosition() {
		return position;
	}

	public void setPosition(Mintermen mintermen) {
		this.position = mintermen;
	}






}