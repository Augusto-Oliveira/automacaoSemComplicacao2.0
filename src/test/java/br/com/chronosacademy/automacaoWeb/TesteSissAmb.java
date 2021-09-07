package br.com.chronosacademy.automacaoWeb;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.PrincipalSissPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.LinkedHashMap;

public class TesteSissAmb {
    Driver driverWeb;
    WebDriver driver;
    PrincipalSissPage principalSissPage;

    @Before     //Abrindo o Navegador a cada Test
    public void inicializaTeste(){
        driverWeb = new Driver(Browser.CHROME);
        driver = driverWeb.getDriver();
        driver.get("http://qualidade.manutencao.sissonline.com.br/");
        principalSissPage = new PrincipalSissPage(driver);

        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 1030));
        driver.manage().window().setPosition(new Point(1280, 0));

        driver.get("https://qualidade.sissonline.com.br/");
        */
    }

    @Test
    public void efetuarLogon() throws InterruptedException {
        String usuarioTexto = "985785826";
        String senhaTexto = "Luiza7anos";

        WebElement campoCard = driver.findElement(By.id("txtCardNumber"));
        campoCard.sendKeys(usuarioTexto);
        WebElement campoSenha = driver.findElement(By.id("txtSenha"));
        campoSenha.sendKeys(senhaTexto);

        // clicando no botão Entrar
        /*String xpathBotao = "//*[@id=\"btEntrar\"]";
        WebElement btnEntrar = driver.findElement(By.xpath(xpathBotao));
        btnEntrar.click(); //clicando no botão
        */
        principalSissPage.getBtnEntrar();
        //aqui utilizando PAGEs para as ações

        //Finalizando o login com o Challenge
        String xpathChallenge = "//*[@id=\"ChallengeFields\"]/div/span";
        Thread.sleep(2000);
        WebElement idChallenge = driver.findElement(By.xpath(xpathChallenge));
        WebElement result = driver.findElement(By.id("txt_:_0"));
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("1:A", "v"); map.put("1:B", "6"); map.put("1:C", "E"); map.put("1:D", "8");
        map.put("2:A", "V"); map.put("2:B", "T"); map.put("2:C", "j"); map.put("2:D", "7");
        map.put("3:A", "M"); map.put("3:B", "v"); map.put("3:C", "N"); map.put("3:D", "1");
        map.put("4:A", "q"); map.put("4:B", "A"); map.put("4:C", "1"); map.put("4:D", "n");
        result.sendKeys(map.get(idChallenge.getText()));

        //Após inserir o Challenge clicar em Entrar
        principalSissPage.getBtnEntrar(); //clicando no botão Entrar no SISS
        }

    /*@Test
    public void selecionaUnidade() {
        String ubsUnidade = "UBS PONTE GRANDE";
        String xpathUnidade = "//*[@id=\"_div\"]/input";
        WebElement unidade = driver.findElement(By.xpath(xpathUnidade));
        unidade.sendKeys(ubsUnidade);
    }*/
}