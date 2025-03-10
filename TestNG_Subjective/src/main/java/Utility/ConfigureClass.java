package Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ConfigureClass {

	public RemoteWebDriver driver;
	String username ="pallavi_nikam";
	String authkey ="iRO278KkW1KW0SIL5qOanS4QGlDFwodcgfevIe3FIKArBlR44w";
	String hub ="@hub.lambdatest.com/wd/hub";
	 
	 @Parameters({"TestName","browsername","Version","Platform","URL"})
	@BeforeMethod
	public void setUp(String TestName,String browsername, String Version,String Platform,String uRL){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browsername);
		capabilities.setCapability("browserVersion", Version);
		capabilities.setCapability("name", "TestNG_LamdaTest : "+TestName);
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", username);
		ltOptions.put("accessKey", authkey);
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("platformName", Platform);
		ltOptions.put("build", " Build_LambdatTestTestNG_Pallavi_Run2");
		ltOptions.put("project", "TestNG_LamdaTest");
		 
		ltOptions.put("console", "true");
		ltOptions.put("smartUI.project", "SmartProject");
		capabilities.setCapability("LT:Options", ltOptions);
		capabilities.setCapability("ie.popupBlocker", false);
		capabilities.setCapability("ie.ensureCleanSession", true);
		capabilities.setCapability("ie.browserCommandLineSwitches", "-private");
		 capabilities.setCapability("network", "true"); // Enable network logs
		 try {
         	System.out.println("https://" + username + ":" + authkey + hub);
         	 driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities);
              System.out.println("In try Block");
         } catch (MalformedURLException e) {
             System.out.println("Invalid grid URL");
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
		 
		 driver.get(uRL);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(){
		 System.out.println("Close the browser");
		driver.quit();
	}
}
