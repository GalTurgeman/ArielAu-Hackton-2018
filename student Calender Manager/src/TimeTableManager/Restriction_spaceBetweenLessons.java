package TimeTableManager;

import java.util.PriorityQueue;

public class Restriction_spaceBetweenLessons extends Restriction {

	public Restriction_spaceBetweenLessons(Schedule sched, double weight){
	    super(sched, weight);
    }

	@Override
	public double calcGrade() {
		int spaceLength = 0;
		for (PriorityQueue<Event> day : _sched.get_validateTable()){
            for (int lessonIdx = 0; lessonIdx < day.size()-1; lessonIdx++){
                Event ev1 = day.poll();
                Event ev2 = day.poll();
                spaceLength = spaceLength + ev2.get_startTime().get_hours() - ev1.get_endTime().get_hours();
            }
        }

        return _weight * (1 / (1+spaceLength));
	}
}
