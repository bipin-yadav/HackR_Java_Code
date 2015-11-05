/*Gaurav went to a chocolate factory. Since it was his first visit, the manager decided to give him a gift. The manager told Gaurav that when a chocolate is being made at the factory, its sweetness at the ith second is given by c * i * sqrt(i) * log2(i), where c is a constant. He asked Gaurav to tell him the maximum integer K when the chocolate making process should be stopped, and Gaurav could take home the chocolate that was made. Gaurav did not like chocolates that had a sweetness greater than S. Help Gaurav to find the maximum integer value K such that the sweetness level of the chocolate that he wants does not exceed S.
Input:
First line contains T, that is the no. of testcases. T lines follow.
Each line contains 2 space-separated positive integers, c and S.
Output:
Print T lines, each containing a single integer which is the answer to the ith testcase,
i.e. the time at which Gaurav wants the chocolate-making process to be stopped.
Constraints:
1 <= T <= 10^5
1 <= c <= 100
2 <= S <= 10^15
Sample testcase:
Input:
1
1 9
Output:
3
Explanation:
c=1, S=9.
At the 3rd second, the sweetness of the chocolate is approximately 8.23, which is less than S.
At the 4th second, the sweetness of the chocolate becomes 16, which is greater than S.
Hence, Gaurav reports K=3 to the manager as it is the maximum possible value such that sweetness does not exceed S.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TestClass {
    public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		ArrayList<String> arint = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			arint.add(br.readLine());
		}		
		for(int i = 0; i < N; i++){
			System.out.println(result(arint.get(i)));
		}
	}
    
    public static int result(String str) {  
    	//System.out.println(str);
    	String[] splitStr = str.split("\\s+");
		int c = Integer.parseInt(splitStr[0]);
		//System.out.println(c);
		int s = Integer.parseInt(splitStr[1]);
		//System.out.println(s);	
		int sum=0,i=0;
		while(sum < s){
			i++;
			sum =  sum + (c * i * (int)Math.sqrt(i) * (int)Math.log(i));
		}
	return --i;
}
    
}