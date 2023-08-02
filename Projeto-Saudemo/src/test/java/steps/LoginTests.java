package steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import metodos.Metodos;
import page.HomePage;

public class LoginTests {

	
	Metodos metodos = new Metodos();
	HomePage page = new HomePage();
	
	String usuario = "standard_user";
	String usuarioBloqueado = "locked_out_user";
	String usuarioInvalido = "usuarioInvalido";
	String senhaInvalida = "senhaInvalida";
	String senha = "secret_sauce";
	
	@Before
	public void abrirNavegador() throws InterruptedException {
		Metodos.abrirNavegador();
		
	}
	
	@After
	public void fecharNavegador() {
		metodos.fecharNavegador();
	
	}
	
	@Test
	public void testUsuarioBranco() throws Exception {
		page.login("", senha, "Epic sadface: Username is required");
	}
	
	@Test
	public void testSenhaBranco() throws Exception {
		page.login(usuario, "", "Epic sadface: Password is required");
	}
	
	@Test
	public void testUsuarioInvalido() throws Exception {
		page.login(usuarioInvalido, senha, "Epic sadface: Username and password do not match any user in this service");
	}
	@Test
	public void testSenhaInvalido() throws Exception {
		page.login(usuario, senhaInvalida, "Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test
	public void testUsuarioBloqueado() throws Exception {
		page.login(usuarioBloqueado, senha, "Epic sadface: Sorry, this user has been locked out.");
	}
	
	@Test
	public void loginSucesso() throws Exception {
		page.login(usuario, senha, "Swag Labs");
	}
}







