import java.util.Comparator;


public class KingSort {
	
	private String kingName; 
	private int kingNumber; 
	private char[] myChars = {'L', 'X', 'V', 'I'};
	private int[] myCharNum = {50, 10, 5, 1};
	
	public KingSort(){
		
	}
	public KingSort(String kingName, int kingNum){
		this.kingName = kingName; 
		this.kingNumber = kingNum; 
	}
	
	public int getCharValue(char myC){
		if(myC == 'L'){
			return 50; 
		}
		else if(myC == 'X'){
			return 10; 
		}
		else if(myC == 'V'){
			return 5; 
		}
		else if(myC == 'I'){
			return 1; 
		}
		else{
			System.out.println("ERROR");
		}
		return 0; 
	}
	
	public int getKingNum(String romanKingNum){
		int western = 0; 
		char currentChar; 
		char nextChar; 
		int currentCharNum; 
		int nextCharNum; 
		
		for(int i = 0; i < romanKingNum.length()-1; i ++){
			currentChar = romanKingNum.charAt(i);
			nextChar = romanKingNum.charAt(i+1);
			currentCharNum = getCharValue(currentChar);
			nextCharNum = getCharValue(nextChar);
			
			if(currentCharNum < nextCharNum){
				western = western + (nextCharNum - currentCharNum);
			}
			else{
				western = western + currentCharNum; 
			}
		}
		
		
		System.out.println("western for " + romanKingNum + " is "+ western);
		return western;
	}
	
	public String[] getSortedList(String[] kings){
		
		KingSort[] myArray = new KingSort[kings.length];
		
		String currentString; 
		for(int i = 0; i < kings.length; i ++){
			currentString = kings[i];
			String[] s = currentString.split(" ");
			KingSort currentKing = new KingSort(s[0], getKingNum(s[1]));
			myArray[i] = currentKing; 
		}
		
		return null; 
	}
	
	public static void main(String[] args){
		KingSort myK = new KingSort(); 
		String[] kings = {"ABC VI"};
		myK.getSortedList(kings);
	}
}
