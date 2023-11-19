package tests.base;

import common.CommonAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.BasePage;
import pages.CalculatorPage;


import static common.Config.CLEAN_COOCIES_AND_LOKAL_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
   protected CalculatorPage calculator = new CalculatorPage(driver);

    @AfterTest
    public void clearCoociesAndLOcalStorage(){
        if (CLEAN_COOCIES_AND_LOKAL_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite (alwaysRun = true)
    public void close(){
        if (HOLD_BROWSER_OPEN){
            driver.quit();
        }

    }
}
