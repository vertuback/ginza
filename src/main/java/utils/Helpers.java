package utils;
import io.qameta.allure.Step;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


public class Helpers {
    public int getStatus(String url, int i){
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)url1.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            System.out.println("Code for "+url+" is " +connection.getResponseCode());
            i = connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    public String generateRandomLetter()
    {
        Random r = new Random();
        char a = (char)(r.nextInt(26) + 'a');
        String c = Character.toString(a);
        return c;
    }
    public void checkThatSiteIsOpened()
    {
        if (!url().contentEquals("test.24") || !url().contentEquals("ginza.se") || !url().contentEquals("test.17") || !url().contentEquals("test.14")){
            open(Config.MAIN_URL);
        }
    }
}
