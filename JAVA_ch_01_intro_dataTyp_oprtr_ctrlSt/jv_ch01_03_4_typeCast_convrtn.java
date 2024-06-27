
/* -=-=-=-=-=-=-=-=-=-=-=      Type Conversion and Type-cast      -=-=-=-=-=-=-=-=-=-=-= */


1.16 Type Conversions and type-cast (Recall C/C++ 3.5, 3.6):
When compatible types are mixed in an assignment, the value of the right side is automatically converted to the type of the left side. Eg: int i;  float f;  i = 10;  f = i;  here, the value in i is converted into a float and then assigned to f. Not all types are compatible, for example, boolean and int are not compatible.
	Type conversion: When one type of data is assigned to another type of variable, an automatic type conversion will take place if
	The two types are compatible.		The destination type is larger than the source type.
When these two conditions are met, a widening conversion takes place. For example, the int type is always large enough to hold all valid byte values, and both int and byte are integer types, so an automatic conversion from byte to int can be applied.

Example: long to double is a widening conversion and is legal. But there is no automatic conversion from double to long, since this is not a widening conversion.		long L, l; 	 double D, d;
	L = 100123285L;  d = 90123285.0;
	D = L; 	// legal
	l = d; 	// illegal!!!
	Type-Cast for Incompatible Types: When type-conversion is illegal (long to double) or incompatible (Boolean to int) we can use the type-cast. A cast is an instruction to the compiler to convert one type into another.   A cast has this general form:

(target-type) expression

Here, target-type specifies the desired type to convert the specified expression to. Eg:  double x,y; int k =(int)(x/y);
	The parentheses surrounding  x/y  are necessary. Otherwise, the cast to int would apply only to the  x. 
	The cast is necessary here because there is no automatic conversion from double to int.
	Data-loss during type-cast: When a cast involves a narrowing conversion, information might be lost. When casting a long into a short, information will be lost if the long’s value is greater than the range of a short because its high-order bits are removed. When a floating-point value is cast to an integer type, the fractional component will also be lost due to truncation. For example, if the value 1.23 is assigned to an integer, the resulting value will simply be 1. The 0.23 is lost. For Example:
byte b;  int i;
i = 100; b = (byte) i; 	// No loss of info here. A byte can hold the value 100
i = 257; b = (byte) i;	// Information loss this time. A byte cannot hold the value 257

	Type Conversion in Expressions: When different types of data are mixed within an expression, they are all converted to the same type. This is accomplished through the use of Java’s type promotion rules .	Recall C/C++ 3.5
[1]	First, all char, byte, and short values are promoted to int. 
[2]	Then, if one operand is a long, the whole expression is promoted to long. 
[3]	If one operand is a float operand, the entire expression is promoted to float. 
[4]	If any of the operands is double, the result is double.
	type promotions of a variable expire after the evaluation of the expression. For example, if the value of a byte variable is promoted to int inside an expression, outside the expression, the variable is still a byte. Type promotion only affects the evaluation of an expression.
	type-cast in expression: Even though we have type-promotion in an expression, but in some cases we still need type-cast. Eg:
byte b;   int i;
b = 10;   i = b * b; 		// OK, no cast needed
b = 10;   b = (byte) (b * b); 	// cast needed!!
	No cast is needed when assigning b*b to i, because b is promoted to int when the expression is evaluated. 
	However, when you try to assign b*b to b, you do need a cast—back to byte! Keep this in mind if you get unexpected type-incompatibility error messages on expressions that would otherwise seem perfectly OK.
	This same sort of situation also occurs when performing operations on chars. For example, in the following fragment, the cast back to char is needed because of the promotion of ch1 and ch2 to int within the expression:
char ch1 = 'a',   ch2 = 'b';
ch1 = (char) (ch1 + ch2);
Without the cast, the result of adding ch1 to ch2 would be int, which can’t be assigned to a char.

