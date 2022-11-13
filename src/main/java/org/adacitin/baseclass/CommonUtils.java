package org.adacitin.baseclass;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CommonUtils extends Setup {
	protected static ExtentReports extentreport = new ExtentReports();
	protected static ExtentHtmlReporter extenthtmlreport;
	protected static ExtentTest logger;
	
	public static Logger log = Slf4J.loadLogger(CommonUtils.class);

	
	@BeforeSuite
	public void beforeSuite() {
		extenthtmlreport = new ExtentHtmlReporter("./batch56report.html");
		extentreport.attachReporter(extenthtmlreport);
		System.out.println("befor suite");
	}
	
	
//	@Parameters({"browser"})
//	@BeforeTest
//	public void beforeTest(String name) throws Exception {
//		System.out.println(new Date());
//		System.out.println(name);
//		browserlaunch(name);
//	}
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println(new Date());
		System.out.println("before class");
	}
	
	
	
//	@Parameters({"reportpath"})
//	@BeforeTest
//	public static void browserOpen(String path) throws Exception {
//		report= new ExtentHtmlReporter(path);
//		extend.attachReporter(report);
//		browserlaunch(System.getProperty("browser"));
//		System.out.println(new Date());
//	}

	
	public void loadURL() throws IOException {
		loadUrl(ReadData.getConfigPropData("url"));
	}
	
	
	
	public static void browserlaunch(String key) throws Exception {
		switch (key) {
		case "chrome":
			System.setProperty(ReadData.getConfigPropData("chromevariable"), "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./Jar/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("the give key is not presentin the case");
			break;
		}

//		System.setProperty("webdriver.gecko.driver", "./Jar/geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();

//		System.setProperty("webdriver.chrome.driver", "./Jar/chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		
		// driver.manage().window().setSize(new Dimension(600,530));

	}

	public static void browserMaximize() {
		driver.manage().window().maximize();
	}

	public void fullScreenView() {
		driver.manage().window().fullscreen();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public void loadDifferentUrl(String tourl) {
		driver.navigate().to(tourl);
	}

	public static WebElement elementFinder(By locator) {
		return driver.findElement(locator);
//		WebElement findElement = driver.findElement(locator);
//		return findElement;

	}
	
	public static By locatorFinderById(String data) {
		return By.id(data);
	}
	
	
	public static By locatorfinderByXpath(String data) {
//		By xpath = By.xpath(data);
//		return xpath;
		
		return By.xpath(data);
		
	}
	
	@AfterSuite
	public void endReport() {
		extentreport.flush();
        log.info("The given test is completed in the given browser:"+ System.getProperty("browser"));
	}
	

	public WebElement elementfinderById(String locator) {
		return driver.findElement(By.id(locator));
	}

	public WebElement ElementFinderByxPath(String locator) {
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static By locaterfindByname(String data) {
		return By.name(data);
	}
	
	public static void type(WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}
	
	
	public static void elementClick(WebElement element) {
		element.click();
	}
	
	
//	public static void main(String[] args) {
//		browserlaunch("chrome");
//		browserMaximize();
//		loadUrl("https://www.facebook.com/");
//		
//		//advicable methods use
//		type(elementFinder(locatorFinderById("email")),"shahul");
//		type(elementFinder(locatorFinderById("pass")),"hameed");
//		elementClick(elementFinder(locaterfindByname("login")));
//		
//		// non preferable
//		WebElement username = elementFinder(By.id("email"));
//		type(username, "shahul");
//		WebElement password = elementFinder(By.id("pass"));
//		type(password, "hameed");
//		WebElement login = elementFinder(By.name("login"));
//		elementClick(login);
//		
//		
//		
//		elementFinder(locatorFinderById("email"));
//		elementFinder(By.name("pass"));
//		elementFinder(locatorfinderByXpath("//button[@name='login']"));
//		elementFinder(By.xpath("//button[@name='login']"));
//		
//		type(elementFinder(locatorFinderById("email")),"hameed");
//	
//	sdjhfkjsd
//	}

}
