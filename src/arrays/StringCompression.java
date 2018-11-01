package arrays;

public class StringCompression {
	
	/**
	 * Time complexity is O(n) 
	 * where n is length of string
	 * It creates the compressed string first
	 * and then checks
	 * @param input
	 * @return
	 */
	private static String stringCompressed(String input){
		int index=0;
		StringBuilder result= new StringBuilder();
		int len= input.length();
		while(index<len){
			char c= input.charAt(index);
			result.append(c);
			int count=1;
			while(++index<len && input.charAt(index)== c){
				count++;
			}
			result.append(count);			
		}
		return (result.length()<input.length())? result.toString():input;
	}
	
	/**
	 * The other way to do it is check if we need to compress
	 * Optimal where we don't have a large # of repeating chars
	 * saves creation of string we may never use and we can set the capacity of StringBuilder
	 * (doesn't need to double every time)
	 * Downside: loops through chars twice and duplicated code
	 * @param input
	 * @return
	 */
	private static String compression(String input){
		int newLen= countCompression(input);
		if(input.length()<=newLen){
			return input;
		}
		int index=0;
		StringBuilder result= new StringBuilder(newLen);
		int len= input.length();
		while(index<len){
			char c= input.charAt(index);
			result.append(c);
			int count=1;
			while(++index<len && input.charAt(index)== c){
				count++;
			}
			result.append(count);			
		}
		return result.toString();
	}

	private static int countCompression(String input) {
		int compressedLength=0;
		int index=0;
		int len= input.length();
		while(index<len){
			char c= input.charAt(index);
			while(++index<len && input.charAt(index)== c){
			}
			compressedLength+=2;
		}
		return compressedLength;
	}

	public static void main(String[] args) {
		String input="aabca";
		System.out.println("Input String is "+input);
		System.out.println("Compressed string is "+compression(input));
	}

}
