package com.company.competitiveProgramming;

import java.util.Arrays;
import java.util.List;

public class FacebookSimultaneousFlights {
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    //AMAZING EXPLANATION!! & solution inspired by: https://www.youtube.com/watch?v=KIKjKlbJUwU
    public int countOfAirplanes(List<Interval> airplanes) {
        if(airplanes == null || airplanes.size() == 0)
            return 0;

        int[] start = new int[airplanes.size()];
        int[] end = new int[airplanes.size()];

        int x = 0;
        for(Interval interval : airplanes) {
            start[x] = interval.start;
            end[x] = interval.end;
            x++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int simulFlights = 1;
        int maxSimulFlights = 1;

        int i=1; int j=0;

        while(i < start.length && j < start.length) {
            if(start[i] < end[j]) {
                simulFlights++;
                i++;
            }
            else{
                j++;
                simulFlights--;
            }

            maxSimulFlights = Math.max(maxSimulFlights, simulFlights);
        }

        return maxSimulFlights;
    }
}
