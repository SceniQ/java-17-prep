public class Methods{
	
	public static void main(String... x){
		
	}
	
	/**
	
	An access modifier determines what classes a method can be accessed from.
	Access modifiers help to enforce when these components are allowed to
	talk to each other
	
	private - The private modifier means the method can be called only from within the
	same class.
	Package Access - With package access, the method can be called only from a class in
	the same package
	protected - The protected modifier means the method can be called only from a class
	in the same package or a subclass.
	public - The public modifier means the method can be called from anywhere.
	**/
	public void skip1() {}
	//default void skip2() {} // DOES NOT COMPILE - There is a default keyword, which is used in
							//switch statements and interfaces, but default is never used as an access modifier
	//void public skip3() {} // DOES NOT COMPILE - The skip3() method doesn’t compile because the access modifier is specified after the
							//return type.
	void skip4() {}
	
	
	/**
	//2. OPTIONAL SPECIFIERS
	
	There are a number of optional specifiers for methods. Unlike with
	access modifiers, you can have multiple specifiers in the same method (although not all combinations
	are legal). When this happens, you can specify them in any order. And since these
	specifiers are optional, you are allowed to not have any of them at all. This means you can
	have zero or more specifiers in a method declaration.
	
	While access modifiers and optional specifiers can appear in any order, they must all
	appear before the return type!
	**/
	public void bike1() {}
	public final void bike2() {}
	public static final void bike3() {}
	public final static void bike4() {}
	//public modifier void bike5() {} // DOES NOT COMPILE
	//public void final bike6() {} // DOES NOT COMPILE
	final public void bike7() {}
	String hike7(int a) { // DOES NOT COMPILE
		if (1 < 2) return "orange";
	}
	
	/**
	**/
}