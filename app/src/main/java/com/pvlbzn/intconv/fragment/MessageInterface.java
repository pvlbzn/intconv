package com.pvlbzn.intconv.fragment;

/*
 * MessageInterface contains necessary method which must be implemented
 * by Fragment in order to receive a message from Activity.
 */
public interface MessageInterface {
    public void receiveMessage(String msg);
}
