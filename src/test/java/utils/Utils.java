package utils;

import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.bb.ath.ftabb.FTABBContext;
import cucumber.api.Scenario;
import io.qameta.allure.Allure;

public class Utils {

	public static WebDriver driver() {
		WebDriver driver = null;
		driver = (WebDriver) FTABBContext.getContext().getBrowserModule().getBrowserDriver().getDriver();
		return driver;
	}
	
	public static void esperarPagina(int tempo) throws Exception {
		for (int i = 0; i < tempo; i++) {
			Thread.sleep(1000);
		}
	}
	
	public static void aguardarVisibilidade(Boolean visibilidade, Integer tempoEspera, String valorXpath)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver(), tempoEspera);

		if (visibilidade = true) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(valorXpath)));
		} else {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(valorXpath)));
		}

	}

	public static void limparCache() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_DELETE);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void paginaContemTexto(String text) throws Exception {
		esperarPagina(2);
		boolean existe = driver().getPageSource().contains(text);
		if (existe == false) {
			System.out.println("Não encontrei a String: " + text);
		}
		assertTrue(existe);

	}

	public static boolean textoExiste(String texto) {
		return driver().getPageSource().contains(texto);

	}

	public static void capturarScreenshot() {
		File imagem = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
		try {
			Allure.addAttachment("Screenshot", Files.newInputStream(Paths.get(imagem.getPath())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void capturarScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");

		File imagem = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem,
					(new File("./target/allure-reports", scenario.getName() + " - " + scenario.getStatus() + ".png")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String gerarNumerosAleatorios(int qtdDigitos) {
		String numero = Double.toString(Math.random());
		return numero.substring(3, qtdDigitos + 3);
	}

	public static void aceitarAlertaJavascript() {
		Alert alt = driver().switchTo().alert();
		alt.accept();
	}

	public static void cancelarAlertaJavascript() {
		Alert alt = driver().switchTo().alert();
		alt.dismiss();
	}

	public static void movimentarScroll(String pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver();
		js.executeScript("window.parent.scrollTo(0," + pixels + ");", "0");
	}

	public static boolean elementoExiste(String elemento) {
		boolean existe = false;
		try {
			existe = Utils.driver().findElement(By.xpath(elemento)).isEnabled();
		} catch (NoSuchElementException e) {
			existe = false;
		}
		return existe;
	}

	public static void moverMouse() throws Exception {
		Robot robot = new Robot();
		robot.mouseMove(+400, +100);
		robot.mouseMove(-400, -100);
	}

	public static void atualizarPagina() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);
		Thread.sleep(10000);
	}

	public static void moverMousePara(String xPath) throws Exception {
		Actions acao = new Actions(driver());
		acao.moveToElement(driver().findElement(By.xpath(xPath))).build().perform();
	}

	public static WebElement findElement(String xPath) {
		WebDriverWait wait = new WebDriverWait(driver(), 20);
		return wait.until(ExpectedConditions.visibilityOf(driver().findElement(By.xpath(xPath))));
	}

	public static List<WebElement> findElements(String xPath) {
		return driver().findElements(By.xpath(xPath));
	}

	public static void dobleClick(String xPath) {
		(new Actions(driver())).doubleClick(findElement(xPath)).build().perform();
	}

	public static void scrollByElement(WebElement elemento) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver();
		js.executeScript("arguments[0].scrollIntoView();", elemento);
	}

	public static void addEnvironmentAllure() {
		try {
			File env = new File("./target/allure-reports/environment.properties");
			BufferedWriter as = new BufferedWriter(new FileWriter(env));
			as.write("Navegador = Firefox Versao 68");
			as.newLine();
			as.write("Aplicacaoo = ChatBot Norminha");
			as.newLine();
			as.write("Ambiente = Prod");
			as.newLine();
			as.write("Sistema Operacional = " + System.getProperty("os.name").toLowerCase());
			as.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public static void focoEmOutraJanela() {
		for(String winHandle : Utils.driver().getWindowHandles()){
		    driver().switchTo().window(winHandle);
		}
	}
	
		public static void janelaPrincipal() {
		String mainWindow = Utils.driver().getWindowHandle();
		Utils.driver().switchTo().window(mainWindow);

	}
	
		public static String getUrl() {
		return Utils.driver().getCurrentUrl();
	}
	
		public static void fecharJanelaAtual() {
		Utils.driver().close();
	}

	public static int quantidadeDejanelas() {
		return Utils.driver().getWindowHandles().size();
	}

}
