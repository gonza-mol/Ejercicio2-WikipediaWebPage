package pageObject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy(css= "#APjFqb")
    WebElement searchBox;

    @FindBy(css= "#rso>div:nth-child(4) span > a > h3")
    WebElement linkWikipedia;



    public HomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
    }

    public void fillSearchBox(String word) throws InterruptedException {
        searchBox.sendKeys(word);
        Thread.sleep(1000);
        searchBox.sendKeys(Keys.RETURN);
    }

    public String getWikipediaLink() throws InterruptedException {
        List<WebElement> links = driver.findElements(By.cssSelector("#rso span > a > h3"));
        for (WebElement link: links){
            if (link.getText().equalsIgnoreCase("Automatización - Wikipedia, la enciclopedia libre")){
                Thread.sleep(1000);
                link.click();
                break;
            }
        }
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenShot, new File("Image"+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }
}

