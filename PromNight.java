import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class PromNight {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		N = N + 2;
		ArrayList<String> arint = new ArrayList<String>();
		ArrayList<Integer> boys = new ArrayList<Integer>();
		int count[] = new int[2];
		ArrayList<Integer> girls = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			arint.add(br.readLine());
		}	
		for(int i = 0; i < N; i++){
			System.out.println(arint.get(i));
			String str = arint.get(i);
			String[] splitStr = str.split("\\s+");
			if(i == 0){
				for(int j=0;j<splitStr.length;j++){
					count[j] = Integer.parseInt(splitStr[j]);
					System.out.println(count[j]);
				}
			} else if(i == 1){
				for(int k=0;k<splitStr.length;k++){
					boys.add(Integer.parseInt(splitStr[k]));
				}
			}else{
				for(int j=0;j<splitStr.length;j++){
					girls.add(Integer.parseInt(splitStr[j]));
				}
			}
			
		}
		if(count[0] >= count[1]){
			System.out.println(boys);
			System.out.println(girls);
		}
		else{
			System.out.println("NO");
		}
	}
}
