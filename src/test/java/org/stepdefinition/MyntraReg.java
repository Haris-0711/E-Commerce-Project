package org.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.bs.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rc.PojoClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraReg extends BaseClass {
	@Given("To launch the web browser")
	public void toLaunchTheWebBrowser() {
		launchBrowser();
		windowMaximize();
	}

	@When("To open the url of myntra website")
	public void toOpenTheUrlOfMyntraWebsite() {
		launchUrl("https://www.myntra.com/");
	}

	@When("To type and search the Tshirt product")
	public void toTypeAndSearchTheTshirtProduct() throws InterruptedException {
		sleep();
		PojoClass po = new PojoClass();
		passingText("Tshirt", po.getSrch());
		clickBtn(po.getSrchbtn());

	}

	@When("To select the first product and select M size")
	public void toSelectTheFirstProductAndSelectMSize() throws InterruptedException {
		sleep();
		PojoClass po = new PojoClass();
		clickBtn(po.getProduct());
		sleep();
		String parentid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for (String winid : allid) {
			if (winid != parentid) {
				driver.switchTo().window(winid);
			}
		}
		clickBtn(po.getSize());

	}

	@When("To click Add to bag button")
	public void toClickAddToBagButton() throws InterruptedException {
		sleep();
		String parentid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for (String winid : allid) {
			if (winid != parentid) {
				driver.switchTo().window(winid);
			}
		}
		PojoClass po = new PojoClass();
		clickBtn(po.getAddbag());
	}

	@When("TO click the bag icon")
	public void toClickTheBagIcon() throws InterruptedException {
		sleep();
		PojoClass po = new PojoClass();
		clickBtn(po.getBagicon());
	}

	@Then("Take screenshot of the payment page")
	public void takeScreenshotOfThePaymentPage() throws IOException, InterruptedException {
		sleep();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameIntreview\\SS\\myntra.png");
		FileUtils.copyFile(img, f);

	}
}