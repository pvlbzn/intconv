## An Intelligent Conversation

Useless project about client-server communication. Request - response, ones and zeroes, bips and bops, you know, computers.

### Client Side

![MainActivity](https://github.com/pvlbzn/intconv/blob/master/images/MainActivity.png) ![CommunicationActivity](https://github.com/pvlbzn/intconv/blob/master/images/CommunicationActivity.png)

Client side is an android app, which connects to the server side via sockets. All communication based on pure sockets because why not.

### Server Side

`server.py` server is implemented on Python using sockets. Server is single threaded.