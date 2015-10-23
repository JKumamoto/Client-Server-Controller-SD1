import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MainController {

	public static void main(String[] args) {
		try{
				ServerSocket server = new ServerSocket(9000);
				System.out.println("Entrou");
				Socket _server1, _server2, _server3;
				
				do{
					Socket client = server.accept();
					
					client.setKeepAlive(true);
					ObjectInputStream in = new ObjectInputStream(client.getInputStream());
					
					Requisicao in_req = (Requisicao) in.readObject();
					
					_server1 = new Socket("localhost", 9500);
					_server2 = new Socket("localhost", 9501);
					_server3 = new Socket("localhost", 9502);
					
					_server1.setKeepAlive(true);
					_server2.setKeepAlive(true);
					_server3.setKeepAlive(true);
					
					ObjectOutputStream output1 = new ObjectOutputStream(_server1.getOutputStream());
					ObjectOutputStream output2 = new ObjectOutputStream(_server2.getOutputStream());
					ObjectOutputStream output3 = new ObjectOutputStream(_server3.getOutputStream());
					
					output1.writeObject(in_req);
					output2.writeObject(in_req);
					output3.writeObject(in_req);
					
					ObjectInputStream input1 = new ObjectInputStream(_server1.getInputStream());
					ObjectInputStream input2 = new ObjectInputStream(_server2.getInputStream());
					ObjectInputStream input3 = new ObjectInputStream(_server3.getInputStream());
					
					Resposta resposta1 = (Resposta)input1.readObject();
					Resposta resposta2 = (Resposta)input2.readObject();
					Resposta resposta3 = (Resposta)input3.readObject();
					
					ObjectOutputStream output_cli = new ObjectOutputStream(client.getOutputStream());
					
					output_cli.writeObject(resposta1);
					
					output_cli.close();
					output1.close();
					output2.close();
					output3.close();
					input1.close();
					input2.close();
					input3.close();
					in.close();					
					
				}while(true);
			
		}catch (Exception e) {
			
		}

	}

}
