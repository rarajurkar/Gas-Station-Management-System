import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

public class Sale {
	
	private String name;
	private String cardNumber;
	private Date expiryDate;
	private String selectedGrade;
	private double cost;
	private double quantity;
	private Date timestamp;
	
	
	public Sale(Card card){
		name = card.getName();
		cardNumber = card.getCardNumber();
		expiryDate = (Date) card.getDate();
	}
	public void setGrade(String selectedGrade) {
		this.selectedGrade = selectedGrade;
	}
	
	public void saleOperation(Connection connection) throws SQLException{
		ProductCatalog productCatalog = new ProductCatalog();
		double rate = productCatalog.getRate(selectedGrade);
		System.out.println("Rate for entered grade:: "+rate);
		
		PumpingMechanism pumpingMechanism = new PumpingMechanism();
		pumpingMechanism.startFlow(selectedGrade);
		//TODO : select random value from 5 to 20 and pass it to timer.
		FualCostDisplay fualCostDisplay = new FualCostDisplay();
		while(!pumpingMechanism.isCutOff()){
			quantity = pumpingMechanism.getVolume();
			cost = rate * quantity;
			// Fual Cost Display shows Quantity and Cost
			System.out.println(" FUEL COST DISPLAY ");
			fualCostDisplay.sendVolumeCost(quantity, cost);
		}	
		//TODO : database connector
		//Current timestamp
		timestamp = new Date();
		Statement stmt = connection.createStatement();
		//insert query
		String sql = "insert into transactionlog values ('"+name +"','"+cardNumber+"','"+expiryDate.toString() +"','"+selectedGrade+"',"+cost+",'"+timestamp.toString()+"')";
		stmt.executeUpdate(sql);
		
	}
	double getAmountCharged(){
		return cost;
	}
	
	//getter methods for print class
	public String getName() {
		return name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public String getSelectedGrade() {
		return selectedGrade;
	}
	public double getCost() {
		return cost;
	}
	public double getQuantity() {
		return quantity;
	}
	public Date getTimestamp() {
		return timestamp;
	}
}
