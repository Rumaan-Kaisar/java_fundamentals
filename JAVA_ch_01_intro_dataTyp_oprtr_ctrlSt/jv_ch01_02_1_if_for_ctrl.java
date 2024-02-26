
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

