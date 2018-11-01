package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Ask if permutation is acse sensitive and 
 * if whitespace is significant
 * @author Mohita
 *
 */
public class IsPermutation {
	
	/**
	 * Count Chars in Both the strings
	 * Can use boolean array of 128 length of interviewer confirms
	 * char set is ASCII and 256 if extended ASCII
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPermutation(String s1,String s2)
	{
		if(s1.length() != s2.length())
			return false;
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s1.length();i++)
		{
			char c= s1.charAt(i);
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}
			else
			{
				map.put(c,1);
			}
		}
		for(int i=0;i<s2.length();i++)
		{
			char c= s2.charAt(i);
			if(!map.containsKey(c))
				return false;
			map.put(c, map.get(c)-1);
		}
		for(Map.Entry<Character, Integer> entry: map.entrySet())
		{
			if(entry.getValue() != 0)
				return false;
		}
		return true;
	}
	
	public static boolean isPermutationAscii(String s1, String s2)
	{
		if(s1.length() != s2.length())
			return false;
		
		int[] letters = new int[128]; //256 for extended ASCII
		for(int i=0;i<s1.length();i++)
		{
			int c = s1.charAt(i);
			letters[c]++;
		}
		for(int i=0;i<s2.length();i++)
		{
			int c= s2.charAt(i);
			letters[c]--;
			if(letters[c] < 0)
				return false;
		}
		return true;		
	}
	
	public static String sort(String s)
	{
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	public static boolean isPermutationSort(String s1,String s2)
	{
		if(s1.length() != s2.length())
			return false;
		return sort(s1).equals(sort(s2));
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the string");
		String input1= s.nextLine();
		System.out.println("Please enter the string");
		String input2= s.nextLine();
		System.out.println("String1 is "+input1);
		System.out.println("String2 is "+input2);
		System.out.println("Are these strings permutations of each other "+isPermutation(input1, input2));
		System.out.println("Are these strings permutations of each other "+isPermutationSort(input1, input2));
		System.out.println("Are these strings permutations of each other "+isPermutationAscii(input1, input2));
		s.close();

	}

}
