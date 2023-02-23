package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {
	//This class has page objects/elements/methods and links related to the main page of the website
	//This will driver the driver.get method of getting to the main page.
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		//super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	//This method will take us directly to the landing page
	public void goTo() {
		driver.get("https://humanbenchmark.com/");
	}
}
