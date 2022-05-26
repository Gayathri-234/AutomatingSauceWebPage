package OpenGooglePageDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleSearch {
    @Test
    public void testGooglePage(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver edge = new EdgeDriver();
        edge.get("https://www.google.com/");
        //thread.sleep(2000);
        edge.quit();

    }

}
