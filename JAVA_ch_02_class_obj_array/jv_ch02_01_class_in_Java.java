
/* -=-=-=-=-=-=-=-=-=-=-=      Class in java      -=-=-=-=-=-=-=-=-=-=-= 

2.1 Class in java
The methods and variables that constitute a class are called members of the class. These members are also called instance variables. The objects of a class are called instances of that class. Keyword class is used to create a class. The simplified form of a class in Java:

class classname {		// declare instance variables
type var1; 
type var2;
       ...
type varN;

// declare methods
type method1(parameters) { /* body of method */ }
type method2(parameters) { /* body of method */ }
...
		type methodN(parameters) { /* body of method */ }}

/* defining a class of type Vehicle */
class Vehicle {	int passengers; 	// number of passengers
    int fuelcap;  	// fuel capacity in gallons
    int mpg;       // fuel consumption in miles -gallon
          }

/* Declaring a Vehicle object called minivan */
Vehicle minivan = new Vehicle(); 

	Notice that the general form of a class does not specify a main() method. A main() method is required only if that class is the starting point for your program. Also, some types of Java applications, such as applets, don’t require a main().
	Notice in the example that Vehicle is used twice to declare an object one as type fashion (object's type) and another is as method fashion [Actually Vehicle() is the Vehicle class's default constructor see 2.5] with the keyword "new". To declare an object of class type "classname" we use,			classname object_name = new classname();
After this statement executes, object_name  will be an instance of classname.
[Each time you create an instance of a class, you are creating an object that contains its own copy of each instance variable defined by the class. Thus, the contents of the variables in one object can differ from the contents of the variables in another. There is no connection between the two objects except for the fact that they are both objects of the same type.]
	Following two things happened when this line used to declare an object of type Vehicle,         Vehicle minivan = new Vehicle();
[1]	It declares a variable called minivan of the class type Vehicle by " Vehicle minivan". This variable does not define an object. Instead, it is simply a variable that can refer to an object. 
[2]	The declaration creates a physical copy of the object and assigns to minivan a reference to that object by using new.
	In Java, all class objects must be dynamically allocated: The new operator dynamically allocates (i.e., allocates at run time) memory for an object and returns a reference to it. This reference is, more or less, the address in memory of the object allocated by new (reference is kind of pointer). This reference is then stored in a variable. new used here with class's default constructor.
	The two steps combined in the preceding statement can be rewritten like this to show each step individually:
Vehicle minivan; 		// declare reference to object
minivan = new Vehicle(); 	// allocate a Vehicle object using class's default constructor Vehicle()
	The first line declares minivan as a reference to an object of type Vehicle. Thus, minivan is a variable that can refer to an object, but it is not an object itself. At this point, minivan does not refer to an object. 
	The next line creates a new Vehicle object and assigns a reference to it to minivan. Now, minivan is linked with an object.
	To access these instance variables of an object, use the dot (.) operator. It links the name of an object with the name of a member.  The general form,  	object.member		Example:	   minivan.fuelcap = 16;

	Example 1: complete code that uses the Vehicle class 
	The file that contains this program is VehicleDemo.java because the main() is in the class called VehicleDemo, not the class called Vehicle. 
	When you compile this program, two .class files will be created, one for Vehicle and one for VehicleDemo. The Java compiler automatically puts each class into its own .class file. 
	It is not necessary for both the Vehicle and the VehicleDemo class to be in the same source file. Each class can be in its own file, called Vehicle.java and VehicleDemo.java, respectively.
	To run this program, you must execute VehicleDemo.class.


class Vehicle{	int passengers; 
    int fuelcap; 
    int mpg;  }
    
    class VehicleDemo {	/* main class, starting point of the program  */
    public static void main(String args[]) {
    Vehicle minivan = new Vehicle();
    int range;
    
    minivan.passengers = 7;
    minivan.fuelcap = 16;
    minivan.mpg = 21;
    
    range = minivan.fuelcap * minivan.mpg;
    System.out.println("Minivan can carry " + minivan.passengers +
    " with a range of " + range);
    } }
    
*/
