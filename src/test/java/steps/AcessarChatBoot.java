package steps;

import br.com.bb.ath.ftabb.utilitarios.FTABBUtils;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.ChatbotPage;

public class AcessarChatBoot extends FTABBUtils{
	
	public ChatbotPage page = new ChatbotPage();
	
	@Dado("^que acesso o chatBot da Norminha com usuario \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void queAcessoOChatBotDaNorminhaComUsuarioESenha(String usuario, String senha) throws Exception {
		page.acessarChatBot(usuario, senha);
	}

	@Quando("^seleciono no menu do chat o assunto \"([^\"]*)\"$")
	public void queSelecionoNoMenuOChatOAssunto(String assunto) throws Exception {
	    page.acessarAssunto(assunto);
	    
	}

	@Quando("^escrevo \"([^\"]*)\" no chat e envio$")
	public void escrevoNoChatEEnvio(String msg) throws Exception {
	    page.enviarNoChatBot(msg);
	   
	}

	@Então("^a norminha me responde \"([^\"]*)\"$")
	public void aNorminhaMeResponde(String text) throws Exception {
	    page.validarRespostaNorminha(text);
	}
	
}
