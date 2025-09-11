Feature: Navigate to Your Ongoing Agreements

  # Business Purpose: Allow users to track agreements that are currently in progress.
  # Improves transparency and reduces support queries by providing real-time visibility.
  #TS-RENT-005
  Background:
    Given the user is logged in with valid mobile number and OTP for Rental Agreement

    When the user clicks on the top-right "Menu"
    And the user clicks on "Rental Agreement"
    

  Scenario: Navigate to "Your Ongoing Agreements" and return to Rental Agreement
    When the user clicks on "Your Ongoing Agreements"
  
