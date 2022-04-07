package Tic;
import java.util.*;
public class tictac {
	\\Checking x and o count row wise column wise and diagonal wise
	public static boolean check(String str,char ch)
	{
		String input=str.toLowerCase();
		for(int i=2;i<input.length();i+=3)
		{
			if(input.charAt(i)==ch &&input.charAt(i-1)==ch &&input.charAt(i-2)==ch)
			{
				return true;
			}
		}
		for(int i=0;i<3;i++)
		{
			if(input.charAt(i)==ch &&input.charAt(i+3)==ch &&input.charAt(i+6)==ch)
			{
				return true;
			}
		}
		if((input.charAt(0)==ch &&input.charAt(4)==ch &&input.charAt(8)==ch)||input.charAt(4)==ch &&input.charAt(2)==ch &&input.charAt(6)==ch)
			return true;
		return false;
	}
	public static void main(String args[])
	{
		String str;
		Scanner sc= new Scanner(System.in);
		str=sc.nextLine();
		if(str.length()>9 || str.length()<9)
		{
			System.out.println("Invalid input");
		}
		else 
		{
			int xc=0,oc=0;
			for(int i=0;i<str.length();i++)
			{
				if(str.charAt(i)=='x')
					xc++;
				else
					oc++;
			}
			if(Math.abs(xc-oc)<=1)
			{
				boolean xr=check(str,'x');
				boolean or=check(str,'o');
				if(xr==or)
				{
					System.out.println("Match Drawn");
				}
				else if(xr)
				{
					System.out.println("x wins");
				}
				else if(or)
				{
					System.out.println("o wins");
				}
				
			}
			else
			{
				System.out.println("character count mismatch");
			}
		}
		sc.close();
	}
}
