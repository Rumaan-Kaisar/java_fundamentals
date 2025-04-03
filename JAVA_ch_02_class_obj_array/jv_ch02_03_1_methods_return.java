
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


