
// jv_ch02_05_garbage_finalize         2.7         128.5-132.3

/* -=-=-=-=-=-=-=-=-=-=-=      Garbage collection and finalize()      -=-=-=-=-=-=-=-=-=-=-= 


2.7 Garbage collection and finalize()
In C++, to free allocated memory space after use of an object we used the keyword "delete" and also the destructor is called when the object goes out of scope. In Java there is no destructor  , the allocated memory cleanup is performed by "garbage collection". It is unpredictable when "garbage collector" is called by Java run-time system, it is called automatically when it needed.
	Java’s garbage collection system reclaims objects automatically—occurring transparently, behind the scenes, without any programmer intervention. It works like this: When no references to an object exist, that object is assumed to be no longer needed, and the memory occupied by the object is released. This recycled memory can then be used for a subsequent allocation.
	Garbage collection takes time, so the Java run-time system does it only when it is appropriate. It will not occur simply because one or more objects exist that are no longer used. Thus, you can’t know precisely when garbage collection will take place.
	For efficiency, the garbage collector will usually run only when two conditions are met: 
	There are objects to recycle, and 		There is a need to recycle them. 
	new is not used with primitive types (unlike C++) in Java: In C++ we used new for int, float etc. Recall C/C++ 10.11. In Java you don’t need to use new for variables of the primitive types, such as int or float. 
	Java’s primitive types are not implemented as objects, they are implemented as “normal” variables. A variable of a primitive type actually contains the value that you have given it.
	But object variables are references (pointers) to the object. This layer of indirection (and other object features) adds overhead to an object.

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
