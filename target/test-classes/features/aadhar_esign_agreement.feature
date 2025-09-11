Feature: Navigate to Paperless Rental Agreement with Aadhaar E-Sign

  # Business Purpose: Enable a fully digital rental agreement using Aadhaar-based authentication.
  # Simplifies signing and reduces turnaround time by avoiding physical paperwork.
  
  #TS-RENT-005

  Background:
    Given the user is logged in with valid mobile number and OTP for Rental Agreement
  
    When the user clicks on the top-right "Menu"
    And the user clicks on "Rental Agreement"
   

  Scenario: Navigate to "Paperless Rental Agreement with Aadhaar E-Sign" and return to Rental Agreement
    When the user clicks on "Paperless Rental Agreement with Aadhaar E-Sign"
    