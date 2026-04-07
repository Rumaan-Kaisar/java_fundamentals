
// jv_ch02_09_1_strings                2.14        158.9-162.9


/* -=-=-=-=-=-=-=-=-=-=-=      Strings      -=-=-=-=-=-=-=-=-=-=-=

    In Java, strings are objects of "String" class (not primitive types)
    The "String" type objects defines and supports character strings.  

        java.lang.String

    String defines and supports character sequences in Java
    Part of the java.lang package (automatically imported)

    Constructing String:
        Method 1:
            similar to constructing any other type of object:
            by using "new" and calling the "String" constructor. 

            For example:
                        String str = new String("Hello");

        Method 2:
            You can also construct a String from another String.
            Eg: Consider previous str,  

                        String str2 = new String(str);

        Method 3:
            Another easy way to create a String is just assigning a String literal to a variable

                        String str = "Hello";     

            In this case, "str" is initialized to the character sequence "Hello"

    
    String objects can be used anywhere a "quoted string literal" is allowed
    Example: Passing String object as argument to println()

            String str1 = new String("Java strings are objects.");
            System.out.println(str1);



    ----------------    String Methods    ----------------

    The String class contains several methods that operate on strings. 
    Following are 6 methods to operate on strings: 

    Consider following strings:

        String str1 = "Hello.";
        String str2 = new String(str1);
        String str3 = "You there !!";


    boolean equals(String str):
        Returns true if the "invoking string" contains the same character sequence as "str".

            str1.equals(str2)   //true if same content

        For example:

            if(str1.equals(str2)) System.out.println("str1 = str2"); 
            else return;
            if(str1.equals(str3)) System.out.println("str1 = str3"); 
            else return;
        
        Output:
            str1.equals(str2) returns true, 
            str1.equals(str3) returns false

        Why don’t use == instead of equals():
            equals() "compares the character sequences" of two String objects for equality. 
            Applying the == to two String references simply determines 
                whether the two references refer to the "same object".


    int length():
        Obtains the length of a string (number of characters).

            str1.length() // 6 for "Hello."

        For example:

            System.out.println("Length of str1: " + str1.length());


    char charAt(int index):
        Obtains the character at the index specified by "index".

            str1.charAt(0) // 'H' for "Hello."

        For example:
            // display str1's one char at a time.
            for(int i=0; i < str1.length(); i++)  System.out.print(str1.charAt(i));


    int compareTo(String str):
        Compares the strings lexicographically.

        Negative:   invoking string < str
        Positive:   invoking string > str
        Zero:       strings equal

            str1.compareTo(str3)  // comparison result is -ve
        
        For example:
            int result = str1.compareTo(str3);

            if(result == 0) 
                System.out.println("str1 = str3");
            else if(result < 0) 
                System.out.println("str1 < str3");
            else
                System.out.println("str1 > str3");


    int indexOf(String str):
        Searches the invoking string for the substring specified by "str". 
        Returns the index of the first match or –1 on failure. 

            "One Two Three One".indexOf("One")  // 0

        For example:
            str2 = "One Two Three One";     // assign a new string to str2

            idx = str2.indexOf("One");
            System.out.println("Index of first occurrence of One: " + idx);

            idx = str2.lastIndexOf("One");
            System.out.println("Index of last occurrence of One: " + idx);


    int lastIndexOf(String str):
        Searches the invoking string for the substring specified by "str". 
        Returns the "index of the last match" or –1 on failure. 

            "One Two Three One".lastIndexOf("One")  // 14


----  rev[07-Apr-2026]  ----

----------------    String Concatenation    ----------------

You can concatenate (join together) two strings using the + operator.
Works with literals, variables, and expressions
Automatically converts "non-string" operands to strings during concatenation

For example:
            String str1 = "One";
            String str2 = "Two";
            String str3 = "Three";
            
            //initializes str4 with the string "OneTwoThree".
            String str4 = str1 + str2 + str3;   




----------------    Arrays of Strings    ----------------

   Arrays of Strings: Like any other data type, strings can be assembled into arrays. For example: String strs[] = { "This", "is", "a", "test." };    System.out.println("Original array: ");
for(String s : strs) System.out.print(s + " ");     System.out.println("\n");
strs[1] = "was";    strs[3] = "test, too!";         // change a string
System.out.println("Modified array:"); for(String s : strs) System.out.print(s +" ");   output:
Original array:
This is a test.
Modified array:
This was a test, too!



--------  Qwen  --------

Java Strings - Organized Notes















Code Examples:
java
12345678910111213141516171819202122232425

String str1 = "Hello.";
String str2 = new String(str1);
String str3 = "You there !!";

// equals()
if(str1.equals(str2)) System.out.println("str1 = str2");  // ✓ Executed
if(str1.equals(str3)) System.out.println("str1 = str3");  // ✗ Skipped

// length()
System.out.println("Length of str1: " + str1.length());  // Output: 6


// charAt() - print one char at a time
for(int i=0; i < str1.length(); i++)
    System.out.print(str1.charAt(i));  // Output: Hello.

// compareTo()
int result = str1.compareTo(str3);
if(result == 0) System.out.println("str1 = str3");
else if(result < 0) System.out.println("str1 < str3");
else System.out.println("str1 > str3");

// indexOf() / lastIndexOf()
String str2 = "One Two Three One";
int idx = str2.indexOf("One");        // 0
int idxLast = str2.lastIndexOf("One"); // 14




🔹 String Concatenation




== vs equals()
Operator/Method
What It Compares
Use Case

==
Reference equality (memory address)
Checks if two references point to the same object

equals()
Content equality (character sequence)
Checks if two strings have the same characters


java
1234567
String a = new String("Hello");
String b = new String("Hello");
String c = a;

a == b      // false (different objects)
a.equals(b) // true  (same content)
a == c      // true  (same reference)

✅ Always use equals() to compare String content


🔹 Arrays of Strings
Strings can be stored in arrays like any other data type
Declaration & Initialization:

String strs[] = { "This", "is", "a", "test." };


Iterating & Modifying:

// Print original array
System.out.println("Original array: ");
for(String s : strs) System.out.print(s + " ");
// Output: This is a test.

// Modify elements
strs[1] = "was";
strs[3] = "test, too!";

// Print modified array
System.out.println("Modified array:");
for(String s : strs) System.out.print(s + " ");
// Output: This was a test, too!


🔹 Quick Reference Summary
✅ Creating Strings: Use literals ("text") for simplicity; new String() when explicit object creation needed
✅ Comparing: Always use .equals() for content, never ==
✅ Common Methods: length(), charAt(), indexOf(), compareTo(), equals()
✅ Concatenation: Use + operator
✅ Arrays: String[] arr = {...}; access/modify via index

💡 Pro Tip: Strings are immutable in Java — any operation that appears to modify a string actually creates a new String object.



*/
