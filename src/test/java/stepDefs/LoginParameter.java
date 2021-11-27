package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginParameter {
	WebDriver driver;
	@Given("application is opened user enter {string}")
	public void application_is_opened_user_enter(String string) {
		WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		   driver.findElement(By.xpath("//input[@id='login1']")).sendKeys(string);
	}

	@Given("user enter {string}")
	public void user_enter(String string) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(string);
	}

	@Given("user click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
	}

	@Then("I verify the {string}")
	public void i_verify_the(String string) {
		if(driver.findElement(By.xpath("//b[contains(text(),'Wrong username and password combination.')]")).isDisplayed()) {
			System.out.println(string);
		}
		else {
			System.out.println("Success");
		}
	}

}

