import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CardReader {
	
	public Card getDetails(){
		//creating a new card instance
		Card card = new Card();
		Scanner sc = new Scanner(System.in);
		//Emulation of procurement of card details using console input
		
		//procuring name on card
		System.out.println("Enter name :: ");
		String cname = sc.nextLine();
		
		//procuring card number
		System.out.println("Enter card number(Without spaces) :: ");
		String cnumber = sc.nextLine();
		
		//procuring expiry date as a string
		
		System.out.println("Enter Expiry Date(yyyy/MM/dd)");
		String expDt = sc.nextLine();
		
		//converting the string so procured to Java Date type
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = formatter.parse(expDt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Setting respective attributes of Card object, using the 
		//values obtained above
		card.setName(cname);
		card.setCardNumber(cnumber);
		card.setDate(date);
		
		return card;
	}
	

}
