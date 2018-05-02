package TimeTableManager;

import java.util.ArrayList;

public class DB {

    ArrayList<ArrayList<Event>> _eventsDB;

    public static DB DBinstance = null;

    public static DB getInstance() throws Exception {

    }


        public static DB getInstance() throws Exception {
        if (DBinstance == null){
            throw new Exception("DB was not initialized by any input reader!");
        }
        return DBinstance;
    }



}
