package com.automation.AutomationQAChallenge_apis.QAChallenge_apis.conguration.driverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.AutomationQAChallenge_apis.QAChallenge_apis.conguration.Config;

/**
 * This class is used to initialize web driver based on the browser type.
 * 
 */
public class BrowserDriver {


	public static WebDriver driver = null;
	public static int webDriverTimeout = 10;
	public static String device_name = System.getProperty("devive.name", Config.DEVICE_NAME);
	public static String platform_name = System.getProperty("platform.name", Config.PLATFORM_NAME);
	public static String platform_version = System.getProperty("platform.version", Config.PLATFORM_VERSION);
	private static final String CHROME_DRIVER = "chromedriver/chromedriver.exe";
	private static final String INTERNET_DRIVER = "iedriver/IEDriverServer.exe";
	private static final String GECKO_DRIVER = "geckodriver/geckodriver.exe";
	

	public static void setup() throws Exception {
		Config.readConfig();
	}

	public static void setupWithoutBrowser() throws Exception {
		Config.readConfig();
	}

	public static void setupWithBrowser() throws Exception {
		Config.readConfig();
		setupBrowser();
	}

	public static void setupBrowser() throws MalformedURLException {
		// Setting the WebDriver browser
		try {
			String browserType = System.getProperty("default.browser", Config.DEFAULT_BROWSER);
			System.out.println(browserType);
			setBrowser(Browser.getType(browserType));
			driver.manage().deleteAllCookies();
		} catch (Exception e) {
			System.out.println(e.toString());
			setBrowser(Browser.FIREFOX);
		}
	}


	/**
	 * Enables the changing of a browser during runtime. If an instance is up
	 * and running it will be closed and a new driver will be instantiated.
	 * Default driver is <code>FirefoxDriver</code>
	 * 
	 * @param browserType @see Browser
	 * @throws MalformedURLException 
	 */
	public static void setBrowser(Browser browserType) throws MalformedURLException {
		if (driver != null) {
			driver.quit();
		}
		switch (browserType) {
			case CHROME:											//For chrome browser
				System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
				System.getProperty("webdriver.chrome.driver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				driver = new ChromeDriver(chromeOptions);
				driver.manage().timeouts().implicitlyWait(Long.parseLong(Config.TIMEOUT_SMALL_MS), TimeUnit.SECONDS);
				driver.manage().window().setSize(new Dimension(1000, 1000));
				break;
			case INTERNET_EXPLORER:									//For Internet explorer browser
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				System.setProperty("webdriver.ie.driver", INTERNET_DRIVER);
				caps.setCapability("ignoreZoomSetting", true);
				caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				System.getProperty("webdriver.ie.driver");
				driver = new InternetExplorerDriver(caps);
				driver.manage().window().setSize(new Dimension(1000, 1000));
				driver.manage().timeouts().implicitlyWait(Long.parseLong(Config.TIMEOUT_SMALL_MS), TimeUnit.SECONDS);
				break;
			case ANDROID:											//For android driver
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
				capabilities.setCapability("platformVersion", platform_version);
				capabilities.setCapability("platformName", platform_name);
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
				driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				driver.manage().timeouts().implicitlyWait(Long.parseLong(Config.TIMEOUT_SMALL_MS), TimeUnit.SECONDS);
				break;
			default:												//For firefox browser 
				System.setProperty("webdriver.gecko.driver", GECKO_DRIVER);
				driver = new FirefoxDriver();
				driver.manage().window().setSize(new Dimension(1000, 1000));
				driver.manage().timeouts().implicitlyWait(Long.parseLong(Config.TIMEOUT_SMALL_MS), TimeUnit.SECONDS);
		}
	}

}
