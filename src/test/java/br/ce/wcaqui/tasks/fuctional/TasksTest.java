package br.ce.wcaqui.tasks.fuctional;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class TasksTest {
	@Test
	public void deveSalvarTarefaComSucesso() {
		ChromeOptions cap = new ChromeOptions(); 
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.IGNORE);
		WebDriver driver = new ChromeDriver();
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
