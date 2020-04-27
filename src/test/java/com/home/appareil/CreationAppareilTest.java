package com.home.appareil;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreationAppareilTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kenti\\Documents\\dev\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
	    driver.get("http://localhost:4200/auth");
	    driver.findElement(By.id("email")).sendKeys("kentish.munusami@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("test");  
	    driver.findElement(By.name("connecter")).click();
	    Thread.sleep(1000);
	    List<WebElement> nbAppareil = driver.findElements(By.tagName("app-appareil"));
	    int nbAppareilBeforeAdd = nbAppareil.size();
//	    List<WebElement> options = driver.findElements(By.tagName("a"));
//        System.out.println(options);
//        for (WebElement option : options)
//        {
//        	System.out.println(option.getText());
//            if (option.getText().equals(searchText))
//            {
//                option.click(); // click the desired option
//
//            }
//        } 
	    driver.findElement(By.partialLinkText("Nouvel")).click();
	    driver.findElement(By.id("name")).sendKeys("test"); 
	    driver.findElement(By.id("status")).sendKeys("allumé"); 
	    driver.findElement(By.name("enregistrer")).click();//on ajoute un appareil
	    Thread.sleep(1000);
	    List<WebElement> nbAppareilAfterAdd = driver.findElements(By.tagName("app-appareil"));
	    assertTrue(nbAppareilAfterAdd.size()>nbAppareilBeforeAdd);//on vérifie l'ajout de appareil
	    driver.findElement(By.xpath("//app-appareil[@ng-reflect-appareil-name='test']/li/h4/span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("test1"); 
	    driver.findElement(By.id("status")).sendKeys("éteint");
	    driver.findElement(By.name("enregistrer")).click();//on modifie un appareil
	    Thread.sleep(1000);
	    WebElement appareilModify = driver.findElement(By.xpath("//app-appareil[@ng-reflect-appareil-name='test1' or @ng-reflect-appareil-status='éteint']/li/span"));
	    assertNotNull(appareilModify);//on vérifie la modification de appareil
	    driver.findElement(By.xpath("//app-appareil[@ng-reflect-appareil-name='test1']/li/span")).click();//on supprime un appareil
	    Thread.sleep(1000);
	    List<WebElement> nbAppareilAfterDelete = driver.findElements(By.tagName("app-appareil"));
	    assertTrue(nbAppareilBeforeAdd == nbAppareilAfterDelete.size());//on vérifie la suppresion d'un appareil
//	    driver.close();	

	}

}
