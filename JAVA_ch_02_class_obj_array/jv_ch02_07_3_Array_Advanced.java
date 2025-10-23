
// 145.9-149.7

/* -=-=-=-=-=-=-=-=-=-=-=      Array (advanced)      -=-=-=-=-=-=-=-=-=-=-= 

2.11 Array (advanced)
	Assigning Array References (more like assigning pointers of C/C++: copying address): As with other objects, when you assign one array reference variable to another, you are simply changing what object that variable refers to. You are not causing a copy of the array to be made, nor are you causing the contents of one array to be copied to the other. (i.e. same object with two different names, "not two different objects with equal values". The object can be modified via both of the names.) For example,

           int nums1[] = new int[10];
           int nums2[] = new int[10];
           for(i=0; i < 10; i++) nums1[i] = i; 	//putting values to nums1 
           for(i=0; i < 10; i++) nums2[i] = -i; 	//putting values to nums2
	Output :
Here is nums1: 0 1 2 3 4 5 6 7 8 9
Here is nums2: 0 -1 -2 -3 -4 -5 -6 -7 -8 -9
Here is nums2 after assignment: 0 1 2 3 4 5 6 7 8 9
nums1 after change through nums2: 0 1 2 99 4 5 6 7 8 9
           System.out.print("Here is nums1: "); for(i=0; i < 10; i++) System.out.print(nums1[i] + " "); System.out.println();
           System.out.print("Here is nums2: "); for(i=0; i < 10; i++) System.out.print(nums2[i] + " "); System.out.println();

           nums2 = nums1; 			// now nums2 refers to nums1
           System.out.print("Here is nums2 after assignment: "); for(i=0; i < 10; i++) System.out.print(nums2[i] + " "); System.out.println();

           nums2[3] = 99; 			// operating on nums1 array through nums2
           System.out.print("nums1 after change through nums2: "); for(i=0; i < 10; i++) System.out.print(nums1[i] + " "); System.out.println();
	As the output shows, after the assignment of nums1 to nums2, both array reference variables refer to the same object.
	Using the length Member (instance member of an array object): Because arrays are implemented as objects, each array has associated with it a length instance variable that contains the number of elements that the array can hold. (In other words, length contains the size of the array.) Here is a program that demonstrates this property:

int list[] = new int[10];
int nums[] = { 1, 2, 3 };
int table[][] = {  	{1, 2, 3},
		{4, 5},
		{6, 7, 8, 9} };             // a variable-length table

System.out.println("length of list is " + list.length);
System.out.println("length of nums is " + nums.length);
System.out.println("length of table is " + table.length);
System.out.println("length of table[0] is " + table[0].length);
System.out.println("length of table[1] is " + table[1].length);
System.out.println("length of table[2] is " + table[2].length);
System.out.println();	// use length to initialize list
for(int i=0; i < list.length; i++) list[i] = i * i;
System.out.print("Here is list: ");

// now use length to display list
for(int i=0; i < list.length; i++) System.out.print(list[i] + " ");
System.out.println();

	Output:  length of list is 10
	      length of nums is 3
	      length of table is 3
	      length of table[0] is 3
	      length of table[1] is 2
	      length of table[2] is 4
	      Here is list: 0 1 4 9 16 25 36 49 64 81
	Pay special attention to the way length is used with the two-dimensional array table. Since a two-dimensional array is an array of arrays. 
	Thus, when " table.length " is used, it obtains the number of arrays stored in table, which is 3 in this case. 
	To obtain the length of any individual array in table, you will use an expression such as this, " table[0].length " which, in this case, obtains the length of the first array.
	Also notice that list.length is used by the for loops to govern the number of iterations that take place. Since each array carries with it its own length, you can use this information rather than manually keeping track of an array’s size.
	Keep in mind that the value of length has nothing to do with the number of elements that are actually in use. It contains the number of elements that the array is capable of holding.
	length simplifies many algorithms by making certain types of array operations easier—and safer—to perform. For example, the following uses length to copy one array to another while preventing an array overrun and its attendant run-time exception.

class ACopy { public static void main(String args[]) {	 int i;
int nums1[] = new int[10];
int nums2[] = new int[10];
for(i=0; i < nums1.length; i++) nums1[i] = i;

// compare array size using length and  copy nums1 to nums2 
			if(nums2.length >= nums1.length) for(i = 0; i < nums1.length; i++) nums2[i] = nums1[i];
			for(i=0; i < nums2.length; i++) System.out.print(nums2[i] + " ");	      }}

	Here, length helps perform two important functions.		First, it is used to confirm that the target array is large enough to hold the contents of the source array.
		Second, it provides the termination condition of the for loop that performs the copy. 



----  GPT  ----

2.11 Array (Advanced)
1. Assigning Array References

In Java, assigning one array to another does not copy the array — it only copies the reference (address).

This means both variables will refer to the same array object in memory.

Any change made through one reference will also affect the other.

Example:

int nums1[] = new int[10];
int nums2[] = new int[10];

for(int i = 0; i < 10; i++) nums1[i] = i;
for(int i = 0; i < 10; i++) nums2[i] = -i;

System.out.print("Here is nums1: ");
for(int i = 0; i < 10; i++) System.out.print(nums1[i] + " ");
System.out.println();

System.out.print("Here is nums2: ");
for(int i = 0; i < 10; i++) System.out.print(nums2[i] + " ");
System.out.println();

nums2 = nums1; // nums2 now refers to the same object as nums1

System.out.print("Here is nums2 after assignment: ");
for(int i = 0; i < 10; i++) System.out.print(nums2[i] + " ");
System.out.println();

nums2[3] = 99; // modify nums1 through nums2

System.out.print("nums1 after change through nums2: ");
for(int i = 0; i < 10; i++) System.out.print(nums1[i] + " ");
System.out.println();


Output (simplified):

Here is nums1: 0 1 2 3 4 5 6 7 8 9
Here is nums2: 0 -1 -2 -3 -4 -5 -6 -7 -8 -9
Here is nums2 after assignment: 0 1 2 3 4 5 6 7 8 9
nums1 after change through nums2: 0 1 2 99 4 5 6 7 8 9


Key Point:
✅ After assignment (nums2 = nums1;), both nums1 and nums2 refer to the same array object.

2. Using the length Member

Every array in Java has a built-in instance variable called length.

length stores the number of elements the array can hold.

It is final (cannot be changed).

Example:

int list[] = new int[10];
int nums[] = { 1, 2, 3 };
int table[][] = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

System.out.println("length of list is " + list.length);
System.out.println("length of nums is " + nums.length);
System.out.println("length of table is " + table.length);
System.out.println("length of table[0] is " + table[0].length);
System.out.println("length of table[1] is " + table[1].length);
System.out.println("length of table[2] is " + table[2].length);
System.out.println();

for(int i = 0; i < list.length; i++) list[i] = i * i;
System.out.print("Here is list: ");
for(int i = 0; i < list.length; i++) System.out.print(list[i] + " ");
System.out.println();


Output:

length of list is 10
length of nums is 3
length of table is 3
length of table[0] is 3
length of table[1] is 2
length of table[2] is 4
Here is list: 0 1 4 9 16 25 36 49 64 81


Explanation:

table.length → number of rows (3)

table[0].length → length of first row (3)

Each inner array (row) can have different lengths — this shows an irregular (jagged) array.

list.length is used in loops to avoid manually tracking array size.

Key Points:

✅ length gives the total number of elements the array can hold, not how many are actually used.

✅ length helps avoid array overrun errors (runtime exceptions).

3. Example — Copying Arrays Safely

length can make array operations safer and easier.

Example:

class ACopy {
    public static void main(String args[]) {
        int nums1[] = new int[10];
        int nums2[] = new int[10];

        for(int i = 0; i < nums1.length; i++) nums1[i] = i;

        // Copy nums1 to nums2 safely
        if(nums2.length >= nums1.length)
            for(int i = 0; i < nums1.length; i++)
                nums2[i] = nums1[i];

        for(int i = 0; i < nums2.length; i++)
            System.out.print(nums2[i] + " ");
    }
}


Explanation:

✅ length is used to check if the target array (nums2) is large enough.

✅ It also controls the loop condition to avoid errors.

✅ Summary

Assigning one array to another copies the reference, not the elements.

The length variable gives the total capacity of an array.

It is used to control loops, prevent overflows, and safely copy arrays.

For 2D arrays:

table.length → number of rows.

table[i].length → number of columns in row i.


*/

