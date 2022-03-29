package functie;

import java.util.Vector;

public class Maxtermen implements Calcul {
	private int value;
	private static int n_bits;
	private boolean checked;
	private Vector<Boolean> bits =  new Vector<Boolean>(5);
	private Vector<Boolean> dont_care =  new Vector<Boolean>(5);
	private String prod_of_sum;
	
	public Maxtermen()
	{
		value = 0;
		n_bits = 0;
		checked = false;
		bits = null;
		dont_care = null;
		prod_of_sum = "";
	}
	@Override
	public void functie_calcul() {
		
	}
}