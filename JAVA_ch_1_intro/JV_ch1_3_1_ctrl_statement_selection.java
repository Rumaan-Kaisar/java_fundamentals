
/* 1.  if statement:
        General form:

            if(condition){
                statement block 
                } 

        *   Here "condition" is a boolean statement, i.e. true or false
 */


public class JV_ch1_3_1_ctrl_statement_selection{
    public static void main(String args[]){

        // ----------------------  IF statement  ----------------------  

        // single line
        if(10 < 11) System.out.println("10 is less than 11");
        if(10 > 11) System.out.println("This won't be printed");

        // Using Blocks
        int a, b, c;
        a = 2;
        b = 3;
        int u = 0;  /* a Globa variable must be initialized in java */
        if(a < b){
            System.out.println("a is less than b");
            int v = a / b;  /* Here v is a local variable */
            System.out.println("Vlue of v: "+ v);

            u = a * b;
            a = 0;
        } 
        System.out.println("New a: "+ a);
        // Here, scope of v (declared inside if-block) is lost outside of if-block
        // System.out.print("Vlue of v: "+ v);
        System.out.println("Vlue of u: "+ u);


        double i, j, d; /* doesnot make "d" a Global variable, it is still a local variable */
        i = 5;
        j = 10;
        // the target of this if is a block
        if(i != 0) {
            System.out.println("i does not equal zero");
            d = j / i;  /* here d is a local variable */
            System.out.println("j / i is " + d);    /* using local variable d */
        }
        /* Follwing gives compile time error */
        // System.out.println("j / i is (out side of if-block ) :" + d);

        System.out.println();

        c = a - b; // c contains -1
        System.out.println("c contains: "+c);
        if(c >= 0) System.out.println("c is non-negative");
        if(c < 0) System.out.println("c is negative");

        System.out.println();
        c = b - a; // c now contains 1
        System.out.println("c now contains: "+c);
        if(c >= 0) System.out.println("c is non-negative");
        if(c < 0) System.out.println("c is negative");

        // statement ends when ; appears
        System.out.println("This is a long line of output" +
                                a + b + j +
                                "more output");

    }
}

// There is no meaning declaring local variable outside its scope, doesnot make it global

// javac JV_ch1_3_1_ctrl_statement_selection.java
// java JV_ch1_3_1_ctrl_statement_selection
