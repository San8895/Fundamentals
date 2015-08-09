package Arrays;

import java.util.Scanner;
import java.util.HashSet;

/*Write an efficient algorithm to find a lonely element in the given integer of size N 
 where each element repeated twice except one.
 */

public class LonleyElement {
	// declaring a new global array which will contain the sorted list of element
	public static int[] sortedarr;

	// naive method,using for loop
	public static int solution1(int[] arr) {

		int count = 1, temp = -1;
		for (int i = 0; i < arr.length; i++) {
			count = 1;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) {
					count = 0;
					break;
				}
			}
			if (count == 1) {
				temp = arr[i];
				break;
			}
		}

		return temp;
	}

	// solution2, merge sorting and then doing the comparison
	public static int solution2(int[] arr) {
		int temp = -1;
		sortedarr = new int[arr.length];
		int num = arr.length - 1;
		// call sorting method
		mergesort(arr, 0, num);

/*		// print the sorted array for debugging purpose
		System.out.println("The sorted array is :");
		for (int r : sortedarr)
			System.out.print(r + " ");
		System.out.println("\n");*/

		// comparing the sorted list
		int len = sortedarr.length;
		for (int i = 0; i <= len; i = i + 2) {
			if (i < len-1) {
				if (sortedarr[i] != sortedarr[i + 1]){
					temp = sortedarr[i];
					break;
				}	
			}

			else if (i == len-1) {
				if (arr[len - 2] != arr[len - 1]) {
					temp = arr[len-1];
					break;
				}

			}
		}

		return temp;
	}

	public static void mergesort(int[] arr, int lowerindex, int upperindex) {
		int middleindex = (lowerindex + upperindex) / 2;
		if (lowerindex >= upperindex)
			return;
		mergesort(arr, lowerindex, middleindex);
		mergesort(arr, (middleindex + 1), upperindex);
		merge(arr, lowerindex, upperindex);
	}

	public static void merge(int[] arr, int i, int j) {
		int start = i;
		int mid = (i + j) / 2;
		int k = mid + 1;
		int l = i;
		while (i <= mid && k <= j) {
			if (arr[i] <= arr[k])
				sortedarr[l++] = arr[i++];
			else
				sortedarr[l++] = arr[k++];
		}
		// System.out.println("The value of k and j and l are "+ k+" "+j+" "+l);
		if (i > mid)
			for (; k <= j;) {

				sortedarr[l++] = arr[k++];
			}

		else if (k > j)
			for (; i <= mid;)
				sortedarr[l++] = arr[i++];
		for (l = start; l <= j; l++)
			arr[l] = sortedarr[l];

	}
	
	// solution3, Using XOR
	public static int solution3(int[] arr) {
		int temp=0;
		for(int i=0;i<arr.length;i++)
			temp^=arr[i];
		return temp;
	}
	
	// solution4, Using hashset
	public static int solution4(int[] arr) {
		int temp=-1;
		int value;
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0;i<arr.length;i++){
			value=arr[i];
			if(!set.contains(value))
				set.add(value);
			else
				set.remove(value);
		}
		
		if(set.isEmpty())
			temp=-1;
		else
			temp=set.iterator().next();
	//	System.out.println("Inside Hashset and value of lonely element is "+temp);
		return temp;
	}
	
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of list in the Array");
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();

		// solution 1,naive method. Time complexity is O(n2) and space
		// capturing the time
		long startTime = System.nanoTime();
		int lonley1 = solution1(arr);
		long endTime = System.nanoTime();
		System.out.println("The first method with O(n^2)using double for loop took "+ (endTime - startTime) / 1000+ " micro seconds to find the lonely integer i.e. : "+ lonley1);

		// solution 2,sorting and then searching. Time complexity is
		// O(nlogn+n/2) i.e nlogn for sorting and n/2 for comparison and space
		// complexity=O(n)
		long startTime2 = System.nanoTime();
		int lonley2 = solution2(arr);
		long endTime2 = System.nanoTime();
		System.out.println("The second method O(NlogN+N/2) using sorting took "+ (endTime2 - startTime2) / 1000+ " micro seconds to find the lonely integer i.e. : "+ lonley2);
		
		
		// solution 3,Using XOR functionlaity.Xor follows associative law i.e (A^B)^c=A^(B^C).
		//Time complexity is O(n) and space complexity=constant;
		long startTime3 = System.nanoTime();
		int lonley3 = solution3(arr);
		long endTime3 = System.nanoTime();
		System.out.println("The second method O(N)using XOR took "+ (endTime3 - startTime3) / 1000+ " micro seconds to find the lonely integer i.e. : "+ lonley3);
		
		
		// solution 4,Using Hashset which allows to keep only distinct element.
		//Time complexity is O(n) and space complexity=constant;
		long startTime4 = System.nanoTime();
		int lonley4 = solution4(arr);
		long endTime4 = System.nanoTime();
		System.out.println("The second method O(N) using hashset took "+ (endTime4 - startTime4) / 1000+ " micro seconds to find the lonely integer i.e. : "+ lonley4);
		
		

		sc.close();
	}

}
