package steps.webApps;

import com.autong.base.TestBase;
import forms.MyInfoTests;
import io.cucumber.java.en.And;

public class MyInfoSteps {

    MyInfoTests myInfoTests;

    @And("user redirects to My Info from side nav menu")
    public void clickMyInfoSideNav() {
        myInfoTests = new MyInfoTests(TestBase.getDriver());
        myInfoTests.clickMyInfoSideNavLink();
    }

    @And("user clicks on Add attachment button")
    public void userClicksOnAddAttachmentButton() {
        myInfoTests = new MyInfoTests(TestBase.getDriver());
        TestBase.pause(2000);
        TestBase.scrollToBottom();
        myInfoTests.clickAddAttachmentBtn();
    }

    @And("user uploads an attachment successfully")
    public void userUploadsAnAttachmentSuccessfully() {
        myInfoTests = new MyInfoTests(TestBase.getDriver());
        myInfoTests.uploadAttachment();
    }
}
