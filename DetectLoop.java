package singleLinkList;
import java.util.Random;

public class DetectLoop<U,V> {
	public U data1;
	public V data2;
	
	DetectLoop<U,V> nextptr;
	
	public DetectLoop(){
		
	}
	
	public DetectLoop(U data1, V data2){
		this.data1=data1;
		this.data2=data2;
	}
	public  void display(){
		System.out.println("The Data1 is "+data1+" and data2 is "+data2);
	}
	public String toString(){
		return data1+"";
	}
	
	public static void main(String[] args) {
		LinkedListDetect<String,Integer> ld=new LinkedListDetect<String,Integer>();
		
		Random r=new Random();
		int total=r.nextInt(10-1)+5;
		System.out.println("The total value node in list is  "+total);
		int temp;
		for(int i=1;i<=total;i++){
			temp=r.nextInt(100-1)+10;
			ld.insertAtFist("Test"+i, temp);
			
		}
		ld.display();
		
	//inserting and detecting loop in the list
		ld.insertLoop();
		
	}

}

class LinkedListDetect<U,V>{
	
	 DetectLoop<U, V> firstlink;
	
	LinkedListDetect(){
		firstlink=null;
	}
	
	public boolean isEmpty(){
		return (firstlink==null);
	}
	
	
	public void insertAtFist(U data1,V data2){
		DetectLoop<U,V> dl =new DetectLoop<U,V>(data1,data2);
		dl.nextptr=firstlink;
		firstlink=dl;
	}
	
	public void display(){
		DetectLoop<U, V> currentlink;
		currentlink=firstlink;
		while(currentlink!=null){
			currentlink.display();
			System.out.println("The next node is "+currentlink.nextptr);
			currentlink=currentlink.nextptr;
			System.out.println();
		}
		
		
	}
	
	public void insertLoop(){
		DetectLoop<U, V> currentlink=firstlink;
		//inserting(last node will point to first node)
		while(currentlink.nextptr!=null)
			currentlink=currentlink.nextptr;
		currentlink.nextptr=firstlink.nextptr;
		
		//detecting loop
		if(findLoop( firstlink))
			System.out.println("There is a loop in the List");
		else
			System.out.println("There is no loop in the List");
		
		
	}
	public boolean findLoop(DetectLoop<U, V> firstlink){
		DetectLoop<U, V> slow=firstlink;
		DetectLoop<U, V> fast=firstlink;
		do{
			slow=slow.nextptr;
			if(fast==null || fast.nextptr==null)
				return false;
			fast=fast.nextptr.nextptr;
			
		}while(slow!=fast);
	
		return true;
	}
	
	
}
