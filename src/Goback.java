import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mera on 01-06-2017.
 */
public class Goback {

    WebDriver driver;

    public Goback(WebDriver driver) {
        this.driver = driver;
    }
     // history Go back test
    public String goBack() {
        //Xpath
        driver.findElement(By.xpath(".//*[@id='page']/header/div/div/div/div[3]/nav/a[1]")).click();
        driver.navigate().back();
        String title = driver.getTitle().toString();
        return title;
    }
}
