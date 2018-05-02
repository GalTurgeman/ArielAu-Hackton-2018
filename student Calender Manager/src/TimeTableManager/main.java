package TimeTableManager;

import java.util.PriorityQueue;

public class main {

    public static void main(String[] args) throws Exception {
    	DB.initInstance(ExcelReader.parseFile("Lessons Data"));
    	Schedule best = Random_Restart_Hill_Climbing.computeBestSchedule(DB.getInstance().getSampleSchedule());
    	for (PriorityQueue<Event> day : best.get_table()) {
    		for (Event event : day) {
    			System.out.println(event.toString());
    		}
    	}
    	
    }

}
