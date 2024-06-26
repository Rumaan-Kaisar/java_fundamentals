
/*  -=-=-=-=-=-=-=-=-=-=-=      String literals      -=-=-=-=-=-=-=-=-=-=-=

    String literals 
        In Java string is always inside double quotes "". 
        And character constant is inside single quotes ' '. So 'k' and "k" are not the same. 
        'K' is for "character constant" and "K" is for "character string". 


    --------------- character literals : single quote ----------------
    '' vs ""
        '' is used for single character or charcter constants
                char ch_dmo = 'b'; 
        "" used for strings
                "this is a test"
        similar to C++

        You must not confuse STRINGS with CHARACTERS. 
            A character literal represents a single letter of "type char". Eg: 'a'
            
        A string containing only one letter is still a string.
            Although strings consist of characters, they are not the same type. Eg. "a"

          

    --------------- character literals : escape sequence ----------------
    To print escape sequnces for \', \", \\, \r, \n, \t, \b, \f, \ddd etc use single quotes ''
        For example, this assigns ch the tab character:
            ch = '\t';
        
        The next example assigns a single quote to ch:
            ch = '\'';
        


    --------------- string literals : double quote ----------------
    A string is a set of characters enclosed by double quotes. For example, "this is a test"
        String str;
        str = "First line\nSecond line";
        System.out.println(str);  

        Notice how the "\n" escape sequence is used to generate a new line. 
        You don't need to use multiple println( ) statements to get multiline output.

    Use '\n' to generate a new line.
    Use tabs '\t' to align output.
*/




/* Example 1: Following program uses the \n and \t escape sequences. */

// Demonstrate escape sequences in strings.
class StrDemo {
    public static void main(String args[]) {
        // --------------- string literals : single quote ----------------
        // A string is a set of characters enclosed by double quotes. For example, "this is a test"
        String str;

        str = "First line\nSecond line";
        System.out.println(str);
        System.out.println("A\tB\tC");
        System.out.println("D\tE\tF");

        // --------------- character literals : single quote ----------------
        char ch_dmo = 'b'; 
        System.out.println("ch_dmo is " + ch_dmo);
    }
}




// ------------    int to String conversion    ------------

/* Example 2: We saw that in previous section the Hexadecimal, Octal, and Binary literals  
                ouput as "deciaml" by System.out.println() 

                following program first converts "octal 16 to decimal"
                then it converts the result to hexadecimal and outputs eqivalent decimal value.
                It also converts a hexadecimal value to decimal
*/

public class StringLiteral{
    public static void main(String[] args) {        
        // --------------- Hexadecimal, Octal, and Binary literals ----------------
        int hex = 0xFF; // 255 in decimal
        System.out.println("hex is " + hex);

        int oct = 011; // 9 in decimal
        System.out.println("oct is " + oct);

        // specify an integer literal by use of binary: precede the binary number with a 0b or 0B.
        //  For example, this specifies the value 12 in binary:
        int binr = 0b1100;
        System.out.println("binr is " + binr);

        // Octal, Hexa decimal, Binary
        /* Convert int to String: 
            Using toString() method of "Integer" class
            Using valueOf() method of "String" class 
        */
        int octl = 016;
        // Octal is coverted to Decimal "by using radix:10" during data-type-conversion to String
        String octStr = Integer.toString(octl, 10); // gives 14 in decimal: equivalent to 16 in octal 
        System.out.println("Converted num: "+octStr);   
        System.out.println("Type of octStr: "+octStr.getClass().getName()+"\n");

        // The Integer.parseInt() method converts a string to an int with the given radix
            // following converts string "14" to decimal considerinh 14 as a hexadecimal
        int hexd = Integer.parseInt(octStr, 16);    // gives 20 in decimal: equivalent to 14 in Hexadecimal
        // preceeding line takes the String value as a Hexadecimal number and converts it to Decimal
        // parseInt(octStr, 16)  consideres the number-string octStr in Hexadecimal
        System.out.println("Converted dec num to hexd: "+hexd);

        int hex2 = 0x20;
        String hexStr = Integer.toString(hex2, 10); 
        System.out.println("Converted num: "+hexStr);   // gives 32 in decimal: equivalent to 20 in Hexadecimal
        // String hexStr = Integer.toString(hex2, 16); // remains same; Hexadecimal to Hexadecimal 
    }
}




// ------------    String to int conversion    ------------


/*  Example 3: We know that Integer.parseInt() converts a string to an int with the given radix (or base).
                Write a program that converts a given number (input by a user) to 
                        binary, 
                        octal, and 
                        hexadecimal bases.

                Store each one of those in variables.
                Get the object type of each.
                Convert each from String to int.
*/

import java.util.Scanner;

public class NumberConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number from user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Convert to binary, octal, and hexadecimal
        String binary = Integer.toBinaryString(number);
        String octal = Integer.toOctalString(number);
        String hexadecimal = Integer.toHexString(number);

        // Print the converted values
        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hexadecimal);

        // Get the object type of each converted value
        String binaryType = binary.getClass().getName();
        String octalType = octal.getClass().getName();
        String hexadecimalType = hexadecimal.getClass().getName();

        // Convert each from String to int
        int binaryInt = Integer.parseInt(binary, 2);
        int octalInt = Integer.parseInt(octal, 8);
        int hexadecimalInt = Integer.parseInt(hexadecimal, 16);

        // Print the object type of each converted value
        System.out.println("Type of binary: " + binaryType);
        System.out.println("Type of octal: " + octalType);
        System.out.println("Type of hexadecimal: " + hexadecimalType);

        // Print the converted values
        System.out.println("Binary to int: " + binaryInt);
        System.out.println("Octal to int: " + octalInt);
        System.out.println("Hexadecimal to int: " + hexadecimalInt);

        scanner.close();
    }
}

