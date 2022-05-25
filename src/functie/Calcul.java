package functie;

import algoritm.AlgoritmPatruBiti;
import algoritm.AlgoritmTreiBiti;
import algoritm.AlgoritmDoiBiti;

public interface Calcul {
	
	public AlgoritmDoiBiti Initializare_doi(int[] val);
	public AlgoritmTreiBiti Initializare_trei(int[] val);
	public AlgoritmPatruBiti Initializare_patru(int[] val);

}
