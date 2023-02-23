
public class JV_ch1_3_4_ctrl_stmnt_gallon_liter {
    public static void main(String args[]) {
        double gallons, liters;
        int counter;

        counter = 0;

        for(gallons = 1; gallons <= 100; gallons++) {
            liters = gallons * 3.7854; // convert to liters
            System.out.println(gallons + " gallons is " + liters + " liters.\n");

            counter++;

            // every 10th line, print a blank line
            if(counter == 10) {
                System.out.println();
                counter = 0; // reset the line counter
            }
        }
    }
}