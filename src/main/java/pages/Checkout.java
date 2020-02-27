package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import sharedBlocks.Header;
import utils.Helpers;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Checkout {

    private final SelenideElement smokeFullPriceInCheckout = $(By.cssSelector("td#totalPriceFullCart"));
    private final SelenideElement smokeSubtotalPriceValue = $(By.cssSelector("td[class='tdSumma']"));
    private final SelenideElement smokeDeliveryPriceInCheckout = $(By.cssSelector(".trFee > td:nth-child(2)"));
    private final SelenideElement smokePriceOfProductInCheckout = $(By.cssSelector("span[class='price']"));


    public int cleanPrice(String dirtyPrice){
        String a = dirtyPrice.replaceAll("[^A-Za-z0-9]", " ");
        int result = Integer.parseInt(a);
        return result;
    }
    public int getTotalPriceValue(){
        return cleanPrice(smokeFullPriceInCheckout.getText());
    }
    public int getSubtotalPriceValue(){
        return cleanPrice(smokeSubtotalPriceValue.getText());
    }
    public int getDeliveryPriceValue(){
        return cleanPrice(smokeDeliveryPriceInCheckout.getText());
    }
    public int getPriceOfProducteValue(){
        return cleanPrice(smokePriceOfProductInCheckout.getText());
    }

}
