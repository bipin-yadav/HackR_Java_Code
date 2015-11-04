import java.util.Arrays;
import java.util.Scanner;

public class StringImpl{
	private static Scanner scan;
	public static String[] performStringOperation(String s, int n){
		String[] ar = new String[n];
		Arrays.fill(ar, "");
		for(int i=0; i<s.length();i++){
			System.out.println(s.charAt(i));
			ar[i%n] = ar[i%n]+s.charAt(i);
		}
		return ar;	
	}
	public static void main(String[] ar){
	scan = new Scanner(System.in);
	String input = scan.nextLine();
	int num = scan.nextInt();
	String[] output = performStringOperation(input,num);
	for(int i=0; i<output.length;i++){
		System.out.println(output[i]);
	}
	}
}