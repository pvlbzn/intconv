# Kind of server for 'An Inteligent Conversation' project.
# It uses sockets because why not. If request is "Bip"
# responce will be "Bop", otherwise - "Bip".
from socket import *


def start_server(address):
    sock = socket(AF_INET, SOCK_STREAM)
    sock.setsockopt(SOL_SOCKET, SO_REUSEADDR, 1)
    sock.bind(address)
    sock.listen(5)
    while True:
        client, addr = sock.accept()
        print("Connection:", addr)
        handle_conn(client)


def handle_conn(client):
    while True:
        # Buffer size
        req = client.recv(512)
        if not req:
            break
        # Chop request.
        s = str(req)[2:len(str(req)) - 3]
        resp = "Bop" if s == "Bip" else "Bip"
        client.send(resp.encode("ascii") + b'\n')


if __name__ == "__main__":
    addr = ('', 24000)
    start_server(addr)
