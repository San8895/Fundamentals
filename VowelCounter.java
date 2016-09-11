package General_code;
import java.util.Scanner;
import java.util.HashSet;


public class VowelCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the string/sentance whose vowels count you want to count");
		String word=sc.nextLine();
		System.out.println("The number of vowels in "+word+" is :" +countVowel1(word));
		System.out.println("The number of vowels in "+word+" is :" +countVowel2(word));
		sc.close();
	}

	private static int countVowel2(String str) {
		// TODO Auto-generated method stub
		String word=str.toLowerCase();
		int count=0;
		HashSet<Character> hs=new HashSet<Character>();
		hs.add('a');
		hs.add('e');
		hs.add('i');
		hs.add('o');
		hs.add('u');
		char [] ch =word.toCharArray();
		
		for(Character chr :ch){
			if(hs.contains(chr))
				count++;
		}

		return count;
	}

	private static int countVowel1(String str) {
		// TODO Auto-generated method stub
		String word=str.toLowerCase();
		char [] ch =word.toCharArray();
		int count=0;
		for(Character c:ch){
			switch(c){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				count++;
			break;
			default:
				//no count increment
			}
			
		}
		
		
		return count;
	}


}
