package stepDefinitions;

import data.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.TypingTestPage;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TypingTestStepDefinitions extends BaseTest {
    public LandingPage landingPage;
    public TypingTestPage typingTestPage;
    @Given("I landed on TypingTestPage")
    public void iLandedOnTypingTestPage() throws IOException, InterruptedException {
        DataReader dataReader = new DataReader();
        ArrayList<HashMap<String,String>> data = (ArrayList<HashMap<String, String>>) dataReader.getJsonDataToMap();
        landingPage= launchApplication(data.get(0).get("username"), data.get(0).get("password"));


        typingTestPage = landingPage.goToTypingTestPage();
    }

    @When("I type the text displayed on TypingTestPage")
    public void iTypeTheTextDisplayedOnTypingTestPage() {
        typingTestPage.sendCorrectKeys();

    }


    @Then("Test completed message is displayed on TypingTestPage")
    public void testCompletedMessageIsDisplayedOnTypingTestPage() {
        typingTestPage.saveScore();
    }
}
