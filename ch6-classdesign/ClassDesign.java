public class ClassDesign{
	
	public static void main(String... x){
	
	}
}


//Hiding Static Methods
class Bear {
	public static void eat() {
		System.out.println("Bear is eating");
	} 	
}
class Panda extends Bear {
	public static void eat() {
		System.out.println("Panda is chewing");
	}
	public static void main(String[] args) {
		eat();
	} 
}

//Hiding Variables
//A hidden variable occurs when a child class defines a variable with the same name as an
//inherited variable defined in the parent class
class Carnivore {
	protected boolean hasFur = false;
}
class Meerkat extends Carnivore {
	protected boolean hasFur = true;
	
	public static void main(String[] args) {
		Meerkat m = new Meerkat();
		Carnivore c = m;
		System.out.println(m.hasFur); // true
		System.out.println(c.hasFur); // false
	}
}

//1. Understanding Inheritance
//Inheritance is the process by which a subclass automatically includes certain members
//of the class, including primitives, objects, or methods, defined in the parent class

//Writing final Methods
//final methods cannot be overridden. By marking a method
//final, you forbid a child class from replacing this method
//you cannot hide a static method in a child class if it is marked
//final in the parent class.
class Bird {
	public final boolean hasFeathers() {
		return true;
	}
	public final static void flyAway() {}
}
class Penguin extends Bird {
	//public final boolean hasFeathers() { // DOES NOT COMPILE
	//	return false;
	//}
	//public final static void flyAway() {} // DOES NOT COMPILE
}

//Introducing Abstract Classes
//An abstract class is a class declared with the
//abstract modifier that cannot be instantiated directly and may contain abstract methods
abstract class Canine {}
class Wolf extends Canine {}