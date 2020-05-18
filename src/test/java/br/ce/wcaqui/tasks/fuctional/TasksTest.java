package br.ce.wcaqui.tasks.fuctional;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TasksTest {
	
	public WebDriver acessarAplicação()throws MalformedURLException  {
		DesiredCapabilities cap =  DesiredCapabilities.chrome();
		// say you use the redhat5 label to indicate RHEL5 and the amd64 label to specify the architecture
		cap.setCapability("jenkins.label","redhat5 && amd64");
		// Say you want a specific node to thread your request, just specify the node name (it must be running a selenium configuration though)
		cap.setCapability("jenkins.nodeName","(master)");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.102:4444/wd/hub"),cap);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException{
		WebDriver driver = acessarAplicação();
		try {
		//entrar no site
		driver.navigate().to("http://192.168.0.102:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//clicar em Add todo
		
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descriï¿½ao
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
		}finally {
		//fechar o browser
		driver.quit();
		}
	}
}
