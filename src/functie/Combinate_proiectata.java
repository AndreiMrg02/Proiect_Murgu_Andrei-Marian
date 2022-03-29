package functie;
import java.util.Vector;

public class Combinate_proiectata implements Calcul {
	
	
	private int value;
	private static int n_bits;
	private boolean checked;
	private Vector<Boolean> bits =  new Vector<Boolean>(5);
	private Vector<Boolean> dont_care =  new Vector<Boolean>(5);
	private boolean verificare_combinatie;
     
	public Combinate_proiectata(int value, boolean checked, Vector<Boolean> bits, Vector<Boolean> dont_care,
			boolean verificare_combinatie) {

		this.value = value;
		this.checked = checked;
		this.bits = bits;
		this.dont_care = dont_care;
		this.verificare_combinatie = verificare_combinatie;
	}

	Combinate_proiectata()
	{
		value = 0;
		n_bits = 0;
		checked = false;
		bits = null;
		dont_care = null;
		verificare_combinatie = false;
		
	}

	@Override
	public void functie_calcul() {
		// TODO Auto-generated method stub
	}

}
