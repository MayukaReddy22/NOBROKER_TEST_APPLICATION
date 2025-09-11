Feature: Navigate to Upload your Draft

  # Business Purpose: Let users upload pre-drafted agreements for validation and stamping.
  # Saves time and ensures externally created drafts become legally compliant.
  #TS-RENT-005
  Background:
    Given the user is logged in with valid mobile number and OTP for Rental Agreement
    
    When the user clicks on the top-right "Menu"
    And the user clicks on "Rental Agreement"
    

  Scenario: Navigate to "Upload your Draft" and return to Rental Agreement
    When the user clicks on "Upload your Draft"
    
