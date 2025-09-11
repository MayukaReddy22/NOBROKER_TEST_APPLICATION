  Feature:User Login
  Scenario: Login with invalid OTP
    Given the user is on the login page
	When the user enters a valid phone number "<phoneNumber>"
	And the user enters the invalid OTP "<otp>"
    Then an invalid otp message should be shown
    
    #TS-LOGIN-001
    
    Examples:
      | phoneNumber | otp  |
      | 8122802783  | 150914 |