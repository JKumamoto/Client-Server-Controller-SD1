import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Controller_Implementacao extends UnicastRemoteObject implements Server_Interface{

    private Server_Interface server1;
    private Server_Interface server2;
    private Server_Interface server3;
    
    public Controller_Implementacao() throws RemoteException{
	super();
	try{
	    server1=(Server_Interface)Naming.lookup("rmi://localhost:10000/Servidor1");
	    server2=(Server_Interface)Naming.lookup("rmi://localhost:10001/Servidor2");
	    server3=(Server_Interface)Naming.lookup("rmi://localhost:10002/Servidor3");
	}catch(Exception e){
	    e.printStackTrace();
	}
    }

    public Resposta Novo_arquivo(Requisicao req) throws RemoteException{
	Resposta rep=new Resposta();
	try{
	    Resposta rep1=server1.Novo_arquivo(req);
	    Resposta rep2=server2.Novo_arquivo(req);
	    Resposta rep3=server3.Novo_arquivo(req);
	    if(rep1.get_message_content() == 2 && rep2.get_message_content() == 2 && rep3.get_message_content() == 2)
		rep=rep1;
	    else{
		rep.set_message_content(Resposta.ARQUIVO_NAO_ESCRITO);
		System.out.println("Valores diferentes nos servidores");
	    }
	}catch(Exception e){
	    e.printStackTrace();
	}
	return rep;
    }

    public Resposta Pega_arquivo(Requisicao req) throws RemoteException{
	Resposta rep=new Resposta();
	try{
	    Resposta rep1=server1.Pega_arquivo(req);
	    Resposta rep2=server2.Pega_arquivo(req);
	    Resposta rep3=server3.Pega_arquivo(req);
	    if(rep1.get_message_content() == 1 && rep2.get_message_content() == 1 && rep3.get_message_content() == 1)
		rep=rep1;
	    else{
		rep.set_message_content(Resposta.ARQUIVO_NAO_ENCONTRADO);
		System.out.println("Valores diferentes nos servidores");
	    }
	}catch(Exception e){
	    e.printStackTrace();
	}
	return rep;
    }

    public Resposta Lista_arquivo(Requisicao req) throws RemoteException{
	Resposta rep=new Resposta();
	try{
	    Resposta rep1=server1.Lista_arquivo(req);
	    Resposta rep2=server2.Lista_arquivo(req);
	    Resposta rep3=server3.Lista_arquivo(req);
	    if(rep1.get_message_content() == 1 && rep2.get_message_content() == 1 && rep3.get_message_content() == 1)
		rep=rep1;
	    else{
		rep.set_message_content(Resposta.ARQUIVO_NAO_ENCONTRADO);
		System.out.println("Valores diferentes nos servidores");
	    }
	}catch(Exception e){
	    e.printStackTrace();
	}
	return rep;
    }

    public Resposta Muda_arquivo(Requisicao req) throws RemoteException{
	Resposta rep=new Resposta();
	try{
	    Resposta rep1=server1.Muda_arquivo(req);
	    Resposta rep2=server2.Muda_arquivo(req);
	    Resposta rep3=server3.Muda_arquivo(req);
	    if(rep1.get_message_content() == 2 && rep2.get_message_content() == 2 && rep3.get_message_content() == 2)
		rep=rep1;
	    else{
		rep.set_message_content(Resposta.ARQUIVO_NAO_ENCONTRADO);
		System.out.println("Valores diferentes nos servidores");
	    }
	}catch(Exception e){
	    e.printStackTrace();
	}
	return rep;
    }

    
}
