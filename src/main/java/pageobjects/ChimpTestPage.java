package pageobjects;
import java.util.List;
import abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class ChimpTestPage extends AbstractComponent {
        // This class has page objects/elements/methods and links related to the Typing Test Page
        // of the website
        // This will driver the driver.get method of getting to the main page.
        WebDriver driver;

        public ChimpTestPage(WebDriver driver) {
            super(driver);
            // initialization
            this.driver = driver;
            PageFactory.initElements(driver, this);

        }

        //return the array of keys

        @FindBy(css = "div button[class='css-de05nr e19owgy710']")
        WebElement StartTestBtn;


        public void DoChimpTest() {
            StartTestBtn.click();
            int i = 5;
            while(i < 100) {
                clickTiles(i);
                driver.findElement(By.cssSelector("div button[class=\"css-de05nr e19owgy710\"]")).click();
                i++;
            }
        }
        public void clickTiles(int x){
            for(int i = 1; i<x ;i++){
                findCurrentTile("" + i).click();
            }
        }
        public WebElement findCurrentTile( String TileNumber) {
            String locator = "div[data-cellnumber='"+ TileNumber+  "']";
            return driver.findElement(By.cssSelector(locator));

            }



        public void SaveScore() {

            driver.findElement(By.cssSelector("button[class='css-qm6rs9 e19owgy710']")).click();
        }
        public void goTo() {
            driver.get("https://humanbenchmark.com/tests/chimp");
        }

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            ChimpTestPage chimpTestPage = new ChimpTestPage(driver);
            chimpTestPage.goTo();
            chimpTestPage.DoChimpTest();
        }
    }

