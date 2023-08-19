package forms;

import com.autong.base.PageBase;
import com.autong.base.TestBase;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.logging.Logger;

import static locators.Locators.AdminLocators.*;

@Getter
public class AdminTests extends PageBase {
    
    Logger logger = Logger.getLogger("AutoNG logger");

    /**
     * Instantiates a new adds the feedback page.
     *
     * @param driver the driver
     */
    public AdminTests(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ADMIN_SIDE_NAV)
    private WebElement adminSideNav;

    @FindBy(xpath = USER_ROLES_LABEL)
    private List<WebElement> userRolesLabel;

    @FindBy(xpath = USER_ROLES_DROPDOWN)
    private WebElement userRolesDropdown;

    @FindBy(xpath = FOOTER_LINK)
    private WebElement footerLink;

    @FindBy(xpath = COPYRIGHT_YEAR)
    private WebElement copyrightYear;

    @FindBy(xpath = SEARCH_BTN)
    private WebElement searchBtn;

    public void clickAdminSideNavLink() {
        TestBase.waitForElementToBeClickable(10, getAdminSideNav());
        getAdminSideNav().click();
        TestBase.implicitWait(10);
    }

    public void selectValueFromUserRoleDropdown() {
        for (WebElement userRole : getUserRolesLabel()) {
            if (userRole.getText().equals("User Role")) {
                logger.info("Found record that reads User Role");
            }
        }
    }

    public void scrollToPageFooter() {
        TestBase.pause(1000);
        TestBase.scrollToBottom();
        TestBase.waitForElementVisible(10, getFooterLink());
    }

    public String getCopyrightYearText() {
        TestBase.waitForElementVisible(10, getCopyrightYear());
        return getCopyrightYear().getText();
    }

    public void clickFooterHyperlink() {
        TestBase.waitForElementVisible(10, getFooterLink());
        TestBase.waitForElementToBeClickable(10, getFooterLink());
        getFooterLink().click();
        TestBase.switchBrowserTab(1);
    }

    public void openContextMenu() {
        TestBase.contextClick(getSearchBtn());
        TestBase.pause(4000);
    }

    public void mouseHoverSearchBtn() {
        TestBase.mouseHover(getSearchBtn());
        TestBase.pause(4000);
    }
}
