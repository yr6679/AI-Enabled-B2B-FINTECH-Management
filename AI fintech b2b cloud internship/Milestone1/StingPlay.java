package com.higradius;
// import String;

public class StingPlay {

	public static void main(String[] args) {
		String st = new String("Hola");
		String st1 = "Hola";
		String st2 = st1;
		System.out.println(st1 == st2);
		System.out.println(st == st1); // This gives false because new string doesn't provide that particular
		// string to jvm string pool while the st string is present in string pool so a new string has 
		// been made thus they are not equal.  
		
		StringBuilder str = new StringBuilder();
		str.append("Oh My God");
		str.append(" LoL");
		System.out.println(str);
		System.out.println(st + str);
		
		byte[] barr = {101, 111, 123, 98,78};
		String str1 = new String(barr);
		
		String str2 = new String(barr, 1, 3); // Start index, length of the string
		System.out.println(str1 + "\n" + str2);
		
		System.out.println(str.charAt(3));
		String str_concat1 = st1 + st2;
		String str_concat2 = st1.concat(st2);
		
		System.out.println(str_concat1);
		System.out.println(str_concat1 == str_concat2); // gives false
		System.out.println(str_concat1.equals(str_concat2)); // gives true.
	}

}
