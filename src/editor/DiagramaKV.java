package editor;


import java.io.Serializable;

import functie.Calcul;

import functie.MintermenMaxtermen;
import gui.MainFrame;
import pattern.AbstractFactory;


public class DiagramaKV extends AbstractFactory implements Serializable {


    private static final long serialVersionUID = -7898613997619182121L;
    private int n_Bits;
    private MintermenMaxtermen functie_principala =  MintermenMaxtermen.getInstance();
	public DiagramaKV() {
        this.setN_Bits(0);
        
    }

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

	  
}

