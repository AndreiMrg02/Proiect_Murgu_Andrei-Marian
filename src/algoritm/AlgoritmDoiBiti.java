package algoritm;

public class AlgoritmDoiBiti implements Check2{

	 private String sir_biti = "";
	    private final int matrice[][] = new int[2][2];
	    private final int verificare[][] = new int[2][2];
	    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    public AlgoritmDoiBiti() {
	    	super();
	    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    public AlgoritmDoiBiti(int[] val) {
	        int count = 0;
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                matrice[i][j] = val[count++];
	                verificare[i][j] = 0;
	            }
	        }
	    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    public String rezolvare_diagrama(int n_bits) {
	        if (!verificare_patru_biti(n_bits)) {

	            sir_biti = "1";
	        } else {
	    
	            for (int i = 0; i < n_bits; i++) {
	                for (int j = 0; j < n_bits; j++) {
	                    if (matrice[i][j] == 1 && verificare[i][j] == 0) {
	                        if (verificare_doi_biti(i, j,n_bits)) {
	                            grup_biti(i, j);
	                        }

	                    }
	                }
	            }
	        }
	        return sir_biti;
	    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	    public boolean verificare_patru_biti(int n_bits) {
	        boolean cautare_grup = true;

	        outer:
	        for (int i = 0; i < n_bits; i++) {
	            for (int j = 0; j < n_bits; j++) {
	                if (matrice[i][j] == 1) {
	                    cautare_grup = false;
	                } else {
	                    cautare_grup = true;
	                    break outer;
	                }
	            }
	        }
	        return cautare_grup;
	    }
	   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		@Override
		public boolean verificare_doi_biti(int lin, int col,int n_bits) {
			String local = "";
			boolean cautare_grup = true;
	        if (matrice[lin][col] == 1 && matrice[lin][(col + 1) % n_bits] == 1) { // columns ++
	            if (lin == 0) {
	                local = "A'";
	            }
	            if (lin == 1) {
	                local = "A";
	            }

	            creare_sir_biti( local);

	            cautare_grup = false;
	       
	            verificare[lin][col] = 1;
	            verificare[lin][(col + 1) % n_bits] = 1;
	        } else if (matrice[lin][col] == 1 && matrice[(lin + 1) % n_bits][col] == 1) { // rows ++
	            if (col == 0) {
	                local = "B'";
	            }
	            if (col == 1) {
	                local = "B";
	            }
	            creare_sir_biti( local);
	            cautare_grup = false;
	  
	            verificare[lin][col] = 1;
	            verificare[(lin + 1) % n_bits][col] = 1;
	        }
			return cautare_grup;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 public void grup_biti(int lin, int col) {
		        String local = "";

		        if (lin == 0) {
		            local = "A'";
		        }
		        if (lin == 1) {
		            local = "A";
		        }
		        if (col == 0) {
		            local = local + "B'";
		        }
		        if (col == 1) {
		            local = local + "B";
		        }

		        creare_sir_biti( local);

		        verificare[lin][col] = 1;
		    }
		 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    public void creare_sir_biti(String local)
		    {
		    	 if (sir_biti.matches("")) {
		             sir_biti = sir_biti + local;
		         } else {
		             sir_biti = sir_biti + " + " + local;
		         }
		    	
		    }

}
