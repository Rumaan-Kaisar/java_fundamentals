
/* -=-=-=-=-=-=-=-=-=-=-=      Opeartors in JAVA      -=-=-=-=-=-=-=-=-=-=-= 

    Arithmeatic operator: 
        All operators rules are same as C/C++.  
            +	        Addition (also unary plus)
            –	        Subtraction (also unary minus)
            *	        Multiplication
            /	        Division
            %	        Modulus
            ++	        Increment
            ––	        Decrement
            =           Assignment
            

    Relational operators: 
        are also same as C/C++
            ==	    Equal to	
            !=	    Not equal to	
            >	    GREATER than	
            <	    LESS than	
            >=	    Greater than or equal to	
            <=	    Less than or equal to	


    Logical operatrs:
            &	    (Logical) AND
            |	    (Logical) OR
            !	    NOT
            ^	    XOR (exclusive OR)

            ||	    Short-circuit OR (conditional-OR)
            &&	    Short-circuit AND (conditional-AND)
            
        Note: 
            '||', '&&' are also called "Shortcircuit AND, OR" [in C++ these are Logical AND, OR]
            '|', '&', '^' are  called "Bitwise AND, OR, XOR" these are also "Logical AND, OR, XOR"
            The "short-circuit" operators in Java refers as the conditional-OR and the conditional-AND operators



    Data-type restrictions:
        ARITHMETIC and RELATIONAL operators can be applicable to both 'numeric' and 'char' type of data.
        
        RELATIONAL operators are 'NOT applicable' to "Boolean" type data. 
            i.e.  "true > false"  has no meaning in Java. 
        
        In Java, all "OBJECTS" can be compared for equality or inequality using == and !=
    
        However, <, >, <=, or >=, can be applied only to those types that 
            support an ordering relationship (i.e. numeric or char type)



    Operator combination:
        'relational' and 'logical' operators can act together. 
        For 'logical' operators the operands must be 'Boolean' type .



    --------  Bitwise and Shift  --------
    Java Bitwise and Shift Operators:
        In Java, bitwise operators perform operations on INTEGER DATA at the 'individual bit-level'. 
        Here, the INTEGER DATA includes byte, short, int, and long types of data.

    There are 7 operators to perform bit-level operations in Java:

            |       Bitwise OR
            &       Bitwise AND
            ^       Bitwise XOR
            ~       Bitwise Complement (1's complement. Unary NOT)
            <<      Left Shift
            >>      Signed Right Shift
            >>>     Unsigned Right Shift

        The bitwise operators act directly upon the bits of their operands. 
            They are defined only for 'integer operands'. 
                can be used on values of type long, int, short, char, or byte
            They cannot be used on bool, float, double, or class types. 

    Bitwise operators are used to test, set, or shift the 'individual bits' that make up a value. 

    Bitwise operations are important to a wide variety of 'systems-level programming tasks' 
        in which status information from a device must be interrogated or constructed. 

    Note:
        Bitwise AND, OR, XOR, and NOT  operators (&, |, ^, and ~) perform the 'same operations' as their "BOOLEAN LOGICAL equivalents". 
        The difference is that the bitwise operators work on a 'bit-by-bit basis'. 



	--------    C/C++ logical operator modification in JAVA    --------
        "&&" is for 'logical AND operation in C/C++', 
            Which is changed to "&" to denote "logical as wel as bitwise AND" operation in Java.
            "&&" is now denote " Short-circuit AND" operation in Java.
            i.e. in C++ "bitwise and logical AND" was different, but in JAVA '&' is for both "bitwise and logical"
        
        "||" is for 'logical OR operation in C/C++', 
            Which is changed to "|" to denote "logical as wel as bitwise OR" operation in Java.
            "||" is now denote " Short-circuit OR" operation in Java.
            i.e. in C++ "bitwise and logical OR" was different, but in JAVA '|' is for both "bitwise and logical"

        No XOR available in C++
            Newly introduced '^' operator for "XOR" operation in Java. This is unavailable in C/C++. 





    ------------    postfix-prefix    ------------
    postfix-prefix:    
        Both the ++ and -- operators can either 'precede (prefix)' or 'follow (postfix)' the operand. 
                    Eg: x = x + 1; can be written as 
                    prefix:    ++x;    or  as  
                    postfix:   x++; 
        In this case there is no difference whether the increment is applied as a prefix or a postfix. (Recall: C/C++ C_Ch2_2_1)
	

        However, when an increment or decrement is used as part of a 'larger expression', there is an important difference. 

        prefix ++x
            When ++ or -- precedes its operand, Java will perform the 'corresponding operation prior' 
                to obtaining the operand’s value for use by the rest of the expression. For example:
                    x = 10;
                    y = ++x;
                In this case, y will be set to 11.


        postfix x++
            If ++ or -- follows its operand, Java will obtain the operand’s value before incrementing or decrementing it.
                x = 10; 
                y = x++;
            then y will be set to 10. 

            Notice, In both cases, x is still set to 11;


        In short way:
                j = i++;    current value of i is assigned to j. Then i is incremented.
                j = ++i;    current value of i is incremented then assigned to j 





    ------------    Short-circuit AND/OR    ------------

        Truth table. T:true, F:false

        ------------------------------------------
        p       q       p&q     p|q     p^q     !p	
        ------------------------------------------
        T       T       T       T       F       F	
        T       F       F       T       T       F	
        F       T       F       T       T       T	
        F       F       F       F       F       T	
        ------------------------------------------

    The only difference between the 'normal & |' and 'short-circuit && ||' versions is that the 
        NORMAL operands (&, |) will always 'evaluate each operand', but 
        SHORT-CIRCUIT versions (&&, ||) focus 'only first operand' and will evaluate the second operand   iff    'first operand is TRUE'.


	Notice the truth table of 'Logical ANR, OR':
        AND "&" operation: if the first operand is FALSE, the 'outcome is false' no matter what value the second operand has. 
	    OR "|" operation: if the first operand is TRUE, the 'outcome is true' no matter what the value of the second operand. 

        So, in these two cases there is no need to evaluate the second operand (no need to use Logocal '&', '|'). 
            So time can be saved and more efficient code can be produced if we use "&&", "||" the "short-circuit versions" of "AND", "OR".



    ------------    usage of "short circuit"    ------------
    short-circuit "&&" and  "||" can be used to solve following kind of situations: 
        Since the 'modulus' operation involves a division, the short-circuit form '&&' is used to prevent a 'divide-by-zero error'.

            n = 10;
            d = 2; 

            if(d!=0 && (n%d)==0){
                System.out.println(d + " is a factor of " + n); 	// Since d is 2, the second operand "modulus" is evaluated
            }

            d = 0; // d is now set to 0
            // in following cases '&&' is more safe
            if(d!=0 && (n%d)==0){
                System.out.println(d + " is a factor of " + n);	    // Since d is zero, the second operand "modulus" is not evaluated
            }
            if(d!=0 && (n%d)==0){
                System.out.println(d + " is a factor of " + n);	    // without && operator. This will cause a 'divide-by-zero error'
            }


    ------------    Side effect of "short circuit" forms    ------------
    Side effect of "short circuit" forms:    
        Sometimes we need both "&", "|" and "&&", "||". 
        there are some cases where you will want "both operands" of an AND or OR operation to be 'evaluated'. For Example:

            int i;
            i = 0;

            // 'i' incremented even though if statement fails.
                // because 'false' and '++i<100' both evaluated
                // during evaluation of '++i<100', i is incremented

            if(false & (++i < 100) ) System.out.println("won't be displayed");
            System.out.println("if stmt executed:" +i); 		// displays 1


            // In this case, i is not incremented because the short-circuit operator skips the increment
                // '++i<100' is skipped here, hence i is not incremented

            if(false && (++i < 100) ) System.out.println("won't be displayed");
            System.out.println("if statement executed: " + i); 	// still 1 !!
                
            
    


    ------------    SHORTHAND assignment    ------------
    SHORTHAND = operators: 
        Java allow some 'shorthand assignment' operators similar to C++.
	
        To create a "chain" of assignments: 
            int x, y, z;
            x = y = z = 100; 	// set x, y, and z to 100

            Here the = is an operator that yields the value of the 'right-hand expression'. 
            Thus, the value of z = 100 is 100, which is then assigned to y, which in turn is assigned to x. 
            
            Using a “chain of assignment” is an easy way to set a 'group of variables' to a "common value".
	
    Shorthand / compound assignment operators: 
            x = x + 10; can be written as 
            x += 10;  
        and   
            x = x - 100; can be written as 
            x -= 100;  
        In both cases the operator pairs '+='  ,  '-=' tells the compiler 
            to assign to x the value of " x plus 10 " , " x minus 100 ".	
    
            
    This shorthand will work for all the 'binary operators' in Java . The general form of the shorthand is:   
            var op = expression ;
        
    Following is a list of the ARITHMETIC and LOGICAL 'shorthand assignment operators' :

            +=	
            –=	
            *=	
            /=
            %=	
            &=	
            |=	
            ^=



    ------------    Operator Precedence    ------------
    Highest 
            x++   x––   (Postfix)

            ++x   ––x   (prefix)   ~   !   + (unary)   – (unary)   (type-cast)

            *   /   %
    
            +   -

            >>   >>>   <<

            >   >=   <   <=   instanceof

            ==   !=
            
            &

            ^

            |

            &&

            ||

            ?:

            ->

            =   op=

    Lowest

*/




