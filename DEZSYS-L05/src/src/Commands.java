package src;

public interface Commands extends java.rmi.Remote{

	public final static String LOOKUPNAME = "commands";
	
	public String setBlattwinkel() throws java.rmi.RemoteException;
	
	public String setGondelwinkel() throws java.rmi.RemoteException;
	
	public String setBlindleistung() throws java.rmi.RemoteException;
	
	public String setWirkleistung() throws java.rmi.RemoteException;
	
	public String abschalten() throws java.rmi.RemoteException;
	
	public String starten() throws java.rmi.RemoteException;	
}
