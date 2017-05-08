
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class RemoteDateImpl extends UnicastRemoteObject implements RemoteDate {

	/** Construct the object that implements the remote server.
	 * Called from main, after it has the SecurityManager in place.
	 */
	public RemoteDateImpl() throws RemoteException {
		super();	// sets up networking
	}

	/** The remote method that "does all the work". This won't get
	 * called until the client starts up.
	 */
	public Date getRemoteDate() throws RemoteException {
		System.out.println(">> Request for date received. <<");
		return new Date();
	}
}