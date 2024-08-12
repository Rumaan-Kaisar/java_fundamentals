
/* ------------    Chapter 2 Self Test    ------------















Example 4: Given this output,
One
Two
Three
use a single string to show the println( ) statement that produced it.
System.out.println("One\nTwo\nThree");




Example 5: What is wrong with this fragment?
for(i = 0; i < 10; i++) {
int sum;
sum = sum + i;
}
System.out.println("Sum is: " + sum);
There are two fundamental flaws in the fragment. First, sum is created each time the block defined by the
for loop is entered and destroyed on exit. Thus, it will not hold its value between iterations. Attempting to
use sum to hold a running sum of the iterations is pointless. Second, sum will not be known outside of the
block in which it is declared. Thus, the reference to it in the println( ) statement is invalid.




Example 6: Explain the difference between the prefix and postfix forms of the increment operator.
When the increment operator precedes its operand, Java will perform the increment prior to obtaining
the operand’s value for use by the rest of the expression. If the operator follows its operand, then Java
will obtain the operand’s value before incrementing.




Example 7: Show how a short-circuit AND can be used to prevent a divide-by-zero error.
if((b != 0) && (val / b)) ...




Example 8: In an expression, what type are byte and short promoted to?
In an expression, byte and short are promoted to int.Appendix A: Answers to Self Tests 619




Example 9: In general, when is a cast needed?
A cast is needed when converting between incompatible types or when a narrowing conversion is
occurring.




Example 10: Write a program that finds all of the prime numbers between 2 and 100.
// Find prime numbers between 2 and 100.
class Prime {
public static void main(String args[]) {
int i, j;
boolean isprime;
for(i=2; i < 100; i++) {
isprime = true;
// see if the number is evenly divisible
for(j=2; j <= i/j; j++)
// if it is, then it's not prime
if((i%j) == 0) isprime = false;
if(isprime)
System.out.println(i + " is prime.");
}
}
}




Example 11: Does the use of redundant parentheses affect program performance?
No.




Example 12: Does a block define a scope?
Yes.

 */




/*  Example 1: Why does Java "strictly specify" the range and behavior of its primitive types?

                ans:
                    to ensure portability across platforms.
*/


/*  Example 2: What is Java’s character type, and how does it differ 
                from the character type used by some other programming languages?

            ans:
                Java’s character type is char. 
                Java characters are "Unicode" rather than "ASCII" 
                ASCII is used by some other computer languages
*/


/*  Example 3: A boolean value can have any value you like because any non-zero value is true. True or False?

            ans:
                False.
                A boolean value must be either "true" or "false".
*/

