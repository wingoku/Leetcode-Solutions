package com.company.competitiveProgramming;

import java.util.Collections;
import java.util.Stack;

public class SimplifyPath {

    /**
     1. NO slash at outputString.length()-1
     2. if 2 consecutive slashes, replace them with 1
     3. double .. means go up
     4, root is /
     5. whenever /xyz/ than increment directory level count

     */
    public String simplifyPath(String path) {

        if(path == null || path.trim().isEmpty())
            return "";

        Stack<String> stack = new Stack<>();

        path = path.replace("//", "/");
        path = path.trim();

        String[] pathArray = path.split("/");

        for(String s : pathArray) {

            if(s.equals(".") || s.isEmpty())
                continue;

            if(s.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(s);
        }

        StringBuilder sb = new StringBuilder();

        if(stack.isEmpty()) {
            sb.append("/");
        }
        else {
            Collections.reverse(stack);

            while(!stack.isEmpty()) {
                sb.append("/").append(stack.pop());
            }
        }

        return sb.toString();
    }
}
