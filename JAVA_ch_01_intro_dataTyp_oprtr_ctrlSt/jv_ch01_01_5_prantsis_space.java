
/*  -=-=-=-=-=-=-=-=-=-=-=      Spacing and parenthesis      -=-=-=-=-=-=-=-=-=-=-= 
    readability:
        An expression in Java may have tabs and spaces in it to make it more readable
        The two expressions are the same, but the second is easier to read: 	
            x=10/y*(127/x);	 
            x = 10 / y * (127/x);

        Additional spaces makes a good readable code.

    precedence:
        Parentheses 'increase the precedence of the operations' contained within them, just like in ALGEBRA. 
        Use of 'redundant or additional parentheses' will not cause ERRORS or SLOW down the EXECUTION of the expression. 
    
        For example, which of the following two expressions is easier to read?

            x = y/3-34*temp+127;
            x = (y/3) - (34*temp) + 127;
*/





/* ----------------    Semicolons and Positioning    ----------------
    ';' used to terminate a statement. 
        each individual statement must be ended with a semicolon.
        

    Block of code: 
        A block is a set of logically connected statements that are surrounded by '{' and '}'
        A block is NOT terminated by a semicolon ';'
            instead, the end of the block is indicated by the closing brace.


    Line-breaks or multiline:
        Java does not recognize the end of the line as a 'terminator'. 
        the ';' is actual terminator
        For this reason, it does not matter where on a line you put a statement. For example,
                x = y;
                y = y + 1;
                System.out.println(x + " " + y);

        is the same as the following, to Java:

                x = y; y = y + 1; System.out.println(x + " " + y);


        Furthermore, the individual elements of a statement can also be put on separate lines. 
            Following is perfectly acceptable:
                System.out.println("This is a long line of output" +
                x + y + z +
                "more output");
            Breaking long lines in this fashion makes "more readable" code.


    Indentation Practices:
        In Java it does not matter where you place statements relative to each other on a line. 
            indentation style is allowed for more readable programs.
*/

