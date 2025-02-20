
/* -=-=-=-=-=-=-=-=-=-=-=      Class in java      -=-=-=-=-=-=-=-=-=-=-= 

    Classes in Java:
        All Java program activities happen within a class. 
        While we've been using simple classes so far, Java classes have much more power and flexibility.

        Class Definition:
            A class is a "template" that defines an object’s structure. 
            It includes both the 
                -   data (instance variables) and 
                -   methods (code) that operate on that data.

    Object:
        The objects of a class are called instances of that class, 
            essentially created using the class as a blueprint.

        Here, a class plays the role of "logical design", and it only gets 
            a physical representation in memory when an object of that class is created

    Class Members:
        The components of a class, including "methods" and "variables", are called members. 
        These members are also called instance variables



    --------------------    The General Form of a Class    --------------------
    Keyword "class" is used to create a class. The simplified form of a class in Java:

                class classname {		
                    // declare instance variables
                    type var1; 
                    type var2;
                        ...
                    type varN;


                    // declare methods
                    type method1(parameters) { 
                        // body of method 
                    }

                    type method2(parameters) { 
                        // body of method 
                    }
                        ...
                        ...
                        ...

                    type methodN(parameters) { 
                        // body of method 
                    }
                }

        A class defines a LOGICAL ENTITY by specifying "instance variables" and "methods" that operate on them. 
            It is created using the "class" keyword. 
            A well-designed class should group logically related information. 



    -------------  Break down main()  -------------

    Notice that the "general form" of a class does not specify a main() method. 
    A main() method is required only if that class is the "starting point" for your program.
    Some Java applications, like applets, don't require a main() method.



    -------------  default access level for class members  -------------

    For both C++ and Java the class members are "Private by default".
    That's why "public" is used in public static void main(String[] args)
        to make it accessible from outside the class (which is the entry point for running a Java program),
        it must be accessible by the Java Virtual Machine (JVM) from outside the class to start executing the program.
        
    Additionally:
        "static" allows the method to be called without creating an instance of the class 
            (since main is executed before any objects are created).
        "void" means the method doesn’t return any value.
        "String[] args" allows command-line arguments to be passed into the program.



    -------------  defining a class and Declaring a object  -------------

    // Defining a class of type "Vehicle"
    class Vehicle {	
        int passengers;  // Number of passengers
        int fuelcap;     // Fuel capacity in gallons
        int mpg;         // Fuel consumption in miles per gallon
    }

    // Declaring a Vehicle object called minivan
    Vehicle minivan = new Vehicle();



    ----------------    Java vs C++ Classes (Brief Comparison):    ----------------

    1. Memory Management:
            Java:   Automatic garbage collection.
            C++:    Manual with `new` and `delete`.

    2. Inheritance:
            Java:   Single inheritance, multiple via interfaces.
            C++:    Supports multiple inheritance.

    3. Access Control:
            Java:   `public`, `protected`, `private`, default.
            C++:    `public`, `private`, `protected`.

    4. Constructor/Destructor:
            Java:   Constructor for init, `finalize()` for cleanup (garbage collection).
            C++:    Constructor and destructor required for resource management.

    5. Object Creation:
            Java:   `new` for objects, garbage collection.
            C++:    `new` for heap, stack auto-destroys objects.

    6. Multiple Inheritance:
            Java:   No direct multiple inheritance, via interfaces.
            C++:    Direct multiple inheritance allowed.

    7. Method Overloading/Overriding:
            Java:   Overloading and overriding supported.
            C++:    Overloading supported, `virtual` for overriding.

    8. Pointers:
            Java:   No pointers, uses references.
            C++:    Uses pointers, allows direct memory manipulation.

    9. Exception Handling:
            Java:   Requires method declarations for exceptions.
            C++:    Optional exception declarations.

    10. Virtual Functions:
            Java:   All methods are virtual by default.
            C++:    Needs `virtual` keyword for polymorphism.

    11. Default Constructor:
            Java:   Default provided if not defined.
            C++:    Default only if no other constructors are defined.

    12. Static Methods:
            Java:   Can be called without class instances.
            C++:    Can access static members.

    13. Static Variables:
            Java:   Shared across all instances.
            C++:    Shared across all instances, tied to class lifetime.


    |         Feature               |         Java                                      |         C++                                                   |
    |-------------------------------|---------------------------------------------------|---------------------------------------------------------------|
    | Memory Management             | Automatic garbage collection                      | Manual with `new` and `delete`                                |
    | Inheritance                   | Single inheritance, multiple via interfaces       | Supports multiple inheritance                                 |
    | Access Control                | `public`, `protected`, `private`, default         | `public`, `private`, `protected`                              |
    | Constructor/Destructor        | Constructor for init, `finalize()`                | Constructor and destructor required for resource management   |
    |                               |       (garbage collection)                        |                                                               |
    | Object Creation               | `new` for objects, garbage collection             | `new` for heap, stack auto-destroys objects                   |
    | Multiple Inheritance          | No direct multiple inheritance, via interfaces    | Direct multiple inheritance allowed                           |
    | Method Overloading/Overriding | Overloading and overriding supported              | Overloading supported, `virtual` for overriding               |
    | Pointers                      | No pointers, uses references                      | Uses pointers, allows direct memory manipulation              |
    | Exception Handling            | Requires method declarations for exceptions       | Optional exception declarations                               |
    | Virtual Functions             | All methods are virtual by default                | Needs `virtual` keyword for polymorphism                      |
    | Default Constructor           | Default provided if not defined                   | Default only if no other constructors are defined             |
    | Static Methods                | Can be called without class instances             | Can access static members                                     |
    | Static Variables              | Shared across all instances                       | Shared across all instances, tied to class lifetime           |



    
// ----  rev[20-Feb-2025]  ----

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
