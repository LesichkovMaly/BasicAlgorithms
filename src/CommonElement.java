import java.util.*;
public class CommonElement {

	static ArrayList<Integer> findCommonElements(ArrayList<Integer> arr1 , ArrayList<Integer> arr2){
		ArrayList<Integer> arr_common = new ArrayList<Integer>();
		int i = 0;
		while(!arr1.isEmpty() && i < Math.min(arr1.size(),arr2.size())) {
			int curr = arr1.get(i);
			if(arr2.contains(curr)) {
				
				arr1.remove(i);
				for(int j = 0 ; j < arr2.size() ; j++) {
					if(arr2.get(j) == curr) {
						arr2.remove(j);
						break;
					}
				}
				arr_common.add(curr);
				i--;
			}
			i++;
		}
		
		
		return arr_common;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(1);
		arr1.add(3);
		arr1.add(5);		
		arr1.add(3);
		arr1.add(4);		
		arr1.add(7);
		arr1.add(8);
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(1);
		arr2.add(2);
		arr2.add(10);		
		arr2.add(3);
		arr2.add(4);		
		arr2.add(9);
		arr2.add(8);
		
		
		ArrayList<Integer> res = findCommonElements(arr1,arr2);
		System.out.println(res);
	}

}
