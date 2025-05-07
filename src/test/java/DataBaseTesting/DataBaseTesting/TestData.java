package DataBaseTesting.DataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {
	 WebDriver driver=new ChromeDriver();
	   Connection con;
	   Statement stmt;
	   ResultSet rs;
	   String TheWebsite="https://smartbuy-me.com/account/register";
	   String contactFirstNameInDb;
	   String contactLastNameInDb;
	   String email;
	   String Password;
	   
	   String Insertquery="INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country, salesRepEmployeeNumber, creditLimit) VALUES (999, 'Anas', 'Smith', 'John', '123456789', '123 Main St', 'Los Angeles', 'USA', 1370, 50000.00)";  
	   String Updatequery="UPDATE customers set contactLastName='Jarrar',contactFirstName='Anas' where  customerNumber=999"; 
       String Selectquery = "SELECT * FROM customers WHERE customerNumber = 999";
       String Deletequery="delete from customers where  customerNumber=999";  

	   public void Setup() throws SQLException {
		   
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","1234");  
			 driver.manage().window().maximize();
			 driver.get(TheWebsite);
		   }
}
