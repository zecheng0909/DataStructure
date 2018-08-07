package com.cheng;

import com.cheng.stack.ArrayStack;

/**
 * Created by cheng on 2018/6/29.
 */

public class Valid {


    public static void main(String[] args) {
        boolean b = check(null);
        System.out.println(b + "");
    }

    public static boolean check(String[] args) {

        String s = "()";

        ArrayStack<Character> list = new ArrayStack<>();

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '{' || c == '[' || c == '(') {
                list.push(c);
            } else {
                if (list.isEmpty())
                    return false;

                Character top = list.pop();

                if (c == ')' && top != '(')
                    return false;

                if (c == '}' && top != '{')
                    return false;

                if (c == ']' && top != '[')
                    return false;

            }
        }

        return list.isEmpty();
    }
}
