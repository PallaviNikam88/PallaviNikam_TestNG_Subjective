package TestNGTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.ConfigureClass;

public class Test_Scenario_3 extends ConfigureClass{

	@Test(timeOut = 20000)
    public void TestScenario_03_Alerts() {
        
        //1. Click “Javascript Alerts”
        WebElement javascriptAlertsLink = driver.findElement(By.linkText("Javascript Alerts"));
        javascriptAlertsLink.click();
        
        //2. Now click the “Click Me” button in the “JavaScript Alerts” section
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();
        
        //3. Validate the alert message “I am an alert box!” and click OK
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am an alert box!", "Alert message should be 'I am an alert box!'");
        alert.accept();
        
        System.out.println("Test Scenario 3 executed successfully");
    }

	
}
