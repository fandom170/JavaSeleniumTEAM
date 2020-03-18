package Pages;

import Locators.GisMeteoLocators;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GismeteoMain {

     WebDriver driver;

     public GismeteoMain (WebDriver driver) {
         this.driver = driver;
     }

     private By TitlesFromNews = By.cssSelector(Locators.GisMeteoLocators.TitlesFromNews);
     private By ListOfAllDivs = By.tagName("div");
     private By ListOfAllH1 = By.xpath(GisMeteoLocators.DivWithH1);
     private By ListOfNews = By.cssSelector(Locators.GisMeteoLocators.AllNewsTiles);
     private By LastNewTitle = By.xpath(Locators.GisMeteoLocators.LastNewsElement);
     private By AllLinksFromMenu = By.cssSelector(Locators.GisMeteoLocators.ItemsFromTopMenu);
     private By ThreeDaysLink = By.xpath(Locators.GisMeteoLocators.ThreeDaysLink);
     private By CurrentWeekDay = By.xpath(Locators.GisMeteoLocators.CurrentWeekDay);
     private By WeatherForecast = By.xpath(GisMeteoLocators.WeatherForecast);
     private By CurrentTemperature = By.xpath(Locators.GisMeteoLocators.CurrentTemp);


    public SelenideElement cityName(String name) {
        return $(By.xpath(GisMeteoLocators.CityNameFirst + name + GisMeteoLocators.CityNameLast));
    }

    public SelenideElement nextCity(String name) {
        return $(By.xpath(GisMeteoLocators.NextCityFirst + name + GisMeteoLocators.NextCityLast));
    }

    public SelenideElement temperature(int counter) {
        return $(By.xpath(GisMeteoLocators.TemperatureFirst + counter + GisMeteoLocators.TemperatureLast));
    }

    public SelenideElement currentTemperature () {return $(CurrentTemperature);}

    public List <SelenideElement> weatherForecast () {return $$(WeatherForecast);}

    public SelenideElement currentWeekDay () {return $(CurrentWeekDay);}

    public SelenideElement threeDaysLink () {return $(ThreeDaysLink);}

    public List<SelenideElement> listOfAllDivs () {
        return $$(ListOfAllDivs);
    }

    public List <SelenideElement> listOfAllH1 () {return $$(ListOfAllH1);}

    public List <SelenideElement> listOfNews () {
        return $$(ListOfNews);
    }

    public SelenideElement lastNews() {return $(LastNewTitle);}

    public List <SelenideElement> allLinksFromMenu () {return $$(AllLinksFromMenu);}



}
