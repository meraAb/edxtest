import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Mera on 03-06-2017.
 */
public class Hover {

    WebDriver driver;

    public Hover(WebDriver driver) {
        this.driver = driver;
    }

    public String testHover() {
        //Hover test
        Actions builder = new Actions(driver);
        //Xpath
        WebElement we = driver.findElement(By.xpath("//*[@id=\"primary-menu-bar\"]/nav/ul/li[4]/a"));
        builder.moveToElement(we).perform();
        //xpath
        String text = driver.findElement(By.xpath("//*[@id=\"menu-tab-view119\"]/a")).getText();
        return text;
    }
}
