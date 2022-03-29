package editor;

import java.io.Serializable;
import  java.lang.Math;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DiagramaKV implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7898613997619182121L;
    private int n_Bits;
    private int state = 0;
    private TruthTable table =  TruthTable.getInstance();
//    private static DiagramaKV dbObject;
   
    
//    public static DiagramaKV getInstance() {
//
//    	 Logger logger = Logger.getLogger(DiagramaKV.class.getName());
//    	    Supplier<String> StrSupplier= () -> new String("S-a accesat instanta DiagramaKV!");
//	      if(dbObject == null) {
//	    	  logger.log(Level.INFO,
//	                   StrSupplier);
//	         dbObject = new DiagramaKV();
//	      }
//
//	       // returns the singleton object
//	       return dbObject;
//	   }
    public DiagramaKV() {
        super();
        this.setN_Bits(0);
        this.setTable(table);
    }
    public DiagramaKV(int n_Bits, TruthTable table) {
        super();
        this.setN_Bits(n_Bits);
        this.setTable(table);
    }
    
    
    public int getN_Bits() {
        return n_Bits;
    }
    public void setN_Bits(int n_Bits) {
        this.n_Bits = n_Bits;
    }
    public TruthTable getTable() {
        return table;
    }
   
    public void setTable(TruthTable truthTable) {
    	table =  truthTable;
    }
    public double sizeTable()
    {
        return Math.pow(2, n_Bits);
    }
    public void TestSingleton(String s)
    {
    	state++;
    System.out.println(s);
    System.out.println(state);
    }
    
//    @Override
//    public String toString() {
//        return "DiagramaKV n_Bits=" + n_Bits + ", table=" + table + " ";
//    }
}

