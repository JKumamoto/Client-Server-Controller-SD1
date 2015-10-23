import java.io.Serializable;
import java.util.ArrayList;



public class Resposta implements Serializable{
	
	public static final int ARQUIVO_ENCONTRADO = 1;
	public static final int ARQUIVO_NAO_ENCONTRADO = -1;
	public static final int ARQUIVO_ESCRITO_COM_SUCESSO = 2;
	public static final int ARQUIVO_NAO_ESCRITO = -2;
	
	private String 			  _arquivo;
	private ArrayList<String> _files;
	private String            _nome_arquivo;
	private int               _message_content;
	
        public Resposta(){
            
        }

	public int get_message_content() {
		return _message_content;
	}
	public void set_message_content(int _message_content) {
		this._message_content = _message_content;
	}
	public String get_arquivo() {
		return _arquivo;
	}
	public void set_files(ArrayList<String> _files)
	{
		this._files = _files;
	}
	
	public ArrayList<String> get_files() {
		return _files;
	}

	public void set_arquivo(String _arquivo) {
		this._arquivo = _arquivo;
	}
	public String get_nome_arquivo() {
		return _nome_arquivo;
	}
	public void set_nome_arquivo(String _nome_arquivo) {
		this._nome_arquivo = _nome_arquivo;
	}

}
