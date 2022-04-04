package editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TruthTable implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Vector<Integer> mintermen;
    private ArrayList<ArrayList<Integer>> bits;
    private Vector<Boolean> value;
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
	public TruthTable(Vector<Integer> mintermen, ArrayList<ArrayList<Integer>> bits, Vector<Boolean> value) {
		super();
		this.mintermen = mintermen;
		this.bits = bits;
		this.value = value;
	}
	public Vector<Integer> getMintermen() {
		return mintermen;
	}
	public void setMintermen(Vector<Integer> mintermen) {
		this.mintermen = mintermen;
	}
	public ArrayList<ArrayList<Integer>> getBits() {
		return bits;
	}
	public void setBits(ArrayList<ArrayList<Integer>> bits) {
		this.bits = bits;
	}
	public Vector<Boolean> getValue() {
		return value;
	}
	public void setValue(Vector<Boolean> value) {
		this.value = value;
	}






}