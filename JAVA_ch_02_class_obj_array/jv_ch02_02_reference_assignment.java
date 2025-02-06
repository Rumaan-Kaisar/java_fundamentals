
/* -=-=-=-=-=-=-=-=-=-=-=      reference variables and assignment      -=-=-=-=-=-=-=-=-=-=-= 

A primitive type variables (i.e. int, double etc) and object reference variables act differently in an assignment operation. 
	When you assign one primitive-type variable to another, the situation is straightforward. The variable on the left receives a copy of the value of the variable on the right. 
	When you assign one object reference variable to another, the situation is a bit more complicated because you are changing the object that the reference variable refers to. The effect of this difference can cause some counterintuitive results. For example, 

Vehicle car1 = new Vehicle();
Vehicle car2 = car1;

Looks like car1 and car2 refer to different objects, but this is not the case. Instead, car1 and car2 will both refer to the same object. The assignment of car1 to car2 simply makes car2 refer to the same object as does car1. Thus, the object can be acted upon by either car1 or car2. For example, after the assignment car1.mpg = 26; executes, both of following println() statements display the same value: 26.			System.out.println(car1.mpg);
System.out.println(car2.mpg);

	Although car1 and car2 both refer to the same object, they are not linked in any other way. For example, a subsequent assignment to car2 simply changes the object to which car2 refers. The object referred to by car1 is unchanged.

   Vehicle car1 = new Vehicle();
   Vehicle car2 = car1;
   Vehicle car3 = new Vehicle();
   car2 = car3; // now car2 and car3 refer to the same object.

*/
