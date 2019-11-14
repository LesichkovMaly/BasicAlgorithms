
public class SortingAlgorithms {
	public static void insertionSort(int[] arr) {
		int i, key, j;
		for (i = 0; i < arr.length; i++) {
			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// select
			int minindex = i;
			// search for lowest element
			for (int j = i; j < arr.length; j++) {

				if (arr[minindex] >= arr[j]) {
					minindex = j;
				}
			}
			// do the swapping
			int temp = arr[minindex];
			arr[minindex] = arr[i];
			arr[i] = temp;

		}
	}

	
	public static void mergeSort(int[] elements) {
		mergeSort(elements,0,elements.length-1);
	}
	
	private static void mergeSort(int[] elements, int low, int high) {
		if(low<high) {
			int mid = (low + high)/2;
			
			mergeSort(elements,low,mid);
			mergeSort(elements,mid+1,high);
			
			merge(elements,low,mid,high);
		}		
	}

	private static void merge(int[] elements, int low, int mid, int high) {
		
		int size1 = mid - low + 1;
		int size2 = high - mid ;
		
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		
		for(int i = 0 ; i < size1;i++) {
			arr1[i] = elements[low+i];
		}
		for(int i = 0; i<size2; i++) {
			arr2[i] = elements[mid+i+1];
		}
		
		int i = 0,j = 0;
		int k = low;
		while(i<size1 && j<size2) {
			if(arr1[i]>arr2[j]) {
				elements[k] = arr2[j];
				j++;
			}
			else {
				elements[k] = arr1[i];
				i++;
			}
			k++;
		}
		while(i<size1) {
			elements[k] = arr1[i];
			i++;
			k++;
		}
		while(j<size2) {
			elements[k] =arr2[j];
			j++;
			k++;
		}
		
	}

	public static void quickSort(int[] elements) {
		quickSort(elements, 0, elements.length - 1);
	}

	public static void quickSort(int[] elements, int low, int high) {
		if (low < high) {
			int pivotIdx = partition(elements, low, high);

			quickSort(elements, low, pivotIdx - 1);
			quickSort(elements, pivotIdx + 1, high);
		}
	}

	public static int partition(int[] elements, int low, int high) {
		int pivot = elements[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (elements[j] <= pivot) {
				i++;

				swap(elements,i,j);
			}
		}

		swap(elements,i+1,high);
		return i + 1;
	}

	public static void swap(int[] elements,int i,int j) {
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
	public static void heapSort(int[] elements) {
		int n = elements.length;
		for(int i = n/2-1; i>=0;i--) {
			heapify(elements,n,i);
		}
		for(int i = n-1; i>=0 ; i--) {
			swap(elements,0,i);
			heapify(elements,i,0);
		}
	}
	
	private static void heapify(int[] elements, int n, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left<n && elements[left] > elements[largest]){
			largest  = left;
		}
		if(right<n && elements[right] > elements[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			swap(elements,i,largest);
			
			heapify(elements,n,largest);
		}
		
	}
	
	
	private static void radixLSD(String[] arr) {
		radixLSD(arr,arr[0].length());
	}

	private static void radixLSD(String[] arr, int c) {
		int n = arr.length;
		int ascii = 256;
		String[] aux = new String[n];
		
		for(int d = c-1 ; d>=0 ; d--) {
			int[] count = new int[ascii+1];
			for(int i = 0 ; i < n ; i++) {
				count[arr[i].charAt(d)+1]++;
			}
			for(int i = 0 ; i < ascii ; i++) {
				count[i+1] += count[i];
			}
			for(int i = 0 ; i < n ; i++) {
				aux[count[arr[i].charAt(d)]++] = arr[i];
			}
			for(int i = 0 ; i < n ; i++) {
				arr[i] = aux[i];
			}
		}
	}

	public static void main(String[] args) {
		String[] arr = new String[] {"RSD","ADS","FAS","FEG","AAB","SPR"};
		radixLSD(arr);
		for(String s : arr) {
			System.out.println(s);
		}
	}

}
