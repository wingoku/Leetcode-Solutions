package com.company.competitiveProgramming.incomplete;

import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {
    //incomplee
    boolean pathFound = false;
    public boolean canCross(int[] stones) {

        HashSet<Integer> stonesSet = new HashSet<>();

        for(int i : stones)
            stonesSet.add(i);

        int[] jumps = new int[stones.length];
        jumps[0] = 1;
        jumps[1] = 1;

        canReachArrayEnd(stones, stones[1], jumps, 1, stonesSet);

        System.out.println("pathFound: "+ pathFound);
        return pathFound;
    }

    private boolean canReachArrayEnd(int[] stones, int k, int[] jumps, int index, HashSet<Integer> set) {
        //next_jump_destination = currentStoneValue+k || currentStoneValue+k+1 || currentStoneValue+k-1

        if(index >= stones.length || index < 0 || !set.contains(k))
            return false;

        if(pathFound || k == stones[index] && index == stones.length-1) {
            pathFound = true;
            return true;
        }

        //i=2, k=3
        //i=3, k = 5
        //i=4, k=8
        //i=5, k=12
        //i=6,
        jumps[index] = k;

        int newJump = 0;
        if(index >= 2)
            newJump = jumps[index] + jumps[index-1];
        else
            newJump = jumps[0] + jumps[index-1];

        boolean kJumps = canReachArrayEnd(stones, newJump, jumps, index+1, set);
        boolean kPlus1Jumps = canReachArrayEnd(stones, newJump+1, jumps, index+1, set);
        boolean kMinus1Jumps = canReachArrayEnd(stones, newJump-1, jumps, index+1, set);

        return kJumps || kPlus1Jumps || kMinus1Jumps;
    }
}
