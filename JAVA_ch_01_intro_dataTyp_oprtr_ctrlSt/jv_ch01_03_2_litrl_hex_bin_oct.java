
/* -=-=-=-=-=-=-=-=-=-=-=      Hexadecimal, Octal, and Binary literals      -=-=-=-=-=-=-=-=-=-=-= 

    ----------------    literals    ----------------
    literals:
        fixed values that are represented in their human-readable form
        Java literals can be of any of the primitive data types. 
        The way each literal is represented depends upon its type
        
        For example, 
            'a' and ' %' are both character constants.
            10 and –100 are integer literals.
            11.123 is a floating-point literal.

        Literal specifier:
                By default, integer literals are of type "int". 
                    int can be assigned to variables of type 'char', 'byte', or 'short' 
                        as long as the value being assigned can be represented by the target type.

                long: 
                    To specify a long literal, append an 'l' or an 'L'. 
                    For example, 12 is an "int", but 12L is a "long".
                    An integer literal can always be assigned to a long variable.

                float:
                    By default, floating-point literals are of type 'double'. 
                    To specify a float literal, append an 'F' or 'f'.  
                    Eg:  "10.19F"  is of type 'float'.


    '_' into an integer or floatingpoint literal:
        When the literal is compiled, the underscores are simply discarded. 
        Here is an example: 123_45_1234 
*/



/*  --------------- Hexadecimal, Octal, and Binary literals ----------------
    Hexadecimal:
        A hexadecimal literal must begin with 0x or 0X (a zero followed by an x or X).
        int hex = 0xFF;     // 255 in decimal


    Octal:
        An octal literal begins with a zero.
        int oct = 011;      // 9 in decimal


    Binary:
        precede the binary number with a 0b or 0B.
        For example, following specifies the value 12 in binary:
        int binr = 0b1100;


    int undScrTest = 123_45_1234;
    System.out.println("undScrTest is " + undScrTest);

*/




/* Example 1: Following demonstrates the Hexadecimal, Octal, and Binary literals  
                Notice, System.out.println() prints those in "deciaml"
*/
 
public class LiteralDemo{
    public static void main(String[] args) {        
            // --------------- Hexadecimal, Octal, and Binary literals ----------------
            int hex = 0xFF; // 255 in decimal
            System.out.println("hex is " + hex);

            int oct = 011; // 9 in decimal
            System.out.println("oct is " + oct);

            // specify an integer literal by use of binary: precede the binary number with a 0b or 0B.
            //  For example, this specifies the value 12 in binary:

            int binr = 0b1100;
            System.out.println("binr is " + binr);

            int undScrTest = 123_45_1234;
            System.out.println("undScrTest is " + undScrTest);
    }
}




// ----    rev[25-Apr-24]    ----

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


