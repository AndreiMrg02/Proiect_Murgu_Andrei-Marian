package algoritm;

public class AlgoritmTwo implements Check2{

	 private String sir_biti = "";
	    private final int matrice[][] = new int[2][2];
	    private final int verificare[][] = new int[2][2];
	    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    public AlgoritmTwo() {
	    	super();
	    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    public AlgoritmTwo(int[] val) {
	        int count = 0;
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                matrice[i][j] = val[count++];
	                verificare[i][j] = 0;
	            }
	        }
	    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    public String solve(int n_bits) {
	        if (!check4(n_bits)) {
	            // reaches if all values are 1
	            sir_biti = "1";
	        } else {
	            // reaches if smaller groups are to be found rather than 4
	            for (int i = 0; i < n_bits; i++) {
	                for (int j = 0; j < n_bits; j++) {
	                    if (matrice[i][j] == 1 && verificare[i][j] == 0) {
	                        if (check2(i, j,n_bits)) {
	                            group_bits(i, j);
	                        }

	                    }
	                }
	            }
	        }
	        return sir_biti;
	    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    // check for 4
	    public boolean check4(int n_bits) {
	        boolean search_smaller_group = true;

	        outer:
	        for (int i = 0; i < n_bits; i++) {
	            for (int j = 0; j < n_bits; j++) {
	                if (matrice[i][j] == 1) {
	                    search_smaller_group = false;
	                } else {
	                    // breaks outer loop and returns true to find smaller groups
	                    search_smaller_group = true;
	                    break outer;
	                }
	            }
	        }
	        return search_smaller_group;
	    }
	    // no grouping
	   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		@Override
		public boolean check2(int row, int col,int n_bits) {
			String local = "";
			boolean search_smaller_group = true;
	        if (matrice[row][col] == 1 && matrice[row][(col + 1) % n_bits] == 1) { // columns ++
	            if (row == 0) {
	                local = "A'";
	            }
	            if (row == 1) {
	                local = "A";
	            }

	            matches( local);

	            search_smaller_group = false;
	            // make checked
	            verificare[row][col] = 1;
	            verificare[row][(col + 1) % n_bits] = 1;
	        } else if (matrice[row][col] == 1 && matrice[(row + 1) % n_bits][col] == 1) { // rows ++
	            if (col == 0) {
	                local = "B'";
	            }
	            if (col == 1) {
	                local = "B";
	            }
	            matches( local);
	            search_smaller_group = false;
	            // make checked
	            verificare[row][col] = 1;
	            verificare[(row + 1) % n_bits][col] = 1;
	        }
			return search_smaller_group;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 public void group_bits(int row, int col) {
		        String local = "";

		        if (row == 0) {
		            local = "A'";
		        }
		        if (row == 1) {
		            local = "A";
		        }
		        if (col == 0) {
		            local = local + "B'";
		        }
		        if (col == 1) {
		            local = local + "B";
		        }

		        matches( local);

		        verificare[row][col] = 1;
		    }
		 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    public void matches(String local)
		    {
		    	 if (sir_biti.matches("")) {
		             sir_biti = sir_biti + local;
		         } else {
		             sir_biti = sir_biti + " + " + local;
		         }
		    	
		    }

}
