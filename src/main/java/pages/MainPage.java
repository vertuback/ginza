package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import sharedBlocks.Header;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends Header {

    @Step("Open {url}")
    public MainPage openMainPage(String url){
        open(url);
        return this;
    }
    @Step("Fill smth in search")
    public MainPage fillSmthInSearch(String searchQuery){
        new Header().setSmthInSearchBox(searchQuery);
        return this;
    }
    @Step("Add random product to card")
    public MainPage addRandomProductToCard(String searchQuery)
    {
        fillSmthInSearch(searchQuery);
        return this;
    }

}
