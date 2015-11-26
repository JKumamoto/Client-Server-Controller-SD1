import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Server_Implementacao extends UnicastRemoteObject implements Server_Interface{

	public Server_Implementacao() throws RemoteException{
		super();
	}

	public Resposta Novo_arquivo(Requisicao req) throws RemoteException{
		Resposta rep=new Resposta();
		try{
			FileWriter fw=new FileWriter(req.get_nome_arquivo()+".txt");
			fw.write(req.get_conteudo());
			fw.close();
			rep.set_message_content(Resposta.ARQUIVO_ESCRITO_COM_SUCESSO);
		}catch(FileNotFoundException e){
			rep.set_message_content(Resposta.ARQUIVO_NAO_ESCRITO);
			System.out.println("Arquivo já existente");
		}catch(IOException e){
			System.out.println("Erro Interno");
			rep.set_message_content(Resposta.ARQUIVO_NAO_ESCRITO);
		}
		return rep;
	}

	public Resposta Pega_arquivo(Requisicao req) throws RemoteException{
		Resposta rep=new Resposta();
		try{
			int c;
			StringBuilder s=new StringBuilder("");
			FileReader fr=new FileReader(req.get_nome_arquivo()+"");
			while((c=fr.read())!=-1)
				s.append((char) c);

			fr.close();
			rep.set_message_content(Resposta.ARQUIVO_ENCONTRADO);
			rep.set_nome_arquivo(req.get_nome_arquivo());
			rep.set_arquivo(s.toString());
		}catch(FileNotFoundException e){
			rep.set_message_content(Resposta.ARQUIVO_NAO_ENCONTRADO);
		}catch(IOException e){
			System.out.println("Erro Interno");
			rep.set_message_content(Resposta.ARQUIVO_NAO_ENCONTRADO);
		}
		return rep;
	}

	public Resposta Lista_arquivo(Requisicao req) throws RemoteException{
		Resposta rep=new Resposta();
		File f=new File("/");
		String[] files=f.list();
		ArrayList<String> st=new ArrayList<String>(files.length);
		Collections.addAll(st, files);
		rep.set_message_content(Resposta.ARQUIVO_ENCONTRADO);
		rep.set_files(st);
		return rep;
	}
	
}