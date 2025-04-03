
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
    Classes contain instance variables (data) and methods (functions).
    The "Vehicle" class previously had only data, but most classes also have methods.
    
    Methods manipulate class data and provide access to it.
    Other parts of the program interact with a class mainly through its methods.

    The general form of a Java method is:

            ret_type name(parameter_list){
                // body of method 
            }

        The "ret_type" is the return type of the function. 
        If the function returns no value then the ret_type must be void.

        In java Methods are written with parentheses "()", e.g., getval(), to differentiate them from variables.
            Parentheses indicate that the identifier is a callable method.

        parameter_list is a list of input values (can be empty if no parameters are needed).
            Parameters receive values passed when calling the method. 
            If no parameters are required, the list remains empty.
    
        method naming Restrictions:
            Each method has a name used to call it.
            Cannot use Java keywords as method names.
            main() is reserved for program execution.


    Note:
        In C/C++ we can define a function "inside" of a class or "outside" of a class. 
        We used the scope resolution operator (::) to define a function outside of class. 
        But in Java it is un-common. In Java methods are usually defined inside a class. 

        So it is un-common to use the scope resolution operator (::) to define a method outside of its class.  




    --------  Returning  --------

    Returning from a Method: 
        there are two conditions that "cause" a method to return (i.e. stops execution and goes back to the calling code)


    [1]     If a method reaches its closing curly brace '}', it automatically returns to the caller.
                This applies to methods with a void return type since they do not return a value.
                Eg:
                        void showMessage() { 
                            System.out.println("Hello!");
                        } // Method ends here, returns automatically



    [2]     Second, when a "return statement" is executed. 
                A "return statement" explicitly ends the method and sends control back to the caller.
                If a method has a "return type" (e.g. int, double), the return statement "must return a value of that type".
                Eg:
                        int square(int num) {
                            return num * num;  // Method returns when this line executes
                        }

                    Notice "num" is "int" type so the method square()'s' retrun type is "int".


                Even in void methods, return; can be used to exit the method early:

                        void checkNumber(int num) {
                            if(num < 0) return;    // Method exits if num is negative
                            System.out.println("Number is positive.");
                        }


    Forms of Return :
        There are two forms of return:

            [a]     void methods (those that do not return a value). The form is:
                            return;

            [b]     methods which return values. The form is,
                            return value;

            Second form of return can be used only with methods that have a "non-void return type" (e.g., int, double)
                and that non-void method must use the "return value;" statement to send a result back to the caller.

            Example of The second form "return value;": 	

                        int range() { 
                            return x*y; 
                        }. 

            The "return type" of a method defines the "type of data" it returns.
                The returned value must match the method’s declared "return type".
                Example: 
                    range() has a return type of int. i.e. it will return an integer value to the caller. 
                
                If you want a method to return data of type double, its return type must be type double. 
                Example:
                        double devide(int x, int y) { 
                            return (double)(x /y); 
                        }

                Type Cast: Here a type cast is used to return "double value" from int values (which are int parameters of the method)



    Avoid Too Many Return Statements
        A method can have multiple return statements, 
            but using too many exit points (i.e. return statements) can destructure code.
            and make it difficult to debug.

        A well-structured method should have clear and minimal exit points 
            for better readability and maintainability.

*/


// consider the "Vehicle Class" examples in jv_ch02_01_class_in_Java.java


Adding a Method to the Vehicle Class
As just explained, the methods of a class typically manipulate and provide access to the data of
the class. 


With this in mind, recall that main( ) in the preceding examples computed the range of
a vehicle by multiplying its fuel consumption rate by its fuel capacity. While technically correct,Chapter 4: Introducing Classes, Objects, and Methods 111
this is not the best way to handle this computation. The calculation of a vehicle’s range is
something that is best handled by the Vehicle class itself. The reason for this conclusion is easy
to understand: the range of a vehicle is dependent upon the capacity of the fuel tank and the
rate of fuel consumption, and both of these quantities are encapsulated by Vehicle. By adding
a method to Vehicle that computes the range, you are enhancing its object-oriented structure.
To add a method to Vehicle, specify it within Vehicle’s declaration. For example, the following
version of Vehicle contains a method called range( ) that displays the range of the vehicle.


// Add range to Vehicle.
class Vehicle {
int passengers; // number of passengers
int fuelcap; // fuel capacity in gallons
int mpg; // fuel consumption in miles per gallon
// Display the range.
void range() {  // The range( ) method is contained within the Vehicle class.
System.out.println("Range is " + fuelcap * mpg);    // Notice that fuelcap and mpg are used directly, without the dot operator.
}
}
class AddMeth {
public static void main(String args[]) {
Vehicle minivan = new Vehicle();
Vehicle sportscar = new Vehicle();
int range1, range2;
// assign values to fields in minivan
minivan.passengers = 7;
minivan.fuelcap = 16;
minivan.mpg = 21;
// assign values to fields in sportscar
sportscar.passengers = 2;
sportscar.fuelcap = 14;
sportscar.mpg = 12;
System.out.print("Minivan can carry " + minivan.passengers +
". ");
minivan.range(); // display range of minivan
System.out.print("Sportscar can carry " + sportscar.passengers +
". ");
sportscar.range(); // display range of sportscar.
}
}






This program generates the following output:
Minivan can carry 7. Range is 336
Sportscar can carry 2. Range is 168



