package tests.pages;

import static org.fluentlenium.core.filter.FilterConstructor.withId;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;


public class IndexPage extends FluentPage {
  private String url;

  
  public IndexPage(WebDriver webDriver, int port, int studentID) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/?id=" + studentID;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("play-example-form");
  }
  
  public void setName(String name) {
    fill("#name").with(name);
  }
  
  public void setPassword(String password) {
    fill("#password").with(password);
  }
  
  public void selectAcceso(String acceso) {
    find("div", withId("accesos")).find("input", withId(acceso)).click();
  }

  public void selectCurso(String curso) {
    find("div", withId("cursos")).find("input", withId(curso)).click();
  }
  
  public void selectAño(String año) {
    find("select", withId("año")).find("option", withId(año)).click();
  }

  public void selectTitulacion(String Titulacion) {
    find("select", withId("Titulacions")).find("option", withId(Titulacion)).click();
  }
  
  public void submit() {
    submit("#submit");
  }
  
  public void cancel() {
    find("#cancel").click();
  }
  
  public boolean hasSuccessMessage() {
    return findFirst("div", withId("success-message")) != null;
  }
  
  public boolean hasErrorMessage() {
    return findFirst("div", withId("error-message")) != null;
  }
}
