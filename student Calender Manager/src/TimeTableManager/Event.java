package TimeTableManager;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class Event implements Comparable<Event> {

	private String _name;
	private simpleTime _startTime;
	private simpleTime _endTime;
	private int _day;

	public Event(String name,int day, simpleTime startTime, simpleTime endTime) {
		this._name = name;
		_startTime = new simpleTime(startTime.get_hours(), startTime.get_minutes());
		_endTime = new simpleTime(endTime.get_hours(), endTime.get_minutes());
		_day = day;
	}

	public int get_day() {
		return _day;
	}

	public static boolean doEventsCollide(Event a, Event b) {
		boolean AStartsInB = a._startTime.isAfter(b._startTime) && a._startTime.isBefore(b._endTime);
		boolean AEndsInB = a._endTime.isAfter(b._startTime) && a._endTime.isBefore(b._endTime);
		boolean BStartsInA = b._startTime.isAfter(a._startTime) && b._startTime.isBefore(a._endTime);
		boolean BEndsInA = b._endTime.isAfter(a._startTime) && b._endTime.isBefore(a._endTime);

		return AStartsInB || AEndsInB || BStartsInA || BEndsInA;


	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public simpleTime get_startTime() {
		return _startTime;
	}

	public void set_startTime(simpleTime _startTime) {
		this._startTime = _startTime;
	}

	public simpleTime get_endTime() {
		return _endTime;
	}

	public void set_endTime(simpleTime _endTime) {
		this._endTime = _endTime;
	}

	public void set_day(int _day) {
		this._day = _day;
	}

	abstract public String toIcal();
	abstract double calcGrade();
	abstract boolean betterEvent(Event other);

	@Override
	abstract public int compareTo(Event otherEvent);
}
