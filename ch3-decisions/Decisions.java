public class Decisions{
	
	public static void main(String... x){
		//testPatternMatching(10);
		//testPatternVariablesAndExpressions(10);
		testTheSwitchStatement(2);
	}
	
	private static void testPatternMatching(Number number){
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
	
	private static void testPatternVariablesAndExpressions(Number number){
		/**
		The variable data in this example is referred to as the pattern variable. Notice that this
		code also avoids any potential ClassCastException because the cast operation is executed
		only if the implicit instanceof operator returns true.
		**/
		
		//1. Pattern matching includes expressions that can be used to filter data out, such as in the following example:
		if(number instanceof Integer data && data.compareTo(5)>0)
			System.out.print(data);
		
		
		//2. Subtypes
		//The type of the pattern variable must be a subtype of the variable on the left side of the
		//expression. It also cannot be the same type.
		Integer value = 123;
		if(value instanceof Integer) {}
		//BELOW STATEMENT DOES NOT COMPILE: error - expression type Integer is a subtype of pattern type Integer
		//if(value instanceof Integer data) {}

		
		//3. Flow Scoping
		//Flow scoping means the variable is only in scope when the compiler can definitively determine its type
		//BELOW STATEMENT DOES NOT COMPILE: the compiler cannot guarantee that data is an instance of Integer, data is not in scope
		//if(number instanceof Integer data || data.compareTo(5)>0)
		//	System.out.print(data);
		//You might be thinking that the pattern variable is then only in scope inside the if statement, right? Well, not exactly:
		if (!(number instanceof Integer data))
			return;
		System.out.print(data.intValue());
	}
	
	private static void testTheSwitchStatement(int day){
		/**
		The switch statement is a complex decision-making structure in 
		which a single value is evaluated and flow is redirected to the first matching branch, known
		as a case statement:
		
		What if we have a lot of possible branches or paths for a single value? For example, we
		might want to print a different message based on the day of the week. We could certainly
		accomplish this with a combination of seven if or else statements, but Java, along with many other languages, provides a cleaner approach. In this
		section we present the switch statement
		**/
		
		//1. with Java 14, case values can now be combined:
		switch(day) {
			case 1,2: System.out.print("Lion");
			case 3: System.out.print("Tiger");
		}
		System.out.println();
		//Prior to Java 14, the equivalent code would have been the following:
		switch(day) {
			case 1: case 2: System.out.print("Lion");
			case 3: System.out.print("Tiger");
		}
		
		//2. One last note you should be aware of for the exam: a switch statement is not required to contain any case
		//statements. For example, this statement is perfectly valid:
		switch(day) {}
	}
}