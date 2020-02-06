package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        ARTICLE_NAME_TPL = "xpath://div[contains(@class, 'page-heading')]//h1[contains(text(), '{SUBSTRING}')]";
        BOOKMARK_BUTTON = "css:#page-actions-watch a#ca-watch button";
        REMOVE_FROM_FAVOURITE_LIST = "css:#page-actions-watch a[title='Remove this page from your watchlist']";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
