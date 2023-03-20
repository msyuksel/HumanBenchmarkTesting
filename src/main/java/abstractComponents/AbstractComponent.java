package abstractComponents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
	//This class points to page objects/elements/methods all pages in the website will have access to.
	//Examples below

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div[class='css-o34a3t e19owgy75'] a[href='/']")
	WebElement HumanBenchMarkButton;

	@FindBy(css = "div[class='css-o34a3t e19owgy75'] a[href='/dashboard']")
	WebElement DashboardButton;

	@FindBy(css = "div[class='css-o34a3t e19owgy75'] a[href='/signup']")
	WebElement SignUpButton;

	@FindBy(css = "div[class='css-o34a3t e19owgy75'] a[href='/login']")
	WebElement LoginButton;


	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForWebElementToBeClickable(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));

	}

	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	

	public void waitForElementToDisappear(WebElement findBy) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400));
		wait.until(ExpectedConditions.invisibilityOf(findBy));

	}


}
