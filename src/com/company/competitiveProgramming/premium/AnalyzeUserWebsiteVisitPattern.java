package com.company.competitiveProgramming.premium;

class Solution {

    /**
     create sequence
     create usermap map<user, <web, webFrequency>>

     create webMap <web, <

     User {
     map<web, webObject>

     }

     web {
     map<user, count>
     }

     //find which website was visited by most users
     //find how many users visited a website

     than
     create a map of website and user count and the websites visited by the most users are at the top

     return string based on the user count and web frequency
     */
    public List<String> mostVisitedPattern(String[] userNames, int[] timestamps, String[] websites) {
        HashMap<String, List<Pair>> map = new HashMap<>();

        for(int i=0; i<userNames.length; i++) {
            String userName = userNames[i];
            int time = timestamps[i];
            String website = websites[i];

            map.putIfAbsent(userName, new ArrayList<>());
            map.get(userName).add(new Pair(time, website));
        }

        HashMap<String, Integer> count = new HashMap<>();
        String result = "";

        for(String userName : map.keySet()) {
            HashSet<String> set = new HashSet<>();
            List<Pair> list = map.get(userName);
            Collections.sort(list, (p1, p2) -> Integer.compare(p1.time, p2.time));

            for(int i=0; i<list.size(); i++) {
                for(int j=i+1; j<list.size(); j++) {
                    for(int k=j+1; k<list.size(); k++) {
                        String str = list.get(i).web +" "+ list.get(j).web + " "+ list.get(k).web;

                        if(!set.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0)+1);
                            set.add(str);
                        }

                        if(result.isEmpty() || count.get(result) < count.get(str) || count.get(result) == count.get(str) && result.compareTo(str) > 0) {
                            result = str;
                        }
                    }
                }
            }
        }

        List<String> results = Arrays.asList(result.split(" "));

        return results;
    }

    class Pair {
        int time;
        String web;

        public Pair(int time, String web) {
            this.time = time;
            this.web = web;
        }
    }
}