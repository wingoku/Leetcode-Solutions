package com.company.competitiveProgramming;

public class FirstBadVesion {
    /**
     The idea is to find the a number in a range of numbers
     To do this efficiently we use binary search

     when we find the first bad version, we store it in a variable and keep checking for a new bad version
     and keep shrinking the window and take the window more towards the left side of the spectrum cuz
     we want the smallest badVersion number


     from leetcode
     How about the terminating condition? We could guess that leftleft and rightright eventually both meet and it must be the first bad version, but how could you tell for sure?

     The formal way is to prove by induction, which you can read up yourself if you are interested. Here is a helpful tip to quickly prove the correctness of your binary search algorithm during an interview. We just need to test an input of size 2. Check if it reduces the search space to a single element (which must be the answer) for both of the scenarios above. If not, your algorithm will never terminate.
     */
    //TC; O(logN)
    //SC: O(1)
    public int firstBadVersion(int n) {

        if(n == 0)
            return 1;

        int mid =0;

        int left = 0;
        int right = n;

        int badVersion = n;

        while(left < right) {
            mid = left + (right - left) / 2;//to avoid int overflow

            if(isBadVersion(mid)) { //isBadVersion is a method is an extended class provided by leetocde
                badVersion = mid;

                right = mid;
            }
            else {
                left = mid+1;
            }
        }

        return badVersion;
    }

    private boolean isBadVersion(int n) {
        return true; //i did this for example purposes
    }
}
