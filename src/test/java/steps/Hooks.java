package steps;

import static utils.Utils.addEnvironmentAllure;

import atu.testrecorder.ATUTestRecorder;
import br.com.bb.ath.ftabb.utilitarios.FTABBUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.PlataformaPage;
import utils.Utils;


public class Hooks extends FTABBUtils {
	
	ATUTestRecorder gravar;

	@Before
	public void setUp(Scenario cenario) throws Exception {
		PlataformaPage plataformaPage = new PlataformaPage();
		gravar = new ATUTestRecorder("target/Videos", cenario.getName(), false);
		gravar.start();
		plataformaPage.acessarPlataforma();
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		Utils.capturarScreenshot(scenario);
		Utils.capturarScreenshot();
		gravar.stop();
		addEnvironmentAllure();
	}

}
