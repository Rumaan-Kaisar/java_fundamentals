
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
        Everything is similar to C/C++. The general form of the if, using blocks of statements, is:

                        if(condition) {
                            statement sequence
                        }
                        else {
                            statement sequence
                        }

            '{}' isn't necessary for "single line statement"
            If the "conditional expression" is true, the TARGET of the 'if' will be executed; 
            otherwise, the TARGET of the 'else' (if it exists) will be executed.
            The "conditional expression" controlling the 'if' must produce a boolean resul

        Recall:
            C_Ch2_1_1_ctrl_stmnt_slct_1_ifElse.c
            C_Ch2_1_2_ctrl_stmnt_slct_2_ELIF.c


        Note:
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



----  rev[12-Seop-2024]  ----


    if-else-if ladder:
        Exactly same as C/C++ and "condition" must be used instead of "expression". Last else act as default condition. 



1.20 Switch statement(similar C/C++ switch . Recall C/C++ 2.17)
In C/C++ we used only value to control switch i.e. "switch(value){ }" where value must be int or char constant. In Java we use "expression" i.e "switch(expression){ }", generally expression must be of the types: byte, short, int, char or an enumeration. In JDK 7, expression can also be of type String. This means that modern versions of Java can use a string to control a switch. 
	Frequently, the expression controlling a switch is simply a variable rather than a larger expression.
	Each value specified in the case statements must be a unique constant expression (such as a literal value).
	You can have empty cases (Recall C/C++ 2.17 Note 8), as shown in this example:
switch(i) { 	case 1:
case 2:
case 3: System.out.println("i is 1, 2 or 3"); break;
case 4: System.out.println("i is 4"); break; }
In this fragment, if i has the value 1, 2, or 3, the first println() statement executes. If it is 4, the second println() statement executes. The “stacking” of cases, as shown in this example, is common when several cases share common code.
	Nested Switch: Similar to C/C++ 2.18 Nested switch.


*/


