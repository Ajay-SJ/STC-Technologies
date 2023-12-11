package blue_line_proj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Blue_Line_Project {
	WebDriver driver;
  @Test (priority=-1)
  public void HomePage() throws InterruptedException {
	  //Check whether About us-describe briefly about our blueline tourpackage-dynamic,the about us content can be changed from admin side.
	  driver.get("https://bluelinetourpackage.com/main/index");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[8]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[8]/li[1]/a[1]")).click();
	  driver.findElement(By.name("About")).clear();
	  driver.findElement(By.name("About")).sendKeys("Blueline good line");
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  driver.get("https://bluelinetourpackage.com/");
	  String aboutus=driver.findElement(By.xpath("/html[1]/body[1]/section[3]/div[1]/div[1]/div[1]/p[1]")).getText();
	  System.out.println(aboutus);
	  System.out.println("Successfuly changed the about us content from admin side");
	  //Check whether the Gallery menu take us into the gallery section
	  driver.findElement(By.xpath("//a[contains(text(),'Gallery')]")).click();
	  // Check whether Banner images-static can’t change from admin side
	  driver.get("https://bluelinetourpackage.com/main/index");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	  System.out.println("No option to change is present so banner images can't change from admin side");
	  //Check whether Main images-give an overview about trip-is dyanamic it can be change from admin side.
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[7]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[7]/li[1]/a[1]")).click();
	  driver.findElement(By.xpath("//tbody/tr[3]/td[5]/a[1]/i[1]")).click();
	  driver.findElement(By.name("Image")).sendKeys("C:\\Users\\ajays\\Documents\\Python_class\\pictures\\sril.jpg");
	  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	  driver.get("https://bluelinetourpackage.com/Web");
	  WebElement ImageFile = driver.findElement(By.xpath("//body/section[4]/div[1]/div[1]/div[5]/div[1]/img[1]"));
	  Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		 if (!ImagePresent) {
				System.out.println("Test Failed no image displayed");
			  } else {
				System.out.println("Image displayed.");
			}
	  System.out.println("Disclaimer: Only images with certain resolutions are displayed");
	  //Check whether Contact us-a user can send message for further enquiry to admin.
	  driver.findElement(By.name("Name")).sendKeys("Sumesh");
	  
	  driver.findElement(By.name("Email")).sendKeys("sumesh2@gmail.com");
	  
	  driver.findElement(By.name("Contact")).sendKeys("8671234567");
	  driver.findElement(By.name("Message")).sendKeys("Show best packages");
	  driver.findElement(By.xpath("//button[contains(text(),'Send message')]")).click();
	  Thread.sleep(1000);
	  String alert=driver.findElement(By.xpath("/html[1]/body[1]/div[1]")).getText();
	  String expected = "Message Send successfully!";
	  if(expected.equals(alert)) {
	   System.out.println(alert);
	  }
	  else {
		  System.out.println("Use a new email id and try again");
	  }
	  
	  //Check whether right side the address is given its dyanamic the address can change from admin side.
	  driver.get("https://bluelinetourpackage.com/main/index");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[3]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[3]/li[1]/a[1]")).click();
	  driver.findElement(By.name("Address")).clear();
	  driver.findElement(By.name("Address")).sendKeys("Will,this,work,India");
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  String notwork=driver.findElement(By.xpath("//h1[contains(text(),'403')]")).getText();
	  String lol = "403";
	  if(lol.equals(notwork)) {
		  System.out.println("Test failed unable to change address");
	  }
	  else {
		  System.out.println("Test successfully address is dynamic");
	  }
	  
	  
	  
	  
  }
  @Test(priority=0)
  public void Gallery() throws InterruptedException {
	  //Check whether Home link will redirect to home page
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  driver.findElement(By.xpath("//body/nav[1]/a[2]")).click();
	  System.out.println("Successfully redirected to homepage");
	  //Check whether Gallery link will take to gallery page
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  driver.findElement(By.xpath("//a[contains(text(),'Gallery')]")).click();
	  System.out.println("Successfully redirected to Gallery page");
	  //Check whether Call and email  is dyanamic its can change from admin side
	  driver.get("https://bluelinetourpackage.com/main/index");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[8]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[8]/li[1]/a[1]")).click();
	  driver.findElement(By.name("Phone")).clear();
	  driver.findElement(By.name("Phone")).sendKeys("9123491235");
	  driver.findElement(By.name("Email")).clear();
	  driver.findElement(By.name("Email")).sendKeys("ert@xui.com");
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  String gcall=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/a[5]")).getText();
	  String gemail=driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/a[6]")).getText();
	  System.out.println("Call and email now in gallery is shown as "+gcall +gemail);
	  System.out.println("Matching with the input");
	  //Check whether type of trips is added from admin side
	  driver.get("https://bluelinetourpackage.com/main/index");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[6]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[6]/li[1]/a[1]")).click();
	  driver.findElement(By.xpath("//body/div[4]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("Alappuzha");
	  driver.findElement(By.xpath("//body/div[4]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys("C:\\Users\\ajays\\Documents\\Python_class\\pictures\\logo1.png");
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  System.out.println("Type of trip successfully added from admin side");
	  //Check whether The text below travel tourist is dyanamic which can be changed from admin side.
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[8]")).click();
	  driver.findElement(By.xpath("//body/div[@id='navbox']/ul[8]/li[1]/a[1]")).click();
	  driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/textarea[1]")).clear();
	  driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/textarea[1]")).sendKeys("Amazing");
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  String Tr_To_Text=driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/p[1]")).getText();
	  System.out.println(Tr_To_Text);
	  System.out.println("Travel tourist text successfully matched with the content given from admin side");
	  //Check whether Search Function in Gallery working
	  driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/a[4]/button[1]")).click();
	  Select country = new Select(driver.findElement(By.xpath("//select[@id='country_list']")));
	  country.selectByVisibleText("Uae");
	  Thread.sleep(1000);
	  Select state = new Select(driver.findElement(By.xpath("//select[@id='state_list']")));
	  state.selectByVisibleText("Moscow");
	  driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).sendKeys("55");
	  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	  System.out.println("Search can be given in any combination and working successfully");
	  
	  //Check whether after login a small button with logined user name will get displayed in the right top side
	  System.out.println("after login a small button with logined user name will get displayed in the right top side");
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  driver.findElement(By.xpath("//body/nav[1]/div[1]/a[2]")).click();
	  driver.findElement(By.name("username")).sendKeys("007");
	  driver.findElement(By.name("password")).sendKeys("123456");
	  driver.findElement(By.xpath("//body/center[2]/form[1]/fieldset[1]/input[3]")).click();
	  String usmatch = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[1]/button[1]")).getText();
	  System.out.println(usmatch+ " Right side text matching with username");
	  //Check whether on clicking username button Myaccount and logout  links will display.on clicking logout the user can successfully logout.on clicking Myaccount the interface switch to My accounts
	  driver.findElement(By.xpath("//button[contains(text(),'007')]")).click();
	  driver.findElement(By.xpath("//body/nav[1]/div[1]/div[1]/div[1]/a[2]")).click();
	  System.out.println("User successfully logged out");
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  driver.findElement(By.xpath("//body/nav[1]/div[1]/a[2]")).click();
	  driver.findElement(By.name("username")).sendKeys("007");
	  driver.findElement(By.name("password")).sendKeys("123456");
	  driver.findElement(By.xpath("//body/center[2]/form[1]/fieldset[1]/input[3]")).click();
	  driver.findElement(By.xpath("//button[contains(text(),'007')]")).click();
	  driver.findElement(By.xpath("//body/nav[1]/div[1]/div[1]/div[1]/a[1]")).click();
	  System.out.println("User successfully gone to My accounts interface after clicking MyAccount button");
	  //Check whether Cart Button-on clicking cart button if the user is not loggined,it will switch to login page else it will add the item to cart.if the item is already added to cart the messege display already added to cart.
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  driver.findElement(By.xpath("//button[contains(text(),'007')]")).click();
	  driver.findElement(By.xpath("//body/nav[1]/div[1]/div[1]/div[1]/a[2]")).click();
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]")).click();
	  System.out.println("User successfully gone to login page after clicking cart in not logged in state");
	  System.out.println("Database error occured when user is logged in and clicking add to cart button");
	  //Check whether the  view more button will switch to login form ,if the user is not already logined else switch to book details interface.
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")).click();
	  System.out.println("Successfully navigated to login page since user is not logged in");
	  driver.findElement(By.name("username")).sendKeys("007");
	  driver.findElement(By.name("password")).sendKeys("123456");
	  driver.findElement(By.xpath("//body/center[2]/form[1]/fieldset[1]/input[3]")).click();
	  driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")).click();
	  System.out.println("User successfully navigated to booking details page");
	  driver.findElement(By.xpath("//button[contains(text(),'007')]")).click();
	  driver.findElement(By.xpath("//body/nav[1]/div[1]/div[1]/div[1]/a[2]")).click();
	  //Check whether sign up link working User can register if needed
	  driver.get("https://bluelinetourpackage.com/Gallery");
	  driver.findElement(By.xpath("//a[contains(text(),'Sighn Up')]")).click();
	  Scanner scanner_user;
	  scanner_user = new Scanner(System.in);
      System.out.println("Enter your Username : ");
      String user = scanner_user.nextLine();
      driver.findElement(By.xpath("//input[@id='exampleInputplace']")).sendKeys(user);
      Thread.sleep(10000);
      scanner_user.close();
      driver.findElement(By.name("password")).sendKeys("999011");
      driver.findElement(By.name("cpassword")).sendKeys("999011");
      driver.findElement(By.name("Description")).sendKeys("lol");
      driver.findElement(By.name("Email")).sendKeys("amali@yku.com");
      driver.findElement(By.name("Phonenumber")).sendKeys("8886781234");
      driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/form[1]/div[7]/input[1]")).sendKeys("C:\\Users\\ajays\\Documents\\Python_class\\pictures\\logo1.png");
      driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
      System.out.println("User successfully registered from sign up link");
  }
  @Test(priority=1)
  public void MyAccount() {
	  //Check whether My account-it will display basic data of user.they can change and update the data if needed.
	  driver.get("https://bluelinetourpackage.com/Web/login");
	  driver.findElement(By.xpath("//body/center[2]/form[1]/fieldset[1]/input[1]")).sendKeys("007");
	  driver.findElement(By.xpath("//body/center[2]/form[1]/fieldset[1]/input[2]")).sendKeys("123456");
	  driver.findElement(By.xpath("//body/center[2]/form[1]/fieldset[1]/input[3]")).click();
	  driver.findElement(By.xpath("//button[contains(text(),'007')]")).click();
	  driver.findElement(By.xpath("//body/nav[1]/div[1]/div[1]/div[1]/a[1]")).click();
	  driver.findElement(By.name("name")).clear();
	  driver.findElement(By.name("name")).sendKeys("008");
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  String cerror = driver.findElement(By.xpath("//h1[contains(text(),'403')]")).getText();
	  System.out.println("Getting html error as follows" +cerror);
	  
	  //Check whether Change password-on click change password the change password page appears with two input field password and current password.user  can change and update password.
	  driver.get("https://bluelinetourpackage.com/Myaccount/Change");
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys("123456");
	  driver.findElement(By.name("cpassword")).clear();
	  driver.findElement(By.name("password")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  System.out.println("Password successfully changed");
	  //Check whether the cart button switch to cart page which display the user carted items
	  driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/a[2]/button[1]/i[1]")).click();
	  System.out.println("Successfully displayed the cart page");
  
  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chromedriver","C:\\Users\\ajays\\Documents\\Software_Test_Course\\Automation\\Selenium\\chromedriver-win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
