package pageobjects;
import abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MemoryTestPage extends AbstractComponent {
    // This class has page objects/elements/methods and links related to the Typing Test Page
    // of the website
    // This will driver the driver.get method of getting to the main page.
    WebDriver driver;

    public MemoryTestPage(WebDriver driver) {
        super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //return the array of keys

    @FindBy(css = "div[class='css-1qvtbrk e19owgy78'] button")
    WebElement StartTestBtn;

// get tiles   div[class="css-hvbk5q eut2yre0"] div[class]
    public void DoMemoryTest() throws InterruptedException {
        StartTestBtn.click();
//        waitForElementToAppear(new By.ByCssSelector("div[class='css-hvbk5q eut2yre0'] div[class*='active']"));
        int i = 0;
        while(i < 150){
        List<Integer> ActiveTilePositions = GetListWithActiveTileLocations();
        System.out.println(ActiveTilePositions);

//        waitForElementToAppear(new By.ByCssSelector("div[class=\"css-hvbk5q eut2yre0\"] div[class]"));
        List<WebElement> Tiles = GetGridShape();


        Thread.sleep(2000);
        for (Integer ActiveTilePosition : ActiveTilePositions){
            System.out.println(Tiles.get(ActiveTilePosition));
            Tiles.get(ActiveTilePosition).click();

        }
        i++;
    }
    }
    public void goTo() {
        driver.get("https://humanbenchmark.com/tests/memory");
    }

    public List<WebElement> GetGridShape() {

       List<WebElement> Tiles = driver.findElements(By.cssSelector("div[class=\"css-hvbk5q eut2yre0\"] div[class]"));

       return Tiles;
    }

    public List<Integer> GetListWithActiveTileLocations() {

        List<Integer> PositionsToClick = new ArrayList<Integer>();
        waitForElementToAppear(new By.ByCssSelector("div[class='css-hvbk5q eut2yre0'] div[class*='active']"));
        List<WebElement> GridWithActiveTiles = driver.findElements(By.cssSelector("div[class=\"css-hvbk5q eut2yre0\"] div[class]"));


        for(WebElement x : GridWithActiveTiles){
            if (x.getAttribute("class").contains("active")){
                PositionsToClick.add(GridWithActiveTiles.indexOf(x));
            }
        }

        return PositionsToClick;

//active tiles locator div[class="css-hvbk5q eut2yre0"] div[class*='active']
    }
    public void SaveScore() {
        driver.findElement(By.cssSelector("button[class='css-qm6rs9 e19owgy710']")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        MemoryTestPage memoryTestPage = new MemoryTestPage(driver);
        memoryTestPage.goTo();
        memoryTestPage.DoMemoryTest();
    }
}

