public class Operators{
	
	public static void main(String... x){
		//testTypesOfOperators();
		//testOperatorPrecedence();
		//testComplementAndNegationOperators();
		//testIncrementAndDecrementOperators();
		//testArithmeticOperators();
		testNumericPromotion();
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
		long pigeon = 1 + ((3 * 5) / 3; // DOES NOT COMPILE
		int blueJay = (9 + 2) + 3) / (2 * 4; // DOES NOT COMPILE
		//This example does not compile because Java, unlike some other programming languages,
		//does not allow brackets, [], to be used in place of parentheses. If you replace the brackets
		//with parentheses, the last example will compile just fine.
		short robin = 3 + [(4 * 2) + 4]; // DOES NOT COMPILE
		
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
		z = x * y; // The result z is then a long value.
		
		//2. What is the data type of x + y?
		double a = 39.21;
		float b = 2.1;
		z = a + b; // This is actually a trick question, as the second line does not compile!
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
		long feathers = 10(long); // DOES NOT COMPILE
	}
	
}