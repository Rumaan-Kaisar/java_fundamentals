
/* -=-=-=-=-=-=-=-=-=-=-=      chapter name      -=-=-=-=-=-=-=-=-=-=-= 

    Constructor (Simplified)
        A constructor initializes an object when it’s created.
        It can set initial values for "instance variables defined by the class" or run "startup procedures".
        A constructor has the same name as its class.
        It looks like a method but has no return type (not even void).


    Java’s Default Constructor
        Every class in Java automatically has a default constructor if no constructor is written.
        This default constructor initializes:
            Numeric types to "0"
            Reference types to "null"
            Booleans to "false"
        If you create your own constructor, the default one is no longer provided.

        When creating an object in Java using:
                ClassName objectName = new ClassName();
            The part "new ClassName()" calls the class's default constructor.


    Parameterized Constructor:
        A constructor (i.e. same name as its class) that takes parameters, like a method.
        It's used to initialize objects with specific values when they’re created.
        (by setting values of member variables from constructor)



    In following comparison
            Vehicle minivan = new Vehicle(7, 16, 21); 
        is much more easier than using "." for each member variable 
        Eg: minivan.mpg = 21;


                // Constructor without parameter	
                class Vehicle{
                    int passengers; 
                    int fuelcap; 
                    int mpg;  
                }

                class VehicleDemo { 
                    public static void main(String args[]) {
                        Vehicle minivan = new Vehicle();

                        minivan.passengers = 7;
                        minivan.fuelcap = 16;
                        minivan.mpg = 21;

                        // more codes
                    } 
                }	


                // Parameterized constructor
                class Vehicle{
                    int passengers; 
                    int fuelcap; 
                    int mpg;
                    // constructor with parameter
                    Vehicle(int p, int f, int m){
                        passengers = p;
                        Fuelcap = f;
                        Mpg = m;
                    }

                class VehicleDemo {
                    public static void main(String args[]) {
                        Vehicle minivan = new Vehicle(7, 16, 21);

                        // more codes
                    }
                }


    Difference with C++: 
        In C++ we would use,  
            Vehicle minivan(7, 16, 21); 
        to initialize the object minivan instantly.



    ----------------  new  ----------------

    General Form of "new" in Java:
        The new operator is used to create objects in Java.

                classVariable = new ClassName(argumentList);

            classVariable: the reference variable of the class type.
            ClassName(argumentList): calls the class's constructor (can be empty if no parameters).
                If no constructor is defined, Java uses a default constructor.

        What new Does
            Allocates memory for the object.
            Calls the specified constructor.
            Returns a reference to the newly created object.
            This reference is assigned to classVariable.


        Important Note
            If the system runs out of memory while using "new", a "run-time exception" occurs.
            This isn't an issue in small examples, 
                but in real applications, it needs to be handled properly (using exceptions, covered later).


    Why don't we use "new" for primitive types like 'int' or 'float' in Java?
        Primitive types are not objects in Java.
        They behave like regular variables and directly hold their value.
        Object variables, however, store a reference (like a pointer) to an object in memory.
        Using objects "adds extra overhead" (like managing references and object features).
        For efficiency, primitive types avoid this overhead by storing values directly without needing new.


        In C++:
            Primitive types like int, float, char, etc. are not objects — just like in Java.
            However, C++ allows you to allocate memory dynamically for primitive types using "new", like this:

                        int* p = new int;   // dynamically allocate an int ("heap" allocation)
                        *p = 10;

                This creates an int in "heap memory", and p holds its address.
                But this is optional in C++, you can still declare normal "stack variables" without new:

                        int x = 10;  // normal "stack" allocation

        In Java:
            Primitive types like int, float, char are also not objects.
            But Java does not allow using 'new' with primitive types — only for objects.
            Primitive variables directly store their value in memory.
            For example:

                        int x = 10;    // direct storage, no new
                        Integer y = new Integer(10);  // deprecated, but shows how objects are created



    ----  Stack Memory  ----
        A special memory area for storing "local variables" and "function call" information 
        (like parameters, return addresses).

        How it works:
            Memory is organized like a stack (LIFO — last in, first out).
            When a function is called, its local variables and information are pushed onto the stack.
            When the function ends, they're popped off automatically.


            Fast to allocate and free.
            Lifetime: Exists only while the function is running.

        Example:
            int x = 5;  // stored in stack


    ----  Heap Memory  ----
        A large pool of memory used for dynamic allocation — for data whose size or lifetime isn't known in advance.

        How it works:
            You manually request memory (using 'new' in C++, or 'new' in Java for objects).
            In C++, you must manually 'delete' it. In Java, garbage collection handles it.

            Slower to allocate/free than stack.
            Lifetime: Exists until explicitly freed (C++) or garbage collected (Java).

        Example:
            int* p = new int;  // stored in heap

*/




