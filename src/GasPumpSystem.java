import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GasPumpSystem {
	
	public static void main(String args[]){
		
		//create database connection 
		String url = "jdbc:mysql://localhost:3306/gaspumplog";
		String username = "root";
		String password = "rucha771992";
		Connection connection;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, username, password);
		
		InstructionDisplay instructionDisplay = new InstructionDisplay();
		instructionDisplay.prompt("Please Swipe Your Card");

		CardReader cardReader = new CardReader();
		// Receiving Card Details from Card Reader
		Card card = cardReader.getDetails();
		   ///System.out.println("Card:: "+card.getCardNumber()+ "   " +card.getName()+"   "+card.getDate());
		
		// Sending card for verify method of CardAuthentication class
		CardAuthentication cardAuthentication = new CardAuthentication();
		
		// collecting result of card verification "isValid"
		boolean isValid = cardAuthentication.verify(card);
		   ///System.out.println("Card Validation Result:: "+isValid);
		
		if(isValid){
			// if card verification is successful, do the following:
			
			Sale sale = new Sale(card); 
			//create an instance of product catalog
			ProductCatalog productCatalog = new ProductCatalog();
			
			//Display available grade types
			//and corresponding costs per unit
			productCatalog.showItem();
			
			//Obtain selected grade
			instructionDisplay.prompt("Select Grade");
			Scanner scanner = new Scanner(System.in);
			String selectedGrade = scanner.nextLine(); 
			
			//set grade attribute of Sale class to
			//the selected grade
			sale.setGrade(selectedGrade);
			
			sale.saleOperation(connection);
			
			double totalCost = sale.getAmountCharged();
			instructionDisplay.prompt("Total Amount Charged : "+ totalCost);
			
			Printer printer = new Printer();
			printer.print(sale);
		}
		else{
			instructionDisplay.prompt("Card is Not Valid");
		}
	}catch(SQLException e){
		e.printStackTrace();
	}

	}
}
