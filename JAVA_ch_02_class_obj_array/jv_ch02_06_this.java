
// jv_ch02_06_this                     2.8         132.3-134

/* -=-=-=-=-=-=-=-=-=-=-=      chapter name      -=-=-=-=-=-=-=-=-=-=-= 

2.8 The this reference (C/C++ this pointer, Recall C/C++ 10.8)
When a method is called, it is automatically passed an implicit argument that is a reference to the invoking object (that is, the object on which the method is called). This reference is called this.  To understand this, first consider a program that creates a class called Pwr that computes the result of a number raised to some integer power:
class Pwr {double b;
int e;
double val;

Pwr(double base, int exp) { b = base;
e = exp;
val = 1;
if(exp==0) return;
for( ; exp>0; exp--) val = val * base;}
double get_pwr() { return val; }
}	
class DemoPwr { public static void main(String args[]) {
Pwr x = new Pwr(4.0, 2);
Pwr y = new Pwr(2.5, 1);
Pwr z = new Pwr(5.7, 0);

System.out.println(x.b + " exp " + x.e + " is " + x.get_pwr());
System.out.println(y.b + " exp " + y.e + " is " + y.get_pwr());
System.out.println(z.b + " exp " + z.e +" is " + z.get_pwr());
}}
	Within a method, the other members of a class can be accessed directly, without any object or class qualification. Thus, inside get_pwr( ), the statement return val; means that the copy of val associated with the invoking object will be returned. 
	However, the same statement can also be written like this:  return this.val;
	Here, this refers to the object on which get_pwr() was called. Thus, this.val refers to that object’s copy of val. Writing the statement without using this is really just shorthand.
	Here is the entire Pwr class 
written using the this reference:	
class Pwr { double b, val; int e;
Pwr(double base, int exp) { this.b = base; this.e = exp; this.val = 1;
if(exp==0) return;
for( ; exp>0; exp--) this.val = this.val * base;
}
double get_pwr() { return this.val; }
}
	However, this has some important uses. For example, the Java syntax permits the name of a parameter or a local variable to be the same as the name of an instance variable. When this happens, the local name hides the instance variable. You can gain access to the hidden instance variable by referring to it through this. 
For Example:  Syntactically valid way to write the Pwr() constructor.	      Pwr(double b, int e) { 	this.b = b;  this.e = e;  val = 1;
			if(e==0) return;
			for( ; e>0; e--) val = val * b; }
	In this version, the names of the parameters are the same as the names of the instance variables, thus hiding them. However, this is used to “uncover” the instance variables.



*/
