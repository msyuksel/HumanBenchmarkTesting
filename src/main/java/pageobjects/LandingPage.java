package pageobjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LandingPage extends AbstractComponent {
	// This class has page objects/elements/methods and links related to the main
	// page of the website
	// This will driver the driver.get method of getting to the main page.
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(css = " div a[id='login']")
	WebElement loginBtn;

	@FindBy(css = "input[id='text']")
	WebElement usernameInput;
	@FindBy(css = "input[id='password']")
	WebElement passwordInput;

	@FindBy(css = "div[class = \"css-1ur49oz e19owgy70\"]:nth-child(1) a[class = \"css-uaat4j e19owgy72\"]:nth-child(1)")
	WebElement reactionTimeLinkBtn;

	@FindBy(css = "div[class = \"css-1ur49oz e19owgy70\"]:nth-child(1) a[class = \"css-uaat4j e19owgy72\"]:nth-child(2)")
	WebElement sequenceMemoryLinkBtn;

	@FindBy(css = "div[class = \"css-1ur49oz e19owgy70\"]:nth-child(1) a[class = \"css-uaat4j e19owgy72\"]:nth-child(3)")
	WebElement aimTrainerLinkBtn;

	@FindBy(css = "div[class = \"css-1ur49oz e19owgy70\"]:nth-child(2) a[class = \"css-uaat4j e19owgy72\"]:nth-child(1)")
	WebElement numberMemoryLinkBtn;

	@FindBy(css = "div[class = \"css-1ur49oz e19owgy70\"]:nth-child(2) a[class = \"css-uaat4j e19owgy72\"]:nth-child(2)")
	WebElement verbalMemoryLinkBtn;

	@FindBy(css = "div[class = \"css-1ur49oz e19owgy70\"]:nth-child(2) a[class = \"css-uaat4j e19owgy72\"]:nth-child(3)")
	WebElement chimpTestLinkBtn;

	@FindBy(css = "div[class = \"css-1ur49oz e19owgy70\"]:nth-child(3) a[class = \"css-uaat4j e19owgy72\"]:nth-child(1)")
	WebElement visualMemoryLinkBtn;

	@FindBy(css = "div[class = \"css-1ur49oz e19owgy70\"]:nth-child(3) a[class = \"css-uaat4j e19owgy72\"]:nth-child(2)")
	WebElement typingLinkBtn;

	@FindBy(css = "div[class = \"css-w0151b e19owgy76\"] p:nth-child(1)")
	WebElement copyRightLocator;

	@FindBy(css = "div[class = \"css-w0151b e19owgy76\"] p:nth-child(2)")
	WebElement contactEmailLocator;

	@FindBy(css = "div[class = \"css-w0151b e19owgy76\"] p:nth-child(3)")
	WebElement privacyPolicyLocator;

	@FindBy(css = "div[class = \"css-w0151b e19owgy76\"] p:nth-child(4)")
	WebElement licensingLocator;

	// This method will take us directly to the landing page
	public void goTo() {
		driver.get("https://humanbenchmark.com/");

	}
	public ChimpTestPage goToChimpTest() {

		chimpTestLinkBtn.click();
		return new ChimpTestPage(driver);

	}
	public NumberMemoryTestPage goToNumberMemoryTestPage() {

		numberMemoryLinkBtn.click();
		return new NumberMemoryTestPage(driver);

	}

	public ReactionTimePage goToReactionTimeTestPage() {

		reactionTimeLinkBtn.click();
		return new ReactionTimePage(driver);

	}
	public SequenceMemoryPage goToSequenceMemoryTestPage() {

		sequenceMemoryLinkBtn.click();
		return new SequenceMemoryPage(driver);

	}
	public AimTestPage goToAimTestPage() {
		AimTestPage aimTestPage = new AimTestPage(driver);
		aimTestPage.goTo();
		return aimTestPage;

	}
//	public VerbalMemoryPage goToVerbalMemoryTestPage() {
//
//		verbalMemoryLinkBtn.click();
//		return new VerbalMemoryPage(driver);
//
//	}
	public MemoryTestPage goToMemoryTestPage() {

		visualMemoryLinkBtn.click();
		return new MemoryTestPage(driver);

	}
	public TypingTestPage goToTypingTestPage() {

		typingLinkBtn.click();
		return new TypingTestPage(driver);

	}
	public LoginPage goToLoginPage() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}


}
