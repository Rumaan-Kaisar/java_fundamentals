
// jv_ch02_07_2_MultiD_irregular       2.10        142-145.9

/* -=-=-=-=-=-=-=-=-=-=-=      chapter name      -=-=-=-=-=-=-=-=-=-=-= 

2.10 Multidimensional Arrays
	Two-Dimensional Arrays: A two-dimensional array is a list of one-dimensional arrays. Eg: A 2-D integer array abs of size 10, 20:
int abs[][] = new int[10][20];
To access point 3, 5 of array abs, you would use abs[3][5].
	Example: A two-dimensional array table is loaded with the numbers 1 through 12.
int t, i;
table[][] = new int[3][4];  /* declaration of the array */
for(t=0; t < 3; ++t) {        for(i=0; i < 4; ++i){	 table[t][i] = (t*4)+i+1;
System.out.print(table[t][i] + " "); }
System.out.println(); }
table[0][0] will have the value 1, table[0][1] the value 2, table[0][2] the value 3, and so on. The value of table[2][3] will be 12. 
	Irregular Arrays: Irregular Arrays are more like C++'s multidimensional-unsized-arrays (Recall C/C++ 4.4) but they are not same. In Irregular array the leftmost-dimension [] is fixed, not-empty and other [] are empty (Eg: rows fixed and columns vary). In C++'s multidimensional-unsized-array the leftmost-dimension [] is unfixed, empty while other [] are filled with fixed values (Eg: columns fixed and rows vary). 	Irregular Arrays	multidimensional-
unsized-arrays
	1 1 2 3 5
1 1 
1 3 2 1
3 4 5 5 8 9 1 4 4	1 1 2 
3 5 8
9 1 4
. . .
	When we allocate memory for a multidimensional array, we usually specify the both dimensions at the same time. For example:
int table[][] = new int[3][4]
	However we can specify only the memory for the first (leftmost) 	dimension and allocate the remaining dimensions separately. Since 	multidimensional arrays are implemented as arrays of arrays, the length 	of each array is under our control. Consider previous statement:		int table[][] = new int[3][];
	table[0] = new int[4];
	table[1] = new int[4];
	table[2] = new int[4];
	But separate specification is not useful when we deal with regular array (row and columns are fixed).  Separate specification of dimension sizes of an array is very helpful for irregular array. For example:	int var_ary[][] = new int[4][];
var_ary[0] = new int[10];       /* specifying first row of length  10 */
var_ary[1] = new int[15];       /* specifying 2nd row of length  15 */
var_ary[2] = new int[3];         /* specifying 3rd  row of length  3 */
var_ary[3] = new int[4];         /* specifying 4th  row of length  4 */
	The use of irregular (or ragged) multidimensional arrays can be used effectively in some situations. For example, if you need a very large two-dimensional array that is sparsely populated (that is, one in which not all of the elements will be used), an irregular array might be a perfect solution.
	Arrays of Three or More Dimensions: Here is the general form of a multidimensional array declaration:
type name[ ][ ]...[ ] = new type[size1][size2]...[sizeN];
For example, the following declaration creates a 4 × 10 × 3 three-dimensional integer array.
int multidim[][][] = new int[4][10][3];
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


*/
