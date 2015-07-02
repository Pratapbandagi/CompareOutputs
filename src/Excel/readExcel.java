package Excel;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import Utils.RelationshipBean;
import Utils.TagBean;
import Utils.TagInput;

public class readExcel {

	private final Set<TagBean> tagBeans9 = new HashSet<TagBean>();
	private final Set<RelationshipBean> relationshipBeans = new HashSet<RelationshipBean>();
	
	
	public TagInput extractFromExcel(String Excelpath) throws FileNotFoundException {
		extractRelationships(Excelpath);
		TagInput tagInput = new TagInput(tagBeans9, relationshipBeans);
		return tagInput;
	}
	
	
	private void extractRelationships(String path) {
		
		String Sheetname = "listitems";
		Xls_Reader Obj = new Xls_Reader(path);
		int rowCount = Obj.getRowCount(Sheetname);
		for (int i = ExcelConstants.startRow; i <= rowCount; i++) {
			String startTagWord = Obj.getCellData("listitems", 0, i);
			TagBean tagword1 = new TagBean(startTagWord);
			tagBeans9.add(tagword1);
			String endTagWord = Obj.getCellData("listitems", 3, i);
			TagBean tagword2 = new TagBean(endTagWord);
			tagBeans9.add(tagword2);
			RelationshipBean relationshipBean = new RelationshipBean(tagword1, tagword2);
			relationshipBeans.add(relationshipBean);
		}
		
		System.out.println("Relationhshib Bean " + relationshipBeans);
	}


}
