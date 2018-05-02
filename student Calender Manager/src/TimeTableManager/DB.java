package TimeTableManager;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

import org.apache.poi.ss.formula.functions.Even;

public class DB {

    private static ArrayList<ArrayList<Event>> _eventsDB;

    public static DB DBinstance = null;

    public static DB getInstance() throws Exception {
        if (DBinstance == null){
            throw new Exception("DB was not initialized by any input reader!");
        }
        return DBinstance;
    }

    public static void initInstance(ArrayList<ArrayList<Event>> dbTable){
        DBinstance = new DB(dbTable);
    }

    private DB(ArrayList<ArrayList<Event>> dbTable){
        _eventsDB = dbTable;
    }

    public ArrayList<Event> getSimilarEvents(Event eventToCompare) throws Exception {
        for (ArrayList<Event> eventsList : _eventsDB){
            if (eventsList.contains(eventToCompare)){
                return eventsList;
            }
        }
        throw new Exception("Error finding similar events in DB!");
    }

    public Schedule randomSchedule(Schedule schedToCopy) throws Exception {
        Schedule randomSchedule = new Schedule(schedToCopy);
        for (PriorityQueue<Event> queue : randomSchedule.get_table()){
            for (Event event : queue){
                ArrayList<Event> similarEvents = getSimilarEvents(event);

                Random r = new Random();
                int Low = 0;
                int High = similarEvents.size();
                int Result = r.nextInt(High-Low) + Low;

                Event newEvent = similarEvents.get(Result);
                randomSchedule.swapEvent(event, newEvent);
            }
        }
        return randomSchedule;
    }
    
    public Schedule getSampleSchedule() {
    	ArrayList<Restriction> restrictions = new ArrayList<>();
    	ArrayList<PriorityQueue<Event>> table = new ArrayList<>();
    	for (int i =0; i<10; i++) {
	    	Random r = new Random();
	    	int Low = 0;
	    	int High = this._eventsDB.size();
	    	int Result = r.nextInt(High-Low) + Low;
	    	PriorityQueue<Event> queue = new PriorityQueue<>();
	    	for (Event event : _eventsDB.get(Result)) {
	    		queue.add(event);
	    	}
	    	table.add(queue);
    	}
    	
    	Schedule sample = new Schedule(table, restrictions);
    	Restriction_numOfLessons rest_num_lessons = new Restriction_numOfLessons(sample, 60);
    	Restriction_spaceBetweenLessons rest_space = new Restriction_spaceBetweenLessons(sample, 40);
    	restrictions.add(rest_num_lessons);
    	restrictions.add(rest_space);
    	
    	return sample;
    	
    }
}
