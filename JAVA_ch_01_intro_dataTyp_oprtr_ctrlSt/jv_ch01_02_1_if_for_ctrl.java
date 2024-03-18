
/*  -=-=-=-=-=-=-=-=-=-=-=      selection statements & loops (intro)      -=-=-=-=-=-=-=-=-=-=-= 
    
    ------------    Selection statements    ------------
                        1. if
                        2. if-else
                        3. nested-if
                        4. if-else-if
                        5. switch-case
                        6. jump – break, continue, return

    IF conditional:
                    if(condition){ 
                        statement block 
                    } 

        IF condition is one of JAVA's selection statements




    ------------    LOOPs    ------------
    In Java there are three primary types of loops: for, while, do-while:
                        1. for loop
                        2. Enhanced for loop
                        3. while loop
                        4. do-while loop

    FOR loop:
                    for(initialization; condition; iteration){
                        statement block
                    }

        condition:  is a boolean statement, 
                    i.e. 'true' or 'false'
        No ";" after statement block's "}". 
        "statement block" and others are exactly same as C/C++.


*/




/* Example 1: Following demonstrate 'IF statement' */
public class jv_ch01_02_1_if_ctrl{
    public static void main(String args[]){

        // ----------------------  IF statement  ----------------------  

        // ----  single line IF-statement  ----
        if(10 < 11) System.out.println("10 is less than 11");
        if(10 > 11) System.out.println("This won't be printed");

        
        int a, b, c;
        a = 2;
        b = 3;
        int u = 0;  // a Global variable must be initialized in java 

        // ----  Using Block with IF-statement  ----
        if(a < b){
            System.out.println("a is less than b");
            int v = a / b;  // Here v is a local variable
            System.out.println("Vlue of v: "+ v);

            u = a * b;
            a = 0;
        } 
        System.out.println("a: "+ a);
        System.out.println("Vlue of u: "+ u);

    }
}
// Note: using online compiler, use 'Main' insted of 'jv_ch01_02_1_if_ctrl' as file naming




/* Example 2: Here is a program that illustrates the if statement: */

// Demonstrate the if. Call this file 'IfDemo.java'.
class IfDemo {
    public static void main(String args[]) {
        int a, b, c;

        a = 2;
        b = 3;

        if(a < b) System.out.println("a is less than b");
        // this won't display anything
        if(a == b) System.out.println("you won't see this");

        System.out.println();   // print a blank line
        
        c = a - b; // c contains -1
        System.out.println("c contains -1");

        if(c >= 0) System.out.println("c is non-negative");
        if(c < 0) System.out.println("c is negative");
        System.out.println();

        c = b - a; // c now contains 1
        System.out.println("c contains 1");
        if(c >= 0) System.out.println("c is non-negative");
        if(c < 0) System.out.println("c is negative");
    }
}




/* Example 3: Following demonstrate 'FOR-loop' */
public class jv_ch01_02_1_for_ctrl{
    public static void main(String args[]){
        int count;

        // single line
        for(count = 0; count < 5; count = count+1) System.out.println("This is count: " + count);
        System.out.println("Done!");
        System.out.println();

        // block
        for(int i = 5; i > 0; i--){
            System.out.println("This is i: " + i);
        }
        System.out.println("Block is Done!");
    }
}




/* Example 4: Following demonstrate "Block of codes"
                Call this file BlockDemo.java.
*/
class BlockDemo {
    public static void main(String args[]) {
        double i, j, d;
    
        i = 5;
        j = 10;
    
        // the target of this if is a block
        if(i != 0) {
            System.out.println("i does not equal zero");
            d = j/i;
            System.out.println("j / i is " + d);
        }
    }
}




/* Example 5: Does the use of a code block introduce any 'run-time inefficiencies'? 
                In other words, does Java actually execute the '{' and "}"?

                Ans: No. Code blocks do not add any overhead whatsoever. 
                    In fact, because of their ability to simplify the coding of certain algorithms, 
                    their use generally increases speed and efficiency.

                    Also, the { and } exist only in your program’s source code. 
                        Java does not, per se, execute  the { or }

                However, blocks of code have additional properties and uses.
                The main reason for their existence is to create logically inseparable units of code 
*/




/* Example 6: Improving the Gallons-to-Liters Converter
                    use the for loop, 
                    the if statement, and 
                    code blocks

                This new version will print a table of conversions, 
                    beginning with 1 gallon and ending at 100 gallons.

                After every 10 gallons, a blank line will be output. 

                This is accomplished through the use of a variable called 'counter' 
                    that counts the number of lines that have been output.
*/

// This program displays a conversion table of gallons to liters.
class GalToLitTable {
    public static void main(String args[]) {
        double gallons, liters;
        int counter;

        counter = 0;
        for(gallons = 1; gallons <= 100; gallons++) {
            liters = gallons * 3.7854; // convert to liters
            System.out.println(gallons + " gallons is " + liters + " liters.");
            counter++;
            // every 10th line, print a blank line
            if(counter == 10) {
                System.out.println();
                counter = 0; // reset the line counter
            }
        }
    }
}




/* Example 7. Show the general form of the "if" statement. Show the general form of the "for loop". 

                The general form of the "IF":
            
                    if(condition) statement;
            
                    
            
                The general form of the "FOR":
            
                    for(initialization; condition; iteration) statement;

*/




/* Example 8. How do you create a block of code?
                A block of code is started with a { and ended with a }. 
*/




/* Example 9: Adapt "Example 6" so that it prints a conversion table of 'inches to meters'. 
                Display 12 feet of conversions, inch by inch. 

                Output a blank line every 12 inches. 
                (HINT: One meter equals approximately 39.37 inches.) 
*/

// This program displays a conversion table of inches to meters.

class InchToMeterTable {
    public static void main(String args[]) {
        double inches, meters;
        int counter;

        counter = 0;    // line counter
        for(inches = 1; inches <= 144; inches++) {
            meters = inches/39.37;  // convert to meters
            System.out.println(inches + " inches is " + meters + " meters.");
            counter++;
            // every 12th line, print a blank line
            if(counter == 12) {
                System.out.println();
                counter = 0; // reset the line counter
            }
        }
    }
}


