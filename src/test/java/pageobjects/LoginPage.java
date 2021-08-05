package pageobjects;



import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.MetodosUteis;

public class LoginPage extends MetodosUteis {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "txtUsername")
    private WebElement usuario;

    @FindBy(id = "txtPassword")
    private WebElement senha;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    @FindBy(css = "h1")
    private List<WebElement> titulos;

    public void preencherUsuario(String nomeUsuario) {
        esperarElemento(usuario);
        usuario.sendKeys(nomeUsuario);
    }

    public void preencherSenha(String senhaUsuario) {
        esperarElemento(senha);
        senha.sendKeys(senhaUsuario);
    }

    public void clicarBotaoLogin() {
        esperarElemento(btnLogin);
        btnLogin.click();
    }

    public void validarDashboard() {
        WebElement dashboard = null;
        for (int i = 0; i < titulos.size(); i++) {
            if (titulos.get(i).getText().contains("Dashboard")) {
                dashboard = titulos.get(i);
            }
        }
        esperarElemento(dashboard);
        assertTrue(dashboard.isEnabled());
    }

}
	
