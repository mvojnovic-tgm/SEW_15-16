
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.w3c.dom.*;

public class XMLRPCClient {

	private static int port;
	private static final String host = "localhost";
	private static ArrayList<String[]> wts;
	
	public static void main(String[] args) throws Exception {
		
		
		wts = new ArrayList();
		
		ArrayList<XmlRpcClient> client = new ArrayList();
		//VORDEFINIERTE SERVER PORTS
		XmlRpcClientConfigImpl conf0 = new XmlRpcClientConfigImpl();
		conf0.setServerURL(new URL("http://"+host+":"+8080+"/xmlrpc"));
		XmlRpcClient xrc0 = new XmlRpcClient();
		xrc0.setConfig(conf0);
		client.add(xrc0);
		
		XmlRpcClientConfigImpl conf1 = new XmlRpcClientConfigImpl();
		conf1.setServerURL(new URL("http://"+host+":"+8081+"/xmlrpc"));
		XmlRpcClient xrc1 = new XmlRpcClient();
		xrc1.setConfig(conf1);
		client.add(xrc1);
		
		XmlRpcClientConfigImpl conf2 = new XmlRpcClientConfigImpl();
		conf2.setServerURL(new URL("http://"+host+":"+8082+"/xmlrpc"));
		XmlRpcClient xrc2 = new XmlRpcClient();
		xrc2.setConfig(conf2);
		client.add(xrc2);
		
		
		//MANUELES HINZUFUEGEN VON SERVERS UEBER DIE KONSOLE
		//while(true){
			//System.out.println("Welches Windkraftwerk wollen sie abfragen?(Port)");
			//Scanner s = new Scanner(System.in);
			//String str = s.nextLine();
			//if(str.equals("exit"))break;
			//
			//port = Integer.parseInt(str);
			// Set Client Configuration
			//XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			//config.setServerURL(new URL("http://"+ host + ":" + port + "/xmlrpc") );
			//XmlRpcClient client = new XmlRpcClient();
			//client.setConfig( config );
			
			//------------------------------------------------------------------------------------------------------
			//XmlRpcClientConfigImpl conf = new XmlRpcClientConfigImpl();
			//conf.setServerURL(new URL("http://"+host+":"+port+"/xmlrpc"));
			//XmlRpcClient xrc = new XmlRpcClient();
			//xrc.setConfig(conf);
			//client.add(xrc);
			
			
		
			// Set Parameter
			Object[] params = new Object[]{0,0};
			
			// RPC Call
			//Integer result = (Integer) client.execute("Calculator2.mul", params);
			
			
			//---------------------------------------------------
			//Integer result = (Integer)client.execute("RandomValueGenerator.testRnd", params);
			String[] help = new String[7];
			for(int i = 0; i<client.size();i++){
				/*
				System.out.println("Windkraft: "+i);
				System.out.println(client.get(i).execute("RandomValueGenerator.temp", params)+" Grad Celsius");
				System.out.println(client.get(i).execute("RandomValueGenerator.akt_Strom", params)+ " I");
				System.out.println(client.get(i).execute("RandomValueGenerator.b_Strom", params)+" I");
				System.out.println(client.get(i).execute("RandomValueGenerator.d_Zahl", params)+" pro min");
				System.out.println(client.get(i).execute("RandomValueGenerator.wind_v", params)+" km/h");
				System.out.println(client.get(i).execute("RandomValueGenerator.b_Pos", params)+" Grad");
				*/
				help = new String[7];
				help[0] = i+"";
				help[1] = client.get(i).execute("RandomValueGenerator.temp", params)+"";
				help[2] = client.get(i).execute("RandomValueGenerator.akt_Strom", params)+"";
				help[3] = client.get(i).execute("RandomValueGenerator.b_Leistung", params)+"";
				help[4] = client.get(i).execute("RandomValueGenerator.d_Zahl", params)+"";
				help[5] = client.get(i).execute("RandomValueGenerator.wind_v", params)+"";
				help[6] = client.get(i).execute("RandomValueGenerator.b_Pos", params) +"";
				
				
				
				
				wts.add(help);
				
				//---------------------------------------
//				for(int j = 0; j<=i;j++){
//				System.out.println("------------------------------------------------");
//				System.out.println(wts.get(j)[0]);
//				System.out.println(wts.get(j)[1]);
//				System.out.println(wts.get(j)[2]);
//				System.out.println(wts.get(j)[3]);
//				}
				
				
				//System.out.println(wts.get(0)[0]);

			}		
			for(int i = 0; i<wts.size(); i++){
				for(int j = 0;j<wts.get(i).length; j++){
					System.out.println(wts.get(i)[j]);
				}
			}
			safeToXml();
			// Display Result
			//System.out.println( result );
		
		//}

	}
	
	public static void safeToXml(){
		Document dom;
	    Element e = null;
	    
	    for(int i = 0; i< wts.size(); i++){
	    	System.out.println(wts.get(i)[0]);
	    }
	    
	    // instance of a DocumentBuilderFactory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
	        // use factory to get an instance of document builder
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        // create instance of DOM
	        dom = db.newDocument();

	        // create the root element
	        Element rootEle = dom.createElement("Windraeder");

	        // create data elements and place them under root
	        //e = dom.createElement("role1");
	        //e.appendChild(dom.createTextNode(role1));
	        //rootEle.appendChild(e);
	        for(int i = 0; i< wts.size(); i++){
	        	System.out.println(i);
		        e = dom.createElement("Windrad");
		        e.setAttribute("number"+i, wts.get(i)[0]);
		        e.setAttribute("temp", wts.get(i)[1]);
		        e.setAttribute("akt_Temp", wts.get(i)[2]);
		        e.setAttribute("b_Strom", wts.get(i)[3]);
		        e.setAttribute("d_Zahl", wts.get(i)[4]);
		        e.setAttribute("wind_v", wts.get(i)[5]);
		        e.setAttribute("b_Pos", wts.get(i)[6]);
		        e.appendChild(dom.createTextNode("Windrad "+ wts.get(i)[0]));
		        rootEle.appendChild(e);
	        }
	        
	        
	        
	        
	        
	        dom.appendChild(rootEle);
	        
	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
	            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	            // send DOM to file
	            tr.transform(new DOMSource(dom), 
	                                 new StreamResult(new FileOutputStream("test.xml")));

	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    } catch (ParserConfigurationException pce) {
	        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	    }
	
	}

}
