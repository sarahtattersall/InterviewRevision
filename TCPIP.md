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


### Transport Layer (host-to-host) ###
This layer constitutes the networking regime between two network hosts, either on the local network or on remote networks separated by routers. The transport layer provides a uniform networking interface that hides the actual topology of the underlying network connections This is where flow-control, error-correction, and connection protocols exist. This layer deals with opening and maintaining connections between internet costs.

It establishes a __basic data channel__ that an application uses in it's task-specific data exchange. 

### Internet Layer ###
This layer exchanges datagrams across network boundaries. This layer defines the addressing and routing structures used for TCP/IP. The primary protocol is the Internet Protocol which defines IP addresses.  Its function in routing is to transport datagrams to the next IP router that has the connectivity to a network closer to the final destination.

The IP has two basic functions:

1. __Host addressing and identification__ which is accomplished with a hierarchical IP addressing system.
2. __Packet Routing__ is the basic task of sending packets of data from source to destination by forwarding them to the next router closeser to the final destination.

#### IP Address ####

#### Routing ####

### Link Layer ###
This defines tnetworkinging methods within the scope of the local network link on which hosts communicate without intervening routers. This layer describes the protocols used to descript the local network topology and interfaces needed to effetransmutationion of the datagrams to next-neighbour hosts.

It moves packets betweene the internet layer interfaces of two different hosts on the same link. It adds packet headers preparing data for transmission and then transmits the frame over a physical medium. 


## The OSI Stack ##
The OSI model is a conceptual model that characterises and standardises the internal functions of a communication system by partitioning it into __abstraction__ layers.

![image](http://www.novell.com/info/primer/art/prim02.gif)


1. __Physical Layer__
    * Defines the __electrical__ and physical specifications. 
    * Defines the relationship between a device and a physical transmission medium
    * Defines the protocol to establish and terminate a connection between two directly connected nodes
    * Defines a protocol for __flow__control
    * Defines a protocol for the provision of a connection between two directly connected nodes.
    * Takes care of parallel to serial conversion.
    * __Synchronous transmission__ clock is derived from signal. Different methods are:
        * __Bipolar__: uses transitions between levels to encode bits.
        * __Manchester__: Splits each bit in half and uses two voltage T and F. 
        * __Differential__: 1 is no transition, 0 is transition at start of bit.
        * __NRZI__: Non return to zero, invert on ones.
    * __Asynchronous transmission__ receiver keeps own clock -> clock drift 


2. __Data Link Layer__
    * Provides a __reliable link__ between two directly connected nodes, by detecting and correcting errors that may occur in the physical layer.
    * An example of a daaa link layer is the Point-to-Point protocol (PPP)
    * Describes protocols for __broadcast__ network when two transmitters want to talk at same time.
        * __MAC__ both frames lost, must be transmitted again
        * __ALOHA__ on collision sender waits random time before trying again. Improved with _slotted transmission_, _carrier sensing_ or _token passing_.
    	* __Binary Exponential Back-off__: transmit, if collision occurs wait 0, 1 slot before transmitting. If another collision wait 0, 1, 2 or 3 slots. etc. 
    
3. __Network Layer__
    * Provides the functional and procedural means of transferring variable length data sequences (__datagrams__)
    * It may/may not implement message delivery by splitting the message into __fragments__.
    * Datagram delivery is not guaranteed to be reliable.
    * Examples of network layers are 
       * __IP__: has the task of delivering packets from the source host to the destination host solely based on the IP addresses in the packet headers. For this purpose, IP defines packet structures that encapsulate the data to be delivered. It also defines addressing methods that are used to label the datagram with source and destination information.                         
       * __UDP__
       * __MAC__.
    * Stores and forwards messages if data has been split into multiple packages.
    * Can use a repeater(__hub__) to increase signal strength. A __bridge__ does the same and stores-and-forwards (i.e. by processing the header).
    * Deals with __routing__. 
        * __Isoltated adaptive routing__ makes decisions purely on information of local node
        * __Distributed adaptive routing__ passes information between nodes
        * __Non adaptive routing__ means routers always take the same action.
        * __Flood routing__ sends data down all links except one it arrived on. It avoids loops by recording hop count and where packet has been.
        * __Source routing__ ???
        * __Backwards learning__: Bridges lean where the host is over time by using flooding. The reply teaches them where the destination host was.
        * __Distance vector routing__ has the router maintain a table of distances. It periodically exchanges information with its neighbour to recompute distances.
    * Deals with sub-netting
       
    
4. __Transport Layer__
    * Provides the __reliable__ sending of data packets between nodes. 
    * __TCP__: Is connection orientated transfer. Streams with reliable delivery. 
    * __UDP__: Is connection-less data transfer. Good for fast transfer with resilience to packet loss.
    * Uses protocol __ports__ to define end points. 
    * Deals with __Automatic Repeat Request(ARQ)__.
    
    
5. __Session Layer__
    * Provides mechanism for opening, closing and managing a session.
    * Controls the __dialogues__ between computers. 
    * Establishes, manages and terminates connections between the local and remote application.
    * Provides __full-duplex__, __half-duplex__, or __simplex__ operation. 
    
    
6. __Presentation Layer__  
    * Serves as the data translator for the network. 
    * Establishes __context__ between application layer entities. 
    * Provides independence from data representation by translating between application and network formats
    
7. __Application Layer__
    * Closest to the end user
    * Interacts with software applications. 
 