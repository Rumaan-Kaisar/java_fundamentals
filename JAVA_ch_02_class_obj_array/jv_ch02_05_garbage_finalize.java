
// jv_ch02_05_garbage_finalize         2.7         128.5-132.3

/* -=-=-=-=-=-=-=-=-=-=-=      Garbage collection and finalize()      -=-=-=-=-=-=-=-=-=-=-= 


2.7 Garbage collection and finalize()



	Java’s garbage collection system reclaims objects automatically—occurring transparently, behind the scenes, without any programmer intervention. It works like this: When no references to an object exist, that object is assumed to be no longer needed, and the memory occupied by the object is released. This recycled memory can then be used for a subsequent allocation.


	Garbage collection takes time, so the Java run-time system does it only when it is appropriate. It will not occur simply because one or more objects exist that are no longer used. Thus, you can’t know precisely when garbage collection will take place.
	For efficiency, the garbage collector will usually run only when two conditions are met: 
	There are objects to recycle, and 	
	There is a need to recycle them. 



	new is not used with primitive types (unlike C++) in Java: In C++ we used new for int, float etc. Recall C/C++ 10.11. In Java you don’t need to use new for variables of the primitive types, such as int or float. 
	Java’s primitive types are not implemented as objects, they are implemented as “normal” variables. A variable of a primitive type actually contains the value that you have given it.
	But object variables are references (pointers) to the object. This layer of indirection (and other object features) adds overhead to an object.





--------    Garbage Collection (GC)    --------
In C++:
    Uses the keyword "delete" to free memory.
    Also "destructor" runs when an object goes out of scope.

In Java:
    No destructor — memory is automatically cleaned up by Garbage Collector (GC).
    The GC runs automatically (called by Java run-time system), but when it runs is unpredictable.
    
    When no references point to an object, it is 'marked' for garbage collection.
    GC reclaims memory only when necessary (not immediately after an object becomes unused).




🔸 When Does GC Run?
Only when:

There are unused (unreferenced) objects.

The system decides it's a good time to reclaim memory.




🔸 Primitive Types and new
In C++: You can use new for primitive types like int, float.

In Java:

No need to use new for primitive types (int, float, char, etc.).

Primitive variables hold actual values.

Object variables hold references (pointers) to objects.






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
