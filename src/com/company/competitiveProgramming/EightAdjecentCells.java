package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EightAdjecentCells {

    //working. Amazon coding interview
    //passed
    public List<Integer> cellCompete(int[] states, int days) {

        List<Integer> oldStates = new ArrayList<>();
        for(int i=0; i<states.length; i++)
            oldStates.add(states[i]);

        List<Integer> updatedStates = new ArrayList<>();

        for(int day = 0; day < days; day++) {
            updatedStates = new ArrayList<>();
            for(int i=0; i<oldStates.size(); i++) {
                if(i==0)
                    updatedStates.add(getUpdatedValue(0, oldStates.get(i+1)));
                else
                    if(i== oldStates.size() -1) {
                        updatedStates.add(getUpdatedValue(oldStates.get(i-1), 0));
                    }
                    else
                        updatedStates.add(getUpdatedValue(oldStates.get(i-1), oldStates.get(i+1)));
            }
            Collections.copy(oldStates, updatedStates);
        }
        return updatedStates;
    }

    private int getUpdatedValue(int prev, int next) {
        if(prev == next)
            return 0;
        return 1;
    }
}
