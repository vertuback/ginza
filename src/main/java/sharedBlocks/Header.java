package sharedBlocks;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPage;
import utils.Config;

import java.net.HttpURLConnection;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import java.net.HttpURLConnection;
import java.net.URL;

public class Header {

    private final SelenideElement txtSearchBox = $(By.cssSelector("#stSearch4_tbSearch"));
    private final SelenideElement btnSearch = $(By.cssSelector("#btnSearch"));
    private final SelenideElement lnkMainLogo = $(By.cssSelector("img[id='imgLogo']"));
    private final SelenideElement lnkLoggaIn = $(By.cssSelector("#ucLogin_hlLogin"));
    private final SelenideElement lnkRegistration = $(By.cssSelector("#a.icon-customer-service"));
    private final SelenideElement btnGoToCheckout = $(By.cssSelector("#ucProductCart_hplImgCheckout"));
    private final SelenideElement lnkMusicMenuItem = $(By.cssSelector("a#TopMenuCtrl1_rptMainMenu_hplCategory_0[title^=Musik]"));
    private final SelenideElement lnkFilmMenuItem = $(By.cssSelector("a#TopMenuCtrl1_rptMainMenu_hplCategory_0[title^=Film]"));
    private final SelenideElement lnkLoggaUt = $(By.cssSelector("a[onclick='Logout();']"));
    private final SelenideElement lnkGoToCheckout = $(By.cssSelector("a#ucProductCart_hplImgCheckout"));

    //login popup
    private final SelenideElement txtLogin = $(By.cssSelector("#LoginForm1_UserName"));
    private final SelenideElement txtPassword = $(By.cssSelector("#LoginForm1_Password"));
    private final SelenideElement btnLogin = $(By.cssSelector("#btnLogin"));
    private final SelenideElement lnkSkapaKonto = $(By.cssSelector("#LoginForm1_hlRegLink"));
    private final SelenideElement lnkDittLosenord = $(By.cssSelector("#rememberPass"));


    //basket
//    private final SelenideElement searchBox = $(By.cssSelector("#stSearch4_tbSearch"));
//    private final SelenideElement btnSearch = $(By.cssSelector("#stSearch4_btnSearch"));
//    private final SelenideElement lnkMainLogo = $(By.cssSelector("#logo a"));

    @Step("Open {url}")
    public Header openMainPage(String url){
        open(url);

        return this;
    }

    @Step("Fill smth in search")
    public Header setSmthInSearchBox(String text){
        txtSearchBox.setValue(text);
        btnSearch.click();
        return this;
    }
    @Step("Login as a regular user")
    public Header loginAsRegularUser(){
        if (!lnkMainLogo.isDisplayed()){
            open(Config.MAIN_URL);
        }
        for (int a = 0; a < 5; a++) {
           if (lnkLoggaIn.isDisplayed()){
               lnkLoggaIn.click();
               txtLogin.setValue(Config.REGULAR_USER_LOGIN);
               txtPassword.setValue(Config.REGULAR_USER_PASSWORD);
               btnLogin.click();
               break;
           }
           if (!lnkLoggaIn.isDisplayed() && !lnkLoggaUt.isDisplayed()){
                openMainPage(Config.MAIN_URL);
           }
           if (lnkLoggaUt.isDisplayed()){
                lnkLoggaUt.click();
           }
        }
        return this;
    }
    @Step("Login as a company user")
    public Header loginAsCompanyUser(){
        if (!lnkMainLogo.isDisplayed()){
            open(Config.MAIN_URL);
        }
        for (int a = 0; a < 5; a++) {
            if (lnkLoggaIn.isDisplayed()){
                lnkLoggaIn.click();
                txtLogin.setValue(Config.COMPANY_USER_LOGIN);
                txtPassword.setValue(Config.COMPANY_USER_PASSWORD);
                btnLogin.click();
                break;
            }
            if (!lnkLoggaIn.isDisplayed() && !lnkLoggaUt.isDisplayed()){
                openMainPage(Config.MAIN_URL);
            }
            if (lnkLoggaUt.isDisplayed()){
                lnkLoggaUt.click();
            }
        }
        return this;
    }
    @Step("Login as a random user")
    public Header loginAsRandomUser(String login, String password){
        if (!lnkMainLogo.isDisplayed()){
            open(Config.MAIN_URL);
        }
        for (int a = 0; a < 5; a++) {
            if (lnkLoggaIn.isDisplayed()){
                lnkLoggaIn.click();
                txtLogin.setValue(login);
                txtPassword.setValue(password);
                btnLogin.click();
                break;
            }
            if (!lnkLoggaIn.isDisplayed() && !lnkLoggaUt.isDisplayed()){
                openMainPage(Config.MAIN_URL);
            }
            if (lnkLoggaUt.isDisplayed()){
                lnkLoggaUt.click();
            }
        }
        return this;
    }
    @Step("Login as a random user")
    public void goToCheckout(){
        lnkGoToCheckout.click();
    }
}
