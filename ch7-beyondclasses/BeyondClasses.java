public class BeyondClasses{
	
	public static void main(String... x){
		
	}
	
	//1. Declaring and Using an Interface
	//In Java, an interface is defined with the interface keyword, analogous to the class keyword
	//used when defining a class
	public abstract interface CanBurrow{
		public abstract Float getSpeed(int age); //Abstract interface method
		
		//Interface variables are referred to as constants because they are assumed to be
		//public, static, and final. They are initialized with a constant value when they are declared. Since
		//they are public and static, they can be used outside the interface declaration without
		//requiring an instance of the interface 
		public static final int MINIMUM_DEPTH = 2; //Constant variable
	}
	
	//2. Extending an Interface
	//Like a class, an interface can extend another interface using the extends keyword.
	public interface Nocturnal {
		public int hunt();
	}
	public interface CanFly {
		public void flap();
	}	
	public interface HasBigEyes extends Nocturnal, CanFly {}
	public class Owl implements HasBigEyes {
		public int hunt() { return 5; }
		public void flap() { System.out.println("Flap!"); }
	}
	
	//3. Inheriting an Interface
	//Like an abstract class, when a concrete class inherits an interface, all of the inherited abstract
	//methods must be implemented.
	public interface HasTail {
		public int getTailLength();
	}
	public interface HasWhiskers {
		public int getNumberOfWhiskers();
	}
	public abstract class HarborSeal implements HasTail, HasWhiskers {}
	//public class CommonSeal extends HarborSeal {} // DOES NOT COMPILE
	
	//4. Inheriting Duplicate Abstract Methods
	//Java supports inheriting two abstract methods that have compatible method declarations.
	public interface Herbivore { public void eatPlants(); }
	public interface Omnivore { public void eatPlants(); }
	public class Bear implements Herbivore, Omnivore {
		public void eatPlants() {
			System.out.println("Eating plants");
		}		
	}
	
	//5. Inserting Implicit Modifiers:
	//a. Interfaces are implicitly abstract.
	//b. Interface variables are implicitly public, static, and final.
	//c. Interface methods without a body are implicitly abstract.
	//d. Interface methods without the private modifier are implicitly public.
	public interface Soar1 {
		int MAX_HEIGHT = 10;
		final static boolean UNDERWATER = true;
		void fly(int speed);
		abstract void takeoff();
		public abstract double dive();
	}
	
	public abstract interface Soar2 {
	public static final int MAX_HEIGHT = 10;
	public final static boolean UNDERWATER = true;
	public abstract void fly(int speed);
	public abstract void takeoff();
	public abstract double dive();
	}
	
	//6. Differences between Interfaces and Abstract Classes
	//Even though abstract classes and interfaces are both considered abstract types, only interfaces
	//make use of implicit modifiers
	abstract class Husky { // abstract required in class declaration
		abstract void play(); // abstract required in method declaration
	}
	interface Poodle { // abstract optional in interface declaration
		void play(); // abstract optional in method declaration
	}
	
	//The Webby class compiles, but the Georgette class does not. Even though the two
	//method implementations are identical, the method in the Georgette class reduces the access
	//modifier on the method from public to package access
	public class Webby extends Husky {
		void play() {} // OK -play() is declared with package access in Husky
	}
	public class Georgette implements Poodle {
		void play() {} // DOES NOT COMPILE -play() is public in Poodle
	}
	
	//7. Declaring Concrete Interface Methods
	//
}