
/* -=-=-=-=-=-=-=-=-=-=-=      chapter name      -=-=-=-=-=-=-=-=-=-=-= */

// jv_ch02_10_bitwise_operators        2.17        166.5-176.8


2.17 Bitwise Operators (Recall C/C++ 7.7)
Bitwise operators are used to test, set, or shift the individual bits that make up a value. Bitwise operations are important to a wide variety of systems-level programming tasks in which status information from a device must be interrogated or constructed. 
	The bitwise operators can be used on values of type long, int, short, char, or byte. 
	Bitwise operations cannot be used on boolean, float, or double, or class types. 

Operator	&	|	^	>>	>>>	<<	~
Result
	Bitwise AND	Bitwise OR	Bitwise XOR	Shift right	Unsigned shift right	Shift left	One’s complement (unary NOT)
	Bitwise AND, OR, XOR, and NOT: The bitwise operators &, |, ^, and ~ perform the same operations as their Boolean logical equivalents. The difference is that the bitwise operators work on a bit-by-bit basis. 
	You can think of the bitwise AND as a way to turn bits off (and '0' remain off), bitwise OR as a way to turn bits on (and '1' remain on). 
	The following program uses & to turn lowercase letter into uppercase by resetting the 6th bit to 0, | to turn uppercase letter into lowercase by resetting the 6th bit to 1. 

[Why 6th bit? : By Unicode/ASCII character set is definition, the lowercase letters are the same as the uppercase ones except that the lowercase ones are greater in value by exactly 32. Therefore, to transform a lowercase letter to uppercase, just turn off the 6th bit, because in binary 32 is 100 000 "only 6th digit from right is 1/on". That is in binary " a=A+100,000" ]
Bitwise AND	Bitwise OR
	char ch;
	for(int i=0; i < 10; i++) { ch = (char) ('a' + i);
			           System.out.print(ch);
	// This statement turns off the 6th bit.
			           ch = (char) ((int) ch & 65503); 
			           System.out.print(ch + " ");	}		char ch;
	for(int i=0; i < 10; i++) {ch = (char) ('A' + i);
			           System.out.print(ch);
	// This statement turns on the 6th bit.
			           ch = (char) ((int) ch | 32); 
			           System.out.print(ch + " ");	}
Output: 	aA bB cC dD eE fF gG hH iI jJ	Output: 	Aa Bb Cc Dd Ee Ff Gg Hh Ii Jj
65,503 is 1111 1111 1101 1111 in binary. Thus, the AND operation leaves all bits in ch unchanged except for the 6th one, which is set to 0.	32 is 0000 0000 0010 0000 in binary. Thus, the OR operation leaves all bits in ch unchanged except for the 6th one, which is set to 1.

	Other usage of bitwise AND:		The AND operator is also useful when you want to determine whether a bit is on or off. For example, following determines whether bit 4 in status is set:
if((status & 8)!= 0) System.out.println("bit 4 is on");
The number 8 is used because in binary it is "1000" has only the 4th bit on/set. Therefore, the if statement can succeed only when bit 4 of status is also on. 
		An interesting use of above concept is to show the bits of a byte value in binary format.
	int t;
	byte val;
	val = 123;
for(t=128; t>0; t = t/2){ if((val & t) != 0) System.out.print("1 ");
			      else System.out.print("0 "); }

	output:	 0 1 1 1 1 0 1 1
         
[The for loop successively tests each bit in val, using the bitwise AND, to determine whether it is on or off. If the bit is on, the digit 1 is displayed; otherwise, 0 is displayed.]

	XOR will set a bit on iff the bits being compared are different (i.e. 1^1=1, 0^0=0, 1^1=0 ):
	XOR operator makes it a simple way to encode a message. When some value X is XORed with another value Y, and then that result is XORed with Y again, X is produced. That is, given the sequence R1 = X ^ Y; R2 = R1 ^ Y; i.e. X=(X^Y)^Y
	We can create simple CIPHER program in which some integer is the key that is used to both encode and decode a message by XORing the characters in that message. To encode, the XOR operation is applied the first time, yielding the cipher text. To decode, the XOR is applied a second time, yielding the plain text. 
[Of course, such a cipher has no practical value, being trivially easy to break. It does, however, provide an interesting way to demonstrate the XOR.]

