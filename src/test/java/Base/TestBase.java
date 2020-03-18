package Base;

import Pages.GismeteoMain;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


//import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideTargetLocator;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.testng.TextReport;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait Wait;
    public GismeteoMain MainPage;


    @BeforeSuite (alwaysRun = true)
    public void SetUp()
    {
        //Configuration.timeout=5000;

        System.setProperty("webdriver.chrome.driver", _helpers.pathDriver);
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(this.driver);
        Wait = new WebDriverWait(driver, 12);
        driver.manage().window().maximize();

        //selecting of URL
        if (_helpers.goal.equals("Gismeteo")) {
            driver.navigate().to(_helpers.URLGISMETEO);
            MainPage = new GismeteoMain(driver);
        }
        else {
            //MainPage = new Pages.WizzAirMain(driver);
            driver.navigate().to(_helpers.URLWIZZ);
        }

    }

    @AfterSuite
    public void TearDown () throws InterruptedException {

        Thread.sleep(10000);
        WebDriverRunner.closeWebDriver();

        //driver.close();
        //driver.quit();
    }

    public void SwitchToNewTab()
    {
        /*
        var popup = driver.WindowHandles[1]; // handler for the new tab
        Assert.IsTrue(!string.IsNullOrEmpty(popup)); // tab was opened
        //Assert.AreEqual(driver.SwitchTo().Window(popup).Url, "http://blah"); // url is OK
        // close the tab
        */
    }

    public void closeTabById (int tabId) {
        //driver.switchTo().window(driver.windowHandles[1]).Close();
    }

    public void ReturnToParentTab()
    {
        //driver.SwitchTo().Window(driver.WindowHandles[0]);
    }
}
