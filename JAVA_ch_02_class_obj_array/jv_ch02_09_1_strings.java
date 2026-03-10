
// jv_ch02_09_1_strings                2.14        158.9-162.9


/* -=-=-=-=-=-=-=-=-=-=-=      Strings      -=-=-=-=-=-=-=-=-=-=-=

String defines and supports character strings. In Java, strings are objects. Constructing String is similar to constructing any other type of object: by using new and calling the String constructor. For example:
String str = new String("Hello");
	You can also construct a String from another String. Eg: Consider previous str,  String str2 = new String(str);
	Another easy way to create a String is:   String str = "Hello";     str is initialized to the character sequence " Hello "
	String object can be used anywhere that a quoted string is allowed. Eg: String object as an argument to println()
String str1 = new String("Java strings are objects.");
System.out.println(str1);
	6 methods to operate on strings: The String class contains several methods that operate on strings. The general forms for a few:
Names of Method	Description	String str1 = "Hello.";     String str2 = new String(str1);      String str3 = "You there !!";
boolean equals(str)	Returns true if the invoking string contains the same character sequence as str.	if(str1.equals(str2)) System.out.println("str1 = str2"); else return;
if(str1.equals(str3)) System.out.println("str1 = str3"); else return;
[str1.equals(str2) returns true, str1.equals(str3) returns false]
int length( )	Obtains the length of a string.	System.out.println("Length of str1: " + str1.length());
char charAt(index)	Obtains the character at the index specified by index.	// display str1, one char at a time.
for(int i=0; i < str1.length(); i++)  System.out.print(str1.charAt(i));
int compareTo(str)	-ve if invoking string < str, 
+ve if invoking string >  str, 
0 if invoking string =  str, 	int result = str1.compareTo(str3);
	if(result == 0) 	System.out.println("str1 = str3 ");
	else if(result < 0) 	System.out.println("str1 < str3");
	else 		System.out.println("str1 > str3");
int indexOf(str)	Searches the invoking string for the substring specified by str. Returns the index of the first match or –1 on failure.	
	str2 = "One Two Three One";		// assign a new string to str2
idx = str2.indexOf("One");
System.out.println("Index of first occurrence of One: " + idx);
idx = str2.lastIndexOf("One");
System.out.println("Index of last occurrence of One: " + idx);
int lastIndexOf(str)	Searches the invoking string for the substring specified by str. Returns the index of the last match or –1 on failure.	
	You can concatenate (join together) two strings using the + operator. For example,	String str1 = "One";          String str2 = "Two";          String str3 = "Three";     
String str4 = str1 + str2 + str3; //initializes str4 with the string "OneTwoThree".

Note:	Why don’t use == instead of equals():  equals() compares the character sequences of two String objects for equality. Applying the == to two String references simply determines whether the two references refer to the same object.
	Arrays of Strings: Like any other data type, strings can be assembled into arrays. For example:	String strs[] = { "This", "is", "a", "test." };    System.out.println("Original array: ");
for(String s : strs) System.out.print(s + " "); 	System.out.println("\n");
strs[1] = "was";	strs[3] = "test, too!"; 		// change a string
System.out.println("Modified array:"); for(String s : strs) System.out.print(s +" ");	output:
Original array:
This is a test.
Modified array:
This was a test, too!

*/
