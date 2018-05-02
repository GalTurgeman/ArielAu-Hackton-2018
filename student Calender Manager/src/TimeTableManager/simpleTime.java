package TimeTableManager;

public class simpleTime {
	private int _hours;
	private int _minutes;

	public simpleTime(int hours, int minutes) {
		_hours = hours;
		_minutes = minutes;
	}
	
	public boolean isBefore(simpleTime other) {
		if (other.get_hours()>=_hours) {
			if(other.get_minutes()>=_minutes)
				return true;
		}
		return false;
	}
	
	public boolean isAfter(simpleTime other) {
		if (other.get_hours()<=_hours) {
			if(other.get_minutes()<=_minutes)
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return _hours + ":" + _minutes;
	}

	public int get_hours() {
		return _hours;
	}

	public void set_hours(int _hours) {
		this._hours = _hours;
	}

	public int get_minutes() {
		return _minutes;
	}

	public void set_minutes(int _minutes) {
		this._minutes = _minutes;
	}
	
}
