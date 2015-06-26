package Junk;
import java.util.HashSet;
import java.util.Set;

public class readExcel {

	public static Set<String> intersection(Set<String> set1, Set<String> set2) {
		int count = 0;
		Set<String> tmp = new HashSet<String>();
		for (String firstRecord : set1) {
			for (String secondRecord : set2) {
				if (firstRecord.equalsIgnoreCase(secondRecord)) {
					count++;

					tmp.add(firstRecord);
				}
			}
		}
		System.out.println("Total Common elements in both the Sets are : "
				+ count);
		return tmp;
	}

	public static void main(String[] args) {
		Set<String> SetA = new HashSet<String>();
		Set<String> SetB = new HashSet<String>();
		try {
			Xls_Reader xx = new Xls_Reader("C:\\Users\\Pratap\\Desktop\\DBRecords_pivot.xlsx");
			int rowCount = xx.getRowCount("listitems");
			int columCount = xx.getColumnCount("listitems");
			for (int i = 2; i <= rowCount; i++) {
				for (int j = 0; j < 1; j++) {
					SetA.add(xx.getCellData("listitems", j, i));
				}
			}

			Xls_Reader xx1 = new Xls_Reader("C:\\Users\\Pratap\\Desktop\\DBRecords_pivot.xlsx");
			int rowCount1 = xx1.getRowCount("listitems");
			int columCount1 = xx1.getColumnCount("listitems");
			for (int i = 2; i <= rowCount; i++) {
				for (int j = 1; j <= 1; j++) {
					SetB.add(xx.getCellData("listitems", j, i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Number of Common elements in Sets: "
				+ intersection(SetA, SetB));
	}

}
