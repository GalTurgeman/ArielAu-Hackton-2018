package TimeTableManager;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Schedule {
	
	ArrayList<PriorityQueue<Event>> _table;
	ArrayList<PriorityQueue<Event>> _validateTable;
	ArrayList<Restriction> _restrictions;
	double grade;
	
	Schedule(ArrayList<PriorityQueue<Event>> table, ArrayList<Restriction> restriction) {
		this._table = new ArrayList<PriorityQueue<Event>>(_table);
		this._restrictions = new ArrayList<Restriction>(restriction);
		grade = 0;
		calcGrade();
	}
	
	private void calcGrade() {
		for(Restriction restriction : _restrictions) {
			grade += restriction.calcGrade();
		}
	}
	
}
