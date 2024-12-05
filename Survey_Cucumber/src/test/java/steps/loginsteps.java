package steps;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v130.runtime.model.TimeDelta;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectsmodel.Add_Question_Runner;
import pageobjectsmodel.Login;
import pageobjectsmodel.Outcome_Tag;
import pageobjectsmodel.Reports_Page;
import pageobjectsmodel.Survey_Creation;
import pageobjectsmodel.Survey_Home;
import student_Pom.Student_Answer;
import student_Pom.Student_Login;
import student_Pom.Student_Preview;






public class loginsteps {
	static WebDriver driver;
	WebDriverWait Wait;
	Actions action;
	JavascriptExecutor js;
	
	LocalTime currentTime = LocalTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

	
	
	public WebDriver incognitoDriver;
    String incognitoWindowHandle = "";
    String mainWindowHandle;
	
	
	
	      public  loginsteps() {
		ChromeOptions chromeOptions = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromeOptions.addArguments("--incognito");
		incognitoDriver = new ChromeDriver(chromeOptions);
		incognitoDriver.manage().window().maximize();
		incognitoDriver.get("https://digival-staging-nginx-ds-yk25kmkzeq-el.a.run.app/staging1-dcweb/");

	}
	
	@Before
    public void setUp() {
        setUpDriver();
        //setUpIncognitoDriver();
    }
	

    public void setUpDriver() {
        String baseURL = "https://digival-staging-nginx-ds-yk25kmkzeq-el.a.run.app/staging1-dcweb/";
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized", "use-fake-ui-for-media-stream"));
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        
        Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        LocalDateTime currentTime = LocalDateTime.now();
    }


	@Given("user enter username as {string}")
	public void userEnterUsernameAs(String string) {
		Login.username(driver).sendKeys("sf61@mail.com");
	}
	@Given("user enter password as {string}")
	public void userEnterPasswordAs(String string) {
		Login.password(driver).sendKeys("12345678");
	}
	@When("user click the submit button")
	public void userClickTheSubmitButton() {
		Login.Submit(driver).click();
	}
	@Then("loginShouldBeSuccess")
	public void loginShouldBeSuccess() {
		System.out.println("The login is successfully done");
	}
	@Then("click on Digiclass")
	public void clickOnDigiclass() throws InterruptedException {
		Thread.sleep(7000);
		Login.Digiclass(driver).click();	
	}
	@Then("click on Survey")
	public void clickOnSurvey() throws InterruptedException {
		Survey_Home.Sidebutton(driver).click();
		WebElement Surveybutton = driver.findElement(By.xpath("//div[text() = 'Survey']"));
		js.executeScript("arguments[0].scrollIntoView(true);", Surveybutton);
		Surveybutton.click();
		Thread.sleep(5000);
		
		
	}
	@Then("click on Survey Management")
	public void clickOnSurveyManagement() throws InterruptedException {
		Survey_Home.SurveyManagement(driver).click();
		Thread.sleep(5000);
	}
	@Then("click on Survey bank")
	public void clickOnSurveyBank() {
		Survey_Home.Surveybank(driver).click();
	}
	@Then("click on Survey Templates")
	public void clickOnSurveyTemplates() {
		Survey_Home.SurveyTemplate(driver).click();
	}
	@Then("click on Course Level")
	public void clickOnCourseLevel() throws InterruptedException {
		Thread.sleep(5000);
		Survey_Home.courselevel(driver).click();
	}
	@Then("click on CreateSurvey")
	public void clickOnCreateSurvey() throws InterruptedException {
		Thread.sleep(5000);
		Survey_Creation.CreateSurvey(driver).click();
	}
	@Then("click on CreateTemplate")
	public void clickOnCreateTemplate() {
		Survey_Creation.CreateTemplate(driver).click();
	}
	@Then("enter Survey Title as {string}")
	public void enterSurveyTitleAs(String string) {
		Survey_Creation.EnterSurveyTitle(driver).sendKeys("Survey Automation");
	}
	@Then("enter Description as {string}")
	public void enterDescriptionAs(String string) {
		Survey_Creation.EnterDescription(driver).sendKeys("Testing");
	}
	@Then("click on Survey Level")
	public void clickOnSurveyLevel() {
		Survey_Creation.SurveyLevel(driver).click();
	}
	@Then("click on Survey type selection")
	public void clickOnSurveyTypeSelection() {
		Survey_Creation.Surveytypeselection(driver).click();
	}
	@Then("click on Survey type")
	public void clickOnSurveyType() {
		Survey_Creation.Surveytype(driver).click();
	}
	@Then("select Learning Outcome")
	public void selectLearningOutcome() {
		Survey_Creation.LearningOutcome(driver).click();
	}
	@Then("select Mapping Outcome")
	public void selectMappingOutcome() {
		Survey_Creation.MappingOutcome(driver).click();
	}
	
