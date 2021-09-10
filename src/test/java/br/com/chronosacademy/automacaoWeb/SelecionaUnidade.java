package br.com.chronosacademy.automacaoWeb;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.PrincipalSissPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelecionaUnidade {
    Driver driverWeb;
    WebDriver driver;
    PrincipalSissPage principalSissPage;

   @Before     //Abrindo o Navegador na segunda página
    public void abreTelaUnidades(){
       driverWeb = new Driver(Browser.CHROME);
       driver = driverWeb.getDriver();
       driver.get("https://qualidade.sissonline.com.br/unidades");
       //principalSissPage = new PrincipalSissPage(driver);

        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 1030));
        driver.manage().window().setPosition(new Point(1280, 0));

        driver.get("/unidades");
        */
    }

    @Test
    public void selecionaUnidade(){

        String ubsUnidade = "UBS PONTE GRANDE";
        String xpathUnidade = "//*[@id=\"_div\"]/input";
        WebElement unidade = driver.findElement(By.xpath(xpathUnidade));
        unidade.sendKeys(ubsUnidade);

    }

}
   /* @After   //fecha o navegador a cada Test dentro do projeto
    public void finalizaTeste(){
        navegador.quit();  // fechando o navegador e a sessão
    }*/
