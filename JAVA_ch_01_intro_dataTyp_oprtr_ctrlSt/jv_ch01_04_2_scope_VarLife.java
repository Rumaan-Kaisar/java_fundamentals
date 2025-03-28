
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

        Class Scope (JAVA Instance Variables):
            Variables declared within a class but "outside any method" are called "instance variables". 
                are accessible to all methods of the class and 
                have a lifespan that corresponds to the instance of the class.
            Eg:
                public class MyClass {
                    int instanceVar = 10; // Instance variable

                    public void someMethod() {
                        instanceVar = 20; // Accessible here
                    }
                }


        Static Scope (JAVA Class Variables):
            Variables declared with the static keyword are class variables. 
            They are shared among all instances of the class and 
                are accessible without creating an instance of the class.
            Eg:
                public class MyClass {
                    static int staticVar = 10; // Class variable

                    public static void someMethod() {
                        staticVar = 20; // Accessible here
                    }
                }


        Local Scope (JAVA):
            Variables declared within a method are local to that method and 
                can only be accessed within that method.
            Eg:
                public void someMethod() {
                    int localVar = 10; // Local scope
                }


        Block Scope (JAVA):
            Variables declared within a block (e.g., within {}) are scoped to that block.
            Eg:
                public void someMethod() {
                    if (true) {
                        int blockVar = 10; // Block scope
                    }
                    // blockVar is not accessible here
                }


        Method Parameters (JAVA):
            Variables declared as parameters in a method signature are 
                local to that method and can only be accessed within that method.
            Eg:
                public void someMethod(int param) {
                    // param is accessible here
                }



        -=-=-=-=-    Key Differences between Java vs C++ variable scopes    -=-=-=-=-

        Global Variables:
            C/C++: 
                Supports global variables that can be accessed from any function 
                    in the same file or across files (using extern).
            Java: 
                No global variables. 
                Instead, static variables are used at the class level, accessible without creating an instance of the class.


        Namespaces:
            C++: 
                Uses "namespaces" to organize code and prevent "name collisions".
            Java: 
                Uses "packages" to organize classes and interfaces, 
                    providing a different mechanism for organizing code and preventing name collisions.


        Static Variables:
            C/C++: 
                static can be used in "file scope"
                The static keyword can also "limit the scope of a variable to the file" in which it is declared (file scope).
            Java: 
                The static keyword is used to create "class variables" shared across all instances of the class.


        Block Scope:
            C/C++ and Java: Both languages support block scope, 
            but the rules and usage can vary slightly due to differences in language design and usage patterns.
            




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




/*  --------    variable naming in nested-scope    --------
    C/C++ Differs: 
        Although blocks can be nested in Java, 
            no variable declared within an inner scope can have the same name as a variable declared by an enclosing scope. 
        
        In C/C++ however, there is no restriction on the names that you give variables declared in an inner scope. 
            Thus, in C/C++ the declaration of "count" within the block of the "outer for loop" is completely valid, 
            and such a declaration hides the outer variable. 
*/


/* Example 2: following tries to declare two separate variables with the same name, will not compile. */

class NameCollision{
    public static void main(String args[]) { 
        int count; 
        
        for(count = 0; count < 10; count++) { 
            System.out.println("This is count: " + count); 
            int count; 	// illegal!!! ERROR: variable count is already defined in method main(String[])
            // notice "count" is used in following FOR-loop as loop-controller, thus "count" is in nested-scope
            for(count = 0; count < 2; count++) System.out.println("Gives error!");      
        }    
    }
}





/* Example 3:  ChatGPT: "Give an example in C++ that same case won't generate an error" 

                Explanation:
                    Outer count: The variable count is declared outside the outer for loop.
                    Inner count: Inside the inner scope (within the block), 
                                    another variable named count is declared. This hides the outer count.

                        This code will compile and run without any errors in C++. 
                        The inner count is completely separate from the outer count.

                    In each iteration of the outer loop, the inner loop will run twice, printing its own count variable, which is independent of the outer loop's count.

                Contrast with Java:
                    In Java, this same code would result in a compilation error because 
                        Java does not allow a variable declared in an inner scope 
                        to have the same name as a variable declared in an outer scope. 
*/

// C++ version will compile !!
#include <iostream>

