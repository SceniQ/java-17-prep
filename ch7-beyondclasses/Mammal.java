public class Mammal {
	public Mammal(int age) {}
}
class Seal extends Mammal {} // DOES NOT COMPILE
class Elephant extends Mammal {
	public Elephant() {} // DOES NOT COMPILE
}