import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sharedBlocks.Header;
import utils.Config;
import utils.Helpers;


import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;


public class Tests extends Helpers {
    WebDriver driver;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().version("79.0.3945.36").setup();
        open(Config.MAIN_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    public void RegularUserLogin() {
        new Header().loginAsUser(Config.REGULAR_USER_LOGIN, Config.REGULAR_USER_PASSWORD);

    }

    @Test
    public void CompanyUserLogin() {
        new Header().loginAsUser(Config.COMPANY_USER_LOGIN, Config.COMPANY_USER_PASSWORD);
    }

    @Test
    public void UserCanSearch(){
//        new MainPage().fillSmthInSearch("abba");
//        new SearchPage().checkThatSearchPageIsLoading();
        open(Config.MAIN_URL+"music");
    }
    //@Test
    public void OpenAllTypesOfPages(){
        Assert.assertEquals(getStatus(Config.MAIN_URL, 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"Musik/2", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"Hem%20%26%20Hush%c3%a5ll/S%c3%a4kerhet%20%26%20%c3%b6vervakning/6", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"topplista", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"kundservice/templ_kontakta3", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"product/abba/the-albums-1973-82/235095/", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"artist/abba/24350", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"director/ol-parker/398519", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"manufacturer/samsung/73492", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"alla-kampanjer", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"111", 0), 404);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"checkout", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"orderinfo/077033093016052026154135200168052226102189074019", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"order", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"present", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"catalog/OrderCatalog3.aspx", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"profile", 0), 200);
        Assert.assertEquals(getStatus(Config.MAIN_URL+"error/errorpage3.aspx?errorcode=404", 0), 404);

    }
    @Test
    public void addRandomProductToBasketAndCheckThePriceInBasketAndCheckout(){

        open("https://www.ginza.se/");
//        new SearchPage().addRandomProductFromSearchToCart();
//        Assert.assertEquals(new Checkout().getSubtotalPriceValue(), new Checkout().getPriceOfProducteValue());
//        Assert.assertEquals(new Checkout().getDeliveryPriceValue(), 39);
//        Assert.assertEquals(new Checkout().getSubtotalPriceValue() + 39, new Checkout().getTotalPriceValue());
    }
    @AfterClass
    public void tearDown() {
        close();
    }
}
