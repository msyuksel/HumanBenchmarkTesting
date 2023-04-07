package stepDefinitions;

import data.DataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.SequenceMemoryPage;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SequenceMemoryTestStepDefinitions extends BaseTest {

    public LandingPage landingPage;
    public SequenceMemoryPage sequenceMemoryPage;
    public LoginPage loginPage;
    @Given("I landed on SequenceMemoryPage")
    public void iLandedOnSequenceMemoryPage() throws IOException, InterruptedException {
        DataReader dataReader = new DataReader();
        ArrayList<HashMap<String,String>> data = (ArrayList<HashMap<String, String>>) dataReader.getJsonDataToMap();
        landingPage= launchApplication(data.get(0).get("username"), data.get(0).get("password"));


        sequenceMemoryPage = landingPage.goToSequenceMemoryTestPage();

    }
    @When("I click the start button on SequenceMemoryPage")
    public void iClickTheStartButtonOnSequenceMemoryPage() {
        sequenceMemoryPage.startTest();
    }

    @And("I wait for the correct tiles to pop up in sequence")
    public void iWaitForTheCorrectTilesToPopUpInSequence() throws InterruptedException {
        sequenceMemoryPage.testRunner();
    }
    @Then("Test completed message is displayed on SequenceMemoryPage")
    public void testCompletedMessageIsDisplayedOnSequenceMemoryPage() throws InterruptedException {
        sequenceMemoryPage.saveScore();
    }
}
