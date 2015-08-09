

/*Find an efficient algorithm to search for a given element in a 2-D Array of size M*N. 
 * Assume that each rows and column in 2-D Array are sorted.
 * example  here is 2-D array of size 3*4. find position of element 16
 * 			5  8  10  15
 * 			6  9  12  17
 * 			14 16 19  23
 */

import java.util.Scanner;
import java.util.Arrays;
public class FindElementin2DArray {
	
	//display the 2-D Array
	public static void display(int [] [] arr){
		int m=arr.length;
		int n=arr[0].length;
		System.out.println("The 2-D Array is :");
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
				
		}
	}
	
	/*solution1, naive method using two for loop
	 * Time complexity is O(m*n)
	 */
	public static void solution1(int [] [] arr,int k){
		boolean status=false;
		int m=arr.length;
		int n=arr[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]==k){
					status=true;
			//		System.out.println("The match found is  "+status);
					System.out.println("The ith and jth position where match found using solution1 are "+i+" and "+j);
			
				}	
			}
			if(status==true)
				break;	
		}
		if(status==false)
		System.out.println("Element not available in the given 2-D array");
		
	}
	
	/*solution2, pass each row as separate array and do binary search in array to find the element
	 * Time complexity is O(iterate through rows and then do search for each row(having n lement)
	 * thus time complexity O(M*logN)
	 */
	public static void solution2(int [] [] arr,int k){
		int value=-1;
		int m=arr.length;
	//	int n=arr[0].length;
		for(int i=0;i<m;i++){
		//	using java.util.Arrays.binarySearch(array,key) api
			value=Arrays.binarySearch(arr[i],k);
	//		System.out.println(" the value binary search in ith"+i+" round is "+value);
			if(value >=0){
				System.out.println("The ith and jth position where match found using solution2 are "+i+" and "+value);
				break;
			}
			
		}
		if(value==-1)
			System.out.println("Element not available in the given 2-D array");
			
	}

	
	/*solution2, pass each row as separate array and do binary search in array to find the element
	 * Time complexity is O(iterate through rows and then do search for each row(having n lement)
	 * thus time complexity O(M*logN)
	 */
	public static void solution3(int [] [] arr,int k){
		int r=0;
		int c=arr[0].length-1;
		int m=arr.length;
//		int n=arr[0].length;
		 while( r<m && c>=0){
			 if(k<arr[r][c])
				 --c;
			 else if(k> arr[r][c])
				 ++r;
			 else{
					System.out.println("The ith and jth position where match found using solution3 are "+r+" and "+c);
					break;
			 } 
		 }
		
		
	}	
	

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int m,n;
		System.out.println("Enter the number of rows and column would be in 2-D Array");
		m=sc.nextInt();
		n=sc.nextInt();
		int [][] arr=new int[m][n];
		System.out.println("Enter the element of array");
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				arr[i][j]=sc.nextInt();
				
		}
		System.out.println("Enter the element which you would like to find ");
		int k=sc.nextInt();
		
		display(arr);
		long startTime = System.nanoTime();
		solution1(arr,k);
		long endTime = System.nanoTime();
		System.out.println("The first method with O(n^2)using double for loop took "+ (endTime - startTime) / 1000+ " micro seconds to find the element :"+k);

		long startTime2 = System.nanoTime();
		solution2(arr,k);
		long endTime2 = System.nanoTime();
		System.out.println("The second method with O(M*LogN)using loop + binary search took "+ (endTime2 - startTime2) / 1000+ " micro seconds to find the element :"+k);
		
		long startTime3 = System.nanoTime();
		solution3(arr,k);
		long endTime3 = System.nanoTime();
		System.out.println("The second method with O(M+N)using elimination method took "+ (endTime3 - startTime3) / 1000+ " micro seconds to find the element :"+k);
		
		
	sc.close();	
	}

}
