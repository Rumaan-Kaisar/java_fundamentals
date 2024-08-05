
/* -=-=-=-=-=-=-=-=-=-=-=      Type Conversion and Type-cast      -=-=-=-=-=-=-=-=-=-=-= 

    ASSIGNMENT type Conversion:
        When compatible types are mixed in an assignment, 
        right side value automatically converted to the type of the left side

            Eg: 
                    int i;  
                    float f;  

                    i = 10;  
                    f = i;  

                i is converted into a float and then assigned to f

        Not all types are compatible, for example, "boolean" and "int" are not compatible.



    Type conversion (automatic): 
        When one type of data is assigned to another type of variable, 
            an automatic type conversion will take place if:

                1. The two types are compatible.
                2. The destination type is larger than the source type.

        When these two conditions are met, a "widening conversion" takes place. 
        For example, 
            Both "int" and "byte" are integer types, 
            the "int" is always large enough to hold all valid "byte" values, 

        so an automatic conversion from byte to int can be applied.


        Example :  "long" to "double" is a "widening conversion" and is legal. 
                    But there is no automatic conversion from double to long, since this is not a "widening conversion".		
                    
                    long L, l; 	 
                    double D, d;
	
                    L = 100123285L;  
                    d = 90123285.0;
	
                    D = L; 	// legal
	                l = d; 	// illegal!!!


        No autometic conversion:
            from numeric types to char or boolean
            char and boolean are not compatible with each other
            from double to long

        However, an integer literal can be assigned to char


        
    --------    Type-Cast    --------
    
    Type-Cast for Incompatible Types: 
        When type-conversion is illegal (long to double) or incompatible (Boolean to int) we can use the "type-cast". 
        A cast is an "instruction to the compiler" to convert one type into another.   
        A cast has this general form:

            (target-type) expression

        Here, "target-type" specifies the desired data-type to convert the specified expression to. Eg:  
            double x, y; 
            int k =(int)(x/y);
        
            Even though x and y are of type double, the cast converts the outcome of the expression to int.
            "Data loss" occurs when converting from a larger to a smaller data-type.
            The parentheses () surrounding  x/y  are necessary. Otherwise, the cast to int would apply only to the x

        The cast is necessary here because there is "no automatic conversion" from "double" to "int"


    Data-loss during type-cast: 
        When a cast involves a "narrowing conversion" (i.e. bigger data-type to lower data-type, e.g "double" to "int"), 
        information might be LOST. 
        
        When casting a "long" into a "short", 
            information will be lost if the long’s value is "greater than the range" of a short 
            because its high-order bits are removed. 
            
        When a floating-point value is cast to an integer type, 
            the "fractional" component will also be lost due to truncation
            1.23 will become 1 and ".23" will be lost


        Example:
            For Example, consider this byte to int conversion

                    byte b;  
                    int i;

                    i = 100; 
                    b = (byte) i; 	// No loss of info here. A byte can hold the value 100
                    
                    i = 257; 
                    b = (byte) i;	// Information loss this time. A byte cannot hold the value 257



    --------    Type Conversion in Expressions    --------
    Type Conversion in Expressions:
        When "different types "of data are "mixed" within an expression, 
        they are all converted to the same type. 
        This is accomplished through the use of Java’s "TYPE PROMOTION" rules


        [1]  First, all "char", "byte", and "short" values are promoted to "int"
        [2]  Then, if one operand is a "long", the whole expression is promoted to "long"
        [3]  If one operand is a "float" operand, the entire expression is promoted to "float"
        [4]  If any of the operands is "double", the result is "double"

                char / byte / short     promoted to     "int"
                For a   "long"    operand, whole expression is promoted to "long"
                For a   "float"   operand, whole expression is promoted to "float"
                For a   "double"  operand, whole expression is promoted to "double"


        Type promotions of a variable "EXPIRE" after the evaluation of the expression. 
        For example, if the value of a "byte variable" is promoted to int inside an expression, 
            outside the expression, the variable is still a byte. 

        Type promotion only affects the evaluation of an expression.
*/


/*  Example 1: if the value of a "byte variable" is promoted to int inside an expression, 
            outside the expression, the variable is still a byte.  
*/

public class TypePromotionExample {
    public static void main(String[] args) {
        byte b = 42;
        int result;

        // Inside the expression, 'b' is promoted to int
        result = b * 2;

        // Print the result of the expression
        System.out.println("Result of expression (b * 2): " + result);

        // 'b' is still a byte after the expression
        System.out.println("Type of b: " + ((Object) b).getClass().getName());
        System.out.println("Value of b: " + b);
    }
}





