import java.awt.*;
import javax.swing.*;
public class Test {		
	
	public static void main(String args[])
	{
		
		String str="P1100";
		int temp = Integer.parseInt(str.substring(1));
		temp++;
		String newStr = new String();
		if(temp >0 && temp < 10)
		{
			newStr = "P000" + temp;
		}
		else if (temp >= 10 && temp < 100)
		{
			newStr = "P00" + temp;
		}
		else if (temp >= 100 && temp < 1000)
		{
			newStr = "P0" + temp;
		}
		else if (temp >= 1000 && temp < 10000)
		{
			newStr = "P" + temp;
		}
		System.out.println(newStr);
	}
}