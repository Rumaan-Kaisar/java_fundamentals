
/*  -=-=-=-=-=-=-=-=-=-=-=      variable initialization      -=-=-=-=-=-=-=-=-=-=-= 

    Initialization is same as C/C++: 	

                type var_name = value;  
        Eg:     
            int count = 10;  
            char ch = 'X';  
            float f = 1.2F; 


    The capabilities of a variable are determined by its type. 
        eg: a variable of type boolean cannot be used to store floating-point values. 

    The type of a variable cannot change during its lifetime. 
        eg: an int variable cannot turn into a char variable

    All variables in Java must be declared prior to their use.



    --------  Multiple variable initialization  --------
    Using a comma-separated list, you can give "one or more same type variables" an initial value. 

    For example:     
                    int a, b = 8, c = 19, d;

                    In this case, only b and c are initialized.



    --------  Dynamic Initialization  --------
    Dynamic initialization refers to the process of 
        initializing variables at "RUNTIME", rather than at "COMPILE-time", 
        using expressions, method calls, or user input. 
    
    This allows for greater flexibility as: 
        the exact values assigned to variables can be determined during the EXECUTION 
        of the program based on conditions or inputs that are only known at runtime.

    However global variables do not support dynamic initialization.

    C++ also allows dynamic initialization of variables. 
        In C++, dynamic initialization refers to the process of initializing variables at runtime, similar to Java.


    Java allows variables to be initialized dynamically, 
        using any expression valid at the time the variable is declared 
        (   i.e. If the expression variables do not go out of the scope. 
            Because local variables destroyed after the function call   )
        
        For example, 

            //  these variables must be declared before "volume"
            double radius = 4, height = 5;

            // dynamically initialize "volume"
            double volume = 3.1416 * radius * radius * height;

*/



/* Example 1: here is a short program that computes the volume of a cylinder 
                given the radius of its base and its height. 
                
                Notice the dynamic initialization:
                    The first two, "radius" and "height", are initialized by constants.

                    However, "volume" is initialized dynamically to the volume of the cylinder.

                    The key point here is that the initialization expression can use any element valid at
                        the time of the initialization, including calls to methods, other variables, or literals
*/

// Demonstrate dynamic initialization.
class DynInit {
    public static void main(String args[]) {
        double radius = 4, height = 5;

        // dynamically initialize volume
        double volume = 3.1416 * radius * radius * height;
        System.out.println("Volume is " + volume);
    }
}




