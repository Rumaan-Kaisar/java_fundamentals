
/*  -=-=-=-=-=-=-=-=-=-=-=      variable declaration      -=-=-=-=-=-=-=-=-=-=-= 
    In Java, all variables must be declared before they are used
        the data-type of values (i.e. int, float, double) that the variable can hold must also be specified

    In general, to declare a variable you will use a statement like this:

                    type var_name;

    'type' specifies the type of variable
    'var_name' is the name of the variable


    assign value to variable:
        use assignmnet operator '=', following line of code assigns var1 the value 1024
                    var1 = 1024;


    '+' to Chain togather:
        following outputs the value of var1 preceded by the string "var1 contains ":
        the plus sign '+' causes the value of var1 to be displayed after the string that precedes it

                    System.out.println("var1 contains " + var1);


    aritmetic expression:
        Following divides the value in 'var1' by 2 and then stores that result in 'var2'

                    var2 = var1 / 2;
*/




/* Example 1: A 'variable' is a "named memory location" that can be assigned a value.
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




/* Example 2: This program illustrates the differences  between 'int' and 'double'.
                Java defines two floating-point types: float and double, 
                    which represent single- and double-precision values, respectively. 
                    Of the two, 'double' is the most "commonly used"

                Notice: 
                    when 'var' is divided by 4, a "whole-number division" is performed, and 
                        Fractional component lost: the outcome is 2
                    when x is divided by 4, the fractional component is preserved 
                    print a blank line, by calling println() without any arguments.
*/
class Example3 {
    public static void main(String args[]) {
        int var; // declares an int 
        double x; // declares a floating-point variable

        var = 10; // assign value
        x = 10.0; // assign value

        System.out.println("Original value of var: " + var);
        System.out.println("Original value of x: " + x);
        System.out.println(); // print a blank line
        
        // now, divide both by 4
        var = var/4;    // Fractional component lost
        x = x/4;

        System.out.println("var after division: " + var);
        System.out.println("x after division: " + x);
    }
}




/*  Example 3: "Converting Gallons to Liters"
                The program will work by declaring two double variables. 
                    One will hold the number of the gallons, and the second will hold the number of liters after the conversion. 
                There are 3.7854 liters in a gallon. Thus, to convert gallons to liters, the gallon value is multiplied by 3.7854.
                The program displays both the number of 'gallons' and the equivalent number of 'liters'. 
*/

// Try This 1_1: This program converts gallons to liters. Call this program GalToLit.java.

class GalToLit {
    public static void main(String args[]) {
        double gallons; // holds the number of gallons
        double liters; // holds conversion to liters
    
        gallons = 10;   // start with 10 gallons
        liters = gallons * 3.7854;  // convert to liters
        System.out.println(gallons + " gallons is " + liters + " liters.");
    }
}

// Compile the program using the following command line:
javac GalToLit.java

// Run the program using this command:
java GalToLit

