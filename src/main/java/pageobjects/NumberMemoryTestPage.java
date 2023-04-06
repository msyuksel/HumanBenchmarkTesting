package pageobjects;
import org.openqa.selenium.Keys;


import abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NumberMemoryTestPage extends AbstractComponent {
    // This class has page objects/elements/methods and links related to the Typing Test Page
    // of the website
    // This will driver the driver.get method of getting to the main page.
    WebDriver driver;

    public NumberMemoryTestPage(WebDriver driver) {
         super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //return the array of keys

    @FindBy(css = "button[class=\"css-de05nr e19owgy710\"]")
    WebElement StartTestBtn;
    @FindBy(css = "div[class=\"big-number\"]")
    WebElement CorrectNumber;
    @FindBy(css = "input[pattern]")
    WebElement TextBox;

    public void correctlyAnswerLevels() throws InterruptedException {
        Thread.sleep(1000);
//        WebElement CorrectNumber1 = driver.findElement(By.cssSelector("div[class=\"big-number\"]"));
//        System.out.println(CorrectNumber1.getAttribute("textContent"));
//        This test is currently failing because the number is not being read correctly from the web element CorrectNumber
        String number = CorrectNumber.getAttribute("innerHTML");
        typeInNumber(number);
        }

    public void typeInNumber(String num) throws InterruptedException {
        Actions goNext = new Actions(driver);
        goNext.sendKeys(TextBox, num);
        goNext.sendKeys(Keys.ENTER);
        goNext.sendKeys(Keys.ENTER);
        goNext.perform();
    }
    public void startTest(){
        StartTestBtn.click();
    }

    public void SaveScore() {

        driver.findElement(By.cssSelector("button[class='css-qm6rs9 e19owgy710']")).click();
    }
    public void goTo() {
        driver.get("https://humanbenchmark.com/tests/aim");
    }

}