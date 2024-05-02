
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




/*  ------------    Java "Octal to Decimal" conversion: Integer.parseInt()    ------------
    Integer.parseInt() used to parse (convert) a string representation of an integer 
        into its corresponding integer value. 
    
    This method is part of the "Integer" class, 
        which is a "wrapper class" for the primitive data type "int".

    String to int:
        The Integer.parseInt() method converts a string to an int with the given "radix" 
            (radix refers to the base of the numeral system). 
        
            If you pass 8 as a 'radix', it converts an "octal string" into 'decimal'. 

        The method signature with radix looks like this:

                public static int parseInt(String s, int radix) throws NumberFormatException

        Example:
            String binaryString = "1010";
            int decimalValue = Integer.parseInt(binaryString, 2); // Parse binary string to decimal (base 10)
            System.out.println(decimalValue); // Output: 10
                
    [method signature: the concept of a "method signature" in Java is similar to that of a "function prototype" in C++.]
*/




/* Example 2: Below is a Java program that demonstrates parsing a binary string 
                to a decimal value using the Integer.parseInt() method 
*/

public class BinaryToDecimal {
    public static void main(String[] args) {
        // Binary string representation
        String binaryString = "1010";
        
        // Parse binary string to decimal (base 10)
        int decimalValue = Integer.parseInt(binaryString, 2);
        // here "radix: 2" means: treat the string "1010" as a binary integer
        // If we use "radix: 8" (a radix of 8), then the string "1010" will be treated as an OCTAL integer.
        
        // Output the decimal value
        System.out.println(decimalValue); // Output: 10
    }
}



