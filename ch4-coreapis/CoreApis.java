public class CoreApis{
	public static void main(String... coreapis){
		//testConcatenation();
		testImportantStringMethods();
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
		
	}
	
	private static void testMethodChaining(){
		
	}
}