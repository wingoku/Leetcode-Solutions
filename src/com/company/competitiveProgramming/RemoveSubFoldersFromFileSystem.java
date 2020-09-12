package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveSubFoldersFromFileSystem {

    //accepted by leetcode
    //timeComplexity = O(N * M * K) or O(n log n) n log n is cuz of Arrays.sort. So if n long n is higher than N * M * K than the upper bound/worst case time complixity would be N*m*K
    // N: size of folders array
    // M: spliting string into substrings
    // K: iterating over the substring array
    public List<String> removeSubfolders(String[] folder) {

        /*
            /a is a folder
            /a/b
               -> /b is a subfolder of /a

            /a/b/c
                -> /b is a subfolder of /a
                -> /c is a subfolder of /b


            Example:
            /a/b , /a/b/c, /a/b/c/d

            the main folder in the given list is /a/b
            other occurances of folders that include /a/b in the beginning can be removed



            SOLUTION:

            Dynamic programming cuz we need to check if we came across a folder that matches with the first n characters of the current folder

            loop of the array,
            start at index 0,
            put the folder at index 0 in map

            move to the next one and check if the first few characters of the current folder match with characters of the folder in the map


            /a/b/c, /b, /a

            result= /b, /a

        */

        Arrays.sort(folder);
        HashSet<String> hashSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        for(int i=0; i<folder.length; i++) {
            if(folder[i].isEmpty() || folder[i].equals("/"))
                continue;
            addNonSubFolders(folder[i], hashSet, result);
        }

        hashSet.clear();

        return result;
    }

    private void addNonSubFolders(String currentFolder, HashSet<String> hashSet, List<String> result) {
        String[] subStrings = currentFolder.split("/");

        String temp = "";
        for(int i=1; i<subStrings.length; i++) {
            temp += ("/"+subStrings[i]);
            if(hashSet.contains(temp)) {
                return;
            }
        }

        hashSet.add(currentFolder);
        result.add(currentFolder);
    }
}
