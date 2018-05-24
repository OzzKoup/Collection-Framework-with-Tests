#Techlogies which using :

Java 1.8, Maven, JUnit, PowerMock, Mockito;

#Plugins : 

Checkstyle

#To run this project locally :
1)At first u must clone it (-git clone http://git.foxminded.com.ua/Yaroslav/Solutions.git ).
2)Move to the home path "Solution/".
3)Open by your IDEA : "File - Open"(IntelliJ IDEA)
                      "File - Import - General - File System" (Eclipse)
4)Choose in your workspace "Application.java" build and run (Shift + F10) -> IntelliJ IDEA.
                                                            (Cntrl + Shift + F11) -> Eclipse.
5)Well done.

The plugin "checkstyle" is in src/checkstyle folder.
It consists of 2 parts : jar and xml(configurated rules);


#Task descriprion : 

Write an application that takes a string and returns the number of unique characters in the string.
It is expected that a string with the same character sequence may be passed several times to the method.
Since the counting operation can be time consuming, the method should cache the results, so that when the method is given a string previously encountered,
it will simply retrieve the stored result. Use collections and maps where appropriate.

E.g.

  hello world!
  "h" - 1
  "e" - 1
  "l" - 3
  "o" - 2
  "w" - 1
  "r" - 1
  "d" - 1
  "!" - 1
  " " - 1
