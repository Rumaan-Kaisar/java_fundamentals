
/*  -=-=-=-=-=-=-=-=-=-=-=      JUMPs      -=-=-=-=-=-=-=-=-=-=-= 

    "break" and "continue":
        Both are similar to C/C++'s "break" and "continue" (Recall C/C++ C_Ch2_3_1_ctrl_stmnt_jumps.c)



    BREAK:
        Terminates the nearest enclosing loop (for, while, do-while) or exits a switch statement.
        Control jumps to the statement immediately following the loop or switch.

        General form:
            break;

        Labels:
            It is optional
            Java allows "labeled break" to exit "nested" loops.
            The label specifies which loop to terminate.

            Without a label, break applies to the innermost enclosing loop or switch

            Example: 
                notice the label "outer", using break we can jump to outer

                    outer: for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (i == j) break outer;  // Breaks out of the outer loop
                        }
                    }



    CONTINUE:
        Skips the remaining statements in the current loop iteration and jumps to the next iteration.
        Used to skip specific iterations of a loop while allowing the loop to continue.
        i.e. bypassing the rest of the code in the current iteration
        
        General form:
            continue;

        labeled:
            Java allows labeled continue to skip iterations of an outer loop in nested loops.

            Example: 
                notice the label "outer", used to skip to the next iteration of the outer loop

                    outer: for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (i == j) continue outer;  // Skips to the next iteration of the outer loop
                        }
                    }

            Without a label, continue applies to the innermost enclosing loop.



    
    ------------    Remember the following points    ------------

    Break with infinite loops:
        The break statement can be used with any of Java’s loops, 
            including intentionally "infinite loops". Eg: force user to types the letter q:

            for( ; ; ) {
                ch = (char) System.in.read();       // get a char
                if(ch == 'q') break;
            }


    Break out of only the innermost loop:
        In nested loops, break exits only the innermost loop. For example:

            for(int i=0; i<3; i++){
                System.out.println("Outer loop count: " + i);
                System.out.print(" Inner loop count: ");
                
                int t = 0;
                while(t<100){
                    if(t == 10) break; 	// terminate loop if t is 10
                    System.out.print(t + " ");
                    t++;
                }
                System.out.println();
            }
            System.out.println("Loops complete.");

        The break statement in the inner loop causes the termination of only that loop. 
        The outer loop is unaffected. 


    Break in switch:
        The break that terminates a "switch" statement affects only that switch statement and not any enclosing loops.
*/




/* Example 1: The break statement stops a loop immediately and moves program control to the statement after the loop.
                Notice following program, the loop is set to run from 0 to 100,
                    but it ends early when i*i becomes greater than or equal to "num", (which in this case is 100)
                    the break statement causes it to terminate early

                Output:
                    0 1 2 3 4 5 6 7 8 9 Loop complete
*/

class BreakDemo {
    public static void main(String args[]) {
        int num;

        num = 100;
        // loop while i-squared is less than num
        for(int i=0; i < num; i++) {
            if(i*i >= num) break; // terminate loop if i*i >= 100
            System.out.print(i + " ");
        }
        System.out.println("Loop complete.");
    }
}




/* Example 2: The break statement used to terminate intentionally infinite loops. 
                For example, the following program simply reads input until the user types the letter q.
*/

class Break2 {
    public static void main(String args[]) throws java.io.IOException {
        char ch;

        for( ; ; ) {
            ch = (char) System.in.read(); // get a char
            if(ch == 'q') break;
        }
        System.out.println("You pressed q!");
    }
}




