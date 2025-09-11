Feature: Navigate to Renew Your Agreement

  # Business Purpose: Provide customers with a quick way to extend their rental agreements online.
  # Ensures continuity of tenancy without manual paperwork or service interruptions.
  #TS-RENT-005
  Background:
    Given the user is logged in with valid mobile number and OTP for Rental Agreement
   
    When the user clicks on the top-right "Menu"
    And the user clicks on "Rental Agreement"
    

  Scenario: Navigate to "Renew Your Agreement" and return to Rental Agreement
    When the user clicks on "Renew Your Agreement"
   