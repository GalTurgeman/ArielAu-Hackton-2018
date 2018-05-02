package TimeTableManager;

import java.util.ArrayList;

public abstract class Restriction {
	private double _weight;
    private ArrayList<ArrayList<Event>> _table;
    public Restriction(ArrayList<ArrayList<Event>> table, double weight){
        _weight = weight;
        _table = table;
    }
	public abstract double calcGrade();

}
