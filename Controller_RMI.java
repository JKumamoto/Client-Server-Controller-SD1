import java.rmi.Naming;

public class Controller_RMI {

	public static void main(String[] args) {
		try{
		    Server_Interface Controller=new Controller_Implementacao();
		    Naming.rebind("rmi://localhost/Controller", Controller);
		    System.out.println("Controller no ar...");
		}catch(Exception e){
		    e.printStackTrace();
		}
	}

}
