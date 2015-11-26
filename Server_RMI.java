import java.rmi.Naming;

public class Server_RMI{

	public static void main(String[] args){
		try{
			Server_Interface server=new Server_Implementacao();
			Naming.rebind("rmi://localhost/Servidor", server);
			System.out.println("Rodando...");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}