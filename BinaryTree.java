import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CandidateCode {
    private static TreeNode root;

    private static class TreeNode {
        TreeNode left;
        String element;
        TreeNode right;

        TreeNode(TreeNode left, String string, TreeNode right) {
            this.left = left;
            this.element = string;
            this.right = right;
        }
    }

    private static TreeNode create (List<String> wordList) {   
        root = new TreeNode(null, wordList.get(1), null);
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        final int half = wordList.size() / 2;
        for (int i = 1; i < half; i++) {
            if (wordList.get(i) != null) {
                final TreeNode current = queue.poll();
                final int left = 2 * i ;
                final int right = 2 * i + 1;
                if (wordList.get(left) != null) {
                    current.left = new TreeNode(null, wordList.get(left), null);
                    queue.add(current.left);
                }
                if (right < wordList.size() && wordList.get(right) != null) {
                    current.right = new TreeNode(null, wordList.get(right), null);
                    queue.add(current.right);
                }
            }
        }
        return root;
    }
    
    public static int findDistance(TreeNode root2, String n1, String n2){
		int x = Pathlength(root2, n1)-1;
		int y = Pathlength(root2, n2)-1;
		String lcaData = findLCA(root2, n1, n2).element;
		int lcaDistance = Pathlength(root2, lcaData)-1;
		return (x+y)- 2*lcaDistance;
	}

	public static int Pathlength(TreeNode root, String lcaData) {
		if (root != null) {
			int x = 0;
			if ((root.element.equals(lcaData)) || (x = Pathlength(root.left, lcaData)) > 0 || (x = Pathlength(root.right, lcaData)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public static TreeNode findLCA(TreeNode root, String n1, String n2) {
		if (root != null) {
			if (root.element.equals(n1) || root.element.equals(n2)) {
				return root;
			}
			TreeNode left = findLCA(root.left, n1, n2);
			TreeNode right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}
    
	public static int maxMediators(String[] input1,int input2){
		 List<String> wordList = Arrays.asList(input1);
	     root = create(wordList);
	     //System.out.println(wordList);
	     List<String> leaf = new ArrayList<String>();
	     for(int i=0;i<input2;i++){
	    	 if(!input1[i].contains("C")){
	    		 continue;
	    	 } else{
	    		 leaf.add(input1[i]);
	    	 }	    	 
	     }
	     //System.out.println(leaf);
	     int max=0;
	     for(int i=0;i<leaf.size();i++){
	    	 for(int j=0;j<i;j++){
	    		 int tempMax = findDistance(root, leaf.get(i), leaf.get(j));
	    		 if(tempMax >=max){
	    			 max = tempMax;
	    		 }
	    	 }
	     }
		return max;
    }
	
    public static void main(String[] args) {
    	String[] ar1 = { "empty", "D1", "C1", "C2" };
    	String[] ar2 = { "empty", "D1", "D2", "D3", "D4","D5","D6","empty","C1","empty","C2","C3","D7","D8",
					     "empty", "empty","empty","empty","empty","empty","empty","empty","empty","empty","C4",
					     "empty","C5","C6","empty","empty","empty","empty"};   	
        System.out.println(maxMediators(ar2,ar2.length)-1);
	}
}