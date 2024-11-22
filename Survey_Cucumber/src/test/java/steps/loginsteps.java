package steps;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
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
	
	
	
	public WebDriver incognitoDriver;
    String incognitoWindowHandle = "";
    String mainWindowHandle;
	
	
	
	      public  loginsteps() {
		ChromeOptions chromeOptions = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromeOptions.addArguments("--incognito");
		incognitoDriver = new ChromeDriver(chromeOptions);
		incognitoDriver.manage().window().maximize();
		incognitoDriver.get("https://digival-staging-nginx-ds-yk25kmkzeq-el.a.run.app/dev-dcweb/auth/login");

	}
	
	@Before
    public void setUp() {
        setUpDriver();
        //setUpIncognitoDriver();
    }
	

    public void setUpDriver() {
        String baseURL = "https://digival-staging-nginx-ds-yk25kmkzeq-el.a.run.app/dev-dcweb/auth/login";
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized", "use-fake-ui-for-media-stream"));
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
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
		Thread.sleep(10000);
		Login.Digiclass(driver).click();	
	}
	@Then("click on Survey")
	public void clickOnSurvey() {
		Survey_Home.Surveybutton(driver).click();
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
	public void requireTheQuestion() {
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
		driver.findElement(By.xpath("(//div[@class=\"sv-list__item-body\"])[5]")).click();
		WebElement Longtext = driver.findElement(By.xpath("(//span[text()= 'question_3'])[1]"));
		Longtext.click();
		Longtext.sendKeys(Keys.CONTROL + "a");
		Longtext.sendKeys(Keys.DELETE);
		Longtext.sendKeys(" Agile Software Development is based on which of the following type?");	
		
	}
	@Then("click on Create Runner step Template Survey")
	public void clickOnCreateRunnerStepTemplateSurvey() {
		Add_Question_Runner.CreateTemplateSurvey(driver).click();
	}
	
	@Then("Switch to creator to Runner")
	public void switchToCreatorToRunner() throws InterruptedException {
		WebElement chooseElement1 = driver.findElement(By.xpath("//*[@class=\"fa fa-angle-down profile_icon \"]"));
//		Actions action = new Actions(driver);
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
		WebElement academiccalendar =driver.findElement(By.xpath("//div[text()='LMS_CALENDAR-2(2024-2025)']"));
		academiccalendar.click();
		action.moveToElement(academiccalendar).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[text() = 'LMS_CALENDAR-1(2024-2025)']")).click();		
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
		WebElement PLO3 = driver.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[1]"));
		action.doubleClick(PLO3).perform();
		Thread.sleep(5000);
	}
	@Then("Click on clock1")
	public void clickOnClock1() throws InterruptedException {
		
		Outcome_Tag.clock1select(driver).click();
		Outcome_Tag.clock1label(driver).click();
		WebElement clock1 = driver.findElement(By.xpath("//input[@placeholder=\"hh:mm (a|p)m\"]"));
		Thread.sleep(5000);
		clock1.sendKeys(Keys.CONTROL + "a");
		clock1.sendKeys(Keys.DELETE);
		clock1.sendKeys("05:13 PM");
		
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
		clock2.sendKeys(Keys.CONTROL + "a");
		clock2.sendKeys(Keys.DELETE);
		clock2.sendKeys("05:15 PM");
		
	}
	@Then("Publish survey")
	public void publishSurvey() {
		driver.findElement(By.xpath("//span[text()='Publish Survey']")).click();
	}
	
	

    
    @When("switch to the incognito window")
    public void switchToTheIncognitoWindow() throws InterruptedException {
    	incognitoDriver.switchTo().window(incognitoWindowHandle);
        Thread.sleep(3000);
        System.out.println("Switched to the incognito window.");
    
    
    }
    

    
    @Given("student enters username as {string}")
    public void studentEntersUsernameAs(String username) {
    	Student_Login.username(incognitoDriver).sendKeys(username);
    }
    @Given("student enters password as {string}")
    public void studentEntersPasswordAs(String password) {
    	Student_Login.Password(incognitoDriver).sendKeys(password);
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
    	WebElement academicCalendar1 = incognitoDriver.findElement(By.xpath("//div[text()=\"new calendar\"]"));
    	Actions action = new Actions(incognitoDriver);
		action.moveToElement(academicCalendar1).perform();
		Thread.sleep(5000);
		academicCalendar1.click();
		incognitoDriver.findElement(By.xpath("//li[text()='LMS_CALENDAR-1(2024-2025)']")).click();
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
    @Then("click on StronglyDisAgree")
    public void clickOnStronglyDisAgree() {
    	Student_Answer.StronglyDisAgree(incognitoDriver).click();
    }
    @Then("click on next page")
    public void clickOnNextPage() {
    	Student_Answer.NextPage(incognitoDriver).click();
    }
    @Then("click on Agree")
    public void clickOnAgree() {
    	Student_Answer.Agree(incognitoDriver).click();
    }
    @Then("click on DisAgree")
    public void clickOnDisAgree() {
    	Student_Answer.DisAgree(incognitoDriver).click();
    }
    @Then("Answer the openend question")
    public void answerTheOpenendQuestion() {
    	Student_Answer.OpenendAnswer(incognitoDriver).sendKeys("testing done");
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
    	WebElement Learningoutcomesection = driver.findElement(By.xpath("(//div/h6[text() = 'Overall Response'])[3]"));
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
    	driver.findElement(By.xpath("(//*[name()='svg'])[10]")).click();
    	Thread.sleep(5000);
    	
    }
    @Then("click on Sentiment Analysis")
    public void clickOnSentimentAnalysis() throws InterruptedException {
    	driver.findElement(By.xpath("//span[text()='Sentiment Analysis']")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("(//*[name()='svg'])[11]")).click();
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
    public void clickOnThePreviousButton() {
    	Student_Preview.previous(incognitoDriver).click();
    }
    @And("click on the Back button")
    public void clickOnTheBackButton() {
    	Student_Preview.backbutton(incognitoDriver).click();
    	driver.quit();
    }
 
	
	}


	