String msg = "This is a test";   String encmsg = "";   String decmsg = "";
int key = 88;
// encode the message, create string with charAt()
for(int i=0; i < msg.length(); i++) encmsg = encmsg + (char)(msg.charAt(i) ^ key);

// decode the message, create string with charAt()
for(int i=0; i < msg.length(); i++) decmsg = decmsg + (char)(encmsg.charAt(i) ^ key);
	The unary one’s complement (NOT) operator reverses the state of all the bits of the operand. For example, if some integer called A has the bit pattern 1001 0110, then ~A produces a result with the bit pattern 0110 1001.
	The Shift Operators: Shift operators "<<" and ">>" are similar to C/C++ but the unsigned right shift ">>>" is new in Java.

operators	Meaning	General form	Descriptions
<<	Left shift	value << num-bits	value is the value being shifted by the number of bit positions specified by num-bits.
Each left shift causes all bits within the specified value to be shifted left one position and a 0 bit to be brought in on the right. Each right shift shifts all bits to the right one position and preserves the sign bit. 
>>	Right shift	value >> num-bits	
>>>	Unsigned right shift	value >>> num-bits	
	Right shifting ">>" –ve/negative value: Negative numbers are usually represented by setting the high-order bit of an integer value to 1, it is MSB representation for example "8" in binary is "0000 1000" and "-8" in binary is "1000 1000"(Here –ve value is represented as MSB : most significant bit representation, where leftmost bit is reserved for sign, 0 for +ve and 1 for –ve). Java do not use the MSB Representation,  here two’s complement is used.
	Java uses two’s complement to represent negative values. In this approach negative values are stored by first reversing the bits in the value (one's compliment) and then adding 1. Thus, the byte value for –1 in binary is 1111 1111. Right shifting this value will always produce –1! In two's complement, if we want to represent "-8" for 8 bit field (2^8 )_2-8_2=1 0000 0000-1000=1111 1000 for detail see 2.19 Signed binary numbers), and this is the approach used by Java.  If the value being shifted is negative, each right shift brings in a 1 on the left (i.e. -8>>1 brings "1111 1100").
	Note: In C/C++ also two's complement is used to represent –ve binary value. (Also in shifting operation)
	If the value is positive, each right shift brings in a 0 on the left.
	Unsigned right shift: To remove sign bit when shifting right, you can use an unsigned right shift ( >>> ), which always brings in a 0 on the left. For this reason, the >>> is also called the zero-fill right shift. (Eg:<<< is used when shifting bit patterns, such as status codes, that do not represent integers.)
	Lose of bits due to shift: For all of the shifts, the bits shifted out are lost. Thus, a shift is not a rotate, and there is no way to retrieve a bit that has been shifted out.
	Example 1: Here, an integer is given an initial value of 1, which means that its low-order bit is set. Then, a series of eight shifts are performed on the integer. After each shift, the lower 8 bits of the value are shown. The process is then repeated, except that a 1 is put in the 8th bit position, and right shifts are performed.
class ShiftDemo { public static void main(String args[]) {	int val = 1;
for(int i = 0; i < 8; i++) {	for(int t=128; t > 0; t = t/2) {          if((val & t) != 0) System.out.print("1 ");
          else System.out.print("0 ");  }   System.out.println();
val = val << 1; }  System.out.println();	/* left shift */  
val = 128;
for(int i = 0; i < 8; i++) {	for(int t=128; t > 0; t = t/2) {           if((val & t) != 0) System.out.print("1 ");
          else System.out.print("0 "); }System.out.println();
val = val >> 1;} 	}}			/* right shift */ 
	Be careful when shifting byte and short values because Java will automatically promote these types to int when evaluating an expression. For example, if you right shift a byte value, it will first be promoted to int and then shifted. The result of the shift will also be of type int. Often this conversion is of no consequence. 
	If you shift a negative byte or short value, it will be sign-extended when it is promoted to int. Thus, the high-order bits of the resulting integer value will be filled with ones. This is fine when performing a normal right shift. But when you perform a zero-fill right shift, there are 24 ones to be shifted before the byte value begins to see zeros.
	Bitwise Shorthand Assignments: All of the binary bitwise operators have a shorthand form that combines an assignment with the bitwise operation. For example, the following two statements both assign to x the outcome of an XOR of x with the value 127.
x = x ^ 127;			x ^= 127;
The bitwise shift operators can be used to perform very fast multiplication or division by "2":
	A shift left doubles a value.		A shift right halves it.


