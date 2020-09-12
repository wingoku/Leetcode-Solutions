package com.company.competitiveProgramming;

public class MinHeap {
    int[] minHeapArray = null;
    int currentIndex = 0;

    public MinHeap(int capacity) {
        minHeapArray = new int[capacity];
    }

    public void add(int item) {
        //adding to the heap by going farthest down and farthest right since heap is populated LEFT to RIGHT & TOP to BOTTOM
        minHeapArray[currentIndex] = item;
        currentIndex++;
        heapifyUp(); //we need to check if the current added item can be pushed to the top of the heap since min value in the heap is always at the top
    }

    public int poll() {
        int itemToReturn = minHeapArray[0];
        minHeapArray[0] = minHeapArray[currentIndex-1]; //removing the last item i-e; the item farthest down & farthest right in the binary heap tree
        minHeapArray[currentIndex-1] = Integer.MAX_VALUE;
        currentIndex--;
        heapifyDown(); // we need to make sure the item we moved to the top during this poll method, is NOT breaking the minHeap structure i-e; the root/top most item in the minHeap is always the smallest value
        return itemToReturn;
    }

    private void heapifyUp() {
        //check if the currently added item is smaller than its parent
        int currentNodeIndex = currentIndex-1;
        int parentIndex = getParentIndex(currentNodeIndex);

        while(parentIndex >= 0) {
            if(currentNodeIndex == parentIndex)
                return;

            if(minHeapArray[currentNodeIndex] < minHeapArray[parentIndex]) {
                swap(currentNodeIndex, parentIndex);
                currentNodeIndex = parentIndex;
                parentIndex = getParentIndex(currentNodeIndex);
            }
            else break;
        }
    }

    private void heapifyDown() {
        int currentNodeIndex = 0;
        int leftChildIndex = getLeftChildIndex(currentNodeIndex);
        int rightChildIndex = getRightChildIndex(currentNodeIndex);

        while(currentNodeIndex < currentIndex) {

            if (leftChildIndex <= currentIndex - 1 && minHeapArray[leftChildIndex] < minHeapArray[currentNodeIndex]) {
                swap(currentNodeIndex, leftChildIndex);
                currentNodeIndex = leftChildIndex;
                leftChildIndex = getLeftChildIndex(currentNodeIndex);
                rightChildIndex = getRightChildIndex(currentNodeIndex);

            } else if (rightChildIndex <= currentIndex - 1 && minHeapArray[rightChildIndex] < minHeapArray[currentNodeIndex]) {
                swap(currentNodeIndex, rightChildIndex);
                currentNodeIndex = rightChildIndex;
                leftChildIndex = getLeftChildIndex(currentNodeIndex);
                rightChildIndex = getRightChildIndex(currentNodeIndex);

            } else break;
        }
    }

    private void swap(int currentPositionIndex, int finalPositionIndex) {
        if(currentPositionIndex >= 0 && finalPositionIndex >= 0 && currentPositionIndex != finalPositionIndex) {
            /**
             * We swap the node/item at the current position with node/item at final position
             * in case of heapifyUp(), we replace currentIndex which is the index of the child node with the finalIndex which is the index of its parent node
             */
            int temp = minHeapArray[finalPositionIndex];
            minHeapArray[finalPositionIndex] = minHeapArray[currentPositionIndex];
            minHeapArray[currentPositionIndex] = temp;
        }
    }

    private int getParentIndex(int currentNodeIndex) {
        return (currentNodeIndex-1)/2;
    }

    private int getLeftChildIndex(int currentNodeIndex) {
        return 2 * currentNodeIndex + 1;
    }

    private int getRightChildIndex(int currentNodeIndex) {
        return 2 * currentNodeIndex + 2;
    }
}
