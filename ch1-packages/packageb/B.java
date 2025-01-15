package packageb;
import packagea.A;
public class B{
	public static void main(String... args){
		A a = new A();
		System.out.println(a.toString());
<<<<<<< HEAD
		System.out.println(Float.valueOf(1)); //works without casting
		System.out.println(Byte.valueOf((byte)1)); //doesn't work without casting
		System.out.println(Short.valueOf((short)1)); //doesn't work without casting
		int z;
=======
		String textBlock = """
			"Java Study Guide"
				by Scott & Me :D!""";
		System.out.println(textBlock);		
>>>>>>> 16258ce3964da43a946663e9eb959621b9b841c2
	}
}