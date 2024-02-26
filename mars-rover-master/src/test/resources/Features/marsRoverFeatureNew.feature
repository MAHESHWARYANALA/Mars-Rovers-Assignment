#Author: Maheshwar Yanala

Feature: Mars Rover Testing Tasks

  Scenario: Test for Rover direction facing and positioning initialisation
    Given Rovers initial position is 1 2 "N"
    When Rover prints its position
    Then the output should be 1 2 "N"

  Scenario: Test for moving the Rover x and y position and location
    Given Rovers initial position is 1 2 "N"
    When Rover moves with commands "LMLMLMLMM"
    Then the output should be 1 3 "N"

  Scenario: Test for moving the Rover as per the given scenario problem
    Given the plateau size is 5 5
    And Rovers initial position is 1 2 "N"
    When Rover moves with commands "MMRMMRMRRM"
    Then the output should be 1 3 "N"
