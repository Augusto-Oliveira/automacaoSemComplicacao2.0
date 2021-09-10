package br.com.chronosacademy.pages;

import br.com.chronosacademy.maps.PrincipalSissMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrincipalSissPage {
    private WebDriver driver;
    private PrincipalSissMap principalSissMap;

    public PrincipalSissPage(WebDriver driver) {
        this.driver = driver;
        principalSissMap = new PrincipalSissMap();
    }
    public void getBtnEntrar() {
        String xpathBotao = "//*[@id=\"btEntrar\"]";
        WebElement btnEntrar = driver.findElement(By.xpath(xpathBotao));
        btnEntrar.click(); //clicando no botão
    }

}
