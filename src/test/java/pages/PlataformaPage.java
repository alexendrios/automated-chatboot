package pages;

import br.com.bb.ath.ftabb.FTABBContext;
import br.com.bb.ath.ftabb.exceptions.ElementoNaoLocalizadoException;
import br.com.bb.ath.ftabb.utilitarios.FTABBUtils;

public class PlataformaPage extends FTABBUtils {
	
	public void acessarPlataforma() throws ElementoNaoLocalizadoException {
		// Plataforma.abrirUrl("https://plataforma.atendimento.bb.com.br");
		FTABBContext contexto = FTABBContext.getContext();
		contexto.boot();
		contexto.getBrowserModule().getWebActions().abrirUrl("https://plataforma.atendimento.bb.com.br:49286/estatico/nia-cognitivo-estatico-chat-plt-3/app/spas/chat-cognitivo/chat-cognitivo.app.html");
		//Utils.aguardarVisibilidade(true, 15, "//input[@id = 'txtChave' or @id = 'chave' or @id = 'idToken1']");
	}

}
