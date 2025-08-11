
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
    Notice- up to this point, the classes that we have been using have had only one method: main().

        Also notice that the "general form" of a class does not specify a main() method. 
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
    Following class encapsulates information about vehicles, such as cars, vans, and trucks.
        A class definition creates a "new data type". In this case, the new data type is called "Vehicle".
        We will use this name to declare objects of type Vehicle. 
        Remember that a class declaration is only a type description; it does not create an actual object.

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



    ----------------    Connection between two objects of the same class    ----------------
    Each object has its own copies of the instance variables defined by its class.
        Thus, the contents of the variables in one object can differ from the contents of the variables in another
        Even if both objects are of the same type.
        The only link between the two objects is that they share the same type.

    For example, two Vehicle objects each have separate copies of variables like passengers, fuelcap, and mpg, which may hold different values.
    The program in the class TwoVehicles demonstrates this principle.



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

    14. Using };  :
            C++: After a class definition, a semicolon is required:

                    class MyClass {
                        // members
                    };

            Java: After a class definition, no semicolon is needed:

                    class MyClass {
                        // members
                    }


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



    ----------------    The Classic 3 OOP Principles:   ----------------
    All object-oriented languages (like Java, C++, Python, etc.) are typically defined by:

        Encapsulation:
            Bundling data and methods together, and restricting direct access to some of an object's components.

        Inheritance:
            Creating new classes from existing ones, inheriting fields and methods.

        Polymorphism:
            The ability for different classes to be treated through the same interface, 
            typically via method overriding or overloading.


    ----------------   So why do some add "Abstraction" as a fourth?   ----------------
    Because Abstraction is conceptually distinct from the other three — and equally important in OOP design.
    Even though it overlaps slightly with Encapsulation.

    Abstraction means:
        Hiding complex implementation details and showing only the necessary features to the user.

        For example, you can drive a car without knowing how its engine works internally — 
            you just interact with the steering, pedals, and gear.

        In code:
            Using abstract classes, interfaces, or method signatures without implementation.
            It helps reduce complexity and isolate impact of changes.


    Some teaching models list "3 core principles" (Encapsulation, Inheritance, Polymorphism), 
        while others expand it to 4 principles by explicitly naming "Abstraction" 
            because it plays a crucial role in good OOP design, even if it overlaps with the effects of encapsulation.

    Both views are correct — it's just about whether abstraction is "bundled conceptually with encapsulation" or highlighted separately. 
    Many modern OOP textbooks and instructors prefer emphasizing all four for clarity.
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
    int passengers;  // Number of passengers
    int fuelcap;     // Fuel capacity in gallons
    int mpg;         // Fuel consumption in miles per gallon
}
    
// main class, starting point of the program
class VehicleDemo {	
    public static void main(String args[]) {
        // crating an object of Vehicle class
        Vehicle minivan = new Vehicle();
        int range;

        // assigning instance variables of Vehicle class
        // Notice the use of the dot operator to access a member
        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        // calculating range of a minivan
        range = minivan.fuelcap * minivan.mpg;
        System.out.println("Minivan can carry " + minivan.passengers + " with a range of " + range);
    } 
}




/* Example 2: There is no connection between the two objects except for the fact that they are both objects of the same type. 

                In the following example we have two Vehicle objects, each has its own copy of passengers, fuelcap, and mpg, 
                and the contents of these can differ between the two objects. 

                The class with main() is now called TwoVehicles.
*/

// This program creates two Vehicle objects.
class Vehicle {
    int passengers;  // number of passengers
    int fuelcap;     // fuel capacity in gallons
    int mpg;         // fuel consumption in miles per gallon
}


// This class declares an object of type Vehicle.
class TwoVehicles {
    public static void main(String args[]) {
        Vehicle minivan = new Vehicle();
        Vehicle sportscar = new Vehicle();
        int range1, range2;

        // assign values to fields in minivan
        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        // assign values to fields in sportscar
        sportscar.passengers = 2;
        sportscar.fuelcap = 14;
        sportscar.mpg = 12;

        // compute the ranges assuming a full tank of gas
        range1 = minivan.fuelcap * minivan.mpg;
        range2 = sportscar.fuelcap * sportscar.mpg;
        System.out.println("Minivan can carry " + minivan.passengers + " with a range of " + range1);
        System.out.println("Sportscar can carry " + sportscar.passengers + " with a range of " + range2);
    }
}




/* Example 3:   What is the difference between a "class" and an "object"?
                How is a class defined?
                What does each object have its own copy of?

            ans:
                A class is a logical abstraction that describes the "form and behavior" of an object. 
                An object is a "physical instance" of the class.

                A class is defined by using the keyword "class". 
                Inside the class statement, you specify the code and data that comprise the class.

                Each object of a class has its own copy of the class's instance variables.
*/

