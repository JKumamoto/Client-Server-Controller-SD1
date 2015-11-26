import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server_Interface extends Remote{
	public Resposta Novo_arquivo(Requisicao req) throws RemoteException;
	public Resposta Pega_arquivo(Requisicao req) throws RemoteException;
	public Resposta Lista_arquivo(Requisicao req) throws RemoteException;
}