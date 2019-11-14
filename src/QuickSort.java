
public class QuickSort {

	public static void quickSort(int[] arr) {
		quickSort(arr,0,arr.length-1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pi = partition(arr,low,high);
			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);
		}
		
	}

	private static int partition(int[] arr, int low, int high) {
		int i = low - 1;
		int j = low;
		
		int pivot = arr[high];
		
		while(j<high) {
			if(pivot>arr[j]) {
				i++;
				
				swap(arr,i,j);
			}
			j++;
			
		}
		swap(arr,i+1,j);
		return i+1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,4,2,6,5,3,9,7};
		quickSort(arr);
		for(int i = 0 ; i < arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
