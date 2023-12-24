import kz.bcc.Main;
import org.junit.Before;
import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldTest {

        WebDriver driver;

        @Before
        public void startUp(){
            WebDriverManager.chromedriver().setup();
        }

        @Test
        public void testHelloWorld() {
            Main.main(new String[0]);
            driver = new ChromeDriver();
        }

    }
