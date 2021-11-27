package gridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	RemoteWebDriver driver;

	@Test
	public void f() {

		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		String nodeurl = "http://localhost:5556/wd/hub";
		driver = new RemoteWebDriver(new URL(nodeurl), cap);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}