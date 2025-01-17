package packageb;
import packagea.A;
public class B{
	public static void main(String... args){
		A a = new A();
		System.out.println(a.toString());
		System.out.println(Float.valueOf(1)); //works without casting
		System.out.println(Byte.valueOf((byte)1)); //doesn't work without casting
		System.out.println(Short.valueOf((short)1)); //doesn't work without casting
		int z;
		
		String textBlock = """
			"Java Study Guide"
				by Scott & Me :D!""";
		System.out.println(textBlock);	

		int numKnives;
		System.out.println("""
		   "# forks = " + numForks +
			" # knives = " + numKnives +
			# cups = 0""");		
			
		var test = "test";
			test = null;
			System.out.println(test);
			
		var num = 0;
		System.out.println(num);
		System.out.println(++num);
		System.out.println(num);
		System.out.println(num--);
		System.out.println(num);
		
		var num2 = 2;
		System.out.println(num2--);
		System.out.println(++num2);
	}
}