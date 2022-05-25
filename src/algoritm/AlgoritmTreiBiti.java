package algoritm;


public class AlgoritmTreiBiti implements Check2 ,Check4{

	  private String sir_biti = "";
	  private final int matrice[][] = new int[2][4];
	  private final int verificare[][] = new int[2][4];
	  private int count;
	  
	public AlgoritmTreiBiti(int[] valoare)
		{
				count = 0;
		        for (int i = 0; i < 2; i++) {
		            for (int j = 0; j < 4; j++) {
		                matrice[i][j] = valoare[count++];
		                verificare[i][j] = 0;
		            }
		        }
		}
	@Override
	public String rezolvare_diagrama(int n_bits) {
		if (!verificare_opt_biti()) {
            
            sir_biti = "1";
        } else {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (matrice[i][j] == 1 && verificare[i][j] == 0) {
                        if (verificare_patru_biti(i, j)) {
                            if (verificare_doi_biti(i, j,n_bits)) {
                            	grup_biti(i, j);
                            }
                        }

                    }
                }
            }
        }
        return sir_biti;
	}
     public boolean verificare_opt_biti() {
    	 boolean cautare_grup = false;

    	        outer:
    	        for (int i = 0; i < 2; i++) 
    	        {
    	            for (int j = 0; j < 4; j++) 
    	            {
    	                if (matrice[i][j] == 1)
    	                {
    	                    cautare_grup = false;
    	                } else
    	                {
    	                    cautare_grup = true;
    	                    break outer;
    	                }
    	            }
    	        }
    	        return cautare_grup;
    	    }

	@Override
	public boolean verificare_patru_biti(int row, int col) {
		  boolean cautare_grup = true;
	        String local_bit_string = "";
	        if (matrice[row][0] == 1 && matrice[row][1] == 1 && matrice[row][2] == 1 && matrice[row][3] == 1) 
	        { // row fours
	            if (row == 0) {
	                local_bit_string = "A'";
	            }
	            if (row == 1) {
	                local_bit_string = "A";
	            }

	            matches(local_bit_string);

	            cautare_grup = false;
	            // make checked
	            verificare[row][0] = 1;
	            verificare[row][1] = 1;
	            verificare[row][2] = 1;
	            verificare[row][3] = 1;
	        } else if (matrice[0][col] == 1 && matrice[0][(col + 1) % 4] == 1 && matrice[1][col] == 1 && matrice[1][(col + 1) % 4] == 1)
	        { // columns ++
	            if (col == 0) {
	                local_bit_string = "B'";
	            }
	            if (col == 1) {
	                local_bit_string = "C";
	            }
	            if (col == 2) {
	                local_bit_string = "B";
	            }
	            if (col == 3) {
	                local_bit_string = "C'";
	            }

	            matches(local_bit_string);

	            cautare_grup = false;
	            // make checked
	            verificare[0][col] = 1;
	            verificare[0][(col + 1) % 4] = 1;
	            verificare[1][col] = 1;
	            verificare[1][(col + 1) % 4] = 1;
	        } else if (matrice[0][col] == 1 && matrice[0][(4 + (col - 1)) % 4] == 1 && matrice[1][col] == 1 && matrice[1][(4 + (col - 1)) % 4] == 1) 
	        { // columns --
	            if (col == 0) 
	            {
	                local_bit_string = "C'";
	            }
	            if (col == 1) 
	            {
	                local_bit_string = "B'";
	            }
	            if (col == 2) 
	            {
	                local_bit_string = "C";
	            }
	            if (col == 3) 
	            {
	                local_bit_string = "B";
	            }

	            matches(local_bit_string);

	            cautare_grup = false;
	            // make checked
	            verificare[0][col] = 1;
	            verificare[0][(4 + (col - 1)) % 4] = 1;
	            verificare[1][col] = 1;
	            verificare[1][(4 + (col - 1)) % 4] = 1;
	        }
	        return cautare_grup;
	}
	

	@Override
	public boolean verificare_doi_biti(int row, int col, int n_bits) {
		 boolean  cautare_grup = true;
	        String local = "";

	        if (matrice[row][col] == 1 && matrice[row][(col + 1) % 4] == 1) { // columns ++
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
	                local = local + "C";
	            }
	            if (col == 2) {
	                local = local + "B";
	            }
	            if (col == 3) {
	                local = local + "C'";
	            }

	            matches(local);

	            cautare_grup = false;
	            verificare[row][col] = 1;
	            verificare[row][(col + 1) % 4] = 1;
	        } else if (matrice[row][(4 + (col - 1)) % 4] == 1 && matrice[row][col] == 1) { // columns -- 
	            if (row == 0) {
	                local = "A'";
	            }
	            if (row == 1) {
	                local = "A";
	            }
	            if (col == 0) {
	                local = local + "C'";
	            }
	            if (col == 1) {
	                local = local + "B'";
	            }
	            if (col == 2) {
	                local = local + "C";
	            }
	            if (col == 3) {
	                local = local + "B";
	            }

	            if (sir_biti.matches("")) {
	                sir_biti = sir_biti + local;
	            } else {
	                sir_biti = sir_biti + " + " + local;
	            }

	            cautare_grup = false;
	            // make checked
	            verificare[row][(4 + (col - 1)) % 4] = 1;
	            verificare[row][col] = 1;
	        } else if (matrice[row][col] == 1 && matrice[(row + 1) % 2][col] == 1) { // rows ++
	            if (col == 0) {
	                local = "B'C'";
	            }
	            if (col == 1) {
	                local = "B'C";
	            }
	            if (col == 2) {
	                local = "BC";
	            }
	            if (col == 3) {
	                local = "BC'";
	            }

	            matches(local);

	            cautare_grup = false;
	            // make checked
	            verificare[row][col] = 1;
	            verificare[(row + 1) % 2][col] = 1;
	        }
			return cautare_grup;
	}
	@Override
	public void grup_biti(int row, int col) {
		String local_bit_string = "";

        if (row == 0) {
            local_bit_string = "A'";
        }
        if (row == 1) {
            local_bit_string = "A";
        }
        if (col == 0) {
            local_bit_string = local_bit_string + "B'C'";
        }
        if (col == 1) {
            local_bit_string = local_bit_string + "B'C";
        }
        if (col == 2) {
            local_bit_string = local_bit_string + "BC";
        }
        if (col == 3) {
            local_bit_string = local_bit_string + "BC'";
        }

        matches(local_bit_string);
        verificare[row][col] = 1;
    }
	@Override
	public void matches(String local) {
		 if (sir_biti.matches("")) {
             sir_biti = sir_biti + local;
         } else {
             sir_biti = sir_biti + " + " + local;
         }
		
	}
		
}



