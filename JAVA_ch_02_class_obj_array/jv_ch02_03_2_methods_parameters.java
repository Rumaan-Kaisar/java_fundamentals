
// 115.9-124.7

/* -=-=-=-=-=-=-=-=-=-=-=      methods with parameters      -=-=-=-=-=-=-=-=-=-=-= 
    parameters and arguments:
        A value passed to a method is called an "argument". 
        Inside the method, the variable that receives the argument is called a "parameter".
        parameter declaration syntax is the same as that used for variables.

        Example: 
                    devide(int x, int y)
            
            here x and y are parameters but in    devide(2, 3)    2 and 3 are arguments.


    Scope of parameters:
        A parameter is within the scope of its method,
        aside from its special task of receiving an argument, it acts like any other local variable.

    A method can have more than one parameter       devide(int x, int y)


    multiple parameters:
        When a method has multiple parameters, each parameter specifies its own type, which can differ from the others. 
        For example, this is perfectly valid:

                    int myMeth(int a, double b, float c){  }

*/




/* Example 1: Here is a simple example that uses a parameter. Inside the ChkNum class, 
                the method isEven() returns true if the value that it is passed is even. 
                It returns false otherwise. 
                
                Therefore, isEven() has a return type of "boolean"


                isEven() is called three times with different values.
                    Each time, a value (called an argument) is passed inside the parentheses. 
                    When isEven() is called, its parameter x takes the value of the argument.
*/

// NOTE: In C/C++, functions can exist outside of classes, while in Java, methods must be inside a class.
class ChkNum {
    // return true if x is even
    boolean isEven(int x) {
        if((x%2) == 0) return true;
        else return false;
    }
}

class ParmDemo{
    public static void main(String args[]) {
        ChkNum e = new ChkNum();    // creating a class of ChkNum to use the method isEven() encapsulated in it

        if(e.isEven(10)) System.out.println("10 is even.");
        if(e.isEven(9)) System.out.println("9 is even.");
        if(e.isEven(8)) System.out.println("8 is even.");
    }
}




/* Example 2: A method can have more than one parameter.
                
                In this program, the "Factor class" has a method isFactor() 
                that checks if the first number is a factor of the second.
*/

class Factor {
    // This method has two parameters.
    boolean isFactor(int a, int b) {
        if( (b % a) == 0 ) return true;
        else return false;
    }
}


class IsFact {
    public static void main(String args[]) {
        Factor x = new Factor();

        // Pass two arguments to isFactor()
        if(x.isFactor(2, 20)) System.out.println("2 is factor");
        if(x.isFactor(3, 20)) System.out.println("this won't be displayed");
    }
}


// ----  rev [01-May-2025]  ----
// 117.5-124.7


