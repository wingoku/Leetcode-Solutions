package com.company.competitiveProgramming;

import java.util.HashSet;

public class UniqueEmailAddresses {
    //leetcode accepted solution
    //amazon coding interview
    //TC: O(N+C) where N is the length of emails array & C is the max number of character in an email in the provided array
    public int numUniqueEmails(String[] emails) {
        //everything after + in name part of the email is discarded
        //domain names in email can have +
        // . in name part of the email is removed & the 2 words are merged
        //we don't remove + . from domain name

        HashSet<String> uniqueEmailsSet = new HashSet<>();

        for(String email : emails) {
            int atSignIndex = email.indexOf("@");
            String namePart = email.substring(0, atSignIndex);
            if(namePart.contains("+")) {
                namePart = namePart.substring(0, namePart.indexOf("+"));
            }
            namePart = namePart.replaceAll("\\.", "");
            uniqueEmailsSet.add(namePart.concat(email.substring(atSignIndex, email.length())));
        }

        return uniqueEmailsSet.size();
    }
}
