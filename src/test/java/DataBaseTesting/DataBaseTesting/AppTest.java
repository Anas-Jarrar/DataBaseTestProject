package DataBaseTesting.DataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

//   WebDriver driver=new ChromeDriver();
   Connection con;
   Statement stmt;
   ResultSet rs;
   
   
   @BeforeTest
   public void MySetup() throws SQLException {
	   
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","1234");  
	   
   }
   
   @Test(priority=1,enabled=false)
   public void InsertToRowFromDatabase() throws SQLException {
	   
	 String query="INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country, salesRepEmployeeNumber, creditLimit) VALUES (999999, 'Anas', 'Smith', 'John', '123456789', '123 Main St', 'Los Angeles', 'USA', 1370, 50000.00)";  
	 stmt=con.createStatement();
	 int RowInserted = stmt.executeUpdate(query);
	 System.out.println(RowInserted);
   }
   @Test(priority=2,enabled=false)
   public void UpdateRowFromDatabase() throws SQLException {
	   
	 String query="UPDATE customers set customerName='Anas Jarrar' where  customerNumber=999999";  
	 stmt=con.createStatement();
	 int RowUpdated = stmt.executeUpdate(query);
	 System.out.println(RowUpdated);
   }
   @Test(priority=3,enabled=false)
   public void DeleteRowFromDatabase() throws SQLException {
	   
	 String query="delete from customers where  customerNumber=999999 ";  
	 stmt=con.createStatement();
	 int RowDeleted = stmt.executeUpdate(query);
	 System.out.println(RowDeleted );
   }
   
   @Test(priority = 1)
   public void ReadFromDatabase() throws SQLException {
       String query = "SELECT * FROM customers WHERE customerNumber = 999";
       stmt = con.createStatement();
       rs = stmt.executeQuery(query);
       
       while (rs.next()) {
           System.out.println("Customer Number: " + rs.getInt("customerNumber"));
           System.out.println("Customer Name: " + rs.getString("customerName"));
           System.out.println("Contact First Name: " + rs.getString("contactFirstName"));
           System.out.println("Contact Last Name: " + rs.getString("contactLastName"));
           System.out.println("City: " + rs.getString("city"));
           System.out.println("Country: " + rs.getString("country"));
           System.out.println("-----------------------------");
       }
   }

   
   @AfterTest
   public void MyAfterTest() {
	   
	   
	   
   }
}
