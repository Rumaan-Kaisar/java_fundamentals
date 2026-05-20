
// jv_ch02_09_2_strAdv_imutble_cmd     2.15+2.16   162.9-166.5

/* -=-=-=-=-=-=-=-=-=-=-=      Strings: Immutability and others      -=-=-=-=-=-=-=-=-=-=-=


    Strings Are Immutable:
        In Java (C#, python also) the contents of a String object are immutable. 
        That is, once created, a "String" object's content *"cannot be changed"

        Any "modification" (concatenation, substring, etc.) creates a "new String object".
            The original String remains untouched in memory.
        Since unused String objects are automatically garbage collected, so it's not a headache.


    A "Reference Variables" is not the "Object Content":
        String reference variables can change the object to which they refer.
            i.e. a reference variables like "s" below can point to "different objects".

                String s = "Hello";     
                s = s + " World";       // s now points to a NEW object "Hello World"
                // The original "Hello" object still exists (until GC collects it)

        It is the *content* of any single String object that "cannot" be changed.


    substring():
        It returns a new string that contains a specified portion of the invoking string. 

                String substring(int startIndex, int endIndex)

        "startIndex" specifies the beginning index, and 
        "endIndex" specifies the stopping point. 



    --------  Why Immutable Strings?  --------

    Safety:
        Prevent accidental changes when multiple references point to same literal.

    Optimization:
        String pooling, hash caching, thread-safety.

    Predictability:
        Strings behave like primitive values 
        (e.g., `"Daniel"` isn't thought of as `['D','a',...]`).
*/




/*  Example 1: Folowing program demonstrate immutability of strings:
                "contents of a specific String object cannot be changed after it is created"

                When we using substring() a new "String object" is manufactured that contains the substring.
                The original string is unaltered, and the rule of immutability remains intact. 

                This program also demonstrates substring().

            Output:
                orgstr: Gimme a break
                substr:  a br

            As you can see, the original string "orgstr" is unchanged, 
                and "substr" contains the substring.
*/

class SubStrDemo {
    public static void main(String args[]) {
        String orgstr = "Gimme a break";
        
        // construct a substring
        String substr = orgstr.substring(5, 10); // This creates a new string that contains the desired substring.

        System.out.println("orgstr: " + orgstr);
        System.out.println("substr: " + substr);
    }
}




