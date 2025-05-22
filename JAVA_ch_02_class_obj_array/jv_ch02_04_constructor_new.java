
/* -=-=-=-=-=-=-=-=-=-=-=      chapter name      -=-=-=-=-=-=-=-=-=-=-= 

// jv_ch02_04_constructor_new          2.5+2.6     124.7-128.5

// rev [19-May-2025]

Constructor:
A constructor initializes an object (i.e. to give initial values to the instance variables defined by the class) 
when it is created or to perform any other startup procedures required to create a fully formed object. 
It has the same name as its class and is syntactically similar to a method. 
However, constructors have no explicit return type. 

Java's Default constructor: 
All classes have constructors, whether you define one or not, 
because Java automatically provides a default constructor that initializes all member variables to their default values, 
which are zero, null, and false, for numeric types, reference types, and booleans, respectively. 
However, once you define your own constructor, the default constructor is no longer used. Example:

--------------------------

Constructor (Simplified)
A constructor initializes an object when it’s created.

It can set initial values for instance variables or run startup procedures.

A constructor has the same name as its class.

It looks like a method but has no return type (not even void).

Java’s Default Constructor
Every class in Java automatically has a default constructor if no constructor is written.

This default constructor initializes:

Numeric types to 0

Reference types to null

Booleans to false

If you create your own constructor, the default one is no longer provided.

--------------------------






class MyClass { int x;
   MyClass(){ x = 10; }  }	class ConsDemo { public static void main(String args[]) {
	MyClass t1 = new MyClass(); 	// parameter-less initialization 
	MyClass t2 = new MyClass(); 	// parameter-less initialization 
	System.out.println(t1.x + " " + t2.x); 	}}
	Constructor is called by new when an object is created. For example, in the line 	MyClass t1 = new MyClass();
the constructor MyClass() is called on the t1 object, giving t1.x the value 10. The same is true for t2. After construction, t2.x has the value 10. Thus, the output from the program is 10 10. 
	i.e., in general from of object in 2.1,     classname object_name = new classname();  in the part "new  classname()" 
classname() is the class's default constructor.
	Parameterized constructor: It has the same name as its class and is syntactically similar to a parameterized method. Parameterized constructor is used to initialize objects on-spot (by setting values of member variables from constructor), for example,

class MyClass { int x;
   MyClass(int i){ x = i; }  }	class PeramConsDemo { public static void main(String args[]) {
	MyClass t1 = new MyClass(10); 	// parameter-less initialization
	MyClass t2 = new MyClass(88); 	// parameter-less initialization
	System.out.println(t1.x + " " + t2.x); 	}}
	The  MyClass() constructor defines one parameter called i, which is used to initialize the instance variable, x. Thus, when 
 MyClass t1 = new MyClass(10); 	executes, the value 10 is passed to i, which is then assigned to x.
Constructor without parameter	Parameterized constructor
class Vehicle{	int passengers; 
int fuelcap; 
int mpg;  }

class VehicleDemo {public static void main(String args[]) {
Vehicle minivan = new Vehicle();

minivan.passengers = 7;
minivan.fuelcap = 16;
minivan.mpg = 21;
// . .  . .  . .  . .  . .  . .  . .  . .  . .
} }	class Vehicle{	int passengers; 
int fuelcap; 
int mpg;  
Vehicle(int p, int f, int m){ 	passengers = p;
			Fuelcap = f;
			Mpg = m;
}

class VehicleDemo {public static void main(String args[]) {
Vehicle minivan = new Vehicle(7, 16, 21);
// . .  . .  . .  . .  . .  . .  . .  . .  . .
} }
	Vehicle minivan = new Vehicle(7, 16, 21); is much more easier than using "." for each member variable Eg: minivan.mpg = 21;
	Difference with C++ : In C++ we would use,  Vehicle minivan(7, 16, 21); to initialize the object minivan instantly.

2.6 General form of "new" and details about object declaration (Recall C/C++'s 10.11)
The new operator has this general form: 	class_variable = new class-name(arg-list);
	Here, class_variable is a variable of the class type being created. The class-name is the name of the class that is being instantiated. The class name followed by a parenthesized argument list (which can be empty) i.e. class-name(arg-list) specifies the constructor for the class. If a class does not define its own constructor, new will use the default constructor supplied by Java. 
	The new operator returns a reference to the newly created object, which (in this case) is assigned to class-var.
	A run-time exception will occur if new is unable to allocate memory for an object because insufficient memory space.



*/
