package core;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

//Сделайте сценарий, который проверяет, не появляются ли в логе браузера сообщения при открытии страниц 
//в учебном приложении, а именно -- страниц товаров в каталоге в административной панели.
//Сценарий должен состоять из следующих частей:
//1) зайти в админку
//2) открыть каталог, категорию, которая содержит товары 
//(страница http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1)
//3) последовательно открывать страницы товаров и проверять, 
//не появляются ли в логе браузера сообщения (любого уровня)



/**
 * @author Dmitry Nakhabtsev
 */
public class TestCase17 extends TestBase{
	



@Test
public void test() throws InterruptedException{

	String url="http://www.google.com";
//	String url="http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";	

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
	driver.get(url); 
	
	driver.findElement(By.name("q")).sendKeys("webdriver");
	driver.findElement(By.name("btnG")).click();
	wait.until(titleIs("webdriver - Google Search"));
	
//	driver.findElement(By.name("username")).sendKeys("admin");
//	driver.findElement(By.name("password")).sendKeys("admin");
//	driver.findElement(By.name("login")).click();
	
    System.out.println("Congratulations!");

}
}