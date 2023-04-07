package stepDefinitions;

import data.DataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.NumberMemoryTestPage;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class NumberMemoryTestStepDefinitions extends BaseTest {
    public LandingPage landingPage;
    public NumberMemoryTestPage numberMemoryTestPage;
    public LoginPage loginPage;
    @Given("I landed on NumberMemoryTestPage")
    public void iLandedOnNumberMemoryTestPage() throws IOException, InterruptedException {
        DataReader dataReader = new DataReader();
        ArrayList<HashMap<String,String>> data = (ArrayList<HashMap<String, String>>) dataReader.getJsonDataToMap();
        landingPage= launchApplication(data.get(0).get("username"), data.get(0).get("password"));

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
