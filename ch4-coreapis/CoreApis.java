public class CoreApis{
	public static void main(String... coreapis){
		//testConcatenation();
		//testImportantStringMethods();
		//testMethodChaining();
		//testImportantStringBuilderMethods();
		//testEqualsMethodAndReferenceEquality();
		//testTheStringPool();
		testCreatingAnArrayOfPrimitives();
	}
	
	private static void testConcatenation(){
		/**
		Placing one String before the other String and combining them is called string concatenation.
		**/
		System.out.println(1 + 2); // 3
		System.out.println("a" + "b"); // ab
		System.out.println("a" + "b" + 3); // ab3
		System.out.println(1 + 2 + "c"); // 3c
		System.out.println("c" + 1 + 2); // c12
		System.out.println("c" + null); // cnull
		System.out.println();
		
		//1. use numeric addition if two numbers are involved, use concatenation otherwise, and evaluate from left to right
		var s = "1"; // s currently holds "1"
			s += "2"; // s currently holds "12"
			s += 3; // s currently holds "123"
		System.out.println(s); // 123
		System.out.println();
	}
	
	private static void testImportantStringMethods(){
		/**
		The exam creators pick most of the methods developers use in the real world.
		For all these methods, you need to remember that a string is a sequence of characters
		and Java counts from 0 when indexed.
		**/
		System.out.println();
		
		//1. Determining the Length - The method length() returns the number of characters in the String.
		//The method signature is as follows: public int length()
		var name = "animals";
		System.out.println(name.length()); // 7
		System.out.println();
		
		//2. Getting a Single Character - The method charAt() lets you query the string to find out what character is at a specific index.
		//The method signature is as follows: public char charAt(int index)
		System.out.println(name.charAt(0)); // a
		System.out.println(name.charAt(6)); // s
		//System.out.println(name.charAt(7)); // exception
		System.out.println();
		
		//3. Finding an Index - The method indexOf() looks at the characters in the string and finds the first index that matches the desired value.		
		//The method signatures are as follows: public int indexOf(int ch), public int indexOf(int ch, int fromIndex), public int indexOf(String str), and 
		//public int indexOf(String str, int fromIndex)
		System.out.println(name.indexOf('a')); // 0
		System.out.println(name.indexOf("al")); // 4
		System.out.println(name.indexOf('a', 4)); // 4
		System.out.println(name.indexOf("al", 5)); // -1
		System.out.println();
		
		//4. Getting a Substring - The method substring() also looks for characters in a string. It returns parts of the string.
		//The first parameter is the index to start with for the returned string.
		//The method signatures are as follows: public String substring(int beginIndex), public String substring(int beginIndex, int endIndex)
		System.out.println(name.substring(3)); // mals
		System.out.println(name.substring(name.indexOf('m'))); // mals
		System.out.println(name.substring(3, 4)); // m
		System.out.println(name.substring(3, 7)); // mals
		
		System.out.println(name.substring(3, 3)); // empty string
		// exception - this set throws an exception because the indexes can’t be backward. Java knows perfectly well that it will never get to index 2 if it starts with index 3
		//System.out.println(name.substring(3, 2));
		//System.out.println(name.substring(3, 8)); // exception -  out of bounds
		System.out.println();
		
		//5. Adjusting case - These methods make it easy to convert your data
		//The method signatures are as follows: public String toLowerCase(); public String toUpperCase().
		System.out.println(name.toUpperCase()); // ANIMALS
		System.out.println("Abc123".toLowerCase()); // abc123
		System.out.println();
		
		//6. Checking for Equality - The equals() method checks whether two String objects contain exactly the same characters in the same order. The
		//equalsIgnoreCase() method checks whether two String objects contain the same characters, with the exception that it ignores the characters’ case.
		//The method signatures are as follows: public boolean equals(Object obj); public boolean equalsIgnoreCase(String str);
		System.out.println("abc".equals("ABC")); // false
		System.out.println("ABC".equals("ABC")); // true
		System.out.println("abc".equalsIgnoreCase("ABC")); // true
		System.out.println();
		
		//7. Searching for Substrings - The startsWith() and endsWith() methods look at whether the provided value matches part of the String.
		//The contains() method isn’t as particular; it looks for matches anywhere in the String.
		//The method signatures are as follows: public boolean startsWith(String prefix); public boolean endsWith(String suffix); 
		//public boolean contains(CharSequence charSeq)
		System.out.println("abc".startsWith("a")); // true
		System.out.println("abc".startsWith("A")); // false
		System.out.println("abc".endsWith("c")); // true
		System.out.println("abc".endsWith("a")); // false
		System.out.println("abc".contains("b")); // true
		System.out.println("abc".contains("B")); // false
		System.out.println();
		
		//8. Replacing Values - The replace() method does a simple search and replace on the string
		//The method signatures are as follows: public String replace(char oldChar, char newChar);
		//public String replace(CharSequence target, CharSequence replacement);
		System.out.println("abcabc".replace('a', 'A')); // AbcAbc
		System.out.println("abcabc".replace("a", "A")); // AbcAbc
		System.out.println();
		
		//9. Removing Whitespace - These methods remove blank space from the beginning and/or end of a String.
		//The strip() and trim() methods remove whitespace from the beginning and end of a String.
		//The method signatures are as follows: public String strip(); public String stripLeading();
		//public String stripTrailing(); public String trim();
		System.out.println("abc".strip()); // abc
		System.out.println("\t a b c\n".strip()); // a b c
		String text = " abc\t ";
		System.out.println(text.trim().length()); // 3
		System.out.println(text.strip().length()); // 3
		System.out.println(text.stripLeading().length()); // 5
		System.out.println(text.stripTrailing().length());// 4
		System.out.println();
		
		//10. Working with Indentation - The indent() method adds the same number of blank spaces to the beginning of each line if you pass a positive number
		//The stripIndent() method is useful when a String was built with concatenation rather than using a text block. It gets rid of all incidental whitespace.
		//The method signatures are as follows: public String indent(int numberSpaces); public String stripIndent();
		var block = """
					a
					 b
					c""";
		var concat = " a\n"
 				   + "  b\n"
            	   + " c";
		System.out.println(block.length()); // 6
		System.out.println(concat.length()); // 9
		System.out.println(block.indent(1).length()); // 10
		System.out.println(concat.indent(-1).length()); // 7
		System.out.println(concat.indent(-4).length()); // 6
		System.out.println(concat.stripIndent().length()); // 6
		System.out.println();
		
		//12. Translating Escapes - The translateEscapes() method takes these literals and turns them into the
		//equivalent escaped character. The method signature is as follows: public String translateEscapes();
		var str = "1\\t2";
		System.out.println(str); // 1\t2
		System.out.println(str.translateEscapes()); // 1 2
		System.out.println();
		
		//12. Checking for Empty or Blank Strings - Java provides convenience methods for whether a String has a length of zero or contains only
		//whitespace characters. The method signatures are as follows: public boolean isEmpty(); public boolean isBlank();
		System.out.println(" ".isEmpty()); // false
		System.out.println("".isEmpty()); // true
		System.out.println(" ".isBlank()); // true
		System.out.println("".isBlank()); // true
		System.out.println();
		
		//13. Formatting Values - There are methods to format String values using formatting flags
		//The method signatures are as follows: public static String format(String format, Object args...);
		//public static String format(Locale loc, String format, Object args...); public String formatted(Object args...);
		var kateName = "Kate";
		var orderId = 5;
		// All print: Hello Kate, order 5 is ready
		System.out.println("Hello "+kateName+", order "+orderId+" is ready");
		System.out.println(String.format("Hello %s, order %d is ready",kateName, orderId));
		System.out.println("Hello %s, order %d is ready".formatted(kateName, orderId));
		System.out.println();
		
		/**
		%s - Applies to any type, commonly String values
		%d - Applies to integer values like int and long
		%f - Applies to floating-point values like float and double
		%n - Inserts a line break using the system-dependent line separator
		**/
		var nameJ = "James";
		var score = 90.25;
		var total = 100;
		System.out.println("%s:%n Score: %f out of %d".formatted(nameJ, score, total));
		
	}
	
	private static void testMethodChaining(){
		/**
		This is just a series of String methods. Each time one is called, the returned value is put
		in a new variable. There are four String values along the way, and AnimAl is output.
		However, on the exam, there is a tendency to cram as much code as possible into a small
		space. You’ll see code using a technique called method chaining.
		**/
		var start = "AniMaL ";
		var trimmed = start.trim(); // "AniMaL"
		var lowercase = trimmed.toLowerCase(); // "animal"
		var result = lowercase.replace('a', 'A'); // "AnimAl"
		System.out.println(result);
		System.out.println();
		
		//1. Here’s an example:
		result = "AniMaL ".trim().toLowerCase().replace('a', 'A');
		System.out.println(result);
		System.out.println();
		
		//2. To read code that uses method chaining, start at the left and evaluate the
		//first method. Then call the next method on the returned value of the first method. Keep
		//going until you get to the semicolon.
		String a = "abc";
		String b = a.toUpperCase();
		b = b.replace("B", "2").replace('C', '3');
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println();
		
		
	}
	
	private static void testMutabilityAndChaining(){
		/**
		When we chained String method calls, the result was a new String with the answer. Chaining StringBuilder
		methods doesn’t work this way. Instead, the StringBuilder changes its own state and returns a reference to itself
		**/
		StringBuilder sb = new StringBuilder("start");
		sb.append("+middle"); // sb = "start+middle"
		StringBuilder same = sb.append("+end"); // "start+middle+end"
		System.out.println();
		
		//1. This time the reference is stored in same. This means sb and same point to the same 
		//object and would print out the same value.
		StringBuilder a = new StringBuilder("abc");
		StringBuilder b = a.append("de");
		b = b.append("f").append("g");
		System.out.println("a=" + a); //abcdefg
		System.out.println("b=" + b); //abcdefg
		System.out.println();
	}
	
	private static void testImportantStringBuilderMethods(){
		//1. Using Common Methods
		//These four methods work exactly the same as in the String class. Be sure you can identify the
		//output of this example:
		var sb = new StringBuilder("animals");
		String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al")); //anim
		int len = sb.length(); //7 
		char ch = sb.charAt(6);//s
		System.out.println(sub + " " + len + " " + ch); //anim 7 s
		System.out.println();
		
		//2. Appending Values - The append() method adds the parameter to the StringBuilder and returns a reference to
		//the current StringBuilder. One of the method signatures is as follows: public StringBuilder append(String str)
		sb = new StringBuilder().append(1).append('c');
		sb.append("-").append(true);
		System.out.println(sb); // 1c-true
		System.out.println();
		
		//3. Inserting Data - The insert() method adds characters to the StringBuilder at the requested index and returns a
		//reference to the current StringBuilder. Just like append(), there are lots of method signatures
		//for different types. Here’s one: public StringBuilder insert(int offset, String str)
		sb = new StringBuilder("animals");
		sb.insert(7, "-");// sb = animals-5:
		sb.insert(0, "-");// sb = -animals-
		sb.insert(4, "-");// sb = -ani-mals-
		System.out.println(sb);
		System.out.println();
		
		//4. Deleting Contents - The delete() method is the opposite of the insert() method. It removes characters from the
		//sequence and returns a reference to the current StringBuilder. The deleteCharAt() method is convenient 
		//when you want to delete only one character. The method signatures are as follows:
		//public StringBuilder delete(int startIndex, int endIndex); public StringBuilder deleteCharAt(int index)
		sb = new StringBuilder("abcdef");
		sb.delete(1, 3); // sb = adef
		sb.deleteCharAt(5); // exception
		System.out.println();
		
		//5. Replacing Portions - The replace() method works differently for StringBuilder than it did for String.
		//The method signature is as follows: public StringBuilder replace(int startIndex, int endIndex, String newString)
		var builder = new StringBuilder("pigeon dirty");
		builder.replace(3, 6, "sty");
		System.out.println(builder); // pigsty dirty
		System.out.println();
		
		//6. Reversing - The reverse() method does just what it sounds like: 
		//it reverses the characters in the sequences and returns a reference to the current StringBuilder
		//The method signature is as follows: public StringBuilder reverse()
		sb = new StringBuilder("ABC");
		sb.reverse();
		System.out.println(sb);
		System.out.println();
	}
	
	private static void testEqualsMethodAndReferenceEquality(){
		/**
		Consider the following code that uses == with objects:
		**/
		var one = new StringBuilder();
		var two = new StringBuilder();
		var three = one.append("a");
		System.out.println(one == two); // false
		System.out.println(one == three); // true
		System.out.println();
		
		//1. You saw earlier that equals() uses logical equality rather than object equality for
		//String objects:
		// /**In case you are wondering, the authors of StringBuilder did not implement equals().
		//If you call equals() on two StringBuilder instances, it will check reference equality. You can call
		//toString() on StringBuilder to get a String to check for equality instead.**/
		var x = "Hello World";
		var z = " Hello World".trim();
		System.out.println(x.equals(z)); // true
		System.out.println();
		
		// Remember that == is checking for object reference equality!
	}
	
	private static void testTheStringPool(){
		/**
		The string pool, also known as the intern pool, is a location in the Java Virtual Machine (JVM) that
		collects all these strings.
		The string pool contains literal values and constants that appear in your program.
		For example, "name" is a literal and therefore goes into the string pool. The myObject.
		toString() method returns a string but not a literal, so it does not go into the string pool.
		**/
		var x = "Hello World";
		var y = "Hello World";
		System.out.println(x == y); // true
		System.out.println();
		
		//2. Although x and z happen to evaluate to the same string, one is computed at runtime. 
		//Since it isn’t the same at compile-time, a new String object is created
		var z = " Hello World".trim();
		System.out.println(x == z); // false
		System.out.println();
		
		//3. This prints false. Calling += is just like calling a method and results in a new String.
		//You can even force the issue by creating a new String:
		var singleString = "hello world";
		var concat = "hello ";
		concat += "world";
		System.out.println(singleString == concat); // false
		System.out.println();
		
		//4. This says, 'No, JVM, I really don’t want you to use the string pool. Please create a new object for me even though it is less
		//efficient.' 
		x = "Hello World";
		y = new String("Hello World");
		System.out.println(x == y); // false
		// You can also do the opposite and tell Java to use the string pool. The intern() method will
		//use an object in the string pool if one is present.
		//public String intern() If the literal is not yet in the string pool, Java will add it at this time.
		var name = "Hello World";
		var name2 = new String("Hello World").intern();
		System.out.println(name == name2); // true
		System.out.println();
		
		//5. 
		var first = "rat" + 1;
		var second = "r" + "a" + "t" + "1";
		var third = "r" + "a" + "t" + new String("1");
		System.out.println(first == second);
		System.out.println(first == second.intern());
		System.out.println(first == third);
		System.out.println(first == third.intern());
		System.out.println();
	}
	
	private static void testCreatingAnArrayOfPrimitives(){
		/**
		The most common way to create an array is to specify the type of the
		array (int) and the size (3). The brackets tell you this is an array.
		When you use this form to instantiate an array, all elements are set to the default value
		for that type
		
		This approach is called an anonymous array. It is anonymous because you don’t specify
		the type and size:
		**/
		int[] moreNumbers = {42, 55, 99};
		
		//1. you can type the [] before or after the name, and adding a space is optional. This
		//means that all five of these statements do the exact same thing:
		int[] numAnimals;
		int [] numAnimals2;
		int []numAnimals3;
		int numAnimals4[];
		int numAnimals5 [];
		
		//2. Creating an Array with Reference Variables
		//We can call equals() because an array is an object. It returns true because of reference
		//equality. The equals() method on arrays does not look at the elements of the array.
		//Remember, this would work even on an int[] too. The type int is a primitive; int[] is an object.
		String[] bugs = { "cricket", "beetle", "ladybug" };
		String[] alias = bugs;
		System.out.println(bugs.equals(alias)); // true
		System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0
		System.out.println();
		
	}
}