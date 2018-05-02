package TimeTableManager;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Schedule implements Comparable<Schedule> {

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

	public void swapEvent(Event toSearchAndRemove, Event toReplace) {
		int dayIndex = 0;
		for (PriorityQueue<Event> day : _table) {
			if(dayIndex == toReplace.get_day())
				day.add(toReplace);
			for (Event event : day) {
				if(toSearchAndRemove == event) 
					day.remove(event);
			}
			dayIndex++;
		}
	}

	public ArrayList<Event> getAllEvents() {
		ArrayList<Event> ans = new ArrayList<>();
		for (PriorityQueue<Event> day : _table) {
			for (Event event : day) {
				ans.add(event);
			}
		}
		return ans;
	}

	private void validateTable() {
		int indexHopper;
		_validateTable = new ArrayList<PriorityQueue<Event>>(_table);
		for (PriorityQueue<Event> day : _validateTable) {
			indexHopper = 0;
			for (int i = 0; i < day.size(); i=i+2) {
				Event temp = day.poll();
				if(Event.doEventsCollide(temp, day.peek())) {
					if(temp.betterEvent(day.peek())) {
						day.remove(day.remove());
						day.add(temp)
					}					
				}
				else {
					day.add(temp);
				}
			}
		}
	}

	@Override
	public int compareTo(Schedule other) {
		if (grade>other.grade) return 1;
		else if (grade<other.grade) return -1;
		return 0;
	}

}
