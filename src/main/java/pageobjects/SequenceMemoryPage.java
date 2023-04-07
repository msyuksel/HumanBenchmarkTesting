package pageobjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SequenceMemoryPage extends AbstractComponent {
    WebDriver driver;

    public SequenceMemoryPage(WebDriver driver) {
        super(driver);
        // super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[class='css-de05nr e19owgy710']")
    WebElement sequenceMemoryStartTestBtn;

    @FindBy(css = "span span:nth-child(2)")
    WebElement levelNum;

    @FindBy(css = "div[class = 'square active']")
    WebElement activeSquareBtn;

    //Same locator on all test pages
    @FindBy(css = "button[class='css-qm6rs9 e19owgy710']")
    WebElement saveScoreBtn;

    @FindAll({@FindBy(css = "div[class = 'square-row'] div")})
    public List<WebElement> squareBtns;

    @FindBy(css = "div.anim-slide-fade-in div.css-1qvtbrk.e19owgy78:nth-child(2) > h1.css-0")
    WebElement playerScore;

    public int scoreIs = 1;

    private void checkIfSquareIsActive(List<Integer> btnClickIndexs) throws InterruptedException {
        try{waitForWebElementToAppear(squareBtns.get(8));} catch (Exception e){}
        for (WebElement x : squareBtns) {
            try {waitForWebElementToAppear(activeSquareBtn);}catch (Exception e){}
            if (x.getAttribute("class").equals("square active")){
                while(!(x.getAttribute("class").equals("square active"))){
                }
                btnClickIndexs.add(squareBtns.indexOf(x));
            }
        }
    }

    private List<Integer> indexesOfActiveSquares() throws InterruptedException {
        List<Integer> btnClickIndexs = new ArrayList<Integer>();
        for(int i = 0; i<scoreIs; i++) {
            checkIfSquareIsActive(btnClickIndexs);
            Thread.sleep(400);
        }
        return btnClickIndexs;
    }

    private void clickBoxes(List<Integer> btnClickIndexs, int i) throws InterruptedException {
        try {waitForWebElementToAppear(squareBtns.get(8));} catch (Exception e){}
        squareBtns.get(btnClickIndexs.get(i)).click();
    }

    public void testRunner() throws InterruptedException {
        for(int j = 0; j <100; j++){
            List<Integer> btnClickIndexs = indexesOfActiveSquares();
            for(int i = 0; i<scoreIs; i++) {
                try {waitForWebElementToBeClickable(squareBtns.get(i));} catch(Exception e){}
                clickBoxes(btnClickIndexs , i);
            }
            System.out.println("Level is: "+scoreIs);
            System.out.println("Click List Size: "+btnClickIndexs.size());
            //try {waitForWebElementToAppear(activeSquareBtn);} catch (Exception e){}
            scoreIs++;
        }
    }


    public void goTo() {
        driver.get("https://humanbenchmark.com/tests/sequence");
    }
    public void saveScore() throws InterruptedException {
        saveScoreBtn.click();
    }
    public void startTest(){
        sequenceMemoryStartTestBtn.click();
    }


}
