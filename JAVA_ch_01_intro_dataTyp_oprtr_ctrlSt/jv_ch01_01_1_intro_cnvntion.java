
/* -=-=-=-=-=-=-=-=-=-=-=      Intro to JAVA      -=-=-=-=-=-=-=-=-=-=-= 
                
    --------    Java doesn't support "pointers" :(    --------
    The pointer feature of C++ can access "resource outside of program" itself and it can break security. 
    For this reason Java doesn't support pointer. 



    History of Java:
        Java is similar to C and C++ but it is a platform-independent language.
        Java is a cross-platform language that could produce code that would run on a variety of CPUs under differing environments.  

        So we can create Platform-Independent (i.e. Portable) programs. 

        Most computer languages were designed to be compiled for a specific target. For example, consider C++. 
        Although it was possible to compile a C++ program for just about any type of CPU, 
            to do so required a full C++ compiler targeted for that CPU. 
            The problem, however, is that compilers are expensive and time-consuming to create.




    Java is Related to C and C++: 
        Java inherits its syntax from C.
        Its object model is adapted from C++. 

        You can think of Java as simply the “Internet version of C++.” 
        Although Java was influenced by C++, it is not an enhanced version of C++, it is neither upwardly nor downwardly compatible with C++.  

        Java was not designed to replace C++.




    --------    applet, bytecode and JVM    --------
    Applet: 
        a kinda networked program called the applet. 
        An applet is a special kind of Java program that is designed to be 'transmitted over the Internet' and 
        automatically executed by a Java-compatible web browser. 
        
        The applet is a 'dynamic', 'self-executing' program. 
        
        Such a program is an 'active agent' on the client computer,
            it is INITIATED by the SERVER.

            If the user 'clicks' a link that contains an 'applet', the applet will be 'automatically downloaded' and run in the browser. 

        They are typically used to 'display data' provided by the server, handle 'user input', 
        or provide simple functions, such as a 'loan calculator', that execute locally, rather than on the server. 


    servlet: 
        A servlet is a small program that EXECUTES on a SERVER. 
            Just as applets dynamically extend the functionality of a web browser, 
            servlets dynamically extend the functionality of a web server.

            [There are two very broad categories of objects that are transmitted between the 'server' and the client: 
                passive information and 
                dynamic, active programs. 
                
                For example, when you read your e-mail, you are viewing 'passive data'. 
                    Even when you download a program, the "program’s code" is still only 'passive data' until you execute it. ]

        

    ----  The "bytecode"  and "JVM"  ---- 
        However, networked programs present serious problems in the areas of security and portability.      
        Java achieved 'protection' by confining an 'applet' to the "Java execution environment" and not allowing it access to other parts of the computer. 

    Bytecode and JVM: 
        The output of a Java compiler is not executable code (not an .exe file). 
        Rather, it is bytecode. 
        
        Bytecode is a 'highly optimized set of instructions' designed to be executed by 
            the Java run-time system, which is called the Java Virtual Machine (JVM). 
        
        In essence, the original JVM was designed as an "interpreter" for "BYTECODE". 


        Reason to be "interpretive" :  
            many modern languages are designed to be 'compiled into executable code' because they runs faster than interpreter. 
            However, the fact that a Java program is executed by the JVM helps solve the major problems associated with web-based programs. 

            Portability: 
                Translating a Java program into bytecode makes it much easier to run a program in a wide variety of environments
                Note: Although the details of the JVM will differ from platform to platform, all understand the same Java bytecode. 

            Security : 
                Since the JVM is in control, it can contain the program and prevent it from generating side effects outside of the system. 

            Bytecode makes Java run faster : 
                When a program is INTERPRETED, it generally runs slower than the same program would run if compiled to EXECUTABLE CODE. 
                However, with Java, the differential between the two is not so great. 
                    Because bytecode has been highly optimized, the use of bytecode enables the JVM to execute programs much faster than you might expect.

        JIT: 
            Java can compile of bytecode into 'native code' (machine code of the User's machine ) in order to boost performance. 
            It can be achieved by using  just-in-time (JIT) COMPILER for bytecode. 
            When a JIT compiler is part of the JVM, selected portions of bytecode are compiled into EXECUTABLE CODE in real time on a piece-by-piece, demand basis. 

            JIT "PARTIALLY COMPILE" a Java program (into several executable files), 
                because Java performs various run-time checks that can be done only at run time. 
                So it is not practical to compile an entire Java program into executable code all at once. 

                A JIT compiler compiles code as it is needed, during execution. 
                Furthermore, not all sequences of bytecode are compiled — only those that will benefit from compilation. The remaining code is simply interpreted. 

*/





