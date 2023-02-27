package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SequenceMemoryPage {
    WebDriver driver;

    public SequenceMemoryPage(WebDriver driver) {
        // super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "div[class = \"view-go e18o0sx0 css-saet2v e19owgy77\"] div div div h1 div")
    WebElement reactionTimeClickBtn;

    //Same locator on all test pages
    @FindBy(css = "button[class=\"css-qm6rs9 e19owgy710\"]")
    WebElement saveScoreBtn;

    public void goTo() {
        driver.get("https://humanbenchmark.com/tests/sequence");
    }
}