int main() {
    int count;

    // Outer for loop with 'count'
    for(count = 0; count < 10; count++) {
        std::cout << "This is count in the outer loop: " << count << std::endl;

        // Inner scope
        {
            int count;  // This declaration hides the outer 'count'
            for (count = 0; count < 2; count++) {
                std::cout << "This is count in the inner loop: " << count << std::endl;
            }
        }
    }

    return 0;
}




/* Example 4: If a variable declaration includes an "initializer", 
                that variable will be re-initialized each time the block in which it is declared is entered. 
*/

class VarInitDemo {
    public static void main( String args[] ) {
        int x;
	
        for(x = 0; x < 3; x++) { 
            int y = -1; // y is initialized each time block is entered 
			System.out.println("y is: " + y); // this always prints -1 
			y = 100; 
	        System.out.println("y is now: " + y);   
        }	  
    }    
}

/*  output : 	
        y is: -1
		y is now: 100
		y is: -1
		y is now: 100
		y is: -1
		y is now: 100
*/




/* Example 5: No variable declared within an inner scope can have the same name as a variable declared by an enclosing scope.
                Following  attempts to declare a variable in an inner scope with the same name as one defined in an outer scope.

                *** This program will not compile. ***
*/

class NestVar {
    public static void main(String args[]) {
        int count;
    
        for(count = 0; count < 10; count = count+1) {
            System.out.println("This is count: " + count);
            int count; // illegal!!!
            for(count = 0; count < 2; count++) System.out.println("This program is in error!");
        }
    }
}

/*  However, in C/C++ the declaration of "count" within the block of the outer for loop is completely valid, 
        and such a declaration "HIDES" the outer variable. 
    
        The designers of Java felt that this "name hiding" could easily lead to programming errors and disallowed it. 
*/





/*  --------    Independent Blocks    --------
    Can a block in C++ or Java be created using only "{}", i.e., without being part of a class, function, or control statement?
    
        Yes. In both C++ and Java, you can create a block using {} independently, 
            without it being alongside a class, function, or control statement. 

    This creates a "BLOCK SCOPE", allowing you to define variables that are "local to that block".


    ----  Purpose of Independent Blocks  ----
    The main purpose of creating such independent blocks is to "limit the scope of variables". This can help in:

    Memory Management: 
        Variables go out of scope and can be destroyed as soon as the block is exited, freeing up resources.

    Avoiding Name Conflicts/Collision: 
        Using blocks to limit variable scope can help prevent name conflicts with variables in other parts of the code.

    Code Organization: 
        Blocks can be used to "logically group related code" and variables, 
            making the code more readable and maintainable.

        These blocks can be particularly useful in complex functions where 
            limiting the scope of variables helps "avoid errors" and "improve clarity".
*/



/* Example 6 (use GPT): demostrate "A variable declared within a block will lose its value when the block is left. " 
        Use only a block i.e. just "{}" i.e. no control-statement, methot or class
*/

// In Java, you can create an independent block like this:

public class BlockScopeExample {
    public static void main(String[] args) {
        {
            int blockVar = 10;
            System.out.println("blockVar: " + blockVar);
        }
        // blockVar is not accessible here
    // System.out.println("Outside block: blockVar = " + blockVar); // This would cause a compile-time error
    }
}

   


/* Example 7 (C++): In this example, blockVar is defined within an independent block scope inside the main function. 
                Outside the {} block, blockVar is not accessible. 
*/

// C++: In C++, you can create an independent block as follows:
#include <iostream>

int main() {
    {
        int blockVar = 10;
        std::cout << "blockVar: " << blockVar << std::endl;
    }
    // blockVar is not accessible here
    return 0;
}




/*  Example 8: Does a block define a scope?

            ans:
                Yes
*/




/*  Example 9: What is wrong with this fragment?


                    for(i=0; i<10; i++) {
                        int sum;
                        sum = sum + i;
                    }
                    System.out.println("Sum is: " + sum);

                    
            ans:
                There are two fundamental flaws in the fragment. 

                First, 
                    "sum" is created each time the block defined by the for loop is entered and destroyed on exit.
                    Thus, it will not hold its value between iterations. 
                        Attempting to use sum to hold a "running sum of the iterations" is pointless. 

                Second, 
                    sum will not be known outside of the block in which it is declared.
                    Thus, the reference to it in the println() statement is "invalid".
*/




/* Example 10: Is the following fragment valid?

                    for(int i = 0; i < num; i++)
                    sum += i;
                    count = i;

                ans:
                    No; i is not known outside of the for loop in which it is declared.
*/

