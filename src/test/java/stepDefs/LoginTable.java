package stepDefs;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTable {
	WebDriver driver;
	@Given("user open rediff.com")
	public void user_open_rediff_com() {
		WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		   
	}

	@Given("enter  username and password")
	public void enter_username_and_password(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		List<List<String>> list=dataTable.asLists();
		
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys(list.get(0).get(0));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(list.get(0).get(1));
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
	}

	@Then("verify messages")
	public void verify_messages() {
		if(driver.findElement(By.xpath("//b[contains(text(),'Wrong username and password combination.')]")).isDisplayed()) {
			System.out.println("fail");
		}
		else {
			System.out.println("Success");
		}
	}
}