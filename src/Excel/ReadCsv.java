package Excel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsv {
	
public void extractRelationships(String csvPath){
	
	String csvFile = "C:\\Users\\Pratap\\Desktop\\Sample Sheet_Skill Library - Copy.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = "\t";
	try {
		 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			String[] country = line.split(cvsSplitBy);
			for (int i = 0; i < country.length; i++) {
				System.out.println(country[0]);
				System.out.println(country[1]);
			}
		
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
	
}
