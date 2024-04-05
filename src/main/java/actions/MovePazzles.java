package actions;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovePazzles {
   public static AppiumDriver driver;
  /*  @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-l1\"]/android.widget.ImageView")
    static String  leftEar;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-l2\"]/android.widget.ImageView")
    static String leftArm;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-l3\"]/android.widget.ImageView")
    static String leftHandArm;
    @FindBy(xpath = " //android.view.ViewGroup[@content-desc=\"drag-c1\"]/android.widget.ImageView")
    static String twoEyes;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-c2\"]/android.widget.ImageView")
    static String cenrBody;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-c3\"]/android.widget.ImageView")
    static String centrLegs;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-r1\"]/android.widget.ImageView")
    static String rightEar;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-r2\"]/android.widget.ImageView")
    static String rightArm;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-r3\"]/android.widget.ImageView")
    static String rightHandLeg;

    @FindBy(xpath = "android.view.ViewGroup[@content-desc=\"drop-l1\"]/android.view.ViewGroup")
    static String toLeftEar;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-l2\"]/android.view.ViewGroup")
    static String toLeftHand;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-l3\"]/android.view.ViewGroup")
    static String toLeftHandLeg;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-c1\"]/android.view.ViewGroup")
    static String TotwoEyes;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-c2\"]/android.view.ViewGroup")
    static String toCenrBody;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-c3\"]/android.view.ViewGroup")
    static String toCentrLegs;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-r1\"]/android.view.ViewGroup")
    static String toRightEar;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-r2\"]/android.view.ViewGroup")
    static String toRightArm;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drop-r3\"]/android.view.ViewGroup")
    static String toRightHandLeg;*/
    //public AppiumDriver driver;
    ///public Action action;
    public static  boolean isDisplayed;
    public String xpath;
    public String xpath2;

    public  String fromPlace;
    public  String toPlace;

    public MovePazzles(AppiumDriver driver) {
        this.driver=driver;
        //PageFactory.initElements(driver, this);

    }

    public static void movePuzzle(MoveWithPazzlesObj moveWithPazzlesObj){


        System.out.println(MoveWithPazzlesObj.getFromElement());
        System.out.println(MoveWithPazzlesObj.getToElement());

        WebElement fromElement = driver.findElement(AppiumBy
                .xpath(MoveWithPazzlesObj.getFromElement()));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement toElement = driver.findElement(AppiumBy.xpath(MoveWithPazzlesObj.getToElement()));
        toElement.getLocation();
        System.out.println(toElement.getText());
        isDisplayed = toElement.isDisplayed();

        System.out.println("ToElement displayed at Start " + isDisplayed);
        Actions action = new Actions(driver);
        action.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release(toElement)
                .build().perform();

        isDisplayed = toElement.isDisplayed();

        System.out.println("ToElement displayed at finish " + toElement.isDisplayed());

    }
    }
