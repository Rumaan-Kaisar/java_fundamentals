
// 2.13 

/*  -=-=-=-=-=-=-=-=-=-=-=      Enhanced FOR      -=-=-=-=-=-=-=-=-=-=-= 

    For-Each Loop (Enhanced for Loop)
        The "Enhanced FOR loop" or "for-each loop" Designed to traverse arrays or collections 
        from start to finish without manual indexing.

        The loop automatically:
            Starts at index 0
            Goes up to the last element
            Moves one by one (sequential order)

        No need to:
            Use index i
            Write loop condition
            Increment counter
            Access nums[i]


        The general form:

                for (type itr_var : collection) {
                    statement-block
                }


            type:       Data type of each element in the array (e.g., int, String)

            itr_var:    iteration variable that holds one element at a time.
                        (an iteration variable is a temporary variable)

            collection: The array (or other data structures) you want to loop through


        Each time the loop runs, it takes the next element from the array 
            and puts it in itr_var, one by one — like a stream.

        The loop continues until all elements are processed. 
            For an array with N elements, it goes from 0 to N–1.

        The itr_var type must match (or be compatible with) the type of elements in the array.
            For example, if the array is int[], then the loop variable itr_var should be int.


    Note: 
        The enhanced for loop (or "for-each" loop) can work with many types of "data collections" — not just arrays.
        In this section, we're only using it with arrays, 
            but we can also use it with more advanced data structures like: 
                lists, 
                sets, 
                queues, and 
                maps.

        These structures are part of Java's "Collections Framework" - a built-in set of tools for storing and managing groups of data.

        Common uses of the for-each loop is to easily go through all items in these collections - just like with arrays.
*/


/*  Example 1: Traditional vs Enhanced for 

                Traditional for loop (manual indexing):
                    The array is read sequentially using an index variable (e.g., i).

                    The loop must explicitly specify:
                        Starting index
                        Ending index
                        Increment value
                    
                    Elements are accessed manually, like nums[i].
                    Requires care to avoid out-of-bounds errors.


                For-each loop (enhanced for loop):
                    Automatically goes through the array from first element to last.
                    No index (loop counter), no start/end values, no manual indexing needed.
                    
                    Uses an iterator variable (e.g., x) instead of a loop counter.
                        The iterator directly holds one array element at a time.
                        On each loop pass, x gets the next value in the array.
                        Thus, 
                            on the first iteration, x contains 19, 
                            on the second iteration, x contains 25, and so on.
                    
                    Syntax is simpler and safer.
                    Helps prevent boundary errors.
*/

// Traditional for loop:

int nums[] = {19, 25, 33, 42, 5, 6, 7, 8, 9, 10};
int sum = 0;

for(int i = 0; i < nums.length; i++) {
    System.out.println("Value: " + nums[i]);
    sum += nums[i];
}


// Enhanced for loop (simpler):

int nums[] = {19, 25, 33, 42, 5, 6, 7, 8, 9, 10};
int sum = 0;

for(int x : nums) {
    System.out.println("Value: " + x);
    sum += x;
}



