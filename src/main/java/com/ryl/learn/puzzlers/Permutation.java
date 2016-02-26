package com.ryl.learn.puzzlers;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	
	private static String[] permutation(String original){
		ArrayList<String> list = new ArrayList<String>();
		if(original.length() == 1){
			return new String[]{original};
		}else{
			for(int i=0;i<original.length();i++){
				String s = original.charAt(i)+"";
				String result = "";
				String resultA = result+s;
				String leftS = original.substring(0,i)+
						original.substring(i+1,original.length());
				for(String element:permutation(leftS)){
					result = resultA+element;
					list.add(result);
				}
			}
			return list.toArray(new String[list.size()]);
		}
	}
	
	public static void main(String[] args){
		System.out.println(permutation("abcd").length);
		System.out.println(Arrays.toString(permutation("abcd")));
	}
}
