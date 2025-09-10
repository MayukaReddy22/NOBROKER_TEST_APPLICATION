Feature: Payment Module - NoBroker.com

  Scenario: Successful Payment using Contact Number
    Given User is logged in with valid phone number and OTP for contact payment

    When User clicks on Pay Rent button
    And User selects Contact Number payment option
    And User enters PAN number "IJSPP4270C"
    Then User verifies the PAN number
    And User is redirected to the payment page
