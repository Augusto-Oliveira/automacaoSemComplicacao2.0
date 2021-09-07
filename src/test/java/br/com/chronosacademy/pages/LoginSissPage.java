package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.LoginSissMap;
import org.openqa.selenium.support.PageFactory;

public class LoginSissPage {
    LoginSissMap loginSissMap;

    public LoginSissPage(){
        loginSissMap = new LoginSissMap();
        PageFactory.initElements(Driver.getDriver(), loginSissMap);
    }

    public void getBtnEntrar(){
        loginSissMap.btnEntrar.click();
    }


}
