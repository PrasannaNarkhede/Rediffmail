package rediffpomTest;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rediffpomPages.Login;

public class ExternalDataDriven {

	WebDriver driver;
	Login lp;

	@Test(dataProvider = "dp")
	public void f(String user, String pass) {
		driver = new ChromeDriver();
		lp = new Login(driver);
		lp.openUrl();
		lp.verifyTitle();
		lp.doLoginAs(user, pass);
	}

	@AfterMethod
	public void afterMethod() {
		lp.closePage();
	}

	@DataProvider
	public Object[][] dp() throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook(".//src//test//resources//Files//RediffLoginData.xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		int cellNum = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowNum][cellNum];

		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {

				if (sheet.getRow(i).getCell(j).getCellType().equals(CellType.STRING)) {
					obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				} else if (sheet.getRow(i).getCell(j).getCellType().equals(CellType.NUMERIC)) {
					obj[i][j] = String.valueOf(sheet.getRow(i).getCell(j).getNumericCellValue());
				} else if (sheet.getRow(i).getCell(j).getCellType().equals(CellType.FORMULA)) {
					obj[i][j] = String.valueOf(sheet.getRow(i).getCell(j).getCellFormula());
				} else if (sheet.getRow(i).getCell(j).getCellType().equals(CellType.BLANK)) {
					obj[i][j] = String.valueOf(sheet.getRow(i).getCell(j).getStringCellValue());
				} else if (sheet.getRow(i).getCell(j).getCellType().equals(CellType.BOOLEAN)) {
					obj[i][j] = String.valueOf(sheet.getRow(i).getCell(j).getBooleanCellValue());
				}
			}
		}
		wb.close();

		return obj;

	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		
	}

}
