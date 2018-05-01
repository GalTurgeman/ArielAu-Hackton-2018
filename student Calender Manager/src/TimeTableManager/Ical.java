package TimeTableManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ical {
	
	public static void generateFile() {
		String string = "C://";
		System.out.println(string);
		
		
		String s = "BEGIN:VCALENDAR\r\n" + 
				"VERSION:2.0\r\n" + 
				"PRODID:-//CalKal//EN\r\n" + 
				"BEGIN:VEVENT\r\n" + 
				"UID:uid1@example.com\r\n" + 
				"DTSTAMP:20180502T170000Z\r\n" + 
				"ORGANIZER;CN=Tom Gropper:MAILTO:GropperTom@Gmail.com\r\n" + 
				"DTSTART:20180502T170000Z\r\n" + 
				"FREQ=WEEKLY;BYDAY=TU;INTERVAL=1;UNTIL=20180730T210000Z\r\n" + 
				"DTEND:20180502T180000Z\r\n" + 
				"SUMMARY:Toms test event\r\n" + 
				"END:VEVENT\r\n" + 
				"BEGIN:VEVENT\r\n" + 
				"UID:uid2@example.com\r\n" + 
				"DTSTAMP:20180502T190000Z\r\n" + 
				"ORGANIZER;CN=Tom Gropper:MAILTO:GropperTom@Gmail.com\r\n" + 
				"DTSTART:20180502T190000Z\r\n" + 
				"FREQ=WEEKLY;BYDAY=TU;INTERVAL=1;UNTIL=20180730T210000Z\r\n" + 
				"DTEND:20180502T200000Z\r\n" + 
				"SUMMARY:Toms test eventdd\r\n" + 
				"END:VEVENT\r\n" + 
				"END:VCALENDAR";
		System.out.println(generateName());
		File file = new File(generateName());
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String generateName() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now) + ".ical";
	}
	
	public static void main(String[] args) {
		generateFile();
	}

}
