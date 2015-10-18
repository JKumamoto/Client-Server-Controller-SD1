import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Servidor {

	private static HashMap<String, String> map=new HashMap<String, String>();

	public static void main(String[] args) {
		try{
			ServerSocket server;
			server=new ServerSocket(9000);
			System.out.println("Server Started at 9000... Waiting for connections");
			rodando(server);
			//server.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void rodando(ServerSocket server) throws Exception{
		while(true){
			Socket client=server.accept();
			System.out.println("Connection accepted "+client.getInetAddress().getHostAddress());
			Resposta rep=new Resposta();
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
				if(map.containsKey(req.get_nome_arquivo())){
					rep.set_message_content(Resposta.ARQUIVO_NAO_ESCRITO);
					System.out.println("Arquivo já existente");
				}else{
					map.put(req.get_nome_arquivo(), req.get_conteudo());
					System.out.println("Novo arquivo criado com sucesso");
					rep.set_message_content(Resposta.ARQUIVO_ESCRITO_COM_SUCESSO);
				}
				break;
			case Requisicao.PEGA_ARQUIVO:
				String arq=map.get(req.get_nome_arquivo());
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
			default: 
				System.out.println("Erro desconhecido");
				rep.set_message_content(0);
				break;
		}
		return rep;
	}

}
