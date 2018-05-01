package TimeTableManager;

import java.util.ArrayList;

public abstract class Event {
	public ArrayList<TimePeriod> _instance = new ArrayList<>();
	public String _name;
	
	abstract public String toIcal();
	abstract double calcGrade();
}
