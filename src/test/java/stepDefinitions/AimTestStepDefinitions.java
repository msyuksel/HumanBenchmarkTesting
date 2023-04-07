package stepDefinitions;

import data.DataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AimTestPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AimTestStepDefinitions extends BaseTest {
    public LandingPage landingPage;
    public AimTestPage aimTestPage;
    public LoginPage loginPage;
    @Given("I landed on AimTestPage")
    public void iLandedOnAimTestPage() throws IOException, InterruptedException {
        DataReader dataReader = new DataReader();
        ArrayList<HashMap<String,String>> data = (ArrayList<HashMap<String, String>>) dataReader.getJsonDataToMap();
        landingPage= launchApplication(data.get(0).get("username"),  data.get(0).get("password"));
        Thread.sleep(2000);
        aimTestPage = landingPage.goToAimTestPage();

    }

    @When("I click the start button on AimTestPage")
    public void iClickTheStartButtonOnAimTestPage() {
        aimTestPage.startTest();
    }

    @And("I use aim hacks")
    public void iUseAimHacks() {
        aimTestPage.DoAimTest();
    }

    @Then("Test completed message is displayed on AimTestPage")
    public void testCompletedMessageIsDisplayedOnAimTestPage() {
        aimTestPage.SaveScore();
    }
}
