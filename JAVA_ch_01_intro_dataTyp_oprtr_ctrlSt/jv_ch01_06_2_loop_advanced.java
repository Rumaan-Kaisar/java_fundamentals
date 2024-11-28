
/* -=-=-=-=-=-=-=-=-=-=-=      LOOPS      -=-=-=-=-=-=-=-=-=-=-= 

    ----  Usage  ----
    FOR:        Use a FOR loop when the number of iterations is known in advance.
    DO-WHILE:   Use a DO-WHILE loop when the loop must execute at least once.
    WHILE:      Use a WHILE loop when the number of iterations is unknown and depends on a condition.

    
    ------------    FOR loop    ------------
    Following are the most traditional forms of the for

        Repeats a single statement:

            for(initialization; condition; iteration) statement;


        Repeats a block (similar to C/C++):

                for(initialization; condition; iteration){
                    // statement sequence
                }

            Initialization: 
                Sets the starting value of the loop control variable (often a counter that controls the loop)
                It is usually an assignment statement. Executed once at the beginning

            Condition: 
                A "Boolean expression" that checks if the loop should continue
                checked before each iteration; loop runs as long as it's true

            Iteration: 
                Defines how the loop control variable changes after each loop cycle
                performed after each loop body execution

            Semicolons: The three sections (initialization, condition, iteration) are separated by semicolons

            For loop can proceed in a positive or negative fashion (increment & decrement), 
                and it can change the loop control variable by any amount.


    ------------    FOR-Loop Variations    ------------

    Multi Loop-Control Var:
        Any number of "initialization" and "iteration" are possible
        "Commas" separate multiple initialization and iteration statements
        But, more than two or three make the the loop complicated

            for(i=0, j=10; i<j; i++, j--) {
                System.out.println("i and j: " + i + " " + j);
            }

        When the loop begins, both i and j are initialized.
        Each time the loop repeats, i is incremented and j is decremented in each iteration.


    Boolean Condition Control:
        The loop-condition can be any valid Boolean expression, not just related to the loop control variable.
        Eg: the loop continues until the user types the letter 'S' at the keyboard:

            for(i = 0; (char)System.in.read() != 'S'; i++) {
                System.out.println("Pass #" + i);
            }


    BLANK Sections in for Loop:
        Any part (initialization, condition, iteration) of a for loop can be left blank

            for(i=0; i<10;) { 
                System.out.println("Pass #" + i);
                i++;    // Increment inside the loop body
            }

        Outer initialization:
            Initialization portion can be moved outside of the for:

                int i = 0; 				// move initialization out of loop
                for( ; i<10 ; ) {
                    System.out.println("Pass #" + i);
                    i++;
                }  

        No increment (indefinite run):
            for(i=0;  (char)System.in.read() != 'S';  ) System.out.println("Again");

        Infinite Loop:
            To create an infinite loop use the for by leaving the conditional expression empty. Eg:

                for(;;){ } // intentionally infinite loop

            This loop will run forever. (It can be terminated by using the break statement.)


    Loops with No Body:
        The body of a FOR-loop can be "empty" if all the logic is handled within the loop declaration.
        EG: This loop sums numbers from 1 to 5, but there’s no body for the loop.

                for(i = 1; i <= 5; sum += i++);

        Notice that the summation process is handled entirely within the FOR statement, and no body is needed. 
            Pay special attention to the iteration expression: 	sum += i++; 
            It is equivalent to:    sum = sum + i; i++;


    Declaring Variables Inside for Loop:
        Loop control variables can be "declared" inside the loop (if it's not used elsewhere).
        In this case, we declare the variable inside the initialization portion of the FOR. Eg:

                int sum = 0, 
                fact = 1;

                for(int i = 1; i <= 5; i++) { 	// notice the initialization of i
                    sum += i; 	// i is known throughout the loop
                    fact *= i; 
                }

            In this example, i cannot be accessed outside the for loop
            If you need to use the loop variable "i" elsewhere in your program, don't declare it inside the for loop
            The scope (or lifetime) of i is limited to the for loop. Once the loop ends, i no longer exists


    The Enhanced for Loop:
        Java offers an enhanced for loop for "iterating over collections" like arrays.
        We'll discuss it more thoroughly in the next chapter when we cover arrays.
        
                for (int element : array) {
                    // body of loop
                }
        
        You can only use it to read data, not modify the collection
        Iterates through each element of the collection without requiring an "index".
        It's particularly useful for iterating over arrays, ArrayList, HashSet, and other collection types in Java.
        Not present in C/C++.

        EG: used for arrays

                int[] numbers = {1, 2, 3, 4, 5};

                for(int num : numbers) {
                    System.out.println(num);
                }



    ------------    WHILE and DO-WHILE loop    ------------

    WHILE Loop: 
        Same behavior in both Java and C/C++.

                while(condition) {
                    // statements
                }

        The loop evaluates the condition before executing the body.
            i.e. if the condition is false at the start, the loop is never executed
        
        Like the for loop, the while loop checks its condition at the start, so the loop may not run at all. 
            This removes the need for a separate pre-check before the loop.


        Infinite Loop using while:

                while(true) {
                    // infinite loop
                }



    DO-WHILE Loop:
        Similar to C/C++.

                do {
                    // statements
                } while(condition);

        The body is executed before the condition is checked.
        The body of the loop will always be executed at least once, 
            even if the condition is false on the first evaluation.



    ------------    Nested Loops    ------------
            
    Nested Loops:
        One loop can be nested inside of another.
        Similar in Java and C/C++.
        
        Eg: To find factors of numbers we can use nested FOR-loops

            for(int i=2; i <= 100; i++){ 
                System.out.print("Factors of " + i + ": ");
                for(int j=2; j<i; j++) if((i%j) == 0) System.out.print(j + " ");
                System.out.println(); 
            }

        You can nest FOR, WHILE, and DO-WHILE loops.
        Loops are executed from the outermost to innermost, 
            with the "inner loop" completing all its iterations for each iteration of the "outer loop".



    ------------    Variable Scoping in LOOPs    ------------

    Similar in Java and C++:
        variables declared in a loop can have a "different scope" depending on how they are declared.

        If you declare a variable "inside a loop or block", it will have the "block-level scope"
            that the variable is only accessible within that specific block (the code enclosed by {} where it was declared). 

                    for (int i=0; i<5; i++) {
                        System.out.println(i); // 'i' is accessible here
                    }
                    // 'i' is no longer accessible here

        If we declare variables outside of loops or blocks, giving them broader scope,
            so they remain accessible outside the loop or block they were used in.

                    int i;
                    for (i = 0; i < 5; i++) {
                        std::cout << i << std::endl; // 'i' is accessible here
                    }
                    // 'i' is still accessible here because it was declared outside the loop




    --------  Notes  --------

    Type Promotion and Casting in Loops:
        In Java, arithmetic on smaller data types (like byte, char, short) promotes them to "int" in expressions. 
        To assign the result back to a smaller type, an "explicit cast" is needed.

                byte b = 1;
                for(int i = 0; i < 10; i++) {
                    b = (byte) (b + 1); // Requires explicit cast, as result is promoted to int
                }


    break and continue:
        break exits the nearest enclosing loop entirely
        continue skips the current iteration of the loop and proceeds to the next iteration

        Labeled break and continue: 
            Use labels with break and continue to break or continue "outer multiple loops". 
            Doesn't exist in C/C++

        Example (Labeled break):

                outerLoop:
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (j == 1) {
                            break outerLoop;  // Exits both loops
                        }
                        System.out.println("i = " + i + ", j = " + j);
                    }
                }


    Scope of Loop Variables:
        Variables declared within a loop in Java have block scope,
            means they are only accessible within the loop where they are declared. 
            After the loop finishes, the variable is no longer accessible.

                for(int i = 0; i < 5; i++) {
                    // notice i is declared in the initialization portion of the FOR-loop
                    // i is accessible here
                }
                // i is no longer accessible here


    Nested Loops and Performance:
        There's potential performance issues, especially when the loops have high iteration counts (e.g., O(n^2) complexity).
        Nested loops can also lead to complex code, so use them judiciously and refactor where possible.


    Unreachable Code in Loops
        If the compiler detects code after an unconditional return or break within a loop, it will throw an error. 
        This rule is stricter than in C/C++, which may not always flag unreachable code.

                for(int i = 0; i < 5; i++) {
                    break;  // Loop will break immediately
                    System.out.println("This is unreachable");  // Causes a compilation error
                }


    Floating Point Loops:
        Be cautious when using floating-point numbers as loop counters. 
        Due to the inaccuracy of floating-point arithmetic, conditions may not behave as expected.
        This problem exists in both Java and C/C++, but Java has stricter type-checking, which might prevent some issues upfront.

                for(float f = 0.1f; f != 1.0f; f += 0.1f) {
                    System.out.println(f);
                }
                // May not terminate as expected due to floating-point precision issues


    Iterator vs. for Loop:
        When iterating over collections (like ArrayList or HashSet), 
            it's generally preferable to use an "Iterator" or an "enhanced for-each" loop in Java.
        Unlike C++, Java doesn’t provide "pointer-based iteration" but rather "object-based iterators".
        The use of Iterator ensures fail-safe behavior, 
            meaning it avoids ConcurrentModificationException when modifying collections during iteration.

        Example:

                ArrayList<String> list = new ArrayList<>();

                list.add("A");
                list.add("B");

                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }



    Final Variables in Loops:
        In Java, final variables (constants) cannot be modified inside a loop. They must be initialized only once.
        This is a stricter enforcement compared to C++, 
            where const variables have a similar but slightly different set of rules.

            Example:

                final int limit = 5;

                for (int i = 0; i < limit; i++) {
                    System.out.println(i);  // Works fine, but you cannot modify `limit`
                }




        --------    Use ChatGPT prompts like below    --------

            prompt 1:
                GPT: Provide important points to remember, key facts, and aspects of the following in Java. 
                Also, explain the control-flow mechanism and differences from C/C++:

                    for loop variations
                    while loop
                    do-while loop
                    Nested loops


            prompt 2:
                Explain the control flow mechanisms and key differences between Java and C/C++ for the following loop structures:

                    for loop variations
                    while loop
                    do-while loop
                    Nested loops

                Also, provide important points to remember and key facts related to each loop structure in Java.

*/



