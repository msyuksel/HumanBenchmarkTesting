package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReactionTimePage {
    WebDriver driver;

    public ReactionTimePage(WebDriver driver) {
        // super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class=\"view-splash e18o0sx0 css-saet2v e19owgy77\"]")
    WebElement reactionTimeStartTestBtn;

    @FindBy(css = "div[class = \"view-go e18o0sx0 css-saet2v e19owgy77\"] div div div h1 div")
    WebElement reactionTimeClickBtn;

    //Same locator on all test pages
    @FindBy(css = "button[class=\"css-qm6rs9 e19owgy710\"]")
    WebElement saveScoreBtn;

    @FindBy(css = "div[class=\"css-42wpoy e19owgy79\"]")
    WebElement continueBtn;

    public void startTest() {
        reactionTimeStartTestBtn.click();
    }

    public void clickReactionTimeBtn() {
        Boolean ThereAreTriesRemaining = true;
        int tries = 5;
        while (ThereAreTriesRemaining) {
            reactionTimeClickBtn.click();
            tries--;
            ThereAreTriesRemaining = (tries != 0);
            if (!ThereAreTriesRemaining){
                break;
            }
            continueBtn.click();





    }}

    public void saveScore() {
        saveScoreBtn.click();
    }


    public void goTo() {
        driver.get("https://humanbenchmark.com/tests/reactiontime");
    }

}
