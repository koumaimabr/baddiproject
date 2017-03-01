#Program that converts an NFA to a DFA and minimizes it.

#Synopsis

This program converts an NFA into a minimized DFA.

#Usage

You can run this program by compiling with QT libraries included in Eclipse, or compiling separately and then setting "Class-Path:" line in JAR manifest file. 
For Eclipse:
First download QT Jambi libraries for your OS:
http://qtjambi.org/downloads
And extract the zip. 

Then Import the Java files here as a new project in Eclipse. In properties of project, select "Java Build Path". Click on " Libraries" , and select " Add External JARs" , to add two JARs from the extracted QT Jambi zip: 

1. qtjamb-4*.jar
2. qtjambi-native*
Then you can just run the project in eclipse, or export as a JAR. 

For manually running:
Compile the project as a JAR, and include the two files mentioned above as a class-path.

You can use the included JAR to run without a need to download QT jambi libraries, as they are included in it .
Note: That JAR file has only the Linux 64 bit QT Jambi libraries for now. Other platforms will be included soon

#Contributors
This is a project for the languages theory class.

By :
Ouissal Benameur
Oumaima Kabbouri
Charaf Boughriba


 
