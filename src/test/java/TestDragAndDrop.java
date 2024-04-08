import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.netty.util.internal.ThreadExecutorMap;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class TestDragAndDrop {

    public AppiumDriver driver;
    public Action action;
    public boolean isDisplayed;
    public ArrayList<String> fromElements = new ArrayList<String>(
            Arrays.asList("drag-l1","drag-l2","drag-l3","drag-c1", "drag-c2",
                    "drag-c3", "drag-r1", "drag-r2","drag-r3"));
    public ArrayList<String> toElements = new ArrayList<String>(
            Arrays.asList("drop-l1","drop-l2","drop-l3","drop-c1", "drop-c2",
                    "drop-c3", "drop-r1", "drop-r2","drop-r3"));
    int j;

    public static final String drugAndDropXpath = "//android.widget.TextView[@text=\"\uDB80\uDDDB\"]";


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "8.1");
        desiredCapabilities.setCapability("automationName","UIAutomator2");
        desiredCapabilities.setCapability("deviceName","emulator-5554");
        desiredCapabilities.setCapability("appPackage","com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity",".MainActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement drugAndDrp = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='\uDB80\uDDDB']"));

        drugAndDrp.click();

    }

    @Test
    @Description("This is test Robot building puzzles")
    @Story("Puzzles")
    @Feature("Robot building")
    @Issue("1234")

    public void testRobotBuilding() throws RuntimeException, InterruptedException {
        for (j=0;j<fromElements.size(); j++) {
            WebElement fromElement = driver.findElement(AppiumBy.accessibilityId(fromElements.get(j)));
            WebElement toElement = driver.findElement(AppiumBy.accessibilityId(toElements.get(j)));
            toElement.getLocation();
            isDisplayed = toElement.isDisplayed();
            Assert.assertEquals(isDisplayed, true, "Puzzle is not installed");
            System.out.println("ToElement displayed at Start " + isDisplayed);
            WebElement draggable = driver.findElement(AppiumBy.accessibilityId(fromElements.get(j)));
            Rectangle start = draggable.getRect();
            Rectangle finish = driver.findElement(AppiumBy.accessibilityId(toElements.get(j))).getRect();
            new Actions(driver)
                    .dragAndDropBy(draggable, (finish.getX() - start.getX() +1), (finish.getY() - start.getY()+1))
                    .perform();
            Thread.sleep(2000);
            isDisplayed = toElement.isDisplayed();
            System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
            System.out.println(fromElement.getLocation());
            Assert.assertFalse(isDisplayed, "Puzzle is not installed");
        }

    }

        @AfterTest
        public void congratsAndQuit() {
            try{
                WebElement fromElement = driver.findElement(AppiumBy.xpath
                        ("//android.widget.TextView[@text='You made it, click retry if you want to try it again.']"));

                WebElement toElement = driver.findElement(AppiumBy.accessibilityId("button-Retry"));
                Assert.assertEquals(fromElement.getText(), "You made it, click retry if you want to try it again.", "What's wrong?");
                toElement.click();

            }catch (NoSuchElementException e) {
                System.out.println("I don't know what is wrong");
            }
            driver.quit();

        }
}
