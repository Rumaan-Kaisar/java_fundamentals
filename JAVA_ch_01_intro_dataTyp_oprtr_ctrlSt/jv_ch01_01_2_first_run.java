
/*  -=-=-=-=-=-=-=-=-=-=-=      Environmnet & first run      -=-=-=-=-=-=-=-=-=-=-=

        // Environmnet Setup
        // Sample JAVA program (basic-skeleton)
        // File naming & Execution


    ------------    Environmnet Setup    ------------

    Installing Java Development Kit (JDK), Netbeans IDE  and compiling a program

    Download and install JDK from oracle.com :
        The JDK supplies two primary programs. 
            The first is javac, which is the Java compiler. 
            The second is java, which is the standard "Java interpreter" and is also referred to as the "application launcher".
	
            The JDK runs in the command prompt environment and uses command-line tools (CLI). 
                It is not a windowed application. 
                It is also not an integrated development environment (IDE).

    NOTE : In addition to the basic command-line (CLI) tools supplied with the JDK, there are several high-quality IDEs available for Java, 
            such as NetBeans and Eclipse. 
            An IDE can be very helpful when developing and deploying commercial applications. 



    ------------    Sample JAVA program & compile    ------------

    Write and compile a Java program:  
        Before we start the following points should be maintained
	
        Enter the program: 
            Use simple text editor to write the program and crate the source-file.
	
        Name of the source-file: 
            A source file is called "compilation unit" in Java, and a Java compiler require the ".java" file extension after the source-file name.
	
            main class: 
                In java all code must reside inside a class called "main class". 
            
                By conversion, the "name of the main class" should match the "name of the source-file". 
                    Same name helps us to maintain and organize the codes easily.
                    The 'main-class' name and the 'source-file name' must maintain the CAPITALIZATION, because Java is case sensitive.  
	
        Compiling the program: 
            Before use the java compiler "javac" we have to add it in the "system-path". 
	
            Adding 'JAVA' in system-path:
                control panel  →  sysem security  →  system  →  advanced system setting  →  Environment variables(bottom)  
                    user variavle  →  path(add path)    and   sytem variable  →  path(add path) 

                If path doesn't exist crate one. Before edit, make sure that you copied the desired path (folder location in a drive) of the program. 

                    C:\Program Files\Java\jdk1.8.0_231\bin; 	 is the location for Java compiler  javac.

                    C:\Windows\Microsoft.NET\Framework\v4.0.30319;  	 is the location for C# compiler csc.exe. (for programming C# )


            Compiling the program:  
                To compile the "Example.java" program, execute the compiler, "javac", 
                specifying the name of the source file on the command line, as shown here: 	
                
                    javac Example.java

                The javac compiler creates a file called "Example.class" that contains the 'bytecode version 'of the program. 
                    Remember, bytecode is not executable code. 
                    Bytecode must be executed by a JVM (interpreter). 
                    Thus, the output of javac is not code that can be directly executed.
	
                Executing the application/program: 
                    To actually run the program, you must use the Java interpreter, "java". 
                        To do so, pass the class name "Example" as a command-line argument, as shown here: 	
                        
                            java Example
                    
                        Notice, no file extension ".class" is used. 
*/



// ----  rev  ----
/* Example 1:  The First Sample Program Line by Line: 
                This is a simple Java program. Call this file Example.java.
*/



class Example { 	// A Java program begins with a call to main( ).
public static void main(String args[]){ System.out.println("Java drives the Web.");
}
}

/* 
Method: In Java any function/subroutine is called "method"
	The first line is a multiple line comment section. 
	The next line is: 	class Example {
This line uses the keyword class to declare that a new class is being defined. Example is the name of the class. The class definition begins with the opening curly brace "{" and ends with the closing curly brace "}". The elements between the two braces are members of the class.  All program activity occurs within this main-class. On the right there is a single line comment.
	The next line: 		public static void main (String args[]) {
This line begins the main() method (function/subroutine called method in Java). This is similar to C/C++'s main() function, and some modifier and specifier are used in addition.  This is the line at which the program will begin executing. All Java applications begin execution by calling main(). Now let's see why the specifiers/modifiers are used :
	public is an access modifier defined previously in C/C++. In this case, main() must be declared as public, since it must be called by code outside of its class when the program is started. 
	The keyword static allows main() to be called before an object of the class has been created. This is necessary because main() is called by the JVM before any objects are made. [Recall C/C++ 14.3: Static Class Members: A static member variable exists before any object of its class is created]
	The keyword void simply tells the compiler that main() does not return a value. 
	In main() there is only one parameter, String args[], which declares a parameter named args. This is an array of objects of type String. Objects of type String store sequences of characters. In this case, args receives any command-line arguments present when the program is executed [Recall 5.4 Pass Arguments to main() of C/C++, the command line argument]. This program does not make use of this " String args[]" information, but other programs will.
	The last character on the line is the {. This signals the start of main()’s body. All of the code included in a method will occur between the method’s opening curly brace and its closing curly brace.
	The next line of code is the statement: 	System.out.println("Java drives the Web.");
	This line outputs the string "Java drives the Web." followed by a new line on the screen. Output is done by the built-in println() method. 
	The line begins with System.out. "System" is a predefined class that provides access to the system, and out is the output stream that is connected to the console.  Thus, System.out is an object that encapsulates console output. 

Note:		All statements in Java end with a semicolon. 
	The Java compiler will compile classes that do not contain a main() method. But, the Java interpreter would report an error because it would be unable to find the main() method.
	In Java there is no " return 0; " statement. Program execution terminates when "}" is reached. The { and } exist only in your program’s source code. Java does not, per se, execute the { or }.

1.2.4 println() and print(): println() outputs the data in the "new line" after each call. The print() method is just like println(), except that it does not output a new line after each call.
	Using the + operator, you can chain together as many items as you want within a single println() statement. Eg:
System.out.println("var1 contains " +x);
In this statement, the plus "+" sign causes the value of x to be displayed after the string that precedes it.
	To print a blank line, simply call println() without any arguments. i.e. 	"println():"


 */
