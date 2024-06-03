
/* -=-=-=-=-=-=-=-=-=-=-=      scope and life of a variable      -=-=-=-=-=-=-=-=-=-=-= 
    Block and scope:
        A block (block of codes) is begun with "{" and ended by "}". 
        A block defines a scope. A new scope is created during creation of new block.

        A scope determines what objects are visible to other parts of your program. 
            It also determines the lifetime of those objects.



    ------------    C/C++ & Java scopes    ------------
    ChatGPT: "What are the difference between variables scopes in C/C++ and in Java?"
        While the general principles of variable scope are similar across C, C++, and Java, there are some key differences due to the specifics of each language.

        -=-=-=-  C++ Variable Scopes  -=-=-=-

        Global Scope (C++): 
            Variables declared outside of any function are global and can be accessed from 
                any function within the same file (or across files if declared as extern in C/C++).
            Eg:
                int globalVar = 10; // Global scope

                void someFunction() {
                    globalVar = 20; // Accessible here
                }

        Local Scope (C++):
            Variables declared within a function are local to that function and 
                can only be accessed within that function.
            Eg:
                void someFunction() {
                    int localVar = 10; // Local scope
                }

        Block Scope (C++):
            Variables declared within a block (e.g., within {}) are scoped to that block.
            Eg:
                void someFunction() {
                    if (true) {
                        int blockVar = 10; // Block scope
                    }
                    // blockVar is not accessible here
                }

        Namespace Scope (C++):
            In C++, variables can also be scoped within namespaces.
            Eg:
                namespace MyNamespace {
                    int namespaceVar = 10;
                }

                void someFunction() {
                    int x = MyNamespace::namespaceVar; // Accessing namespace variable
                }


        -=-=-=-  Java Variable Scopes  -=-=-=-


        
// --------  rev[03-jun-2024]  --------



Class Scope (Instance Variables):

Variables declared within a class but outside any method are called instance variables. 
They are accessible by all methods of the class and have a lifespan that corresponds to the instance of the class.
Example:
java
Copy code
public class MyClass {
    int instanceVar = 10; // Instance variable

    public void someMethod() {
        instanceVar = 20; // Accessible here
    }
}


Static Scope (Class Variables):

Variables declared with the static keyword are class variables. They are shared among all instances of the class and are accessible without creating an instance of the class.
Example:
java
Copy code
public class MyClass {
    static int staticVar = 10; // Class variable

    public static void someMethod() {
        staticVar = 20; // Accessible here
    }
}


Local Scope:

Variables declared within a method are local to that method and can only be accessed within that method.
Example:
java
Copy code
public void someMethod() {
    int localVar = 10; // Local scope
}



Block Scope:

Variables declared within a block (e.g., within {}) are scoped to that block.
Example:
java
Copy code
public void someMethod() {
    if (true) {
        int blockVar = 10; // Block scope
    }
    // blockVar is not accessible here
}


Method Parameters:

Variables declared as parameters in a method signature are local to that method and can only be accessed within that method.
Example:
java
Copy code
public void someMethod(int param) {
    // param is accessible here
}




        -=-=-=-=-    Key Differences between Java vs C++ variable scopes    -=-=-=-=-

Global Variables:

C/C++: Supports global variables that can be accessed from any function in the same file or across files (using extern).
Java: Does not support global variables. Instead, static variables are used at the class level, accessible without creating an instance of the class.
Namespaces:

C++: Uses namespaces to organize code and prevent name collisions.
Java: Uses packages to organize classes and interfaces, providing a different mechanism for organizing code and preventing name collisions.
Static Variables:

C/C++: The static keyword can also limit the scope of a variable to the file in which it is declared (file scope).
Java: The static keyword is used to create class variables shared across all instances of the class.
Block Scope:

C/C++ and Java: Both languages support block scope, but the rules and usage can vary slightly due to differences in language design and usage patterns.
Understanding these differences helps when transitioning between these languages or when trying to apply concepts learned in one language to another.



    C/C++ defines two general categories of scopes: 

                    global 
            and 
                    local 

        Although supported by Java, these are not the best ways to categorize Java’s scopes.
            

    Scope In Java:
        #   Scopes defined by class: 
                We'll discuss this kind later with classes.
        
        #   Scopes defined by method: 
                For now we focus on Scope defined by methods


        Scope defined by methods is mostly similar to C/C++'s local variables scope. 
            It begins with "{"
            The "parameters" of the method are also included within the method’s scope.

        1.  Variables declared inside a scope are not visible/accessible to code that is defined outside that scope.
            i.e. you are localizing that variable and 
                protecting it from unauthorized access and/or modification. 

        2.  Scopes can be nested.

        3.  Within a "block", variables can be declared at any point, but are valid only after they are declared.
                If you define a variable at the start of a method, 
                    it is available to all of the code within that method.
                Conversely, if you declare a variable at the end of a block, 
                    it is effectively useless, because no code will have access to it.
                A variable declared within a block will lose its value when the block is left. 

        4.  Variables are created when their scope is entered, and destroyed (lose its value) when their scope is left

        5.  variables declared within a method will not hold their values between calls to that method. 
        
        6.  If a variable declaration includes an initializer, that variable will be reinitialized each time the block in which it is declared is entered.


    lifetime of a variable:
        The lifetime of a variable is confined to its scope.



    --------    NESTED-Scope    --------
    For example, each time you create a block of code, you are creating a new, nested scope. 

    The outer scope encloses the inner scope. 
    Objects of outer scope will be accessible to inner scope. 
    However, the reverse is not true. Objects declared within the inner scope will not be visible outside it. 

    Note: declaration means:    
                            dataType var_name


    --------    NESTED-Scope restriction    --------
    No variable declared within an inner scope can have the same name as a variable declared by an enclosing scope. 
    [In C/C++ there is no restriction]
    
    For example, following tries to declare two separate variables with the same name, will not compile.


        public static void main(String args[]) { 
            int count; 
            for(count = 0; count < 10; count ++) {
                System.out.println("This is count: " + count); 
                int count; 	// illegal!!! 
                for(count = 0; count < 2; count++) System.out.println("Gives error!");      
            }    
        } 

*/





