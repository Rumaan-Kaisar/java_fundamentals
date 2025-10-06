
// jv_ch02_07_2_MultiD_irregular       2.10        142-145.9

/* -=-=-=-=-=-=-=-=-=-=-=      multi-dimensional, irregular array      -=-=-=-=-=-=-=-=-=-=-= 
    Similar tyo C/C++ Java also support multi-dimensional array.
    Java also support multi-dimensional irregular array (also referred to as a jagged array)

    Jagged (or Ragged) array:
        A jagged array, also known as a ragged array or irregular array is an "array of arrays" 
        of which the member arrays can be of different lengths, 
        producing rows of jagged edges when visualized as output.

        "Ragged array" and "jagged array" are two different names for the same data structure: 
            an array of arrays where the inner arrays can have different lengths.
            creating a non-uniform, or "ragged," appearance when visualized.



    --------  Two-Dimensional Arrays (2D)  --------
    A 2D array is a list of one-dimensional arrays.

    Syntax:
                int arr[][] = new int[rows][cols];

        Example:
                int abs[][] = new int[10][20];  // 10 rows, 20 columns

            It creates a 2-D integer array named "abs" of size 10, 20


    Accessing elements:
        since arrays use zero-based indexing, to get the element from 3rd row, 5th column

                abs[2][4]  // Accesses element at row 3, column 5



    --------  Irregular Arrays  --------
    Irregular Arrays are more like C++'s multidimensional-unsized-arrays 
    (Recall C/C++ C_Ch4_1_3_initialize_array.c) but they are not same. 

    In Java, you can create arrays where "rows have different lengths".

    In Irregular array the leftmost-dimension [] is fixed, not-empty and 
    other [] are empty (means rows fixed and columns vary). 

    In Java : leftmost dimension is fixed first.
    In C++  : last dimension is usually fixed first.

    Example 1:
                    int riders[][] = new int[7][];

        Notice leftmost-dimension is fixed: [7]
            It means it has fixed 7 rows
            But the columns in each rows varies


    Example 2: 
        Regular 2D Array (fixed size):

                int table[][] = new int[3][4];  // All 3 rows have 4 columns

        Irregular Array (different row lengths):

                int var_ary[][] = new int[4][]; // 4 rows, no column size yet

                var_ary[0] = new int[10];  // row 0 has 10 columns
                var_ary[1] = new int[15];  // row 1 has 15 columns
                var_ary[2] = new int[3];   // row 2 has 3 columns
                var_ary[3] = new int[4];   // row 3 has 4 columns

    C++ vs Java:
        In C++'s multidimensional-unsized-array the leftmost-dimension [] is unfixed, 
        (empty while other [] are filled with fixed values. Eg: columns fixed and rows vary).
    
        In Java jagged arrays, leftmost dimension is fixed (rows fixed), inner dimensions (columns) may vary.
        In C++ unsized multidimensional arrays, leftmost dimension can be omitted, but the rightmost (e.g., columns) must be fixed.
    
        Irregular Arrays:
            1 1 2 3 5
            1 1 
            1 3 2 1
            3 4 5 5 8 9 1 4 4

        multidimensional-unsized-arrays:
            1 1 2 
            3 5 8
            9 1 4
            . . .


    Why use irregular arrays?
        Useful when you need a large 2D structure but only some parts are used (e.g., sparse data).
        Saves memory by allocating only what you need.

        For example, if you need a very large two-dimensional array that is sparsely populated 
        (that is, one in which not all of the elements will be used), an irregular array might be a perfect solution.


    --------  Arrays of Three or More Dimensions  --------
    Here is the general form of a multidimensional array declaration:

                type name[ ][ ]...[ ] = new type[size1][size2]...[sizeN];

        For example, the following declaration creates a 4 x 10 x 3 three-dimensional integer array.

                int multidim[][][] = new int[4][10][3];  // 3D array

        Can think of it as 4 layers, each with 10 rows and 3 columns.


    Allocation style:
        When we allocate memory for a multidimensional array, we usually specify the both dimensions at the same time.
        For example:
                int table[][] = new int[3][4]

        However we can specify only the memory for the first (leftmost) dimension 
            and allocate the remaining dimensions separately.
     
        Since multidimensional arrays are implemented as "arrays of arrays", the length of each array is under our control. 
        Considering previous statement we can write it as:
        
                int table[][] = new int[3][];

                table[0] = new int[4];
                table[1] = new int[4];
                table[2] = new int[4];

            So separate specification is not useful when we deal with "regular array" (row and columns are fixed).  
        
        Separate specification of dimension sizes of an array is very helpful for "irregular array". 
        For example:

                int var_ary[][] = new int[4][];

                var_ary[0] = new int[10];       // specifying first row of length  10 
                var_ary[1] = new int[15];       // specifying 2nd row of length  15 
                var_ary[2] = new int[3];         // specifying 3rd  row of length  3 
                var_ary[3] = new int[4];         // specifying 4th  row of length  4 




-------------------------------------------------------------------

----  Qwen  ----


--------------------------------------------------------------------


	Initializing Multidimensional Arrays: A multidimensional array can be initialized by enclosing each dimension’s initializer list within its own set of curly braces (it is different form C/C++'s array initialization, extra curly braces not used. Recall C/C++ 4.4). For example, the general form of array initialization for a two-dimensional array is shown here:
	type-specifier array_name[ ] [ ] = { 	{ val, val, val, ..., val },
	{ val, val, val, ..., val },
	        . .  . .  . .  . .  . .
	       				{ val, val, val, ..., val }    };	Eg: Array sqrs with the numbers 1 through 4 and their squares:	int sqrs[][] = {   { 1, 1 },
	             { 2, 4 },
	             { 3, 9 },
	             { 4, 16 }  }


	Here, val indicates an initialization value. Each inner block designates a row. Within each row, the first value will be stored in the first position of the subarray, the second value in the second position, and so on. 

	Notice that commas separate the initializer blocks and that a semicolon follows the closing }.

	Alternative Array Declaration Syntax: There is a second form that can be used to declare an array:   type[] var-name;  
Here, []  follow the type specifier, not the name of the array variable. For example, following two declarations are equivalent:
char table[][] = new char[3][4];
char[][] table = new char[3][4];

	This alternative declaration form useful when we declare several arrays at the same time. For example, to create three arrays:
int[] nums, nums2, nums3;    is more easier than      int nums[], nums2[], nums3[];

	The alternative declaration form is also useful when specifying an array as a return type for a method. For example,
int[] someMeth( ) { ... }
This declares that someMeth() returns an array of type int.




----------------  GPT  ----------------
Here’s a simplified and organized (pointwise) version of your notes on Multidimensional Arrays in Java:


4. Initializing Multidimensional Arrays

Arrays can be initialized with nested braces:

int sqrs[][] = {
    { 1, 1 },
    { 2, 4 },
    { 3, 9 },
    { 4, 16 }
};


Each inner block { ... } represents a row.



✅ Initializing Multidimensional Arrays
You can initialize a 2D array at the time of declaration using nested braces.
Syntax:
java


1
2
3
4
5
6
⌄
int sqrs[][] = {
    {1, 1},
    {2, 4},
    {3, 9},
    {4, 16}
};
Each inner {} represents one row.
Commas separate rows.
Semicolon after the final }.
Java uses extra curly braces compared to C/C++, making initialization clearer and safer.





5. Alternative Array Declaration Syntax

Two equivalent ways to declare arrays:

char table[][] = new char[3][4];   // traditional
char[][] table = new char[3][4];   // alternative


Alternative form is useful when:

Declaring multiple arrays:

int[] nums, nums2, nums3;   // easier than int nums[], nums2[], nums3[];


Declaring return type of a method:

int[] someMeth() { ... }  // returns int array







✅ Summary:

Java arrays are objects → support garbage collection.

2D arrays = arrays of arrays.

Ragged arrays allow variable row sizes.

Java supports any dimension of arrays.

Nested braces are used for initialization.

Alternative declaration (type[] name) is often more convenient.

Would you like me to also add a simple diagram (like showing rows and columns in a ragged array vs. regular 2D array) to make it more visual?




----------------  Qwen  ----------------
Here is a clear, simplified, and pointwise explanation of the topic "Multidimensional Arrays in Java":





✅ Alternative Array Declaration Syntax
There are two ways to declare arrays in Java:
type arrayName[][];
Example: int table[][] = new int[3][4];
type[][] arrayName; ← Preferred alternative
Example: int[][] table = new int[3][4];
Advantages of the second form:
Better readability — clearly shows that the variable holds an array.
Easier when declaring multiple arrays:
java


1
int[] nums, nums2, nums3;  // All are int arrays
vs.
java


1
int nums[], nums2[], nums3[];  // More verbose
Essential when defining methods that return arrays:
java


1
2
3
⌄
int[] getArray() {
    return new int[5];
}





✅ Summary (Key Points)
2D Arrays
Arrays of arrays; declared as
new int[rows][cols]
Element Access
Use
arr[i][j]
for row
i
, column
j
Irregular Arrays
Rows can have different lengths — useful for saving memory
Memory Allocation
Can allocate rows individually:
arr[0] = new int[5];
3D+ Arrays
Supported:
int[][][] arr = new int[a][b][c];
Initialization
Use nested
{}
blocks for clarity
Declaration Forms
Both
int[][] arr
and
int arr[][]
work, but
int[][] arr
is preferred

💡 Tip: Use ragged arrays when dealing with uneven data (like student records with different subject counts), and regular arrays for structured grids (like matrices).







*/





/* Example 1: A two-dimensional array table is loaded with the numbers 1 through 12. */

class TwoDArrayExample {
    public static void main(String[] args) {
        int t, i;
        int table[][] = new int[3][4];   // declaration & allocation of 2D array

        for (t = 0; t < 3; t++) {       // loop through rows
            for (i = 0; i < 4; i++) {   // loop through columns
                table[t][i] = (t*4) + i + 1; // calculate value
                System.out.print(table[t][i] + "\t");
            }
            System.out.println();  // move to next row
        }

        // Example values:
            // table[0][0] = 1
            // table[0][1] = 2
            // ...
            // table[2][3] = 12
    }
}

