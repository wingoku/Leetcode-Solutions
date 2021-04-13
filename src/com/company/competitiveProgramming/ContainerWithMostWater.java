package com.company.competitiveProgramming;

public class ContainerWithMostWater {
    class Solution {
        /**
         The container with most amount of area would contain the most amount of water
         So the idea is to calculate the max area
         area = width * height

         two pointer
         if left pillar height is smaller than right pillar height, than we increment start pointer
         and
         if right pillar height is smaller than or equal to left pillar height than we increment end pointer
         */
        //tc: O(N)
        //SC: O(1)
        public int maxArea(int[] height) {

            int maxArea = 0;
            int start = 0;
            int end = height.length-1;

            while(start < end) {
                int pillar1 = height[start];
                int pillar2 = height[end];

                int area = getArea(start, end, pillar1, pillar2);
                maxArea = Math.max(maxArea, area);

                //so in the beginning since pillar 1 is smaller than pillar 2, (1, 7), we increment start
                //now the pillar 1 height would be 8, we calculate the area and now we come to this condition
                //since pillar 1 is bigger than pillar2, we decrement end pointer
                //again we calculate the max area but this time it'd be less than prev calculate area
                //so decrement end pointer again cuz it's smaller than left pillar.
                if(pillar1 < pillar2)
                    start++;
                else
                    end--;
            }

            return maxArea;
        }

        private int getArea(int start, int end, int pillar1, int pillar2) {
            int widthDiff = end - start;
            int heightDiff = Math.min(pillar1, pillar2); //because our container's area is limited by the height of the smaller pillar cuz if one wall is bigger than the other and we take the bigger wall to calculate the area,
            //it would mean that we'd spill water

            return widthDiff * heightDiff;
        }
    }
}
