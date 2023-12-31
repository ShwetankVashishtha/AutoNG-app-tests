package forms;

import com.autong.base.PageBase;
import com.autong.base.TestBase;
import com.autong.utilities.PropertyManager;
import com.autong.utilities.annotations.ElementMeta;
import com.autong.utilities.annotations.ObjectLoaderMeta;
import com.autong.utilities.annotations.WaitForLoad;
import com.autong.utilities.annotations.WebSpecificField;
import com.autong.utilities.meta.LocateUsing;
import com.autong.utilities.meta.Platform;
import com.autong.utilities.meta.WaitCondition;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static locators.Locators.LoginLocators.*;

@Getter
public class LoginTests extends PageBase {

    PropertyManager pm = new PropertyManager();

    /**
     * Instantiates a new adds the feedback page.
     *
     * @param driver the driver
     */
    public LoginTests(WebDriver driver) {
        super(driver);
    }

//    @WebSpecificField
//    @ElementMeta(locateUsing = LocateUsing.XPATH, elementName = "username field", locator = USERNAME)
//    @WaitForLoad(waitForElement = WaitCondition.Visible)
//    public WebElement username;

    @FindBy(xpath = USERNAME)
    private WebElement username;

    @FindBy(xpath = PASSWORD)
    private WebElement password;

    @FindBy(xpath = LOGIN)
    private WebElement login;

    @FindBy(xpath = DASHBOARD_LOGO)
    private WebElement dashboardLogo;

    @ObjectLoaderMeta(platform = Platform.WEB)
    public void openUrl() {
        TestBase.setupBrowser(pm.getResourceBundle.getProperty("browser"),
                pm.getResourceBundle.getProperty("BASE_URL"));
    }

    public void enterCredentials(String username, String password) {
        TestBase.waitForElementVisible(10, getUsername());
        getUsername().clear();
        sendKeys_custom(getUsername(), "Username", username);
        TestBase.waitForElementToBeClickable(10, getPassword());
        getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void clickLogin() {
        TestBase.waitForElementToBeClickable(10, getLogin());
        getLogin().click();
        TestBase.implicitWait(10);
    }

    public boolean verifyDashboardLogo() {
        if (getDashboardLogo().isDisplayed()) {
            return true;
        }
        return false;
    }
}
