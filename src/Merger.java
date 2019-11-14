
public class Merger {

	private static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);

	}

	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int middle = (l + r) / 2;
			mergeSort(arr, l, middle);
			mergeSort(arr, middle + 1, r);
			
			merge(arr,l,middle,r);
		}
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int[] arr1 = new int[mid-l+1];
		int[] arr2 = new int[r-mid];
 		for(int i = 0; i< arr1.length ; i++) {
 			arr1[i] = arr[l+i];
 		}
 		for(int i = 0 ; i < arr2.length ; i++) {
 			arr2[i] = arr[mid+i+1];
 		}
 		
 		int i = 0 , j = 0;
 		int k = l;
 		while(i<arr1.length && j< arr2.length) {
 			if(arr1[i]<arr2[j]) {
 				arr[k]=arr1[i];
 				i++;
 			}
 			else {
 				arr[k] = arr2[j];
 				j++;
 				
 			}
 			k++;
 		}
		
 		while(i<arr1.length) {
 			arr[k] = arr1[i];
 			k++;
 			i++;
 		}
 		while(j<arr2.length) {
 			arr[k]=arr2[j];
 			k++;
 			j++;
 		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,5,3,6,2,2,9,7};
		mergeSort(arr);
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}
}
