/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author jefferson.kumamoto
 */
public class Servidor {

    public static void main(String[] args) {
        try{
            ServerSocket server;
            server=new ServerSocket(9000);
            System.out.println("Server Started at 9000... Waiting for connections");
            HashMap<String, String> map=new HashMap<String, String>();
            while(true){
                Socket client=server.accept();
                System.out.println("Connection accepted "+client.getInetAddress().getHostAddress());
                Resposta rep=new Resposta();
                ObjectInputStream input=new ObjectInputStream(client.getInputStream());
                Requisicao req=new Requisicao();
                switch(req.get_message_content()){
                    case Requisicao.NOVO_ARQUIVO: System.out.println("Novo arquivo requisitado por: "+client.getInetAddress().getHostAddress());
                                    map.put(req.get_nome_arquivo(), req.get_conteudo());
                                    System.out.println("Novo arquivo criado com sucesso");
                                    rep.set_message_content(Resposta.ARQUIVO_ESCRITO_COM_SUCESSO); break;
                    case Requisicao.PEGA_ARQUIVO: rep.set_nome_arquivo(req.get_nome_arquivo());
                                            rep.set_arquivo(map.get(req.get_nome_arquivo()));
                                    System.out.println("Arquivo encontrado com sucesso"); break;
                    default: System.out.println("Fudeu..");
                             rep.set_message_content(-3); break;
                }
                ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(rep);
                
                output.close();
                input.close();
                client.close();
            }
            //server.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
