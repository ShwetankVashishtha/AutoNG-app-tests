package forms;

import com.autong.utilities.PropertyManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.autong.base.PageBase;
import com.autong.base.TestBase;

import static locators.Locators.MyInfoLocators.*;

@Getter
public class MyInfoTests extends PageBase {

    PropertyManager pm = new PropertyManager();

    /**
     * Instantiates a new adds the feedback page.
     *
     * @param driver the driver
     */
    public MyInfoTests(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = MYINFO_SIDE_NAV)
    private WebElement myInfoSideNav;

    @FindBy(xpath = ADD_ATTACHMENT_BTN)
    private WebElement addAttachmentBtn;

    @FindBy(xpath = BROWSE_BTN)
    private WebElement browseBtn;

    @FindBy(xpath = FILE_PATH_INPUT)
    private WebElement filePathInput;

    public void clickMyInfoSideNavLink() {
        TestBase.waitForElementVisible(10, getMyInfoSideNav());
        TestBase.waitForElementToBeClickable(10, getMyInfoSideNav());
        getMyInfoSideNav().click();
        TestBase.implicitWait(10);
    }

    public void clickAddAttachmentBtn() {
        TestBase.waitForElementVisible(10, getAddAttachmentBtn());
        TestBase.waitForElementToBeClickable(10, getAddAttachmentBtn());
        getAddAttachmentBtn().click();
    }

    public void uploadAttachment() {
        getFilePathInput().sendKeys(System.getProperty("user.dir") + pm.getResourceBundle.getProperty("ATTACHMENT_PATH"));
    }
}
