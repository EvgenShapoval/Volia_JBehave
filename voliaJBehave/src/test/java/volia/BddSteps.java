package volia;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.WebLibrary;
import pages.CompanyPage;
import pages.DataCenterPage;
import pages.ITPage;
import pages.VacanciesPage;
import pages.VoliaHomePage;

public class BddSteps {
	
	protected static WebDriver driver;
	
	@BeforeScenario
	public void beforeScenario() {
//		System.setProperty("webdriver.chrome.driver", "D:/soft/java/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println();
		System.out.println("BeforeScenario section");
		System.out.println();
	}
	
	@AfterScenario
	public void afterScenario() {
		System.out.println();
		System.out.println("After scenario section");
		System.out.println();
		
		driver.quit();
	}
	
	
	@Given("Открыть HomePage volia.com")
	public void iOpen() {
		driver.get("https://volia.com/");
	}
	
//	Scenario: Проверка количества вакансий на ITPage
	
	@When("В блоке menu выбрать Світ Волі")
	public void in_Menu_block_select_CompanyPage() {
		VoliaHomePage homePage = new VoliaHomePage(driver);
			homePage.clickCompanyPage();
	}
	
	@When("На CompanyPage в блоке menu main кликнуть по Вакансіі")
	public void in_CompanyPage_in_mainMenu_block_click_on_Vacancies() {
		CompanyPage companyPage = new CompanyPage(driver);
			companyPage.clickVacanciesPage();
	}
	
	@When("На VacanciesPage в сайдбаре выбрать IT")
	public void on_VacanciesPage_in_sidebar_select_IT() {
		VacanciesPage vacanciesPage = new VacanciesPage(driver);
			vacanciesPage.clickITPage();
	}
	
	@Then("Проверить, что на ITPage отображается '$expIT' вакансии")
	public void check_that_2_vacancies_are_displayed_on_ITPage(int expIT) {
		ITPage iTPage = new ITPage(driver);
		
			int expNumberIT = expIT;
			int actNumberIT = iTPage.numberITPage();
		
		Assert.assertTrue("Fail. Ожидали сообщение - " + expNumberIT 
				+ ". Было получено сообщение - " + actNumberIT, expNumberIT == actNumberIT);
	} 
	

//	Scenario: Проверяем с заявленной на сайте стоимостью аренды сервера 
	
	@When("В блоке Menu кликаем по вкладке «Дата-центр ВОЛЯ»")
	public void in_Menu_block_click_DataCenter() {
		VoliaHomePage homePage = new VoliaHomePage(driver);
			homePage.clickdataCenterPage();
	}
	
	@Then("Сравниваем Вартість сервера Від '$serverPrice' грн/міс с заявленной на сайте")
	public void compare_price_server_with_stated_on_site(int expServerPrice) {
		DataCenterPage dataCPage = new DataCenterPage(driver);
		
		String textPrice = dataCPage.serverPriceString();
		int modServerPrice = WebLibrary.cutStingReturnInt(textPrice, 4, 7);
	
		Assert.assertTrue("Fail. Цена сервера на сайте - " + textPrice 
				+ ". Не равна ожидаемой - "	+ expServerPrice, 
				modServerPrice == expServerPrice);
	}
	
	
//	Scenario: Authorization error in My account
	
//	Scenario: Authorization error in My account
//	Given I open HomePage volia.com
//	When I click My account in login-block
//	When I enter '37373' in username
//	When I enter 'bd86' in password
//	When I click checkbox  - rememberme - and click buttonSubmit
//	Then Compare the result with the expected - 'Дані не збіглися'
	
	
//	@Given("I open HomePage volia.com")
//	public void iOpen() {
//		driver.get("https://volia.com/");
//	}
	
//	@When("I click My account in login-block")
//	public void clickMyAccoun() {
//		VoliaHomePage homePage = new VoliaHomePage(driver);
//		homePage.clickSignInMyVoliaPage();
//	}
//	
//	@When("I enter '$username'  in username")
//	public void enterUsername(String username) {
//		SignInMyVoliaPage signInMyVoliaPage = new SignInMyVoliaPage(driver);
//		signInMyVoliaPage.inputUsernameSignInMyVoliaPage(username);
//	}
//	
//	@When("I enter '$password' in password")
//	public void enterPassword(String password) {
//		SignInMyVoliaPage signInMyVoliaPage = new SignInMyVoliaPage(driver);
//		signInMyVoliaPage.inputUsernameSignInMyVoliaPage(password);
//	}
//	
//	
//	@When("I click checkbox  - rememberme - and click buttonSubmit")
//	public void clickCheckboxAndClickButtonSubmit(String username) {
//		SignInMyVoliaPage signInMyVoliaPage = new SignInMyVoliaPage(driver);
//		signInMyVoliaPage.clickAFormSignInMyVoliaPage();
//		signInMyVoliaPage.clickSubmitSignInMyVoliaPage();
//	}
//	
//	
//	@Then("Compare the result with the expected - '$errorMessage'")
//	public void verificationThen(String errorMessage) {
//		ErrorMyVoliaPage errorMyVolia = new ErrorMyVoliaPage(driver);
//		
//		String expectedError = errorMessage;
//		String actualError = errorMyVolia.actualErrorMyVoliaPage();
//
//		
//		Assert.assertTrue("Fail. Ожидали сообщение - " + expectedError 
//				+ ". Было получено сообщение - " + actualError, actualError.contains(expectedError));
//	} 

}
