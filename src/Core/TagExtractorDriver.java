package Core;


import java.io.FileNotFoundException;

import Utils.DBconnection;
import Utils.ReadingNotepadfiles;
import Utils.TagInput;

public class TagExtractorDriver {

	public static void main(String[] args) throws FileNotFoundException {

		Utils.ReadingNotepadfiles Obj_Notepadfile = new Utils.ReadingNotepadfiles();
		Utils.DBconnection Obj_db = new DBconnection();
		Utils.TagInput obj_Dbitems = Obj_db.extractBaseTagFromDataBase("select  BASE_TAG , CHILD_TAG from CACHE_CLOUD_TAG_DATA");
		Utils.TagInput Obj_outputitems = Obj_Notepadfile.extratFromOutputNotepad("E:\\excelfiles\\New folder\\OutputNotepad25thjuneUthkarsh.txt");
		ReportUtils.findCommonTags(obj_Dbitems, Obj_outputitems );

	}

}
