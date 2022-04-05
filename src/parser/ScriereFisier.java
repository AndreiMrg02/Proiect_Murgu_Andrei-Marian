//package parser;
//import editor.DiagramaKV;
//import editor.TruthTable;
//
//import java.io.IOException;
//import java.io.Writer;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Vector;
//
//import com.google.gson.Gson;
//
//
//public class ScriereFisier {
//		
//	  public List<DiagramaKV> date_diagrama(List<DiagramaKV> diagrama)
//	  {
//		  Vector<Integer> mintermen =  new Vector<Integer>();
//		  mintermen.add(0,1);
//		  mintermen.add(1,2);
//		  mintermen.add(2,3);
//		  mintermen.add(3,4);
//		  ArrayList<ArrayList<Integer> > arrLL = new ArrayList<ArrayList<Integer>>();
//		  
//		  arrLL.add(new ArrayList<Integer>());
//		  arrLL.get(0).add(0, 0);
//	      arrLL.get(0).add(0, 0);
//	      ArrayList<Integer> linia_doi = new ArrayList<Integer>();
//	      linia_doi.add(0);
//	      linia_doi.add(1);
//	      arrLL.add(linia_doi);
//	      ArrayList<Integer> linia_trei = new ArrayList<Integer>();
//	      linia_trei.add(1);
//	      linia_trei.add(0);
//	      arrLL.add(linia_trei);
//	      ArrayList<Integer> linia_patru = new ArrayList<Integer>();
//	      linia_patru.add(1);
//	      linia_patru.add(1);
//	      arrLL.add(linia_patru);
//	      Vector<Boolean> value =  new Vector<Boolean>(4);
//	      value.add(0,true);
//	      value.add(1,false);
//	      value.add(2,true);
//	      value.add(3,false);
//	
//      	TruthTable table_biti =  new TruthTable(mintermen,arrLL,value);
//        diagrama = Arrays.asList(
//                  new DiagramaKV(2,table_biti)
//          );
//          return  diagrama;
//	  }
//	  
//	  
//	  public void scriere_fisier() {
//
//		  List<DiagramaKV> diagrama =  null;
//	        try {
//	        	
//	        	
//
//	            Gson gson = new Gson();
//	            Writer writer = Files.newBufferedWriter(Paths.get("test.json"));
//	            gson.toJson(date_diagrama(diagrama), writer);
//
//	            writer.close();
//	        System.out.printf("Serialized data is saved\n");
//	        } catch (IOException i) {
//	        System.out.printf("Serialized data NOT saved");
//	        i.printStackTrace();
//	        }
//
//
//	        }
//}
