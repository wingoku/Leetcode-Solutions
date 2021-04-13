package com.company.competitiveProgramming.premium;

class Solution {
    public String rearrangeString(String s, int k) {

        //aa 5
        if(s.length() <= 1 || k <= 1 || k > s.length())
            return s;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> {
            return Integer.compare(map.get(c2), map.get(c1));
        });

        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        Queue<Character> q = new LinkedList<>();

        //aabbcc k = 3
        //take out a
        //a count -- = 1
        //put a in the q
        //q size < 3 :: q size = 1
        //takeout b
        //b count -- = 1
        //put b in the q
        //q size < 3 :: qsize = 2
        //take out c
        //c count -- = 1
        //put c in the q
        //q size == 3  --- maxHeap in this example is empty now
        //get past the continue condition cuz now the next character we add in the maxHeap for sure will be K distance apart
        //take out the top element out of the q
        //put it in to the maxHeap
        //take out a
        //a count -- = 0
        //put a in to the q
        //q size == 3
        //take out the top element from q that's b
        //put b in the maxheap
        //take out b from maxheap
        //b count -- = 0
        //put b into the q
        //q size == 3
        //take out the top element from the q
        //put c into the maxheap
        //take out c
        //c count -- = 0
        //q size == 3
        //take out the top element from the q
        //the count of the top element a is zero
        //maxHeap stays empty, we get out of the loop
        //then check if the rearranged string size == given string. If yes that means we sucessfully put all characters K distance away from themselves
        //if rearrange string size != given string size return "" cuz we couldn't rearrange them
        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            sb.append(c);
            map.put(c, map.get(c)-1);
            q.offer(c);

            if(q.size() < k)
                continue;

            char cc = q.poll();
            if(map.get(cc) > 0) {
                maxHeap.offer(cc);
            }
        }

        /*
        in example: "aaabc"

        we put abc in the map with count 3 1 1 respectively
        we run the maxHeap.noEmpty loop

        we take out a, decrement its count to 2 and put a in the q. q size = 1
        we take out b, decrement its count to 0 and put b in the q. q size = 2
        we take out c, decrement its count to 0 and put c in the q. q size = 3

        we get past the q.size() < K condition

        we take out the top element from q which is a
        and put it in the maxHeap

        we decrement a count to 1
        we put it into the q

        q size == 3 again

        we take out the top element from the q which is b. It's count = 0
        so we don't put it in the maxHeap
        so maxHeap is empty so we get out of the loop

        then we check if sb.length() == giveString.length() which is not true cuz sb contains only abca and it's size is 4 and given string size is 5
        so it means we couldn't rearrange it. so we return ""
        */

        return sb.length() == s.length() ? sb.toString() : "";
    }
}