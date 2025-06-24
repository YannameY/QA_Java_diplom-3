// BrowserFactory.java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static int choice = 2;
    protected WebDriver driver;
    public static WebDriver createDriver(int choice) {
        switch (choice) {
            case 1:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case 2:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case 3:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("Некорректный выбор браузера");
        }
    }
}
