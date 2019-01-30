
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emmanuel
 */
public class server extends UnicastRemoteObject implements Adder{
    public server() throws RemoteException{
        super();
    }

    @Override
    public int add(int n1, int n2) throws RemoteException {
        return n1+n2;
    }
    
    public static void main(String args[]) throws RemoteException{
        try{
            Registry reg = LocateRegistry.createRegistry(4444);
            reg.rebind("hi_server", new server()); //come back to edit
            System.out.println("server is ready..");
        }catch(RemoteException e){
            System.out.println("Exception: " + e);
            
        }
    
   }
}
