package com.swaglabs.config;

import com.swaglabs.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    private static WebDriver driver;
    protected static LoginPage loginPage;

    public static WebDriver getDriver() {
        if (driver == null) {
            String env = System.getProperty("env", "local");   // local or docker
            String browser = System.getProperty("browser", "chrome"); // chrome or edge
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

                // --- Run locally ---
                if (browser.equalsIgnoreCase("chrome")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new"); // headless mode
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
//            driver = new ChromeDriver();
                    driver = new ChromeDriver(options); //headless
                    driver.manage().window().maximize();

                } else if (browser.equalsIgnoreCase("edge")) {
                    System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();

                } else {
                    throw new RuntimeException("Unsupported browser: " + browser);
                }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
