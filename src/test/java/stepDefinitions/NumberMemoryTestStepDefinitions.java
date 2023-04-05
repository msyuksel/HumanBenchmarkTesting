package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.NumberMemoryTestPage;
import testComponents.BaseTest;

import java.io.IOException;

public class NumberMemoryTestStepDefinitions extends BaseTest {
    public LandingPage landingPage;
    public NumberMemoryTestPage numberMemoryTestPage;

    @Given("I landed on NumberMemoryTestPage")
    public void iLandedOnNumberMemoryTestPage() throws IOException {
        landingPage= launchApplication();

        numberMemoryTestPage = landingPage.goToNumberMemoryTestPage();
    }

    @When("I click the start button on NumberMemoryTestPage")
    public void iClickTheStartButtonOnNumberMemoryTestPage() {
        numberMemoryTestPage.startTest();

    }

    @And("I keep submitting the numbers as they are displayed to me")
    public void iKeepSubmittingTheNumbersAsTheyAreDisplayedToMe() throws InterruptedException {
        numberMemoryTestPage.correctlyAnswerLevels();
    }

    @Then("Test completed message is displayed on NumberMemoryTestPage")
    public void testCompletedMessageIsDisplayedOnNumberMemoryTestPage() {
        numberMemoryTestPage.SaveScore();
    }
}
