package arrays;

public class StringEditsAway {
		
	/**
	 * Time Complexity is O(N*M)
	 * where N and M are length of strings
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean editsAway(String s1,String s2){
		if(s1.equals(s2)){
			return true;
		}
		if((s1.length() != s1.length()) && ((s2.length()+1) != s1.length())){
			return false;
		}

		boolean mistake= s1.length()==s2.length();
		for(char c : s2.toCharArray()){
			boolean contains= s1.contains(Character.toString(c));
			if(!contains && !mistake){
				return false;
			}
			if(!contains){
				mistake=false;
			}
		}
		return true;
	}
	/**
	 * Complexity is O(n) 
	 * where n is length of shorter string
	 * Increases the runtime only if both strings are long
	 * Cleaner and easier to follow
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean oneEditAway(String s1,String s2){
		if(s1.length()== s2.length()){
			return oneEditReplace(s1,s2);
		}
		else if(s2.length()+1 == s1.length()){
			return oneEditInsert(s1,s2);
		}
		else if(s1.length()+1 == s2.length()){
			return oneEditInsert(s2, s1);
		}
		return false;
	}
	
	/*
	 * Check if one character can be inserted in s2 to make s1
	 */
	private static boolean oneEditInsert(String s1, String s2) {
		int index1=0;
		int index2=0;
		while(index1<s1.length() && index2<s2.length()){
			if(s1.charAt(index1)!=s2.charAt(index2)){
				if(index1!=index2){
					return false;
				}
				index1++;
			}
			else{
				index1++;
				index2++;
			}
		}
		return true;
	}
	private static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference= false;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(foundDifference){
					return false;
				}
				foundDifference=true;
			}
		}
		return true;
	}
	
	/**
	 * Time Complexity is O(n) where n is length of shorter string
	 * This approach is more compact and avoids redundant code
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isEditAwayCompact(String first,String second){
		if(Math.abs(first.length()-second.length())>1){
			return false;
		}
		int index1=0;
		int index2=0;
		boolean foundDifference=false;
		String s1= first.length()>second.length()? first : second;
		String s2= first.length()<second.length()?first: second;
		while(index1 < s1.length() && index2<s2.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				if(foundDifference){
					return false;
				}
				foundDifference=true;
				if(s1.length() == s2.length()){
					index2++; //Moving the shorter pointer as well as replace can work
				}
			} else{
				index2++;
			}
			index1++; //Always move longer pointer
		}
		return true;
	}

	public static void main(String[] args) {
		String s1= "paled";
		String s2= "pale";
		System.out.println("String are "+s1+" , "+s2);
		System.out.println("Are Strings atmost one edit away "+isEditAwayCompact(s1, s2));
	}

}
