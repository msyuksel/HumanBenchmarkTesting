package pageobjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {
	// This class has page objects/elements/methods and links related to the main
	// page of the website
	// This will driver the driver.get method of getting to the main page.
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[type='text']")
	WebElement usernameInput;
	@FindBy(css = "input[type='password']")
	WebElement passwordInput;
@FindBy(css = "input[type='submit']")
WebElement submitButton;

	// This method will take us directly to the landing page
	public LandingPage goToLandingPage(WebDriver driver) {
		driver.get("https://humanbenchmark.com/");
		return new LandingPage(driver);


	}

	public LandingPage loginToAccount(String username, String password) throws InterruptedException {

		Thread.sleep(2000);
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		submitButton.click();
		Thread.sleep(2000);

		return goToLandingPage(driver);

	}


}
