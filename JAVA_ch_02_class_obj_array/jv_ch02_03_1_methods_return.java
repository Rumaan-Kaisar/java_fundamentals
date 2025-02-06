
/* -=-=-=-=-=-=-=-=-=-=-=      Methods and returning from methods      -=-=-=-=-=-=-=-=-=-=-= 

Methods are similar to C/C++'s "functions". The general form of a Java method is:
ret-type name( parameter-list ) { /* body of method */ }
The ret-type is the return type of the function. If the function returns no value then the ret-type must be void.
	Note: In C/C++ we can define a function inside of a class or outside of a class. We used the scope resolution operator (::) to define a function outside of class. But in Java it is un-common. In Java methods are usually defined inside a class, so it is un-common to use the scope resolution operator (::) to define a method outside of its class.  


	Returning from a Method: there are two conditions that cause a method to return
[1]	First, when the method’s closing curly brace is encountered. 
[2]	Second, when a return statement is executed. 


	Return : There are two forms of return:
[a]	One for void methods (those that do not return a value). The form is,   	return;
[b]	One for methods which return values. The form is, 	   return value;


	Second form of return can be used only with methods that have a non-void return type. Furthermore, a non-void method must return a value by using this "return value;" form of return. Example of The second form " return value;": 	
int range() { return x * y; }. 
	Notice that range() has a return type of int. i.e. it will return an integer value to the caller. The return type of a method is important because the type of data returned by a method must be compatible with the return type specified by the method. Thus, if you want a method to return data of type double, its return type must be type double. Eg:
double devide(int x, int y) { return (double) (x /y); }
Here a type cast is used to return "double value" from int values (which are int parameters of the method)
	It is permissible to have multiple return statements in a method, however, because having too many exit points (i.e. return statements) in a method can destructure code. A well-designed method has well-defined exit points.


*/

