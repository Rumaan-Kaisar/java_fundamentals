
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




/* Example 1:  The First Sample Program Line by Line: 
                This is a simple Java program. Call this file 'Example.java'.
*/

class Example { 	
    // A Java program begins with a call to main().
    public static void main(String args[]){ 
        System.out.println("Java drives the Web.");
    }
}

/*  --------    walkthrough    --------


    Method: 
        In Java any function/subroutine is called "method"
    
    The line : 	class Example {
        uses the keyword 'class' to declare that a new class is being defined. 
        'Example' is the name of the class. 
        The class definition begins with the opening curly brace "{" and ends with the closing curly brace "}". 
            members: The elements between the two braces are members of the class. 
        
        main-class: All program activity occurs within this 'main-class'. 
    
    Next line is a single line comment.
            
    public static void main (String args[]) {
        main() method: This line begins the 'main() method' (function/subroutine called method in Java). 
            This is similar to C/C++'s main() function, and some modifier and specifier are used in addition.  
            
            This is the line at which the program will 'begin executing'. 
            All Java applications begin 'execution' by calling main(). 
        
            Now let's see why the specifiers/modifiers are used :
                public: 
                    is an access modifier defined previously in C/C++. 
                    In this case, main() must be declared as public, 
                        since it must be called by 'code outside of its class' when the program is started. 
        
                static:
                    static allows main() to be called 'before an object of the class
                    This is necessary because main() is called by the JVM before any objects are made. 
                    [Recall C/C++: Static Class Members: A static member variable exists before any object of its class is created]

                void:
                    simply tells the compiler that main() does not return a value. 
                
                String args[]:
                    this only parameter of main() declares a parameter named args. 
                    This is an array of objects of type 'String'. 
                        Objects of type String store sequences of characters. 
                    In this case, 'args' receives any "command-line arguments" present when the program is executed 
                        [Recall Pass Arguments to main() of C/C++, the command line argument]. 
                        This program does not make use of this "String args[]" information, but other programs will.
        
                {:
                    This signals the start of main()’s body. 
                    All of the code included in a method will occur between the method’s opening curly brace and its closing curly brace.



        System.out.println("Java drives the Web.");
            All statements in Java end with a semicolon.    
        
            This line outputs the string "Java drives the Web." followed by a new line on the screen. 
            Output is done by the built-in println() method. 

            System.out:
                "System" is a predefined class that provides access to the 'system', and 'out' is the "output stream" that is connected to the 'console'.  
                Thus, 'System.out' is an object that encapsulates 'console output'. 



    Note:		 
        The Java compiler 'will compile' classes that "do not contain a main()" method. 
        But, the Java 'interpreter' would report an 'error' because it would be unable to find the main() method.



    no 'return 0;'
        In Java there is no " return 0; " statement. 
        Program execution terminates when "}" is reached. 
        
        The { and } exist only in your program’s source code. Java does not, per se, execute the { or }.



    --------    println() and print()    --------
    println():
        println() outputs the data in the "new line" after each call. 
        
        chain using '+':
            Using the + operator, you can chain together as many items as you want within a single println() statement. Eg:
                    System.out.println("var1 contains " +x);
            In this statement, the plus "+" sign causes the value of x to be 'displayed after' the string that precedes it.
        
            To print a blank line, simply call println() without any arguments. i.e. 	"println():"
    
    
    print():    
        print() method is just like println(), except that it does not output a new-line after each call.

*/



/* --------    File naming    --------
        By conversion, the "name of the main class" should match the "name of the source-file". 
            Same name helps us to maintain and organize the codes easily.
            The 'main-class' name and the 'source-file name' must maintain the CAPITALIZATION, because Java is case sensitive. 
*/



/* --------    Handling Syntax Errors    --------
    When your program contains a syntax error, you shouldn’t necessarily take the compiler's messages at face value. 
        The messages may be misleading. 
        You may need to “second-guess” an error message in order to find the real problem. 
        
        Also, look at the 'last few lines' of code in your program that 'precede the line being flagged'. 
            Sometimes an error will not be reported until 'several lines after' the point at which the error actually occurred. 
*/




/* Example 1: Where do Java programs begin execution? 

                Java programs begin execution at main()
*/




/* Example 2: If you make a typing mistake when entering your program, what sort of error will result? 
                
                A syntax error.
*/




/* Example 3: Does it matter where on a line you put a statement? 

                No, Java is a free-form language 
*/




/*  ------------    String[] args conventions!!    ------------
    In Java, both "String[] args" and "String args[]" are syntactically correct (position of [] is different) 
    both are valid ways to declare an "array parameter" in the main method. 



    --------  Preferred Convention  --------
    "String[] args" is generally recommended because it clearly indicates that 
        the type of the variable is a "String array". 

    This aligns with Java's general practice of placing the brackets [] next to the "type" rather than the "variable name".



    --------  Alternative Syntax  --------
    "String args[]" is more preferable fopr the programmers with a background in C/C++ 
    This syntax is more common in C and C++, the array notation [] is typically placed next to the "variable name"
*/


// Example 4: Both syntax are correct:

public class MainMethodExample {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}



public class MainMethodExample {
    public static void main(String args[]) {
        System.out.println("Hello, World!");
    }
}

