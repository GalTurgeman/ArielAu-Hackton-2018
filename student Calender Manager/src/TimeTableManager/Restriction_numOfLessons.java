package TimeTableManager;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Restriction_numOfLessons extends Restriction {

	public Restriction_numOfLessons(Schedule sched, double weight){
	    super(sched, weight);
    }

	@Override
	public double calcGrade() {
		int validLessons = 0;
		for (PriorityQueue<Event> day : _sched.get_validateTable()){
            validLessons = validLessons + day.size();
        }

        int totalLessons = 0;
        for (PriorityQueue<Event> day : _sched.get_table()){
            totalLessons = totalLessons + day.size();
        }

        return _weight * (validLessons / totalLessons);
	}
}
