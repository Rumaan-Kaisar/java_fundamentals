
/*  ------------    object creation and "new"    ------------
    Objects in Java are created using the "new" operator:
        Example: 
                    Vehicle minivan = new Vehicle();

                This line is used to "declare an object" of type "Vehicle"


        Object Creation happens in Two Steps:
            Step 1: "Vehicle minivan"
                        Declares a reference variable (minivan) of type Vehicle. 
                        This variable does not define an object.

            Step 2: "new Vehicle()"
                        Dynamically allocates memory for an object and assigns a reference to minivan.
                        i.e. this declaration creates a physical copy of the object
                        This is done by using the "new" operator.


    The statement  
            Vehicle minivan = new Vehicle();

        can be broken into two steps: 
            Vehicle minivan;        // Declare reference to a Vehicle object
            minivan = new Vehicle();    // Allocate a Vehicle object


    1. Declaration:
    
            Vehicle minivan;        // Declare reference to a Vehicle object
        
        - declares 'minivan' as a reference to an object of type 'Vehicle'.
        - This creates a variable "minivan" (not an object itself) that can refer to a "Vehicle" object. 
        - At this point, "minivan" does not refer to any object yet.  


    2. Object Creation & Assignment:
    
            minivan = new Vehicle();    // Allocate a Vehicle object
    
        - This creates a new "Vehicle" object in memory.
        - The reference to this object is assigned to "minivan", linking it to the object.  

    So, initially, "minivan" is just a reference. After object creation, it gets linked to an actual object.


    Role of "new" Operator:
        The new operator dynamically allocates (i.e., allocates at run time) memory for an object
        Returns a reference to the allocated object
            This reference is, more or less, the "address in memory" of the object allocated by "new"
        This reference is then stored in a variable.
            In Java, all class objects must be dynamically allocated.


    Separate Objects:
        Different object references (e.g., minivan and sportscar) refer to "separate memory allocations" 
        and they do not share data.




// TxtBK: 109.5-110.3

A primitive type variables (i.e. int, double etc) and object reference variables act differently in an assignment operation. 
	When you assign one primitive-type variable to another, the situation is straightforward. The variable on the left receives a copy of the value of the variable on the right. 
	When you assign one object reference variable to another, the situation is a bit more complicated because you are changing the object that the reference variable refers to. The effect of this difference can cause some counterintuitive results. For example, 

Vehicle car1 = new Vehicle();
Vehicle car2 = car1;

Looks like car1 and car2 refer to different objects, but this is not the case. Instead, car1 and car2 will both refer to the same object. The assignment of car1 to car2 simply makes car2 refer to the same object as does car1. Thus, the object can be acted upon by either car1 or car2. For example, after the assignment car1.mpg = 26; executes, both of following println() statements display the same value: 26.			System.out.println(car1.mpg);
System.out.println(car2.mpg);

	Although car1 and car2 both refer to the same object, they are not linked in any other way. For example, a subsequent assignment to car2 simply changes the object to which car2 refers. The object referred to by car1 is unchanged.

   Vehicle car1 = new Vehicle();
   Vehicle car2 = car1;
   Vehicle car3 = new Vehicle();
   car2 = car3; // now car2 and car3 refer to the same object.        
*/
