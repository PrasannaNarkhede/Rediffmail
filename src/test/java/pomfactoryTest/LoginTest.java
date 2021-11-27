package pomfactoryTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomwithfactory.Login;

public class LoginTest {
	Login lp;
	WebDriver driver;
  @Test
  public void login() {
	  lp.openUrl();
	  lp.assertTitle();
	  lp.doLoginAs("Selenium", "Selenium321");
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  lp=new Login(driver);
  }
  @AfterMethod
  public void afterMethod() {
	  lp.closePage();
  }

}
