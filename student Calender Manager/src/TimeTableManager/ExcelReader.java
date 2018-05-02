package TimeTableManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static String path = "LessonData.xlsx";

	public static ArrayList<ArrayList<Event>> parseFile(String filePath) {
		InputStream ExcelFileToRead;
		try {

			ExcelFileToRead = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row; 
			XSSFCell cell;
			ArrayList<ArrayList<Event>> ret = new ArrayList<ArrayList<Event>>();

			Iterator rows = sheet.rowIterator();
			rows.next();
			rows.next();
			rows.next();
			rows.next();

			while (rows.hasNext())
			{
				row=(XSSFRow) rows.next();

				Lesson lesson = new Lesson("", 0, new simpleTime(0, 0), new simpleTime(0, 0), "", 0.0);
				Iterator cells = row.cellIterator();
				cells.next();
				cells.next();
				cells.next();
				cell=(XSSFCell) cells.next();
				if(cell.getStringCellValue() != null) {
					lesson._courseID = cell.getStringCellValue();
					cell=(XSSFCell) cells.next();
					lesson.set_name(cell.getStringCellValue());
					cell=(XSSFCell) cells.next();
					lesson._lecturer = cell.getStringCellValue();
					cell=(XSSFCell) cells.next();
					cell=(XSSFCell) cells.next();
					String s = cell.getStringCellValue();
					if(s.length() != 0)
						lesson.set_day(s.charAt(0) - 'à' + 1);
					else {
						lesson.set_day(1);
					}
					if(s.length() > 1) {
						lesson.set_startTime(new simpleTime(Integer.parseInt(s.substring(2, 4)), 0));
						lesson.set_endTime(new simpleTime(Integer.parseInt(s.substring(8, 10)), 0));
					}
					else {
						lesson.set_startTime(new simpleTime(0, 23));
						lesson.set_endTime(new simpleTime(0, 23));
					}
					cells.next();
					cell=(XSSFCell) cells.next();
					lesson._points = cell.getNumericCellValue();
					boolean flag = false;
					for(ArrayList<Event> lessons : ret) {
						if(lessons.get(0).get_name() == lesson.get_name()) {
							lessons.add(lesson);
							flag = true;
							break;
						}
					}
					if(!flag) {
						ArrayList<Event> arrayList = new ArrayList<Event>();
						arrayList.add(lesson);
						ret.add(arrayList);
					}
				}
			}
			wb.close();

			//			for(ArrayList<Event> list : ret) {
			//				System.out.print("[ ");
			//				for(Event lesson : list) {
			//					System.out.print(lesson.toString());
			//				}
			//				System.out.println(" ]");
			//			}
			return ret;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		parseFile(path);
	}

}
