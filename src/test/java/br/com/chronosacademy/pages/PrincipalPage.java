package br.com.chronosacademy.pages;

import br.com.chronosacademy.maps.PrincipalMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PrincipalPage {  //PARA CRIAR CONSTRUTOR > BOTAO DIREITO > GENERATE >
    private WebDriver driver;
    private PrincipalMap principalMap;

    public PrincipalPage(WebDriver driver) {
         this.driver = driver;
         principalMap = new PrincipalMap();
        PageFactory.initElements(driver, principalMap);
    }

    public String getTitulo() {
        //String xpathTitulo = "//section[2]//h4";  //caminho sem os elementos a mais
        //WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));  // criei o elemento
        return principalMap.txtTitulo.getText();

    }

    public void clickBotao() {
        //String xpathBotao = "//section[2]/div[3]//a";
        //WebElement btnTitulo = driver.findElement(By.xpath(xpathBotao));  // criei o elemento
        principalMap.btnTitulo.click(); //clicando no elemento encontrado
    }

}