
/* -=-=-=-=-=-=-=-=-=-=-=      SELECTIONs      -=-=-=-=-=-=-=-=-=-=-= 

    There are 3 types of control statements in JAVA:
        Selection Statements: 
            To choose different paths of execution based on certain conditions
                1. if
                2. if-else
                3. switch

        Iteration (Loop) Statements: 
            To execute a block of code multiple times
                1. for
                2. while
                3. do-while

        Jump Statements: 
            To break out of loops or skip to the next iteration of a loop
                1. break
                2. continue
                3. return




    ------------    if-else, Nested if, if-else-if ladder    ------------

    if, if-else:
        Everything is similar to C/C++. The general form of the if (if-else), using blocks of statements, is:

                        if(condition) {
                            statement sequence
                        }
                        else {
                            statement sequence
                        }

            '{}' isn't necessary for "single line statement" 
                but recommended for clarity and to avoid errors
            If the "conditional expression" is true, the TARGET of the 'if' will be executed; 
            Otherwise, the TARGET of the 'else' (if it exists) will be executed.
            The "conditional expression" controlling the 'if' must produce a boolean result

        Recall:
            C_Ch2_1_1_ctrl_stmnt_slct_1_ifElse.c
            C_Ch2_1_2_ctrl_stmnt_slct_2_ELIF.c


        Note:
            The "else" part is optional, without it, we get a simple 'if' statement    
            In Java "if(condition)" is used and in C/C++ "if(expression)" is used.
            In Java "condition" must be a "Boolean expression " which returns true/false value.
            But in C/C++, any non-zero value is considered true, and zero is false.



    Nested if:
        In a nested if-else, an "invisible block" appears around the nearest if-else of the same visible block.
            (Recall 'Example 2' of C/C++ C_Ch2_1_2_ctrl_stmnt_slct_2_ELIF.c)
            when {} not used an "else" connects to "nearest if". For example:

                    if(i == 10) { 
                        if(j < 20) a = b;
                        if(k > 100) c = d;  // Makes an if-else block.
                        else a = c;         // this else refers to if(k > 100)
                    }
                    else a = d;     // this else refers to if(i == 10)

        note:
            Useful when you have multiple conditions that need to be checked in a sequence.
            Proper indentation and use of braces {} are crucial to maintaining readability.

        Control Flow:
            The program evaluates the outer if condition first.
            If the outer if condition is true, the program then evaluates the inner if condition(s).
            This can continue to any number of levels, though "deep nesting" should be avoided for readability.

        Differences from C/C++:
            Java requires conditions to be explicitly "boolean" expressions.



    if-else-if ladder:
        Exactly same as C/C++ and "condition" must be used instead of "expression". 
            i.e. conditions must be "explicitly boolean", unlike C/C++ where any non-zero value can be true
        
        The if-else-if ladder is a sequence of if and else-if conditions used to "test multiple conditions".
            The program executes the first true condition (if found) and ignores the rest.
            The final else block (optional) act as default condition, catches any cases where none of the previous conditions were true.
            If there is no final else and all other conditions are false, no action will take place


        Control Flow:
            The program checks each if and else-if condition evaluated from the top downward
            The first block with a true condition is executed.
            If no conditions are true, and there's an else block, that block is executed.


        Differences from C/C++:
            conditions must be "explicitly boolean", unlike C/C++


    ----  Avoid Overuse  ----
    Overusing "nested if" statements and "if-else-if ladders" can make code harder to maintain. 
    In such cases, consider refactoring your code, possibly using "switch" or "polymorphism".




    ------------    switch    ------------

    (similar C/C++ switch . Recall C_Ch2_1_3_ctrl_stmnt_slct_3_switch.c)
    The switch statement is used for multi-way branching, where a variable is tested against a list of values.
        Each case value must be a "compile-time constant", and 
        The data types must match the switch expression's type.

        Frequently, the expression controlling a switch is simply a variable rather than a larger expression.
        Each value specified in the case statements must be a unique constant expression (such as a literal value).


    Control Flow:
        The program evaluates the "switch expression" and jumps to the matching case.
        If a case matches, the corresponding block of code is executed.
        Without a break, the program continues executing the next case statements (fall-through).
        The default case (optional) is executed if no other case matches.


    Fall-Through: To prevent "fall-through", a "break" statement is usually used to exit the switch block after a matching case is executed.
        But it is generally considered a bad practice unless intentionally used.
 

    Differences from C/C++:
        In C/C++ we used only "value" to control switch i.e. "switch(value){ }" where "value" must be "int" or "char" constant. 
        In Java we use "expression" i.e "switch(expression){ }", 
            Generally expression must be of the types: 'byte', 'short', 'int', 'char' or an 'enumeration'. 
            In JDK 7, expression can also be of type 'String' i.e. it allows String-object

        In Java, switch statements can work with int, char, short, byte, enum, String (since Java 7), and "boxed primitive types" like Integer, Character, etc.
        In C++, switch statements work with int, char, enum, and other types that can be implicitly converted to int. It does not support String.
    
        Handling of null in Java:
            Java switch statements throw a "NullPointerException" if a String is null. 
            C++ doesn't have this issue since it does not handle "String" types.


    ----  "stacking" of cases  ----
    You can have empty cases (Similar C/C++), as shown in this example:

            switch(i) {
                case 1:
                case 2:
                case 3: System.out.println("i is 1, 2 or 3"); break;
                case 4: System.out.println("i is 4"); break; 
            }

    In this fragment, if i has the value 1, 2, or 3, the first println() statement executes. 
    If it is 4, the second println() statement executes. 
    The "stacking" of cases, is common when several cases share common code.


    ----  Nested Switch: Similar to C/C++  ----
    The nesting level does not impact the functionality of a switch statement.
    You can nest as many switch statements as needed.

    Notes:
        Nested switches can reduce readability if overused or deeply nested.
        Separate break statements needed for each nested switch to prevent fall-through between cases. 
        Skipping break in the inner switch won’t break out of the outer switch.
        Default Case: Always include a default case in both the outer and inner switch to handle unexpected values and improve robustness.
        String in Switch: Be cautious of "null values" when using "String" in the switch, as it can cause runtime exceptions.




    ------------    NOTEs    ------------

    ----  NOTE: Efficiency Considerations  ----

        It's generally more efficient to place the most likely conditions first in the if-else-ladder

        Try to keep your nesting levels to a minimum by refactoring complex conditions into separate methods or using early returns
            Maintain consistent formatting and indentation

        Combining multiple conditions using logical operators (&& for AND, || for OR) 
            can sometimes simplify your "if structures" but be cautious of readability.

        The short-circuiting behavior of && and || can be leveraged for performance optimization 
            (e.g., avoiding expensive operations if the result is already determined).

        Use explicit null checks if String is used in "switch".

        Use the TERNARY operator (condition ? expr1 : expr2) instead of simple if-else conditions



    ----  NOTE: Switch Statement Facts  ----

        Fall-Through:
            Execution will continue to the next case if no 'break' is used. This is a common source of bugs and unexpected behavior

        Switch with enum Types:
            enum types are a natural fit for switch statements, providing both readability and safety

        Switch on Strings:
            Be aware that string comparisons in switch are "case-sensitive"
            String comparison in switch statements is generally more efficient than using multiple if-else-if checks

        Switch Fall-through Best Practices:
            If you are using fall-through intentionally, make sure to comment and document this behavior for readability
            If you want multiple cases to execute the same block of code, you can let them fall through intentionally (by omitting break) or group them together:

                        switch (day) {
                            case "MONDAY":
                            case "TUESDAY":
                                System.out.println("Weekday");
                                break;
                            case "SATURDAY":
                            case "SUNDAY":
                                System.out.println("Weekend");
                                break;
                            default:
                                System.out.println("Invalid day");
                        }

        Default case:
            Always include a default case in a switch statement, even if it’s just to handle exceptions

        Switch vs. If-Else Performance:
            Generally, switch statements can be faster than an equivalent if-else-if ladder, due to the way the bytecode is optimized by the JVM.

*/
       



