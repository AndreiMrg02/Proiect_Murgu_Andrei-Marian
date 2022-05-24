package algoritm;


public class AlgoritmThree implements Check2 ,Check4{

	  private String sir_biti = "";
	  private final int matrice[][] = new int[2][4];
	  private final int verificare[][] = new int[2][4];
	  private int count;
	  
	public AlgoritmThree(int[] valoare)
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
	public String solve(int n_bits) {
		if (!check8()) {
            // reaches if all values are 1
            sir_biti = "1";
        } else {
            // reaches if smaller groups are to be found rather than 8
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (matrice[i][j] == 1 && verificare[i][j] == 0) {
                        if (check4(i, j)) {
                            if (check2(i, j,n_bits)) {
                            	group_bits(i, j);
                            }
                        }

                    }
                }
            }
        }
        return sir_biti;
	}
     public boolean check8() {
    	 boolean search_smaller_group = false;

    	        outer:
    	        for (int i = 0; i < 2; i++) 
    	        {
    	            for (int j = 0; j < 4; j++) 
    	            {
    	                if (matrice[i][j] == 1)
    	                {
    	                    search_smaller_group = false;
    	                } else
    	                {
    	                    // breaks outer loop and returns true to find smaller groups
    	                    search_smaller_group = true;
    	                    break outer;
    	                }
    	            }
    	        }
    	        return search_smaller_group;
    	    }

	@Override
	public boolean check4(int row, int col) {
		  boolean search_smaller_group = true;
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

	            search_smaller_group = false;
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

	            search_smaller_group = false;
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

	            search_smaller_group = false;
	            // make checked
	            verificare[0][col] = 1;
	            verificare[0][(4 + (col - 1)) % 4] = 1;
	            verificare[1][col] = 1;
	            verificare[1][(4 + (col - 1)) % 4] = 1;
	        }
	        return search_smaller_group;
	}
	

	@Override
	public boolean check2(int row, int col, int n_bits) {
		 boolean  search_smaller_group = true;
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

	            search_smaller_group = false;
	            // make checked
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

	            search_smaller_group = false;
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

	            search_smaller_group = false;
	            // make checked
	            verificare[row][col] = 1;
	            verificare[(row + 1) % 2][col] = 1;
	        }
			return search_smaller_group;
	}
	@Override
	public void group_bits(int row, int col) {
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



