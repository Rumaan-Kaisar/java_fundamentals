
/* ------------    Chapter 3 Self Test    ------------


5. Is the following fragment valid?
for(int i = 0; i < num; i++)
sum += i;
count = i;




6. Explain what break does. Be sure to explain both of its forms.




7. In the following fragment, after the break statement executes, what is displayed?
for(i = 0; i < 10; i++) {
while(running) {
if(x<y) break;
// ...
}
System.out.println("after while");
}
System.out.println("After for");




8. What does the following fragment print?
for(int i = 0; i<10; i++) {
System.out.print(i + " ");
if((i%2) == 0) continue;
System.out.println();
}
✓Chapter 3: Program Control Statements 101




9. The iteration expression in a for loop need not always alter the loop control variable by a
fixed amount. Instead, the loop control variable can change in any arbitrary way. Using this
concept, write a program that uses a for loop to generate and display the progression 1, 2, 4,
8, 16, 32, and so on.




10. The ASCII lowercase letters are separated from the uppercase letters by 32. Thus, to convert
a lowercase letter to uppercase, subtract 32 from it. Use this information to write a program
that reads characters from the keyboard. Have it convert all lowercase letters to uppercase,
and all uppercase letters to lowercase, displaying the result. Make no changes to any other
character. Have the program stop when the user enters a period. At the end, have the program
display the number of case changes that have taken place.




11. What is an infinite loop?



12. When using break with a label, must the label be on a block that contains the break?

*/


/* Example 4: Show the for statement for a loop that counts from 1000 to 0 by –2.

                for(int i = 1000; i >= 0; i -= 2)   // ...
*/


/*
5. Is the following fragment valid?
for(int i = 0; i < num; i++)
sum += i;
count = i;
No; i is not known outside of the for loop in which it is declared.




6. Explain what break does. Be sure to explain both of its forms.
A break without a label causes termination of its immediately enclosing loop or switch statement.
A break with a label causes control to transfer to the end of the labeled block.Appendix A: Answers to Self Tests 621




7. In the following fragment, after the break statement executes, what is displayed?
for(i = 0; i < 10; i++) {
while(running) {
if(x<y) break;
// ...
}
System.out.println("after while");
}
System.out.println("After for");
After break executes, “after while” is displayed.




8. What does the following fragment print?
for(int i = 0; i<10; i++) {
System.out.print(i + " ");
if((i%2) == 0) continue;
System.out.println();
}
Here is the answer:
0 1
2 3
4 5
6 7
8 9





9. The iteration expression in a for loop need not always alter the loop control variable by a
fixed amount. Instead, the loop control variable can change in any arbitrary way. Using this
concept, write a program that uses a for loop to generate and display the progression 1, 2, 4,
8, 16, 32, and so on.


// Use a for loop to generate the progression
1 2 4 8 16, ...

class Progress {
public static void main(String args[]) {
for(int i = 1; i < 100; i += i)
System.out.print(i + " ");
}
}




10. The ASCII lowercase letters are separated from the uppercase letters by 32. Thus, to convert
a lowercase letter to uppercase, subtract 32 from it. Use this information to write a program
that reads characters from the keyboard. Have it convert all lowercase letters to uppercase,622 Java: A Beginner’s Guide
and all uppercase letters to lowercase, displaying the result. Make no changes to any other
character. Have the program stop when the user enters a period. At the end, have the program
display the number of case changes that have taken place.
// Change case.
class CaseChg {
public static void main(String args[])
throws java.io.IOException {
char ch;
int changes = 0;
System.out.println("Enter period to stop.");
do {
ch = (char) System.in.read();
if(ch >= 'a' & ch <= 'z') {
ch -= 32;
changes++;
System.out.println(ch);
}
else if(ch >= 'A' & ch <= 'Z') {
ch += 32;
changes++;
System.out.println(ch);
}
} while(ch != '.');
System.out.println("Case changes: " + changes);
}
}



*/
