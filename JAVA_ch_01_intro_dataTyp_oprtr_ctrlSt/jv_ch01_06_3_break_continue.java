
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

        To name a block, add a label at the beginning. 
            A label is a valid Java identifier followed by a colon. 
            Once labeled, you can use it as the target of a break, which resumes execution at the block's end.


    unstructured (goto vs labeled-break):
        Using a labeled break can make code somewhat unstructured as it allows jumps across multiple lines or nested levels, 
        but it still retains more structure compared to an "unstructured goto".
*/




/* Example 3: When used inside a set of nested loops, the break statement will break out of only the innermost loop. */

class Break3 {
    public static void main(String args[]) {
        for(int i=0; i<3; i++) {
            System.out.println("Outer loop count: " + i);
            System.out.print(" Inner loop count: ");
            
            int t = 0;
            while(t < 100) {
                if(t == 10) break; // terminate loop if t is 10
                System.out.print(t + " ");
                t++;
            }
            System.out.println();
        }
        System.out.println("Loops complete.");
    }
}




/* Example 4: Following program has three nested blocks. We exit the block using break with a label */

class Break4 {
    public static void main(String args[]) {
        int i;
    
        for(i=1; i<4; i++) {
            one: {
                two: {
                    three: {
                        System.out.println("\ni is " + i);
                        if(i==1) break one;
                        if(i==2) break two;
                        if(i==3) break three;
                        // this is never reached
                        System.out.println("won't print");
                    }
                    System.out.println("After block three.");
                }
                System.out.println("After block two.");
            }
            System.out.println("After block one.");
        }
        System.out.println("After for.");
    }
}


/* Output:
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


    When i is 1, the first if succeeds, causing a break to the end of the block of code defined by label one. 
        This causes "After block one." to print. 

    When i is 2, the second if succeeds, causing control to be transferred to the end of the block labeled by two. 
        This causes the messages "After block two." and "After block one." to be printed, in that order. 

    When i is 3, the third if succeeds, and control is transferred to the end of the block labeled by three. 
        Now, all three messages are displayed.
*/




/* Example 5: In following example, break is used to exit a series of "nested for" loops. 
                When the break in the inner loop runs, control jumps to the end of the outer loop labeled "done", 
                skipping the rest of all three loops. 
*/

class Break5 {
    public static void main(String args[]) {
        done:
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<10; k++) {
                    System.out.println(k + " ");
                    if(k == 5) break done; // jump to done
                }
                System.out.println("After k loop");     // won't execute
            }
            System.out.println("After j loop");     // won't execute
        }
        System.out.println("After i loop");
    }
}

/*  Output:
    0
    1
    2
    3
    4
    5
    After i loop
*/




/* Example 6: Precisely where you put a label is very important— especially when working with loops. 

                The program has two sets of nested loops with one key difference:

                In the first set, the label is "before" the outer FOR-loop. 
                    When the break executes, it skips all remaining iterations of the outer loop and exits the loop entirely.

                In the second set, the label is before the outer FOR-loop's "opening brace". 
                    Here, when the break executes, it jumps to the end of the block, 
                    allowing the next iteration of the outer loop to continue.
*/

class Break6 {
    public static void main(String args[]){
        int x=0, y=0;
    
        // here, put label before for statement (labeled both FOR & its block)
        stop1: for(x=0; x < 5; x++){
            for(y = 0; y < 5; y++) {
                if(y == 2) break stop1;
                System.out.println("x and y: " + x + " " + y);
            }
        }
    
        System.out.println();
        // now, put label immediately before '{' (labeled just FOR's block)
        for(x=0; x < 5; x++) stop2: {   // notice the label
            for(y = 0; y < 5; y++) {
                if(y == 2) break stop2;
                System.out.println("x and y: " + x + " " + y);
            }
        }
    }
}




/* Example 7: We cannot break to any label that is not defined for an enclosing block.

                In the folloing program,
                    since the loop labeled "one" does not enclose the break, 
                    it is not possible to transfer control to that block. 
*/

class BreakErr {
    public static void main(String args[]) {
        one: for(int i=0; i<3; i++) {
            System.out.print("Pass " + i + ": ");
        }

        for(int j=0; j<100; j++) {
            if(j == 10) break one;      // WRONG: label "one" is not defined for this block
            System.out.print(j + " ");
        }
    }
}




