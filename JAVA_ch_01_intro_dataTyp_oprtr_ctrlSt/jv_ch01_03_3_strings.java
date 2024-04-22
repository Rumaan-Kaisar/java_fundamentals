
/*  -=-=-=-=-=-=-=-=-=-=-=      String literals      -=-=-=-=-=-=-=-=-=-=-=

    String literals 
        In Java string is always inside double quotes "". 
        And character constant is inside single quotes ' '. So 'k' and "k" are not the same. 
        'K' is for "character constant" and "K" is for "character string". 


    --------------- character literals : single quote ----------------
    '' vs ""
        '' is used for single character or charcter constants
                char ch_dmo = 'b'; 
        "" used for strings
                "this is a test"
        similar to C++

        You must not confuse STRINGS with CHARACTERS. 
            A character literal represents a single letter of "type char". Eg: 'a'
            
        A string containing only one letter is still a string.
            Although strings consist of characters, they are not the same type. Eg. "a"

          

    --------------- character literals : escape sequence ----------------
    To print escape sequnces for \', \", \\, \r, \n, \t, \b, \f, \ddd etc use single quotes ''
        For example, this assigns ch the tab character:
            ch = '\t';
        
        The next example assigns a single quote to ch:
            ch = '\'';
        


    --------------- string literals : double quote ----------------
    A string is a set of characters enclosed by double quotes. For example, "this is a test"
        String str;
        str = "First line\nSecond line";
        System.out.println(str);  

        Notice how the "\n" escape sequence is used to generate a new line. 
        You don't need to use multiple println( ) statements to get multiline output.

    Use '\n' to generate a new line.
    Use tabs '\t' to align output.
*/




/* Example 1: Following program uses the \n and \t escape sequences. */

// Demonstrate escape sequences in strings.
class StrDemo {
    public static void main(String args[]) {
        String str;

        str = "First line\nSecond line";
        System.out.println(str);
        System.out.println("A\tB\tC");
        System.out.println("D\tE\tF");
    }
}


