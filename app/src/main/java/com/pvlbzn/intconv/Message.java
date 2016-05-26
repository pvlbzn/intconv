package com.pvlbzn.intconv;

/*
 * Message class is represent a message.
 */
public class Message {

  public int source;
  public String uname;
  public String msg;

  public static int USER = 1;
  public static int REMOTE = 2;

  public Message(int s, String n, String m) {
    this.source = s;
    this.uname = n;
    this.msg = m;
  }
}
