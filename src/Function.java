import java.util.Scanner;

import sun.misc.Regexp;


public class Function {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ���ַ������Կո�ָ�:");
        String data = scanner.nextLine();
        String[] res = data.split(" ");
        for(String single:res)
        {
        	System.out.println(single);
        }
	}
}
