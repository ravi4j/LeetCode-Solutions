/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00151_Reverse_Words_in_a_String {
	public static void main(String[] args) {
		P00151_Reverse_Words_in_a_String solution = new P00151_Reverse_Words_in_a_String();
		String input = "the sky is blue";
		String output = solution.reverseWords(input);
		System.out.println(output);

		input = "  hello world!  ";
		output = solution.reverseWords(input);
		System.out.println(output);

		input = "a good   example";
		output = solution.reverseWords(input);
		System.out.println(output);
	}

	public String reverseWords(String s) {
		if(s == null || s.length() == 0){
			return s;
		}
		String[] words = s.trim().split("\\s+");
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < words.length; i++){
			String word = words[i];
			StringBuilder temp = new StringBuilder(word).reverse();
			builder.append(temp);
			if(i+ 1 < words.length){
				builder.append(" ");
			}
		}
		return builder.reverse().toString();
	}

}
