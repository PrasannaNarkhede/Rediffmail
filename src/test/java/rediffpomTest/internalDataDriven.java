package rediffpomTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rediffpomPages.Login;

public class internalDataDriven {
WebDriver driver;
Login lp;

@DataProvider
public Object[][] dp(){
	
	
	Object[][] obj=new Object[4][2];
	obj[0][0]="User1";
	obj[0][1]="pass1";
	
	obj[1][0]="User2";
	obj[1][1]="pass2";
	
	obj[2][0]="User3";
	obj[2][1]="pass3";
	
	obj[3][0]="User4";
	obj[3][1]="pass4";
	
	return obj;
}





@Test(dataProvider="dp")
public void f(String user,String pass) {
	lp.openUrl();
	lp.verifyTitle();
	lp.doLoginAs(user, pass);
	

	
}

@BeforeMethod
public void beforeMethod() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	lp = new Login(driver);
}

@AfterMethod
public void afterMethod() {
	lp.closePage();
}
}
			