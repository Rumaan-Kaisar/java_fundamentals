
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

*/


class SubStrDemo {
public static void main(String args[]) {
String orgstr = "Java makes the Web move.";
// construct a substring
String substr = orgstr.substring(5, 18); // This creates a new string that contains the desired substring.
System.out.println("orgstr: " + orgstr);
System.out.println("substr: " + substr);
}
}

/*  

----  rev[20-Apr-2026]  ----

Example 1: Folowing program demonstrate immutability of strings:
                "contents of a specific String object cannot be changed after it is created"


When we using substring() a new String object is manufactured that contains the substring, the original string is unaltered, and the rule of immutability remains intact. Here is the program that demonstrates substring( ) and the principle of immutable strings:

String orgstr = "Java makes the Web move.";
// construct a substring
String substr = orgstr.substring(5, 18);
System.out.println("orgstr: " + orgstr);
System.out.println("substr: " + substr);	Output:	orgstr: Java makes the Web move.
		substr: makes the Web

As you can see, the original string orgstr is unchanged, and substr contains the substring.
	StringBuffer: Java offers a class called StringBuffer, which creates string objects that can be changed. For example, in addition to the charAt() (which obtains the character at a specific location), StringBuffer defines setCharAt(), which sets a character within the string. Java also supplies StringBuilder, which is related to StringBuffer, and also supports strings that can be changed. 
	For general purpose use String, not StringBuffer or StringBuilder.



Notes
[1]	Mutable arrays: Once you have created an array of values, you can always change any one of the entries. Why? Because immutability could get costly as any change to an immutable array would need to be implemented as a copy (garbage collector take care of it).
	The most important non-numeric type is the string. A string can be viewed as an array of characters so it would not be unreasonable to make it mutable, but strings are also viewed as primitive values (e.g., we don’t think of “Daniel” as an array of 6 characters). Consequently, some languages have immutable strings, others have mutable strings. 
	In Java, C#, JavaScript, Python and Go, strings are immutable. Furthermore, Java, C#, JavaScript and Go have the notion of a constant: a “variable” that cannot be reassigned. 
	In Ruby and PHP, strings are mutable.
	The C language does not really have string objects per se. However, we commonly represent strings as a pointer char *. In general, C strings are mutable. The C++ language has its own string class. It is mutable.
	In both C and C++, string constants (declared with the const qualifier) are immutable, but you can easily “cast away” the const qualifier, so the immutability is weakly enforced.
	In Swift, strings are mutable. However, if you declare a string to be a constant (keyword let), then it is immutable.

I'm new to C++ coming from a background of C#, and am trying to understand how the string class in C++ works. I've read that strings are mutable in C++, but following doesn’t work like that
//Declaration for the string data
std::string strData = "One";
//Declaration for C++ vector
std:: vector <std::string> str_Vector;

	str_Vector.push_back(strData);
	strData = "Two";
	str_Vector.push_back(strData);
	strData = "Three";
	str_Vector.push_back(strData);
	strData = "Four";
	str_Vector.push_back(strData);

I am wondering why str_Vector does not become "Four", "Four", "Four", "Four"? If strings are mutable in C++ and if str_Vector stores by reference (both assumptions I've made which could very well be false), then it seems to me that we just added the pointer to strData four times, and that modifying strData should also implicitly modify str_Vector.	That's the problem with Java and C#. The differences between object and pointer are muddled beyond all recognition.

In C++, something doesn't point to something else if it's not declared with * or &. For the code to behave as you expect it, it would have to look like this:

	std::string s="One";
	std::vector<std::string *> v;
	v.push_back(&s);
	s="Two";
	v.push_back(&s);
	s="Three";
	v.push_back(&s);
	s="Four";
	v.push_back(&s);

See? Now you've pushed the same pointer into the vector four times, and changes made to any of the elements will be reflected in all the other elements. Or more accurately, changes to the object which any of the elements point to will be reflected in the object which all the other elements point to.
[2]	Immutable String in Java: In java, string objects are immutable. Immutable simply means unmodifiable or unchangeable. Once string object is created its data or state can't be changed but a new string object is created. Example given below:

	String s="Sachin";  
	s.concat(" Tendulkar"); 	//concat() method appends the string at the end  
	System.out.println(s);  	//will print Sachin because strings are immutable objects  	Output:  
	Sachin
Here Sachin is not changed but a new object is created with sachintendulkar. That is why string is known as immutable. That two objects are created but s reference variable still refers to "Sachin" not to "Sachin Tendulkar". But if we explicitely assign it to the reference variable, it will refer to "Sachin Tendulkar" object. For example:
String s="Sachin";  
s=s.concat(" Tendulkar");  
System.out.println(s);  

Output:  
          Sachin Tendulkar		In such case, s points to the "Sachin Tendulkar". Please notice that still sachin object is not modified.
	Why string objects are immutable in java?
Because java uses the concept of string literal. Suppose there are 5 reference variables, all refers to one object "sachin". If one reference variable changes the value of the object, it will be affected to all the reference variables. That is why string objects are immutable in java.







2.16 Strings to control SWITCH and Command-Line arguments 
We can use a String to control a switch. For example, using a string-based switch is an improvement over using the equivalent sequence of if/else statements. 


	However, switching on strings can be less efficient than switching on integers. Therefore, it is best to switch on strings only in cases in which the controlling data is already in string form.  Don’t use strings in a switch unnecessarily.

String command = "cancel";

switch(command) { 	case "connect": 	System.out.println("Connecting"); break;
case "cancel": 	System.out.println("Canceling"); break;
case "disconnect": 	System.out.println("Disconnecting"); break;
default: 		System.out.println("Command Error!"); break;	}
	The string contained in command (which is "cancel" in this program) is tested against the case constants. When a match is found (as it is in the second case), the code sequence associated with that sequence is executed.
	Command-Line Arguments:  We noticed args[] parameter to main() that has been in every program. Many programs use command-line arguments. A command-line argument is the information that directly follows the program’s name on the command line when it is executed. 
	To access the command-line arguments inside a Java program is quite easy—they are stored as strings in the String array passed to main(). For example, the following program displays all of the command-line arguments that it is called with:
class CLDemo { public static void main(String args[]) {
System.out.println("There are " + args.length + " command-line arguments.");
System.out.println("They are: ");
for(int i=0; i<args.length; i++) System.out.println("arg[" + i + "]: " + args[i]);
}}
If CLDemo is executed like, java CLDemo one two three 
[passing " one two three " as command line arguments  during program execution (not in compilation)]	output: There are 3 command-line arguments.
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
       int i;	if(args.length != 1) System.out.println("Usage: java Phone <name>");
else {	      //To use the program, one command-line argument must be present.
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






Example 1:  Proof of Immutability
```java
String orgstr = "Java makes the Web move.";
String substr = orgstr.substring(5, 18);  // "makes the Web"

System.out.println(orgstr);  // → "Java makes the Web move." (UNCHANGED)
System.out.println(substr);  // → "makes the Web" (NEW object)
```

### 🛠️ Need Mutable Strings? Use:
| Class | Use Case | Thread-Safe? |
|-------|----------|--------------|
| `StringBuffer` | Mutable strings, legacy code | ✅ Yes |
| `StringBuilder` | Mutable strings, modern single-threaded code | ❌ No (faster) |
| `String` | **Default choice** for almost everything | N/A (immutable) |

> Rule of thumb: Use `String` unless you're doing heavy string building in loops → then use `StringBuilder`.

---

## 🌍 Cross-Language String Mutability Cheat Sheet

| Language | Strings Mutable? | Constants Supported? | Notes |
|----------|------------------|---------------------|-------|
| **Java, C#, Python, JS, Go** | ❌ Immutable | ✅ (`final`, `const`, etc.) | New object on "change" |
| **Ruby, PHP, Swift** | ✅ Mutable | ✅ (`let` in Swift) | Swift: `let` = immutable |
| **C** | ✅ (via `char*`) | ⚠️ Weak (`const` castable) | No real string type |
| **C++** | ✅ (`std::string`) | ✅ (`const std::string`) | Mutable by default |

### ❓ Why Immutable Strings?
- **Safety**: Prevent accidental changes when multiple references point to same literal.
- **Optimization**: String pooling, hash caching, thread-safety.
- **Predictability**: Strings behave like primitive values (e.g., `"Daniel"` isn't thought of as `['D','a',...]`).

> ⚠️ **Arrays are mutable** because copying entire arrays on every change would be expensive. Strings are treated as *values*, not data structures.

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

## 🧠 Quick Recap

| Concept | Takeaway |
|---------|----------|
| **String Immutability** | "Changes" create new objects; originals stay safe |
| **Reference vs Value** | Variable can point elsewhere; object content is fixed |
| **Mutable Alternative** | `StringBuilder` for efficient concatenation |
| **C++ vs C#** | C++ copies by default; use `&`/`*` explicitly for references |
| **String `switch`** | Valid in Java, but prefer when input is already String |
| **Command-Line Args** | `args[]` is a `String[]`; index 0 = first argument |
| **String Comparison** | Always use `.equals()`, never `==` (in Java) |

*/