/* Example 1: A simple computerized guessing game (version 1). 
                In this version of the game, the program asks the player for a letter between A and Z. 
                If the player presses the correct letter on the keyboard, 
                    the program responds by printing the message:   ** Right **
*/

class Guess {
    public static void main(String args[]) throws java.io.IOException {
        char ch, answer = 'K';

        System.out.println("I'm thinking of a letter between A and Z.");
        System.out.print("Can you guess it: ");
        ch = (char) System.in.read(); // read a char from the keyboard

        if(ch == answer) System.out.println("** Right **");
    }
}




/* Example 2: Guessing game (version 2) this version uses the else to print a message when the wrong letter is picked. */

class Guess2 {
    public static void main(String args[]) throws java.io.IOException {
        char ch, answer = 'K';

        System.out.println("I'm thinking of a letter between A and Z.");
        System.out.print("Can you guess it: ");
        ch = (char) System.in.read(); // get a char

        if(ch == answer) System.out.println("** Right **");
        else System.out.println("...Sorry, you're wrong.");
    }
}




/* Example 3: Guessing game (version 3) used nested-if-else to add a further improvement.
                Now provides the player with feedback about a wrong guess 
*/

class Guess3 {
    public static void main(String args[]) throws java.io.IOException {
        char ch, answer = 'K';

        System.out.println("I'm thinking of a letter between A and Z.");
        System.out.print("Can you guess it: ");

        ch = (char) System.in.read();   // get a char
        if(ch == answer) System.out.println("** Right **");
        else {
            System.out.print("...Sorry, you're ");
            // a nested if
            if(ch < answer) System.out.println("too low");
            else System.out.println("too high");
        }
    }
}




