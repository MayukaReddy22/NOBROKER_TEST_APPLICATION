Feature: Navigate to E-Stamped Agreement

  # Business Purpose: Provide users with a digital option to generate legally stamped agreements.
  # Eliminates the need to visit physical offices, making the process faster and secure.
  #TS-RENT-005
  Background:
    Given the user is logged in with valid mobile number and OTP for Rental Agreement
    When the user clicks on the top-right "Menu"
    And the user clicks on "Rental Agreement"
   

  Scenario: Navigate to "E-Stamped Agreement" and return to Rental Agreement
    When the user clicks on "E-Stamped Agreement"