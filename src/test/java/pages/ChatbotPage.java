package pages;

import br.com.bb.ath.ftabb.Pagina;
import br.com.bb.ath.ftabb.anotacoes.MapearElementoWeb;
import br.com.bb.ath.ftabb.elementos.ElementoBotao;
import br.com.bb.ath.ftabb.elementos.ElementoInput;
import utils.Utils;

public class ChatbotPage extends Pagina {
	PlataformaPage LoginPage = new PlataformaPage();
	
	@MapearElementoWeb(xPath = "//input[@id = 'txtChave' or @id = 'chave' or @id = 'idToken1']")
	private ElementoInput campoLogin;

	@MapearElementoWeb(xPath = "//input[@id = 'txtSenha' or @id = 'senha' or @id = 'idToken2']")
	private ElementoInput campoSenha;

	@MapearElementoWeb(xPath = "//input[@class = 'button' or @id = 'entrar' or @id = 'loginButton_0']")
	private ElementoBotao botaoEntrar;
	
	@MapearElementoWeb(xPath = "//input[@id='input-01']")
	public ElementoInput inputBuscar;
	
	@MapearElementoWeb(xPath = "//li[1]")
	public ElementoBotao btnAcessarAssunto;
	
	@MapearElementoWeb (xPath = "//textarea[@placeholder='Informe a pergunta desejada...']")
	public ElementoInput inputChat;
	
	public void acessarChatBot(String user, String senha) throws Exception {
		campoLogin.escrever(user);
		campoSenha.escrever(senha);
		botaoEntrar.clicar();
	}

	public void acessarAssunto(String assunto) throws Exception {
		Utils.aguardarVisibilidade(true, 15, "//li[1]");
		inputBuscar.escrever(assunto);
		btnAcessarAssunto.clicar();	
		//System.out.println(inputChat.quantosExistem());
	}
	
	public void enviarNoChatBot(String msg) throws Exception {
		Utils.aguardarVisibilidade(true, 5, "//textarea[@placeholder='Informe a pergunta desejada...']");
		inputChat.escreverEPressionarEnter(msg);
	}
	
	public void validarRespostaNorminha(String text) throws Exception {
		Utils.paginaContemTexto(text);
	}
	
	
}