	@Then("selectTagOutcome")
	public void selectTagOutcome() {
		Survey_Creation.TagMapping(driver).click();
	}
	
	
	@Then("click on start Creation")
	
	public void clickOnStartCreation() {
		Survey_Creation.StartCreation(driver).click();
	}
	@Then("click on Add Question")
	public void clickOnAddQuestion() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Add Question']")).click();
		WebElement Ratingscale = driver.findElement(By.xpath("(//span[text()= 'question_1'])[1]"));
		Ratingscale.click();
		Ratingscale.sendKeys(Keys.CONTROL + "a");
		Ratingscale.sendKeys(Keys.DELETE);
		Ratingscale.sendKeys(
				" Which phase of the Software Development Life Cycle (SDLC) is most suitable for Automation Testing?");
		Thread.sleep(5000);
				
	}
	@Then("duplicate the Question")
	public void duplicateTheQuestion() {
		Add_Question_Runner.Duplicate(driver).click();
	}
	@Then("require the question")
	public void requireTheQuestion() throws InterruptedException {
		Thread.sleep(2000);
		Add_Question_Runner.Required(driver).click();
	}
	@Then("delete the Question")
	public void deleteTheQuestion() {
		Add_Question_Runner.Delete(driver).click();
	}
	@Then("click on Add New Question")
	public void clickOnAddNewQuestion() throws InterruptedException {

		driver.findElement(By.xpath("(//span[text()='Add Question'])[1]")).click();
		WebElement inputElement =driver.findElement(By.xpath("(//span[text()='question_2'])[1]"));
		inputElement.click();
		inputElement.sendKeys(Keys.CONTROL + "a"); 
		inputElement.sendKeys(Keys.DELETE);
		inputElement.sendKeys(" Why Java for Automation testing?");
	}
	@Then("click on Long text")
	public void clickOnLongText() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class=\"svc-element__question-type-selector-icon\"])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@title='Long Text'])[3]")).click();
		Thread.sleep(2000);
		WebElement Longtextquestion =driver.findElement(By.xpath("(//span[text()='question_3'])[1]"));
		Longtextquestion.sendKeys(Keys.CONTROL + "a");
		Longtextquestion.sendKeys(Keys.DELETE);
		Longtextquestion.sendKeys(" Agile Software Development is based on which of the following type?");	
		
	}
	@Then("click on Create Runner step Template Survey")
	public void clickOnCreateRunnerStepTemplateSurvey() {
		Add_Question_Runner.CreateTemplateSurvey(driver).click();
	}
	
	@Then("Switch to creator to Runner")
	public void switchToCreatorToRunner() throws InterruptedException {
		WebElement chooseElement1 = driver.findElement(By.xpath("//*[@class=\"fa fa-angle-down profile_icon \"]"));
		action.moveToElement(chooseElement1).perform();
		Thread.sleep(10000);
		WebElement subElement = driver
				.findElement(By.xpath("//div[normalize-space()='Logged in as Survey Template Creator']"));
		action.moveToElement(subElement).perform();
		Thread.sleep(5000);
		WebElement runnerElement = driver.findElement(By.xpath("//li[normalize-space()='Survey Template Runner']"));
		action.moveToElement(runnerElement).perform();
		runnerElement.click();
		Thread.sleep(5000);
	}
	
	@Then("Switch the calendar")
	public void switchTheCalendar() throws InterruptedException {
		Thread.sleep(5000);
		WebElement academiccalendar =driver.findElement(By.xpath("//div[text ()= 'Automation Staging']"));
		academiccalendar.click();
		Thread.sleep(5000);
		WebElement movedcalendar =driver.findElement(By.xpath("//li[text() = '2024-20258']"));
		js.executeScript("arguments[0].scrollIntoView(true);", movedcalendar);
		action.moveToElement(movedcalendar).perform();
		movedcalendar.click();
		Thread.sleep(5000);
	}
	@Then("click on Run Survey")
	public void clickOnRunSurvey() {
		Add_Question_Runner.RunSurvey(driver).click();
	}
	@Then("Select  Program")
	public void selectProgram() {
		Add_Question_Runner.Selectprogram(driver).click();
	}
	@Then("click on Program name")
	public void clickOnProgramName() {
		Add_Question_Runner.programname(driver).click();
	}
	@Then("Select  term")
	public void selectTerm() {
		Add_Question_Runner.selectTerm(driver).click();
	}
	@Then("click on Regular")
	public void clickOnRegular() {
		Add_Question_Runner.Regular(driver).click();
	}
	@Then("Select Year")
	public void selectYear() {
		Add_Question_Runner.Selectyear(driver).click();
	}
	@Then("click on Year")
	public void clickOnYear() {
		Add_Question_Runner.Year(driver).click();
	}
	@Then("Select Level")
	public void selectLevel() {
		Add_Question_Runner.SelectLevel(driver).click();
	}
	@Then("click on Level")
	public void clickOnLevel() {
		Add_Question_Runner.Level(driver).click();
	}
	@Then("Select course")
	public void selectCourse() {
		Add_Question_Runner.SelectCourse(driver).click();
	}
	@Then("click on course")
	public void clickOnCourse() {
		Add_Question_Runner.Coursename(driver).click();
	}
	@Then("Enter Survey version name as {string}")
	public void enterSurveyVersionNameAs(String string) {
		Add_Question_Runner.Surveyversionname(driver).sendKeys("Automation testing");
	}
	@Then("Add PLO")
	public void addPLO() {
		WebElement PLO = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
		action.moveToElement(PLO).perform();
		PLO.click();

		WebElement PLO2 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[3]"));
		action.moveToElement(PLO2).perform();
		PLO2.click();
	}
	@Then("click on next")
	public void clickOnNext() {
		driver.findElement(By.xpath("//span[@class=\"text-nowrap px-3\"]")).click();
	}
	@Then("select the settings")
	public void selectTheSettings() throws InterruptedException {
		WebElement SA1 = driver.findElement(By.xpath("//span[text() = 'Section A']"));
		js.executeScript("arguments[0].scrollIntoView(true);", SA1);
		Thread.sleep(5000);		
		
	}
	
	@And("click on More settings")
	public void clickonMoresettings() {
		Outcome_Tag.Moresettings(driver).click();	
		
	}
	
	
	@Then("click on outcome button")
	public void clickOnOutcomeButton() throws InterruptedException {
		WebElement Outcomebutton = driver.findElement(
				By.xpath("//div[@class=\"border d-flex align-items-center justify-content-between p-2 rounded\"]"));
		Outcomebutton.click();
		Thread.sleep(5000);
	}
	@Then("click on course outcome")
	public void clickOnCourseOutcome() throws InterruptedException {
		Outcome_Tag.CourseOutcome(driver).click();
		Thread.sleep(5000);
	}
	@Then("select framework")
	public void selectFramework() {
		Outcome_Tag.selectFramework(driver).click();
	}
	@Then("click on Knowledge")
	public void clickOnKnowledge() {
		Outcome_Tag.Knowledge(driver).click();
	}
	@Then("select Clo1checkbox")
	public void selectClo1checkbox() {
		Outcome_Tag.Clo1checkbox(driver).click();
	}
	@Then("click on Tag")
	public void clickOnTag() {
		Outcome_Tag.Tag(driver).click();
	}
	@Then("select TagSelection")
	public void selectTagSelection() {
		Outcome_Tag.Tagselection(driver).click();
	}
	@Then("click on save")
	public void clickOnSave() {
		driver.findElement(By.xpath("//span[text() = 'Save']")).click();
	}
	
	@Then("Select the participants")
	public void selectTheParticipants() throws InterruptedException {
		
		Thread.sleep(5000);
		Outcome_Tag.particpantsdropdown(driver).click();
		Outcome_Tag.leveldropdown(driver).click();
		Outcome_Tag.yeardropdown(driver).click();
		Thread.sleep(5000);
		WebElement PLO3 = driver.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[4]"));
		action.doubleClick(PLO3).perform();
		Thread.sleep(5000);
	}
	@Then("Click on clock1")
	public void clickOnClock1() throws InterruptedException {
		
		Outcome_Tag.clock1select(driver).click();
		Outcome_Tag.clock1label(driver).click();		
		WebElement clock1 = driver.findElement(By.xpath("//input[@placeholder=\"hh:mm (a|p)m\"]"));
		LocalTime currentTime = LocalTime.now();
	    LocalTime newTime = currentTime.plusMinutes(1);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
	    String formattedTime = newTime.format(formatter);
	    Thread.sleep(2000);
	    clock1.sendKeys(Keys.CONTROL + "a");
	    clock1.sendKeys(Keys.DELETE);
	    clock1.sendKeys(formattedTime);

		
	}
	
	@Then("Click on Ok button")
	public void clickOnOkButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(5000);
	}
	
	
	@Then("select clock2")
	public void selectClock2() throws InterruptedException {
		
		Outcome_Tag.clock2select(driver).click();
		Outcome_Tag.clock2label(driver).click();	
		WebElement clock2 = driver.findElement(By.xpath(
				"(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd css-b52kj1\"])[5]"));
		Thread.sleep(5000);
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");	
	    LocalTime newTime = currentTime.plusMinutes(5);
	    String formattedTime = newTime.format(formatter);
	    Thread.sleep(2000);
	    clock2.sendKeys(Keys.CONTROL + "a");
	    clock2.sendKeys(Keys.DELETE);
	    clock2.sendKeys(formattedTime);


	}
	@Then("Publish survey")
	public void publishSurvey() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Publish Survey']")).click();
		Thread.sleep(2000);
		Add_Question_Runner.Overview(driver).click();
		Thread.sleep(3000);
		Add_Question_Runner.courseOverview(driver).click();
		
	}
	
	

    
    @When("switch to the incognito window")
    public void switchToTheIncognitoWindow() throws InterruptedException {
    	incognitoDriver.switchTo().window(incognitoWindowHandle);
        Thread.sleep(3000);
        System.out.println("Switched to the incognito window.");
    
    
    }
    

    
    @Given("student enters username as {string}")
    public void studentEntersUsernameAs(String username) {
    	Student_Login.username(incognitoDriver).sendKeys("studenttesting10@digi.com");
    }
    @Given("student enters password as {string}")
    public void studentEntersPasswordAs(String password) {
    	Student_Login.Password(incognitoDriver).sendKeys("12345678");
    }
    @When("student clicks the submit button")
    public void studentClicksTheSubmitButton()  {
    	Student_Login.Submit(incognitoDriver).click();
        
    }

    @Then("student login should be successful")
    public void studentLoginShouldBeSuccessful() throws InterruptedException {
        // You can add assertions here to verify successful login
        System.out.println("The login is successfully done");
        Thread.sleep(10000);
    }
    
    
    @Then("click on studentsideicon")
    public void clickOnStudentsideicon() {
    	Student_Login.studentsideicon(incognitoDriver).click();
    }
    
    @Then("click on survey1")
    public void clickOnSurvey1() {
    	Student_Login.survey(incognitoDriver).click();
    }
    @Then("click on Mysurvey")
    public void clickOnMysurvey() throws InterruptedException {
    	Student_Login.Mysurvey(incognitoDriver).click();
    	Thread.sleep(5000);
    }
    @Then("click on Courselevel")
    public void clickOnCourselevel() {
    	Student_Login.Courselevel(incognitoDriver).click();
    }
    
    @Then("switch the calendar1")
    public void switchTheCalendar1() throws InterruptedException {
    	WebElement academicCalendar1 = incognitoDriver.findElement(By.xpath("//div[text()='Regression-3 2023-2024']"));
    	Actions action = new Actions(incognitoDriver);
		action.moveToElement(academicCalendar1).perform();
		Thread.sleep(5000);
		academicCalendar1.click();
		incognitoDriver.findElement(By.xpath("//li[text()='2024-20258']")).click();
		Thread.sleep(5000);

    }
    
    @Then("click on Go to survey")
    public void clickOnGoToSurvey() throws InterruptedException {
    	Student_Answer.GOTOSURVEY(incognitoDriver).click();
    	Thread.sleep(5000);
    }
    
    @Then("click on StronglyAgree")
    public void clickOnStronglyAgree() {
    	Student_Answer.StronglyAgree(incognitoDriver).click();
    }
    @Then("click on Neutral")
    public void clickOnNeutral() {
    	Student_Answer.Neutral(incognitoDriver).click();
    }
    @Then("click on next page")
    public void clickOnNextPage() {
    	Student_Answer.NextPage(incognitoDriver).click();
    }
    
    @Then("click on StronglyDisAgree")
    public void clickOnStronglyDisAgree() {
    	Student_Answer.StronglyDisAgree(incognitoDriver).click();
    }
   
    @Then("click on Agree")
    public void clickOnAgree() {
    	Student_Answer.Agree(incognitoDriver).click();
    }
 
    @Then("Answer the openend question")
    public void answerTheOpenendQuestion() {
    	Student_Answer.OpenendAnswer(incognitoDriver).sendKeys("testing done good");
    }
    @Then("click on complete")
    public void clickOnComplete() throws InterruptedException {
    	Student_Answer.Complete(incognitoDriver).click();
    	Thread.sleep(5000);
    }
    @Then("close the survey")
    public void closeTheSurvey() {
    	Student_Answer.closeAnswer(incognitoDriver).click();
    	
    }
	
 
    @When("switch to the MainWindow")
   public void switchToMainWindow() throws Exception {
        mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(mainWindowHandle);
        driver.navigate().refresh();
        System.out.println("Switched back to the main window.");
    }
    @Then("click on Report icon")
    public void clickOnReportIcon() {
    	Reports_Page.Reporticon(driver).click();
    }
    @Then("click on ViewReports")
    public void clickOnViewReports() throws InterruptedException {
    	Reports_Page.ViewReports(driver).click();
    	Thread.sleep(3000);
    }
    @Then("Move to Learningoutcomesection page")
    public void moveToLearningoutcomesectionPage() throws InterruptedException {
    	WebElement Learningoutcomesection = driver.findElement(By.xpath("(//div/h6[text() = 'Overall Response'])[2]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Learningoutcomesection);
		Thread.sleep(5000);
		WebElement Learningoutcomesection1 = driver.findElement(By.xpath("//div/h6[text() = 'Overall Response Rate']"));
		js.executeScript("arguments[0].scrollIntoView(true);", Learningoutcomesection1);
		Thread.sleep(5000);
    }
    @Then("drag down to sectionA")
    public void dragDownToSectionA() throws InterruptedException {
    	Reports_Page.SectionA(driver).click();
    	Thread.sleep(5000);
    }
    @Then("click on static Anaysis")
    public void clickOnStaticAnaysis() throws InterruptedException {
    	Reports_Page.staticAnalysis(driver).click();
    	Thread.sleep(5000);
    }
    @Then("click am on the Questionnaire page")
    public void clickAmOnTheQuestionnairePage() throws InterruptedException {
    	WebElement Questionnaire = driver
				.findElement(By.xpath("//h6[text()='Questionnaire - Mean & Standard Deviation']"));
		js.executeScript("arguments[0].scrollIntoView(true);", Questionnaire);
		Thread.sleep(5000);
    }
    @Then("click on the individual question")
    public void clickOnTheIndividualQuestion() throws InterruptedException {
    	WebElement IndividualQuestions = driver.findElement(By.xpath("//div/span[text()='Individual Questions']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(IndividualQuestions, 500, 0).click().perform();
		Thread.sleep(5000);
    }
    
    @Then("drag down to question")
    public void dragDownToQuestion() throws InterruptedException {
    	driver.findElement(By.xpath("//div/span[text()='Individual Questions']")).click();
    	Thread.sleep(5000);
    }
    
    
    
    @Then("click on Individual Responders")
    public void clickOnIndividualResponders() throws InterruptedException {
    	
    	WebElement i1 = driver.findElement(By.xpath("//div[text() = 'Why Java for Automation testing?']"));
		js.executeScript("arguments[0].scrollIntoView(true);", i1);
		Thread.sleep(5000);
		WebElement IndividualResponders = driver.findElement(By.xpath("//span[text()='Individual Responders']"));
		action.moveToElement(IndividualResponders, 500, 0).click().perform();
		Thread.sleep(5000);
    	
    }
    @Then("click on the individual responders link")
    public void clickOnTheIndividualRespondersLink() throws InterruptedException {
    	driver.findElement(By.xpath("//span[text()='Individual Responders']")).click();
    	Thread.sleep(5000);
    }
    @Then("click on the View Reports")
    public void clickOnTheViewReports() throws InterruptedException {
    	Reports_Page.viewreports1(driver).click();
    	Thread.sleep(4000);
    }
    @Then("go back to the previous page")
    public void goBackToThePreviousPage() throws InterruptedException {
    	driver.findElement(By.xpath("(//*[name()='svg'])[12]")).click();
    	Thread.sleep(5000);
    	
    }
    @Then("click on Sentiment Analysis")
    public void clickOnSentimentAnalysis() throws InterruptedException {
    	driver.findElement(By.xpath("//span[text()='Sentiment Analysis']")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("(//*[name()='svg'])[13]")).click();
    	Thread.sleep(5000);
    }
    @Then("scroll to View By Individual Response")
    public void scrollToViewByIndividualResponse() throws InterruptedException {
    	WebElement Emoji = driver.findElement(By.xpath("//div[text()='View By Individual Response']"));
		js.executeScript("arguments[0].scrollIntoView(true);", Emoji);
		Thread.sleep(5000);
		driver.quit();
    }
 
 
    

    
    @And("click on the Preview button")
    public void clickOnThePreviewButton() throws InterruptedException {
    	
    	incognitoDriver.navigate().refresh();
    	Thread.sleep(5000);
    	Student_Preview.Preview(incognitoDriver).click();
    }
    @Then("click on next button")
    public void clickOnNextButton() throws InterruptedException {
    	Thread.sleep(5000);
    	Student_Preview.nextbutton(incognitoDriver).click();
    }

    
    
    @And("click on the Previous button")
    public void clickOnThePreviousButton() throws InterruptedException {
    	Thread.sleep(5000);
    	Student_Preview.previous(incognitoDriver).click();
    	incognitoDriver.quit();
    }


	
	}


	


