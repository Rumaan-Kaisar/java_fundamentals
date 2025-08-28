
// jv_ch02_07_1_Array_1D               2.9         136-141

/*  -=-=-=-=-=-=-=-=-=-=-=      Array 1D      -=-=-=-=-=-=-=-=-=-=-= 

    In Java, arrays work like in other languages, but with one key difference: Arrays are implemented as objects in Java.
    Because arrays are objects:
        1. They have useful built-in features (like knowing their length).
        2. Unused arrays are automatically cleaned up by garbage collection.

    
    One-Dimensional Arrays:
        To declare a one-dimensional array in Java we use the similar "object-declaration-form". General form:

                type arrayName[] = new type[size];

            "type" declares the element type of the array.  
            (The "element type" is also commonly referred to as the "base type".) 

            "size" is the number of elements in the array.


    Creation process:
        Since arrays are implemented as objects, they are dynamically allocated using "new"
        Array creation is a two-step process:
            1. Declare an "array reference variable".
            2. Allocate memory with "new" (assigning a reference to that memory to the array variable.)






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


----  GPT  ----

Here’s the simplified and pointwise version of your text:



🔹 One-Dimensional Arrays

General form:






Example:

int sample[] = new int[10];


This can be split into:

int sample[];        // declaration (reference only)
sample = new int[10]; // memory allocation


👉 At first, sample refers to nothing. After allocation, it points to the array in memory.

🔹 Array Initialization

Similar to C/C++ array initialization.

Example:

int nums[] = {1, 2, 3, 4, 5};

🔹 Array Boundaries

Java strictly enforces array bounds.

Accessing beyond the array size → runtime error.

Example (Error):

int sample[] = new int[10];
for(int i=0; i<100; i++) sample[i] = i;


👉 When i reaches 10, program throws ArrayIndexOutOfBoundsException and stops.

🔹 Sorting an Array

Bubble Sort → simple and easy, good for small arrays.

Quicksort → faster and better for large arrays.

Other algorithms: Shaker Sort, Shell Sort, etc.

✅ This gives a step-by-step clear structure for Java arrays, their creation, initialization, boundaries, and sorting.

Would you like me to also prepare a side-by-side comparison with C/C++ arrays for even easier understanding?




----  Qwen  ----
Here is a simplified, pointwise summary of the given Java arrays content:

Arrays in Java are objects, unlike in some other languages.
Because arrays are objects:
They have built-in properties, like length (to get size).
Unused arrays are automatically removed by garbage collection.
One-dimensional array declaration syntax:
java


1
type array-name[] = new type[size];
type: data type of elements (e.g., int, char) — also called base/element type.
size: number of elements the array can hold (set at runtime).
Arrays are dynamically allocated using the new operator.
Creating an array involves two steps:
Declare an array reference variable:
java


1
int sample[];
Allocate memory and assign it to the variable:
java


1
sample = new int[10];
Example combining both steps:
java


1
int sample[] = new int[10];
sample holds a reference to the allocated memory.
Before allocation, sample is null (points to no object).
Array initialization works similarly to C/C++:
Can initialize values at declaration time.
Example:
java


1
int arr[] = {1, 2, 3};
Array boundaries are strictly enforced in Java:
Accessing index outside bounds causes ArrayIndexOutOfBoundsException.
This is a runtime error and stops the program.
Example of array overrun:
java


1
2
int sample[] = new int[10];
for(int i = 0; i < 100; i++) sample[i] = i; // Error at i=10
Loop runs to 99, but array has only 10 elements → error when i >= 10.
Sorting arrays:
Bubble Sort is simple and easy to understand, good for small arrays.
Not efficient for large datasets.
Other algorithms include Quick Sort, Shell Sort, Shaker Sort.
Quick Sort is one of the best general-purpose sorting algorithms.
✅ Key takeaway: Java arrays are safe, object-based, and bounds-checked, with dynamic allocation and automatic memory management.


*/
