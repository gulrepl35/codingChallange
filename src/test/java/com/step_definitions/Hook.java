package com.step_definitions;

import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;
public class Hook {
    private static Logger logger = Logger.getLogger(Hook.class);

    @Before()
    public void setup(Scenario scenario) throws InterruptedException {
        logger.info("##############################");
        logger.info("Test setup!");
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url" + ConfigurationReader.getProperty("Environment")));

    }

    @After()
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Test failed!!!");
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", "screenshot");
        } else {
            logger.info("Cleanup!");
            logger.info("Test completed!");
        }
        logger.info("##############################");
        Driver.closeDriver();

    }
}