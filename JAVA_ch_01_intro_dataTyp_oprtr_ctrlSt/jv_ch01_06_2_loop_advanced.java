
/* -=-=-=-=-=-=-=-=-=-=-=      LOOPS      -=-=-=-=-=-=-=-=-=-=-= 

// ----  rev[17-Oct-2024]  ----

GPT: give important points to remember, important facts / aspects of following in JAVA. Also control-flow mechanism and difference from C/C++. 

for loop variations
while 
do-while
nested loops


    ------------    FOR loop    ------------
    Following are the most traditional forms of the for

        Repeats a single statement:

            for(initialization; condition; iteration) statement;


        Repeats a block:

            for(initialization; condition; iteration){
                statement sequence
            }




1.21 for loop (with variations)[ Recall C/C++ 2.5 , 2.11 ]
Similar to C/C++'s for loop  for(initialization; condition; iteration) {statement;}
The initialization is usually an assignment statement that sets the initial value of the loop control variable, which acts as the counter that controls the loop. The condition is a Boolean expression that determines whether or not the loop will repeat. The iteration expression defines the amount by which the loop control variable will change each time the loop is repeated. Notice that these three major sections of the loop must be separated by semicolons.
	Some Variations on the for Loop
[1]	Multiple loop control variables can be used in the for loop. Multiple loop control variables are often convenient and can simplify certain algorithms. Any number of initialization and iteration statements are possible, but, more than two or three make the for loop unwieldy. Consider the following code:
for(i=0, j=10; i<j; i++, j--) System.out.println("i and j: " + i + " " + j);
	Here, commas separate the two initialization statements and the two iteration expressions. When the loop begins, both i and j are initialized. Each time the loop repeats, i is incremented and j is decremented. 
[2]	The condition controlling the loop can be any valid Boolean expression. It does not need to involve the loop control variable. Eg: the loop continues to execute until the user types the letter S at the keyboard:
for(i = 0;  (char)System.in.read() != 'S';  i++) System.out.println("Pass #" + i);
[3]	It is possible for any or all of the initialization, condition, or iteration portions of the for loop to be blank.  For example, 
for(i=0; i<10; ) { 	System.out.println("Pass #" + i);
i++; }  	// increment loop control variable is inside the for loop 
	or iteration may not present at all. Eg:
for(i = 0;  (char)System.in.read() != 'S';  ) System.out.println("Again");
	The initialization portion can be moved out of the for:
int i = 0; 				// move initialization out of loop
for( ; i<10 ; ) { 	System.out.println("Pass #" + i); i++; }  
	The Infinite Loop: To create an infinite loop use the for by leaving the conditional expression empty. Eg:
for(;;){ } // intentionally infinite loop
This loop will run forever. (It can be terminated by using the break statement.)
[4]	Loops with No Body: In Java, the body associated with a for loop (or any other loop) can be empty. This is because a null statement is syntactically valid. They are often useful. For example, the following program uses one to sum the numbers 1 through 5: 	for(i = 1; i <= 5; sum += i++) ;
	Notice that the summation process is handled entirely within the for statement, and no body is needed. 
	Pay special attention to the iteration expression: 	sum += i++. It is equivalent to:    sum = sum + i; i++;
[5]	Declaring Loop Control Variables Inside the for Loop: Often the variable that controls a for is needed only for the purposes of the loop and is not used elsewhere. In this case, we declare the variable inside the initialization portion of the for. Eg:
int sum = 0, fact = 1;
for(int i = 1; i <= 5; i++) { 	sum += i; 	// i is known throughout the loop
fact *= i; }
	In this example, i is not accessible outside the for loop. If you need to use the loop control variable elsewhere in your program, you will not be able to declare it inside the for loop.
	Note: the scope of that variable ends when the for statement does. (That is, the scope of the variableis limited to the for loop.) Outside the for loop, the variable will cease to exist. 
[6]	The Enhanced for Loop: Relatively recently, a new form of the for loop, called the enhanced for, was added to Java. The enhanced for provides a streamlined way to cycle through the contents of a collection of objects, such as an array. We'll discuss with array.



1.22 while and do-while loop (similar to C/C++)
While loop:  	while(condition){}	Do-While loop: 	do{}while(condition);



1.23 Nested Loops: 	One loop can be nested inside of another. Eg: To find factors of numbers
for(int i=2; i <= 100; i++){ System.out.print("Factors of " + i + ": ");
  for(int j=2; j<i; j++) if((i%j) == 0) System.out.print(j + " ");
  System.out.println(); }




-=-=-=-=-  GPT  -=-=-=-=-

Important Points to Remember: Control Flow in Java (Differences and Key Aspects Compared to C/C++)
1. for Loop Variations
Basic Structure:

java
Copy code
for (initialization; condition; iteration) {
    // body of loop
}
Initialization: executed once at the beginning.
Condition: checked before each iteration; loop runs as long as it's true.
Iteration: performed after each loop body execution.
Important Aspects:

Same as in C/C++ in terms of syntax and behavior.
Infinite Loop: Can be written like this (same as C/C++):
java
Copy code
for(;;) {
    // infinite loop
}
Multiple Initialization and Iteration Expressions: You can use multiple comma-separated expressions:
java
Copy code
for (int i = 0, j = 10; i < j; i++, j--) {
    // loop body
}
Differences from C/C++:

In Java, the scope of the variables declared in the initialization section is restricted to the body of the loop. In C++, variables can be declared outside and can have an extended scope.
2. while Loop
Basic Structure:

java
Copy code
while (condition) {
    // body of loop
}
Important Aspects:

The while loop evaluates the condition first, meaning if the condition is false at the start, the loop is never executed.
Same behavior in both Java and C/C++.
Infinite Loop:
java
Copy code
while (true) {
    // infinite loop
}
Control Flow Mechanism:

Condition evaluated first.
If the condition is true, the loop body is executed.
Repeat step 1.
3. do-while Loop
Basic Structure:

java
Copy code
do {
    // body of loop
} while (condition);
Important Aspects:

The do-while loop is similar to the while loop but with one key difference: the body of the loop will always be executed at least once, even if the condition is false on the first evaluation.
Similar to C/C++.
Useful when the loop must run at least once before checking the condition.
Control Flow Mechanism:

The body is executed once before the condition is checked.
The condition is evaluated after each iteration.
If the condition is true, the loop continues; otherwise, it terminates.
Example:

java
Copy code
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 5);
Difference from while:

The while loop checks the condition before execution of the loop body.
The do-while loop checks the condition after the loop body, so the loop is guaranteed to run at least once.
4. Nested Loops
Basic Structure:

java
Copy code
for (initialization; condition; iteration) {
    for (initialization; condition; iteration) {
        // inner loop body
    }
    // outer loop body
}
Important Aspects:

You can nest for, while, and do-while loops.
Loops are executed from the outermost to innermost, with the inner loop completing all its iterations for each iteration of the outer loop.
Similar in Java and C/C++.
Example of Nested for Loops:

java
Copy code
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.println("i: " + i + ", j: " + j);
    }
}
Output:

yaml
Copy code
i: 1, j: 1
i: 1, j: 2
i: 1, j: 3
i: 2, j: 1
i: 2, j: 2
i: 2, j: 3
i: 3, j: 1
i: 3, j: 2
i: 3, j: 3
Differences from C/C++:

Variable Scoping: In Java, variables declared in a loop have block-level scope (limited to the loop or block they are declared in). In C++, variables declared in a loop can have a different scope depending on how they are declared.
5. Additional Notes:
Java has an enhanced for-each loop (also called the enhanced for loop) which is useful for iterating through arrays and collections.
java
Copy code
for (int element : array) {
    // body of loop
}
This loop is not available in C/C++ and is specific to Java (and other modern languages like Python).
Differences in Java from C/C++:
Variable Declaration and Scope:

In Java, the scope of a variable declared inside the loop is limited to the loop. In C++, the scope can vary.
In Java, loop control variables can only be used within the loop unless declared outside the loop. In C++, their scope may differ based on declaration.
Enhanced for Loop in Java:

Java provides an additional for-each loop for working with arrays and collections, which does not exist in C++.
Break and Continue Behavior:

Both Java and C/C++ allow the use of break and continue statements, but Java's control-flow mechanisms like labels in combination with break are not commonly used in C++.
Type Checking:

Java is more strictly typed than C++, so implicit type conversions inside loops (e.g., promoting an int to a float) are handled differently.
Conclusion:
In summary, Java's control flow for loops (for, while, do-while) is quite similar to C/C++, but with some key differences in scoping rules, enhanced features like the enhanced for-each loop, and stricter type-checking. Keep in mind the specific characteristics of loops and variable scoping when transitioning from C++ to Java.

