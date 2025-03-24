// 110.3-115.9
/* -=-=-=-=-=-=-=-=-=-=-=      Methods and returning from methods      -=-=-=-=-=-=-=-=-=-=-= 

    Methods in Java Classes:


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



// ----  rev[24-Mar-2025]  ----











As explained, instance variables and methods are constituents of classes. So far, the Vehicle
class contains data, but no methods. Although data-only classes are perfectly valid, most
classes will have methods. Methods are subroutines that manipulate the data defined by
the class and, in many cases, provide access to that data. In most cases, other parts of your
program will interact with a class through its methods.
A method contains one or more statements. In well-written Java code, each method
performs only one task. Each method has a name, and it is this name that is used to call the
method. In general, you can give a method whatever name you please. However, remember
that main( ) is reserved for the method that begins execution of your program. Also, don’t use
Java’s keywords for method names.
When denoting methods in text, this book has used and will continue to use a convention that
has become common when writing about Java. A method will have parentheses after its name.
For example, if a method’s name is getval, it will be written getval( ) when its name is used in a
sentence. This notation will help you distinguish variable names from method names in this book.
The general form of a method is shown here:
ret-type name( parameter-list ) {
// body of method
}
Here, ret-type specifies the type of data returned by the method. This can be any valid type,
including class types that you create. If the method does not return a value, its return type
must be void. The name of the method is specified by name. This can be any legal identifier
other than those already used by other items within the current scope. The parameter-list is a
sequence of type and identifier pairs separated by commas. Parameters are essentially variables
that receive the value of the arguments passed to the method when it is called. If the method
has no parameters, the parameter list will be empty.


Methods are similar to C/C++'s "functions". The general form of a Java method is:

ret_type name(parameter_list){
    // body of method 
}

The ret-type is the return type of the function. If the function returns no value then the ret-type must be void.
	Note: In C/C++ we can define a function inside of a class or outside of a class. We used the scope resolution operator (::) to define a function outside of class. But in Java it is un-common. In Java methods are usually defined inside a class, so it is un-common to use the scope resolution operator (::) to define a method outside of its class.  


	Returning from a Method: there are two conditions that cause a method to return
[1]	First, when the method’s closing curly brace is encountered. 
[2]	Second, when a return statement is executed. 


	Return : There are two forms of return:
[a]	One for void methods (those that do not return a value). The form is,   	return;
[b]	One for methods which return values. The form is, 	   return value;


	Second form of return can be used only with methods that have a non-void return type. Furthermore, a non-void method must return a value by using this "return value;" form of return. Example of The second form " return value;": 	
int range() { return x * y; }. 
	Notice that range() has a return type of int. i.e. it will return an integer value to the caller. The return type of a method is important because the type of data returned by a method must be compatible with the return type specified by the method. Thus, if you want a method to return data of type double, its return type must be type double. Eg:
double devide(int x, int y) { return (double) (x /y); }
Here a type cast is used to return "double value" from int values (which are int parameters of the method)
	It is permissible to have multiple return statements in a method, however, because having too many exit points (i.e. return statements) in a method can destructure code. A well-designed method has well-defined exit points.



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

