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
				while (cells.hasNext()) {
					cell=(XSSFCell) cells.next();
					if(cell.getStringCellValue() != null) {
						lesson._courseID = cell.getStringCellValue();
						cell=(XSSFCell) cells.next();
						lesson.set_name(cell.getStringCellValue());
					}

				}
			}
			for(int i = 0; i < ret.length; i++) {
				System.out.print("[ ");
				for(int j = 0; j < ret[i].length; j++) {
					System.out.print("[" + ret[i][j] + "]");
				}
				System.out.println("]");
			}
			wb.close();
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
