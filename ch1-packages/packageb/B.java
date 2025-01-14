package packageb;
import packagea.A;
public class B{
	public static void main(String... args){
		A a = new A();
		System.out.println(a.toString());
		String textBlock = """
			"Java Study Guide"
				by Scott & Me :D!""";
		System.out.println(textBlock);		
	}
}