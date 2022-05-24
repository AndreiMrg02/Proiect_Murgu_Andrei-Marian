package functie;

import algoritm.AlgoritmFour;
import algoritm.AlgoritmThree;
import algoritm.AlgoritmTwo;

public interface Calcul {
	
	public AlgoritmTwo Initializare_doi(int[] val);
	public AlgoritmThree Initializare_trei(int[] val);
	public AlgoritmFour Initializare_patru(int[] val);

}
