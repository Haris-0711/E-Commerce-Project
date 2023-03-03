package org.bs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void launchBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}
	

	public static void pageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	public static void passingText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}

	public static void closingBrowser() {
		driver.quit();
	}

	public static void clickBtn(WebElement ele) {
		ele.click();
	}

	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File F = new File("location + imgName.png");
		FileUtils.copyFile(image, F);
	}

	public static Actions a;

	public static void moveCursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}

	public static void dragdrop(WebElement dragWebElement, WebElement dropWebElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropWebElement).perform();
	}

	public static void rightClick(WebElement tarWebElement) {
		a = new Actions(driver);
		a.contextClick(tarWebElement).perform();
	}

	public static void switchingFrame(WebElement e) {
		driver.switchTo().frame(e);
	}

	public static void WindowHandling() {
		String parentId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		for (String winId : allWindowId) {
			if (winId != parentId) {
				driver.switchTo().window(winId);
			} else if (winId == parentId) {
				driver.switchTo().window(winId);
			}
		}
	}

	public static JavascriptExecutor js;

	public static void scrollPageTop(WebElement tarWebElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebElement);
	}

	public static void scrollPageDown(WebElement tarWebElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", tarWebElement);
	}
	
	public static void jsClick(WebElement tarWebElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", tarWebElement);
	}
	public static void jspassingText(String txt, WebElement tarWebElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', txt)" ,tarWebElement);
	}

	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excellocation.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet mysheet = wb.getSheet("Sheet1");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();
		String value = " ";
		if (cellType == 1) {
			String stringCell = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String format = s.format(dd);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);
		}
	}

	public static void createNewExcel(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDriver\\Excel\\DD6CH.xlsx");

		Workbook wb = new XSSFWorkbook();
		Sheet newSheet = wb.createSheet("sheet1");
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(newData);
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);

	}

	public static void createCell(int cRow, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDriver\\Excel\\DD6CH.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet mysheet = wb.getSheet("Sheet1");
		Row r = mysheet.getRow(cRow);
		Cell c = r.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
	}

	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDriver\\Excel\\DD6CH.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet newSheet = wb.getSheet("Sheet1");
		Row newRow = newSheet.createRow(creRow);
		Cell newCell = newRow.createCell(creCell);
		newCell.setCellValue(newData);
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
	}

	public static void updateDataToParticularCell(int getTheRow, int getTheCell, String exisitingData,
			String writeNewData) throws IOException {
		File f = new File("C:\\\\Users\\\\LENOVO\\\\eclipse-workspace\\\\MavenDataDriver\\\\Excel\\\\DD6CH.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Sheet1");
		Row r = s.getRow(getTheRow);
		Cell c = r.getCell(getTheCell);
		String str = c.getStringCellValue();
		if (str.equals(exisitingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	public static Robot r;
	
	public static void pressEnter() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	public static void releaseEnter() throws AWTException {
		r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void sleep() throws InterruptedException {
		Thread.sleep(3000);
	}
	
}
