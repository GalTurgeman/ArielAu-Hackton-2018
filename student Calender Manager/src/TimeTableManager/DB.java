package TimeTableManager;

import java.util.ArrayList;
import java.util.PriorityQueue;

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

    public Schedule randomSchedule(Schedule schedToCopy){
        Schedule randomSchedule = new Schedule(schedToCopy);
        for (PriorityQueue<Event> )
    }
}
