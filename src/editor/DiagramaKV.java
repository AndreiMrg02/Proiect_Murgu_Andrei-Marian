package editor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import  java.lang.Math;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import functie.Calcul;
import functie.Iterator;
import functie.Maxtermen;
import functie.Mintermen;
import pattern.AbstractFactory;


public class DiagramaKV extends AbstractFactory implements Serializable {

    /**
     * 
     */
	private DiagramaKV[] kv = null;
    private static final long serialVersionUID = -7898613997619182121L;
    private int n_Bits;
    private Mintermen mintermen_function =  Mintermen.getInstance();
    private Maxtermen maxtermen_function =  Maxtermen.getInstance();

	

	public DiagramaKV() {
        this.setN_Bits(0);
        
    }
    public DiagramaKV(int n_Bits, TruthTable table, Mintermen mintermen_function, Maxtermen maxtermen_function) {
		super();
		this.n_Bits = n_Bits;
		this.mintermen_function = mintermen_function;
		this.maxtermen_function = maxtermen_function;
	}
    
    public DiagramaKV getDiagramaKV(int index)
    {
    	if(index <= kv.length)
    	{
    		return kv[index];
    	}
		return null;
    }
   
    public void  read_json( ) throws IOException
    {
       
    	
    	try {
    		
    		JsonReader reader = new JsonReader(new FileReader("truthtable.json"));
    		GsonBuilder builder =  new GsonBuilder();
    		Gson gson = builder.create();
    	    kv = gson.fromJson(reader, DiagramaKV[].class);
    	    
    	  
    	    for(DiagramaKV date: kv)
            {
    	    	
    	    	   System.out.println("Numarul de biti:" + date.getN_Bits() + " \n");
    	    	   System.out.print("Functie Mintermen: ");     	      	    	    	    		
		    	     for(int i = 0; i < date.mintermen_function.getMintermen().size(); i++)
				    	{
					    	System.out.print(" " + date.mintermen_function.getMintermen().get(i));
				    	}
		    	     System.out.println("\n");
		    	     	//date.getTerm("Mintermen").functie_calcul(date.getN_Bits());
//		    	 	date.getTerm("Mintermen").initializare_vector(date.getN_Bits());
//	    	     	date.getTerm("Mintermen").initializare_mintermen_din_json(date.getN_Bits());
//	    	     	date.getTerm("Mintermen").construire_sir_biti(date.getN_Bits());
		    	    initializare_biti("Mintermen", date);
	    	     	date.getTerm("Mintermen").afisare_sir_biti();
		    	     	
		    	     	System.out.print("\nFunctie Maxtermen: \n");   
		    	     for(int i = 0; i < date.mintermen_function.getMintermen().size(); i++)
				    	{
					    	System.out.print(" " + date.maxtermen_function.getMaxtermen().get(i));
				    	}
		    
		    	     System.out.println("\n");
		    	    // date.getTerm("Maxtermen").functie_calcul(date.getN_Bits());
		    	    initializare_biti("Maxtermen", date);
//		    	 	date.getTerm("Maxtermen").initializare_vector(date.getN_Bits());
//	    	     	date.getTerm("Maxtermen").initializare_mintermen_din_json(date.getN_Bits());
//	    	     	date.getTerm("Maxtermen").construire_sir_biti(date.getN_Bits());
	    	     	date.getTerm("Maxtermen").afisare_sir_biti();
		    	     for(Iterator iter = date.mintermen_function.getIterator(); iter.hasNext();)
		    	     {
		    	    	 String KV_min = (String)iter.next();
		    	    	 System.out.println("Sirul : " + KV_min);
		    	     }
		    
		    	     
		    	   
            }
    	    System.out.println(" "); 	
    	    

    	}
    	catch(FileNotFoundException ex)
    	{
    		ex.printStackTrace();
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    		
    	}
    	
    	
    }
    void initializare_biti(String clasa, DiagramaKV kv) 
    {
    	kv.getTerm(clasa).initializare_vector(kv.getN_Bits());
    	kv.getTerm(clasa).initializare_mintermen_din_json(kv.getN_Bits());
    	kv.getTerm(clasa).construire_sir_biti(kv.getN_Bits());
    }
	@Override
	public Calcul getTerm(String term) {
		if(term.equalsIgnoreCase("Mintermen"))
		{
			return mintermen_function;
		}else if(term.equalsIgnoreCase("Maxtermen"))
		{
			return maxtermen_function;
		}else if(term.equalsIgnoreCase("CombinatieProiectata"))
		{
			return Mintermen.getInstance();
		}
		else
		{
			System.out.println("Functia nu exista !");
		}
		return null;
	}

	public Mintermen getMintermen_function() 
	{
		
		return mintermen_function;
	}

	public void setMintermen_function(Mintermen mintermen_function) {
		this.mintermen_function = mintermen_function;
	}

	public Maxtermen getMaxtermen_function() {
		return maxtermen_function;
	}

	public void setMaxtermen_function(Maxtermen maxtermen_function) {
		this.maxtermen_function = maxtermen_function;
	}
	 public int getN_Bits() {
	        return n_Bits;
	    }
	    public void setN_Bits(int n_Bits) {
	        this.n_Bits = n_Bits;
	    }
	    public double sizeTable()
	    {
	        return Math.pow(2, n_Bits);
	    }
	  
}

