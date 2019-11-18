package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	static WebDriver driver;

	public static void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hi\\eclipse-workspace\\KalaiVaniV\\SeleniumClass\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	public static void type(WebElement loc, String in) {
		loc.sendKeys(in);
	}

	public static void click(WebElement loc) {
		loc.click();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static String getData(int r, int c) throws IOException {
		File loc = new File("C:\\Users\\hi\\eclipse-workspace\\KalaiVaniV\\MavenDataDriven\\excel\\DataDriven.xlsx");
		FileInputStream in = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(in);
		Sheet s = w.getSheet("Data");
		Row row = s.getRow(r);
		Cell cell = row.getCell(c);
		int type = cell.getCellType();
		String value = null;
		if (type == 1) {
			value = cell.getStringCellValue();
		}

		else if (type == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("mm/dd/yyyy");
				value = sim.format(d);
			} 
			else {
				double num = cell.getNumericCellValue();
				long l = (long) num;
				value = String.valueOf(l);
			}
		}
		return value;
	}
}
