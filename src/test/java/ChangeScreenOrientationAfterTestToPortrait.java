import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ChangeScreenOrientationAfterTestToPortrait extends CoreTestCase {

    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        /*MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'SKIP')]"),
                "Cannot find onboarding screen for skip it or cannot find the skip button",
                1
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        fail("Fail test when Wikipedia in landscape orientation");*/
    }
}
