//The final modifier prevents a class from being extended any further
public class Mammal { }
final class Rhinoceros extends Mammal { }
class Clara extends Rhinoceros { } // DOES NOT COMPILE