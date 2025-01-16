
/* ------------    Chapter 3 Self Test    ------------


10. The ASCII lowercase letters are separated from the uppercase letters by 32. Thus, to convert
a lowercase letter to uppercase, subtract 32 from it. Use this information to write a program
that reads characters from the keyboard. Have it convert all lowercase letters to uppercase,
and all uppercase letters to lowercase, displaying the result. Make no changes to any other
character. Have the program stop when the user enters a period. At the end, have the program
display the number of case changes that have taken place.

*/



/* Example: 10. The ASCII lowercase letters are separated from the uppercase letters by 32. Thus, to convert
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


