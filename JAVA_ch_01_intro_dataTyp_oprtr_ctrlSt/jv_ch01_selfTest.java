
/* ------------    Chapter 2 Self Test    ------------

// ----  rev[19-Aug-2024]  ----


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



