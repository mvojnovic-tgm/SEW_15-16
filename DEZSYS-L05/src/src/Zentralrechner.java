package src;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Zentralrechner {

  private static String user = ActiveMQConnection.DEFAULT_USER;
  private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
  private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
  private static String[] subject;
  
  private static Commands netConn = null;
	
  public static void main( String[] args ) {
		
	  
	  getParkrechner();
	  
	  
	  // Create the connection.
	  Session session = null;
	  Connection connection = null;
	  MessageConsumer[] consumer = new MessageConsumer[subject.length-1];
	  Destination destination = null;
	  Queue[] q = new Queue[subject.length-1];
	  
	 
			
	  try {
	    
		  	
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
			connection = connectionFactory.createConnection();
			connection.start();
		
			// Create the session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//create Queues
			for(int i = 0; i<q.length; i++){
				q[i] = session.createQueue(subject[i+1]);
			}
			
			//for(int i = 0; i<)
			
			
			// Create the consumer
			for(int i = 0; i<consumer.length; i++){
				consumer[i] = session.createConsumer(q[i]);
			}
				
			// Start receiving
			ObjectMessage[] message = new ObjectMessage[q.length];
			for(int i = 0; i<message.length; i++){
				message[i] = (ObjectMessage)consumer[i].receive();
			}
			
			//interpretiere messages
			ArrayList<ArrayList<String[]>> als = new ArrayList<>();
			for(int i = 0; i<message.length; i++){
				als.add((ArrayList<String[]>)message[i].getObject());
			}			

      if ( message != null ) {
    	  
    	  for(int i = 0; i<message.length; i++){
    		  //Ausgabe und acknoledge
    		  message[i].acknowledge();
    		  System.out.println("Got: Parkrechner"+ (i+1));
    		  printPR(als.get(i));
    		  System.out.println();
    		  
    	  }
    	  
      }
      
      connection.stop();
				
	  } catch (Exception e) {
	  	
	    System.out.println("[MessageConsumer] Caught: " + e);
	    e.printStackTrace();
	      
	  }
	  
	  command();

  } // end main

private static void command() {
	boolean run = true;
	while(run == true){//eine Schleife damit mehrere Commands gesendet werden koennen
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();
		try {
			
			netConn = (Commands)Naming.lookup(Commands.LOOKUPNAME);
			String cmd = "";
			//Die Commands
			switch(st){
			case "aus": cmd = netConn.abschalten();
				//der aus Command schaltet den Server aus
				run = false;
				break;
			case "start": cmd = netConn.starten();
				break;
			case "bl": cmd = netConn.setBlindleistung();
				break;
			case "wl": cmd = netConn.setWirkleistung();
				break;
			case "bw": cmd = netConn.setBlattwinkel();
				break;
			case "gw": cmd = netConn.setGondelwinkel();
				break;
			default: System.out.println("Falscher Input");
				break;
			}
			System.out.println(cmd);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}

private static void printPR(ArrayList<String[]> al ) {
	int wr = 1;
	for(String[] s : al){
		System.out.println();
		System.out.println("Windrechner"+wr);
		wr++;
		for(int i = 0; i< s.length ; i++)System.out.println(s[i]);
	}
	System.out.println("----------------------------------------------");
	System.out.println();
	
}

/**
 * Methoden zum auslesen der conf Datei
 */
	private static void getParkrechner() {
	
		try {
			
			File file = new File("conf.xml");
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			if (doc.hasChildNodes()) {
				printNote(doc.getChildNodes());
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static void printNote(NodeList nodeList) {

		  
	    for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);
	
			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
	
				// get node name and value
				//System.out.println(tempNode.getTextContent());
				subject = tempNode.getTextContent().split("\n");
				
	
			}
	    }
	    
	    for(int i = 0; i<subject.length; i++){
	    	subject[i] = subject[i].replace(" ","");
	    }
	    	
	    
	
	
	
	}
      
}
	
