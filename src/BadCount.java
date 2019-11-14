import java.util.*;

public class BadCount {

	public static int[] count(int[] arr, int r)  {
		int[] res = new int[r+1];
		for(int i=0;i<r+1;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[j] == i) {
					res[i]++;
				}
			}
		}
		return res;
	}
	
	public static void removeAll(ArrayList<Integer> list) {
		while(!list.isEmpty()) {
			for(int i = list.size() - 1 ; i >= 0 ; i--) {
				removeLastOccurence(list.get(i),list);
			}
		}
	}
	
	public static void removeLastOccurence(int x , ArrayList<Integer> arr) {
		int lastIndexOf = -1;
		for(int i = arr.size()-1; i>=0 ; i--) {
			if(x == arr.get(i)) {
				lastIndexOf = i;
				break;
			}
		}
//		if(lastIndexOf != -1 ) {
//			for(int i = lastIndexOf ; i<arr.size() - 1; i++) {
//				int temp = arr.get(i);
//				arr.set(i,arr.get(i+1));
//				arr.set(i+1, temp);
//			}
//		}
		
		arr.remove(lastIndexOf);
		
		
	
	}
	public static int[] removeLastOccurence(int x , int[] arr) {
		int lastIndexOf = -1;
		if(arr.length == 0) {
			return arr;
		}
		int[] res = new int[arr.length-1];
		for(int i = arr.length - 1 ; i>=0 ; i--) {
			if(x==arr[i]) {
				lastIndexOf = i;
				break;
			}
		}
		if(lastIndexOf != -1 ) {
			for(int i = lastIndexOf ; i<arr.length - 1; i++) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1]=temp;
			}
			for(int i = 0 ; i < arr.length-1;i++) {
				res[i] = arr[i]; 
			}
			return res;
		}
		
		
		return arr;
	}

	public static void main(String[] args) {
		double[][] b = new double[7][];
		int[] arr = new int[] {0, 8, 1, 3, 1, 3, 10, 3};
		//int[] result = count(arr,4);
		int[] res = removeLastOccurence(8, arr);
//		for(int i=0;i<res.length;i++) {
//			System.out.println(res[i]);
//		}
		ArrayList list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.add(1);
		list.add(6);
		list.add(4);
		
		list.add(5);
		
		System.out.println(list.toString());
		removeAll(list);
		System.out.println(list.isEmpty());
		
		
	}
}
