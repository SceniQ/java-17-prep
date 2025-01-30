public class Decisions{
	
	public static void main(String... x){
		patterMatchingTest(10);
	}
	
	private static void patterMatchingTest(Number number){
		/**
		*Java 16 officially introduced pattern matching with if statements and the instanceof operator.
		Pattern matching is a technique of controlling program flow that only executes a section
		of code that meets certain criteria.
		**/
		
		//option 1
		if(number instanceof Integer){
			Integer data = (Integer)number;
			System.out.println(data.compareTo(5));
		}
		
		//option 2 - with pattern matching
		if(number instanceof final Integer data) {
			System.out.println(data.compareTo(5));
		}
	}
}