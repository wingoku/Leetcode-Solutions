package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for(String word : wordDict)
            set.add(word);


        return dfs(s, 0, set, new HashMap<Integer, Boolean>());
    }

    private boolean dfs(String s, int index, HashSet<String> set, HashMap<Integer, Boolean> dp) {
        if(index >= s.length())
            return true;


//        System.out.println("before: "+ index);
//        if(dp.containsKey(index))
//            return dp.get(index);

        System.out.println(index + " " + s.substring(index));

        boolean found = false;
        for(int i=index; i<s.length(); i++) {

            String word = s.substring(index, i+1);

            if(set.contains(word)) {
                // System.out.println(word);
                found = dfs(s, i+1, set, dp);

                if(found)
                    break;
            }
        }

        dp.put(index, found);

        return found;
    }
}
