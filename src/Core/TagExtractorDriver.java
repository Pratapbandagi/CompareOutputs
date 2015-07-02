package Core;


import java.io.IOException;

import Utils.DBconnection;
import Utils.ReadingNotepadfiles;
import Excel.ReadCsv;
import Excel.readExcel;

public class TagExtractorDriver {

	public static void main(String[] args) throws IOException {

//		Utils.ReadingNotepadfiles Obj_Notepadfile = new Utils.ReadingNotepadfiles();
//		Utils.DBconnection Obj_db = new DBconnection();
//		ReadingNotepadfiles rnf = new ReadingNotepadfiles();
//		//Utils.TagInput obj_Dbitems = rnf.extractFromDBNotepad("E:\\excelfiles\\New folder\\DBRecordsfile.txt",true);
//		Utils.TagInput obj_Dbitems = Obj_db.extractTagsFromDataBase("select  BASE_TAG , CHILD_TAG from CACHE_CLOUD_TAG_DATA");
//		Utils.TagInput Obj_outputitems = Obj_Notepadfile.extratFromOutputNotepad("E:\\excelfiles\\New folder\\StringCastDemo.txt");
//		ReportUtils.findCommonTags(obj_Dbitems, Obj_outputitems );

		
		//Utils.DBconnection Obj_db = new DBconnection();
		//Utils.TagInput obj_Dbitems = Obj_db.extractTagsFromDataBase("select  BASE_TAG , CHILD_TAG from CACHE_CLOUD_TAG_DATA");
		////readExcel re = new readExcel();
		////Utils.TagInput obj_Excelitems = re.extractFromExcel("E:\\excelfiles\\ListItems.xlsx");		
		//ReportUtils.findCommonRelationships(obj_Dbitems, obj_Excelitems);
		
		
        

		Utils.DBconnection obj_DB = new DBconnection();
		Utils.TagInput obj_DbItems1 = obj_DB.extractTagsFromDataBase("select  BASE_TAG , CHILD_TAG from CACHE_CLOUD_TAG_DATA");
		ReadingNotepadfiles rnf = new ReadingNotepadfiles();
		Utils.TagInput Obj_OutputItems1 = rnf.extratFromOutputNotepad30th("E:\\excelfiles\\New folder\\InformationTechnologyLevel_01_01_07_2015_Ranjeet.txt");
		ReportUtils.findCommonTags(obj_DbItems1, Obj_OutputItems1 );
		
		Utils.TagInput obj_DbItems2 = obj_DB.extractTagsFromDataBase("select  BASE_TAG , CHILD_TAG from CACHE_CLOUD_TAG_DATA");
		Utils.TagInput obj_OutputItems2 = rnf.extratFromOutputNotepad30th("E:\\excelfiles\\New folder\\InformationTechnologyLevel_02_01_07_2015_Ranjeet.txt");
		ReportUtils.findCommonTags(obj_DbItems2, obj_OutputItems2 );
		
		Utils.TagInput obj_DbItems3 = obj_DB.extractTagsFromDataBase("select  BASE_TAG , CHILD_TAG from CACHE_CLOUD_TAG_DATA");
		Utils.TagInput obj_OutputItems3 = rnf.extratFromOutputNotepad30th("E:\\excelfiles\\New folder\\InformationTechnologyLevel_03_01_07_2015_Ranjeet.txt");
		ReportUtils.findCommonTags(obj_DbItems3, obj_OutputItems3 );
		
		

	}

}
