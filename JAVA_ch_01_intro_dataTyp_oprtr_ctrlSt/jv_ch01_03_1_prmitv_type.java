
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




/* ----------------    boolean    ----------------
    when a boolean value is output by println(), "true" or "false" is displayed. 

    boolean variable also used to control the if statement. 
        There is no need to write an "if(b == true)" we can just use "if(b)"

    The outcome of a relational operator, such as <, is a boolean value.
*/


/* Example 4: The boolean type represents true/false values. 
                Java defines the values true and false using the reserved words 'true' and 'false'. 
                Here is a program that demonstrates the boolean type: */
// Demonstrate boolean values.
class BoolDemo {
    public static void main(String args[]) {
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
        // '()' around 10 > 9 is necessary because the '+' operator has a higher precedence than the >
    }
}




/* Example 5: How Far Away Is the Lightning?  
                create a program that computes how far away, in feet, a listener is from a lightning strike. 

                Sound travels approximately 1,100 feet per second through air. 

                Thus, knowing the interval between the time you see a lightning bolt and
                    the time the sound reaches you enables you to compute the distance to the lightning. 

                Assume that the time interval is 7.2 seconds.
*/

// Compute the distance to a lightning strike whose sound takes 7.2 seconds to reach you.

class Sound {
    public static void main(String args[]) {
        double dist;
    
        dist = 7.2 * 1100;
        System.out.println("The lightning is " + dist + " feet away.");
    }
}






/*  Why does Java have different data types for integers and floating-point values? 
        That is, why aren’t all numeric values just the same type?

    Speed: 
        Integer arithmetic is faster than floating-point calculations.
    
    Memory: 
        amount of memory required for one type of data might be less than that required for another. 
    
    Algorithms: 
        some algorithms require (or at least benefit from) the use of a specific type of data. 
*/



