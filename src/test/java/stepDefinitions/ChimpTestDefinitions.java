package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import testComponents.BaseTest;

import java.io.IOException;
import pageobjects.ChimpTestPage;


public class ChimpTestDefinitions extends BaseTest {

	public LandingPage landingPage;
	public ChimpTestPage chimpTestPage;

	@Given("I landed on ChimpTestPage")
	public void i_landed_on_chimp_test_page() throws IOException{
		// Write code here that turns the phrase above into concrete action
		landingPage= launchApplication();

		chimpTestPage = landingPage.goToChimpTest();


	}
	@When("I click the start button")
	public void i_click_the_start_button() {
		// Write code here that turns the phrase above into concrete actions
		chimpTestPage.startChimpTest();
	}
	@When("I click every correct answer for each level")
	public void i_click_every_correct_answer_for_each_level() {
		// Write code here that turns the phrase above into concrete actions
		chimpTestPage.doChimpTest();
	}
	@Then("Test completed message is displayed")
	public void test_completed_message_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Trust Me Bro");
	}
//	@Given("I landed on ChimpTestPage")
//	public void iLandedOnChimpTestPage() throws IOException {

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
