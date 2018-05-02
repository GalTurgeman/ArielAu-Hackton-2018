package TimeTableManager;

public class Lesson extends Event {
	
	public String _class,_lecturer,_courseID;
	public double _points;
	
	public Lesson(String name, int day, simpleTime startTime, simpleTime endTime, String courseID, double points) {
		super(name, day, startTime, endTime);
		this._courseID = courseID;
		this._points = points;
	}
	
	public String toString() {
		return "(" + super.get_name() + ", " + super.get_day() + ", " + super.get_startTime() + ", " + super.get_endTime() + " )";
	}
	
	@Override
	public String toIcal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	double calcGrade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Event otherEvent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	boolean betterEvent(Event other) {
		// TODO Auto-generated method stub
		return false;
	}

}
