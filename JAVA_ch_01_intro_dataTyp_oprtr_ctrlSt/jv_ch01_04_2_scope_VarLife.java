
/* -=-=-=-=-=-=-=-=-=-=-=      scope and life of a variable      -=-=-=-=-=-=-=-=-=-=-= */

Does a block define a scope?


/* 
Scope In Java:
    #   endregionScopes defined by class. We'll discuss this kind later with classes.
    #   Scopes defined by method. For now we focus on 


    Scope defined by methods is mostly similar to C/C++'s local variables scope. The scope defined by a method begins with its opening curly brace. The parameters of the method are also included within the method’s scope.

    1.  Variables declared inside a scope are not visible/accessible to code that is defined outside that scope.

    2.  Scopes can be nested.

    3.  Within a block, variables can be declared at any point, but are valid only after they are declared.

    4.  Variables are created when their scope is entered, and destroyed (lose its value) when their scope is left.abstract

    5.  variables declared within a method will not hold their values between calls to that method. 
    
    6.  If a variable declaration includes an initializer, that variable will be reinitialized each time the block in which it is declared is entered.

*/

/* nested-Scope restriction: no variable declared within an inner scope can have the same name as a variable declared by an enclosing scope. [In C/C++ there is no restriction]
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




// Before: 1.14

/* 
 


1.13 Scope and Lifetime of Variables
A block (block of codes) is begun with "{" and ended by "}". A block defines a scope. A new scope is created during creation of new block.
	A scope determines what objects are visible to other parts of your program. It also determines the lifetime of those objects.
	C/C++ defines two general categories of scopes: global and local. Although supported by Java, these are not the best ways to categorize Java’s scopes. In Java:
[1]	Scopes defined by class. We'll discuss this kind later with classes.
[2]	Scopes defined by method. For now we focus on 
	Scope defined by methods is mostly similar to C/C++'s local variables scope. The scope defined by a method begins with its opening curly brace. The parameters of the method are also included within the method’s scope.
	Variables declared inside a scope are not visible/accessible to code that is defined outside that scope. Thus, when you declare a variable within a scope, you are localizing that variable and protecting it from unauthorized access and/or modification. 
	Scopes can be nested. For example, each time you create a block of code, you are creating a new, nested scope. When this occurs, the outer scope encloses the inner scope. Objects of outer scope will be accessible to inner scope. However, the reverse is not true. Objects declared within the inner scope will not be visible outside it. Eg: consider the following program (similar to C/C++):

class ScopeDemo {	
public static void main(String args[]) { int x; 			// known to all code within main
x = 10;
if(x == 10) {  int y = 20; 	// y is known only to if block
        System.out.println("x and y: " + x + " " + y); 	// x and y both accessible
        x = y * 2; }
y = 100; 			// Won't run, returns an error. y is unknown here
System.out.println("x is " + x);        }	    }	// x is still accessible
	Within a block, variables can be declared at any point, but are valid only after they are declared. Thus, if you define a variable at the start of a method, it is available to all of the code within that method. Conversely, if you declare a variable at the end of a block, it is effectively useless, because no code will have access to it.
	Variables are created when their scope is entered, and destroyed (lose its value) when their scope is left [Recall C/C++ 3.2]. Thus, the lifetime of a variable is confined to its scope. Therefore, variables declared within a method will not hold their values between calls to that method. If a variable declaration includes an initializer, that variable will be reinitialized each time the block in which it is declared is entered. Example:
class VarInitDemo {
public static void main(String args[]) {  int x;
	for(x = 0; x < 3; x++) { int y = -1; // y is initialized each time block is entered 
			System.out.println("y is: " + y); // this always prints -1 
			y = 100; 
	System.out.println("y is now: " + y);   }	  }    }	output : 	y is: -1
		y is now: 100
		y is: -1
		y is now: 100
		y is: -1
		y is now: 100
	C/C++ Exception: Although blocks can be nested, no variable declared within an inner scope can have the same name as a variable declared by an enclosing scope. For example, following tries to declare two separate variables with the same name, will not compile.
public static void main(String args[]) { int count; 
for(count = 0; count < 10; count ++) { System.out.println("This is count: " + count); 
						int count; 	// illegal!!! 
for(count = 0; count < 2; count++) System.out.println("Gives error!");      
}    }
In C/C++ there is no restriction on the names that you give variables declared in an inner scope. Thus, in C/C++ the declaration of count within the block of the outer for loop is completely valid, and such a declaration hides the outer variable. 




 */
