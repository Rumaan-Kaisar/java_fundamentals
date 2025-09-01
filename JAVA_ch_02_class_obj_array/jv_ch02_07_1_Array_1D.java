
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
    
    Example:
        For example following creates an "int array of 10 element" and
            links to a array referance variable named "sample"

                int sample[] = new int[10];

        Just like an object declaration "sample" holds a reference to the memory allocated by "new".
        So this can be split into:

                int sample[];           // declaration (reference only)
                sample = new int[10];   // memory allocation

            At first, sample refers to nothing. 
            After allocation, it points to the array in memory.


        Note:
            Each element in an array is accessed using an index.
            In Java, array indexing starts at 0.
            So, for an array of size 10:

                First element:  sample[0]
                Last element:   sample[9]

            A program can fill sample with numbers 0 to 9 using a loop.



    --------  Array Initialization  --------
    Similar to C/C++ array initialization. Recall "C_Ch4_1_3_initialize_array.c"
    We can initialize values at declaration time.
    Example:
                int nums[] = {1, 2, 3, 4, 5};


    Array Boundaries:
        Java strictly enforces array bounds.
        Accessing beyond the array size raise "runtime error" ArrayIndexOutOfBoundsException

        Example of array overrun (Error):

                int sample[] = new int[10];

                // Error at i=10
                for(int i=0; i<100; i++) sample[i] = i;

            When i reaches 10, program throws "ArrayIndexOutOfBoundsException" and stops.
            Loop runs to 99, but array has only 10 elements 






// ----  rev[01-Sep-2025]  ----
// add prog from 137.7

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



🔹 Sorting an Array

Bubble Sort → simple and easy, good for small arrays.

Quicksort → faster and better for large arrays.

Other algorithms: Shaker Sort, Shell Sort, etc.

✅ This gives a step-by-step clear structure for Java arrays, their creation, initialization, boundaries, and sorting.

Would you like me to also prepare a side-by-side comparison with C/C++ arrays for even easier understanding?




----  Qwen  ----




Sorting arrays:
Bubble Sort is simple and easy to understand, good for small arrays.
Not efficient for large datasets.
Other algorithms include Quick Sort, Shell Sort, Shaker Sort.
Quick Sort is one of the best general-purpose sorting algorithms.
✅ Key takeaway: Java arrays are safe, object-based, and bounds-checked, with dynamic allocation and automatic memory management.


*/



/* Example 1: Following program loads sample with the numbers 0 through 9, using array 
                notice array index begin from 0
*/

class ArrayDemo {
    public static void main(String args[]) {
        int sample[] = new int[10]; // array declaration and memory allocation
        int i;

        for(i = 0; i < 10; i = i+1) sample[i] = i;  // putting values to the array
        for(i = 0; i < 10; i = i+1) System.out.println("This is sample[" + i + "]: " + sample[i]);
    }
}


