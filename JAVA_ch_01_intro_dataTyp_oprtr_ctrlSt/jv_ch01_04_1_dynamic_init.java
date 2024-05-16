
/*  -=-=-=-=-=-=-=-=-=-=-=      variable initialization      -=-=-=-=-=-=-=-=-=-=-= 

    Initialization is same as C/C++: 	

                type var_name = value;  
        Eg:     
            int count = 10;  
            char ch = 'X';  
            float f = 1.2F; 



    --------  Multiple variable initialization  --------
    Using a comma-separated list, you can give "one or more same type variables" an initial value. 

    For example:     
                    int a, b = 8, c = 19, d;

                    In this case, only b and c are initialized.



    --------  Dynamic Initialization  --------
    It is also same as C/C++ local variables.

    However global variables do not support dynamic initialization.


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

