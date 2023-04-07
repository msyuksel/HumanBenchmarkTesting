package stepDefinitions;

import data.DataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import pageobjects.MemoryTestPage;
import pageobjects.LandingPage;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MemoryTestStepDefinitions extends BaseTest {
    public LandingPage landingPage;
    public MemoryTestPage MemoryTestPage;
    public LoginPage loginPage;
    @Given("I landed on MemoryTestPage")
    public void iLandedOnMemoryTestPage() throws IOException, InterruptedException {
        DataReader dataReader = new DataReader();
        ArrayList<HashMap<String,String>> data = (ArrayList<HashMap<String, String>>) dataReader.getJsonDataToMap();
        landingPage= launchApplication(data.get(0).get("username"), data.get(0).get("password"));


        MemoryTestPage = landingPage.goToMemoryTestPage();

    }

    @When("I click the start button on MemoryTestPage")
    public void iClickTheStartButtonOnMemoryTestPage() throws InterruptedException {
        MemoryTestPage.startTest();
    }
    @And("I keep clicking on the numbers in the order they appear on MemoryTestPage")
    public void iKeepClickingOnTheNumbersInTheOrderTheyAppearOnMemoryTestPage() throws InterruptedException {
        MemoryTestPage.DoMemoryTest();
    }

    @Then("Test completed message is displayed on MemoryTestPage")
    public void testCompletedMessageIsDisplayedOnMemoryTestPage() {
        MemoryTestPage.SaveScore();
    }


}
