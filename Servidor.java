import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	private static ArrayList<String> files = new ArrayList<String>();
	public static void main(String[] args) {
		try{
			ServerSocket server;
			server=new ServerSocket(Integer.valueOf(args[0]));
			System.out.println("Server Started at "+args[0]+"... Waiting for connections");
			rodando(server);
			//server.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void rodando(ServerSocket server) throws Exception{
		while(true){
			Socket client=server.accept();
			client.setKeepAlive(true);
			System.out.println("Connection accepted "+client.getInetAddress().getHostAddress());
			ObjectInputStream input=new ObjectInputStream(client.getInputStream());
			Requisicao req = (Requisicao)input.readObject();
			Resposta resposta=cases(req, client);
			ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
			output.writeObject(resposta);
			
			output.close();
			input.close();
			client.close();
		}
	}
	
	private static Resposta cases(Requisicao req, Socket client){
		Resposta rep=new Resposta();
		switch(req.get_message_content()){
			case Requisicao.NOVO_ARQUIVO: 
				System.out.println("Novo arquivo requisitado por: "+client.getInetAddress().getHostAddress());
				if(files.contains(req.get_nome_arquivo())){
					rep.set_message_content(Resposta.ARQUIVO_NAO_ESCRITO);
					System.out.println("Arquivo já existente");
				}else{
					files.add(req.get_nome_arquivo());
					try {
						PrintWriter out = new PrintWriter(req.get_nome_arquivo()+".txt");
						out.println(req.get_conteudo());
						out.close();
					} catch (FileNotFoundException e) {
						rep.set_message_content(Resposta.ARQUIVO_NAO_ENCONTRADO);
						System.out.println("Arquivo nao encontrado ");
					}
				
					System.out.println("Novo arquivo criado com sucesso");
					rep.set_message_content(Resposta.ARQUIVO_ESCRITO_COM_SUCESSO);
				}
				break;
			case Requisicao.PEGA_ARQUIVO:				
				String arq = null;
				try {
					arq = new Scanner(new File(req.get_nome_arquivo()+".txt")).useDelimiter("\\A").next();
				} catch (FileNotFoundException e) {
					System.out.println("Arquivo nao encontrado");
				}
					if(arq==null){
					rep.set_message_content(Resposta.ARQUIVO_NAO_ENCONTRADO);
					System.out.println("Arquivo não encontrado");
				}else{
					rep.set_message_content(Resposta.ARQUIVO_ENCONTRADO);
					rep.set_nome_arquivo(req.get_nome_arquivo());
					rep.set_arquivo(arq);
					System.out.println("Arquivo encontrado com sucesso");
				}
				break;
			case Requisicao.MUDA_ARQUIVO:                                
				arq="";
                                try {
					arq = new Scanner(new File(req.get_nome_arquivo()+".txt")).useDelimiter("\\A").next();
				} catch (FileNotFoundException e) {
					System.out.println("Arquivo nao encontrado");
				}
				    if(arq==null){
					rep.set_message_content(Resposta.ARQUIVO_NAO_ENCONTRADO);
					System.out.println("Arquivo não encontrado");
				}else{                                        
                                        try {
                                            File file = new File(req.get_nome_arquivo()+".txt");
                                            PrintWriter out = new PrintWriter(file);
                                            out.println(req.get_conteudo());
                                            out.close();
                                            
                                            rep.set_message_content(Resposta.ARQUIVO_ENCONTRADO);
                                            rep.set_nome_arquivo(req.get_nome_arquivo());
                                            rep.set_arquivo(req.get_conteudo());

                                            System.out.println("Conteudo a mudar:"+req.get_conteudo());
                                            System.out.println("Arquivo modificado com sucesso");
                                            
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        
					
				}
				break;
			case Requisicao.LISTA_ARQUIVO:
				if(files.isEmpty())
				{
					rep.set_message_content(Resposta.ARQUIVO_NAO_ENCONTRADO);
				}
				else
				{
					rep.set_files(files);
					rep.set_message_content(Resposta.ARQUIVO_ENCONTRADO);
				}                        
                            
			default: 
				System.out.println("Erro desconhecido");
				rep.set_message_content(0);
				break;
		}
		return rep;
	}

}
