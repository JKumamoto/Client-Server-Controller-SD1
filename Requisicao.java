import java.io.Serializable;


public class Requisicao implements Serializable {
	
	public static final int NOVO_ARQUIVO  = 0;
	public static final int PEGA_ARQUIVO  = 1;
	public static final int LISTA_ARQUIVO = 2;
        public static final int MUDA_ARQUIVO = 3;
	
	private String _conteudo;
	private String _nome_arquivo;
	private int    _message_content;
	
        public Requisicao(){
            
        }
        
	public String get_conteudo() {
		return _conteudo;
	}
	public void set_conteudo(String _conteudo) {
		this._conteudo = _conteudo;
	}
	public String get_nome_arquivo() {
		return _nome_arquivo;
	}
	public void set_nome_arquivo(String _nome_arquivo) {
		this._nome_arquivo = _nome_arquivo;
	}
	public int get_message_content() {
		return _message_content;
	}
	public void set_message_content(int _message_content) {
		this._message_content = _message_content;
	}
	
	
	

}
