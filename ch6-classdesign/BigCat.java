/**Understanding Inheritance
Inheritance is the process by which a subclass automatically includes certain members
of the class, including primitives, objects, or methods, defined in the parent class
1. Declaring a Subclass 
**/

//We indicate a class is a subclass by declaring it with the
//extends keyword. We don’t need to declare anything in the superclass 
//other than making sure it is not marked final.

//When one class inherits from a parent class, all
//public and protected members are automatically available as part of the child class

//Last but not least, private members are restricted to the class they are 
//defined in and are never available via inheritance

public class BigCat {
	protected double size;
}
class Jaguar extends BigCat {
	public Jaguar() {
		size = 10.2;
	}
	public void printDetails() {
		System.out.print(size);
	}
}

class Spider {
	public void printDetails() {
		System.out.println(size); // DOES NOT COMPILE
	}
}