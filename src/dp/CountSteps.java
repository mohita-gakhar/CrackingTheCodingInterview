package dp;

import java.util.Arrays;

public class CountSteps {
	
	private static int countSteps(int n)
	{
		int[] count = new int[n+1];
		Arrays.fill(count, -1);
		return countSteps(n, count);
	}
	
	/**
	 * One can also use a map to store cached values
	 * O(N) time and O(N) space solution
	 * Use bottom up DP and with variables solution can be cut to O(1) space
	 * @param n
	 * @param count
	 * @return
	 */
	private static int countSteps(int n, int[] count) {
		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		if(count[n] == -1)
		{
			count[n] = countSteps(n-1,count) + countSteps(n-2,count) + countSteps(n-3, count);
		}
		return count[n];
	}

	public static void main(String[] args) {
		int n = 50;
		System.out.println("n = "+n);
		int steps = countSteps(n);
		System.out.println("Count Steps = "+steps);
	}

}
