package br.com.chronosacademy.automacaoWeb;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.CursoPage;
import br.com.chronosacademy.pages.PrincipalPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

public class TesteWeb {
    //VARIÁVEIS GLOBAIS
    WebDriver driver;
    Driver driverWeb;
    PrincipalPage principalPage;     //instanciando a classe
    CursoPage cursoPage;

    @Before     //Abrindo o Navegador a cada Test
    public void inicializaTeste(){
        driverWeb = new Driver(Browser.CHROME);
        driver = Driver.getDriver();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver); //inicializando a Página
    }

    //@Test
    public void primeiroTeste(){
        String titulo = principalPage.getTitulo();

        assertEquals("Porque Tempo É Conhecimento", titulo);  //texto na página
    }

    @Test
    public void segundoTeste(){
        //cursoPage = principalPage.clickBotao();
        principalPage.clickBotao();
        cursoPage = new CursoPage(driver);
        String titulo = cursoPage.getTitulo2();

        assertEquals("AUTOMAÇÃO SEM COMPLICAÇÃO WEB 2.0", titulo);
    }
    @After
    public void finalizaTeste(){
        driver.quit();  // fechando o navegador e a sessão

    }
}