Feature: Payment Module - NoBroker.com

  Scenario: Successful Payment using Contact Number
    Given User is logged in with valid phone number and OTP for contact payment
    When User clicks on Pay Rent button
    