/* Example 1: Following uses a FOR-loop to print the square roots of the numbers between 1 and 99.
                It also displays the rounding error present for each square root.
*/

class SqrRoot {
    public static void main(String args[]) {
        double num, sroot, round_err;

        for(num = 1.0; num < 100.0; num++) {
            sroot = Math.sqrt(num);
            System.out.println("Square root of " + num + " is " + sroot);
            // compute rounding error
            round_err = num - (sroot * sroot);
            System.out.println("Rounding error is " + round_err);
            System.out.println();
        }
    }
}




/* Example 2: The for loop can proceed in a positive or negative fashion, 
                and it can change the loop control variable by any amount.

                Following program prints the numbers 100 to –95, in decrements of 5. 
*/

// A negatively running for loop
class DecrFor {
    public static void main(String[] args) {
        int x;

        for(x = 100; x > -100; x -= 5) System.out.println(x);
    }
}




/* Example 3: The loop's condition can be any valid Boolean expression 
                and doesn't have to use the loop control variable.

                For example, the loop below runs until the user types 'S': 
*/

// Loop until an S is typed.
class ForTest{
    public static void main(String[] args) throws java.io.IOException {
        int i;

        System.out.println("Press S to stop.");
        for(i = 0; (char) System.in.read() != 'S'; i++) System.out.println("Pass #" + i);
    }
}




