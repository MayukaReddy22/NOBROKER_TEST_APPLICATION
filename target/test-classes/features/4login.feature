 Feature:User Login
 Scenario: OTP Expiry and Resend
    Given the user is on the login page
    When the user enters a valid phone number "<phoneNumber>"
    And waits until the OTP expires and clicks on resend button
    And the user enters the valid OTP
   
     #TS-LOGIN-001
    
     Examples:
     | phoneNumber |
     | 8122802783  | 