/*  -=-=-=-    Labeled continue    -=-=-=-
    
    Labeled continue:
        The "continue" statement can also specify a "label" to indicate which enclosing loop to continue. 

        For example:

                outerloop: for(int i=1; i < 10; i++) { 
                    System.out.print("\nOuter loop pass " + i + ", Inner loop: ");
                        for(int j = 1; j < 10; j++) { 
                            if(j == 5) continue outerloop;  // continue outer loop
                            System.out.print(j);  
                        }
                    }	

        when the "continue" executes, control passes to the OUTER loop, 
        "skipping" the remainder of the INNER loop.
*/




/* Example 8:  continue is the opposite of break. 
                In this program, continue helps print even numbers between 0 and 100. 
                It skips the odd numbers by causing the loop to iterate early, 
                    bypassing the println() call for odd numbers. 
*/
class ContDemo {
    public static void main(String args[]) {
        int i;
    
        // print even numbers between 0 and 100
        for(i = 0; i<=100; i++) {
            if((i%2) != 0) continue; // iterate
            System.out.println(i);
        }
    }
}




/* Example 9: "continue" can be used with a "label" to specify which outer loop to continue. 
                In the following program, when continue executes, control passes to the outer loop, 
                    skipping the rest of the inner loop.
*/
class ContToLabel {
    public static void main(String args[]) {
        outerloop: for(int i=1; i < 10; i++) {
            System.out.print("\nOuter loop pass " + i + ", Inner loop: ");
            for(int j = 1; j < 10; j++) {
                if(j == 5) continue outerloop;  // continue outer loop
                System.out.print(j);
            }
        }
    }
}




/* Example 10: Following program puts finishing touches on the Java help system that was created previouly. 
                (Recall "Example 12" jv_ch01_06_2_loop_advanced.java)
                
                This version adds the syntax for "break" and "continue"
                It also allows the user to request the syntax for more than one statement
                It does this by adding an outer loop that runs until the user enters q as a menu selection 
*/

class Help3 {
    public static void main(String args[]) throws java.io.IOException {
        char choice, ignore;
        
        for(;;) {
            do {
                System.out.println("Help on:");
                System.out.println(" 1. if");
                System.out.println(" 2. switch");
                System.out.println(" 3. for");
                System.out.println(" 4. while");
                System.out.println(" 5. do-while");
                System.out.println(" 6. break");
                System.out.println(" 7. continue\n");

                System.out.print("Choose one (q to quit): ");
                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while(ignore != '\n');

            } while( choice < '1' | choice > '7' & choice != 'q');
            
            if(choice == 'q') break;
            System.out.println("\n");

            switch(choice) {
                case '1':
                    System.out.println("The if:\n");
                    System.out.println("if(condition) statement;");
                    System.out.println("else statement;");
                    break;

                case '2':
                    System.out.println("The switch:\n");
                    System.out.println("switch(expression) {");
                    System.out.println(" case constant:");
                    System.out.println(" statement sequence");
                    System.out.println(" break;");
                    System.out.println(" // ...");
                    System.out.println("}");
                    break;

                case '3':
                    System.out.println("The for:\n");
                    System.out.print("for(init; condition; iteration)");
                    System.out.println(" statement;");
                    break;

                case '4':
                    System.out.println("The while:\n");
                    System.out.println("while(condition) statement;");
                    break;

                case '5':
                    System.out.println("The do-while:\n");
                    System.out.println("do {");
                    System.out.println(" statement;");
                    System.out.println("} while (condition);");
                    break;

                case '6':
                    System.out.println("The break:\n");
                    System.out.println("break; or break label;");
                    break;

                case '7':
                    System.out.println("The continue:\n");
                    System.out.println("continue; or continue label;");
                    break;
            }
            System.out.println();
        }
    }
}




/*  Example 11: Explain what break does. Be sure to explain both of its forms.

                A break without a label:
                    causes termination of its immediately enclosing loop or switch statement.

                A break with a label: 
                    causes control to transfer to the "end of the labeled block".
*/




/* Example 12: In the following fragment, after the break statement executes, what is displayed?

                        for(i=0; i < 10; i++) {
                            while(running){
                                if(x<y) break;
                                // ...
                            }
                            System.out.println("after while");
                        }
                        System.out.println("After for");

            ans:
                After "break" executes, "after while" is displayed.
*/


