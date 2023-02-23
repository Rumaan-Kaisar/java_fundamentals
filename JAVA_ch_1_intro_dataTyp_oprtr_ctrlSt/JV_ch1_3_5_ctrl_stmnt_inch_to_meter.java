
public class JV_ch1_3_5_ctrl_stmnt_inch_to_meter {
    public static void main(String args[]) {
        double meter, inch;
        int counter;

        counter = 0;

        for(inch = 1; inch <= 144; inch++) {
            meter = inch / 39.37; // convert to meters
            System.out.println(inch + " inch is " + meter + " meter.");

            counter++;

            // every 10th line, print a blank line
            if(counter == 10) {
                System.out.println();
                counter = 0; // reset the line counter
            }
        }
    }
}