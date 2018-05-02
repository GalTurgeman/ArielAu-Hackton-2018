package TimeTableManager;

import java.util.ArrayList;

public interface Restriction {
	
	double calcGrade(ArrayList<ArrayList<Event>> _table, double wight);
}