/*  --------  Mutable Strings  --------

    StringBuffer:
        StringBuffer is a Java class used to create modifiable (changeable) strings.

        It includes charAt() to get a character at a specific position.
        It also has setCharAt() to change a character in the string.

    StringBuilder:
        Java provides StringBuilder, which is similar to StringBuffer.
        StringBuilder also allows strings to be modified.

    Rule of thumb:
        For general purpose use "String", not "StringBuffer" or "StringBuilder".

    

    --------   Cross-Language String Mutability    --------

    The most important non-numeric type is the string. 
    Since a string can be seen as both an array of characters and a primitive value, 
        some languages make strings mutable while others make them immutable.


    Java, C#, Python, JS, Go        Immutable. Any modification creates a new object
    
    Ruby, PHP, Swift                Mutable. 
                                    Swift uses `let` (to be a constant) to enforce immutability 

    C                               Mutable (via `char*`)
                                    No native string type; uses null-terminated character arrays

    C++                             Mutable (`std::string`). Strings are mutable by default


    In both C and C++, string constants (declared with the const qualifier) are immutable, 
        but you can easily “cast away” the const qualifier, 
        so the immutability is weakly enforced.


    --------  Arrays are mutable  --------

    Once you have created an array of values, you can "always change" any one of the entries. 

    Why? 
        Immutable arrays are too costly because every change requires creating a copy of the array.
        On the other hand "Strings" are treated as "values", not data structures.



    --------  Immutable Strings in C++ and Java  --------

    C++ Confusion: 
        I've read that strings are "mutable" in C++, but following doesn’t work like that

                // Declaration for the string data
                std::string strData = "One";

                // Declaration for C++ vector
                std::vector <std::string> str_Vector;

                str_Vector.push_back(strData);
        
                strData = "Two";
                str_Vector.push_back(strData);
                
                strData = "Three";
                str_Vector.push_back(strData);
                
                strData = "Four";
                str_Vector.push_back(strData);

        I am wondering why str_Vector does not become "Four", "Four", "Four", "Four"? 

    ans:
        If strings are mutable in C++ and if "str_Vector" stores by reference (both assumptions I've made which could very well be false),
            then it seems to me that we just added the "pointer" to strData four times, 
            and that modifying strData should also implicitly modify str_Vector.

        That's the problem with Java and C#. The differences between "object" and "pointer" are muddled beyond all recognition.

        In C++, something doesn't point to something else if it's not declared with * or &. 
        For the code to behave as you expect it, it would have to look like this:

                std::string s="One";
                std::vector <std::string*> v;

                v.push_back(&s);
                s="Two";
                v.push_back(&s);
                s="Three";
                v.push_back(&s);
                s="Four";
                v.push_back(&s);

        See? Now you've pushed the same pointer into the vector four times, 
            and changes made to any of the elements will be reflected in all the other elements. 

        Or more accurately, changes to the object which any of the elements point to 
            will be reflected in the object which all the other elements point to.



    Immutable String in Java: 
        In java, string objects are immutable. 
        Immutable simply means unmodifiable or unchangeable. 

        Once string object is created "its data or state can't be changed" but a new string object is created. 
        For example:

                String s="Sachin";  
                s.concat(" Tendulkar");     //concat() method appends the string at the end  
                System.out.println(s);      //will print Sachin because strings are immutable objects   
    
            Output:  
                Sachin

            Here s = "Sachin" is not changed but a new object is created with "Sachin Tendulkar" (but not assigned to any variable). 
            That is why string is known as immutable. 
            That two objects are created but "s" reference variable still refers to "Sachin" not to "Sachin Tendulkar". 
            But if we explicitely assign the new object s.concat(" Tendulkar") to the reference variable, 
                it will refer to "Sachin Tendulkar" object. For example:

                String s = "Sachin";  
                s = s.concat(" Tendulkar");  
                System.out.println(s);  

            Output:  
                Sachin Tendulkar  
          
            In such case, s points to the "Sachin Tendulkar". 
                Please notice that still "Sachin" object is not modified.
                It's not usable since no variable is using it, and goes to "Garbage Collector"


    Why string objects are immutable in java?
        String objects are immutable in Java so they can be safely shared and reused. 
        Since string literals are stored in a common pool, multiple references may point to the same object. 
        If strings were mutable, a change through one reference would affect all others. 

        To prevent this, Java makes strings immutable, ensuring safety, security, and efficient memory usage.



====================================================================================



--------

Nothing mysterious is happening—just object creation + reference reassignment. The confusion usually comes from mixing up the object with the variable pointing to it.

Let’s walk through your exact example slowly.

Step 1: Initial string
String s = "Sachin";
A String object "Sachin" is created.
Variable s points to that object.
Step 2: Calling concat without assignment
s.concat(" Tendulkar");

What actually happens:

A new String object "Sachin Tendulkar" is created.
But you don’t store its reference anywhere.

So:

"Sachin" → still exists and is unchanged
"Sachin Tendulkar" → created temporarily, then becomes eligible for garbage collection

That’s why:

System.out.println(s);

prints:

Sachin
Step 3: With reassignment
s = s.concat(" Tendulkar");

Now:

"Sachin Tendulkar" is created
s is updated to point to this new object


--------  What happens to "Sachin"?  --------
So the situation becomes:

"Sachin" → still exists in memory (unchanged)
"Sachin Tendulkar" → now referenced by s
Where did the “immutable string” go?

It never went anywhere.

The original "Sachin" object is still intact
It just might no longer be referenced by your variable

If no variables reference it anymore, the Java Garbage Collector will eventually clean it up.
You can’t get the original object back if nothing references it anymore and it has been garbage collected.
In Java, an object stays alive only if something still references it.



What happens to "Sachin"?
    After this:

    String s = "Sachin";
    s = s.concat(" Tendulkar");
    The original "Sachin" object:
    Still exists in memory for some time
    But no variable points to it anymore (in your code)

    So from your program’s point of view:

    It’s unreachable, therefore unusable.

    Will it be deleted?

    Yes—eventually.

    Java’s Garbage Collector will remove it if and only if:

    No references point to it
    And it’s not being kept in the string pool


What is case in C++?
    It actually does happen in C++ too—just in a slightly different way, and that’s why it feels less obvious.

    The core idea is the same across all languages:

    If you lose all ways to reach an object, you can’t use it anymore.

    But how that loss happens differs.

    In C++ with std::string (your original case)
    std::string s = "Sachin";
    s = s + " Tendulkar";

    What happens here:

    "Sachin" exists inside s
    Then s = s + " Tendulkar" creates a new string object
    The old "Sachin" content inside s is replaced

    But here’s the key difference from Java:

    👉 In C++, the old memory is immediately destroyed (or reused)
    👉 There is no separate object floating around

    So:

    You don’t have two independent objects like Java
    You just replaced the contents of s




====================================================================================











---- gPT --
yes—you can absolutely get the “all elements change together” behavior in both Java and C#, but not with strings the way you’re imagining. The key difference is that in those languages, strings are immutable, and variables hold references to objects, not the objects themselves.

In your C++ example:

std::vector<std::string> stores copies of strings.
So each push_back captures the current value of strData.

In your pointer version:

std::vector<std::string*> stores addresses
All entries point to the same std::string object → so changes affect all

That logic is sound.

--------

In both Java and C#:

Variables of class types store references (like pointers, but safer)
BUT String is immutable

So when you do this:

String s = "One";
List<String> list = new ArrayList<>();

list.add(s);
s = "Two";
list.add(s);

You are not modifying the same object.

Instead:

"One" stays unchanged
s = "Two" makes s point to a new string object

So the list becomes:

["One", "Two", "Three", "Four"]

—not four copies of "Four".



--------

How to get the "same reference" behavior

To mimic your C++ pointer example, you need a mutable object.

Java example:
class Box {
    String value;
}

Box box = new Box();
box.value = "One";

List<Box> list = new ArrayList<>();

list.add(box);
box.value = "Two";
list.add(box);
box.value = "Three";
list.add(box);
box.value = "Four";
list.add(box);

Now all elements refer to the same box object.

Result:

["Four", "Four", "Four", "Four"]


--------

Key idea (this is the real takeaway)
C++ (without pointers): values are copied
C++ (with pointers/references): shared object
Java/C#:
Always deal with references for objects
But whether changes propagate depends on mutability, not “reference-ness”


// -----------------  all codes at once   ------------------


C++: Value vs Pointer Behavior
1) Value semantics (what your original code does)

Each element is a separate copy:

#include <iostream>
#include <vector>
#include <string>

int main() {
    std::string strData = "One";
    std::vector<std::string> str_Vector;

    str_Vector.push_back(strData);

    strData = "Two";
    str_Vector.push_back(strData);

    strData = "Three";
    str_Vector.push_back(strData);

    strData = "Four";
    str_Vector.push_back(strData);

    for (const auto& s : str_Vector) {
        std::cout << s << std::endl;
    }

    return 0;
}

Output:

One
Two
Three
Four
2) Pointer semantics (shared object)

All entries point to the same string:

#include <iostream>
#include <vector>
#include <string>

int main() {
    std::string s = "One";
    std::vector<std::string*> v;

    v.push_back(&s);

    s = "Two";
    v.push_back(&s);

    s = "Three";
    v.push_back(&s);

    s = "Four";
    v.push_back(&s);

    for (auto ptr : v) {
        std::cout << *ptr << std::endl;
    }

    return 0;
}

Output:

Four
Four
Four
Four


------------------------------------------------------------

Java: Immutable String vs Shared Mutable Object
1) Using String (immutable)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "One";
        List<String> list = new ArrayList<>();

        list.add(s);

        s = "Two";
        list.add(s);

        s = "Three";
        list.add(s);

        s = "Four";
        list.add(s);

        for (String str : list) {
            System.out.println(str);
        }
    }
}

Output:

One
Two
Three
Four
2) Using a mutable object (shared reference behavior)
import java.util.*;

class Box {
    String value;
}

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        box.value = "One";

        List<Box> list = new ArrayList<>();

        list.add(box);

        box.value = "Two";
        list.add(box);

        box.value = "Three";
        list.add(box);

        box.value = "Four";
        list.add(box);

        for (Box b : list) {
            System.out.println(b.value);
        }
    }
}

Output:

Four
Four
Four
Four
One-line intuition to keep in your head
C++: copy unless you use pointers/references
Java: reference always, but immutable objects don’t change

------------------------------------------------------------





2.16 Strings to control SWITCH and Command-Line arguments 
We can use a String to control a switch. For example, using a string-based switch is an improvement over using the equivalent sequence of if/else statements. 


   However, switching on strings can be less efficient than switching on integers. Therefore, it is best to switch on strings only in cases in which the controlling data is already in string form.  Don’t use strings in a switch unnecessarily.

String command = "cancel";

switch(command) {   case "connect":     System.out.println("Connecting"); break;
case "cancel":  System.out.println("Canceling"); break;
case "disconnect":  System.out.println("Disconnecting"); break;
default:        System.out.println("Command Error!"); break;    }
   The string contained in command (which is "cancel" in this program) is tested against the case constants. When a match is found (as it is in the second case), the code sequence associated with that sequence is executed.
   Command-Line Arguments:  We noticed args[] parameter to main() that has been in every program. Many programs use command-line arguments. A command-line argument is the information that directly follows the program’s name on the command line when it is executed. 
   To access the command-line arguments inside a Java program is quite easy—they are stored as strings in the String array passed to main(). For example, the following program displays all of the command-line arguments that it is called with:
class CLDemo { public static void main(String args[]) {
System.out.println("There are " + args.length + " command-line arguments.");
System.out.println("They are: ");
for(int i=0; i<args.length; i++) System.out.println("arg[" + i + "]: " + args[i]);
}}
If CLDemo is executed like, java CLDemo one two three 
[passing " one two three " as command line arguments  during program execution (not in compilation)]    output: There are 3 command-line arguments.
               They are:
               arg[0]: one
               arg[1]: two
               arg[2]: three
Notice that the first argument is stored at index 0, the second argument is stored at index 1, and so on.
Another Example: Following takes one command-line argument that specifies a person’s name. It then searches through a two-dimensional array of strings for that name. If it finds a match, it displays that person’s telephone number.
class Phone {
public static void main(String args[]) {
       String numbers[][] = {
{ "Tom", "555-3322" },
{ "Mary", "555-8976" },
{ "Jon", "555-1037" },
{ "Rachel", "555-1400" }   };
       int i;   if(args.length != 1) System.out.println("Usage: java Phone <name>");
else {        //To use the program, one command-line argument must be present.
        for(i=0; i<numbers.length; i++) { 
                if(numbers[i][0].equals(args[0])) {
     System.out.println(numbers[i][0] + ": " + numbers[i][1]);
                   break;  } }
        if(i == numbers.length) System.out.println("Name not found."); }
}}
        
sample run:
java Phone Mary
Mary: 555-8976





// ----  qwen  ----

# 📝 Strings: Immutability & Usage — Simplified Pointwise


---

---

## 🤔 C++ Confusion Clarified (For C# Devs)

### Your Code:
```cpp
std::string strData = "One";
std::vector<std::string> str_Vector;

str_Vector.push_back(strData);  // Copies "One"
strData = "Two";                // strData now points to NEW string
str_Vector.push_back(strData);  // Copies "Two"
// ... etc
```

### ✅ What Actually Happens:
- `push_back(strData)` → **copies the value**, not the reference.
- Each vector element is an **independent `std::string` object**.
- Changing `strData` later does **not** affect prior copies.

### 🔁 To Get "Reference-Like" Behavior (Not Recommended):
```cpp
std::string strData = "One";
std::vector<std::string*> str_Vector;  // Vector of POINTERS

str_Vector.push_back(&strData);  // Store address
strData = "Two";                 // Modifies the SAME object
// Now all pointers in vector see "Two"
```
> ⚠️ Danger: Dangling pointers if `strData` goes out of scope. Prefer values unless you truly need shared mutation.

### 🎯 Key C++ Mindset Shift:
> **"If it's not `*` or `&`, it's a value copy."**  
> C++ defaults to **value semantics**. C#/Java default to **reference semantics** for objects.

---

## 🔀 2.16 Strings in `switch` & Command-Line Args

### ✅ String `switch` (Java 7+)
```java
String cmd = "cancel";
switch(cmd) {
    case "connect":    /* ... */ break;
    case "cancel":     System.out.println("Canceling"); break;  // ✅ Matches
    case "disconnect": /* ... */ break;
    default:           System.out.println("Error!");
}
```
- ✔️ Cleaner than long `if-else` chains.
- ⚠️ Slightly slower than `int` switches → use only when input is already a `String`.

---

## 💻 Command-Line Arguments (Java)

### 📥 How `main(String[] args)` Works:
```java
class CLDemo {
    public static void main(String[] args) {
        System.out.println("Count: " + args.length);
        for(int i = 0; i < args.length; i++) 
            System.out.println("arg[" + i + "]: " + args[i]);
    }
}
```
**Run**: `java CLDemo one two three`  
**Output**:
```
Count: 3
arg[0]: one
arg[1]: two
arg[2]: three
```

### 🔍 Practical Example: Phone Lookup
```java
// Run: java Phone Mary
if (args.length != 1) {
    System.out.println("Usage: java Phone <name>");
} else {
    for (String[] entry : numbers) {
        if (entry[0].equals(args[0])) {  // ✅ Use .equals() for String comparison!
            System.out.println(entry[0] + ": " + entry[1]);
            break;
        }
    }
}
```
> ⚠️ **Never use `==` to compare String content in Java** → use `.equals()`.

---



*/
