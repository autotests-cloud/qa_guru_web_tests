package tests;

import com.codeborne.selenide.Configuration;
import drivers.CustomWebDriver;
import helpers.PropertiesHelper;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    public static PropertiesHelper config;


    @BeforeAll
    public static void beforeAll() {
        config = ConfigFactory.newInstance().create(PropertiesHelper.class, System.getProperties());

        Configuration.browser = CustomWebDriver.class.getName();
        Configuration.baseUrl = config.webUrl();

    }
}
