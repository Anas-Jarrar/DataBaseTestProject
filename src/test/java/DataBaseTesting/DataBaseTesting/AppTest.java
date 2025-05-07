package DataBaseTesting.DataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends TestData{

  
   @BeforeTest
   public void MySetup() throws SQLException {
	   Setup();
   }
   
   @Test(priority=1,enabled=true)
   public void InsertToRowFromDatabase() throws SQLException {   
	 stmt=con.createStatement();
	 stmt.executeUpdate(Insertquery);
   }
   @Test(priority=2,enabled=true)
   public void UpdateRowFromDatabase() throws SQLException {
	    
	 stmt=con.createStatement();
	 stmt.executeUpdate(Updatequery);
	 
   }

   
   @Test(priority = 3,enabled=true)
   public void ReadFromDatabase() throws SQLException {
       stmt = con.createStatement();
       rs = stmt.executeQuery(Selectquery);
       while (rs.next()) {
          contactFirstNameInDb=rs.getString("contactFirstName").toString().trim();
          contactLastNameInDb= rs.getString("contactLastName");
          email=contactFirstNameInDb+contactLastNameInDb+"@gmail.com";
          Password = "123!Passw0rd";
       }
       driver.findElement(By.id("customer[first_name]")).sendKeys(contactFirstNameInDb);;
       driver.findElement(By.id("customer[last_name]")).sendKeys(contactLastNameInDb);;
       driver.findElement(By.id("customer[email]")).sendKeys(email);;
       driver.findElement(By.id("customer[password]")).sendKeys(Password);;
       
   }

   @Test(priority=4,enabled=true)
   public void DeleteRowFromDatabase() throws SQLException {
	   
	 stmt=con.createStatement();
	 stmt.executeUpdate(Deletequery);
   }
   
   @AfterTest
   public void MyAfterTest() {
	   
	   
	   
   }
}
