# new feature
# Tags: optional

Feature: A description
   @myaccount
  Scenario: A scenario
     Given user is on the given url
     And user sign in with email "ghendon35@gmail.com" and password "Elbistan4634"
     And user is on the My personel info
     When user update his or her first name
     Then user firstname must be change