package com.pvlbzn.intconv;

public class Sanitizer {

    public static String process(String msg) {
        // Here must be performed proper user input sanitization.
        if (msg.equals("")) {
            return " ";
        }

        if (msg.length() > 3) {
            return msg.substring(0, 3);
        }

        return msg;
    }

}
