package page;

import org.openqa.selenium.By;

import metodos.Metodos;

public class HomePage {

	Metodos metodos = new Metodos();

	By user = By.id("user-name");
	By password = By.id("password");
	By btnLogin = By.id("login-button");
	By msgErro = By.xpath("//h3[@data-test='error']");
	
	public void login(String user, String password, String texto) throws Exception {
		
		metodos.escrever(user,this.user);
		metodos.escrever(password,this.password);
		metodos.clicar(btnLogin);
		if(texto.equals("Swag Labs")) {
			metodos.validarTitle(texto);
		}else {
			metodos.validarTexto(texto, msgErro);
		}

	}
}

