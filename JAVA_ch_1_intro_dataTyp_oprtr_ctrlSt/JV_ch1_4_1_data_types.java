
/* 
 
    boolean(not precise, 1-bit)    true/false values
    byte(8-bit)         8-bit integer   
    char(16-bit)        Character: Java use "unicode", ASCII(8-bit) is subset of unicode
    double(64-bit)      Double-precision floating point
    float(32-bit)       Single-precision floating point
    int(32-bit)         Integer
    long(64-bit)        Long integer
    short(16-bit)       integer         
 */

public class JV_ch1_4_1_data_types{
    public static void main(String[] args) {

        // --------------- int ----------------
        /* int : Compute the number of cubic inches in 1 cubic mile. */
        long ci;
        long im;
        im = 5280 * 12;
        ci = im * im * im;
        System.out.println("There are " + ci + " cubic inches in cubic mile.");


        // --------------- float ----------------
        /* 
        float: Use the Pythagorean theorem to
        find the length of the hypotenuse
        given the lengths of the two opposing sides.
        */
        double x, y, z;
            x = 3;
            y = 4;
            z = Math.sqrt(x*x + y*y);
            System.out.println("Hypotenuse is " +z);


        // --------------- char ----------------
        // char: A character variable can be assigned a value by enclosing the character in single quotes.
        // Character variables can be handled like integers.
        char ch;
        ch = 'X';
        System.out.println("ch contains " + ch);
        ch++; // increment ch
        System.out.println("ch is now " + ch);
        ch = 90; // give ch the value Z
        System.out.println("ch is now " + ch);


        // --------------- boolean ----------------
        // Demonstrate boolean values.
        boolean b;
        b = false;
        System.out.println("b is " + b);

        b = true;
        System.out.println("b is " + b);

        // a boolean value can control the if statement
        if(b) System.out.println("This is executed.");
        b = false;
        if(b) System.out.println("This is not executed.");
        // outcome of a relational operator is a boolean value
        System.out.println("10 > 9 is " + (10 > 9));




        // --------------- literals ----------------
        // literals refer to fixed values that are represented in their human-readable form
        // Java literals can be of any of the primitive data types. The way each literal is represented depends upon its type
        /*      
                For example, 'a' and ' %' are both character constants.

                10 and –100 are integer literals.
                11.123 is a floating-point literal.

                specify a long literal, append an l or an L. For example, 12 is an int, but 12L is a long.
                An integer literal can always be assigned to a long variable.
                specify a float literal, append an F or f to the constant. For example, 10.19F is of type float.

                Although integer literals create an int value by default, they can still be assigned to variables
                of type char, byte, or short as long as the value being assigned can be represented by the target type. 



                underscores into an integer or floatingpoint literal:
                When the literal is compiled, the underscores are simply discarded. Here is an example:
                123_45_1234 
        */

        
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


            // --------------- character literals : single quote ----------------
            char ch_dmo = 'b'; 
            System.out.println("ch_dmo is " + ch_dmo);

            
            // --------------- string literals : single quote ----------------
            // A string is a set of characters enclosed by double quotes. For example, "this is a test"
            String str;
            str = "First line\nSecond line";
            System.out.println(str);
            System.out.println("A\tB\tC");
            System.out.println("D\tE\tF");
    }
}




