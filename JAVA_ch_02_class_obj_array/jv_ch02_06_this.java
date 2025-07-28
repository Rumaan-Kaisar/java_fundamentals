
// jv_ch02_06_this                     2.8         132.3-134

/*  -=-=-=-=-=-=-=-=-=-=-=      this      -=-=-=-=-=-=-=-=-=-=-= 

    The this reference (C/C++ this pointer, Recall ch10_09_1_this.cpp)

    When a method is called, Java automatically passes a reference to the invoking object.
        That method automatically passed an "implicit argument"  i.e. a reference to the invoking object 
        (the object on which the method is called). 
        This reference is called "this". 

    "this" lets you "explicitly refer to the current object" inside its class’s methods.


    Is Java's this Similar to C++'s this Pointer?

        Yes — Both Java's this and C++'s this pointer refer to-
            "the current instance of the class" within its non-static methods.

        They're used to:
            Access instance variables and methods of the "current object".
            Resolve "naming conflicts" between local variables and instance variables.
            Pass the current object as a parameter to other methods or constructors.


        C++ this	
            Type:       Pointer (ClassName* this)	
            Syntax:     this->member or this->method()	
            Null Safety:    Can be nullptr in some rare cases	
            Usage in Static Context:    Not allowed (no object exists)	
            Memory Model:   "Explicitly" points to object's memory	


        Java this
            Type:       Reference (not a pointer)
            Syntax:     this.member or this.method()
            Null Safety:    Never null — always valid inside a method
            Usage in Static Context:       can't use this in static methods
            Memory Model:       "Implicit" reference to the object

*/




/* Example 1:  To understand "this", first consider a program that creates a class called "Pwr" 
                that computes the result of a number raised to some integer power.
*/

class Pwr {
    double b;
    int e;
    double val;

    Pwr(double base, int exp) { 
        b = base;
        e = exp;
        val = 1;

        if(exp==0) return;
        for( ; exp>0; exp--) val = val * base;
    }
    
    double get_pwr() { 
        return val; 
    }
}


class DemoPwr { 
    public static void main(String args[]) {
        Pwr x = new Pwr(4.0, 2);
        Pwr y = new Pwr(2.5, 1);
        Pwr z = new Pwr(5.7, 0);

        System.out.println(x.b + " exp " + x.e + " is " + x.get_pwr());
        System.out.println(y.b + " exp " + y.e + " is " + y.get_pwr());
        System.out.println(z.b + " exp " + z.e +" is " + z.get_pwr());
    }
}




/*  ----------------    Accessing Members with / without this    ----------------
    Inside a method, instance variables can be accessed directly:

                    return val;

    Or using this:

                    return this.val;

    Both work the same — this.val refers to the calling object’s val.
        "this" refers to the current object.


    ----------------    When this is Necessary    ----------------
    If "method parameters have the same names as instance variables", parameters hide the instance variables.

                    Pwr(double b, int e) {
                        this.b = b;  // 'this.b' refers to instance variable, 'b' is the parameter
                        this.e = e;
                    }

        Without "this", you’d only be referring to the 'parameters', not the 'instance variables'.


    Example:
        Within a method, the other members of a class can be accessed directly, without any object or class qualification. 
        Thus, in the above example, inside get_pwr(), the statement 

                    return val;         // without "this"

        means that the "copy of val" associated with the invoking object will be returned. 


        However, the same statement can also be written like this:  

                    return this.val;    // with "this"

        Here, "this" refers to the object on which get_pwr() was called. Thus, "this.val" refers to that "object’s copy of val". 
        Say, if get_pwr() had been invoked on x, then "this" in the preceding statement would have been referring to x.
            i.e. if x.get_pwr() is called, then "this.val" means "x.val".


    NOTE: 
        Writing the statement without using this is really just "shorthand".
        So, writing "val" alone is just shorthand for "this.val" inside instance methods.
            i.e. "this" implicitly applied.
        Most programmers omit "this" unless needed for clarity or disambiguation.
*/


/* Example 2: Here is the "entire Pwr class" from previous example written using the "this" reference. 
                In this version, "this" is used consistently, even when not strictly necessary.
*/

class Pwr {
    double b;
    int e;
    double val;

    Pwr(double base, int exp) { 
        this.b = base;
        this.e = exp;
        this.val = 1;

        if(exp==0) return;
        for( ; exp>0; exp--) this.val = this.val * base;
    }
    
    double get_pwr() { 
        return this.val; 
    }
}







// 

/* ----------------  Using this to Avoid Name Conflicts  ----------------
    Actually, no Java programmer would write Pwr as shown above using "this" 
        because nothing is gained, and the "standard form" is easier. 

    Using "this" to Avoid Name Conflicts in Java:
        Sometimes, a method or constructor might use "parameter or a local variable names" that 
            are the same as "instance variable names". 

        When this happens, the parameter hides (or "shadows") the instance variable.
        We can gain access to the "hidden instance variable" by referring to it through "this".



// rev[28-Jul-2025]

 For example, the
following is a syntactically valid way to write the Pwr( ) constructor.



Pwr(double b, int e) {
this.b = b; // This refers to the b instance variable, not the parameter.
this.e = e;
val = 1;
if(e==0) return;
for( ; e>0; e--) val = val * b;
}
In this version, the names of the parameters are the same as the names of the instance
variables, thus hiding them. However, this is used to “uncover” the instance variables





Example:
java
Copy
Edit
Pwr(double b, int e) {
    this.b = b; // 'this.b' means the instance variable, 'b' alone means the parameter
    this.e = e;
    val = 1;
    if(e == 0) return;
    for(; e > 0; e--) val = val * b;
}
In this code:

this.b refers to the instance variable b

b by itself refers to the parameter

Without this, Java would only see the parameter and ignore the instance variable

So, this helps Java tell the difference when both names are the same.










However, "this" has some important uses. For example, the Java syntax permits the name of a parameter or a local variable to be the same as the name of an instance variable. When this happens, the local name hides the instance variable. You can gain access to the hidden instance variable by referring to it through this. 
For Example:  Syntactically valid way to write the Pwr() constructor.	      Pwr(double b, int e) { 	this.b = b;  this.e = e;  val = 1;
			if(e==0) return;
			for( ; e>0; e--) val = val * b; }


In this version, the names of the parameters are the same as the names of the instance variables, thus hiding them. However, this is used to “uncover” the instance variables.



-----------------------------------------------------------------

Here’s a simplified, mid-ground and well-organized pointwise version:



When "this" Becomes Necessary:
Name Conflicts Between Parameters and Instance Variables:

Java allows method parameters to have the same names as instance variables.

In such cases, the parameter hides the instance variable.

Resolving the Conflict Using this:

To access the hidden instance variable, use this.

Example:

java
Copy code
Pwr(double b, int e) {
    this.b = b;  // `this.b` refers to the instance variable, `b` is the parameter
    this.e = e;
    val = 1;
    if (e == 0) return;
    for (; e > 0; e--) val *= b;
}






It improves clarity, especially when parameters or local variables share names with instance variables.

✅ Summary


It's optional unless there's a naming conflict.

It helps access hidden instance variables when parameter names are the same.


Secret Level (Amazon Prime Video)
Eyes of Wakanda 
Star Wars: Tales Of The Underworld
*/