/* Example 4: The following program demonstrates the if-else-if ladder */

class Ladder {
    public static void main(String args[]) {
        int x;

        for(x=0; x<6; x++) {
            if(x==1) System.out.println("x is one");
            else if(x==2) System.out.println("x is two");
            else if(x==3) System.out.println("x is three");
            else if(x==4) System.out.println("x is four");
            else System.out.println("x is not between 1 and 4");    // default statement
        }
    }
}




/* Example 5: The following demonstrates a Nested Switch. */

class NestedSwitchExample {
    public static void main(String[] args) {
        int level = 1;
        int subject = 2;

        switch (level) {
            case 1:
                System.out.println("Level 1");
                switch (subject) {
                    case 1:
                        System.out.println("Math");
                        break;
                    case 2:
                        System.out.println("Science");
                        break;
                    default:
                        System.out.println("Unknown Subject");
                        break;
                }
                break;
            case 2:
                System.out.println("Level 2");
                break;
            default:
                System.out.println("Unknown Level");
                break;
        }
    }
}




/* Example 6: Here is a more complex example of a nested switch in Java: */

class NestedSwitchDemo {
    public static void main(String[] args) {
        int region = 1; // Let's say: 1 = North America, 2 = Europe
        int country = 1; // 1 = USA, 2 = Canada

        switch (region) {
            case 1:
                System.out.println("North America");
                switch (country) {
                    case 1:
                        System.out.println("USA");
                        break;
                    case 2:
                        System.out.println("Canada");
                        break;
                    default:
                        System.out.println("Unknown Country");
                }
                break;
            case 2:
                System.out.println("Europe");
                break;
            default:
                System.out.println("Unknown Region");
        }
    }
}




/* Example 7: Another program demonstrates the switch. Notice:

                Each time through the loop, the statements associated with the case constant that matches i are executed. 
                All others are bypassed. 
                When i is five or greater, no case statements match, so the default statement is executed
*/

class SwitchDemo {
    public static void main(String args[]) {
        int i;

        for(i=0; i<10; i++)
            switch(i) {
                case 0:
                    System.out.println("i is zero");
                    break;
                case 1:
                    System.out.println("i is one");
                    break;
                case 2:
                    System.out.println("i is two");
                    break;
                case 3:
                    System.out.println("i is three");
                    break;
                case 4:
                    System.out.println("i is four");
                    break;
                default:
                    System.out.println("i is five or more");
        }
    }
}




/* Example 8: (Demonstrate "Fall-Through") this program displays the following output, 
                since no "break" is used. It falls-through
                i.e., execution will continue into the next case if no break statement is present

                i is less than one
                i is less than two
                i is less than three
                i is less than four
                i is less than five

                i is less than two
                i is less than three
                i is less than four
                i is less than five

                i is less than three
                i is less than four
                i is less than five

                i is less than four
                i is less than five

                i is less than five
*/

// Demonstrate the switch without break statements.
class NoBreak {
    public static void main(String args[]) {
        int i;
        for(i=0; i<=5; i++) {
            switch(i){
                case 0:
                    System.out.println("i is less than one");
                case 1:
                    System.out.println("i is less than two");
                case 2:
                    System.out.println("i is less than three");
                case 3:
                    System.out.println("i is less than four");
                case 4:
                    System.out.println("i is less than five");
            }
            System.out.println();
        }
    }
}




/* Example 9: You can have empty cases, as shown in following example. 
                In this fragment, if i has the value 1, 2, or 3, the first println() statement executes. 
                If it is 4, the second println() statement executes. 

                The “stacking” of cases, as shown in this example, is common when several cases share common code.
*/
class EmptyCase {
    public static void main(String args[]) {
        int i;
        for(i=0; i<=5; i++) {
            switch(i){
                case 1:
                case 2:
                case 3: 
                    System.out.println("i is 1, 2 or 3");
                    break;
                case 4: 
                    System.out.println("i is 4");
                    break;
            }
            System.out.println();
        }
    }
}



