
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
    The general form for initializing a 1D array:
                
                type array-name[ ] = { val1, val2, val3, ... , valN };

        val1 through valN, are assigned in sequence, left to right, in index order. 

    No "new" needed:
        Java automatically allocates an array large enough to hold the specified initializers. 
        There is no need to explicitly use the "new" operator.

    Example:
                int nums[] = {1, 2, 3, 4, 5};



--------  Array Boundaries  --------
    Array Boundaries:
        Java strictly enforces array bounds.
        Accessing beyond the array size (overrun or underrun the end of an array) raise "runtime error" 
            i.e. ArrayIndexOutOfBoundsException

        Example of array overrun (Error):

                int sample[] = new int[10];

                // Error at i=10. 
                for(int i=0; i<100; i++) sample[i] = i;

            When i reaches 10, program throws "ArrayIndexOutOfBoundsException" and stops.
            Loop runs to 99, but array has only 10 elements 
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




/* Example 2: Following program finds the minimum and maximum values stored in the "nums" array 
                by cycling through the array using a for loop.

            Note:
                The nums array was given values by hand, using 10 separate assignment statements. 
                However we can initialize it.
*/

class MinMax {
    public static void main(String args[]) {
        int nums[] = new int[10];
        int min, max;

        nums[0] = 99;
        nums[1] = -10;
        nums[2] = 100123;
        nums[3] = 18;
        nums[4] = -978;
        nums[5] = 5623;
        nums[6] = 463;
        nums[7] = -9;
        nums[8] = 287;
        nums[9] = 49;

        min = max = nums[0];

        for(int i=1; i<10; i++) {
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
    
        System.out.println("min and max: " + min + " " + max);
    }
}


// ----  Improved Version  ----
// here is a better way to write the MinMax program: now using array initializers.

class MinMax {
    public static void main(String args[]) {
        int nums[] = { 99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49 };
        int min, max;

        min = max = nums[0];

        for(int i=1; i<10; i++) {
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
    
        System.out.println("min and max: " + min + " " + max);
    }
}




/* Example 3: (overrun) Try the following program that purposely overruns an array.
                Notice the "ArrayIndexOutOfBoundsException" error. 

                As soon as i reaches 10, an ArrayIndexOutOfBoundsException is generated 
                    and the program is terminate
*/

class ArrayErr {
    public static void main(String args[]) {
        int sample[] = new int[10];
        int i;

        // generate an array overrun
        for(i = 0; i < 100; i = i+1) sample[i] = i;
    }
}







// ----  rev[11-Sep-2025] 139.7  ----




/* Example 4: Sorting an Array: Bubble sort is similar to C/C++ C_Ch4_1_1_1D_array.c sorting example.

                There are a number of different sorting algorithms like:
                        quick sort, 
                        shaker sort, and  
                        shell sort, 
                    to name just three. 

                However, the best known, simplest, and easiest to understand is called the Bubble sort.

                Although the Bubble sort is good for small arrays, it is not efficient when used on larger ones. 
                The best general-purpose sorting algorithm is the "Quicksort". 



Bubble sort works by repeatedly comparing adjacent elements in an array.

If two elements are out of order, they are swapped.

With each pass:

Smaller values "bubble" to the front.

Larger values "sink" to the back.

The process repeats until the whole array is sorted.

It requires (number of elements – 1) passes in the worst case.

Core logic (Java code):

for(a = 1; a < size; a++)
    for(b = size - 1; b >= a; b--) {
        if(nums[b - 1] > nums[b]) {  // out of order
            t = nums[b - 1];
            nums[b - 1] = nums[b];
            nums[b] = t;
        }
    }


Outer loop → runs multiple passes.

Inner loop → compares and swaps adjacent elements.

After each pass, the next smallest element is placed in its correct position.
*/



/*  



*/
