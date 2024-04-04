
/*  -=-=-=-=-=-=-=-=-=-=-=      PRIMITIVE Types and LITERALS      -=-=-=-=-=-=-=-=-=-=-= 

    Built-in DATA TYPES:
        Java contains two general categories of built-in data types:

                object-oriented
                non-objectoriented


    PRIMITIVE types:
        i)      Boolean : 1 is for "true" and 0 is for "false"
        ii)     Integer numbers: byte, short, int, long
        iii)    Character: char
        iv)     Floating numbers: double, float

        There are 8 PRIMITIVE-TYPES of data, which are shown in the Table.
            These are also called 'elemental' or "simple".
        
                    boolean     1 bit (true), 0 bit (false)
                    byte        8 bit
                    short       16 bit
                    int         32 bit
                    long        64 bit
                    char        16 bit
                    double      32 bit
                    float       64 bit

        The term PRIMITIVE is used to indicate that these types are "not objects" in an Object-Oriented sense,
            PRIMITIVE means normal "BINARY values". 


    Literals / constants:
        Eg: 100 is a literal.

        
    Literal specifier:
        By default, integer literals are of type "int". 

        long: 
            To specify a long literal, append an 'l' or an 'L'. 
            For example, 12 is an "int", but 12L is a "long".

        float:
            By default, floating-point literals are of type 'double'. 
            To specify a float literal, append an 'F' or 'f'.  
            Eg:  "10.19F"  is of type 'float'.



    int to char / byte / short:
        'int' can be assigned to variables of type char, byte, or short 
            as long as the 'value being assigned' can be represented by the target type (i.e. char / byte / short).

        An integer literal can always be assigned to a long variable.



    Underscore '_' Embedding:
        In JDK 7, you can embed one or more underscores into an integer or floating-point literal. 
        Doing so can "make it easier to read" values consisting of many digits. 
        When the literal is compiled, the underscores are simply 'DISCARDED'. 

        The use of "_" is particularly useful when encoding things like: 
            part numbers, customer IDs, and status codes .

        Here is an example: 123_45_1234 specifies the value 123,451,234. 



    character constant:
        A character variable can be assigned as value by enclosing the character in single quotes '' 
            which makes the character act like a constant 
        Eg: 	
            char ch; 
            ch='b';


            
    Using standard classes:        
        standard classes of Java they are all like header files of C++.  
        To access a member-functions of Math class (i.e. a method ) we use the "." operator as we did for println(). 
        
        Eg: to access sqrt():
            Math.sqrt(x*x + y*y)



    Notes:
        Size of Boolean data type "boolean" is 1 bit long. 1 is for "true" and 0 is for "false". 
            However, the actual size of a boolean variable in memory is not precisely defined, by java specification.

        double is the most commonly used because all of the "MATH functions" in Java’s class library use double values.
            For example, the sqrt() method returns a 'double'

        JAVA vs C++:
            In Java 'long' is 64 bit and in C/C++ "long int" is 32 bit. 
            Also there is no unsigned (+ve only) in Java.
            Characters in Java is actually 'int' type, also it can be used for integer data types. 
            In Java, "char" is  not 8-bit like C/C++. 
                Instead, Java uses "Unicode". therefore "16-bit" is used for char.
                In Java, char is an unsigned 16-bit type having a range of 0 to 65,536. 
                The standard 8-bit ASCII character set is a subset of Unicode and also available in Java.

*/



// ------------    Java's Primitive Types    ------------

/*
    boolean (not precise, 1-bit)         true/false values

    double    (64-bit)                   Double-precision floating point
    float     (32-bit)                   Single-precision floating point
 
    char      (16-bit)                   Character: Java use "unicode", ASCII(8-bit) is subset of unicode

    byte      (8-bit)                    8-bit integer  
    int       (32-bit)                   Integer
    long      (64-bit)                   Long integer
    short     (16-bit)                   integer         


    Java defines "four integer types": byte, short, int, and long, 

        byte      8      –128    to    127
        short     16     –32,768    to    32,767
        int       32     –2,147,483,648    to    2,147,483,647
        long      64     –9,223,372,036,854,775,808    to    9,223,372,036,854,775,807


    Itegral types:
        char can also be categorized as an integer type in Java.
        However, char type is treated separately.

        Java defines a "type category" called INTEGRAL TYPES, it includes: byte, short, int, long, and char. 
            Because they all hold whole-number, binary values. 

        However, the purpose of the first four is to represent "numeric integer quantities". 
        The purpose of "char" is to represent "characters".

        i.e. the principal uses of char and the other integral types are fundamentally different. 
            That's why the char type is treated separately
*/




/* Example 1: When you need an integer that has a range greater than int, use long. 
                For example, here is a program that computes the "number of cubic inches" 
                contained in a cube of one cubic-mile. 

                Hint: 1 mile = 5280 feet; 1 feet = 12 inches
*/

// Compute the number of cubic inches in 1 cubic mile.
class InchesOneCubicMile {
    public static void main(String args[]) {
        long cubicInch;
        long inchMile;

        inchMile = 5280 * 12;   // 1 mile = 5280 feet; 1 feet = 12 inches
        cubicInch = inchMile * inchMile * inchMile;

        System.out.println("There are " + cubicInch + " cubic inches in a cubic mile.");
    }
}

// Output:
// There are 254358061056000 cubic inches in cubic mile.




/* Example 2: Use the Pythagorean theorem to find the length of the hypotenuse
                given the lengths of the two opposing sides.

                Note that, sqrt() is a member of the standard Math class. 
                Notice how sqrt() is called; it is preceded by the name Math. 
                Similarly "System.out" precedes println().
*/
class Hypot {
    public static void main(String args[]) {
        double x, y, z;
    
        x = 3;
        y = 4;
    
        // Notice how sqrt() is called. It is preceded by the name of the class "Math" of which it is a member.
        z = Math.sqrt(x*x + y*y);
        System.out.println("Hypotenuse is " + z);
    }
}




/* Example 3: Since char is an "unsigned 16-bit" type, it is possible 
                to perform various arithmetic manipulations on a char variable.
                For example, Character variables can be handled like integers.

                In following program, ch is first given the value X. 
                    Next, ch is incremented. This results in ch containing Y. 

                    Then, ch is assigned the value 90, which is letter 'Z' in the ASCII (and Unicode) value.
*/
// Character variables can be handled like integers.
class CharArithDemo {
    public static void main(String args[]) {
        char ch;

        ch = 'X';
        System.out.println("ch contains " + ch);

        ch++; // increment ch
        System.out.println("ch is now " + ch);

        ch = 90; // give ch the value Z
        System.out.println("ch is now " + ch);
    }
}


/* 
    Note that the "ASCII character set" occupies the first 127 values in the "Unicode character set", 
    So all the tricks applied for ASCII in C/C++ also applicable to Unicode.
*/




// ----  rev[04-Apr-24]  ----

public class JV_ch1_4_1_data_types{
    public static void main(String[] args) {

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



/* 
Why does Java have different data types for integers and floating-point values? That
is, why aren’t all numeric values just the same type?
A: Java supplies different data types so that you can write efficient programs. For example,
integer arithmetic is faster than floating-point calculations. Thus, if you don’t need
fractional values, then you don’t need to incur the overhead associated with types float or
double. Second, the amount of memory required for one type of data might be less than
that required for another. By supplying different types, Java enables you to make best use
of system resources. Finally, some algorithms require (or at least benefit from) the use of
a specific type of data. In general, Java supplies a number of built-in types to give you the
greatest flexibility.

 */




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
