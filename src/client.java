
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emmanuel
 */
public class client {
    public static void main (String args[]) throws RemoteException{
	client c = new client();
	c.connectRemote();
}

private void connectRemote() throws RemoteException{
	try
	{
		Registry reg = LocateRegistry.getRegistry("localhost", 4444);
		Adder ad = (Adder) reg.lookup("hi_server");
		System.out.println("addition is " + ad.add(50, 70));
                
        }catch(NotBoundException|RemoteException e){
            System.out.println("Exception: " + e);
        }

}
        
}