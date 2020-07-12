package com.company.competitiveProgramming;

public class RobotReturnToOrigin {

    /// L R D U
    // L L R R D U D U
    // L RR D U
    //AMAZON CODING INTERVIEW
    //leetcode accepted it. 3ms

    /**
     * The idea is to find out if the robot ends up at the positoin it started at
     * So if the robot moves left from it's original position,
     * In order for it to return back to it's originl position, it must move Right once.
     *
     * So in essense what we need to check if Left moves count == Right moves count && Up moves count == Down moves count
     */
    public boolean isRobotReturningToOriginalPosition(String moves) {
        int[] asciiArray = new int[126];

        for(int i=0; i<moves.length(); i++) {
            asciiArray[moves.charAt(i)]++;
        }
        return (asciiArray['L'] == asciiArray ['R'] && asciiArray['U'] == asciiArray['D']);
    }
}
