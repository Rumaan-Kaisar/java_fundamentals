
// jv_ch02_11_ternary_operator         2.18        176.8-179

/* -=-=-=-=-=-=-=-=-=-=-=      The '?' ternary Operator      -=-=-=-=-=-=-=-=-=-=-=

    The "?" is called a TERNARY operator because it requires "three operands".
    It is similar to C/C++'s "?" operator.
    
    General form:
                    Exp1 ? Exp2 : Exp3;

        where "Exp1" is a boolean expression, and 
        Exp2 and Exp3 are expressions of any type "other than void".
        The "type" of Exp2 and Exp3 must be the same (or compatible).
        Notice the use and placement of the colon ":"


   The value of a ? expression is determined like this: Exp1 is evaluated. If it is true, then Exp2 is evaluated and becomes the value of the entire ? expression. If Exp1 is false, then Exp3 is evaluated and its value becomes the value of the expression. 
   Example, Prevent a division by zero using the ?,    if(i != 0 ? true : false) System.out.println("100 / " + i + " is " + 100 / i);
   If i=0, then the outcome of the if is false, the division by zero is prevented, and no result is displayed. Otherwise, the division performed.

*/
