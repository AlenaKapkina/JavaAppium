package tests;

import lib.*;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() {

        if (Platform.getInstance().isAndroid() || Platform.getInstance().isMW()) {
            return;
        }

        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreWikiLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWaysText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreDataText();
        WelcomePage.clickGetStartedButton();
    }
}
