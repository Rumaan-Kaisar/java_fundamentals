
/*  ------------    Chapter 1 Self Test    ------------

    Example 1. What is bytecode and why is it important to Java’s use for Internet programming?

    Bytecode is a highly optimized set of instructions that is executed by the Java Virtual Machine.
    Bytecode helps Java achieve both portability and security.




    Example 2. What are the three main principles of object-oriented programming?

    Encapsulation, polymorphism, and inheritance




    Example 3. Where do Java programs begin execution?

    Java programs begin execution at main( )




    Example 4. What is a variable?

    A variable is a named memory location. The contents of a variable can be changed during the execution
    of a program.




    Example 5. Which of the following variable names is invalid?
    A. count
    B. $count
    C. count27
    D. 67count

    The invalid variable is "D. 67count" Variable names cannot begin with a digit




    Example 6. How do you create a single-line comment? How do you create a multiline comment?

    A single-line comment begins with // and ends at the end of the line. A multiline comment begins with
    |* and ends with *|




    Example 7. Show the general form of the "if" statement. Show the general form of the "for loop".

    The general form of the if:
        if(condition) statement;
    The general form of the for:
        for(initialization; condition; iteration) statement;




    Example 8. How do you create a block of code?
    A block of code is started with a { and ended with a }.




    Example 9. The moon’s gravity is about 17 percent that of earth’s. Write a program that computes your
    effective weight on the moon.
        //
        Compute your weight on the moon.
        Call this file Moon.java.
        //

        class Moon {
            public static void main(String args[]) {
            double earthweight; // weight on earth
            double moonweight; // weight on moon

        earthweight = 165;
        moonweight = earthweight * 0.17;
        System.out.println(earthweight +
        " earth-pounds is equivalent to " +
        moonweight + " moon-pounds.");
        }
        }


        // Compute your weight on the moon.
        class JV_ch1_1_1_moon_weight {
            public static void main(String args[]) {
                double earthweight; // weight on earth
                double moonweight; // weight on moon
            
                earthweight = 165;
                moonweight = earthweight * 0.17;

                System.out.println(earthweight + " earth-pounds is equivalent to " + moonweight + " moon-pounds.");
            }
        }




    Example 10. Adapt Try This 1-2 so that it prints a conversion table of inches to meters. Display 12 feet
    of conversions, inch by inch. Output a blank line every 12 inches. (One meter equals
    approximately 39.37 inches.)

        //
        This program displays a conversion
        table of inches to meters.
        Call this program InchToMeterTable.java.
        //
        class InchToMeterTable {
            public static void main(String args[]) {
            double inches, meters;
            int counter;
            counter = 0;
            for(inches = 1; inches <= 144; inches++) {
            meters = inches / 39.37; // convert to meters
            System.out.println(inches + " inches is " +
            meters + " meters.");
            counter++;
            // every 12th line, print a blank line
            if(counter == 12) {
            System.out.println();
            counter = 0; // reset the line counter
            }
            }
            }
            }




    Example 11. If you make a typing mistake when entering your program, what sort of error will result?
    A syntax error.



    Example 12. Does it matter where on a line you put a statement? 
    No, Java is a free-form language
*/