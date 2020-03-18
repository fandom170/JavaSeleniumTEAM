package Tests;

import Base.TestBase;
import Base._helpers;
import Pages.GismeteoMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.codeborne.selenide.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.title;

public class GismeteoTest extends TestBase {
    WebDriver driver;

    @Test
            (testName = "Get Title", priority = 1)
    public void CheckTitle() throws InterruptedException {
        System.out.println(title());
        Assert.assertNotNull(title(), "Page was not loaded or, at least, does not have a title");
    }

     @Test
             (testName = "Get all Div from the page", priority = 2)
    public void GetAllDivs()
    {
        for (SelenideElement webElem : MainPage.listOfAllDivs())
        {
            webElem.shouldBe(Condition.enabled);//DO NOTHING
        }
        System.out.println("Test no 2");
        Assert.assertTrue(MainPage.listOfAllDivs().size() > 0, "If you see this message, then any divs has not been found");
    }

    //2. find all div with h1
     @Test
                (testName = "Get all divs with h1", priority = 3)
    public void GetH1Divs()
    {

        for (SelenideElement webElem : MainPage.listOfAllH1())
        {
            //DO NOTHING
            webElem.shouldBe(Condition.visible);
        }
        Assert.assertTrue(MainPage.listOfAllH1().size() >0, "If you see this message, then any divs with h1 tag has not been found");
    }

    //3. find all elements with news tiles
        @Test
                (testName = "Get all div with news", priority = 4)
    public void GetAllNews()
    {
        Assert.assertNotNull(MainPage.listOfNews(),  "Element is null");
    }

    //4. Find the last element from news tiles
        @Test
                (testName = "Get Last element", priority = 5)
    public void GetLastSpan()
    {
        Assert.assertNotNull(MainPage.lastNews(), "Last element in news row is null");
    }

    //5. Get all titles from items from #3
    @Test
            (testName = "Get title from elements 3", priority = 6)
    public void GetTitles()
    {
        List  <String> TitlesList = new ArrayList<>();
        for (SelenideElement elem : MainPage.listOfNews())
        {
            TitlesList.add(elem.getText());
            Assert.assertNotNull(elem.getText(), "Element of list is null");
        }
        Assert.assertTrue(TitlesList.size() > 0, "List is empty");
    }

    //6. Find element with text ...////////////////////////////////////////////////////////
        @Test
                (testName = "Get element by text content", priority = 7)
    public void GetElementByName()
    {
        String cityName = "Bradford";
        Assert.assertNotNull(MainPage.cityName(cityName));
    }

    //7. Find the element that describes city next after another city
        @Test
                (testName = "Get next element after particular element", priority = 8)
    public void GetNextElement()
    {
        String city = "London";
        Assert.assertNotNull(MainPage.nextCity(city));
    }

    //8. Find all top menu link
    @Test
            (testName = "Get element by css using tag", priority = 9)
    public void GetAllLinksFromMenu()
    {
        Assert.assertNotNull(MainPage.allLinksFromMenu());
    }

    //9. On the current city weather page find element for 3 current weekdays.
        @Test
            (testName = "Find 3-days link", priority = 10)
    public void GetThreeDaysLink()
    {
        Assert.assertNotNull(MainPage.threeDaysLink(), "Three days link element was not found");
    }

    //10. Find element for currently selected weekday
      @Test
              (testName = "Find current weekday", priority = 11)
    public void GetCurrentWeekDay()
    {
        LocalDateTime now = LocalDateTime.now();

        String date = MainPage.currentWeekDay().getText();
        System.out.println("Current date from GisMeteo = " + date);
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("E, d MMM, HH:mm");
        Assert.assertTrue(date.equalsIgnoreCase(now.format(myFormat)), "Dates are not equal");
    }

    //11. Find temperature when it's Малооблачно (1 element!!)
        @Test
            (testName = "Get temperature using axis", priority = 12)
    public void GetTemperature()
    {
        int counter = 1;
         for (SelenideElement elem : MainPage.weatherForecast())
        {
            if (elem.getText().equals("Малооблачно"))
            {
                break;
            }
            counter++;
        }
        Assert.assertNotNull(MainPage.temperature(counter).getText(), "Appropriate element has not been found");
    }

    //12. Find temeperature for main tile
        @Test
                (testName = "Get temperature using axis (2)", priority = 13)
    public void GetDayTemperature()
    {

        Assert.assertNotNull(MainPage.currentTemperature().getText(), "Appropriaete element has not been found");
    }




}