Let’s look at the key elements of this program, beginning with the range( ) method itself.
The first line of range( ) is
void range() {
This line declares a method called range that has no parameters. Its return type is void. Thus,
range( ) does not return a value to the caller. The line ends with the opening curly brace of the
method body.


The body of range( ) consists solely of this line:
System.out.println("Range is " + fuelcap * mpg);
This statement displays the range of the vehicle by multiplying fuelcap by mpg. Since each
object of type Vehicle has its own copy of fuelcap and mpg, when range( ) is called, the range
computation uses the calling object’s copies of those variables.
The range( ) method ends when its closing curly brace is encountered. This causes
program control to transfer back to the caller.
Next, look closely at this line of code from inside main( ):
minivan.range();
This statement invokes the range( ) method on minivan. That is, it calls range( ) relative to
the minivan object, using the object’s name followed by the dot operator. When a method is
called, program control is transferred to the method. When the method terminates, control is
transferred back to the caller, and execution resumes with the line of code following the call.
In this case, the call to minivan.range( ) displays the range of the vehicle defined by minivan.
In similar fashion, the call to sportscar.range( ) displays the range of the vehicle defined by
sportscar. Each time range( ) is invoked, it displays the range for the specified object.
There is something very important to notice inside the range( ) method: the instance
variables fuelcap and mpg are referred to directly, without preceding them with an object name
or the dot operator. When a method uses an instance variable that is defined by its class, it does
so directly, without explicit reference to an object and without use of the dot operator. This is
easy to understand if you think about it. A method is always invoked relative to some object of
its class. Once this invocation has occurred, the object is known. Thus, within a method, there is
no need to specify the object a second time. This means that fuelcap and mpg inside range( )
implicitly refer to the copies of those variables found in the object that invokes range( ).
Returning from a Method
In general, there are two conditions that cause a method to return—first, as the range( ) method
in the preceding example shows, when the method’s closing curly brace is encountered. The
second is when a return statement is executed. There are two forms of return—one for use inChapter 4: Introducing Classes, Objects, and Methods 113
void methods (those that do not return a value) and one for returning values. The first form is
examined here. The next section explains how to return values.
In a void method, you can cause the immediate termination of a method by using this form
of return:
return ;
When this statement executes, program control returns to the caller, skipping any remaining
code in the method. For example, consider this method:
void myMeth() {
int i;
for(i=0; i<10; i++) {
if(i == 5) return; // stop at 5
System.out.println();
}
}
Here, the for loop will only run from 0 to 5, because once i equals 5, the method returns. It is
permissible to have multiple return statements in a method, especially when there are two or
more routes out of it. For example:
void myMeth() {
// ...
if(done) return;
// ...
if(error) return;
// ...
}
Here, the method returns if it is done or if an error occurs. Be careful, however, because
having too many exit points in a method can destructure your code; so avoid using them
casually. A well-designed method has well-defined exit points.
To review: A void method can return in one of two ways—its closing curly brace is
reached, or a return statement is executed.
Returning a Value
Although methods with a return type of void are not rare, most methods will return a value.
In fact, the ability to return a value is one of the most useful features of a method. You have
already seen one example of a return value: when we used the sqrt( ) function to obtain a
square root.
Return values are used for a variety of purposes in programming. In some cases, such as
with sqrt( ), the return value contains the outcome of some calculation. In other cases, the
return value may simply indicate success or failure. In still others, it may contain a status code.
Whatever the purpose, using method return values is an integral part of Java programming.114 Java: A Beginner’s Guide
Methods return a value to the calling routine using this form of return:
return value;
Here, value is the value returned. This form of return can be used only with methods that have
a non-void return type. Furthermore, a non-void method must return a value by using this form
of return.
You can use a return value to improve the implementation of range( ). Instead of displaying
the range, a better approach is to have range( ) compute the range and return this value. Among
the advantages to this approach is that you can use the value for other calculations. The following
example modifies range( ) to return the range rather than displaying it.
// Use a return value.
class Vehicle {
int passengers; // number of passengers
int fuelcap; // fuel capacity in gallons
int mpg; // fuel consumption in miles per gallon
// Return the range.
int range() {
return mpg * fuelcap;
}
}
class RetMeth {
public static void main(String args[]) {
Vehicle minivan = new Vehicle();
Vehicle sportscar = new Vehicle();
int range1, range2;
// assign values to fields in minivan
minivan.passengers = 7;
minivan.fuelcap = 16;
minivan.mpg = 21;
// assign values to fields in sportscar
sportscar.passengers = 2;
sportscar.fuelcap = 14;
sportscar.mpg = 12;
// get the ranges
range1 = minivan.range();
range2 = sportscar.range();
Return the range for a given vehicle.
Assign the value
returned to a variable.Chapter 4: Introducing Classes, Objects, and Methods 115
System.out.println("Minivan can carry " + minivan.passengers +
" with range of " + range1 + " Miles");
System.out.println("Sportscar can carry " + sportscar.passengers +
" with range of " + range2 + " miles");
}
}
The output is shown here:
Minivan can carry 7 with range of 336 Miles
Sportscar can carry 2 with range of 168 miles
In the program, notice that when range( ) is called, it is put on the right side of an assignment
statement. On the left is a variable that will receive the value returned by range( ). Thus, after
range1 = minivan.range();
executes, the range of the minivan object is stored in range1.
Notice that range( ) now has a return type of int. This means that it will return an integer
value to the caller. The return type of a method is important because the type of data returned
by a method must be compatible with the return type specified by the method. Thus, if you
want a method to return data of type double, its return type must be type double.
Although the preceding program is correct, it is not written as efficiently as it could be.
Specifically, there is no need for the range1 or range2 variables. A call to range( ) can be
used in the println( ) statement directly, as shown here:
System.out.println("Minivan can carry " + minivan.passengers +
" with range of " + minivan.range() + " Miles");
In this case, when println( ) is executed, minivan.range( ) is called automatically and its value
will be passed to println( ). Furthermore, you can use a call to range( ) whenever the range of a
Vehicle object is needed. For example, this statement compares the ranges of two vehicles:
if(v1.range() > v2.range()) System.out.println("v1 has greater range");






