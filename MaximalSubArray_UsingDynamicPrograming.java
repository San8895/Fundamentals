package General_code;
import java.util.Scanner;
import java.util.Random;

public class MaximalSubArray_UsingDynamicPrograming {
	public static int maxsubarray(int [] arr){
		int max=arr[0];
		int newsum=arr[0];
		for(int i=1;i<arr.length;i++){
			newsum=(newsum+arr[i]>arr[i])?(newsum+arr[i]):arr[i];
			max=(newsum>max)?newsum:max;
		}
		
	return max;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the number of element in the array");
		int num=sc.nextInt();
		int [] arr=new int[num];
		Random r =new Random();
		for(int i=0;i<num;i++)
			arr[i]=r.nextInt(59-1)-30;
		System.out.println("The element in the array are ");
		for(int g : arr)
			System.out.print(g+" ");
		System.out.println();
		
		System.out.println("The max subarray sum is : "+maxsubarray(arr));
		
		sc.close();
	}

}
