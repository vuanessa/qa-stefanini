package pageobjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.MetodosUteis;

public class AdminPage extends MetodosUteis {
	
	 protected WebDriver driver;

	    public AdminPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    @FindBy(id = "menu_admin_viewAdminModule")
	    private WebElement menuAdmin;
	    
	    @FindBy(id = "searchSystemUser_userName")
	    private WebElement campoUsuario;
	    
	    @FindBy(id = "searchSystemUser_userType")
	    private WebElement campoPerfil;
	    
	    @FindBy(id = "searchSystemUser_employeeName_empName")
	    private WebElement campoFuncionario;
	    
	    @FindBy(id = "searchSystemUser_status")
	    private WebElement campoSituacao;
	    
	    @FindBy(id = "searchBtn")
	    private WebElement btnPesquisar;
	    
	   public void menuAdmin() {
		   esperarElemento(menuAdmin);
		   menuAdmin.click();
	   }
	    
	    public void preencherUsuarioBusca(String usuario) {
	    	esperarElemento(campoUsuario);
	    	campoUsuario.clear();
	    	campoUsuario.sendKeys(usuario);
	    }
	    
	    public void preencherPerfilBusca(String perfil) {
	    	esperarElemento(campoPerfil);
	    	selecionar(campoPerfil, perfil);
	    }	
	    
	    public void preencherNomeFuncionarioBusca(String nomeFuncionario) {
	    	esperarElemento(campoFuncionario);
	    	campoFuncionario.clear();
	    	campoFuncionario.sendKeys(nomeFuncionario);
	    }
	    
	    public void preencherSituacaoBusca(String situacao) {
	    	esperarElemento(campoSituacao);
	    	selecionar(campoSituacao, situacao);
	    }
	    
	    public void clicarBotaoPesquisar() {
			esperarElemento(btnPesquisar);
			btnPesquisar.click();
		}
	    
	    public void validarLinkUsuario(String usuario) {
	    	WebElement linkUsuario = driver.findElement(By.linkText(usuario));
	    	esperarElemento(linkUsuario);
	    	assertTrue(linkUsuario.isDisplayed());
	    }

}
