
// 110.3-115.9

/* -=-=-=-=-=-=-=-=-=-=-=      Methods and returning from methods      -=-=-=-=-=-=-=-=-=-=-= 

    ------    Methods in Java vs C++ functions    ------
    "Methods in Java" are similar to "functions in C/C++", but there are key differences:

    Similarities:
        Both encapsulate reusable code that performs a specific task.
        Both can take parameters and return values.
        Both follow a similar syntax:

                // C++ Function
                int add(int a, int b) {
                    return a + b;
                }


                // Java Method (inside a class)
                int add(int a, int b) {
                    return a + b;
                }

        while "methods" and "functions" serve the same purpose, Java's methods are tightly integrated into its object-oriented design.

    Differences:
        Java enforces OOP principles, making methods an integral part of objects and classes.
        Java methods use "reference-based" memory management, while C/C++ functions can use both "references" and "pointers".
        
        Belongs To:
            In C/C++, functions can exist outside of classes, while in Java, methods must be inside a class.

        Call Format:
            Java Methods: Called using an object (obj.method(), unless static).
            C/C++ Functions: Called directly (function()).

        Static Keyword:
            Java Methods: static methods belong to the class itself.
            C/C++ Functions: No static keyword for functions (except for internal linkage).

        Encapsulation:
            Java Methods: Part of Object-Oriented Programming (OOP).
            C/C++ Functions: Procedural (unless inside a class).

        Main Function:
            Java Methods: public static void main(String[] args).
            C/C++ Functions: int main().



            
    ----------------    Methods in Java    ----------------

    The general form of a Java method is:

            ret_type name(parameter_list){
                // body of method 
            }

        The "ret_type" is the return type of the function. 
        If the function returns no value then the ret_type must be void.


    Note:
        In C/C++ we can define a function "inside" of a class or "outside" of a class. 
        We used the scope resolution operator (::) to define a function outside of class. 
        But in Java it is un-common. In Java methods are usually defined inside a class. 

        So it is un-common to use the scope resolution operator (::) to define a method outside of its class.  




    ----  Returning  ----

    Returning from a Method: 
        there are two conditions that "cause" a method to return (i.e. stops execution and goes back to the calling code)

        [1]     If a method reaches its closing curly brace '}', it automatically returns to the caller.
                    This applies to methods with a void return type since they do not return a value.
                    Eg:
                            void showMessage() { 
                                System.out.println("Hello!");
                            } // Method ends here, returns automatically

        [2]     Second, when a return statement is executed. 




--------------  rev[27-Mar-2025]  -------------------

When Does a Method Return in Java?


Encountering the Closing Curly Brace (})


Executing a return Statement

A return statement explicitly ends the method and sends control back to the caller.

If the method has a return type (e.g., int, double), return must return a value of that type.

Example:

java
Copy
Edit
int square(int num) {
    return num * num;  // Method returns when this line executes
}
Even in void methods, return; can be used to exit the method early:

java
Copy
Edit
void checkNumber(int num) {
    if (num < 0) return; // Method exits if num is negative
    System.out.println("Number is positive.");
}
In summary, a method always returns when it reaches } or executes a return statement.

---------------------------------




    Return :
        There are two forms of return:

            [a]     void methods (those that do not return a value). The form is:
                            return;

            [b]     methods which return values. The form is,
                            return value;




                            
	Second form of return can be used only with methods that have a non-void return type. Furthermore, a non-void method must return a value by using this "return value;" form of return. Example of The second form " return value;": 	
int range() { return x * y; }. 
	Notice that range() has a return type of int. i.e. it will return an integer value to the caller. The return type of a method is important because the type of data returned by a method must be compatible with the return type specified by the method. Thus, if you want a method to return data of type double, its return type must be type double. Eg:
double devide(int x, int y) { return (double) (x /y); }
Here a type cast is used to return "double value" from int values (which are int parameters of the method)
	It is permissible to have multiple return statements in a method, however, because having too many exit points (i.e. return statements) in a method can destructure code. A well-designed method has well-defined exit points.









Summary of Java Methods
Methods and Instance Variables: Methods and instance variables are part of a class. While a class can contain only data, most classes include methods to manipulate and access that data.

Role of Methods: Methods serve as subroutines that interact with a class's data. Other parts of a program typically access class data through its methods.

Naming and Structure:

Each method has a name used to call it.

The main() method is reserved for program execution.

Java keywords cannot be used as method names.

Method Notation: Methods are written with parentheses, e.g., getval(), to differentiate them from variables.

General Method Form:

java
Copy
Edit
ret-type name(parameter-list) {
    // body of method
}
ret-type: The return type of the method (can be any valid type, including class types).

name: A unique identifier for the method.

parameter-list: A list of input values (can be empty if no parameters are needed).

Method Parameters: Parameters receive values passed when calling the method. If no parameters are required, the list remains empty.




------GPT------
Methods in Java Classes (Simplified & Pointwise)
Instance Variables & Methods:

Classes contain instance variables (data) and methods (functions).
The Vehicle class previously had only data, but most classes also have methods.
Purpose of Methods:

Methods manipulate class data and provide access to it.
Other parts of the program interact with a class mainly through its methods.
Structure of Methods:

A method is a subroutine that contains one or more statements.
Well-written methods perform a single task for clarity and efficiency.
Method Naming Rules:

A method has a name, used to call it.
Restrictions:
Cannot use Java keywords as method names.
main() is reserved for program execution.
Convention: Method names are written with parentheses (getval()) in text for clarity.
General Form of a Method:

java
Copy
Edit
returnType methodName(parameter-list) {  
    // method body  
}
returnType: Type of data the method returns (use void if no value is returned).
methodName: Any valid identifier not conflicting with other names in the scope.
parameter-list: Variables that receive values passed to the method. (Empty if no parameters).
*/


