package pomwithfactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Login {
WebDriver driver;
	
	private String url = "https://mail.rediff.com/cgi-bin/login.cgi";
	private String expectedTitle = "Rediffmail";

	
	@FindBy(id="login1")
	WebElement userbox;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passbox;
	
	@FindBy(css="input[name='proceed']")
	WebElement loginbtn;
	
	@FindBy(tagName="a")
	List<WebElement> links;
	
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void doLoginAs(String user, String pass) {
		try {
			userbox.sendKeys(user);
			passbox.sendKeys(pass);
			loginbtn.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void assertTitle() {
		Assert.assertEquals(expectedTitle, driver.getTitle());
	}

	public void verifyTitle() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(expectedTitle, driver.getTitle());
		sa.assertAll();
	}

	public void openUrl() {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void closePage() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
