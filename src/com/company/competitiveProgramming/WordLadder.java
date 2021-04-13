package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    /**
     WHY ARE WE USING BFS

     cuz when ever we want to find the shortest path to a given node we use DFS
     This video at time: 5:05 explains the reason WHY dfs is not the right choice for finding the shortest path
     https://www.youtube.com/watch?v=nVH5hyVSXa8
     */
    /**
     Input:
     beginWord = "hit",
     endWord = "cog",
     wordList = ["hot","dot","dog","lot","log","cog"]

     The idea is to find another word that's only one character difference

     We can think of each word as a node and the given condition two words are connected
     if there is only one character difference between them

     Using this idea we think of this problem a graph problem

     Based on this concept, we take the given word and than find all the variations of it
     by changing each character in the word from a-z and check if the new word with
     one changed character is present in the given list

     if yes, we add that word in the queue since it's a child node/adjecent vertex of
     the word in whome we changed one character & MARK IT AS VISITED in order to not visit the same node twice


     For Example:

     Consider we poped the word "dot" from queue
     in this findCombinations(), we will generate the words "dog" & "log" and put them in the queue cuz it's in the given words list

     now the queue looks like ["dog", "log"]
     than we pop "dog" from the queue and come to findCombinations() and generate its combinations
     we'll generate "log" combination again & put it in the queue
     cuz 2 reasons
     1. We didn't mark "log" as visited at the moment
     2. "log" is in the given words list

     now the queue looks like ["dog", "log", "log"]

     Now we've "log" 2 times in the queue. than we go back to the queue

     than we pop "log" from the cue and find its combination "cog" and put it in the queue
     now the queue looks like

     ["log", "cog"]

     that's how we'll end up visit "log" node twice


     WE DONT STOP after finding a combination when we're changing 1 character in the given word
     cuz there might be other nodes similar to the given word with 1 character variation
     that might have shorter path to the endWord

     We also make sure that we don't add the generated combination word that exactly the same
     as the word that we've already visited

     We start this process from the given word and perform the same process for all
     the word combinations that we put in the queue. Once we find the end word
     we return the graph/tree level at which we found the endWord
     */

    /**
     TIME COMPLEXITY:

     it'd we M^2 * N

     N = number of words aka nodes in the given list
     M = length of each word

     And for finding new combinations of each word, We've to M*26 iterations
     AND
     We also have to form the word from char array using new String(charArray) which takes M time again

     so in total the time complexity would be

     M * M(for recreating the combination of word into String) * N
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, Boolean> givenWordsMap = new HashMap<>();
        givenWordsMap.put(beginWord, false);

        for(String word : wordList)
            givenWordsMap.put(word, false);

        if(!givenWordsMap.containsKey(endWord))
            return 0;

        givenWordsMap.put(endWord, false);
        return bfs(beginWord, endWord, givenWordsMap);
    }

    private int bfs(String beginWord, String endWord, HashMap<String, Boolean> givenWordsMap) {
        int level = 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()) {
            int qSize = q.size();

            //traversing the level & adding child nodes of the nodes from this level
            for(int i=0; i<qSize; i++) {
                String word = q.poll();

                //if the word taken from the queue is matching with the endWord, than this node was
                //the node we're looking for. We end the bfs here
                if(word.equals(endWord)) {
                    return level + 1;
                }

                findCombinations(word, givenWordsMap, q);
            }

            level++;
        }

        return 0;
    }

    private void findCombinations(String currentWordNode, HashMap<String, Boolean> givenWordsMap, Queue<String> q) {
        for(int i=0; i<currentWordNode.length(); i++) {

            char[] currentNodeWordCharArray = currentWordNode.toCharArray();
            for(char c = 'a'; c <= 'z'; c++) {
                currentNodeWordCharArray[i] = c;

                String newCombination = new String(currentNodeWordCharArray);
                if(isWordPresentInGivenWordsList(newCombination, givenWordsMap)) {
                    // System.out.println(newCombination);
                    q.add(newCombination);
                    givenWordsMap.put(newCombination, true);//we found the node so we mark as visited
                    //the reason we mark it as visited here is cuz if we don't do it here we might
                    //generate similar combinations again and again after poping a word from queue

                    /**
                     For Example:

                     Consider we poped the word "dot" from queue
                     in this findCombinations(), we will generate the words "dog" & "log" and put them in the queue cuz it's in the given words list

                     now the queue looks like ["dog", "log"]
                     than we pop "dog" from the queue and come to findCombinations() and generate its combinations
                     we'll generate "log" combination again & put it in the queue
                     cuz 2 reasons
                     1. We didn't mark "log" as visited at the moment
                     2. "log" is in the given words list

                     now the queue looks like ["dog", "log", "log"]

                     Now we've "log" 2 times in the queue. than we go back to the queue

                     than we pop "log" from the cue and find its combination "cog" and put it in the queue
                     now the queue looks like

                     ["log", "cog"]

                     that's how we'll end up visit "log" node twice
                     */
                }
            }
        }
    }

    private boolean isWordPresentInGivenWordsList(String word, HashMap<String, Boolean> givenWordsMap) {
        return givenWordsMap.containsKey(word) && (givenWordsMap.get(word) == false);//if this word node already visited or not cuz we don't want to end up in recursive traversal between nodes
    }
}
