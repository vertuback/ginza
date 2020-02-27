package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import sharedBlocks.Header;
import utils.Helpers;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage extends Helpers {

    private final SelenideElement btnAddProductToCartFromList = $(By.cssSelector(".product_details-holder > a[onclick*='AddToCartProduct']"));


    @Step("Open {url}")
    public SearchPage openMainPage(String url){
        open(url);
        return this;
    }
    @Step("Fill smth in search")
    public SearchPage checkThatSearchPageIsLoading()
    {
        if (btnAddProductToCartFromList.exists()){
            System.out.println("Element is Present");
        }
        else{
            System.out.println("Element is Absent");
        }

        return this;
    }

    @Step("Add random product from search")
    public SearchPage addRandomProductFromSearchToCart()
    {
        new Header().setSmthInSearchBox(generateRandomLetter());
        checkThatSearchPageIsLoading();
        btnAddProductToCartFromList.click();
        new Header().goToCheckout();

        return this;
    }




}
