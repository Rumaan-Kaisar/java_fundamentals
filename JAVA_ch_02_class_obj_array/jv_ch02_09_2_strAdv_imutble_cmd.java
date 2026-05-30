
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

                String s = "Sachin";  
                s = s.concat(" Tendulkar");  
                System.out.println(s); 

    In this case it looks like String is mutable, String s changes to new string.

    But actually s is just a referance variable, pointing two different String objects
        one is "Sachin" and other is "Sachin Tendulkar"

    Nothing mysterious is happening—just object creation + reference reassignment. 
    The confusion usually comes from mixing up the object with the variable pointing to it.


    First consider the following Version:

                String s="Sachin";  
                s.concat(" Tendulkar");     //concat() method appends the string at the end  
                System.out.println(s);      //will print Sachin because strings are immutable objects 

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
                "Sachin" --> still exists and is unchanged
                "Sachin Tendulkar" --> created temporarily, then becomes eligible for "garbage collection"

        That’s why:
                System.out.println(s);

            prints "Sachin"



    Now consider the assignment version:

                String s = "Sachin";  
                s = s.concat(" Tendulkar");  
                System.out.println(s); 

        Step 1: Initial string
        
                String s = "Sachin";

            A String object "Sachin" is created.
            Variable s points to that object.


        Step 2: With reassignment

                s = s.concat(" Tendulkar");

            Now:
                "Sachin Tendulkar" is created
                s is updated to point to this new object


        --------  What happens to "Sachin"?  --------

        So the situation becomes:
            "Sachin" --> still exists in memory (unchanged)
            "Sachin Tendulkar" --> now referenced by s

        Where did the “immutable string” go?
            It never went anywhere.

            The original "Sachin" object is still intact
            It just might no longer be referenced by your variable

            If no variables reference it anymore, the "Java Garbage Collector" will eventually clean it up.
            In Java, an object stays alive only if something still references it.


    --------  What is case in C++?  --------

    above thing actually does happen in C++ too—just in a slightly different way.

    The core idea is the same across all languages:
        If you lose all ways to reach an object, you can’t use it anymore.
        But how that loss happens differs.

    In C++ with std::string:
    
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



    --------  So why Strings in C++ said to be mutable  --------

    Java String immutability means the String object itself can never change.

    C++ std::string mutability means the same string object can change its contents.
        although some expressions (such as s + "text") may create temporary string objects during evaluation.


    Java String is immutable:
                String s = "Sachin";
                s.concat(" Tendulkar");

        The "Sachin" object can never be modified.
        Instead:

                s.concat(" Tendulkar");

            creates a new String object:
            The original "Sachin" object remains exactly as it was.


    C++ std::string is mutable:
                std::string s = "Sachin";
                s += " Tendulkar";

        Here the string object stored in s is modified directly.

        Before:
                s -> "Sachin"

        After:
                s -> "Sachin Tendulkar"

            The same string object changes its contents.
            This is possible because std::string is mutable.


    In short:
        Java String objects never change; every modification creates a new String object.
        
        C++ std::string objects are mutable; 
        many operations modify the existing string, 
        although some expressions (such as s + "text") may create temporary string objects during evaluation.

    ====================================================================================


    ----------------    Strings to control SWITCH and Command-Line arguments    ----------------

    Using Strings in Switch Statements:
        A "String" can be used to control a "switch" statement in Java.
        String-based "switch" is often cleaner and more readable than equivalent "if/else" chains.

    However, switching on strings can be less efficient than switching on integers. 
        Use "string-based switch" only when the controlling data is already in "String" form.
        Avoid unnecessary string switches.

    Example:

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


# Strings to Control SWITCH and Command-Line Arguments

---


### 💻 Example: String Switch Statement
```java
String command = "cancel";

switch(command) {
    case "connect":
        System.out.println("Connecting");
        break;
    case "cancel":
        System.out.println("Canceling");
        break;
    case "disconnect":
        System.out.println("Disconnecting");
        break;
    default:
        System.out.println("Command Error!");
        break;
}
```

### 🔍 How It Works
- The string value in `command` (e.g., `"cancel"`) is compared against each `case` constant.
- When a match is found, the corresponding code block executes.
- In the example above, `"cancel"` matches the second case → outputs: `Canceling`.

---

## 2. Command-Line Arguments in Java

### ✅ What Are Command-Line Arguments?
- Command-line arguments are inputs provided directly after the program name when executing a Java application.
- Example: `java MyProgram arg1 arg2 arg3`

### ✅ Accessing Arguments in Code
- Arguments are passed to the `main()` method as a `String` array: `String args[]`
- Each argument is stored as a string at sequential indices: `args[0]`, `args[1]`, etc.

### 💻 Example 1: Display All Command-Line Arguments
```java
class CLDemo {
    public static void main(String args[]) {
        System.out.println("There are " + args.length + " command-line arguments.");
        System.out.println("They are: ");
        for(int i = 0; i < args.length; i++) {
            System.out.println("arg[" + i + "]: " + args[i]);
        }
    }
}
```

#### ▶️ Sample Execution
```bash
java CLDemo one two three
```

#### 📤 Output
```
There are 3 command-line arguments.
They are: 
arg[0]: one
arg[1]: two
arg[2]: three
```

> 📌 Note: The first argument is stored at index `0`, the second at index `1`, and so on.

---

### 💻 Example 2: Phone Lookup Using Command-Line Argument
```java
class Phone {
    public static void main(String args[]) {
        String numbers[][] = {
            { "Tom", "555-3322" },
            { "Mary", "555-8976" },
            { "Jon", "555-1037" },
            { "Rachel", "555-1400" }
        };
        
        if(args.length != 1) {
            System.out.println("Usage: java Phone <name>");
        } else {
            for(int i = 0; i < numbers.length; i++) {
                if(numbers[i][0].equals(args[0])) {
                    System.out.println(numbers[i][0] + ": " + numbers[i][1]);
                    break;
                }
            }
            if(i == numbers.length) {
                System.out.println("Name not found.");
            }
        }
    }
}
```

#### ▶️ Sample Execution
```bash
java Phone Mary
```

#### 📤 Output
```
Mary: 555-8976
```

### 🔑 Key Takeaways
- Always validate `args.length` before accessing command-line arguments to avoid `ArrayIndexOutOfBoundsException`.
- Use `.equals()` for string comparison (not `==`).
- Command-line arguments are always passed as `String` types—convert them if numeric operations are needed.

---

> ✅ **Best Practices Summary**
> 1. Use string `switch` only when necessary for readability.
> 2. Validate command-line argument count before use.
> 3. Remember: `args[0]` is the first user-provided argument (not the program name).
> 4. Keep code modular and add error handling for robust CLI programs.













# 📝 Strings: Immutability & Usage — Simplified Pointwise


---
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
