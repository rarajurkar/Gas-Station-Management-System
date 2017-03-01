import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Printer {

	public void print(Sale sale) {
		// TODO Auto-generated method stub
		System.out.println("Printing Receipt");
		System.out.println(sale.getName());
		System.out.println(sale.getQuantity());
		System.out.println(sale.getSelectedGrade());
		System.out.println(sale.getCost());
		System.out.println(sale.getTimestamp());
		//String receiptName = "Receipt_"+sale.getTimestamp().toString()+".txt";
		File file = new File("Receipt.txt");
		
		try {
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file,false);
			fileWriter.write("ABC Gas Station"); 
			fileWriter.write("\n"+sale.getName()+"\n"+sale.getQuantity()+"\n"+sale.getSelectedGrade()+"\n"+sale.getCost()+"\n"+sale.getTimestamp());
            fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Runtime runtime = Runtime.getRuntime();
		{
				try {
					Runtime.getRuntime().exec("notepad Receipt.txt");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		
	}
}
