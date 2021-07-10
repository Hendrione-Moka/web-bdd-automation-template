import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.GridViewPage;
import pages.TableViewPage;
import pages.WebPlaygroundHomePage;
import webdriverpool.WebdriverInitializer;

//TDD = Test driven development (Unit Testing) E2E
public class TestRunPageObject {

  @Before
  public void inisialisasiWebdriver() {
    WebdriverInitializer.initialize();
  }

  @After
  public void quitBrowser() {
    WebdriverInitializer.quit();
  }

  @Test
  public void addQuoteWIthBlueColor() {
    WebPlaygroundHomePage homePage = new WebPlaygroundHomePage(WebdriverInitializer.driver);
    GridViewPage gridViewPage = new GridViewPage(WebdriverInitializer.driver);

    homePage.openPage();
    homePage.inputQuote("There is a will there is a way");
    homePage.selectColor("Blue");
    homePage.clickButtonAddQuote();
    String actualQuote = gridViewPage.getQuoteText(1);
    Assert.assertEquals("There is a will there is a way", actualQuote);
  }

  @Test
  public void addQuoteWIthYellowColor() {
    WebPlaygroundHomePage homePage = new WebPlaygroundHomePage(WebdriverInitializer.driver);
    GridViewPage gridViewPage = new GridViewPage(WebdriverInitializer.driver);

    homePage.openPage();
    homePage.inputQuote("There is a will there is a way");
    homePage.selectColor("Yellow");
    homePage.clickButtonAddQuote();
    String actualQuote = gridViewPage.getQuoteText(1);
    Assert.assertEquals("There is a will there is a way", actualQuote);
  }

  @Test
  public void hoverShowTableButton() {
    WebPlaygroundHomePage homePage = new WebPlaygroundHomePage(WebdriverInitializer.driver);
    TableViewPage tableViewPage = new TableViewPage(WebdriverInitializer.driver);

    homePage.openPage();
    tableViewPage.clickTableView();
    tableViewPage.hoverShowTableBtn();
    boolean hasil = tableViewPage.isTableShow();
    Assert.assertTrue(hasil);
  }

  @Test
  public void clickButtonShowTableAfterTenSec() {
    WebPlaygroundHomePage homePage = new WebPlaygroundHomePage(WebdriverInitializer.driver);
    TableViewPage tableViewPage = new TableViewPage(WebdriverInitializer.driver);

    homePage.openPage();
    tableViewPage.clickTableView();
    tableViewPage.clickButtonShowTableAfterTenSec();
    boolean hasil = tableViewPage.isTableShow();
    Assert.assertTrue(hasil);
  }

  @Test
  public void switchTab() {
    WebPlaygroundHomePage homePage = new WebPlaygroundHomePage(WebdriverInitializer.driver);

    homePage.openPage();
    homePage.clickPoweredByLink();
    String title = homePage.getAtlasTitle();
    System.out.println(title);
    Assert.assertEquals("Atlas ID – Automatin Testing Learning and Sharing Indonesia", title);
  }

}
