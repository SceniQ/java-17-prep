public class Operators{
	
	public static void main(String... x){
		//testTypesOfOperators();
		//testOperatorPrecedence();
		//testComplementAndNegationOperators();
		//testIncrementAndDecrementOperators();
		//testArithmeticOperators();
		//testNumericPromotion();
		//testCastingValues();
		//testCompoundAssignmentOperators();
		//testReturnValueOfAssignmentOperators();
		testEqualityOperators();
	}
	
	private static void testTypesOfOperators(){
		/**
		Java supports three flavors of operators: unary, binary, and ternary. These types of operators
		can be applied to one, two, or three operands, respectively.
		Java operators are not necessarily evaluated from left-to-right	order. In this following
		example, the second expression is actually evaluated from right to left, given the specific
		operators involved
		**/
		//In this example, you first decrement cookies to 3, then multiply the resulting value by
		//2, and finally add 3. The value then is automatically promoted from
		//9 to 9.0 and assigned to reward. The final values of
		//reward and cookies are 9.0 and 3, respectively, with the following printed:
		int cookies = 4;
		double reward = 3 + 2 * --cookies;
		System.out.print("Zoo animal receives: "+reward+" reward points");
	}
	
	private static void testOperatorPrecedence(){
		/**
		Determining which operators are evaluated in what order is referred to as 
		operator precedence. In this manner, Java more closely follows
		the rules for mathematics. Consider the following expression:
		**/
		//The multiplication operator (*) has a higher precedence than the addition operator (+), so
		//the height and length are both multiplied by 2 before being added together.
		var height = 1;
		var length =1;
		var perimeter = 2 * height + 2 * length;
	}
	
	private static void testComplementAndNegationOperators(){
		/**
		The logical complement operator (!) flips the value of a
		boolean expression. For example, if the value is true, it will be converted to false, and
		vice versa
		**/
		boolean isAnimalAsleep = false;
		System.out.print(isAnimalAsleep); // false
		isAnimalAsleep = !isAnimalAsleep;
		System.out.print(isAnimalAsleep); // true
		
		//1. you also need to know about the bitwise complement operator (~), which
		//flips all of the 0s and 1s in a number. It can only be applied to integer numeric types such as
		//byte, short, char, int, and long
		int value = 3;// Stored as 0011
		int complement = ~value;// Stored as 1100
		System.out.println(value);// 3
		System.out.println(complement); // -4
		//remember this rule: to find the bitwise complement of a number, multiply it by
		//negative one and then subtract one.
		System.out.println(-1*value -1);// -4
		System.out.println(-1*complement -1);// 3
		
		//2. Moving on to more common operators, the negation operator (-)
		//reverses the sign of a numeric expression, as shown in these statements:
		double zooTemperature = 1.21;
		System.out.println(zooTemperature); // 1.21
		zooTemperature = -zooTemperature;
		System.out.println(zooTemperature); // -1.21
		zooTemperature = -(-zooTemperature);
		System.out.println(zooTemperature); // -1.21
	}
	
	private static void testIncrementAndDecrementOperators(){
		/**
		Increment and decrement operators, ++ and --, respectively, can be applied to numeric variables
		and have a high order of precedence compared to binary operators. In other words,
		they are often applied first in an expression.
		
		Increment and decrement operators require special care because the order in which they
		are attached to their associated variable can make a difference in how an expression is processed
		**/
		//The following code snippet illustrates this distinction:
		int parkAttendance = 0;
		System.out.println(parkAttendance); // 0
		System.out.println(++parkAttendance); // 1
		System.out.println(parkAttendance); // 1
		System.out.println(parkAttendance--);// 1
		System.out.println(parkAttendance); // 0
	}
	
	private static void testArithmeticOperators(){
		/**
		Arithmetic operators are those that operate on numeric values.
		
		Next, we move on to operators that take two operands, called binary operators. Binary
		operators are by far the most common operators in the Java language. They can be used
		to perform mathematical operations on variables, create logical expressions, and perform
		basic variable assignments. Binary operators are often combined in complex expressions
		with other binary operators; therefore, operator precedence is very important in evaluating
		expressions containing binary operators.
		**/
		int price = 2 * 5 + 3 * 4 -8;
		//First, you evaluate the 2 * 5 and 3 * 4, which reduces the expression to this:
		price = 10 + 12 -8;
		
		//1. Changing the Order of Operation
		//Let’s return to the previous price example. The following code snippet contains the same
		//values and operators, in the same order, but with two sets of parentheses added:
		price = 2 * ((5 + 3) * 4 -8);
		//This time you would evaluate the addition operator 5 + 3, which reduces the expression
		//to the following:
		price = 2 * (8 * 4 -8);
		//You can further reduce this expression by multiplying the first two values within the
		//parentheses:
		price = 2 * (32 -8);
		//Next, you subtract the values within the parentheses before applying terms outside the
		//parentheses:
		price = 2 * 24;
		//Finally, you would multiply the result by 2, resulting in a value of 48 for price.
		
		//2. Verifying Parentheses Syntax
		//When working with parentheses, you need to make sure they are always valid and balanced.
		//Consider the following examples:
		//long pigeon = 1 + ((3 * 5) / 3; // DOES NOT COMPILE
		//int blueJay = (9 + 2) + 3) / (2 * 4; // DOES NOT COMPILE
		//This example does not compile because Java, unlike some other programming languages,
		//does not allow brackets, [], to be used in place of parentheses. If you replace the brackets
		//with parentheses, the last example will compile just fine.
		//short robin = 3 + [(4 * 2) + 4]; // DOES NOT COMPILE
		
		//3. Division and Modulus Operators
		//The modulus operator, sometimes called the remainder operator, is simply the remainder when two numbers are
		//divided.
		System.out.println(9 / 3); // 3
		System.out.println(9 % 3); // 0
		System.out.println(10 / 3); // 3
		System.out.println(10 % 3); // 1
		System.out.println(11 / 3); // 3
		System.out.println(11 % 3); // 2
		System.out.println(12 / 3); // 4
		System.out.println(12 % 3); // 0
	
		//If you hear the phrase floor value, it just means the value without anything after the decimal point.
	}
	
	private static void testNumericPromotion(){
		/**
		1. If two values have different data types, Java will automatically promote one of the
		values to the larger of the two data types.
		
		2. If one of the values is integral and the other is floating-point,
		Java will automatically promote the integral value to the floating-point
		value’s data type.
		
		3. Smaller data types, namely, byte, short, and char, are first promoted to
		int any time they’re used with a Java binary arithmetic operator with a variable (as opposed to a value), 
		even if neither of the operands is int.

		4. After all promotion has occurred and the operands have the same data type, 
		the resulting value will have the same data type as its promoted operands.
		**/
		//1. Let’s tackle some examples for illustrative purposes:
		int x = 1;
		long y = 33;
		var z = x * y; // The result z is then a long value.
		
		//2. What is the data type of x + y?
		double a = 39.21;
		//float b = 2.1;
		//z = a + b; // This is actually a trick question, as the second line does not compile!
	}
	
	private static void testCastingValues(){
		/**
		Casting is a unary operation where one data type is explicitly
		interpreted as another data type. Casting is optional and unnecessary when converting to a
		**/
		//Casting is performed by placing the data type, enclosed in parentheses, to the left of the
		//value you want to cast. Here are some examples of casting:
		int fur = (int)5;
		int hair = (short) 2;
		String type = (String) "Bird";
		short tail = (short)(4 + 10);
		//long feathers = 10(long); // DOES NOT COMPILE
		System.out.println();
		
		//2. Reviewing Primitive Assignments
		//int fish = 1.0; // DOES NOT COMPILE -  cannot assign double value to int
		//short bird = 1921222; // DOES NOT COMPILE - value too big for short
		//int mammal = 9f; // DOES NOT COMPILE - cannot assign float to int
		//long reptile = 192_301_398_193_810_323; // DOES NOT COMPILE - vaur too big for long
		
		//3. Applying Casting
		//We can fix three of the previous examples by casting the results to a smaller data type.
		//Remember, casting primitives is required any time you are going from a larger numerical
		//data type to a smaller numerical data type, or converting from a floating-point
		//number to an integral value.
		int fish = (int)1.0;
		short bird = (short)1921222; // Stored as 20678
		int mammal = (int)9f;
		//long reptile = (long)192301398193810323; // DOES NOT COMPILE - This still does not compile 
		//because the value is first interpreted as an int by the compiler and is out of range.
		long reptile = 192301398193810323L;
		System.out.println();
		
		//4. Casting Values vs. Variables
		//Revisiting our third numeric promotional rule, the compiler doesn’t require casting when
		//working with literal values that fit into the data type.
		byte hat = 1;
		byte gloves = 7 * 10;
		short scarf = 5;
		short boots = 2 + 1;
		//All of these statements compile without issue. On the other hand, neither of these statements
		//compiles:
		//short boots = 2 + hat; // DOES NOT COMPILE
		//byte gloves = 7 * 100; // DOES NOT COMPILE
	}
	
	private static void testCompoundAssignmentOperators(){
		/**
		Besides the simple assignment operator (=), Java supports numerous compound assignment
		operators.
		
		Addition assignment: a += 5
		Subtraction assignment: b -=0.2
		Multiplication assignment: c *= 100
		Division assignment: d /= 4
		**/
		//Compound operators are really just glorified forms of the simple assignment operator,
		//with a built-in arithmetic or logical operation that applies the left and right sides of the
		//statement and stores the resulting value in the variable on the left side of the statement.
		int camel = 2, giraffe = 3;
		camel = camel * giraffe; // Simple assignment operator
		camel *= giraffe; // Compound assignment operator
		
		//Compound operators are useful for more than just shorthand—they
		//can also save you from having to explicitly cast a value
		long goat = 10;
		int sheep = 5;
		//sheep = sheep * goat; // DOES NOT COMPILE
		sheep *= goat; // COMPILES
	}
	
	private static void testReturnValueOfAssignmentOperators(){
		/**
		One final thing to know about assignment operators is that the result of an assignment is an
		expression in and of itself equal to the value of the assignment
		**/
		long wolf = 5;
		//The key here is that (wolf=3) does two things. First, it sets the value of the variable
		//wolf to be 3. Second, it returns a value of the assignment, which is also 3.
		long coyote = (wolf=3);
		System.out.println(wolf); // 3
		System.out.println(coyote); // 3
		System.out.println();
	}
	
	private static void testEqualityOperators(){
		/**
		The equals operator (==) and not equals operator (!=)
		compare two operands and return a boolean value determining whether the expressions
		or values are equal or not equal, respectively.
		**/
		//boolean monkey = true == 3; // DOES NOT COMPILE
		//boolean ape = false != "Grape"; // DOES NOT COMPILE
		//boolean gorilla = 10.2 == "Koko"; // DOES NOT COMPILE
		boolean polar = (bear = true);
		System.out.println(polar); // true
	}
}