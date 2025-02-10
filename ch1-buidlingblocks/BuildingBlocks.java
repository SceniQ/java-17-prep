/**
Understanding Package Declarations and Imports
A statement is an instruction, and import statements tell Java which packages to look in for
classes.
The import statement doesn’t bring in child packages, fields, or methods; 
it imports only classes directly under the package 
**/
import java.util.Random; // import tells us where to find Random

//Wildcards Classes in the same package are often imported together. You can use a shortcut to import all
//the classes in a package.
import java.util.*; // imports java.util.Random among other things

public class BuildingBlocks{
	/**
	To use most classes, you have to create objects. An object is a runtime instance of a class
	in memory. An object is often referred to as an instance since it represents a single representation
	of the class. All the various objects of all the different classes represent the state of
	your program. A reference is a variable that points to an object.
	**/
	
	//1. Fields and Methods
	//Java classes have two primary elements: methods, often called functions or procedures in
	//other languages, and fields, more generally known as variables. Together these are called the
	//members of the class.
	
	//we define a variable named name. We also declare the type of that variable to
	//be String. A String is a value that we can put text into, such as "this is a string".
	//String is also a class supplied with Java
	String name;
	
	//Next we can add methods - A method is an operation that can be called. Again,
	//public is used to signify that this method may be called from other classes.
	//The method name and parameter types are called the method signature.
	public String getName() {
	 return name;
	}
	public void setName(String newName) {
	 name = newName;
	}
	
	//2. Comments
	//Another common part of the code is called a comment. Because comments aren’t executable
	//code, you can place them in many places. Comments can make your code easier to read.
	
	// comment until end of line
	
	//A single-line comment begins with two slashes. The compiler ignores anything you type
	//after that on the same line. Next comes the multiple-line comment:
	/* Multiple
	* line comment
	*/
	
	//A multiple-line comment (also known as a multiline comment) includes anything starting
	//from the symbol /* until the symbol */. People often type an asterisk (*) at the beginning of
	//each line of a multiline comment to make it easier to read, but you don’t have to. Finally, we
	//have a Javadoc comment:
	/**
	* Javadoc multiple-line comment
	* @author Jeanne and Scott
	*/
	
	//3. Writing a main() Method - The main() method is often called an entry
	//point into the program, because it is the starting point that the JVM looks for when it begins
	//running a new program.
	public static void main(String[] args) {
		System.out.println("Hello World");
		//4. Passing Parameters to a Java Program - The code args[0] accesses the first element of the array. That’s right: array indexes begin
		//with 0 in Java.	
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		Random r = new Random(); // DOES NOT COMPILE WITHOUT PROPER IMPORT STATEMENT!
		System.out.println(r.nextInt(10));
	}
	
}

//Classes and Source Files
//top-level type is a data structure that can be defined independently
//within a source file
class Animal {
 String name;
}