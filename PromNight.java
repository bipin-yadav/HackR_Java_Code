import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class PromNight {
	public static void main(String args[]) throws Exception {
		//Read Input.
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
		//Create Proper DataStructure.
		for(int i = 0; i < N; i++){
			System.out.println(arint.get(i));
			String str = arint.get(i);
			String[] splitStr = str.split("\\s+");
			if(i == 0){
				for(int j=0;j<splitStr.length;j++){
					count[j] = Integer.parseInt(splitStr[j]);
				}
			} 
			if(i == 1){
				for(int k=0;k<splitStr.length;k++){
					boys.add(Integer.parseInt(splitStr[k]));
				}
			}
			if(i == 2){
				for(int j=0;j<splitStr.length;j++){
					girls.add(Integer.parseInt(splitStr[j]));
				}
			}
			
		}
		//Apply Problem Logic.
		if(count[0] <= count[1]){
			//System.out.println(boys);
			Collections.sort(boys);
			//System.out.println(boys);
			//System.out.println(girls);
			Collections.sort(girls);
			//System.out.println(girls);
			int pairCount = 0;
			for(int  i=0;i<boys.size();i++){
				boolean pair=false;
				//System.out.println("for"+i);
				for(int  j=0;j<girls.size();j++){
					if(girls.get(j) < boys.get(i)){
						pair = true;					
					}
				}
				if(pair){
					pairCount++;
				}
			}
			if(pairCount >= boys.size()){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		else{
			System.out.println("NO");
		}
	}
}
