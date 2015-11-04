import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
		System.out.println(goodBadCount(arint.get(i)));
		}
	}

	public static String goodBadCount(String str) {
			
		    int badCount = 0, goodCount = 0;
			boolean bad = false,first=true;
			String[] splitStr = str.split("\\s+");
			int h = Integer.parseInt(splitStr[0]);
			ArrayList<Integer> ariniPrime = allPrimeNumber(h);
			//System.out.println(ariniPrime);
			int m = Integer.parseInt(splitStr[1]);
			int s = Integer.parseInt(splitStr[2]);
			int count = ariniPrime.size();
			for (int k = h; k < 24; k++) {
				System.out.println("h"+k);
				if(first){
					for (int j = m; j < 60; j++) {
						System.out.println("m"+j);						
						for (int l = s; l < 60; l++) {
							System.out.println("s"+l);
							for(int c = count-1;c>=0;c--){
								if (k%ariniPrime.get(c)==0 && j%ariniPrime.get(c)==0 && l%ariniPrime.get(c)==0) {							
									badCount = badCount + 1;
									bad = true;
									//System.out.println("bc"+badCount);
								}						
							}
							if(!bad){
							goodCount = goodCount + 1;	
							//System.out.println("gc"+goodCount);
							}
						}
					}
					first=false;
				}	
				else{
					for (int j = 1; j < 60; j++) {
						System.out.println("m"+j);						
						for (int l = 1; l < 60; l++) {
							System.out.println("s"+l);
							for(int c = count-1;c>=0;c--){
								if (k%ariniPrime.get(c)==0 && j%ariniPrime.get(c)==0 && l%ariniPrime.get(c)==0) {							
									badCount = badCount + 1;
									bad = true;
									//System.out.println("bc"+badCount);
								}						
							}
							if(!bad){
							goodCount = goodCount + 1;	
							//System.out.println("gc"+goodCount);
							}
						}
					}
				}
			}
		
		
		return badCount + ":" + goodCount;
	}

	public static ArrayList<Integer> allPrimeNumber(int number) {
		ArrayList<Integer> arint = new ArrayList<Integer>();
		for (int i = 2; i <= number; i++) {
			if (isPrimeNumber(i)) {
				arint.add(i);
			}
		}
		return arint;
	}
	
	public static boolean isPrimeNumber(int number){      
        for(int i=2; i<=number/2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
	
}
