package com.javaexercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RepeatedString {
	
	
	public void calcu() {
		System.out.println("newprogram");
		String s="Raghuvaran";
		char[] arr= {'R','a','g','h','u','v','a','r','a','n','r','r','a','u'};
		int count=0;
		Map<Character,Integer> map=new HashMap<Character, Integer>();
		for(char i:arr)
		{
			for(char j:arr)
			{
				if(i==j)
				{
					count=count+1;
				}
			}
			if(count>1)
			{
				if(!map.containsKey(i))
				{
					map.put(i,count);
					
					
				}
				
			}
			count=0;
		}
		Iterator<Entry<Character, Integer>> it=map.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<Character,Integer> en=(Entry<Character, Integer>)it.next();
			System.out.println(en.getKey()+":"+en.getValue());
			
		}
		
	}
	
	
	
	
	

}
