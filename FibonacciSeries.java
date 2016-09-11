package General_code;
import java.util.Scanner;

public class FibonacciSeries {

	public static void fiboDynamic(int num1){
		 long [] fib =new long [num1+1];
		fib[0]=0;
		fib[1]=1;
		fib[2]=1;
		for(int i=3;i<=num1;i++){
			fib[i]= auxfiboDynamic(i,fib);
		}
		for(long r : fib){
			System.out.print(r+" ");
		}
		
	}
	public static long auxfiboDynamic(int num2, long [] fib){
		if (num2<0)
			return fib[0];
		else if (num2 ==1 || num2 ==2)
			return fib[1];
		else 
			return (auxfiboDynamic(num2-1, fib) + auxfiboDynamic( num2-2, fib));	
	}
	
	public static int PrintFiboRecursion(int num){
		if(num <1)
			return 0;
		else if (num ==1 || num==2)
			return 1;
		else 
		 return PrintFiboRecursion(num-1) + PrintFiboRecursion(num-2);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner (System.in);
		//input the number upto which fibonacci series need to be generated
		
		System.out.println("Input the Natural number(>0) upto which fibonacci series need to be generated");
		int num =sc.nextInt();
		
		System.out.println("The Series is:");
		// using recursion method
		for(int i=1;i<=num;i++){
			System.out.print(" "+PrintFiboRecursion(i));
		}
		System.out.println();
		//using for loop
		
		//using dynamic programing
		System.out.println("Series using Dynamic programing ");
		fiboDynamic(num);
		System.out.println();
		
		
		sc.close();
	}

}
