package TimeTableManager;

import java.util.ArrayList;

public class Schedule {
	
	ArrayList<ArrayList<Event>> _table;
	ArrayList<Restriction> _restrictions;
	double grade;
	
	Schedule(ArrayList<ArrayList<Event>> _table, ArrayList<Restriction> _restriction) {
		this._table = new ArrayList<ArrayList<Event>>(_table);
		this._restrictions = new Array<Restriction>(_restriction);
		grade = 0;
	}
	
	void calcGrade() {
		for(Restriction restriction : _restrictions) {
			grade += restriction.calcGrade();
		}
	}
	
}
