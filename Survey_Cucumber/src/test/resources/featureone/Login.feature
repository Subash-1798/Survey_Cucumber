Feature: Digival User

@Login
Scenario: Successful login

 
    Given user enter username as "sf61@mail.com"
    And user enter password as "12345678"
    When user click the submit button
    Then loginShouldBeSuccess
    Then click on Digiclass
    And click on Survey
    And click on Survey Management
    Then click on Survey bank
    And click on Survey Templates
    And click on Course Level
    Then click on CreateSurvey
    And click on CreateTemplate
    And enter Survey Title as "Survey Automation"
    And enter Description as "Testing"
    Then click on Survey Level
    And click on Survey type selection
    And click on Survey type
    Then selectTagOutcome
    Then select Learning Outcome
    And select Mapping Outcome
    And click on start Creation
    Then click on Add Question
    And duplicate the Question
    And require the question
    Then delete the Question
    Then click on Add New Question
    And click on Long text
    And click on Create Runner step Template Survey
    Then Switch to creator to Runner
    Then click on Survey
    And click on Survey Management
    And click on Survey bank
    And click on Survey Templates
    And click on Course Level
    Then Switch the calendar
    And click on Run Survey
    Then Select  Program
    And click on Program name
    Then Select  term
    And click on Regular
    Then Select Year
    And click on Year
    Then Select Level
    And click on Level
    Then Select course
    And click on course
    Then Enter Survey version name as "Automation testing"
    Then Add PLO
    Then click on next
    Then select the settings
    And click on More settings
    Then click on outcome button
    Then click on course outcome
    And select framework
    Then click on Knowledge
    And select Clo1checkbox
    Then click on Tag
    And select TagSelection
    Then click on save
    Then click on next
    And Select the participants
    Then click on next
    Then Click on clock1 
    Then Click on Ok button
    And select clock2
    Then Click on Ok button
    Then Publish survey
    
   
   
    When switch to the incognito window
    Given student enters username as "st40@mail.com"
    And student enters password as "12345678"
    When student clicks the submit button
    Then student login should be successful
    Then click on studentsideicon
    Then click on survey1
    And  click on Mysurvey
    And  click on Courselevel
    Then  switch the calendar1
    Then click on Go to survey
    And  click on StronglyAgree
    Then click on Neutral
    Then click on next page
    Then click on StronglyDisAgree
    And click on Agree
    And Answer the openend question
    Then click on complete
    And close the survey
     
    When switch to the MainWindow
    Then click on Report icon
    Then click on ViewReports
    Then Move to Learningoutcomesection page
    Then drag down to sectionA
    Then click on static Anaysis
    Then click am on the Questionnaire page  
    And click on the individual question
    Then drag down to question
    And click on Individual Responders
    And click on the individual responders link
    And click on the View Reports
    And go back to the previous page
    And click on Sentiment Analysis
    And scroll to View By Individual Response
    When switch to the incognito window


    And  click on Courselevel
    And click on the Preview button
    Then click on next button
    And click on the Previous button
   
    
