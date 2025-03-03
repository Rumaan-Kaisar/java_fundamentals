
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


    Notice in the example that "Vehicle" is used twice to "declare an object" 
        one as type fashion (object's type) and 
        another is as method fashion "Vehicle()" with the keyword "new". 
        [Actually Vehicle() is the Vehicle class's default constructor]

            // Declaring a Vehicle object called minivan
            Vehicle minivan = new Vehicle();


    To declare an object of class type "classname" we use, general form:

            classname object_name = new classname();

        After this statement executes, "object_name"  will be an instance of "classname".
        Each time you create an instance of a class, you are creating an object that contains 
            its own copy of each instance variable defined by the class.
        Changes in one object don’t affect another, even though they share the same class type.


    When following line is executed, two things happen:

            Vehicle minivan = new Vehicle();

        "Vehicle minivan" declares a variable that can refer to a Vehicle object but doesn't create one.
        "new Vehicle()" creates an object in memory, and minivan stores its reference.        

        The statement can be split into two steps:

            Vehicle minivan;            // Declares a reference to a Vehicle object  
            minivan = new Vehicle();    // Creates a Vehicle object and assigns its reference to minivan  

        The first line declares minivan as a reference but doesn't create an object.
        The second line creates a Vehicle object and assigns its reference to minivan.


    In Java, objects of a class must be created dynamically using the new operator. 
        The new operator dynamically allocates (i.e., allocates at run time) memory for an object and returns a reference to it.
            This means memory for the object is allocated at runtime, rather than at compile time.
        This reference is, more or less, the address in memory of the object allocated by new (reference is kind of pointer). 
            This reference is then stored in a variable. 
        "new" used here with class's "default constructor" to initialize the object.


    To access an object's instance variables, use the dot (.) operator. 
        It connects the object's name with a member's name.

            object.member

        Example:
            minivan.fuelcap = 16;



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



    
// ----  rev[24-Feb-2025]  ----

*/






/* Example 1: (Using the Vehicle Class)
                This program is saved in VehicleDemo.java because the main() method (the program’s starting point) 
                is in the VehicleDemo class, not the Vehicle class.

                What happens when you compile?
                    Two ".class" files are created: Vehicle.class and VehicleDemo.class.
                        (Java automatically creates a separate "compiled file" for each class.)
                        one for Vehicle and one for VehicleDemo

                classes can be in seperate files:
                    Each class can be in its own file, called Vehicle.java and VehicleDemo.java, respectively.
                    But we must run VehicleDemo.class (since it contains the main() method).
*/

// a class
class Vehicle{	
    int passengers; 
    int fuelcap; 
    int mpg;  
}
    
// main class, starting point of the program
class VehicleDemo {	
    public static void main(String args[]) {
        // crating an object of Vehicle class
        Vehicle minivan = new Vehicle();
        int range;

        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        range = minivan.fuelcap * minivan.mpg;
        System.out.println("Minivan can carry " + minivan.passengers +
        " with a range of " + range);
    } 
}


