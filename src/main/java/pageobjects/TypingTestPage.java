package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TypingTestPage {
	// This class has page objects/elements/methods and links related to the Typing Test Page
	// of the website
	// This will driver the driver.get method of getting to the main page.
	WebDriver driver;

	public TypingTestPage(WebDriver driver) {
		// super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//return the array of keys
	@FindAll({@FindBy(css = "div span[class*='incomplete']")})
	public List<WebElement> Keys;
	@FindBy(css = "div[class='letters notranslate']")
	WebElement BoxToTypeIn;

	// This method will take us directly to the landing page
	public void goTo() {
		driver.get("https://humanbenchmark.com/tests/typing");
	}
	public void selectTextBox() {
		BoxToTypeIn.click();
	}
	public void sendCorrectKeys() {
		//converting the list of webelements into a list of characters
		List<Character> CorrectKeys = new ArrayList<Character>();
		for(WebElement c : Keys){
			char x=c.getText().charAt(0);
			CorrectKeys.add(x);
		}
		//converting the list of characters into a charsequence
		CharSequence[] cs = CorrectKeys.toArray(new CharSequence[CorrectKeys.size()]);

		//selecting the textbox and sending our charsequence of correct keys
		selectTextBox();
		BoxToTypeIn.sendKeys(cs);
	}


}
