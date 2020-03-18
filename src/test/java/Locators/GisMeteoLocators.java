package Locators;

public class GisMeteoLocators {
    public static String DivWithH1 = ".//div[@h1]";
    public static String AllNewsTiles = ".readmore_item";

    public static String TitlesFromNews = ".readmore_title";

    public static String ItemsFromTopMenu = "li.nav_item a";

    public static String LastNewsElement = ".//*[@class = 'readmore_list']/div[last()]";

    public static String ThreeDaysLink = ".//li[@class = 'nolink subnav_item']//a[contains(text(), '3')]";

    public static String CurrentWeekDay = ".//div[@id = 'time']/span";

    public static String CurrentTemp = ".//div[contains(@class, 'description gray')]/ancestor::div[@class = 'wn_body']//div[@data-type = 'temperature']";

    public static String CityNameFirst = ".//div[@class = 'cities_item']//span[contains(text(), '";
    public static String CityNameLast = "')]";

    public static String NextCityFirst = ".//*[contains(text(),";
    public static String NextCityLast = ")]/ancestor::div/a";

    public static String WeatherForecast = ".//div[contains(@class, '_line iconline clearfix')]//span[@class = 'tooltip']";

    public static String TemperatureFirst = ".//div[contains(@class, 'chart chart__temperatureNearest')]/div/div['";
    public static String TemperatureLast = "']";
}
