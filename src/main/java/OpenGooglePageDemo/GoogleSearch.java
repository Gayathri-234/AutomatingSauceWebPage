package OpenGooglePageDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class GoogleSearch {
    @Test
    public void testGooglePage() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver edge = new EdgeDriver();
        edge.get("https://www.google.com/");
        Thread.sleep(2000);
        edge.quit();

    }

}
