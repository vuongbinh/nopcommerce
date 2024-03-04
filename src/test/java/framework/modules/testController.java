package framework.modules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

public class testController {
    static WebDriver driver;
    Properties pros = new Properties();
    public static WebDriverWait wait;
    public static WebElement element;

//    public static WebDriver openBrowser(String browserName, boolean isHeadless) {
//        switch (browserName) {
//            case "chrome":
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("window-size=1920,1080");
//                if (isHeadless) {
//                    chromeOptions.addArguments("--Headless");
//                }
//                chromeOptions.addArguments("--remote-allow-origins=*");
//                return new ChromeDriver(chromeOptions);
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                FirefoxBinary firefoxBinary = new FirefoxBinary();
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.setBinary(firefoxBinary);
//                if (isHeadless) {
//                    firefoxOptions.setHeadless(true);
//                }
//                return new FirefoxDriver(firefoxOptions);
//        }
//
//
//        if (browserName.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("window-size=1920,1080");
//            if (isHeadless) {
//                options.addArguments("--Headless");
//            }
//            options.addArguments("--remote-allow-origins=*");
//            return new ChromeDriver(options);
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            FirefoxBinary firefoxBinary = new FirefoxBinary();
//            FirefoxOptions options = new FirefoxOptions();
//            options.setBinary(firefoxBinary);
//            options.setHeadless(true);
//            return new FirefoxDriver(options);
//        } else throw new IllegalArgumentException("The Browser " + browserName + " does not support");
//    }

    protected static Object[][] getDataFromFile(Sheet excelSheet) {
        int rowCOUNT = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum();
        Object[][] object = new Object[rowCOUNT][2];
        for (int i = 0; i < rowCOUNT; i++) {
            Row row = excelSheet.getRow(i + 1);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                object[i][j] = row.getCell(j).toString();
            }
        }
        return object;
    }

//    @Parameters({"browserName", "isHeadless"})
    @BeforeClass
    void setup() {
//        driver = openBrowser(browserName, isHeadless);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
