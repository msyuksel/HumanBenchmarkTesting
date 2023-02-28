package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AimTestPage {
    // This class has page objects/elements/methods and links related to the Typing Test Page
    // of the website
    // This will driver the driver.get method of getting to the main page.
    WebDriver driver;

    public AimTestPage(WebDriver driver) {
        // super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //return the array of keys

    @FindBy(css = "div[class='css-ad1j3y e6yfngs2']")
    WebElement StartTestBtn;


    public void DoAimTest() {
        StartTestBtn.click();
        ClickTargets();
        SaveScore();
    }
    public void ClickTargets() {
        while(driver.findElements(By.cssSelector("div[class='css-z6vxiy e6yfngs3']:nth-child(4)")).size() > 0){
            driver.findElement(By.cssSelector("div[class='css-z6vxiy e6yfngs3']:nth-child(4)")).click();
        }


    }

    public void SaveScore() {
        driver.findElement(By.cssSelector("button[class='css-qm6rs9 e19owgy710']")).click();
    }
}