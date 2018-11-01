package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Ask interviewer about character set of string
 * @author Mohita
 *
 */
public class IsUnique {
	
	private static boolean isUnique(String s)
	{
		Map<Character,Integer> freq = new HashMap<>();
		for(char c : s.toCharArray())
		{
			if(freq.containsKey(c))
				return false;
			freq.put(c, 1);
		}
		return true;
	}

	/*private static boolean isUniqueChars(String s)
	{
		if(s.length()>256)
			return false;
		boolean[] char_set = new boolean[256];
		for(int i=0;i<s.length();i++)
		{
			int c= s.charAt(i);
			if(char_set[c])
				return false;
			char_set[c]=true;
		}
		return true;
	}*/
	
	/**
	 * Assumes that string only consists of a-z
	 * O(n)
	 * @param s
	 * @return
	 */
	private static boolean isUniqueWithNoExtraDS(String s)
	{
		if(s.length()>26)
			return false;
		int checker=0;
		for(int i=0;i<s.length();i++)
		{
			int bitAtIndex= s.charAt(i)-'a';
			if((checker & (1<<bitAtIndex))>0)
				return false;
			checker |=(1<<bitAtIndex);
		}
		return true;
	}
	
	/**
	 * Assumes all the chars in string are from ASCII charcter set
	 * @param s
	 * @return
	 */
	private static boolean isUniqueAsciiNoDS(String s)
	{
		if(s.length()>256)
			return false;
		long checker1 = 0;
		long checker2 = 0;
		long checker3 = 0;
		long checker4 = 0;
		for(int i=0;i<s.length();i++)
		{
			int val= s.charAt(i);
			int toCheck= val/64;
			val%=64;
			switch (toCheck) {
			case 0:
				if((checker1 & (1<<val))>0)
					return false;
				checker1 |= (1<<val);
				break;
				
			case 1:
				if((checker2 & (1<<val))>0)
					return false;
				checker2 |= (1<<val);
				break;
			
			case 2:
				if((checker3 & (1<<val))>0)
					return false;
				checker3 |= (1<<val);
				break;
			
			case 3:
				if((checker4 & (1<<val))>0)
					return false;
				checker4 |= (1<<val);
				break;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the string");
		String input= s.nextLine();
		s.close();
		System.out.println("String is "+input);
		System.out.println("Does string have unique characters "+ isUniqueAsciiNoDS(input));

	}

}
