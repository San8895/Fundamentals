package singleLinkList;
import java.util.Random;
public class Linknode2 {
	
	int rollnum;
	int marks;
	String name;
	Linknode2 nextptr;
	
	Linknode2(int rollnum,int marks,String name){
		this.rollnum=rollnum;
		this.marks=marks;
		this.name=name;
	}
	
	public void display(){
		System.out.println("The marks of "+name+" with roll num "+rollnum+" is :"+marks);
	}
	
	public String toString(){
		return name;
	}
	

	public static void main(String[] args) {
		Linklist2 ll=new Linklist2();
		Random r= new Random();
		int total=r.nextInt(10-1)+5;
		int roll1,marks1;
		System.out.println("The Element count is :"+total);
		for(int i=1;i<=total;i++){
			roll1=r.nextInt(999-1)+1;
			marks1=r.nextInt(99-1)+1;
			ll.insertAtFirst(roll1, marks1, "Student"+i);
		}
		
		ll.display();
		
		System.out.println("\nThe list after reverse :");
		ll.reverse();
		ll.display(); 
		
	
		/*
		 * list of different methods
		 * 
		 * 
		System.out.println("\nThe linklist after removal at first:");
		ll.removeATFirst();
		ll.display();
		
		System.out.println("\nFinding the Student2");
		ll.find("Student2");
		
		System.out.println("\nThe linklist after finding and removal of Student2");
		ll.findandadd(100,87,"NewStudent","Student2");
		ll.display();
		
		System.out.println("\nThe linklist after finding and removal of Student2");
		ll.findanddelete("Student2");
		ll.display();
		
		System.out.println("\nThe list after reverse :");
		ll.reverse();
		ll.display(); 

		*/
	}

}

class Linklist2{
	public Linknode2 firstlink;
	Linklist2(){
		firstlink =null;
	}
	
	public boolean isEmpty(){
		return(firstlink==null);
	}
	
	public void insertAtFirst(int rollnum,int marks,String name){
		Linknode2 lk= new Linknode2(rollnum,marks,name);
		lk.nextptr=firstlink;
		firstlink=lk;
		
	}
	
	public void display(){
		Linknode2 currentlink;
		currentlink=firstlink;
		while(currentlink !=null){
			currentlink.display();
			System.out.println("The next link is :"+currentlink.nextptr);
			System.out.println();
			currentlink=currentlink.nextptr;
		}
		
	}
	
	public Linknode2 removeATFirst(){
		Linknode2 lk =firstlink;
		if(!isEmpty())
			firstlink=firstlink.nextptr;
		else
			System.out.println("Opps!! the linklist is empty");
		
		return lk;
	}
	
	public Linknode2 find(String name) {
		Linknode2 lk=firstlink;
		if(!isEmpty()){
			while(!lk.name.equalsIgnoreCase(name)){
				if(lk.nextptr==null){
					System.out.println("Element not Found in the link list");
					return null;
				}
				else
					lk=lk.nextptr;
			}
			System.out.println(" Match found, the marks for "+name+" is "+lk.marks);
			
		}else
			System.out.println("The linklist is empty");
			
		return lk;

	}

	public Linknode2 findanddelete(String name){
		Linknode2 currentlink=firstlink;
		Linknode2 previouslink=firstlink;
			while(!currentlink.name.equalsIgnoreCase(name)){
				if(currentlink.nextptr==null)
					return null;
				else{
					previouslink=currentlink;
					currentlink=currentlink.nextptr;
				}

			}
			if(currentlink==firstlink)
				firstlink=firstlink.nextptr;
			else{
				previouslink.nextptr=currentlink.nextptr;
				
			}
		
				
		return firstlink;
	}
	
	public  Linknode2 findandadd(int rollnum,int marks,String name,String key){
		Linknode2 lk= new Linknode2(rollnum,marks,name);
		Linknode2 currentlink=firstlink;
			while(!currentlink.name.equalsIgnoreCase(key)){
				if(currentlink.nextptr==null)
					return null;
				else{
					currentlink=currentlink.nextptr;
				}

			}
			if(currentlink==firstlink){
				lk.nextptr=firstlink;
				firstlink=lk;
			}
				
			else{
				lk.nextptr=currentlink.nextptr;
				currentlink.nextptr=lk;
			}
			return firstlink;
	}
	
	
	public  Linknode2 reverse() {
		Linknode2 templink=firstlink;
		Linknode2 currentlink=firstlink;
		Linknode2 previouslink=null;
		if(!isEmpty()){
			while(currentlink !=null){
				templink=currentlink.nextptr;
				currentlink.nextptr=previouslink;
				previouslink=currentlink;
				currentlink=templink;
			}
			
		}else
			System.out.println("The link list is empty");
		
		firstlink=previouslink;
		return firstlink;
	}
	
	
}

