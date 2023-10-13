package test;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObject.HomePage;

public class SearchAutomatizacion extends TestBase {


    HomePage hp;

    @Test
    public void searchAutomatizacionWord() throws InterruptedException {

        hp = new HomePage(driver);
        String word = "automatización";
        hp.fillSearchBox(word);
        Thread.sleep(2000);
        String page = hp.getWikipediaLink();
        Assert.assertEquals(page, "Automatización - Wikipedia, la enciclopedia libre");
        Thread.sleep(2000);




    }



}
