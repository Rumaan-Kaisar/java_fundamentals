/* 
    1.  For loop. General form:

        for(initialization; condition; iteration){
            statement block
        }

    *   Here "condition" is a boolean statement, i.e. true or false
*/


public class JV_ch1_3_2_ctrl_statement_loops{
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

// javac JV_ch1_3_2_ctrl_statement_loops.java
// java JV_ch1_3_2_ctrl_statement_loops