/* Example 4: It is possible for any or all of the initialization, condition, or iteration portions 
                of the FOR loop to be blank. 
                
                For example, in the following program iteration variable moved to inside FOr-loop's body 
*/

class Empty {
    public static void main(String args[]) {
        int i;
        
        for(i = 0; i < 10; ){
            System.out.println("Pass #" + i);
            i++; // increment loop control var
        }
    }
}




/* Example 5: In following program, the initialization portion is also moved out of the FOR.
                Initialization is placed outside the loop when the initial value is calculated 
                    through a complex process that cannot easily fit inside the for loop statement.

                In this version, i is initialized before the loop begins, rather than as part of the for.
*/

// Move more out of the for loop.
class Empty2 {
    public static void main(String args[]) {
        int i;

        i = 0; // move initialization out of loop
        for(; i < 10;){
            System.out.println("Pass #" + i);
            i++; // increment loop control var
        }
    }
}



/* Example 6: The body of a loop can be empty. In this program the 
                FOR-loop only used to calculate sum the numbers through 5
*/
class Empty3 {
    public static void main(String args[]) {
    int i;
    int sum = 0;

    // sum the numbers through 5
    for(i = 1; i <= 5; sum += i++); // No body in this loop!
    System.out.println("Sum is " + sum);
    }
}




/* Example 7: Declaring loop control variables inside the for loop. 
                Notice the declaration the variable inside the initialization portion of the FOR.
*/
class ForVar {
    public static void main(String args[]) {
        int sum = 0;
        int fact = 1;

        // compute the factorial of the numbers through 5
        for(int i = 1; i <= 5; i++) {   // The variable i is declared inside the for statement.
            sum += i; // i is known throughout the loop
            fact *= i;
        }
        // but, i is not known here
        System.out.println("Sum is " + sum);
        System.out.println("Factorial is " + fact);
    }
}




/* Example 8: Here is a simple example in which a while is used to print the alphabet: */
class WhileDemo {
    public static void main(String args[]) {
        char ch;

        // print the alphabet using a while loop
        ch = 'a';
        while(ch <= 'z'){
            System.out.print(ch);
            ch++;
        }
    }
}




/* Example 9: Like the for loop, the while loop checks its condition at the start.
                
                Following program computes the integer powers of 2, from 0 to 9.
                Notice that the while loop executes only when "e" is greater than 0.
*/

class Power {
    public static void main(String args[]) {
        int e;
        int result;
    
        for(int i=0; i < 10; i++) {
            result = 1;
            e = i;
            while(e > 0) {
                result *= 2;
                e--;
            }
            System.out.println("2 to the " + i + " power is " + result);
        }
    }
}
    



/* Example 10: The following program uses "do-while loop" to loop until the user enters the letter q */

class DWDemo {
    public static void main(String args[]) throws java.io.IOException {
        char ch;
        do {
            System.out.print("Press a key followed by ENTER: ");
            ch = (char) System.in.read();   // get a char
        } while(ch != 'q');
    }
}



// ----  rev[25-nov-2024]  ----