/* Example 1: In following program, the constructor for MyClass is

                        MyClass() {
                            x = 10;
                        }

                This sets the value of x to 10 when an object is created.

                Constructor is called by "new" when an object is created. For example, in the line
                        MyClass t1 = new MyClass();
                    the constructor MyClass() is called on the t1 object, giving t1.x the value 10. 

                The same is true for t2. 
                That's why the output is 10  10
*/

// A simple constructor.
class MyClass {
    int x;
    // This is the constructor for MyClass
    MyClass() {
        x = 10;
    }
}

// main class
class ConsDemo {
    public static void main(String args[]) {
        MyClass t1 = new MyClass();
        MyClass t2 = new MyClass();
        
        System.out.println(t1.x + " " + t2.x);
    }
}




/* Example 2: Following program uses parameterized constructor

            The  MyClass() constructor defines one parameter called i, 
                which is used to initialize the instance variable, x. 

            Thus, when 
                        MyClass t1 = new MyClass(10); 	
                executes, the value 10 is passed to i, which is then assigned to x.
*/


// A simple constructor.
class MyClass {
    int x;
    // constructor with a paramater i
    MyClass(int i) {
        x = i;
    }
}

// main class
class PeramConsDemo {
    public static void main(String args[]) {
        MyClass t1 = new MyClass(10);
        MyClass t2 = new MyClass(88);
        
        System.out.println(t1.x + " " + t2.x);
    }
}




/* Example 3: We can improve the Vehicle class by adding a constructor that automatically initializes 
                the passengers, fuelcap, and mpg fields when an object is constructed. 
                Notice how Vehicle objects are created. 


                Both minivan and sportscar are initialized using the Vehicle() constructor when they are created.
                    Each object is initialized as specified in the parameters to its constructor.

                The values given inside "new Vehicle(7, 16, 21)" are passed to the constructor.
                    These values set the object's passengers, fuelcap, and mpg.

                The program’s output will remain the same as before — just now, values are assigned through the constructor.

*/

class Vehicle {
    int passengers; // number of passengers
    int fuelcap; // fuel capacity in gallons
    int mpg; // fuel consumption in miles per gallon

    // This is a constructor for Vehicle.
    Vehicle(int p, int f, int m) {
        passengers = p;
        fuelcap = f;
        mpg = m;
    }

    // Return the range.
    int range() {
        return mpg * fuelcap;
    }

    // Compute fuel needed for a given distance.
    double fuelneeded(int miles) {
        return (double) miles / mpg;
    }
}


class VehConsDemo {
    public static void main(String args[]) {
        double gallons;
        int dist = 252;

        // construct complete vehicles
        Vehicle minivan = new Vehicle(7, 16, 21);
        Vehicle sportscar = new Vehicle(2, 14, 12);

        gallons = minivan.fuelneeded(dist);
        System.out.println("To go " + dist + " miles minivan needs " + gallons + " gallons of fuel.");

        gallons = sportscar.fuelneeded(dist);
        System.out.println("To go " + dist + " miles sportscar needs " + gallons + " gallons of fuel.");
    }
}


