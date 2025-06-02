// jv_ch02_04_constructor_new          2.5+2.6     124.7-128.5

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



--------------------------


2.6 General form of "new" and details about object declaration (Recall C/C++'s 10.11)
The new operator has this general form: 	class_variable = new class-name(arg-list);
	Here, class_variable is a variable of the class type being created. The class-name is the name of the class that is being instantiated. The class name followed by a parenthesized argument list (which can be empty) i.e. class-name(arg-list) specifies the constructor for the class. If a class does not define its own constructor, new will use the default constructor supplied by Java. 
	The new operator returns a reference to the newly created object, which (in this case) is assigned to class-var.
	A run-time exception will occur if new is unable to allocate memory for an object because insufficient memory space.



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



// rev [29-May-2025]



