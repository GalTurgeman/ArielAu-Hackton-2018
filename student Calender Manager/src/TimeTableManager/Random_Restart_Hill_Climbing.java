package TimeTableManager;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Random_Restart_Hill_Climbing {

    public static Schedule computeBestSchedule(Schedule state) throws Exception{
        long startTime = System.currentTimeMillis();
        long runningTime = 0;
        Schedule bestStateFound = state;

        while (runningTime <= 1) {
            int sameGradeCounter = 0;
            Schedule father = state;
            boolean isOnTop = false;
            PriorityQueue<Schedule> neighbours = generateScheduleNeighbours(bestStateFound);
            Schedule bestNeighbour = neighbours.poll();
            if (bestNeighbour.compareTo(state) < 0) {
                isOnTop = true;
            } else if (bestNeighbour.compareTo(state) == 0) {
                bestStateFound = bestNeighbour;
                sameGradeCounter++;
            } else {
                bestStateFound = bestNeighbour;
            }

            while (!isOnTop || sameGradeCounter == 10) {
                neighbours = generateScheduleNeighbours(bestStateFound);
                neighbours.remove(father);
                father = bestStateFound;
                bestNeighbour = neighbours.poll();
                if (bestNeighbour.compareTo(state) < 0) {
                    isOnTop = true;

                } else if (bestNeighbour.compareTo(state) == 0) {
                    bestStateFound = bestNeighbour;
                    sameGradeCounter++;

                } else {

                    bestStateFound = bestNeighbour;
                }

            }
            runningTime = (System.currentTimeMillis() - startTime) / 60000;
            state = DB.getInstance().randomSchedule(state);
        }
        return bestStateFound;
    }

    private static PriorityQueue<Schedule> generateScheduleNeighbours(Schedule state) throws Exception {
        System.out.println("generateScheduleNeighbours");

        PriorityQueue<Schedule> neighbours = new PriorityQueue<>();
        for (Event event : state.getAllEvents()) {
            for (Event eventToSwapWith : DB.getInstance().getSimilarEvents(event)) {
                if (event != eventToSwapWith) {
                    Schedule newNeighbour = state;
                    newNeighbour.swapEvent(event, eventToSwapWith);
                    neighbours.add(newNeighbour);
                }
            }
        }
        return neighbours;
    }

}
