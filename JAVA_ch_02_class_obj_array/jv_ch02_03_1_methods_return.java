
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

                Note: A void method can return in two ways: 
                    When its closing curly brace is reached,  or
                    When a "return;" statement is executed.


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
        A method can have multiple return statements, especially when there are two or more routes out of it.
            Eg:
                    void myMeth(){
                        // ...
                        if(done) return;
                        // ...
                        if(error) return;
                        // ...
                    }
            but using too many exit points (i.e. return statements) can destructure code.
            and make it difficult to debug.

        A well-structured method should have clear and minimal exit points 
            for better readability and maintainability.
*/




/* Example 1: Consider the "Vehicle Class" examples in jv_ch02_01_class_in_Java.java
                The methods of a class typically manipulate and provide access to the data of the class.

                In earlier examples, the main() method calculated a vehicle’s range (fuel capacity × mileage).

                But it's better to let the Vehicle class do this itself, 
                    Since the range of a vehicle is dependent upon the 
                        capacity of the fuel tank i.e. "fuelcap" and the rate of fuel consumption i.e. "mpg"
                        and both of these quantities (variables) are encapsulated by Vehicle. 

                By adding a range() method inside the class, the calculation becomes part of the object’s behavior, 
                    making the code more object-oriented.

                To add the method, define it inside the class declaration.
*/

// Add range to Vehicle.
class Vehicle {
    int passengers; // number of passengers
    int fuelcap; // fuel capacity in gallons
    int mpg; // fuel consumption in miles per gallon

    // Display the range: The range() method is contained within the Vehicle class.
    void range() {  
        // Notice that fuelcap and mpg are used directly, without the dot operator.
        System.out.println("Range is " + fuelcap*mpg);
    }
}

class AddMeth {
    public static void main(String args[]) {
        Vehicle minivan = new Vehicle();
        Vehicle sportscar = new Vehicle();

        // assign values to fields in minivan
        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        // assign values to fields in sportscar
        sportscar.passengers = 2;
        sportscar.fuelcap = 14;
        sportscar.mpg = 12;

        System.out.print("Minivan can carry " + minivan.passengers + ". ");
        minivan.range();    // display range of minivan

        System.out.print("Sportscar can carry " + sportscar.passengers + ". ");
        sportscar.range();  // display range of sportscar
    }
}


/*  ----  Key Points from Example 1  ----

    Method Declaration: 
        "void range()":

        () means no parameters and 
        void means it does not return any value to the caller


    It prints the range:
        System.out.println("Range is " + fuelcap * mpg);

        it uses "fuelcap" and "mpg" which are instance variables.
        Each object of type Vehicle has its own copy of fuelcap and mpg.
        so range() uses the calling object's copies of those variables


    Calling the Method:
        minivan.range();

        Called using an object: invokes the range() method on minivan
        Control goes to the method, and returns after it finishes.


    No Need for Object Name Inside Method:
        Inside range(), we can directly use "fuelcap" and "mpg" without "this" or "object name" or the dot operator
        That's because the method already knows which object it belongs to when called.
        (i.e. without explicit reference to an object and without use of the dot operator)
        Because a method is always invoked relative to some object of its class.
        It implicitly refer to the copies of those variables found in the object that invokes range().


    Object-Specific Output:
        If range() is called on minivan, it shows minivan's range.
        If called on sportscar, it shows sportscar’s range.
*/




/* Example 2: Following code use return in void Methods:
                In void methods, you can use "return;" to exit the method early.

                When this "return;" statement executes
                    It immediately stops the method and returns control to the caller.
                    Any code after return; is skipped. 
*/

// Here, the for loop will only run from 0 to 5, because once i equals 5, the method returns.
void myMeth(){
    int i;
    
    for(i=0; i<10; i++){
        if(i == 5) return; // stop at 5
        System.out.println();
    }
}




/* Example 3: Improving the "range()" Method Using a Return Value:
                Instead of printing the range inside the range() method, it's better to return the value.
                The returned value can be used in other calculations or printed elsewhere.
*/

class Vehicle {
    int passengers; // number of passengers
    int fuelcap; // fuel capacity in gallons
    int mpg; // fuel consumption in miles per gallon
    
    // Return the range.
    int range(){
        return mpg*fuelcap;
    }
}


class RetMeth {
    public static void main(String args[]){
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

        // Use a return value to get the range and assign them
        range1 = minivan.range();
        range2 = sportscar.range();

        System.out.println("Minivan can carry " + minivan.passengers + " with range of " + range1 + " Miles");
        System.out.println("Sportscar can carry " + sportscar.passengers + " with range of " + range2 + " miles");
    }
}


/*  ----  Key Points from Example 3  ----

    Assigning Return Value to Variable:
        You can call a method like range() on the right-hand side of an assignment.
        Example: 
                range1 = minivan.range(); 
        
            stores the returned value into range1.


    Return Type Must Match:
        If a method returns a value, its "return type" must match the "type of value" it returns.
        Example: 
            If returning an int, the method must be declared with int as the return type.
            If you want to return a double, use double as the return type.


    Direct call of a method:
        You don't always need a variable to store the returned value.
        You can use the method call directly in expressions:

            System.out.println("Minivan can carry " + minivan.passengers + " with range of " + minivan.range() + " Miles");

        Furthermore, you can use a call to range() whenever the range of a Vehicle object is needed.
            EG: method calls used in logical expressions:

            if(v1.range() > v2.range()) System.out.println("v1 has greater range");
*/