/*  

For-Each Style for Loop

----  rev[26-Jan-2026]  ----


    ----  Enhanced for with break  ----

: It is possible to terminate the Enhanced for loop early by using a break statement. 

For example, 
for(int x : nums) {	System.out.println("Value is: " + x); sum += x;
if(x == 5) break; // stop the loop when 5 is obtained 
}



	Enhanced for's iteration variable "itr-var" is "read-only":  For-each style for loop's iteration variable is “read-only” as it relates to the underlying array. An assignment to the iteration variable has no effect on the underlying array. In other words, you can’t change the contents of the array by assigning the iteration variable a new value. For example, 
int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
for(int x : nums) {	System.out.print(x + " ");
x = x * 10; // no effect on nums 
}

The for loop increases the value of the iteration variable by a factor of 1, which has no effect on the underlying array nums.



	Enhanced for with  Multidimensional Arrays: Since in Java, multidimensional arrays consist of arrays of arrays, each iteration obtains the next array, not an individual element. Furthermore, the iteration variable (itr-var) in the enhanced for loop must be compatible with the type of array being obtained. For example, in the case of a two-dimensional array, the iteration variable must be a reference to a one-dimensional array. Consider following uses nested for loops to obtain the elements of a two-dimensional array in row order, from first to last.

int sum = 0;
int nums[][] = new int[3][5];
// give nums some values
for(int i = 0; i<3; i++) for(int j=0; j<5; j++) nums[i][j] = (i+1)*(j+1);
// Use for-each for loop to display and sum the values.
for(int x[] : nums){ 	//  compatible type of one-dimensional array
for(int y : x) { System.out.println("Value is: " + y);
    sum += y; }
}	



	Notice how x is declared, "for(int x[] : nums) {" . It is a reference to a one-dimensional array of integers: each iteration of the for obtains the next array in nums, beginning with the array specified by nums[0]. 


	The inner for loop then cycles through each of these arrays, displaying the values of each element.


	Searching value with Enhanced for and other usage :  Enhanced for can be used to search an unsorted array for a value. 
int nums[] = { 6, 8, 3, 7, 5, 6, 1, 4 };
int val = 5;
boolean found = false;	// Use for-each style for to search nums for val.
for(int x : nums) { if(x == val) { found = true; break;}  }
if(found) System.out.println("Value found!");


	Enhanced for is perfect here because searching an unsorted array involves examining each element in sequence. (Of course, if the array were sorted, a binary search could be used, which would require a different style loop.) 


	Other usage of for-each style loops include computing an average, finding the minimum or maximum of a set, looking for duplicates, and so on.


------------------------------------------------


Here is a clear, simplified, and pointwise explanation of the "For-Each Style for Loop" (Enhanced for Loop) in Java:


✅ Example: 



➡️ Cleaner, less error-prone code.



✅ Key Features & Rules
Feature
Explanation


🔍 Read-only variable
You cannot modify the original array using the iteration variable. <br>Example:<br>for (int x : nums) { x = x * 10; } // ❌ No effect on nums


✅ Prevents boundary errors
No risk of going out of bounds (like i > length) — handled automatically.



💡 Useful for simple traversal
Ideal when you just need to read every element once in order.




✅ Using break in Enhanced for
You can exit early using break.
Useful for searching.
Example: Search for a value

java
12345678910111213
int nums[] = {6, 8, 3, 7, 5, 6, 1, 4};
int val = 5;
boolean found = false;

for (int x : nums) {
    if (x == val) {
        found = true;
        break; // Stop as soon as value is found
    }
}



✅ Perfect for searching unsorted data.



✅ For-Each with Multidimensional Arrays
In Java, 2D arrays are arrays of arrays.

So, when using enhanced for:

Outer loop: Gets each row (which is a 1D array)
Inner loop: Loops through elements in that row
Example:

java
123456789101112131415
int nums[][] = new int[3][5];

// Fill array
for (int i = 0; i < 3; i++)
    for (int j = 0; j < 5; j++)
        nums[i][j] = (i+1) * (j+1);

// Display and sum using enhanced for
int sum = 0;
for (int[] row : nums) {         // row is a 1D array

📌 Note:

row → reference to a int[] (a full row)
element → individual integer (int)



✅ Common Uses of Enhanced for Loop
✔️ Printing all elements
✔️ Calculating sum, average, min, max
✔️ Searching for a value
✔️ Checking duplicates
✔️ Processing each item in order

🚫 Not suitable when:

You need the index (i, j)
You want to modify array elements
You need to skip items or loop backward



✅ Summary (Key Points)
Point
Description
📌 Simpler syntax
for (type var : array)
📌 Automatic iteration
From first to last element
📌 Read-only access
Changing var doesn’t affect the array
📌 Safe
No index-out-of-bounds errors
📌 Works with 1D and multi-D arrays
Use nested loops for 2D+
📌 Can use break
To stop early (e.g., search)
📌 Best for reading
Not for updating array values
💡 Tip: Use the enhanced for loop whenever you just need to look at each element once, especially in arrays and lists. It makes your code cleaner and less error-prone!


*/
