package Junk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class mainclass {

	public static void main(String[] args) throws Exception {
		Set<String> setBasetag = new HashSet<String>();
		int count = 0;
		String Value = "";
		List<String[]> listrecs = new ArrayList<String[]>();
		XExcelFileReader xfr = new XExcelFileReader("C:\\Users\\Pratap\\Desktop\\DBRecords_pivot.xlsx");

		listrecs = xfr.readRows(827405);
		for (String[] strings : listrecs) {
			for (String string : strings) {
                
				setBasetag.add(string); 
			}
		}
		System.out.println(count);
	}
	

}
