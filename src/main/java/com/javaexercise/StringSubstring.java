package com.javaexercise;

public class StringSubstring {

	public void countSubstring(String fs,String ss) {
		// TODO Auto-generated method stub
		String s=fs;
		String s1=ss;
		int len1=s.length();
		System.out.println(len1);
		int len2=s1.length();
		if(len1<len2)
		{
			return;
		}
		int len_of_replaced_str=(s.replace(s1,"")).length();
		System.out.println(len_of_replaced_str);
		int replaced_characters=len1-len_of_replaced_str;
		int no_of_substring=replaced_characters/len2;
		System.out.println("No of occurrence of the Sub String "+s1+" is : "+no_of_substring);
	}
	

}