/* Example 1: The following program demonstrates the modulus operator '%' 
                The % yields a remainder of 1 for both "integer" and "floating" - point operations
*/
class ModDemo {
    public static void main(String args[]) {
        int iresult, irem;
        double dresult, drem;
    
        iresult = 10 / 3;   // indeger division cause data-loss, truncates to integer
        irem = 10 % 3;      // Demonstrate the % operator.

        dresult = 10.0 / 3.0;   // no data-loss
        drem = 10.0 % 3.0;

        System.out.println("Result and remainder of 10 / 3: " + iresult + " " + irem);
        System.out.println("Result and remainder of 10.0 / 3.0: " + dresult + " " + drem);
    }
}




/* Example 2: Here is a program that demonstrates several of the RELATIONAL and LOGICAL operators. */
class RelLogOps {
    public static void main(String args[]) {
        int i, j;
        boolean b1, b2;

        i = 10;
        j = 11;
        if(i < j) System.out.println("i < j");
        if(i <= j) System.out.println("i <= j");
        if(i != j) System.out.println("i != j");
        if(i == j) System.out.println("this won't execute");
        if(i >= j) System.out.println("this won't execute");
        if(i > j) System.out.println("this won't execute");

        b1 = true;
        b2 = false;
        if(b1 & b2) System.out.println("this won't execute");
        if(!(b1 & b2)) System.out.println("!(b1 & b2) is true");
        if(b1 | b2) System.out.println("b1 | b2 is true");
        if(b1 ^ b2) System.out.println("b1 ^ b2 is true");
    }
}




