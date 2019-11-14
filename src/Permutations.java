import java.util.*;

public class Permutations {


	public static int factorial(int n) {
		if(n==1) {
			return 1;
		}
		else return n*factorial(n-1);
	}
	public static Set<ArrayList<Integer>> permute(ArrayList<Integer> list){
		Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
		//res.add(list);
		while(res.size()<factorial(list.size())){
			for(int i = 0 ; i< list.size();i++) {
				Random r = new Random();
				int j = r.nextInt(list.size());
				Collections.swap(list, i, j);
			}
			res.add((ArrayList<Integer>)list.clone());
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		for(int i = 8 ; i < 10 ;i++) {
			arr.add(i);
		}
		Set<ArrayList<Integer>> res = permute(arr);
		System.out.println(res);
	}
}
