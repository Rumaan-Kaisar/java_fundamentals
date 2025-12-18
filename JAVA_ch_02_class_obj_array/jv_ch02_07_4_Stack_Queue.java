
// 149.7 - 153.5

// ----  rev[17-Nov-2025] rev book  ----

/* -=-=-=-=-=-=-=-=-=-=-=      chapter name      -=-=-=-=-=-=-=-=-=-=-= 

    Data structure: "stack" and "queue" with array

    Data structures & arrays:
        A data structure organizes data efficiently.
        The simplest one is an "array", which stores elements "linearly" and allows "random access".
        More advanced structures like "stacks" and "queues" are often built on top of arrays.


    Stack:
        A stack is a list which elements can be accessed in FILO (First-In, Last-Out) order.
        Like plates stacked on a table—the last plate placed is the first removed.

        
    Queue:
        A queue follows FIFO (First-In, First-Out) order.
        Like a waiting line at a bank—the first person in line gets served first.


    Why stacks & queues matter:
        They combine storage for information with the methods that access that information.
        i.e. they combine data storage + operations into one unit.

        They act as data engines:
            The structure itself handles STORING and RETRIEVING items, so the program doesn't manage it manually.



    --------  Queue class  --------
    In general, queues support two basic operations: put and get.
        put(): Each put operation places a new element on the end of the queue.
        get(): Each get operation retrieves the next element from the front of the queue.


    Types of queues:
        There are two basic types of queues

        Circular queue: 
            reuses empty positions in the underlying array, when elements are removed.

        Noncircular queue: 
            does not reuse freed space and eventually becomes exhausted.


    ----  Queue behavior  ----

    Queue operations are CONSUMPTIVE:
        once an element is "removed", it cannot be "retrieved" again.

    A queue can become:
        Full: no more space to add items.
        Empty: all items removed.
*/




/* Example 1: For the sake of simplicity, we now consider a "non-circular queue", 
                but it can easily transform it into a circular queue.

                the method we will use is based upon an array. 
                That is, an array will provide the storage for the items put into the queue. 

                (Also there are other ways to support a queue).

                Two indices control access:
                    put index: determines location where the next item will be stored.
                    get index: determines location where the next item will be retrieved.

                Because get is "CONSUMPTIVE", you never access the same element twice.


            Creating the Queue class:
                The constructor for the Queue class creates a queue of a given size 
                (Notice that the put and get indices are initially set to zero).
            
            [   Recall Cpp, ch10_01_1_class_intro.cpp, Example 11. 
                ch10_01_2_constructor_destructor.cpp, Example 6, 
                ch10_06_1_assign_obj.cpp, Example 6
            ]
*/


class Queue{
    char q[];               // this array holds the queue
    int putloc, getloc;     // the put and get indices

    Queue(int size) { 
        q = new char[size];   // allocate memory for queue
        putloc = getloc = 0;  // put and get initialized to 0
    }

    // put a character into the queue
    void put(char ch) { 
        if(putloc==q.length){ 
            System.out.println(" - Queue is full.");
            return; 
        }
        q[putloc++] = ch; 
    }

    // get a character from the queue
    char get(){ 
        if(getloc == putloc){ 
            System.out.println(" - Queue is empty.");
            return (char) 0; 
        }
        return q[getloc++]; }
}


// ----  Rev[15-Dec-2025]  ----

// Demonstrate the Queue class.
class QDemo { 
    public static void main(String args[]) {
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


/* 
Output:Using bigQ to store the alphabet.
Contents of bigQ: ABCDEFGHIJKLMNOPQRSTUVWXYZ

Using smallQ to generate errors.

Attempting to store Z
Attempting to store Y
Attempting to store X
Attempting to store W
Attempting to store V – Queue is full.
Contents of smallQ: ZYXW – Queue is empty.

*/