/* Example 3: Here is a program that demonstrates the short-circuit AND operator. 
                The program determines whether the value in d is a factor of n.

                It does this by performing a modulus operation. 
                If the remainder of n / d is zero, then d is a factor. 

                However, since the modulus operation involves a "DIVISION", 
                the short-circuit form of the AND is used to prevent a "divide-by-zero error" 
*/

class SCops {
    public static void main(String args[]) {
        int n, d, q;
    
        n = 10;
        d = 2;

        if((d != 0) && (n % d) == 0) System.out.println(d + " is a factor of " + n);

        d = 0; // now, set d to zero
        // Since d is zero, the second operand is not evaluated
        // The short-circuit operator prevents a division by zero
        if((d != 0) && (n % d) == 0) System.out.println(d + " is a factor of " + n);


        // try same thing without short-circuit operator, using normal '&'
        // This will cause a divide-by-zero error, because both operands will execute
        if((d != 0) & (n % d) == 0) System.out.println(d + " is a factor of " + n);
    }
}

/*  To prevent a divide-by-zero, the if statement first checks to see if d is equal to zero. 
    If it is, the short-circuit AND stops at that point and does not perform the modulus division. 

    Trying normal AND operator, causes both operands to be evaluated, 
    which leads to a "runtime error" when the division by zero occurs.
*/




// ------------    Side effects of short-circuit operators    ------------

/* Example 4: Since the short-circuit operators are, in some cases, more efficient than their normal counterparts, 
                why does Java still offer the normal AND and OR operators?

                ans: In some cases you will want both operands of an AND or OR operation to be evaluated
                        because of the side effects produced. Consider the following: 
*/
// Side effects can be important.
class SideEffects {
    public static void main(String args[]) {
        int i;

        i = 0;
        // Here, i is still incremented even though the if statement fails.
        if(false & (++i < 100)) System.out.println("this won't be displayed");
        System.out.println("if statement executed: " + i); // displays 1

        // In this case, i is not incremented because the short-circuit operator skips the increment.
        if(false && (++i < 100)) System.out.println("this won't be displayed");
        System.out.println("if statement executed: " + i); // still 1 !!
    }
}

/* The point is that: if your code expects the right-hand operand of an AND or OR operation to be evaluated, 
                        you must use Java’s "nonshort-circuit" forms of these operations. 
*/




// --------  Truth Table  --------

/*  Example 5: fOLLOWING program displays the "truth table" for Java’s LOGICAL operators. 

                Line up the columns: 
                    use the \t escape sequence to embed tabs into each output string
                    Eg:  the header for the table:
                        
                        System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");
*/

// A truth table for the logical operators.
class LogicalOpTable {
    public static void main(String args[]) {
        boolean p, q;

        System.out.println("P\tQ\tAND\tOR\tXOR\tNOT p");

        p = true; q = true;
        System.out.print(p + "\t" + q +"\t");
        System.out.print((p&q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + (!p));

        p = true; q = false;
        System.out.print(p + "\t" + q +"\t");
        System.out.print((p&q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + (!p));

        p = false; q = true;
        System.out.print(p + "\t" + q +"\t");
        System.out.print((p&q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + (!p));

        p = false; q = false;
        System.out.print(p + "\t" + q +"\t");
        System.out.print((p&q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + (!p));
    }
}

/*  Notice the parentheses "()" surrounding the logical operations inside the println() statements.
    They are necessary because of the precedence of Java’s operators. 
    The "+" operator is higher than the logical operators. 
*/




// another version

// --------    [25-JUL-2024]    --------

/* Example 6: Modifying the program so that it uses and displays 1’s and 0’s, rather than
true and false. This may involve a bit more effort than you might at first think! */

