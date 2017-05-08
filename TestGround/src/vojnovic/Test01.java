package vojnovic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class Test01 {
	private static String role1 = null;
	private static String role2 = null;
	private static String role3 = null;
	private static String role4 = null;
	private static ArrayList<String> rolev;
	
	public static void main(String[] args){
//		ArrayList<Integer> as = new ArrayList<>();
//		
//		as.add(1);
//		as.add(2);
//		
//		System.out.println(as.get(0));
//		
//		
//		ArrayList<Integer[]> as2 = new ArrayList<>();
//		Integer[] inte = new Integer[1];
//		
//		inte[0] = 1;
//		as2.add(inte);
//		System.out.println("erste: "+as2.get(0)[0]);
//		
//		inte[0] = 3;
//		as2.add(inte);
//		for(int i = 0; i<5;i++){
//			inte[0] = i;
//			System.out.println(inte);
//			as2.add(inte);
//		}
		
//		System.out.println(as2.get(0)[0]);
//		System.out.println(as2.get(1)[0]);
//		
		//for(int i = 0; i<5; i++)System.out.println(as2.get(i)[0]+"");
		
		
		
		
//		 ArrayList<String[]> listOfArrayList = new ArrayList<String[]>();
//		 String[] s = new String[1];
//		 s[0] = "lel";
//
//	        //Assignment of 4 different String Arrays with different lengths
//	        listOfArrayList.add( new String[]{"line1: test String 1","line1: test String 2","line1: test String 3"}  );
//	        listOfArrayList.add( new String[]{"line2: test String 1"}  );
//	        listOfArrayList.add( new String[]{"line3: test String 1","line3: test String 2","line3: test String 3", "line3: test String 4"}  );
//	        listOfArrayList.add( new String[]{"line4: test String 1","line4: test String 2"}  );
//	        listOfArrayList.add(s);
//	        s[0] = "jesus";
//	        listOfArrayList.add(s);
//
//	        // Printing out the ArrayList Contents of String Arrays
//	        // '$' is used to indicate the String elements of String Arrays
//	        for( int i = 0; i < listOfArrayList.size(); i++ ) {
//	            for( int j = 0; j < listOfArrayList.get(i).length; j++ )
//	                System.out.printf(" $ " + listOfArrayList.get(i)[j]);
//
//	            System.out.println();
//	        }
		
				
		
		
		try {

			File file = new File("test.xml");

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
		                             .newDocumentBuilder();

			Document doc = dBuilder.parse(file);


			if (doc.hasChildNodes()) {

				printNote(doc.getChildNodes());

			}

		    } catch (Exception e) {
			System.out.println(e.getMessage());
		    }
	}
		  private static void printNote(NodeList nodeList) {

			  String[] s = null;
			  
		    for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				//System.out.println(tempNode.getTextContent());
				s = tempNode.getTextContent().split("\n");
				

			}
		    }
		    	
		    try{
		    	System.out.println(s.length);
		    	for(int i = 1; i<s.length;i++){
		    		s[i] = s[i].replace(" ","");
		    		System.out.println(s[i]);
		    	}
		    }catch(NullPointerException n){
		    	
		    }
		
		
		
	}
	private static String getTextValue(String def, Element doc, String tag) {
	    String value = def;
	    NodeList nl;
	    nl = doc.getElementsByTagName(tag);
	    if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
	        value = nl.item(0).getFirstChild().getNodeValue();
	    }
	    return value;
	}
	
}
