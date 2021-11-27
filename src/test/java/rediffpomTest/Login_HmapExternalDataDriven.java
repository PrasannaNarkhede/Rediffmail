package rediffpomTest;

import java.io.IOException;
import java.util.HashMap;

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

public class Login_HmapExternalDataDriven {
	WebDriver driver;
	Login lp;

	@Test(dataProvider = "dp")
	public void f(HashMap<String, String> hmap) {

		driver = new ChromeDriver();
		lp = new Login(driver);
		lp.openUrl();
		lp.verifyTitle();
		lp.doLoginAs(hmap.get("UserName"), hmap.get("Password"));

	}

	@AfterMethod
	public void afterMethod() {
		lp.closePage();
	}

	@DataProvider
	public Object[][] dp() throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook(".//src//test//resources//Files//RediffLoginData.xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		int cellNum = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowNum][1];

		for (int i = 0; i < rowNum; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			String key = "";
			String value = "";
			for (int j = 0; j < cellNum; j++) {
				key = sheet.getRow(0).getCell(j).getStringCellValue();
				if (sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.STRING)) {

					value = sheet.getRow(i + 1).getCell(j).getStringCellValue();

				} else if (sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.NUMERIC)) {
					value = String.valueOf(sheet.getRow(i + 1).getCell(j).getNumericCellValue());
				} else if (sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.FORMULA)) {
					value = String.valueOf(sheet.getRow(i + 1).getCell(j).getCellFormula());
				}
				map.put(key, value);

			}
			obj[i][0] = map;

		}
		wb.close();

		return obj;

	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();

	}

}