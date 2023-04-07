package stepDefinitions;

import data.DataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import pageobjects.ChimpTestPage;


public class ChimpTestDefinitions extends BaseTest {

	public LandingPage landingPage;
	public ChimpTestPage chimpTestPage;
	public LoginPage loginPage;
	@Given("I landed on ChimpTestPage")
	public void i_landed_on_chimp_test_page() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete action
		DataReader dataReader = new DataReader();
		ArrayList<HashMap<String,String>> data = (ArrayList<HashMap<String, String>>) dataReader.getJsonDataToMap();
		landingPage= launchApplication(data.get(0).get("username"), data.get(0).get("password"));

		chimpTestPage = landingPage.goToChimpTest();


	}
	@When("I click the start button")
	public void i_click_the_start_button() {
		// Write code here that turns the phrase above into concrete actions
		chimpTestPage.startChimpTest();

	}
	@When("I click every correct answer for each level")
	public void i_click_every_correct_answer_for_each_level(){
		// Write code here that turns the phrase above into concrete actions
		chimpTestPage.doChimpTest();
	}
	@Then("Test completed message is displayed")
	public void test_completed_message_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		chimpTestPage.SaveScore();
	}
//	@Given("I landed on ChimpTestPage")
//	public void iLandedOnChimpTestPage() throws IOException {sssssssssssssssssssssssss   a  AWywad AAAAAAAAAAAAAAAAAAAAAAAAAAAwa awaaaaaaaaaaaaaaasda

//	}
//
//	@When("I click the start button")
//	public void iClickTheStartButton() {

//	}
//
//	@And("I click every correct answer for each level")
//	public void iClickEveryCorrectAnswerForEachLevel() {

//	}
//
//	@Then("Test completed message is displayed")
//	public void testCompletedMessageIsDisplayed() {
//		System.out.println("Trust Me Bro");
//	}



}
