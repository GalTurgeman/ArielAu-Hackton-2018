package TimeTableManager;

import java.util.ArrayList;

public abstract class Restriction {
	protected double _weight;
    protected Schedule _sched;

    public Restriction(Schedule sched, double weight){
        _weight = weight;
        _sched = sched;
    }
	public abstract double calcGrade();

}
