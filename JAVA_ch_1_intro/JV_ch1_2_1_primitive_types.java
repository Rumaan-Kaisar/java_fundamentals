/* 
    Java contains two general categories of built-in data types:
    object-oriented
    non-objectoriented

    1.  Primitive types:
        i)      Boolean : 1 is for "true" and 0 is for "false"
        ii)     Integer numbers: byte, short, int, long

        iii)    Character: char
        iv)     Floating numbers: double, float

    By default, integer literals are of type "int". To specify a "long" literal, append an "l or an L". For example, 12 is an int, but "12L" is a long.
    By default, floating-point literals are of type "double". To specify a "float" literal, append an "F or f".  Eg:  "10.19F"  is of type float.
    underscores: "123_45_1234" specifies the value "123,451,234". 
        The use of "_" is particularly useful when encoding things like part numbers, customer IDs, and status codes . 

 */

/* 
 literals
    hexadecimal: literal must begin with 0x or 0X (a zero followed by an x or X). Eg: 	hex = 0xFF;  // 255 in decimal
    octal: literal begins with a zero. Eg: 	oct = 011;   // 9 in decimal
    binary: precede the binary number with a 0b or 0B. For example, this specifies the value 12 in binary: 0b1100.

    String literals 
        In Java string is always inside double quotes "". 
        And character constant is inside single quotes ' '. So 'k' and "k" are not the same. 
        'K' is for "character constant" and "K" is for "character string". 
 */

/* 
    Initialization: "type var_name = value ;"  Eg:  int count = 10;  char ch = 'X';  float f = 1.2F; 
    Dynamic Initialization: It is also same for C/C++ local variables. (However global variables do not support dynamic initialization).
        Java allows variables to be initialized dynamically, using any expression valid at the time the variable is declared (i.e. If the expression variables do not go out of the scope. Because local variables destroyed after the function call). For example, 

        double radius = 4, height = 5;  //  these variables must be declared before "volume"
        double volume = 3.1416 * radius * radius * height; // dynamically initialize volume
 */


/* 
Scope In Java:
    #   endregionScopes defined by class. We'll discuss this kind later with classes.
    #   Scopes defined by method. For now we focus on 


    Scope defined by methods is mostly similar to C/C++'s local variables scope. The scope defined by a method begins with its opening curly brace. The parameters of the method are also included within the method’s scope.

    1.  Variables declared inside a scope are not visible/accessible to code that is defined outside that scope.

    2.  Scopes can be nested.

    3.  Within a block, variables can be declared at any point, but are valid only after they are declared.

    4.  Variables are created when their scope is entered, and destroyed (lose its value) when their scope is left.abstract

    5.  variables declared within a method will not hold their values between calls to that method. 
    
    6.  If a variable declaration includes an initializer, that variable will be reinitialized each time the block in which it is declared is entered.

*/

/* nested-Scope restriction: no variable declared within an inner scope can have the same name as a variable declared by an enclosing scope. [In C/C++ there is no restriction]
For example, following tries to declare two separate variables with the same name, will not compile.

        public static void main(String args[]) { 
            int count; 
            for(count = 0; count < 10; count ++) {
                System.out.println("This is count: " + count); 
                int count; 	// illegal!!! 
                for(count = 0; count < 2; count++) System.out.println("Gives error!");      
            }    
        } 
*/

// Before: 1.14





public class JV_ch1_2_1_primitive_types{
    public static void main(String[] args) {

        long var3;
        var3 = 45L;
        double ver4 = 67;
        float ver5 = 56F;

        System.out.print("Long int value "+var3+"\n");
        // You can use the getClass() method to get the type of the object you are using, 
        // For primitive type we use "Boxing": "(Object)var3" converts 'primitive types' into 'object types'
        System.out.print("Type of ver3"+((Object)var3).getClass().getName()+"\n");
        System.out.print("Type of ver4"+((Object)var4).getClass().getName()+"\n");
        System.out.print("Type of ver5"+((Object)var5).getClass().getName()+"\n");


        // String and char: 
        String s1="hello"; 
        char ch1='a';
        System.out.println("Type of s1: "+((Object)s1).getClass().getName());
        // Following works too: because String is already an Object type, so need to Object-boxing 
        // System.out.print("Type of s1: "+s1.getClass().getName()+"\n");
        System.out.println("Type of ch1: "+((Object)ch1).getClass().getName());


        int var1; // this declares a variable
        int var2; // this declares another variable
        var1 = 1024; // this assigns 1024 to var1
        System.out.print("var1 contains " + var1+"\n");
        var2 = var1 / 2;
        System.out.print("var2 contains var1 / 2: ");
        System.out.println(var2);
        // The print() method is just like println(), except that it does not output a new line after each call. 
        // Both print() and println() can be used to output values of any of Java’s built-in types.


        // division on integers
        int var; // this declares an int variable
        double x; // this declares a floating-point variable
        var = 10; // assign var the value 10
        x = 10.0; // assign x the value 10.0
        System.out.println("Original value of var: " + var);
        System.out.println("Original value of x: " + x);

        System.out.println(); // print a blank line

        // now, divide both by 4
        var = var / 4;
        x = x / 4;
        System.out.println("var after division (Notice fraction is lost): " + var);
        System.out.println("x after division: " + x);


        // Gallon to liters
        double gallons; // holds the number of gallons
        gallons = 10; // start with 10 gallons
        double liters = gallons * 3.7854; // Dynamic variable declaration, convert to liters
        System.out.println(gallons + " gallons is " + liters + " liters.");


        // Octal, Hexa decimal, Binary
        /* Convert int to String: 
            Using toString() method of "Integer" class
            Using valueOf() method of "String" class 
        */
        int octl = 016;
        // Octal is coverted to Decimal "by using radix:10" during data-type-conversion to String
        String octStr = Integer.toString(octl, 10); 
        System.out.println("Converted num: "+octStr);   // gives 14 in decimal: equivalent to 16 in octal 
        System.out.println("Type of octStr: "+octStr.getClass().getName()+"\n");
        // The Integer.parseInt() method converts a string to an int with the given radix
        int hexd = Integer.parseInt(octStr, 16);    // gives 20 in decimal: equivalent to 14 in Hexadecimal
        // preceeding line takes the String value as a Hexadecimal number and converts it to Decimal
        // parseInt(octStr, 16)  consideres the number-string octStr in Hexadecimal
        System.out.println("Converted dec num to hexd: "+hexd);

        int hex2 = 0x20;
        String hexStr = Integer.toString(hex2, 10); 
        System.out.println("Converted num: "+hexStr);   // gives 32 in decimal: equivalent to 20 in Hexadecimal
        // String hexStr = Integer.toString(hex2, 16); // remains same; Hexadecimal to Hexadecimal 
    }
}


/* Java Octal to Decimal conversion: Integer.parseInt()
The Integer.parseInt() method converts a string to an int with the given radix. If you pass 8 as a 'radix', it converts an 'octal' string into 'decimal'. 
 */