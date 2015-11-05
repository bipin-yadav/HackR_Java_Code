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
    	//System.out.println("string"+splitStr[0]);
		String h1 = splitStr[0];
		int one = rev(h1);
		//System.out.println(one);
		String h2 = splitStr[1];
		int two = rev(h2);
		//System.out.println(two);	
		int sum=0;
		sum = rev(one + two+"");
		//System.out.println(sum);
	return sum;
}
    
    public static int rev(String example){
    	char[] chars = example.replaceAll("^0+", "").toCharArray();
    	List<Integer> list = new ArrayList<Integer>();
    	for (char c: chars) {
    	    try {
    	        list.add(Integer.parseInt(Character.toString(c)));
    	    }
    	    catch (NumberFormatException nfe) {
    	    }
    	}
    	Collections.reverse(list);
    	//System.out.println(list);
    	String l1="";
    	for(int i=0;i<list.size();i++ ){
    		l1 = l1 + list.get(i);
    	}
    	//System.out.println("l1"+l1);
		return Integer.parseInt(l1);

    }

}
