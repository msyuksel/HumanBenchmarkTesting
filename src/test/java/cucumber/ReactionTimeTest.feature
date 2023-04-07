#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: Submitting correct answers for Reaction test.

@Regression
  Scenario: ReactionTimeTest.feature
    Given I landed on ReactionTimePage
    When I click the start button on ReactionTestPage
    And I wait for the green color to appear on ReactionTestPage before clicking it
    Then  Test completed message is displayed on ReactionTestPage


