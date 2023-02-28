package pageobjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AimTestPage extends AbstractComponent {
    // This class has page objects/elements/methods and links related to the Typing Test Page
    // of the website
    // This will driver the driver.get method of getting to the main page.
    WebDriver driver;

    public AimTestPage(WebDriver driver) {
         super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //return the array of keys

    @FindBy(css = "div[class=\"css-ad1j3y e6yfngs2\"]")
    WebElement StartTestBtn;


    public void DoAimTest() {
        waitForWebElementToBeClickable(StartTestBtn);
        Actions actions = new Actions(driver);
        actions.moveToElement(StartTestBtn).click().build().perform();
        ClickTargets();
        SaveScore();
    }
    public void ClickTargets() {
        for(int i = 0; i <30; i++){
            waitForWebElementToAppear(driver.findElement(By.cssSelector("div[class='css-z6vxiy e6yfngs3']:nth-child(4)")));
            WebElement target = driver.findElement(By.cssSelector("div[class='css-z6vxiy e6yfngs3']:nth-child(4)"));
            Actions actions = new Actions(driver);
            actions.moveToElement(target).click().build().perform();

        }


    }

    public void SaveScore() {

        driver.findElement(By.cssSelector("button[class='css-qm6rs9 e19owgy710']")).click();
    }
    public void goTo() {
        driver.get("https://humanbenchmark.com/tests/aim");
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        AimTestPage aimTestPage = new AimTestPage(driver);
        aimTestPage.goTo();
        aimTestPage.DoAimTest();
    }
}