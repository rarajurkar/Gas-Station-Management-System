import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProductCatalog {
	
	static Map<String, Double> gradeChart;
	static{
		gradeChart =  new HashMap<String, Double>();
		gradeChart.put("Regular", 1.99);
		gradeChart.put("Midgrade",2.35);
		gradeChart.put("Premium",2.59);
		gradeChart.put("Diesel",1.98);
	}
	//Creating a map as a class variable so that this chart
	//mapping grade-types to cost per unit
	//is available to all objects of ProductCatalog
	
	
	public void showItem() {
		//Showing names of available grade-types
		//which, are keys in the static HashMap
		Set<String> gradeNames = gradeChart.keySet(); 
		for(String name : gradeNames){
			System.out.print(name);
			System.out.print("\t"+gradeChart.get(name)+"\n");
		}
	}
	public double getRate(String selectedGrade) {
		//returning cost per unit corresponding
		//to the grade selected by the user
		return gradeChart.get(selectedGrade.trim());
		
	}

}
