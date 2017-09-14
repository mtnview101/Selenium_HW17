package core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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

/**
 * @author Dmitry Nakhabtsev
 */
public class TestBase {
public static ThreadLocal<EventFiringWebDriver> tlDriver=new ThreadLocal<>();
public EventFiringWebDriver driver;
public WebDriverWait wait;

public static class MyListener extends AbstractWebDriverEventListener{
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(by);}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(by+" found");}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println(throwable);}
}


@Before
public void start(){
	if(tlDriver.get()!=null){
		driver=tlDriver.get();
		wait=new WebDriverWait(driver,10);
		return;
	}
	WebDriver driverName = new EdgeDriver();
//	WebDriver driverName = new ChromeDriver();
	driver=new EventFiringWebDriver(driverName);
	driver.register(new MyListener());
	wait=new WebDriverWait(driver,10);
	
	Runtime.getRuntime().addShutdownHook(new Thread(()->{driver.quit(); driver=null;}));
}
@After
public void stop(){
	System.out.println("Congratulations!");
	driver.quit();
	driver = null;	
}
}