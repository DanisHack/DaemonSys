DaemonSys
=========

During system programming lab, we are asked apply our knowledge about daemon processes to create simple server daemon.


Overview:
=========

This process exhibits the following behaviour:
• It is possible to run the server process as an ordinary process for testing purposes.
• The process accepts a command-line option “-d” to daemonize the process. In the
absence of this option, the process runs as an ordinary process.
• The process uses the syslog facility to log messages sent to it.
• Communication between the server and client processes use TCP/IP datagram sockets.
