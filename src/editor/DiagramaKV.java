package editor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import  java.lang.Math;
import java.util.ArrayList;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import functie.Calcul;
import functie.Combinatie_proiectata;
import functie.Maxtermen;
import functie.Mintermen;
import pattern.AbstractFactory;


public class DiagramaKV extends AbstractFactory implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -7898613997619182121L;
    private int n_Bits;
    private TruthTable table =  TruthTable.getInstance();
    public DiagramaKV() {
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
    public void  read_json( ) throws IOException
    {
       
    	DiagramaKV[] kv = null;
    	try {
    		
    		JsonReader reader = new JsonReader(new FileReader("truthtable.json"));
    		GsonBuilder builder =  new GsonBuilder();
    		Gson gson = builder.create();
    	    kv = gson.fromJson(reader, DiagramaKV[].class);
    	    
    	  
    	    for(DiagramaKV date: kv)
            {
    	    	
    	    	   System.out.println("Numarul de biti:" + date.getN_Bits() + " \n");
    	    	   
//    	    	  	for(Integer mintermen: date.table.getMintermen()  )
//        	    	   	{
//        	    	   		System.out.println(" " + mintermen);
//        	    	   
//        	    	   	}
//        	    		for(ArrayList<Integer> bits: date.table.getBits())
//        	    		{
//        	    			for(ArrayList<Integer> n_bits: date.table.getBits())
//            	    		{
//            	    			System.out.print(" " + n_bits.get(n_Bits));
//            	    		}
//        	    			System.out.print(" " + bits.get(n_Bits));
//        	    		}
//        	    		for(Boolean value: date.table.getValue() )
//        	    	   	{
//        	    	   		System.out.print("Value " + value);
//        	    	   	}   	    	     	      	    	    	    		
		    	     for(int i = 0; i < date.sizeTable(); i++)
				    	{
                        
				    	System.out.print(" " + date.table.getMintermen().get(i));
				    	
				    	  for(int j = 0; j < date.getN_Bits(); j++)
					    	{
					    	System.out.print(" " + date.table.getBits().get(i).get(j));
					    	}
				    	System.out.println(" "+ date.table.getValue().get(i));
				    	}
            }
	    	    	

    	}
    	catch(FileNotFoundException ex)
    	{
    		ex.printStackTrace();
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    		
    	}
    	
    	
    }
	@Override
	public Calcul getTerm(String term) {
		if(term.equalsIgnoreCase("Mintermen"))
		{
			return new Mintermen();
		}else if(term.equalsIgnoreCase("Maxtermen"))
		{
			return new Maxtermen();
		}else if(term.equalsIgnoreCase("CombinatieProiectata"))
		{
			return new Combinatie_proiectata();
		}
		return null;
	}

}

