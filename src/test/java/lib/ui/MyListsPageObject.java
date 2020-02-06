package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject{

    protected static String
            NAME_OF_FOLDER_XPATH_TPL,
            ARTICLE_BY_TITLE_TPL,
            REMOVE_FROM_SAVED_BUTTON_TPL;

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getNameOfFolderXpath(String substring) {
        return NAME_OF_FOLDER_XPATH_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getSavedArticleByTitleXpath(String substring) {
        return ARTICLE_BY_TITLE_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getRemoveButtonByTitle(String substring) {
        return REMOVE_FROM_SAVED_BUTTON_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void openFolderByName(String name_of_folder) {
        this.waitForElementAndClick(
                getNameOfFolderXpath(name_of_folder),
                "Cannot find needed reading list by name " + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        this.waitForElementPresent(
                getSavedArticleByTitleXpath(article_title),
                "Cannot find the article named" + article_title,
                5
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        this.waitForElementNotPresent(
                getSavedArticleByTitleXpath(article_title),
                "The article named " + article_title + " was not deleted",
                5
        );
    }

    public void swipeArticleToDelete(String article_title) {
        this.waitForArticleToAppearByTitle(article_title);

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.swipeElementToLeft(
                    getSavedArticleByTitleXpath(article_title),
                    "Cannot find saved article by title " + article_title
            );
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove the article from saved",
                    10
            );
        }

        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightCorner(
                    getSavedArticleByTitleXpath(article_title),
                    "Cannot find saved article");
        }

        if (Platform.getInstance().isMW()) {
            driver.navigate().refresh();
        }

        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void checkThatTheArticleWasNotDeletedByMistakeByOpeningIt(String article_title) {
        this.waitForElementAndClick(
                getSavedArticleByTitleXpath(article_title),
                "There's no such article. Probably requested article was deleted by mistake on the previous step",
                5
        );
    }

    private WebElement waitForTitleElement(String substring) {
        return this.waitForElementPresent(getSavedArticleByTitleXpath(substring), "Cannot find article title on the page of saved articles", 15);
    }

    public String getArticleTitleFromMyListsIOS(String substring) {
        WebElement title_element = this.waitForTitleElement(substring);
        return title_element.getAttribute("name");
    }
}
