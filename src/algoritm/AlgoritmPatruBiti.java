package algoritm;

public class AlgoritmPatruBiti implements Check2{
	 private String sir_biti = "";
	    private final int matrice[][] = new int[4][4];
	    private final int verificare[][] = new int[4][4];

	    public AlgoritmPatruBiti(int val[]) 
	    {
	        int count = 0;
	        for (int i = 0; i < 4; i++)
	        {
	            for (int j = 0; j < 4; j++) 
	            {
	                matrice[i][j] = val[count++]; //Initializam matricea cu val[]
	                verificare[i][j] = 0;
	            }
	        }
	    }

	    public String rezolvare_diagrama(int n_Bits) {
	        if (!verificare_saispreseze_biti()) {
	    
	            sir_biti = "1";
	        } else {

	            for (int i = 0; i < 4; i++) {
	                for (int j = 0; j < 4; j++) {
	                    if (matrice[i][j] == 1 && verificare[i][j] == 0) {
	                        if (check8(i, j)) {
	                            if (check4(i, j)) {
	                                if (verificare_doi_biti(i, j, n_Bits)) {
	                                    grup_biti(i, j);
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        return sir_biti;
	    }

	    
	    private boolean verificare_saispreseze_biti() {
	        boolean cautare_biti = false;

	        outer:
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                if (matrice[i][j] == 1) {
	                    cautare_biti = false;
	                } else {
	       
	                    cautare_biti = true;
	                    break outer;
	                }
	            }
	        }
	        return cautare_biti;
	    }

	    private boolean check8(int row, int col) {
	        boolean cautare_biti = true;
	        String local = "";

	        if (matrice[row][0] == 1 && matrice[row][1] == 1 && matrice[row][2] == 1 && matrice[row][3] == 1 && matrice[(row + 1) % 4][0] == 1 && matrice[(row + 1) % 4][1] == 1
	                && matrice[(row + 1) % 4][2] == 1 && matrice[(row + 1) % 4][3] == 1) { // rows ++
	        	if (row == 0) {
	                local = "A'";
	            }
	            if (row == 1) {
	                local = "B";
	            }
	            if (row == 2) {
	                local = "A";
	            }
	            if (row == 3) {
	                local = "B'";
	            }
	            matches(local);

	            cautare_biti = false;
	     
	            for(int i = 0; i < col; i++)
	            {
	            	verificare[row][i] = 1;
	            	verificare[(row + 1) % 4][i] = 1;
	            }
	            
	        } else if (matrice[row][0] == 1 && matrice[row][1] == 1 && matrice[row][2] == 1 && matrice[row][3] == 1 && matrice[(4 + (row - 1)) % 4][0] == 1
	                && matrice[(4 + (row - 1)) % 4][1] == 1 && matrice[(4 + (row - 1)) % 4][2] == 1 && matrice[(4 + (row - 1)) % 4][3] == 1) { // rows --
	        	if (row == 0) {
	                local = "B'";
	            }
	            if (row == 1) {
	                local = "A'";
	            }
	            if (row == 2) {
	                local = "B";
	            }
	            if (row == 3) {
	                local = "A";
	            }
	            matches(local);

	            cautare_biti = false;
	    
	            for(int i = 0; i < col; i++)
	            {
	            	verificare[row][i] = 1;
	            	verificare[( 4 + (row - 1)) % 4][i] = 1;
	            }
	        } else if (matrice[0][col] == 1 && matrice[1][col] == 1 && matrice[2][col] == 1 && matrice[3][col] == 1 && matrice[0][(col + 1) % 4] == 1 && matrice[1][(col + 1) % 4] == 1
	                && matrice[2][(col + 1) % 4] == 1 && matrice[3][(col + 1) % 4] == 1) { // columns ++
	           
	        	 if (col == 0) {
	                 local = "C'";
	             }
	             if (col == 1) {
	                 local = "D";
	             }
	             if (col == 2) {
	                 local = "C";
	             }
	             if (col == 3) {
	                 local = "D'";
	             }
	            matches(local);

	            cautare_biti = false;
	        
	            for(int i = 0; i < row; i++)
	            {
	            	verificare[i][col] = 1;
	            	verificare[i][(col + 1 ) % 4] = 1;
	            }
	        } else if (matrice[0][col] == 1 && matrice[1][col] == 1 && matrice[2][col] == 1 && matrice[3][col] == 1 && matrice[0][(4 + (col - 1)) % 4] == 1
	                && matrice[1][(4 + (col - 1)) % 4] == 1 && matrice[2][(4 + (col - 1)) % 4] == 1 && matrice[3][(4 + (col - 1)) % 4] == 1) { // columns --
	           
	            if (col == 0) {
	                local = "D'";
	            }
	            if (col == 1) {
	                local = "C'";
	            }
	            if (col == 2) {
	                local = "D";
	            }
	            if (col == 3) {
	                local = "C";
	            }
	            matches(local);

	            cautare_biti = false;
	         
	            for(int i = 0; i < row; i++)
	            {
	            	verificare[i][col] = 1;
	            	verificare[i][(4 + (col - 1 ) ) % 4] = 1;
	            }
	        }
	        return cautare_biti;
	    }
	    // 
	    private String adaugare_doi_biti(int r,int c)
	    {
	    	String local = "";
	    	if (matrice[r][0] == 1 && matrice[r][1] == 1 && matrice[r][2] == 1 && matrice[r][3] == 1) { // row fours
	            if (r == 0) {
	                local = "A'B'";
	            }
	            if (r == 1) {
	                local = "A'B";
	            }
	            if (r == 2) {
	                local = "AB";
	            }
	            if (r == 3) {
	                local = "AB'";
	            }
	            matches(local);
	            
	            for(int i = 0; i < c; i++)
	            {
	            	verificare[r][i] = 1;
	            }
	        } else if (matrice[0][c] == 1 && matrice[1][c] == 1 && matrice[2][c] == 1 && matrice[3][c] == 1) { // column fours
	            if (c == 0) {
	                local = "C'D'";
	            }
	            if (c == 1) {
	                local = "C'D";
	            }
	            if (c == 2) {
	                local = "CD";
	            }
	            if (c == 3) {
	                local = "CD'";

	            }
	            matches(local);
	            
	            for(int i = 0; i < r; i++)
	            {
	            	verificare[i][c] = 1;
	            }
	        }  else if (matrice[r][c] == 1 && matrice[r][(c + 1) % 4] == 1 && matrice[(r + 1) % 4][c] == 1 && matrice[(r + 1) % 4][(c + 1) % 4] == 1) {
	           
	            if (r == 0) {
	                local = "A'";
	            }
	            if (r == 1) {
	                local = "B";
	            }
	            if (r == 2) {
	                local = "A";
	            }
	            if (r == 3) {
	                local = "B'";
	            }
	            if (c == 0) {
	                local = local + "C'";
	            }
	            if (c == 1) {
	                local = local + "D";
	            }
	            if (c == 2) {
	                local = local + "C";
	            }
	            if (c == 3) {
	                local = local + "D'";
	            }

	            matches(local);

	            
	            verificare[r][c] = 1;
	            verificare[r][(c + 1) % 4] = 1;
	            verificare[(r + 1) % 4][c] = 1;
	            verificare[(r + 1) % 4][(c + 1) % 4] = 1;
	        }
	        else
	        {
	        	return null;
	        }
	    	return local;
	    }
	    private void adaugare_un_bit(int r, int c, String local)
	    {
	    	if (r == 0) {
                local = "A'";
            }
            if (r == 1) {
                local = "B";
            }
            if (r == 2) {
                local = "A";
            }
            if (r == 3) {
                local = "B'";
            }
            if (c == 0) {
                local = local + "D'";
            }
            if (c == 1) {
                local = local + "C'";
            }
            if (c == 2) {
                local = local + "D";
            }
            if (c == 3) {
                local = local + "C'";
            }

            matches(local);
	    }

	    
	    private boolean check4(int r, int c) {
	        boolean cautare_biti = true;
	        String local = "";
	        local = adaugare_doi_biti(r,c);
	        if(local != null)
	        {
	        	cautare_biti =  false;
	        }
	        else if (matrice[r][(4 + (c - 1)) % 4] == 1 && matrice[r][c] == 1 && matrice[(r + 1) % 4][(4 + (c - 1)) % 4] == 1 && matrice[(r + 1) % 4][c] == 1) {
	            
	        	adaugare_un_bit( r,  c,  local);
	            cautare_biti = false;
	            
	            verificare[r][(4 + (c - 1)) % 4] = 1;
	            verificare[r][c] = 1;
	            verificare[(r + 1) % 4][(4 + (c - 1)) % 4] = 1;
	            verificare[(r + 1) % 4][c] = 1;

	        } else if (matrice[(4 + (r - 1)) % 4][(4 + (c - 1)) % 4] == 1 && matrice[(4 + (r - 1)) % 4][c] == 1 && matrice[r][(4 + (c - 1)) % 4] == 1 && matrice[r][c] == 1) {
	            
	            if (r == 0) {
	                local = "B'";
	            }
	            if (r == 1) {
	                local = "A'";
	            }
	            if (r == 2) {
	                local = "B";
	            }
	            if (r == 3) {
	                local = "A";
	            }
	            if (c == 0) {
	                local = local + "D'";
	            }
	            if (c == 1) {
	                local = local + "C'";
	            }
	            if (c == 2) {
	                local = local + "D";
	            }
	            if (c == 3) {
	                local = local + "C'";
	            }

	            matches(local);

	            cautare_biti = false;
	            
	            verificare[(4 + (r - 1)) % 4][(4 + (c - 1)) % 4] = 1;
	            verificare[(4 + (r - 1)) % 4][c] = 1;
	            verificare[r][(4 + (c - 1)) % 4] = 1;
	            verificare[r][c] = 1;
	        } else if (matrice[(4 + (r - 1)) % 4][c] == 1 && matrice[(4 + (r - 1)) % 4][(c + 1) % 4] == 1 && matrice[r][c] == 1 && matrice[r][(c + 1) % 4] == 1) {
	           
	            if (r == 0) {
	                local = "B'";
	            }
	            if (r == 1) {
	                local = "A'";
	            }
	            if (r == 2) {
	                local = "B";
	            }
	            if (r == 3) {
	                local = "A";
	            }
	            if (c == 0) {
	                local = local + "C'";
	            }
	            if (c == 1) {
	                local = local + "D";
	            }
	            if (c == 2) {
	                local = local + "C";
	            }
	            if (c == 3) {
	                local = local + "D'";
	            }

	            matches(local);

	            cautare_biti = false;
	            
	            verificare[(4 + (r - 1)) % 4][c] = 1;
	            verificare[(4 + (r - 1)) % 4][(c + 1) % 4] = 1;
	            verificare[r][c] = 1;
	            verificare[r][(c + 1) % 4] = 1;
	        }
	        return cautare_biti;
	    }
	   
	   
	    public boolean verificare_doi_biti(int r, int c,int n_bits) {
	        boolean cautare_biti = true;
	        String local = "";

	        if (matrice[r][c] == 1 && matrice[r][(c + 1) % 4] == 1) { // columns ++
	            if (r == 0) {
	                local = "A'B'";
	            }
	            if (r == 1) {
	                local = "A'B";
	            }
	            if (r == 2) {
	                local = "AB";
	            }
	            if (r == 3) {
	                local = "AB'";
	            }
	            if (c == 0) {
	                local = local + "C'";
	            }
	            if (c == 1) {
	                local = local + "D";
	            }
	            if (c == 2) {
	                local = local + "C";
	            }
	            if (c == 3) {
	                local = local + "D'";
	            }

	            matches(local);

	            cautare_biti = false;
	          
	            verificare[r][c] = 1;
	            verificare[r][(c + 1) % 4] = 1;

	        } else if (matrice[r][(4 + (c - 1)) % 4] == 1 && matrice[r][c] == 1) { // columns --
	            if (r == 0) {
	                local = "A'B'";
	            }
	            if (r == 1) {
	                local = "A'B";
	            }
	            if (r == 2) {
	                local = "AB";
	            }
	            if (r == 3) {
	                local = "AB'";
	            }
	            if (c == 0) {
	                local = local + "D'";
	            }
	            if (c == 1) {
	                local = local + "C'";
	            }
	            if (c == 2) {
	                local = local + "D";
	            }
	            if (c == 3) {
	                local = local + "C";
	            }

	            matches(local);

	            cautare_biti = false;
	           
	            verificare[r][(4 + (c - 1)) % 4] = 1;
	            verificare[r][c] = 1;
	        } else if (matrice[r][c] == 1 && matrice[(r + 1) % 4][c] == 1) { // rows ++
	            if (r == 0) {
	                local = "A'";
	            }
	            if (r == 1) {
	                local = "B";
	            }
	            if (r == 2) {
	                local = "A";
	            }
	            if (r == 3) {
	                local = "B'";
	            }
	            if (c == 0) {
	                local = local + "C'D'";
	            }
	            if (c == 1) {
	                local = local + "C'D";
	            }
	            if (c == 2) {
	                local = local + "CD";
	            }
	            if (c == 3) {
	                local = local + "CD'";
	            }

	            matches(local);

	            cautare_biti = false;
	       
	            verificare[r][c] = 1;
	            verificare[(r + 1) % 4][c] = 1;
	        } else if (matrice[r][c] == 1 && matrice[(4 + (r - 1)) % 4][c] == 1) { // rows --
	            if (r == 0) {
	                local = "B'";
	            }
	            if (r == 1) {
	                local = "A'";
	            }
	            if (r == 2) {
	                local = "B";
	            }
	            if (r == 3) {
	                local = "A";
	            }
	            if (c == 0) {
	                local = local + "C'D'";
	            }
	            if (c == 1) {
	                local = local + "C'D";
	            }
	            if (c == 2) {
	                local = local + "CD";
	            }
	            if (c == 3) {
	                local = local + "CD'";
	            }

	            matches(local);

	            cautare_biti = false;
	           
	            verificare[r][c] = 1;
	            verificare[(4 + (r - 1)) % 4][c] = 1;
	        }
	        return cautare_biti;
	    }

	
	    public void grup_biti(int r, int c) {
	        String local = "";
	        if (r == 0) {
	            local = "A'B'";
	        }
	        if (r == 1) {
	            local = "A'B";
	        }
	        if (r == 2) {
	            local = "AB";
	        }
	        if (r == 3) {
	            local = "AB'";
	        }
	        if (c == 0) {
	            local = local + "C'D'";
	        }
	        if (c == 1) {
	            local = local + "C'D";
	        }
	        if (c == 2) {
	            local = local + "CD";
	        }
	        if (c == 3) {
	            local = local + "CD'";
	        }
	        
	        matches(local);

	        verificare[r][c] = 1;
	    }
	    public void matches(String local)
	    {
	    	 if (sir_biti.matches("")) {
	             sir_biti = sir_biti + local;
	         } else {
	             sir_biti = sir_biti + " + " + local;
	         }
	    	
	    }


}
