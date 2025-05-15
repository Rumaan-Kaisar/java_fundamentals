
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


    ----  Proper use of class  ----
    A class groups related functionality together.
    A good class should handle one clear, specific job.
        Too many unrelated features make a class messy.
        Too little functionality makes it fragmented.
        Balancing this comes with experience.
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




/* Example 3: Adding a Parameterized Method to Vehicle class (recall jv_ch02_03_1_methods_return.java)
                We can improve the Vehicle class by adding a method with a parameter.

                This new method, called fuelneeded(), calculates how much fuel is needed to cover a given distance.
                It takes the number of miles as a parameter and returns the gallons required.

                        double fuelneeded(int miles) {
                            // calculation
                        } 

                Notice that this method returns a value of type double. 
                    since the amount of fuel needed for a given distance might not be a whole number.
*/

// Add a parameterized method that computes the fuel required for a given distance.

class Vehicle {
    int passengers; // number of passengers
    int fuelcap;    // fuel capacity in gallons
    int mpg;        // fuel consumption in miles per gallon

    // Return the range.
    int range() {
        return mpg * fuelcap;
    }

    // Compute fuel needed for a given distance.
    double fuelneeded(int miles) {
        return (double) miles / mpg;
    }
}


class CompFuel {
    public static void main(String args[]) {
        Vehicle minivan = new Vehicle();
        Vehicle sportscar = new Vehicle();
        double gallons;

        int dist = 252;

        // assign values to fields in minivan
        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        // assign values to fields in sportscar
        sportscar.passengers = 2;
        sportscar.fuelcap = 14;
        sportscar.mpg = 12;

        gallons = minivan.fuelneeded(dist);
        System.out.println("To go " + dist + " miles minivan needs " + gallons + " gallons of fuel.");

        gallons = sportscar.fuelneeded(dist);
        System.out.println("To go " + dist + " miles sportscar needs " + gallons + " gallons of fuel.");
    }
}




/* Example 4: Now we'll modify "Example 10" from jv_ch01_06_3_break_continue.java 

                Converting a Help System into a Class:
                    Previous program showed help for Java’s control statements.
                    Since this is one clear, separate task, it makes sense to turn it into a class.


                Why create a class for it?
                    The feature is compact and well-defined.
                    It’s organized and clean when encapsulated inside a class.
                    It’s easy to reuse and upgrade without affecting other code.


                ------------    Steps to convert:    ------------

                Copy existing code from Help3.java to save time.

                Identify what belongs to the help system:
                    Displaying a menu.
                    Checking user input.
                    Showing help information.

                Define three methods in the Help class:
                    showMenu(): Displays the menu.
                    isValid(): Checks for valid input.
                    helpOn(): Displays help information.

                Exclude unrelated parts:
                    How user input is taken.
                    Repeated request handling.
*/

// ----  rev [012May-2025]  ----
// 119.0-124.7

// recall 

class HelpClassDemo {
    public static void main(String args[]) throws java.io.IOException {
        char choice, ignore;
        
        for(;;) {
            do {

                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while(ignore != '\n');

            } while( choice < '1' | choice > '7' & choice != 'q');
            
            if(choice == 'q') break;
            System.out.println("\n");

        }
    }
}




// The entire listing for HelpClassDemo.java is shown here:


// Define help method 
class Help {
    void helpOn(int choice) {
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

    void showMenu() {
        System.out.println("Help on:");
        System.out.println(" 1. if");
        System.out.println(" 2. switch");
        System.out.println(" 3. for");
        System.out.println(" 4. while");
        System.out.println(" 5. do-while");
        System.out.println(" 6. break");
        System.out.println(" 7. continue\n");

        System.out.print("Choose one (q to quit): ");
    }

    boolean isValid(int ch) {
        if((ch < '1' | ch > '7') & ch != 'q') return false;
        else return true;
    }
}




class HelpClassDemo {
public static void main(String args[])
throws java.io.IOException {

char choice, ignore;
Help hlpobj = new Help();
for(;;) {
do {
hlpobj.showMenu();
choice = (char) System.in.read();
do {
ignore = (char) System.in.read();
} while(ignore != '\n');
} while( !hlpobj.isValid(choice) );
if(choice == 'q') break;
System.out.println("\n");
hlpobj.helpOn(choice);
}
}
}
When you try the program, you will find that it is functionally the same as before. The
advantage to this approach is that you now have a help system component that can be reused
whenever it is needed


