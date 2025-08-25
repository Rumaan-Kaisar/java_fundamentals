
// jv_ch02_07_1_Array_1D               2.9         136-141

/*  -=-=-=-=-=-=-=-=-=-=-=      Array 1D      -=-=-=-=-=-=-=-=-=-=-= 

    In Java, arrays work like in other languages, but with one key difference: Arrays are implemented as objects in Java.
    Because arrays are objects:
        1. They have useful built-in features (like knowing their length).
        2. Unused arrays are automatically cleaned up by garbage collection.

    
    


    One-Dimensional Arrays:



	To declare a one-dimensional array in Java we the similar object-declaration-form. General form:
type array-name[ ] = new type[size];
	Here, type declares the element type of the array.  (The element type is also commonly referred to as the base type.) 
	The number of elements that the array will hold is determined by size. 		Since arrays are implemented as objects, they are dynamically allocated using the new operator. The creation of an array is a two-step process. 
	Declare an array reference variable. 
	Allocate memory for the array, assigning a reference to that memory to the array variable. 
	To creates an int array of 10 elements and links it to an array reference variable named sample:
int sample[] = new int[10];
	This declaration works just like an object declaration. The sample variable holds a reference to the memory allocated by new. Hence we can break down this statement in two parts: 	
        int sample[];
        sample = new int[10]; 
	In this case, when sample is first created, it refers to no physical object. 
	It is only after the second statement executes that sample is linked with an array.	
	Array initialization:  Similar to C/C++ array initialization. Recall C/C++ 4.4
	Array Boundaries :  Array boundaries are strictly enforced in Java; it's a run-time error to overrun or underrun the end of an array.

class ArrayErr{ public static void main(String args[]){ int sample[] = new int[10];
  int i;
  for(i = 0; i < 100; i = i+1) sample[i] = i; // generate an array overrun  }}
	As soon as i reaches 10, an ArrayIndexOutOfBoundsException is generated and the program is terminated.
	Sorting an Array: Bubble sort is similar to C/C++ 4.1 sorting example.
	There are a number of different sorting algorithms. There are the quick sort, the shaker sort, and the shell sort, to name just three. However, the best known, simplest, and easiest to understand is called the Bubble sort. 
	Although the Bubble sort is good for small arrays, it is not efficient when used on larger ones. The best general-purpose sorting algorithm is the Quicksort. 


*/
