package stepDefinitions;

import data.DataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.ReactionTimePage;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReactionTimeStepDefinitions extends BaseTest {
    public LandingPage landingPage;
    public ReactionTimePage reactionTimePage;
    public LoginPage loginPage;

    @Given("I landed on ReactionTimePage")
    public void iLandedOnReactionTimePage() throws IOException, InterruptedException {
        DataReader dataReader = new DataReader();
        ArrayList<HashMap<String,String>> data = (ArrayList<HashMap<String, String>>) dataReader.getJsonDataToMap();
        landingPage= launchApplication(data.get(0).get("username"), data.get(0).get("password"));


        reactionTimePage = landingPage.goToReactionTimeTestPage();
    }

    @When("I click the start button on ReactionTestPage")
    public void iClickTheStartButtonOnReactionTestPage() {
        reactionTimePage.startTest();
    }

    @And("I wait for the green color to appear on ReactionTestPage before clicking it")
    public void iWaitForTheGreenColorToAppearOnReactionTestPageBeforeClickingIt() {
        reactionTimePage.clickReactionTimeBtn();
    }

    @Then("Test completed message is displayed on ReactionTestPage")
    public void testCompletedMessageIsDisplayedOnReactionTestPage() {
        reactionTimePage.saveScore();
    }
}
