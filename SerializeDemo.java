package Serializationz;
import java.io.*;

 class Student implements java.io.Serializable{
	 String Name;
	 String Dept;
	 int rollNum;
	 transient int marks;
	 void studentCheck(){
		 System.out.println("The Student name is "+Name+" and roll num is "+rollNum);
	 }
	
}

public class SerializeDemo {

	public static void main(String[] args) {
		//serializing the object
		Student st =new Student();
		st.Name="Tom";
		st.rollNum=98;
		st.Dept="computer";
		st.marks=65;
		try{
			FileOutputStream fileOut = new FileOutputStream("/D:/Workspace/Collectionz/src/Student1.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(st);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in /D:/Workspace/Collectionz/src/Student.ser");
			
		}catch(IOException e){
			System.out.println("The Excpetion in serilization "+e);
		}
		
		// deserilization of the object

		Student stinput =null;
		try{
			FileInputStream fileinput= new FileInputStream("/D:/Workspace/Collectionz/src/Student1.ser");
			ObjectInputStream in=new ObjectInputStream(fileinput);
			stinput=(Student)in.readObject();
			in.close();
			fileinput.close();
		}catch(Exception i){
			System.out.println("The Excpetion in serilization "+i);
			
		}
		System.out.println();
		System.out.println("File deserialization :");
		System.out.println("The Name of Student is "+stinput.Name+" and roll num is "+stinput.rollNum+" with marks "+stinput.marks +" is from "+stinput.Dept+" department");
		

	}

}
