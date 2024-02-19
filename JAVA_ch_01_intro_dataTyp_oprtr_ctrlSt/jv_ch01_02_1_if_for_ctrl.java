
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




/* Example 2: Following demonstrate 'FOR-loop' */
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


