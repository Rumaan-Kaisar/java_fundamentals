/* Compute your weight on the moon. */
class JV_ch1_1_1_moon_weight {
    public static void main(String args[]) {
        double earthweight; // weight on earth
        double moonweight; // weight on moon
    
        earthweight = 165;
        moonweight = earthweight * 0.17;

        System.out.println(earthweight + " earth-pounds is equivalent to " + moonweight + " moon-pounds.");
    }
}