
/* -=-=-=-=-=-=-=-=-=-=-=      if-else      -=-=-=-=-=-=-=-=-=-=-= 


1.19 if-else, Nested if, if-else-if ladder
	if, if-else : Everything is similar to C/C++. In Java "if(condition)" is used and in C/C++ "if(expression)" is used. In Java "condition" must be a "Boolean expression " which returns true/false value. (Recall C/C++ 2.3, 2.4)
	Nested if : In a nested if-else, an invisible block appears around the nearest if-else of the same visible block. Eg: 

if(i == 10) { if(j < 20) a = b;
if(k > 100) c = d;
else a = c;   // this else refers to if(k > 100), Makes an if-else block. Both reacts when "j<20" is true. None will be executed when "k<20" is false
}
else a = d;   // this else refers to if(i == 10)
	The key point about nested ifs in Java is that an else statement always refers to the nearest if statement that is within the same block as the else and not already associated with an else. (Recall C/C++ 2.10 Last portion)
	if-else-if ladder: Exactly same as C/C++ and "condition" must be used instead of "expression". Last else act as default condition. 



1.20 Switch statement(similar C/C++ switch . Recall C/C++ 2.17)
In C/C++ we used only value to control switch i.e. "switch(value){ }" where value must be int or char constant. In Java we use "expression" i.e "switch(expression){ }", generally expression must be of the types: byte, short, int, char or an enumeration. In JDK 7, expression can also be of type String. This means that modern versions of Java can use a string to control a switch. 
	Frequently, the expression controlling a switch is simply a variable rather than a larger expression.
	Each value specified in the case statements must be a unique constant expression (such as a literal value).
	You can have empty cases (Recall C/C++ 2.17 Note 8), as shown in this example:
switch(i) { 	case 1:
case 2:
case 3: System.out.println("i is 1, 2 or 3"); break;
case 4: System.out.println("i is 4"); break; }
In this fragment, if i has the value 1, 2, or 3, the first println() statement executes. If it is 4, the second println() statement executes. The “stacking” of cases, as shown in this example, is common when several cases share common code.
	Nested Switch: Similar to C/C++ 2.18 Nested switch.


*/



