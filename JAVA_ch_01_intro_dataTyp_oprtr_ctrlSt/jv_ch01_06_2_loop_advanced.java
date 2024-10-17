
/* -=-=-=-=-=-=-=-=-=-=-=      LOOPS      -=-=-=-=-=-=-=-=-=-=-= 

// ----  rev[17-Oct-2024]  ----

GPT: give important points to remember, important facts / aspects of following in JAVA. Also control-flow mechanism and difference from C/C++. 

for loop variations
while 
do-while
nested loops


    ------------    FOR loop    ------------
    Following are the most traditional forms of the for

        Repeats a single statement:

            for(initialization; condition; iteration) statement;


        Repeats a block:

            for(initialization; condition; iteration){
                statement sequence
            }




1.21 for loop (with variations)[ Recall C/C++ 2.5 , 2.11 ]
Similar to C/C++'s for loop  for(initialization; condition; iteration) {statement;}
The initialization is usually an assignment statement that sets the initial value of the loop control variable, which acts as the counter that controls the loop. The condition is a Boolean expression that determines whether or not the loop will repeat. The iteration expression defines the amount by which the loop control variable will change each time the loop is repeated. Notice that these three major sections of the loop must be separated by semicolons.
	Some Variations on the for Loop
[1]	Multiple loop control variables can be used in the for loop. Multiple loop control variables are often convenient and can simplify certain algorithms. Any number of initialization and iteration statements are possible, but, more than two or three make the for loop unwieldy. Consider the following code:
for(i=0, j=10; i<j; i++, j--) System.out.println("i and j: " + i + " " + j);
	Here, commas separate the two initialization statements and the two iteration expressions. When the loop begins, both i and j are initialized. Each time the loop repeats, i is incremented and j is decremented. 
[2]	The condition controlling the loop can be any valid Boolean expression. It does not need to involve the loop control variable. Eg: the loop continues to execute until the user types the letter S at the keyboard:
for(i = 0;  (char)System.in.read() != 'S';  i++) System.out.println("Pass #" + i);
[3]	It is possible for any or all of the initialization, condition, or iteration portions of the for loop to be blank.  For example, 
for(i=0; i<10; ) { 	System.out.println("Pass #" + i);
i++; }  	// increment loop control variable is inside the for loop 
	or iteration may not present at all. Eg:
for(i = 0;  (char)System.in.read() != 'S';  ) System.out.println("Again");
	The initialization portion can be moved out of the for:
int i = 0; 				// move initialization out of loop
for( ; i<10 ; ) { 	System.out.println("Pass #" + i); i++; }  
	The Infinite Loop: To create an infinite loop use the for by leaving the conditional expression empty. Eg:
for(;;){ } // intentionally infinite loop
This loop will run forever. (It can be terminated by using the break statement.)
[4]	Loops with No Body: In Java, the body associated with a for loop (or any other loop) can be empty. This is because a null statement is syntactically valid. They are often useful. For example, the following program uses one to sum the numbers 1 through 5: 	for(i = 1; i <= 5; sum += i++) ;
	Notice that the summation process is handled entirely within the for statement, and no body is needed. 
	Pay special attention to the iteration expression: 	sum += i++. It is equivalent to:    sum = sum + i; i++;
[5]	Declaring Loop Control Variables Inside the for Loop: Often the variable that controls a for is needed only for the purposes of the loop and is not used elsewhere. In this case, we declare the variable inside the initialization portion of the for. Eg:
int sum = 0, fact = 1;
for(int i = 1; i <= 5; i++) { 	sum += i; 	// i is known throughout the loop
fact *= i; }
	In this example, i is not accessible outside the for loop. If you need to use the loop control variable elsewhere in your program, you will not be able to declare it inside the for loop.
	Note: the scope of that variable ends when the for statement does. (That is, the scope of the variableis limited to the for loop.) Outside the for loop, the variable will cease to exist. 
[6]	The Enhanced for Loop: Relatively recently, a new form of the for loop, called the enhanced for, was added to Java. The enhanced for provides a streamlined way to cycle through the contents of a collection of objects, such as an array. We'll discuss with array.



1.22 while and do-while loop (similar to C/C++)
While loop:  	while(condition){}	Do-While loop: 	do{}while(condition);



1.23 Nested Loops: 	One loop can be nested inside of another. Eg: To find factors of numbers
for(int i=2; i <= 100; i++){ System.out.print("Factors of " + i + ": ");
  for(int j=2; j<i; j++) if((i%j) == 0) System.out.print(j + " ");
  System.out.println(); }




  -=-=-=-=-  GPT  -=-=-=-=-

  
*/



