package OpenCart_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;
    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    By usernamelocator=By.xpath("//*[@id=\"input-email\"]");
    By passwordlocator=By.xpath("//*[@id=\"input-password\"]");
    By loginbutlocator=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
    By forgotpwdlocator=By.xpath("//*[@id=\"column-right\"]/div/a[3]");

    public void enter_username(String user){
        WebElement username=ldriver.findElement(usernamelocator);
        username.clear();
        username.sendKeys(user);
    }
    public void enter_pwd(String pass){
        WebElement pwd=ldriver.findElement(passwordlocator);
        pwd.clear();
        pwd.sendKeys(pass);
    }
    public void click_login(){
        ldriver.findElement(loginbutlocator).click();
    }
    public void click_forgotpwd(){
        ldriver.findElement(forgotpwdlocator).click();
    }


}
