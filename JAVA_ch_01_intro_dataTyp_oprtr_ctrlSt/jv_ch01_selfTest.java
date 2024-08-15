
/* ------------    Chapter 2 Self Test    ------------

// ----  rev[15-Aug-2024]  ----



Example 6: Explain the difference between the prefix and postfix forms of the increment operator.
When the increment operator precedes its operand, Java will perform the increment prior to obtaining
the operand’s value for use by the rest of the expression. If the operator follows its operand, then Java
will obtain the operand’s value before incrementing.




Example 7: Show how a short-circuit AND can be used to prevent a divide-by-zero error.
if((b != 0) && (val / b)) ...




Example 8: In an expression, what type are byte and short promoted to?
            In an expression, byte and short are promoted to int.Appendix A: answers to Self Tests 619:




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


*/


