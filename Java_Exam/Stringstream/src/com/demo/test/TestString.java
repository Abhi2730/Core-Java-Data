package com.demo.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestString {

	public static void main(String[] args) {
		
		//List of String 
		List<String> lstring = Arrays.asList("Hello","abcd","HElloWorld","Bye","StringList","ab","abcdefgh","abfgh","abhay","about","abofabcd");
		
		
		//by using filter giving condition for String length less than 7 and starts with 'ab' sorting those only
		List<String> sortedstring = lstring.stream().filter(st->st.length()<7).filter(st->st.startsWith("ab")).collect(Collectors.toList());

		//displaying the final Output
		System.out.println("Sorted String is : "+sortedstring);
	}

}