/*  --------    type-cast in Expressions    --------

    Even though we have type-promotion in an expression, 
        but in some cases we still need type-cast.
        For example:

            byte b;
            int i;

            b = 10;
            i = b * b; 		// OK, no cast needed. 
            // since b is promoted to int before the multiplication and i is an int

            b = 10;
            b = (byte) (b * b); 	// cast needed!!


        No cast is needed when assigning b*b to i, because b is promoted to int when the expression is evaluated. 
        However, when you try to assign b*b to b, you do need a "cast—back" to byte! 

        Keep this in mind if you get "unexpected type-incompatibility error" messages 
            on expressions that would otherwise seem perfectly OK.


    This "same sort of situation" also occurs when performing operations on "chars". 
        For example, in the following fragment, 
        the "cast back to char" is needed because of the promotion of ch1 and ch2 to int within the expression.

            char ch1 = 'a',   ch2 = 'b';
            ch1 = (char) (ch1 + ch2);

        ch1 and ch2 are both promoted to int before the addition, when assigned to a character
        Without the cast, the result of adding ch1 to ch2 would be int, which can’t be assigned to a char.

    similarly,
        Even though b is promoted to int during the evaluation of the expression b * b, 
        the result of this expression is still an int. 
        Assigning this int result back to a byte requires an explicit cast

*/




/* Example 2: The following program is perfectly valid since
                long to double is a "widening conversion" that is automatically performed.
*/

class LtoD {
    public static void main(String args[]) {
        long L;
        double D;

        L = 100123285L;
        D = L;  // auto-conversion from long to double

        System.out.println("L and D: " + L + " " + D);
    }
}




/* Example 3: there is no automatic conversion from double to long (float-type to int-type), 
                    since it is not a widening conversion. 
                Thus, the following version of the preceding program is invalid.
*/
// *** This program will not compile. ***
class DtoL {
    public static void main(String args[]) {
        long L;
        double D;

        D = 100123285.0;
        L = D; // Illegal & NO auto-conversion
        // L = (long) D;    // type-cast is a solution, "int" or "long" 
        System.out.println("L and D: " + L + " " + D);
    }
}




/* Example 4: The following program demonstrates some type conversions that require casts */

class CastDemo {
    public static void main(String args[]) {
        double x, y;
        byte b;
        int i;
        char ch;

        x = 10.0;
        y = 3.0;
        i = (int)(x/y); // cast double to int. Truncation will occur
        System.out.println("Integer outcome of x / y: " + i);

        i = 100;
        b = (byte)i;  // No loss of info here. A byte can hold the value 100
        System.out.println("Value of b: " + b);

        i = 257;
        b = (byte)i;  // Information loss this time. A byte cannot hold the value 257
        System.out.println("Value of b: " + b);

        b = 88; // ASCII code for X
        ch = (char)b;   // Cast between incompatible types
        System.out.println("ch: " + ch);
    }
}




/* Example 5: the outcome of an operation involving two "byte values" will be an "int". 
                This is not what you might intuitively expect. 
                Consider the following program: 

                Same sort of situation also occurs when performing operations on "chars". 
                For example, in the following fragment, the cast back to char is needed 
                    because of the promotion of ch1 and ch2 to int within the expression:

                    char ch1 = 'a', ch2 = 'b';
                    ch1 = (char) (ch1 + ch2);
*/
// A promotion surprise!
class PromDemo {
    public static void main(String args[]) {
        byte b;
        int i;

        b = 10;
        i = b*b;    // OK, no cast needed
        b = 10;
        b = (byte)(b * b);     // cast needed!!
        System.out.println("i and b: " + i + " " + b);
    }
}

// "incompatible types" ERROR occurs if "type-cast" not used




/* Example 6: Casts are not only useful when "converting between types" in an assignment. 
                For example, consider the following program. 
                It uses a "cast to double" to obtain a fractional component 
                    from an otherwise integer division.
*/
// Using a cast.
class UseCast {
    public static void main(String args[]) {
        int i;

        for(i = 0; i < 5; i++) {
            System.out.println(i + " / 3: " + i/3);
            // type-cast is used to obtain fractional part
            System.out.println(i + " / 3 with fractions: " + (double) i/3);
            System.out.println();
        }
    }
}


