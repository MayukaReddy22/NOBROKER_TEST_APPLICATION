Feature:User Login
Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters a valid phone number "<phoneNumber>"
	And the user enters the valid OTP
    
    #TS-LOGIN-001
     Examples:
     | phoneNumber |
     |8122802783  | 
    