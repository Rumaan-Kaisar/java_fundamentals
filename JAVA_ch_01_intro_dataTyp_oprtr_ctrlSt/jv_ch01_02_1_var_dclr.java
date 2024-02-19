

// --------    rev[19-2-24]    --------
/*  -=-=-=-=-=-=-=-=-=-=-=      variable declaration      -=-=-=-=-=-=-=-=-=-=-= 
    In Java, all variables must be declared before they are used
    the type of values (i.e. int, float, double) that the variable can hold must also be specified

    In general, to declare a variable you will use a statement like this:
    type var_name;

    type specifies the type of variable
    var_name is the name of the
    variable

assign value to variable:

*/


/* Example 3: A 'variable' is a "named memory location" that can be assigned a value.
                The following program creates two variables called var1 and var2: 

                Notice: 
                    int data type used
                    division operation


*/

class var_int {
    public static void main(String args[]) {
        int var1; // this declares an int variable
        int var2; // this declares another int variable

        var1 = 1024; // this assigns 1024 to var1
        System.out.println("var1 contains " + var1);
        var2 = var1 / 2;    // division operation
        System.out.print("var2 contains var1 / 2: ");
        System.out.println(var2);
    }
}


