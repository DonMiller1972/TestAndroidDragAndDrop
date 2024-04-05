import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestDragAndDrop {


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-l1\"]/android.widget.ImageView")
    static WebElement leftEar;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-l2\"]/android.widget.ImageView")
    WebElement leftArm;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-l3\"]/android.widget.ImageView")
    WebElement leftHandArm;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-c1\"]/android.widget.ImageView")
    WebElement twoEyes;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-c2\"]/android.widget.ImageView")
    WebElement cenrBody;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-c3\"]/android.widget.ImageView")
    WebElement centrLegs;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-r1\"]/android.widget.ImageView")
    WebElement rightEar;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-r2\"]/android.widget.ImageView")
    WebElement rightArm;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-r3\"]/android.widget.ImageView")
    WebElement rightHandLeg;

    @FindBy(xpath = "android.view.ViewGroup[@content-desc=\"drop-l1\"]/android.view.ViewGroup")
    static WebElement toLeftEar;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-l2\"]/android.view.ViewGroup")
    static WebElement toLeftHand;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-l2\"]/android.view.ViewGroup")
    WebElement toLeftHandLeg;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-c1\"]/android.view.ViewGroup")
    WebElement TotwoEyes;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-c2\"]/android.view.ViewGroup")
    WebElement toCenrBody;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-c2\"]/android.view.ViewGroup")
    WebElement toCentrLegs;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-r1\"]/android.view.ViewGroup")
    WebElement toRightEar;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-r2\"]/android.view.ViewGroup")
    WebElement toRightArm;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-r3\"]/android.view.ViewGroup")
    WebElement toRightHandLeg;

    public AppiumDriver driver;
    public Action action;
    public boolean isDisplayed;



    public static final String drugAndDropXpath = "//android.widget.TextView[@text=\"\uDB80\uDDDB\"]";


    @BeforeSuite
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
    public void puzzle1() throws RuntimeException {

        WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drag-l1\"]/android.widget.ImageView"));
        WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drop-l1\"]/android.view.ViewGroup"));
        toElement.getLocation();
        isDisplayed = toElement.isDisplayed();
        Assert.assertEquals(isDisplayed,  true,"Puzzle is not installed");
        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
        isDisplayed = toElement.isDisplayed();
        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
        System.out.println(fromElement.getLocation());
        Assert.assertFalse(isDisplayed, "Puzzle is not installed");

    }
    @Test
    public void puzzle2() throws RuntimeException {
        WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drag-l2\"]/android.widget.ImageView"));

        WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drop-l2\"]/android.view.ViewGroup"));
        toElement.getLocation();
        isDisplayed = toElement.isDisplayed();
        Assert.assertEquals(isDisplayed, true, "Puzzle is not installed");
        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        isDisplayed = toElement.isDisplayed();
        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
        System.out.println(fromElement.getLocation());
        Assert.assertFalse(isDisplayed, "Puzzle is not installed");
    }
    @Test
    public void puzzle3() throws RuntimeException {
        WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drag-l3\"]/android.widget.ImageView"));
        WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drop-l3\"]/android.view.ViewGroup"));
        toElement.getLocation();
        isDisplayed = toElement.isDisplayed();
        Assert.assertEquals(isDisplayed, true, "Puzzle is not installed");
        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        isDisplayed = toElement.isDisplayed();
        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
        System.out.println(fromElement.getLocation());
        Assert.assertFalse(isDisplayed, "Puzzle is not installed");
    }
        @Test
        public void puzzle4() throws RuntimeException {
        WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drag-c1\"]/android.widget.ImageView"));
        WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drop-c1\"]/android.view.ViewGroup"));
        toElement.getLocation();
        isDisplayed = toElement.isDisplayed();
        Assert.assertEquals(isDisplayed, true, "Puzzle is not installed");
        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        isDisplayed = toElement.isDisplayed();
        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
        System.out.println(fromElement.getLocation());
        Assert.assertFalse(isDisplayed, "Puzzle is not installed");
        }
    @Test
    public void puzzle5() throws RuntimeException {
        WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drag-c2\"]/android.widget.ImageView"));
        WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drop-c2\"]/android.view.ViewGroup"));
        toElement.getLocation();
        isDisplayed = toElement.isDisplayed();
        Assert.assertEquals(isDisplayed, true, "Puzzle is not installed");
        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        isDisplayed = toElement.isDisplayed();
        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
        System.out.println(fromElement.getLocation());
        Assert.assertFalse(isDisplayed, "Puzzle is not installed");
    }
    @Test
    public void puzzle6() throws RuntimeException {
        WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drag-c3\"]/android.widget.ImageView"));
        WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drop-c3\"]/android.view.ViewGroup"));

        toElement.getLocation();
        isDisplayed = toElement.isDisplayed();
        Assert.assertEquals(isDisplayed, true, "Puzzle is not installed");
        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        isDisplayed = toElement.isDisplayed();
        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
        System.out.println(fromElement.getLocation());
        Assert.assertFalse(isDisplayed, "Puzzle is not installed");
    }
    @Test
    public void puzzle7() throws RuntimeException {
        WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drag-r1\"]/android.widget.ImageView"));
        WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drop-r1\"]/android.view.ViewGroup"));
        toElement.getLocation();
        isDisplayed = toElement.isDisplayed();
        Assert.assertEquals(isDisplayed, true, "Puzzle is not installed");
        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        isDisplayed = toElement.isDisplayed();
        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
        System.out.println(fromElement.getLocation());
        Assert.assertFalse(isDisplayed, "Puzzle is not installed");
    }
    @Test
    public void puzzle8() throws RuntimeException {
        WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drag-r2\"]/android.widget.ImageView"));
        WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drop-r2\"]/android.view.ViewGroup"));
        toElement.getLocation();
        isDisplayed = toElement.isDisplayed();
        Assert.assertEquals(isDisplayed, true, "Puzzle is not installed");
        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        isDisplayed = toElement.isDisplayed();
        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
        System.out.println(fromElement.getLocation());
        Assert.assertFalse(isDisplayed, "Puzzle is not installed");
    }
    @Test
    public void puzzle9() throws RuntimeException {
        WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drag-r3\"]/android.widget.ImageView"));
        WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drop-r3\"]/android.view.ViewGroup"));
        toElement.getLocation();
        isDisplayed = toElement.isDisplayed();
        Assert.assertEquals(isDisplayed, true, "Puzzle is not installed");
        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        isDisplayed = toElement.isDisplayed();
        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());
        System.out.println(fromElement.getLocation());
        Assert.assertFalse(isDisplayed, "Puzzle is not installed");
    }


        @AfterSuite
        public void congrats() {
            try{
                WebElement fromElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"You made it, click retry if you want to try it again.\"]"));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
                WebElement toElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"button-Retry\"]/android.view.ViewGroup"));
                Assert.assertEquals(fromElement.getText(), "\"You made it, click retry if you want to try it again.", "What's wrong?");
                toElement.click();

            }catch (NoSuchElementException e) {
                System.out.println("I don't know what is wrong");
            }
    }





}
