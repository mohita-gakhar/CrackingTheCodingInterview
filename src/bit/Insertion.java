package bit;

import bit.util.BitUtils;

public class Insertion {
	
	public static int insert(int n, int m, int i, int j)
	{
		int bit = 0;
		while(m!=0)
		{
			int val = m & (1 << bit);
			m >>>=1;
			bit++;
			int mask = ~(1 << j);
			n = n & mask;
			n = n | (val << j);
			j--;
		}
		return n;
	}

	public static void main(String[] args) {
		int a = ~23423;
		System.out.println(BitUtils.toString(a));
		int b = 5;
		System.out.println(BitUtils.toString(b));		
		int c = insert(a, b, 29, 31);
		System.out.println(BitUtils.toString(c));

	}

}
