package arrays;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {	
	
	/**
	 * Time Complexity is O(n) 
	 * where n is length of the string
	 * @param input
	 * @return
	 */
	
	private static boolean isPalindromePermutation(String input)
	{
		//Instead of a map, a int array can also be used in case of strings with only alphabets
		Map<Character, Integer> map= new HashMap<>();
		char[] arr= input.toCharArray();
		for(int i=0;i<arr.length;i++){
			int count=1;
			if(map.containsKey(arr[i])){
				count=map.get(arr[i])+1;
			}
			map.put(arr[i], count);
		}
		boolean flag=true;
		for(Integer count: map.values()){
			if(count%2==1){
				if(!flag){
					return false;
				}
				flag=false;
			}
		}
		return true;
	}
	/**
	 * Map characters to integers a->0 etc
	 * Non letter chars are mapped to -1
	 * @param c
	 * @return
	 */
	private static int getCharNumber(Character c)
	{
		int a = Character.getNumericValue('a');
		int z= Character.getNumericValue('z');
		int val= Character.getNumericValue(c);
		if(a<=val && val<=z){
			return val-a;
		}
		return -1;
	}
	
	/**
	 * Its just an alternate solution
	 * Isn't necessarily an optimal one
	 * @param input
	 * @return
	 */
	private static boolean isPermutationAlternate(String input){
		char[] arr= input.toCharArray();
		int[] table= new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		int oddCount=0;
		for(char c: arr)
		{
			int val= getCharNumber(c);
			if(val!=-1)
			{
				table[val]++;
				if(table[val]%2==1){
					oddCount++;
				}
				else{
					oddCount--;
				}
			}
		}
		return oddCount<=1;
	}
	
	private static boolean isPermutationOfPalindrome(String input){
		int bitVector= createBitVector(input);
		return (bitVector ==0) || isOnlyOneBitSet(bitVector);
	}

	private static boolean isOnlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector-1))==0 ;
	}
	private static int createBitVector(String input) {
		int bitVector=0;
		for(char c: input.toCharArray()){
			int val= getCharNumber(c);
			bitVector = toggleBit(bitVector,val);
		}
		return bitVector;
	}
	private static int toggleBit(int bitVector, int val) {
		if(val<0)
			return bitVector;
		int mask=1<<val;
		if((bitVector & mask) == 0){
			bitVector |= mask;
		}
		else{
			bitVector &= ~mask;
		}
		return bitVector;
	}
	
	public static void main(String[] args) {
		String input="ABCDFDCBA";
		System.out.println("Is "+input+" a palindrome permutation "+isPermutationOfPalindrome(input));
	}

}
