
/* -=-=-=-=-=-=-=-=-=-=-=      LOOPS      -=-=-=-=-=-=-=-=-=-=-= 

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
        
        EG: used for arrays

                for(int num : array) {
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







// ----  rev[31-Oct-2024]  ----


-=-=-=-=-  GPT  -=-=-=-=-


Yes, there are a few additional important facts to remember when using loops in Java, as well as some differences or special considerations compared to C/C++:

1. Type Promotion and Casting in Loops
In Java, arithmetic operations on smaller data types (like byte, char, short) result in promotion to int inside expressions. After the promotion, if the result needs to be assigned back to the smaller data type, you will need to explicitly cast the result back to the original type.
This is something to watch out for in loop iterations involving arithmetic operations on small types.
Example:

java
Copy code
byte b = 1;
for (int i = 0; i < 10; i++) {
    b = (byte) (b + 1); // Requires explicit cast, as result is promoted to int
}

Type Checking:

Java is more strictly typed than C++, so implicit type conversions inside loops (e.g., promoting an int to a float) are handled differently.



2. break and continue Statements
The break statement in Java (similar to C/C++) exits the nearest enclosing loop entirely.
The continue statement skips the current iteration of the loop and proceeds to the next iteration.
Labeled break and continue: Java allows you to use labels with break and continue to break or continue outer loops. This feature doesn't exist in C/C++.
Example (Labeled break):

java
Copy code
outerLoop:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (j == 1) {
            break outerLoop;  // Exits both loops
        }
        System.out.println("i = " + i + ", j = " + j);
    }
}
Output:
css
Copy code
i = 0, j = 0



3. Scope of Loop Variables
Variables declared within a loop in Java have block scope, which means they are only accessible within the loop where they are declared. After the loop finishes, the variable is no longer accessible.
This is similar to C++ unless the variables are declared outside the loop.
Example:

java
Copy code
for (int i = 0; i < 5; i++) {
    // i is accessible here
}
// i is no longer accessible here



4. The for-each Loop (Enhanced for Loop)
Java provides the enhanced for loop for iterating over arrays and collections. It simplifies the iteration process and reduces the chance of errors associated with loop boundaries.
You can only use it to read data, not modify the collection. This is different from regular for loops, where you have full control over the index.
Example:

java
Copy code
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}
Important Points:

The enhanced for loop iterates through each element of the collection without requiring an index.
It's particularly useful for iterating over arrays, ArrayList, HashSet, and other collection types in Java.
Not present in C/C++.



5. Nested Loops and Performance
Nested loops are allowed in Java, just like in C/C++, but care should be taken when using nested loops due to potential performance issues, especially when the loops have high iteration counts (e.g., O(n^2) complexity).
Nested loops can also lead to complex code, so use them judiciously and refactor where possible.



6. Unreachable Code in Loops
Java has a strict rule against unreachable code. If a loop contains code that the compiler determines will never be reached (e.g., after an unconditional return or break), the compiler will produce an error.
This is slightly stricter than C/C++ compilers, which might not always catch unreachable code.
Example:

java
Copy code
for (int i = 0; i < 5; i++) {
    break; // Loop will break immediately
    System.out.println("This is unreachable"); // Causes a compilation error
}



7. Switch Expression in Java (Java 12+):
Java, from version 12 onwards, allows the switch expression, which simplifies the use of switch by making it an expression that can return a value.
This feature is not present in C/C++.
Example:

java
Copy code
int dayOfWeek = 2;
String day = switch (dayOfWeek) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    default -> "Invalid day";
};
System.out.println(day);



8. Floating Point Loops
Be cautious when using floating-point numbers as loop counters. Due to the inaccuracy of floating-point arithmetic, conditions may not behave as expected.
This problem exists in both Java and C/C++, but Java has stricter type-checking, which might prevent some issues upfront.
Example of a potential issue:

java
Copy code
for (float f = 0.1f; f != 1.0f; f += 0.1f) {
    System.out.println(f);
}
// May not terminate as expected due to floating-point precision issues



9. Iterator vs. for Loop
When iterating over collections (like ArrayList or HashSet), it's generally preferable to use an Iterator or an enhanced for-each loop in Java.
Unlike C++, Java doesn’t provide pointer-based iteration but rather object-based iterators.
The use of Iterator ensures fail-safe behavior, meaning it avoids ConcurrentModificationException when modifying collections during iteration.
Example:

java
Copy code
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}



10. Final Variables in Loops
In Java, final variables (constants) cannot be modified inside a loop. They must be initialized only once.
This is a stricter enforcement compared to C++, where const variables have a similar but slightly different set of rules.
Example:

java
Copy code
final int limit = 5;
for (int i = 0; i < limit; i++) {
    System.out.println(i);  // Works fine, but you cannot modify `limit`
}
Summary of Key Differences and Facts:
Java provides the enhanced for-each loop, not available in C/C++.
Variable scoping is stricter in Java, especially within loop bodies.
Strict type-checking and promotion rules apply inside expressions (e.g., promoting smaller types like byte to int).
Labeled break and continue in Java provide more control over nested loops, which are not available in C++.
Iterator-based loops are preferred for collections in Java, whereas C++ uses pointer-based iterations.
Java’s switch expression (Java 12+) enhances control flow by making switch more expressive compared to C++.
These differences are essential to understand when transitioning between Java and C/C++ or when using loops effectively in Java.



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



