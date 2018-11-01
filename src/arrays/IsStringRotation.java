package arrays;

public class IsStringRotation {
	
	/**
	 * Based on observation that yx is always substring of xyxy
	 * Time Complexity is based on isSubstring
	 * If contains takes O(A+B) time
	 * then this takes O(N) time
	 * where N is length of the string
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isRotation(String s1,String s2){
		if(s1.length() != s2.length() || s1.isEmpty() || s2.isEmpty()){
			return false;
		}
		String s1s1= new StringBuilder(s1).append(s1).toString();
		return s1s1.contains(s2);
	}

	public static void main(String[] args) {
		String s1="mohitagakhar";
		String s2="tagakharmohi";
		System.out.println("Strings are "+s1+" "+s2);
		System.out.println("Is "+s2+" rotation of "+s1+" "+isRotation(s1, s2));
	}

}