/*

    --------    Variable Declarations:    --------
    Variable declaration is same as C/C++ :

            type var_name;  
    
        A 'variable' is a "named memory location" that can be assigned a value.
            Further, the value of a variable can be changed during the execution of a program




    --------    Data-types     --------
           
    int, float and double are available for numerical type data. 

    Note: Why int, float, double for numerical data type? Why not only one data type?
        Because int is faster than float, double. 
        Also int require less memory. 
        
        So separating int and float/double makes program fast and efficient. 




    --------    Operator Basic    --------

    All operators rules for 

        + 
        - 
        * 
        / 

    including "=" are same as C/C++. 

    Relational operators are also same 

        <
        >
        <=  
        >=  
        ==  
        != 


*/




/* --------    Naming Conventions in Java    --------

    Identifiers:
        In Java an 'identifier' is a "name" given to a method, a variable, or any other user-defined item.

        Identifiers can be from one to several characters long. 
        
        Variable names may start with any letter of the alphabet, an underscore '_', or a dollar sign '$'. 
            Do not start with digits

            Next characters may be either a letter, a digit,  an underscore '_', or a dollar sign '$'. 
                The underscore can be used to 'enhance the readability' of a variable name, as in line_count. 
            
            Uppercase and lowercase are different; that is, to Java, 'myvar' and 'MyVar' are separate names. 
            
        Eg: Here are some examples of acceptable identifiers:
            Test 
            x 
            y2 
            MaxLoad
            $up 
            _top 
            my_var 
            sample23



    RESTRICTIONS            
        You cannot start an identifier with a 'digit'. Thus, 12x is invalid, for example.
        You cannot use any of the 'Java keywords' as identifier names. 
        You should not use the name of any standard method, such as println, as an identifier. 



    -=-=-=-    naming conventions    -=-=-=-

    Your identifier names should reflect the meaning or usage of the items being named. 
        i.e. all variables, class, method names should be meaningful, descriptive

    Java constants:  
        capitalized 'SNAKE_CASE'         
            static final int MAX_WIDTH = 999;


    Java methods & Variables:  
        'camelCase'      
            getBackground();
    

    Java Class & interfaces:
        'PascalCase'
            class ImageSprite;
            interface RasterDelegate;
        
        some programmers like to distinguish interfaces by beginning the name with an "I":
            interface IComparable; 
            interface IEnumerable;

            
    Java Package:
        all lowercase


*/


// --------    identifier naming    --------
// snake_case
// camelCase
// PascalCase




/* Example 1: Check youur Java-version. */
public class JV_ch1_0_1_javaVersion{
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.runtime.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.vendor"));
        System.out.println(System.getProperty("java.vendor.url"));
        System.out.println(System.getProperty("java.class.path"));   
    }
}




/* Example 2. What is "BYTECODE" and why is it important to Java’s use for Internet programming? 

                Bytecode is a highly optimized 'set of instructions' that is executed by the Java Virtual Machine 'JVM'.
                Bytecode helps Java achieve both portability and security.
*/




/* Example 3. What are the three main principles of object-oriented programming? 

                Encapsulation, 
                Polymorphism, and 
                Inheritance
*/

