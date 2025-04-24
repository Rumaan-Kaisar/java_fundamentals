
// 115.9-124.7

/* -=-=-=-=-=-=-=-=-=-=-=      methods with parameters      -=-=-=-=-=-=-=-=-=-=-= 
    parameters and arguments:
        A value passed to a method is called an "argument". 
        Inside the method, the variable that receives the argument is called a "parameter".
        parameter declaration syntax is the same as that used for variables.

        Example: 
                    devide(int x, int y)
            
            here x and y are parameters but in    devide(2, 3)    2 and 3 are arguments.


    Scope of parameters:
        A parameter is within the scope of its method,
        aside from its special task of receiving an argument, it acts like any other local variable.

    A method can have more than one parameter       devide(int x, int y)


    multiple parameters:
        When a method has multiple parameters, each parameter specifies its own type, which can differ from the others. 
        For example, this is perfectly valid:

                    int myMeth(int a, double b, float c){  }

*/


// ----  rev [24-Apr-2025]  ----

/* Example 1: Here is a simple example that uses a parameter. Inside the ChkNum class, 
                the method isEven() returns true if the value that it is passed is even. 
                It returns false otherwise. 
                
                Therefore, isEven() has a return type of "boolean"
*/

// NOTE: In C/C++, functions can exist outside of classes, while in Java, methods must be inside a class.
class ChkNum {
    // return true if x is even
    boolean isEven(int x) {
        if((x%2) == 0) return true;
        else return false;
    }
}

class ParmDemo{
    public static void main(String args[]) {
        ChkNum e = new ChkNum();    // creating a class of ChkNum to use the method isEven() encapsulated in it
if(e.isEven(10)) System.out.println("10 is even.");
if(e.isEven(9)) System.out.println("9 is even.");
if(e.isEven(8)) System.out.println("8 is even.");
}
}







// ------------   add below to previous :: jv_ch02_03_1_methods_return.java    ------------

// In Java, to create a method, it must be inside a class. 
// It's not necessary for a class to always have member variables; it can just contain methods only

// The purpose of the following RetInt class is only to define the IntRand() method. In Java, methods must be inside a class, but in C++, we can define a function directly without a class.

// In Java, to create a method, it must be inside a class. 
// A class can have one or more methods, like this:

class RetInt {
    // This method will return a random integer
    int IntRand() {
        return (int)(Math.random() * 100); // returns a random integer between 0 and 99
    }
}

class MethDemo {
    public static void main(String args[]) {
        // Create an object of RetInt to use the IntRand() method
        RetInt makeint = new RetInt();
        
        // Call the IntRand() method and display the returned value
        System.out.println("A random integer: " + makeint.IntRand());
    }
}














Here is the output produced by the program:
10 is even.
8 is even.
In the program, isEven( ) is called three times, and each time a different value is passed.
Let’s look at this process closely. First, notice how isEven( ) is called. The argument is specified
between the parentheses. When isEven( ) is called the first time, it is passed the value 10. Thus,
when isEven( ) begins executing, the parameter x receives the value 10. In the second call, 9 is
the argument, and x, then, has the value 9. In the third call, the argument is 8, which is the value
that x receives. The point is that the value passed as an argument when isEven( ) is called is the
value received by its parameter, x.


/* Example 2: A method can have more than one parameter. Simply declare each parameter, separating
one from the next with a comma. For example, the Factor class defines a method called
isFactor( ) that determines whether the first parameter is a factor of the second. */
class Factor {
boolean isFactor(int a, int b) {
if( (b % a) == 0) return true;
else return false;
Here, x is an integer parameter of isEven( ).
Pass arguments
to isEven( ).
This method has two parameters.Chapter 4: Introducing Classes, Objects, and Methods 117
}
}
class IsFact {
public static void main(String args[]) {
Factor x = new Factor();
if(x.isFactor(2, 20)) System.out.println("2 is factor");
if(x.isFactor(3, 20)) System.out.println("this won't be displayed");
}
}
Notice that when isFactor( ) is called, the arguments are also separated by commas.
When using multiple parameters, each parameter specifies its own type, which can differ
from the others. For example, this is perfectly valid:
int myMeth(int a, double b, float c) {
// ...


