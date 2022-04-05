//package parser;
//
//
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.stream.JsonReader;
//
//import editor.DiagramaKV;
//
//
//
//
//
//	public class CitireDate {
//
//		public void  read_json( ) throws IOException
//		    {
//		       
//		    	DiagramaKV[] kv = null;
//		    	try {
//		    		
//		    		JsonReader reader = new JsonReader(new FileReader("truthtable.json"));
//		    		GsonBuilder builder =  new GsonBuilder();
//		    		Gson gson = builder.create();
//		    	    kv = gson.fromJson(reader, DiagramaKV[].class);
//		    	    
//		    	   
//		    	  
//		    	  
//		    	    for(DiagramaKV date: kv)
//	                {
//		    	    	   System.out.println("Numarul de biti:" + date.getN_Bits() + " ");
//		    	
//				    	     for(int i = 0; i < date.sizeTable(); i++)
//						    	{
//		                        
//						    	System.out.print(" "+ date.getTable().getMintermen().get(i));
//						    	
//						    	  for(int j = 0; j < date.getN_Bits(); j++)
//							    	{
//							    	System.out.print(" "+ date.getTable().getBits().get(i).get(j));
//							    	}
////						    	System.out.println(" "+date.getTable().getValue().get(i));
//						    	}
//	                }
//    		    	    	
//
//		    	}
//		    	catch(FileNotFoundException ex)
//		    	{
//		    		ex.printStackTrace();
//		    	}
//		    	catch(Exception ex){
//		    		ex.printStackTrace();
//		    		
//		    	}
//		    	
//		    	
//		    }
//
//		
//	}
//
//
