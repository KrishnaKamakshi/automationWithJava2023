Feature: Application Login

Scenario: Home page on Default Login
Given  User is on Landing Page
When   User login into the application with user email as "krishnaqa@automation.com" and password "TestQA@123"
Then   Home Page should be displayed
And    Cards are displayed