/* Example 1: consider the following program (similar to C/C++) demonstrate scope */

class ScopeDemo {
    public static void main(String args[]) { 
        int x;              // x's declaration: known to all code within main

        x = 10;
        if(x == 10) {  
            int y = 20;     // y's declaration: y is known only to if block
            System.out.println("x and y: " + x + " " + y);  // x and y both accessible
            x = y * 2; 
        }

        y = 100;            // Won't run, returns an error. y is unknown here
        // y wasn't declared in outer scope
        System.out.println("x is " + x);     // x is still accessible   
    }
}




// --------  rev[30-May-2024]  --------

// Before: 1.14

/* 
 


1.13 Scope and Lifetime of Variables





C/C++ Differs: 
    Although blocks can be nested, no variable declared within an inner scope can have the same name as a variable declared by an enclosing scope. 
    For example, following tries to declare two separate variables with the same name, will not compile.

ChatGPT: "Give an example in C++ that same case won't generate an error"

public static void main(String args[]) { int count; 
for(count = 0; count < 10; count ++) { System.out.println("This is count: " + count); 
						int count; 	// illegal!!! 
for(count = 0; count < 2; count++) System.out.println("Gives error!");      
}    }


In C/C++ there is no restriction on the names that you give variables declared in an inner scope. Thus, in C/C++ the declaration of count within the block of the outer for loop is completely valid, and such a declaration hides the outer variable. 




 */




/* Example 2: If a variable declaration includes an initializer, that variable will be reinitialized each time the block in which it is declared is entered. 
 *    
    
    output : 	y is: -1
		y is now: 100
		y is: -1
		y is now: 100
		y is: -1
		y is now: 100

*/

class VarInitDemo {
public static void main(String args[]) {  int x;
	for(x = 0; x < 3; x++) { int y = -1; // y is initialized each time block is entered 
			System.out.println("y is: " + y); // this always prints -1 
			y = 100; 
	System.out.println("y is now: " + y);   }	  }    }




/* Example 3:  
no variable declared within an inner scope can have the same name as a variable declared by an enclosing scope.
following tries to declare two separate variables with the same name, will not compile*/

public static void main(String args[]) { int count; 
    for(count = 0; count < 10; count ++) { System.out.println("This is count: " + count); 
                            int count; 	// illegal!!! 
    for(count = 0; count < 2; count++) System.out.println("Gives error!");      
    }    }


/* Example 4 (use GPT): demostrate "A variable declared within a block will lose its value when the block is left. " 
        Use only a block i.e. just "{}" i.e. no control-statement, methot or class
*/


