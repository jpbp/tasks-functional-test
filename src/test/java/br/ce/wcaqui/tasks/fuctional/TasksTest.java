package br.ce.wcaqui.tasks.fuctional;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TasksTest {
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException{
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"),cap);
		 
		//entrar no site
		driver.navigate().to("http://localhost:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//clicar em Add todo
		
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descri�ao
		driver.findElement(By.id("task")).sendKeys("Teste via selenuim");

		
		
		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		//validar mensagem de sucesso
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.id("message")).getText();
		System.out.println(text);
		Assert.assertEquals("Success!",text);
		//fechar o browser
		driver.quit();
	}
}
