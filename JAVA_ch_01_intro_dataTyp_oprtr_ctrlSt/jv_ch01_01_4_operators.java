
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
            &	    AND
            |	    OR
            !	    NOT
            ^	    XOR (exclusive OR)

            ||	    Short-circuit OR
            &&	    Short-circuit AND
            
        Note: 
            '||', '&&' are also called "Logical AND, OR"
            '|', '&', '^' are  called "Bitwise AND, OR, XOR"



    Data-type restrictions:
        ARITHMETIC and RELATIONAL operators can be applicable to both 'numeric' and 'char' type of data.
        RELATIONAL operators are 'NOT applicable' to "Boolean" type data. i.e.  true > false  has no meaning in Java. 

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

----  rev [29-jan-24]  ----

	
Truth table. T:true, F:false		The only difference between the normal and short-circuit versions is that the normal operands will always evaluate each operand, but short-circuit versions focus only first operand and will evaluate the second operand   iff    first operand is true.


	Notice the truth table, in an AND "&" operation, if the first operand is false, the outcome is false no matter what value the second operand has. 
	In an OR operation, if the first operand is true, the outcome of the operation is true no matter what the value of the second operand. 
So, in these two cases there is no need to evaluate the second operand. So time can be saved and more efficient code can be produced if we use "&&", "||" the "short-circuit versions" of "AND", "OR" .
p	q	p&q	p|q	p^q	!p	
T	T	T	T	F	F	
T	F	F	T	T	F	
F	T	F	T	T	T	
F	F	F	F	F	T	
	"&&" and  "||" can be used to solve following kind of situations: Since the modulus operation involves a division, the short-circuit form of the AND is used to prevent a divide-by-zero error.

n = 10;
d = 2; 
if(d != 0 && (n % d) == 0) System.out.println(d + " is a factor of " + n);	// Since d is 2, the second operand "modulus" is evaluated
d = 0; 
if(d != 0 && (n % d) == 0) System.out.println(d + " is a factor of " + n);	// Since d is zero, the second operand "modulus" is not evaluated.
if(d != 0 & (n % d) == 0) System.out.println(d + " is a factor of " + n);	// without && operator. This will cause a divide-by-zero error.
	Side effect of "short circuit" forms: However sometimes we need both "&", "|" and "&&", "||". In some cases you will want both operands of an AND or OR operation to be evaluated because of the side effects produced. For Example:

int i;
i = 0;
//  i incremented even though if statement fails. 
	if(false & (++i < 100) ) System.out.println("won't be displayed");
	System.out.println("if stmt executed:" +i); 		// displays 1

// In this case, i is not incremented because the short-circuit operator skips the increment. 
	if(false && (++i < 100) ) System.out.println("won't be displayed");
	System.out.println("if statement executed: " + i); 	// still 1 !!
	SHORTHAND assignment operators (Recall C/C++ 7.8.3): Java allow some shorthand assignment operators similar to C/C++.
	To create a chain of assignments: For example, consider this fragment:	int x, y, z;
x = y = z = 100; 	// set x, y, and z to 100
Here the = is an operator that yields the value of the right-hand expression. Thus, the value of z = 100 is 100, which is then assigned to y, which in turn is assigned to x. Using a “chain of assignment” is an easy way to set a group of variables to a common value.
	Shorthand / compound assignment operators: x = x + 10; can be written as x += 10;  and   x = x - 100; can be written as x -= 100;  In both cases the operator pairs +=  ,  -= tells the compiler to assign to x the value of " x plus 10 " , " x minus 100 ".	This shorthand will work for all the binary operators in Java .
The general form of the shorthand is:   var op = expression ;
The arithmetic and logical shorthand assignment operators :
	+=	–=	*=	/=
	%=	&=	|=	^=
1.15 Operator Precedence: 
Highest														Lowest
x++	++x  (prefix)	*	+	>>	>	==	&	^	|	&&	||	?:	->	=
x––	––x  (prefix)	/	-	>>>	>=	!=								op=
(Postfix)	~	%		<<	<									
	!				<=									
	+ (unary)				instanceof									
	– (unary)													
	(type-cast)													


 */
