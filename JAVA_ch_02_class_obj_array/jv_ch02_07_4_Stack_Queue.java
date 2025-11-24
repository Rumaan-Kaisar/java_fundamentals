
// 149.7 - 153.5

// ----  rev[17-Nov-2025] rev book  ----

/* -=-=-=-=-=-=-=-=-=-=-=      chapter name      -=-=-=-=-=-=-=-=-=-=-= */
/* 
2.12 Data structure "stack" and "queue" with array
A data structure is a means of organizing data. The simplest data structure is the array, which is a linear list that supports random access to its elements. Arrays are often used as the underpinning for more sophisticated data structures, such as stacks and queues.
	A stack is a list in which elements can be accessed in first-in, last-out (FILO) order only. Like a stack of plates on a table
	A queue is a list in which elements can be accessed in first-in, first-out (FIFO) order only. Like a line at a bank.
	stacks and queues are data engines: What makes data structures such as stacks and queues interesting is that they combine storage for information with the methods that access that information. Thus, stacks and queues are data engines in which storage and retrieval are provided by the data structure itself, not manually by your program.
	Queue class: In general, queues support two basic operations: put and get. Each put operation places a new element on the end of the queue. Each get operation retrieves the next element from the front of the queue. 
	There are two basic types of queues—circular and noncircular. A circular queue reuses locations in the underlying array when elements are removed. A noncircular queue does not reuse locations and eventually becomes exhausted.
	Queue operations are consumptive: once an element has been retrieved, it cannot be retrieved again. The queue can also become full, if there is no space available to store an item, and it can become empty, if all of the elements have been removed.
	Example: For the sake of simplicity, we now consider a noncircular queue, but it can easily transform it into a circular queue.
	Although there are other ways to support a queue, the method we will use is based upon an array. That is, an array will provide the storage for the items put into the queue. 
	This array will be accessed through two indices. The put index determines where the next element of data will be stored. The get index indicates at what location the next element of data will be obtained. Keep in mind that the get operation is consumptive, and it is not possible to retrieve the same element twice. 
	First create the Queue class. The constructor for the Queue class creates a queue of a given size ( Notice that the put and get indices are initially set to zero). 


Data Structure: Stack & Queue Using Arrays (Simplified Points)


1. Data structures & arrays

A data structure organizes data efficiently.

The simplest one is an array, which stores elements linearly and allows random access.

More advanced structures like stacks and queues are often built on top of arrays.



2. Stack

A stack follows FILO (First-In, Last-Out) order.

Like plates stacked on a table—the last plate placed is the first removed.



3. Queue

A queue follows FIFO (First-In, First-Out) order.

Like a waiting line at a bank—the first person in line gets served first.



4. Why stacks & queues matter

They combine data storage + operations into one unit.

They act as data engines:
The structure itself handles storing and retrieving items, so the program doesn't manage it manually.



5. Basic queue operations

put() → adds an element to the end of the queue.

get() → removes the next element from the front of the queue.



6. Types of queues

Circular queue: reuses empty positions when elements are removed.

Noncircular queue: does not reuse freed space and eventually becomes full.



7. Queue behavior

Queue operations are consumptive → once an element is removed, it cannot be retrieved again.

A queue can become:

Full → no more space to add items.

Empty → all items removed.



8. Queue implementation using an array

We use an array to store the queue elements.

Two indices control access:

put index: where the next item is stored.

get index: where the next item is retrieved.

Because get is consumptive, you never access the same element twice.



9. Creating the Queue class

The constructor creates an array of a chosen size.

put = 0, get = 0 initially.

This simple version is noncircular, but converting to circular is easy later.


*/
 
 class Queue{
        char q[]; 			         // this array holds the queue
        int putloc, getloc; 		         // the put and get indices
        Queue(int size) { q = new char[size];   // allocate memory for queue
		      putloc = getloc = 0; }

// put a character into the queue
        void put(char ch) { 
                if(putloc==q.length){ System.out.println(" – Queue is full.");
		                        return; }
                q[putloc++] = ch; }

// get a character from the queue
        char get(){ 
                if(getloc == putloc){System.out.println(" – Queue is empty.");
			 return (char) 0; }
                return q[getloc++]; }
	}	// Demonstrate the Queue class.
class QDemo { public static void main(String args[]) {
           Queue bigQ = new Queue(100);
           Queue smallQ = new Queue(4);
           char ch;
           int i;

System.out.println("Using bigQ to store the alphabet.");
for(i=0; i < 26; i++) bigQ.put((char) ('A' + i));         // put numbers 

System.out.print("Contents of bigQ: ");       // retrieve and display 
for(i=0; i < 26; i++) { ch = bigQ.get();
     if(ch != (char) 0) System.out.print(ch); }
System.out.println("\n");

System.out.println("Using smallQ to generate errors.");
for(i=0; i < 5; i++) { 
           System.out.print("Attempt to store " + (char) ('Z' - i));
           smallQ.put((char) ('Z' - i));
           System.out.println();   }
System.out.println();

// more errors on smallQ
System.out.print("Contents of smallQ: ");
for(i=0; i < 5; i++) { ch = smallQ.get();
		if(ch != (char) 0) System.out.print(ch);}
}}


Output:	Using bigQ to store the alphabet.
		Contents of bigQ: ABCDEFGHIJKLMNOPQRSTUVWXYZ

		Using smallQ to generate errors.

		Attempting to store Z
		Attempting to store Y
		Attempting to store X
		Attempting to store W
		Attempting to store V – Queue is full.
		Contents of smallQ: ZYXW – Queue is empty.	

