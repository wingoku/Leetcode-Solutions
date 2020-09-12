package com.company.competitiveProgramming;

public class PowerCalculator {

    //TC: O(log pow) cuz we keep dividing pow in halfs until we reach the base case which is pow<-0
    public double myPow(double x, int n) {
        return calPower(x, n);
    }

    private double calPower(double num, int pow) {
        double calculatedHalf = 0;
        boolean isPowerNegative = pow < 0;

        pow = Math.abs(pow);

        calculatedHalf = powHelper(num, pow);


        if(isPowerNegative) {
            calculatedHalf = 1.0/calculatedHalf;
        }

        // if(calculatedHalf > Double.MAX_VALUE || calculatedHalf < Double.MIN_VALUE)
        //     return 0;

        System.out.println("calculatedhalf: "+calculatedHalf);

        return calculatedHalf;
    }

    private double powHelper(double num, long pow) {
        System.out.println("pow: "+ pow );
        if(pow == 0)
            return 1;

        if(pow == 1)
            return num;

        //we keep dividing the power into it's half until the power value is less than 0
        //than it'll start returning values from the base case
        //Eg num: 2, pow: 4
        //powHelper(2,4/2);
        //powHelper(2, 2/2)
        //powHelper(2, 1/2)-> pow == 1 so we return 2
        //we start going up the stack
        //powHelper(2, 1/2) = we return 2
        //powHelper(2,2/2) = we get 2 from previous return
        //  as 2 is even, we do 2*=2 = 4, we return 4
        //powHelper(2,4/2) = we get 4 from previous return
        //  as 4 is even, we do 4*=4 = 16, we return 16
        //than we get out of recursion
        double calculatedHalf = powHelper(num, pow/2);

        System.out.println("pow: "+ pow + " result: "+calculatedHalf);

        if((pow & 1) == 0) {
            calculatedHalf *= calculatedHalf;
        }
        else {
            calculatedHalf *= (calculatedHalf * num);
        }

        return calculatedHalf;
    }
}
