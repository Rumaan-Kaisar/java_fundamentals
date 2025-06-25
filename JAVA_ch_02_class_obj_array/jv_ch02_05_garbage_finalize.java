
// jv_ch02_05_garbage_finalize         2.7         128.5-132.3

/* -=-=-=-=-=-=-=-=-=-=-=      Garbage collection and finalize()      -=-=-=-=-=-=-=-=-=-=-= 


    --------    Garbage Collection (GC)    --------
    In C++:
        Uses the keyword "delete" to free memory.
        Also "destructor" runs when an object goes out of scope.
        uses 'new' to allocate memory

    In Java:
        No destructor — memory is automatically cleaned up by Garbage Collector (GC).
        The GC runs automatically (called by Java run-time system), but when it runs is unpredictable.
        
        When no references point to an object, it is 'marked' for garbage collection.
        GC reclaims memory only when necessary (not immediately after an object becomes unused).


    How GC works:
        When no references point to an object, Java considers it unreachable and marks its memory for cleanup. 
        That memory is then recycled for future use when needed.


    When Does GC Run?
        Java's garbage collection system automatically reclaims memory from objects that are no longer needed. 
        This process happens behind the scenes, without any action required from the programmer.

        Garbage collection doesn't happen immediately after objects become unused. 
            It runs only when the Java run-time decides it's appropriate.
        
        For efficiency, the garbage collector typically runs when:
            There are objects that can be recycled.
            There's a need for additional memory or system resources.

        As a result, you can't predict exactly when garbage collection will occur during a program’s execution.



    --------  memory allocation using new  --------
    we know:
        Primitive variables hold actual values.
        Object variables hold references (pointers) to objects.

    'new' for allocaton:
        In C++ we can use "new" for primitive types like int, float.
        In Java, no need to use new for primitive types (int, float, char, etc.).



    --------  finalize()  --------
    A special method called just before an object is destroyed by GC (final destruction).
        It can be used to ensure that an object terminates cleanly. 
        eg: Used for cleanup tasks (like closing a file).

    Syntax:
            protected void finalize() {
                // finalization code
            }

        Here, the keyword "protected" is an access specifier.


CP 1: 






🔸 finalize() Method
A special method called just before an object is destroyed by GC.

Used for cleanup tasks (like closing a file).

Syntax:

java
Copy
Edit
protected void finalize() {
    // finalization code
}
Important notes:

finalize() is unpredictable — no guarantee when it runs.

It’s not called when an object goes out of scope.

Not a direct replacement for C++ destructors.

Should be used as a backup for resource management, not relied on for regular cleanup.






🔸 Example: Garbage Collection with finalize()
java
Copy
Edit
class FDemo {
    int x;

    FDemo(int i) {
        x = i;
    }

    protected void finalize() {
        System.out.println("Finalizing " + x);
    }

    void generator(int i) {
        FDemo ob = new FDemo(i);
    }
}

class Finalize {
    public static void main(String args[]) {
        FDemo ob = new FDemo(0);

        for (int count = 1; count < 100000; count++)
            ob.generator(count);
    }
}
This program creates a large number of objects.

At some point, garbage collection runs, and finalize() is called for collected objects.

You’ll see messages like Finalizing 12345 in the console.







	finalize(): finalize() is the Method which can be called just before an object’s final destruction by the garbage collector, it can be used to ensure that an object terminates cleanly. Eg: use finalize() to make sure that an open file owned by that object is closed.
	To add a finalizer to a class, you simply define the finalize() and inside finalize() specify those actions that must be performed before an object is destroyed. The Java run-time system calls that finalizer whenever it is about to recycle an object of that class. 
	General form of finalize( ): 		protected void finalize(){   // finalization code here } 
Here, the keyword protected is an access specifier.
	finalize() is called just before garbage collection hence unpredictable (i.e. it is not called when an object goes out of scope). For example, if your program ends before garbage collection occurs, finalize() will not execute. Therefore, it should be used as a “backup” procedure to ensure the proper handling of some resource, or for special-use applications.
	Java does not have "destructors": Although it is true that the finalize() approximates the function of a destructor, it is not the same, a C++ destructor is always called just before an object goes out of scope, but you can’t know when finalize() will be called for any specific object. Frankly, because of Java’s use of garbage collection, there is little need for a destructor.


	Example: To demonstrate garbage collection via finalize(), you often need to create and destroy a large number of objects ,
class FDemo {	int x; 			// class that contain finalize() 
FDemo(int i) { x = i; } 	// constructor 

// called when object is recycled
protected void finalize(){ System.out.println("Finalizing " + x);}

// generates an object that is immediately destroyed
void generator(int i){ FDemo ob = new FDemo(i); }
}

class Finalize { public static void main(String args[]) {
int count;
FDemo ob = new FDemo(0); 	// assigning initial value 

// Now, generate a large number of objects. At some point, garbage collection will occur.
for(count=1; count < 100000; count++) ob.generator(count);	}}



*/
