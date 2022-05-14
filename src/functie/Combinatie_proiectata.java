package functie;
import java.util.Vector;

public class Combinatie_proiectata implements Calcul {
	
	
	private int value;
	private static int n_bits;
	private boolean checked;
	private Vector<Integer> bits =  new Vector<Integer>(5);
	private Vector<Boolean> dont_care =  new Vector<Boolean>(5);
	private boolean verificare_combinatie;
     
	public Combinatie_proiectata(int value, boolean checked, Vector<Integer> bits, Vector<Boolean> dont_care,
			boolean verificare_combinatie) {

		this.value = value;
		this.checked = checked;
		this.bits = bits;
		this.dont_care = dont_care;
		this.verificare_combinatie = verificare_combinatie;
	}

	public Combinatie_proiectata()
	{
		value = 0;
		n_bits = 0;
		checked = false;
		bits = null;
		dont_care = null;
		verificare_combinatie = false;
		
	}


	@Override
	public void initializare_vector(int n_Bits) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void construire_sir_biti(int n_Bits) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afisare_sir_biti() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializare_mintermen_din_json(int n_Bits) {
		// TODO Auto-generated method stub
		
	}

}
