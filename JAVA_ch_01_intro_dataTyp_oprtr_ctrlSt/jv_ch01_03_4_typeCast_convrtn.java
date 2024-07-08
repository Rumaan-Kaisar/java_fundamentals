
/* -=-=-=-=-=-=-=-=-=-=-=      Type Conversion and Type-cast      -=-=-=-=-=-=-=-=-=-=-= 

    assignment type Conversion:
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



    --------    Type-Cast    --------
    
    Type-Cast for Incompatible Types: 
        When type-conversion is illegal (long to double) or incompatible (Boolean to int) we can use the "type-cast". 
        A cast is an "instruction to the compiler" to convert one type into another.   
        A cast has this general form:

            (target-type) expression

        Here, "target-type" specifies the desired data-type to convert the specified expression to. Eg:  
            double x,y; 
            int k =(int)(x/y);
        
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


        [1] First, all "char", "byte", and "short" values are promoted to "int"
        [2] Then, if one operand is a "long", the whole expression is promoted to "long"
        [3] If one operand is a "float" operand, the entire expression is promoted to "float"
        [4] If any of the operands is "double", the result is "double"

                char / byte / short     promoted to     "int"
                For a   "long"    operand, whole expression is promoted to "long"
                For a   "float"   operand, whole expression is promoted to "float"
                For a   "double"  operand, whole expression is promoted to "double"


        Type promotions of a variable "EXPIRE" after the evaluation of the expression. 
        For example, if the value of a "byte variable" is promoted to int inside an expression, 
            outside the expression, the variable is still a byte. 

        Type promotion only affects the evaluation of an expression.
*/
