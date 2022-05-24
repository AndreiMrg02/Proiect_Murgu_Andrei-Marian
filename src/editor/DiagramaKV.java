package editor;

import java.io.Serializable;
import  java.lang.Math;



import functie.Calcul;

import functie.MintermenMaxtermen;
import pattern.AbstractFactory;


public class DiagramaKV extends AbstractFactory implements Serializable {

    /**
     * 
     */
	private DiagramaKV[] kv = null;
    private static final long serialVersionUID = -7898613997619182121L;
    private int n_Bits;
    private MintermenMaxtermen functie_principala =  MintermenMaxtermen.getInstance();

	public DiagramaKV() {
        this.setN_Bits(0);
        
    }

    public DiagramaKV getDiagramaKV(int index)
    {
    	if(index <= kv.length)
    	{
    		return kv[index];
    	}
		return null;
    }
   
//    public void  read_json( ) throws IOException
//    {
//       
//    	
//    	try {
//    		
//    		JsonReader reader = new JsonReader(new FileReader("truthtable.json"));
//    		GsonBuilder builder =  new GsonBuilder();
//    		Gson gson = builder.create();
//    	    kv = gson.fromJson(reader, DiagramaKV[].class);
//    	    
//    	  
//    	    for(DiagramaKV date: kv)
//            {
//    	    	
//    	    	   System.out.println("Numarul de biti:" + date.getN_Bits() + " \n");
//    	    	   System.out.print("Functie Mintermen: ");     	      	    	    	    		
//		    	     for(int i = 0; i < date.mintermen_function.getMintermen().size(); i++)
//				    	{
//					    	System.out.print(" " + date.mintermen_function.getMintermen().get(i));
//				    	}
//		    	     System.out.println("\n");
//		    	    initializare_biti("Mintermen", date);
//	    	     	date.getTerm("Mintermen").afisare_sir_biti();
//		    	     	
//		    	     	System.out.print("\nFunctie Maxtermen: \n");   
//		    	     for(int i = 0; i < date.mintermen_function.getMintermen().size(); i++)
//				    	{
//					    	System.out.print(" " + date.maxtermen_function.getMaxtermen().get(i));
//				    	}
//		    
//		    	     System.out.println("\n");
//		    	    initializare_biti("Maxtermen", date);
//	    	     	date.getTerm("Maxtermen").afisare_sir_biti();
//		    		    	     
//		    	   
//            }
//    	    System.out.println(" "); 	
//    	    
//
//    	}
//    	catch(FileNotFoundException ex)
//    	{
//    		ex.printStackTrace();
//    	}
//    	catch(Exception ex){
//    		ex.printStackTrace();
//    		
//    	}
//    	
//    	
//    }
	@Override
	public Calcul getTerm(String term) {
		if(term.equalsIgnoreCase("Mintermen"))
		{
			return functie_principala;
		}
		return null;
	}
	public MintermenMaxtermen getMintermen_function() 
	{
		
		return functie_principala;
	}

	public void setMintermen_function(MintermenMaxtermen mintermen_function) {
		this.functie_principala = mintermen_function;
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