/*  ------------    "break" and "continue" with LABEL (Replacing "goto")    ------------

    -=-=-=-    Labeled break    -=-=-=-
    Labeled Break:
        Break can act like a "civilized" form of goto.
        Because Java doesn’t support goto.
        Labeled break can help exit deeply nested loops or blocks.
        It allows breaking out of multiple blocks, not limited to loops or switch.
        Provides the usefulness of goto without its downsides.

        Further, you can specify precisely where execution will resume, 
            because this form of break works with a label. 


        The general form of the labeled break:
                break label;

            Typically, "label" is the name of a label that identifies a block of code. 
            When this form of break executes, control is "transferred out" of the named block of code. 


        The labeled block must enclose the break, but it doesn’t have to be the closest block.
        You can use a labeled break to exit multiple nested blocks.
        However, you cannot use break to jump to a block that doesn’t enclose it.


// ----  rev[16-Dec-2024]  ----


	To name a block, put a label at the start of it. The block can be a stand-alone block, or a statement that has a block as its target. A label is any valid Java identifier followed by a colon. Once you have labeled a block, you can then use this label as the target of a break. Doing so causes execution to resume at the end of the labeled block. 



	Example 1: Following program shows three nested blocks:
for(i=1; i<4; i++) { one: { two: { three: { System.out.println("\n i is " + i);
	        if(i==1) break one;
	        if(i==2) break two;
	        if(i==3) break three;
	        System.out.println("won't print");  // this is never reached
	    }
           System.out.println("After block three.");
          	     }
      System.out.println("After block two.");
         }
System.out.println("After block one.");
}
System.out.println("After for.");	Output:
	i is 1
	After block one.
	i is 2
	After block two.
	After block one.
	i is 3
	After block three.
	After block two.
	After block one.
	After for.

	When i is 1, the first if succeeds, causing a break to the end of the block of code defined by label one. This causes After block one. to print. 
	When i is 2, the second if succeeds, causing control to be transferred to the end of the block labeled by two. This causes the messages After block two. and After block one. to be printed, in that order. 
	When i is 3, the third if succeeds, and control is transferred to the end of the block labeled by three. Now, all three messages are displayed.



	Example 2: This time, break is being used to jump outside of a series of nested for loops. When the break statement in the inner loop is executed, program control jumps to the end of the block defined by the outer for loop, which is labeled by done. 

done: for(int i=0; i<10; i++) { 
      for(int j=0; j<10; j++) {
for(int k=0; k<10; k++) { System.out.println(k + " ");
        if(k == 5) break done; 	// jump to done
      }
System.out.println("After k loop"); 		// won't execute
         }
      System.out.println("After j loop"); 		// won't execute
      	                }
System.out.println("After i loop");	Output:
	0
	1
	2
	3
	4
	5
	After i loop




    	Example 3: Precisely where you put a label is very important—especially when working with loops. For example:

// here, put label before for statement.
stop1: for(x=0; x < 5; x++) 
{ for(y = 0; y < 5; y++) { if(y == 2) break stop1;
     System.out.println("x and y: " + x + " " + y); }
}
System.out.println();

// now, put label immediately before {
for(x=0; x < 5; x++)
stop2: {	 for(y = 0; y < 5; y++) { if(y == 2) break stop2;
     System.out.println("x and y: " + x + " " + y);  }
             }	Output: 	x and y: 0 0
		x and y: 0 1

		x and y: 0 0
		x and y: 0 1
		x and y: 1 0
		x and y: 1 1
		x and y: 2 0
		x and y: 2 1
		x and y: 3 0
		x and y: 3 1
		x and y: 4 0
		x and y: 4 1
	Both sets of nested loops are the same except for one point. In the first set, the label precedes the outer for loop. In this case, when the break executes, it transfers control to the end of the entire for block, skipping the rest of the outer loop’s iterations.
	In the second set, the label precedes the outer for’s opening curly brace. Thus, when break stop2 executes, control is transferred to the end of the outer for’s block, causing the next iteration to occur.


	Example 4: We cannot break to any label that is not defined for an enclosing block. Eg:  following is invalid & won't compile:

one: 	for(int i=0; i<3; i++) { System.out.print("Pass " + i + ": "); }
for(int j=0; j<100; j++) {	if(j == 10) break one; // WRONG
System.out.print(j + " "); }
	Since the loop labeled one does not enclose the break, it is not possible to transfer control to that block.



-=-=-=-    Labeled continue    -=-=-=-


	Labeled continue:   As with the break statement, continue may specify a label to describe which enclosing loop to continue. Eg:
outerloop: 
for(int i=1; i < 10; i++) { System.out.print("\nOuter loop pass " + i + ", Inner loop: ");
for(int j = 1; j < 10; j++) { if(j == 5) continue outerloop;  // continue outer loop
					              System.out.print(j);  }
    }	Output
Outer loop pass 1, Inner loop: 1234
Outer loop pass 2, Inner loop: 1234
Outer loop pass 3, Inner loop: 1234
. . .    . . .    . . .
Outer loop pass 9, Inner loop: 1234
	As the output shows, when the continue executes, control passes to the outer loop, skipping the remainder of the inner loop.

Note
[1]	Choosing appropriate loop: Use a for loop when performing a known number of iterations. Use the do-while when you need a loop that will always perform at least one iteration. The while is best used when the loop will repeat an unknown number of times.
[2]	Using if-else-if ladder: Use an if-else-if ladder when the conditions controlling the selection process do not rely upon a single value.
if(x < 10) 		// ...
else if(y != 0) 	// ...
else if(!done) 	// ...
This sequence cannot be recoded into a switch because all three conditions involve different variables—and differing types. 
	Also, you will need to use an if-else-if ladder when testing floating-point values or other objects that are not of types valid for use in a switch expression.





--------    GPT    --------

Key Points to Remember About break and continue in Java:




Control Flow Mechanism:
break:
In switch:

Immediately terminates the current case block and prevents "fall-through" to the next case.
Example:
java
Copy code
switch (day) {
    case 1:
        System.out.println("Monday");
        break; // Exit switch here
    case 2:
        System.out.println("Tuesday");
        break;
}
In Loops:

Stops the execution of the loop entirely when a specific condition is met.
Example:
java
Copy code
for (int i = 0; i < 10; i++) {
    if (i == 5) break;  // Exits the loop when i is 5
}
continue:
Skips the current iteration and moves directly to the next iteration of the loop.
Example:
java
Copy code
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;  // Skips even numbers
    System.out.println(i);  // Prints only odd numbers
}
Differences from C/C++:
Syntax:

Both break and continue have the same syntax in Java and C/C++.
Java introduces labeled break and continue, which are not available in C/C++.
Usage in switch:

The use of break in a switch is mandatory in Java to prevent "fall-through."
In C/C++, omitting break in a switch causes fall-through behavior by default, which can lead to unintentional bugs.
Labels:

Java supports labeled loops with break and continue, allowing control over nested loops.
Labels are not a feature of C/C++.
Memory Safety:

Java does not allow unintentional memory corruption or undefined behavior related to break or continue as C/C++ might when used with pointers or in unsafe code.
Usage in Switch:

In Java, continue cannot be used inside a switch statement. This is different from C++, where continue simply applies to the innermost loop if present.
Summary:
Feature	break	continue
Purpose	Exits the loop or switch completely	Skips to the next iteration of the loop
Labeling	Supports labeled termination	Supports labeled skipping
In Switch	Used to prevent fall-through	Not allowed in switch
Scope	Affects the nearest enclosing loop or switch	Affects the nearest enclosing loop
Difference from C++	Java mandates break in switch cases; supports labels	Labels supported; no usage in switch
By remembering these rules, you'll handle break and continue effectively in Java programs.

*/




