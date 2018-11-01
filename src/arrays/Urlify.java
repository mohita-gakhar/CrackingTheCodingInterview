package arrays;

import java.net.URLEncoder;

public class Urlify {
	
	public static void urlifyInPlace(char[] arr, int trueLength)
	{
		int spaceCount=0;
		for(int i=0;i<trueLength;i++)
		{
			if(arr[i]==' ')
				spaceCount++;
		}
		
		int finalLength = trueLength+spaceCount*2;
		for(int i= trueLength-1;i>=0;i--)
		{
			if(arr[i] == ' ')
			{
				arr[finalLength-1]='0';
				arr[finalLength-2]='2';
				arr[finalLength-3]='%';
				finalLength-=3;
			}
			else
			{
				arr[finalLength-1]=arr[i];
				finalLength-=1;
			}
				
		}
	}

	public static void main(String[] args) {
		String s="John Smith Babes      ";
		System.out.println("String is "+s);
		char[] arr= s.toCharArray();
		urlifyInPlace(arr, 16);
		System.out.println("String after urlify is "+ new String(arr));

	}

}
