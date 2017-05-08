
import java.util.Scanner;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class XMLRPCServer {
	  
private static  int port;

public static void main(String[] args) throws Exception {


  Scanner s = new Scanner(System.in);
  String str = s.nextLine();
  port = Integer.parseInt(str);
	// Initialize Web- and RPCServer
  WebServer webserver = new WebServer (port);
  XmlRpcServer xmlRpcServer = webserver.getXmlRpcServer();
  
  // Set Handler for Calculator Instance
  //PropertyHandlerMapping phm = new PropertyHandlerMapping();
//  PropertyHandlerMapping phm2 = new PropertyHandlerMapping();
//  //phm.addHandler("Calculator", Calculator.class );
//  phm2.addHandler("Calculator2", Calculator2.class);
  //xmlRpcServer.setHandlerMapping(phm);
  //xmlRpcServer.setHandlerMapping(phm2);
  
  
  //---------------------------------------------------------------------------------------
  PropertyHandlerMapping phm = new PropertyHandlerMapping();
  phm.addHandler("RandomValueGenerator", RandomValueGenerator.class);
  xmlRpcServer.setHandlerMapping(phm);
  
  
  // Start Webserver
  webserver.start();
  System.out.println( "Webserver/XmlRpcServer started successfully!");
          
      }
  }