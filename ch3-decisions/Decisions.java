import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decisions{
	
	public static void main(String... x){
		//testPatternMatching(10);
		//testPatternVariablesAndExpressions(10);
		//testTheSwitchStatement(2);
		//testTheSwitchStatement(3);
		//testTheSwitchExpression(5);
		//testTheWhileStatement(5);
		//testTheDoWhileStatement();
		//testTheForLoop();
		//testTheForEachLoop();
		//testNestedLoops();
		//testAddingOptionalLabels();
		//testTheBreakStatement();
		//testTheContinueStatement();
		testTheReturnStatement();
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
		
		System.out.println();
		//2. One last note you should be aware of for the exam: a switch statement is not required to contain any case
		//statements. For example, this statement is perfectly valid:
		switch(day) {}
		
		System.out.println();
		//3. Going back to our printDayOfWeek() method, we can rewrite it to use a switch statement
		//instead of if/else statements:
		switch(day) {
			case 0:
			System.out.print("Sunday");
			break;
			case 1:
			System.out.print("Monday");
			break;
			case 2:
			System.out.print("Tuesday");
			break;
			case 3:
			System.out.print("Wednesday");
			break;
			case 4:
			System.out.print("Thursday");
			break;
			case 5:
			System.out.print("Friday");
			break;
			case 6:
			System.out.print("Saturday");
			break;
			default:
			System.out.print("Invalid value");
			break;
		}
		//4. Exiting with break Statements (as shown above):
		// A break statement terminates the switch statement and returns flow control to the enclosing process. Put simply, it ends the switch statement immediately.
		
		System.out.println();
		//5. Determining Acceptable Case Values
		//the values in each case statement must be compile-time constant values of the same data type as the switch value
		//you can’t have a case statement value that requires executing a method at runtime, even if that method always returns the same value.
		final int bananas = 1;
		int apples = 2;
		int numberOfAnimals = 3;
		final int cookies = 0;//getCookies(); //if method exists
		switch(numberOfAnimals) {
			case bananas:
			//case apples: // DOES NOT COMPILE
			//case getCookies(): // DOES NOT COMPILE
			//case cookies : // DOES NOT COMPILE
			case 3 * 5 : //as expressions are allowed as case values, provided the value can be resolved at compile-time
		}
		
	}
	
	private static void testTheSwitchExpression(int day){
		/**
		- The switch expression supports two types of branches: an expression and	a block. 
		Each has different syntactical rules on how it must be created.
		
		- Each case or default expression requires a semicolon as well as the assignment itself.
		**/
		
		//1. a switch expression supports zero or many case branches and an optional default branch.
		var result = switch(day) {
			case 0 -> "Sunday";
			case 1 -> "Monday";
			case 2 -> "Tuesday";
			case 3 -> "Wednesday";
			case 4 -> "Thursday";
			case 5 -> "Friday";
			case 6 -> "Saturday";
			default -> "Invalid value";
		};
		System.out.print(result);
		System.out.println();
		
		//2. case statements can take multiple values, separated by commas
		switch(day) {
			case 1, 2, 3 -> System.out.print("Winter");
			case 4, 5, 6 -> System.out.print("Spring");
			case 7, 8, 9 -> System.out.print("Summer");
			case 10, 11, 12 -> System.out.print("Fall");
		}
		System.out.println();
		
		//3. All of the branches of a switch expression that do not throw an exception must return a consistent data type (if the switch expression returns a value)
		int measurement = 10;
		int size = switch(measurement) {
			case 5 -> 1;
			case 10 -> (short)2;
			default -> 5;
			//case 20 -> "3"; // DOES NOT COMPILE
			//case 40 -> 4L; // DOES NOT COMPILE
			//case 50 -> null; // DOES NOT COMPILE
		};
		System.out.println();
		
		//4. If the switch expression returns a value, then every branch that isn’t an expression must yield a value.
		int fish = 5;
		int length = 12;
		var name = switch(fish) {
			case 1 -> "Goldfish";
			case 2 -> {yield "Trout";}
			case 3 -> {
				if(length > 10) yield "Blobfish";
				else yield "Green";
			}
			default -> "Swordfish";
		};
		System.out.println();
		
		//5. A default branch is required unless all cases are covered or no value is returned.
		//switch expression that returns a value must handle all possible input values

		var canis = 5;
		//String type = switch(canis) { // DOES NOT COMPILE
		//	case 1 -> "dog";
		//	case 2 -> "wolf";
		//	case 3 -> "coyote";
		//};
		
		//If the switch expression takes an enum value, add a case branch for every possible enum values
		//enum Season {WINTER, SPRING, SUMMER, FALL}
		//var resultWeather = switch(season) {
		//	case WINTER -> "Cold";	
		//	case SPRING -> "Rainy";
		//	case SUMMER -> "Hot";
		//	case FALL -> "Warm";
		//};
	}
	
	private static void testTheWhileStatement(int bitesOfCheese){
		/**
		A loop is a repetitive control structure that can execute a statement of code multiple times in succession
		**/
		
		//1. During execution, the boolean expression is evaluated before each iteration of the loop and exits if the evaluation returns false
		int counter = 0;
		while (counter < 10) {
			double price = counter * 10;
			System.out.println(price);
			counter++;
		}
		int roomInBelly = 5;
		while (bitesOfCheese > 0 && roomInBelly > 0) {
			bitesOfCheese--;
			roomInBelly--;
		}
		System.out.println(bitesOfCheese+" pieces of cheese left");
		
		//2. While loops are often used in places where you expect zero or more executions of the loop. Simply put, the body of the loop may not execute at all or may
		//execute many times.
		int full = 5;
		while(full < 5) {
			System.out.println("Not full!");
			full++;
		}
	}
	
	private static void testTheDoWhileStatement(){
		/**
		Unlike a while loop, though, a do/while loop guarantees that the statement or block will be executed at least once.
		**/
		int lizard = 0;
		do {
			lizard++;
		} while(false);
		System.out.println(lizard);
	}
	
	private static void testTheForLoop(){
		/**
		A basic for loop has the same conditional boolean expression and statement, or block of statements, as the while loops, 
		as well as two new sections: an initialization block and an update statement.
		**/
		
		//1. Variables declared in the initialization block of a for loop have limited scope and are accessible only within the for loop.
		for(int i=0; i < 10; i++)
			System.out.println("Value is: "+i);
		//System.out.println(i); // DOES NOT COMPILE
		System.out.println();
		
		//2. Alternatively, variables declared before the for loop and assigned a value in the initialization
		//block may be used outside the for loop because their scope precedes the creation of the for loop.
		int i;
		for(i=0; i < 10; i++)
			System.out.println("Value is: "+i);
		System.out.println(i);
		System.out.println();
		
		//3. Printing Elements in Reverse
		for (var counter = 5; counter > 0; counter--){
			System.out.print(counter + " ");
		}
		System.out.println();
		
		//4. Creating an Infinite Loop - This example reinforces the fact that the components of the for loop are each optional
		// press ctrl+c to terminate infinte loop!
		//for( ; ; )
		//	System.out.println("Hello World");
		System.out.println();
		
		//5. Adding Multiple Terms to the for Statement - the update statement can modify multiple variables
		int x = 0;
		for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
			System.out.print(y + " "); 
		}
		System.out.print(x + " ");
		System.out.println();
		
		//6. Redeclaring a Variable in the Initialization Block
		//int x = 0;
		//for(int x = 4; x < 5; x++) // DOES NOT COMPILE - variable a;ready declared!
		//	System.out.print(x + " ");
		//We can fix this loop by removing the declaration of x from the for loop as follows:
		for(x = 0; x < 5; x++)
			System.out.print(x + " ");	
		System.out.println();
		
		//7. Using Incompatible Data Types in the Initialization Block - The variables in the initialization block must all be of the same type!
		//int x = 0;
		//for(long y = 0, int z = 4; x < 5; x++) // DOES NOT COMPILE
		//	System.out.print(y + " ");
		System.out.println();
		
		//8. Using Loop Variables Outside the Loop - 
		for(long y = 0, x2 = 4; x < 5 && y < 10; x2++, y++)
			System.out.print(y + " ");
		//System.out.print(x); // DOES NOT COMPILE
		System.out.println();
		
	}
	
	private static void testTheForEachLoop(){
		/**
		The for-each loop is a specialized structure designed to iterate over arrays and various Collections Framework classes.
		
		The right side of the for-each loop must be one of the following:
		# A built-in Java array
		# An object whose type implements java.lang.Iterable
		**/
		
		//1. Compare these two methods that both print the values of an array, one using a traditional
		//for loop and the other using a for-each loop:
		String[] names = new String[]{"1","2","3"};
		for(int counter=0; counter<names.length; counter++)
			System.out.println(names[counter]);
		for(var name : names)
			System.out.println(name);
		System.out.println();
		
		//2. We can also use a for-each loop on a List, since it implements Iterable.
		List<String> nameList = Arrays.asList("1","2","3");
		for(var name : nameList)
			System.out.println(name);
		
		//3. On each iteration, a for-each loop assigns a variable with the same type as the generic argument
		String birds = "Jay";
		//for(String bird : birds) // DOES NOT COMPILE
		//	System.out.print(bird + " ");
		String[] sloths = new String[3];
		//for(int sloth : sloths) // DOES NOT COMPILE
		//	System.out.print(sloth + " ");
	}
	
	private static void testNestedLoops(){
		/**
		A nested loop is a loop that contains another loop, including while, do/while, for, and for-each loops.
		**/
		int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
		for(int[] mySimpleArray : myComplexArray) {
			for(int i=0; i<mySimpleArray.length; i++) {
				System.out.print(mySimpleArray[i]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		
		//1. Nested loops can include while and do/while
		int hungryHippopotamus = 8;
		while(hungryHippopotamus>0) {
			do {
				hungryHippopotamus -= 2;
			} while (hungryHippopotamus>5);
			hungryHippopotamus--;
			System.out.print(hungryHippopotamus+", ");
		}
		System.out.println();
	}
	
	private static void testAddingOptionalLabels(){
		/**
		A label is an optional pointer to the head of a statement that allows the application flow to jump to it or break from it. It is a single
		identifier that is followed by a colon (:).
		**/
		int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
		OUTER_LOOP: for(int[] mySimpleArray : myComplexArray) {
			INNER_LOOP: for(int i=0; i<mySimpleArray.length; i++) {
				System.out.print(mySimpleArray[i]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		
		//1. 
		
		System.out.println();
		
	}
	
	private static void testTheBreakStatement(){
		/**
		Break statement transfers the flow of control out to the enclosing statement
		
		Without a label parameter, the break statement will terminate the nearest inner loop it is currently in the process of executing.
		**/
		int[][] list = {{1,13},{5,2},{2,2}};
		int searchValue = 2;
		int positionX = -1;
		int positionY = -1;
		PARENT_LOOP: for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[i].length; j++) {
				if(list[i][j]==searchValue) {
					positionX = i;
					positionY = j;
					break PARENT_LOOP;
				}
			}		
		}
		if(positionX==-1 || positionY==-1){
			System.out.println("Value "+searchValue+" not found");
		} else {
			System.out.println("Value "+searchValue+" found at: " +
				"("+positionX+","+positionY+")");
		}
		
	}
	
	private static void testTheContinueStatement(){
		/**
		The continue causes flow to finish the execution of the current loop iteration
		
		While the break statement transfers control to the enclosing statement, the continue
		statement transfers control to the boolean expression that determines if the loop should continue.
		**/
		CLEANING: for(char stables = 'a'; stables<='d'; stables++) {
			for(int leopard = 1; leopard<4; leopard++) {
				if(stables=='b' || leopard==2) {
					continue CLEANING;
				}
				System.out.println("Cleaning: "+stables+","+leopard);
			}
		}
		System.out.println();
	}
	
	private static void testTheReturnStatement(){
		/**
		**/
	}
}