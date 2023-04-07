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
Feature: Submitting correct answers for SequenceMemory Test

@Regression
  Scenario: SequenceMemoryTest.feature
    Given I landed on SequenceMemoryPage
    When I click the start button on SequenceMemoryPage
    And I wait for the correct tiles to pop up in sequence
    Then  Test completed message is displayed on SequenceMemoryPage


