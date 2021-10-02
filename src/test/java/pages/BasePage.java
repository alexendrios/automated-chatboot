package pages;

import br.com.bb.ath.ftabb.Pagina;
import br.com.bb.ath.ftabb.anotacoes.MapearElementoWeb;
import br.com.bb.ath.ftabb.elementos.ElementoLink;

public class BasePage extends Pagina {

	@MapearElementoWeb(xPath = "//a")
	public ElementoLink linkGenerico;
	
	
}
