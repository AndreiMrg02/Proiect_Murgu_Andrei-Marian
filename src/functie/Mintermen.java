package functie;

import java.util.Vector;

public class Mintermen implements Calcul {
	
	private int value;
	private static int n_bits;
	private boolean checked;
	private Vector<Boolean> bits =  new Vector<Boolean>(5);
	private Vector<Boolean> dont_care =  new Vector<Boolean>(5);
	private String sum_of_prod;
	
	Mintermen()
	{
		value = 0;
		n_bits = 0;
		checked = false;
		bits = null;
		dont_care = null;
		sum_of_prod = "";
	}
	public void functie_calcul() {
		
	}
}