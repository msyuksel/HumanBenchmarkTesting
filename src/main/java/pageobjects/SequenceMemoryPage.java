package pageobjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
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


    public List<Integer> getClickIndex() throws InterruptedException {
        List<Integer> btnClickIndexs = new ArrayList<Integer>();
        for(int i = 0; i<Integer.valueOf(levelNum.getText()); i++) {
            for (WebElement x : squareBtns) {
                waitForWebElementToAppear(activeSquareBtn);
                if (x.getAttribute("class").contains("active")) {
                    btnClickIndexs.add(squareBtns.indexOf(x));

                    System.out.println("adding into btnclick "+ squareBtns.indexOf(x));
                    System.out.println("indexlist size "+btnClickIndexs.size());
                }
            }
            Thread.sleep(400);
        }

            return btnClickIndexs;

    }

    public void clickBoxes() throws InterruptedException {
        for(int i = 0; i<Integer.valueOf(levelNum.getText()); i++) {
            Iterator<Integer> it = getClickIndex().iterator();
            while (it.hasNext()) {
                Integer x = it.next();
                Thread.sleep(400);

                squareBtns.get(x).click();
            }

        }
    }

//    public void goTo() {
//        driver.get("https://humanbenchmark.com/tests/sequence");
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        SequenceMemoryPage sequenceMemoryPage = new SequenceMemoryPage(driver);
//        sequenceMemoryPage.goTo();
//        sequenceMemoryPage.sequenceMemoryStartTestBtn.click();
//        sequenceMemoryPage.clickBoxes();
//
//    }
}
