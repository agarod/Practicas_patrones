package tests;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;
import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;


public class ViewTest {
  private final int testPort = 3333;
  
  @Test
  public void testIndexPageRetrieval() {
    running(testServer(testPort, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      @Override
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), testPort, 0);
        browser.goTo(indexPage);
        indexPage.isAt();
      }
    });
  }
  
  /** Test submission of an empty form. */
  @Test
  public void testIndexPageEmptySubmission() {
    running(testServer(testPort, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      @Override
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), testPort, 0);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.submit();
        assertThat(indexPage.hasErrorMessage()).isTrue();
      }
    });
  }
  

  @Test
  public void testIndexPageValidSubmission() {
    running(testServer(testPort, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      @Override
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), testPort, 1);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.submit();
        assertThat(indexPage.hasSuccessMessage()).isTrue();
      }
    });
  }
  

  @Test
  public void testIndexPageFormFilledSubmission() {
    running(testServer(testPort, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      @Override
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), testPort, 0);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.setName("Ardiel Y Katerine");
        indexPage.setPassword("Patrones");
        indexPage.selectAcceso("mAYOR 25");
        indexPage.selectAcceso("Pau");
        indexPage.selectCurso("4");
        indexPage.selectaño"4");
        indexPage.selectTitulacion("Informatica");
        indexPage.selectTitulacion("Informatica");
        indexPage.submit();
        //System.out.println(browser.pageSource());  // useful for debugging.
        assertThat(indexPage.hasSuccessMessage()).isTrue();
      }
    });
  }  

}
