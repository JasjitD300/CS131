public class MyFirstClass {
    public static void main(String[] args){
//declare two integer values
int num1 = 1;
int num2 = 2;
// next print out the values on seperate lines

System.out.println(num1 + num2);
System.out.println(num2 - num1);
System.out.println(num2 * num1);
System.out.println(num1 / num2);

//declare new value and make it the same as num2
int num3 = 2;
System.out.println(num1 / num3);

double zero = 0;
double positiveOne = 1;
double negativeOne = -1;

System.out.println(zero / zero);
System.out.println(positiveOne / zero);
System.out.println(negativeOne / zero);

//declare strings
String greeting1 = "hello";
String greeting2 = "greetings";
System.out.println(greeting1 + greeting2);
System.out.println(greeting1 + num1);
System.out.println(num2 + greeting2);

//step 4

String stringEQUATION = num1 + " + " + num2 + " = " + num1 + num2;
System.out.println(stringEQUATION);
stringEQUATION = num1 + " + " + num2 + " = " + (num1 + num2);
System.out.println(stringEQUATION);


int step5Int = 5;
String step5String = "Great";
String seperator1 = "---";
System.out.println(step5Int * step5Int * step5Int);
System.out.println(step5String + seperator1 + step5String + seperator1 + step5String + seperator1 + step5String);

//update seperator

seperator1 = "+++";
System.out.println((step5String + seperator1 + step5String + seperator1 + step5String + seperator1 + step5String));
System.out.println((step5String + step5String + step5String + step5String + step5String + step5String + step5String));
}
public static void printWithSeperator(String theString, String seperator){
    System.out.println(theString + seperator + theString+ seperator + theString);
}}


