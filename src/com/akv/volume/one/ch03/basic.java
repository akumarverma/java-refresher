package com.akv.volume.one.ch03;

public class basic {
    /**
     * Java Basic:
     * ----------
     * java is case sensitive. every thing should be in class
     * main method is entry point of a program -> public static void main(String[] args){..}
     * public -> Access modifier, static -> class method, void -> not returning anything
     * class -> Noun(Upper CamelCase), Methods -> verbs(lower camelCase)
     * file name should be same as public class name(Bank.java) where Bank is public class
     * javac Bank.java -> to compile the file and generate Bytecode
     * java Bank to run class, must have a main class in order to execute. main method should be public
     * block -> {...}
     * println(each line in new line) vs print(Same line)
     * comments
     * ---------
     * 1. single line comment(//) 2. multiple line comment(/* 3. documentation(/**
     * Data Types
     * --------
     * Strongly Typed, all variable should have a type
     * eight primitive types(Integers -> [byte, short, int, long], float -> [float,double], char and boolean
     * long should have a postfix l or L, double should have a postfix d or D, float-> f or F
     * number can also be defined with 1_000_000
     * floating point without f or F is always double
     * isPositiveInfinity,isNegativeInfinity and isNaN are methods of Double class
     * Floating point issue -> bigDecimal
     * Char
     * ----
     * char -> some unicode is described as one character whereas others with 2
     * 'A' is char whereas "A" is String
     * instead of handling characters use Strings
     * unicode ???
     * --------
     * Booleans
     * -------
     * true, False
     * 0 is not False in java
     * variables
     * ---------
     * variables should ne letters and digits
     * valid letters -> a-z,A-Z,_ and $, avoid using $
     * multiple variables can be defined in same line such as int i,j =5, but not preferred
     * variables should be initialized before use, different from Class members, they are initialized to default value
     * we can declare and initialize in steps or in place also
     * variables can appear anywhere, better to declare it close to its usage
     * constants are defined as final(in Upper case seperator by _)
     * should be created as class constant so that it can be used across methods
     * Enumeration
     * -----------
     * defined a restricted set of values
     * enum Size { SMALL, MEDIUM, LARGE}, Size s = Size.SMALL
     * Operators
     * -----------
     * +,-,*,/,%
     * Math functions -> math.sqrt, math.pow, match.PI, math.E etc
     * Math function provide several method to make arithmetic operation safe
     * automatic Conversion
     * -------------------
     * automatic conversion : byte-> short-> int-> long. float-> double, char-> int
     * if case of arithmetic operations:
     * if one operand is double, other will be converted to double
     * if one is float, other will be converted to float
     * if one is long, other will be converted to long
     * otherwise both will be converted to int
     * cast
     * ----
     * int x = (int) 8.7
     * operators
     * ---------
     * assignment operators: +=,-=,*=,
     * increment and decrement operators: x++, --x
     * relational and booleans: ==,!=,<,>,<=,>=,!, &&, ||
     * && and || are of short-circuit type
     * ternary: condition ? exp1: exp2
     * Operator hierarchy
     * -----------------
     * += is right to left association, a+=b+=c => a+=(b+=c)
     * Strings
     * ------
     * String is immutable, operations of string produce new string
     * comparision is done using equals method not through ==, equalIgnoreCase
     * concatenation -> +, operands are converted to String
     * String methods: substring, statsWith,endsWith, join, chatAt,compareTo, indexOf,length
     * ""(empty or zero length String) is not same as null String
     * if(str != null && str.length() !="")
     * StringBuilder/StringBuffer
     * --------------------------
     * StringBuilder builder = new StringBuilder()
     * builder.append("Hello")
     * ...
     * String completedString = builder.toString()
     * StringBuffer is slightly less efficient, but support multithreading
     * input/output
     * ------------
     * Scanner in = new Scanner(System.in)
     * String line = in.nextLine()
     * String word = in.next()
     * int x = in.nextInt()
     * Scanner class is not good for passowrd, use Console class
     * char[] password = Console.readPassword("Password: ")
     * for security reasons, password is returned as char array
     * we should change char [] after processing password
     * Console doesn't have separate method for reading words or number as scanners
     * formatting output
     * ----------------
     * system.out.printf("%8.2f",num)
     * format specifier starts with %
     * File input and output
     * -----------------------
     * Scanner in = new Scanner(path.of("file.txt"),StandardCharsets.UTF_8)
     * PrintWriter out = new PrintWriter(path.of("file.txt"),StandardCharsets.UTF_8)
     * we can use print,println,printf to write to PrintWrite object
     * current dir: System.getProperty("user.dir")
     * scanner and PrintWriter raise IOException if file missing or not able to create
     * Scanner and PrintWriter is good for text file but not for binary,zip file etc
     * Control Flow
     * ------------
     * there is no goto, but have labeled break
     * variables can't be defined in outer and inner block
     * if.. else if.. else, else is optional, else if can repeat multiple times
     * Loops: while(condition), do while(condition)..for(int i;i<=n;i++)
     * the scope of loop index i is within loop not outside
     * Switch: Switch(ch) { case 'a': ..; break; case 'b': ..; break; default:..}
     * switch can execute multiple cases, so break is needed
     * javac -Xlint:fallthrough Myclass.java -> to get break warning
     * annotation @suppressWarning("FallThrough")
     * case label can be: char, Byte, short and Int, Enumeration value,String literals
     * break and continue
     * labeled break to break from deep nested loop
     * BigInteger and BigDecimal
     * ------------------------
     * BigInteger bi = BigInteger.valueOf(100)
     * BigInteger.ZERO,BigInteger.ONE,BigInteger.TEN
     * use add, multiply etc to perform arithmetic operations
     * Arrays
     * ------
     * int[] a or int a[]
     * int[] a =new int[100]
     * int[] a = {1,2,3,4,5}
     * array elements are initialized to default
     * array length can not be changed, if need use ArrayList
     * zero length array: int[] a = {} or int[] a = new int[0]
     * for each: for(element: Collection)
     * collection can be a array or a collection implementing iterable interface
     * Arrays-> toString, copyOf, sort
     * multi-dimensional array int[][] x
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * Some input
     * ----------
     * unicode
     * bitwise operator
     * operator hierarchy
     * Code point and code units
     * format dates
     * multi dimensional array
     */
}
