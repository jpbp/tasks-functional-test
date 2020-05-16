package br.ce.wcaqui.tasks.fuctional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = new ChromeDriver();
		//entrar no site
		driver.navigate().to("http://localhost:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//clicar em Add todo
		
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descriçao
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
