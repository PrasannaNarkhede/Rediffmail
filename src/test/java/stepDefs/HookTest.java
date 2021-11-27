package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HookTest {
	WebDriver driver;

	@Before()
	public void beforeScenario() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}
	
	@After()
	public void afterScenario() {
		driver.quit();
	}
	
	@Given("first step")
	public void first_step() {
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Selenium");
	}

	@Given("second step")
	public void second_step() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test1");
	}
	
	@Then("third step")
	public void third_step() {
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
	}

	@Given("Fourth step")
	public void fourth_step() {
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Selenium");
	}

	@Given("fiveth step")
	public void fiveth_step() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test2");
	}

	@Then("sixth step")
	public void sixth_step() {
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
	}

}