/*  

GPT: give important points to remember, important facts / aspects following in JAVA. Also control-flow mechanism of following in Java and difference from C/C++. 
if-else
Nested if
if-else-if ladder
Switch statement


1. if-else Statement in Java:
Important Points:
The if statement evaluates a boolean expression and executes a block of code if the expression is true.
The else part is optional and provides an alternative block of code to execute if the if condition is false.
Curly braces {} are optional for a single statement but recommended for clarity and to avoid errors.
Control Flow:
If the condition in the if statement is true, the program executes the code inside the if block.
If the condition is false, and if there's an else block, the program executes the code inside the else block.
Differences from C/C++:
Boolean Expressions: In Java, the condition in an if statement must be a boolean expression (i.e., something that evaluates to true or false). In C/C++, any non-zero value is considered true, and zero is false.
2. Nested if Statements in Java:
Important Points:
Nested if statements refer to having one if statement inside another.
Useful when you have multiple conditions that need to be checked in a sequence.
Proper indentation and use of braces {} are crucial to maintaining readability.
Control Flow:
The program evaluates the outer if condition first.
If the outer if condition is true, the program then evaluates the inner if condition(s).
This can continue to any number of levels, though deep nesting should be avoided for readability.
Differences from C/C++:
Java's nested if statements work similarly to C/C++, with the primary difference being that Java requires conditions to be explicitly boolean expressions.
3. if-else-if Ladder in Java:
Important Points:
The if-else-if ladder is a sequence of if and else-if conditions used to test multiple conditions.
The program executes the first true condition and ignores the rest.
The final else block (optional) catches any cases where none of the previous conditions were true.
Control Flow:
The program checks each if and else-if condition in order.
The first block with a true condition is executed.
If no conditions are true, and there's an else block, that block is executed.
Differences from C/C++:
Again, Java requires conditions to be explicitly boolean, unlike C/C++ where any non-zero value can be true.
4. switch Statement in Java:
Important Points:
The switch statement is used for multi-way branching, where a variable is tested against a list of values.
Each case value must be a compile-time constant, and the data types must match the switch expression's type.
A break statement is usually used to exit the switch block after a matching case is executed, to prevent "fall-through" (executing subsequent cases).
Control Flow:
The program evaluates the switch expression and jumps to the matching case.
If a case matches, the corresponding block of code is executed.
Without a break, the program continues executing the next case statements (fall-through).
The default case (optional) is executed if no other case matches.
Differences from C/C++:
Expression Types: Java switch statements can switch on byte, short, char, int, enum, String, and since Java 7, String values as well. In C/C++, only integral types are allowed.
String in Switch: Unlike C/C++, Java allows String objects in the switch expression.
Break Statement: Like in C/C++, forgetting a break statement in a switch can lead to fall-through, but it is generally considered a bad practice unless intentionally used.
General Advice:
Readability: Use proper indentation and avoid deep nesting when possible to keep code readable.
Avoid Overuse: Overusing nested if statements and if-else-if ladders can make code harder to maintain. In such cases, consider refactoring your code, possibly using switch or polymorphism.
Fall-through in switch: Be cautious with fall-through in switch statements. Always use a break statement unless fall-through is intended.




are there any other important facts to remember?
ChatGPT said:
ChatGPT
Certainly! Here are some additional important facts to remember regarding if-else, nested if, if-else-if ladder, and switch statements in Java:

Additional Important Facts
1. General Facts for if-else, nested if, and if-else-if ladder:
Efficiency Considerations:

The if-else-if ladder is evaluated sequentially from top to bottom, so it's generally more efficient to place the most likely conditions first.
Deeply nested if statements can lead to code that is difficult to read and maintain. Consider using early returns, switch statements, or even refactoring your logic into separate methods to improve clarity.
Boolean Logic:

Combining multiple conditions using logical operators (&& for AND, || for OR) can sometimes simplify your if structures but be cautious of readability.
The short-circuiting behavior of && and || can be leveraged for performance optimization (e.g., avoiding expensive operations if the result is already determined).
Null Checks:

Always ensure that objects being checked in conditions are not null to avoid NullPointerException. Use explicit null checks, or consider using Objects.equals() for safe equality checks.
Ternary Operator:

For simple if-else conditions, the ternary operator (condition ? expr1 : expr2) can be a concise alternative, though it should be used carefully to avoid reducing code readability.
2. Switch Statement Specific Facts:
Fall-Through:

By default, Java switch cases fall through, meaning that if you don’t include a break statement at the end of a case, execution will continue to the next case. This is a common source of bugs and unexpected behavior.
Intentionally allowing fall-through can be useful in some scenarios but should be clearly documented to avoid confusion.
Switch with enum Types:

enum types are a natural fit for switch statements, providing both readability and safety (since the compiler can warn you if you miss any enum constants).
Switch on Strings:

Since Java 7, switch statements support String as an argument. This is useful for string-based decisions, but be aware that string comparisons in switch are case-sensitive.
String comparison in switch statements is generally more efficient than using multiple if-else-if checks, especially for a large number of string cases.
Switch Fall-through Best Practices:

If you want multiple cases to execute the same block of code, you can let them fall through intentionally (by omitting break) or group them together:
java
Copy code
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
3. Performance Considerations:
Switch vs. If-Else:
Generally, switch statements can be faster than an equivalent if-else-if ladder, especially when there are many cases to evaluate, due to the way the bytecode is optimized by the JVM.
However, the choice between switch and if-else should primarily be driven by readability and maintainability rather than performance.
4. Best Practices for Readability and Maintenance:
Avoid Deep Nesting:

Try to keep your nesting levels to a minimum by refactoring complex conditions into separate methods or using early returns.
Document Fall-through Cases:

If you are using fall-through in switch statements intentionally, make sure to comment and document this behavior to make it clear to others reading your code.
Consistent Formatting:

Maintain consistent formatting and indentation across all control structures (if-else, switch, etc.) to enhance readability.
Default Case:

Always include a default case in a switch statement, even if it’s just to handle unexpected values or errors.
5. Null Safety:
Switch Statements:
Be cautious when using String in switch statements—null values will cause a NullPointerException. Ensure that the String being switched on is not null.
By keeping these facts and best practices in mind, you'll be better prepared to write clear, efficient, and error-free control structures in Java.
*/



