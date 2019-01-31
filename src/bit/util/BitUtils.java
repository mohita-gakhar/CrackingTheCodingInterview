package bit.util;

public class BitUtils {
	
	public static String toString(int a)
	{
		String sb = "";
		
		for(int i=0;i<32;i++)
		{
			int lsb = a & 1;
			sb = lsb + sb;
			a >>=1;
		}
		return sb;
	}

}
