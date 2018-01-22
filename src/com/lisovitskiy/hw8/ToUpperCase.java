package com.lisovitskiy.hw8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToUpperCase {
	static Pattern pattern = Pattern.compile("(?<!\\w)\\w", Pattern.MULTILINE);
	
	public static StringBuffer capitalizeEachWord(String text){
		Matcher matcher = pattern.matcher(text);
		StringBuffer result = new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(result, 
					matcher.group().toUpperCase());
		}
		matcher.appendTail(result);
		return result;
	}
	public static void main(String[] args){
		String text = "when i was younger\ni never Needed";
		System.out.println(capitalizeEachWord(text));
	}
}
