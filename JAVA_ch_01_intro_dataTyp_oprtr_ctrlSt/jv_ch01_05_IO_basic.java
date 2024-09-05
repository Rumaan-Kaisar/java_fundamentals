
/* -=-=-=-=-=-=-=-=-=-=-=      Keyboard input      -=-=-=-=-=-=-=-=-=-=-= 
    
    Input Characters from the Keyboard:
        To read a character from the keyboard, we will use
            
                System.in.read()

        By default, console input is line buffered.


        "System.in" is the "input object" attached to the keyboard. "System.in" is the complement to "System.out"
        The read() method waits until the user "presses a key" and then "returns" the result
        The "character" is returned as an "int", so it must be "cast into a char" to assign it to a "char" variable

        In this case, the buffer collects the entire line of text you type. 
            You need to press ENTER for the program to receive and process what you've typed.


        Buffer:
            In simple terms, a buffer is like a temporary storage area in your computer's memory. 
            
            When you type something on the keyboard, the characters you type are 
                first collected in this storage area, or "buffer," before they are sent to your program.
            
            You can think of a buffer as a "waiting room" for the data you enter, 
                where it stays temporarily until it's ready to be used by your program.

            For example, when you're typing on the console, the characters you enter don't go directly to your program one by one. 
                Instead, they are stored in the buffer until you press the ENTER key. 


    Note:
        Real-world Java programs and applets will be graphical and window based, not console based. So keyboard use isn't popular.
*/




/* Example 1: Here is a program that reads a character from the keyboard: 

                IO Exception Handling: 
                    Notice the usage of "java.io.IOException" that main() begins like this: 	

                        public static void main(String args[]) throws java.io.IOException {

                    Because System.in.read() is being used, the program must specify the "throws java.io.IOException clause"
                    This line is necessary to "handle Input Errors". It is part of Java’s Exception Handling mechanism.
*/

class KbIn {
    public static void main(String args[]) throws java.io.IOException{
        char ch;
        
        System.out.print("Press a key followed by ENTER: ");
        // notice the cast
        ch = (char) System.in.read(); 	// get a char, Read a character from the keyboard
        System.out.println("Your key is: " + ch); 	
    } 
}


/* The fact that "System.in" is Line-Buffered is a "source of ANNOYANCE" at times. 

    When you press ENTER, a carriage return, "line feed sequence" is entered into the "input stream". 

    Furthermore, these characters are left "pending" in the input buffer "until you read them". 
        In some case, you may need to remove them (by reading them) before the next input operation.

*/


