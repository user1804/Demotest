
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class automationTestCase {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.firefox.marionette", "/Users/tparwani/Desktop/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.weightwatchers.com/us/");
		String expectedTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Verification Successful - The correct title is displayed on the web page.");
		} else {
			System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
		}
		WebElement findmeetingpoint = driver.findElement(By.id("ela-menu-visitor-desktop-supplementa_find-a-meeting"));
		findmeetingpoint.click();

		Thread.sleep(5000);

		boolean meetingpointactualTitle = driver.getTitle().contains("Get Schedules & Times Near You");
		System.out.println("Page tittle contains Get Schedules & Times Near You : " + meetingpointactualTitle);

		WebElement searchbar = driver.findElement(By.id("meetingSearch"));
		searchbar.sendKeys("10011");

		driver.findElement(By.xpath(
				".//*[@id='content']/div/div/ui-view/ui-view/div/div/div/div/div[2]/div[1]/div/form/div[1]/span/button"))
				.click();
		String firstlocname = driver.findElement(By.xpath(
				".//*[@id='ml-1180510']/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]/span"))
				.getText();
		System.out.println("Name of first location search:" + "\n" + firstlocname);

		String firstlocdist = driver
				.findElement(By.xpath(
						".//*[@id='ml-1180510']/result-location/div/div[1]/a/location-address/div/div/div[1]/div[2]"))
				.getText();
		System.out.println("Distance of First location: " + firstlocdist);

		driver.findElement(By.className("meeting-location")).click();
		String meetinglocname = driver.findElement(By.xpath(".//location-address/div/div/div[1]/div/span")).getText();
		if (meetinglocname.equals(firstlocname)) {
			System.out.println(
					"Verification Successful - Displayed location name matches first clicked location results");
		} else {
			System.out.println("Verification Failed");
		}

		String hoursofoperation = driver
				.findElement(By.xpath(".//div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[5]/div")).getText();
		System.out.println("Todays Hours of operation: " + hoursofoperation);

		driver.quit();
	}

}
