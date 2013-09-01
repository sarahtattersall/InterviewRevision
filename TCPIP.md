# TCP/IP Networking (OSI stack, DNS etc): #

## Intro ##

* Provides end-to-end connectivity specifying how data should be formatted, addressed, transmitted, routed and received at the destination.
* It has four abstraction layers:
  1. __Link Layer__: contains communication technologies for a single network segment of a LAN
  2. __Internet Layer__: connects independent networks
  3. __Transport Layer__: handles host-to-host communication.
  4. __Application Layer__: contains all protocols for specific data communications services on a process-to-process level. 
  
##  Layers ##
In general an application uses a set of protocols to send its data down the layers being further encapsulated at each level. The layers near the top are logically closer to the user application. Those near the bottom are closer to the physical transmission.
### Application Layer ###
This is the  scope within which applications create user data and communicate this data to other processes or applications on another or the same host. The communications partners are often called peers. Higher level protocols take place here.
#### SMTP (Simple Mail Transfer Protocol) ####
Email is submitted by a mail client to a mail server agent (MSA) using SMTP on TCP port 578 (although port 25 was traditional). This mail server delivers mail to its mail transfer agent (MTA). The boundary MTA then has to locate the target host using the DNA to look up the mail exchanger (MX) record. 
When the MX target accept the incoming message it hands it to a mail delivery agent (MDA). Once delivered to the local mail server the mail is stored for batch retrieval
 by authenticated mail clients (MUAs) which is then retrieved by end-user applications using IMAP or POP.

![image](http://upload.wikimedia.org/wikipedia/commons/thumb/6/69/SMTP-transfer-model.svg/300px-SMTP-transfer-model.svg.png)

The actual protocol consists of three command/reply sequences.
1. __MAIL__ command, establishes the return address.
2. __RCPT__ command establishes recipient of the message. 
3. __DATA__ sends the message text.

#### SSH ####
This is a cryptographic network protocol for secure data communication remote command-line login, remote command execution, and other services between two networked computers. It uses public-key cryptography to authenticate the remote computer and allow it to authenticate the user. 

The standard TCP port 22 has been assigned for contacting SSH servers and the SSH-2 protocol has an internal architecture with well separated layers:

1. __Transport Layer__: handles the initial key exchange as well as server authentication and sets up encryption, compression and integrity verification. It exposes to the upper layer an interface for sending and receiving plaintext packets. It also arranges for key re-exchange after 1GB of data has been transferred/1 hour has passed. 
2. __Authentication Layer___ handles client authentication and provides a number of authentication methods. 
3. __Connection Layer__ defined the concept of channels, channel requests and global requests. A single SSH connection can host multiple channels simultaneous, each transferring data in both directions. 

#### FTP ####
FTP is built on a client-server architecture and uses separate control and data connections between the client and server. FTP users may authenticate themselves using a clear-text sign in protocol, e.g. a username/password. FTP is often secured with SSL/TLS. 

FTP may run in active of passive mode, which determines how the data connection is established. In _active_ mode, the client creates a TCP control connections. If the client is behind a firewall and unable to accept incoming TCP connections, _passive_ mode may be used.

![image](http://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Passive_FTP_Verbindung.svg/220px-Passive_FTP_Verbindung.svg.png)

Here the client uses the control connection to send a PASV command to the sever and then receives a server IP address and port number, which the client then uses to open a data connection from an arbitrary client port on the server IP address and server port number received. 

The server responds over the connection with three-digit status codes in ASCII. E.g. "200 OK". The numbers represent the code for the response and the optional text is a human-readable explanation. 

#### HTTP (Hypertext Transfer Protocol) ####
This is the foundation of data communication for the World Wide Web. 

Hypertext is structured  text that uses logical links between nodes containing text. HTTP is the protocol to exchange or transfer hypertext.
HTTP functions as a request-response protocol in the client-server computing model (For example the web browser may be the client and an application running on a computer hosting a web site may be the server). The client submits a _HTTP request_ message to the server which in turn provides resources such as HTML files and other content. 
High traffic websites often benefit from web cache servers that deliver content on behalf of upstream servers to improve response time. Web browsers also cache previously accessed web resources and reuse them when possible. 

HTTP defines methods to incaate the desired action to be performed on the identified resource. For example:
* __GET__: Requests a representation of the specified resource. Requests using GET should only retrieve data.
* __POST__: Requests that the server accept the entity enclosed in the request as a new subordinate of the web resource identified by the URI. 
* __HEAD__: Asks for the response identical to the one that would correspond to a GET request but without the response body. Useful for retrieving meta-information.