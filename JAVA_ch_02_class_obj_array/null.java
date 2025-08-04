
// ----------------    self test    ----------------

/*  

1. What is the difference between a class and an object?
2. How is a class defined?
3. What does each object have its own copy of?
4. Using two separate statements, show how to declare an object called counter of a class
called MyCounter.
5. Show how a method called myMeth( ) is declared if it has a return type of double and has
two int parameters called a and b.
6. How must a method return if it returns a value?
7. What name does a constructor have?
8. What does new do?
9. What is garbage collection, and how does it work? What is finalize( )?
10. What is this?
11. Can a constructor have one or more parameters?
12. If a method returns no value, what must its return type be?



1. What is the difference between a class and an object?
A class is a logical abstraction that describes the form and behavior of an object. An object is a
physical instance of the class.
2. How is a class defined?
A class is defined by using the keyword class. Inside the class statement, you specify the code and
data that comprise the class.Appendix A: Answers to Self Tests 623
3. What does each object have its own copy of?
Each object of a class has its own copy of the class’ instance variables.
4. Using two separate statements, show how to declare an object called counter of a class
called MyCounter.
MyCounter counter;
counter = new MyCounter();
5. Show how a method called myMeth( ) is declared if it has a return type of double and has
two int parameters called a and b.
double myMeth(int a, int b) { // ...
6. How must a method return if it returns a value?
A method that returns a value must return via the return statement, passing back the return value in
the process.
7. What name does a constructor have?
A constructor has the same name as its class.
8. What does new do?
The new operator allocates memory for an object and initializes it using the object’s constructor.
9. What is garbage collection and how does it work? What is finalize( )?
Garbage collection is the mechanism that recycles unused objects so that their memory can be reused.
An object’s finalize( ) method is called just prior to an object being recycled.
10. What is this?
The this keyword is a reference to the object on which a method is invoked. It is automatically passed
to a method.
11. Can a constructor have one or more parameters?
Yes.
12. If a method returns no value, what must its return type be?
void


*/
