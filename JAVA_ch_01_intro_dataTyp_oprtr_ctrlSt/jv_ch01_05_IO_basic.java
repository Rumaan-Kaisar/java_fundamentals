
/* -=-=-=-=-=-=-=-=-=-=-=      Keyboard input      -=-=-=-=-=-=-=-=-=-=-= 


Input Characters from the Keyboard:
To read a character from the keyboard, we will use System.in.read().  
By default, console input is line buffered.


System.in is the input object attached to the keyboard. 
The read() method waits until the user presses a key and then returns the result.  
The character is returned as an integer, so it must be cast into a char to assign it to a char variable.  (Not useful for int)

[Here, the term buffer refers to a small portion of memory that is used to hold the characters before they are read by your program. In this case, the buffer holds a complete line of text. As a result, you must press ENTER before any character that you type will be sent to your program. ]


	Notice that  main()  begins like this: 	public static void main(String args[])
throws java.io.IOException {
Because System.in.read() is being used, the program must specify the throws java.io.IOException clause. This line is necessary to handle input errors. It is part of Java’s Exception Handling mechanism.

Note:  Real-world Java programs and applets will be graphical and window based, not console based. So keyboard use isn't popular.

*/

/* Example 1: Here is a program that reads a character from the keyboard: */
class KbIn {
    public static void main(String args[]) throws java.io.IOException{
        char ch;
        
        System.out.print("Press a key followed by ENTER: ");
        ch = (char) System.in.read(); 	// get a char. Read a character from the keyboard.
        System.out.println("Your key is: " + ch); 	
    } 
}



