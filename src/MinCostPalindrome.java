
public class MinCostPalindrome {
	
	public int getMinimum(String s, int oCost, int xCost){
		
		int totalCost = 0; 
		
		int minCost; 
		if(oCost > xCost){ 
			minCost = xCost; 
		}
		else {
			minCost = oCost; 
		}
		
		for(int i = 0; i < s.length()/2; i ++){
			char head = s.charAt(i);
			char tail = s.charAt(s.length()-1-i); 

				if(head == '?' && tail == '?'){
					totalCost = totalCost + minCost*2; 
				}
				else if(head == '?' && tail != '?' ){
					if(tail == 'o'){ totalCost = totalCost + oCost;}
					else{ totalCost = totalCost + xCost;}
				}
				else if(head != '?' && tail == '?' ){
					if(head == 'o'){ totalCost = totalCost + oCost;}
					else{ totalCost = totalCost + xCost;}
				}
				else if(head != tail && head != '?' && tail != '?'){
					return -1; 
				}
		
		}
		
		return totalCost; 
	}
	
	public static void main(String[] args){
		MinCostPalindrome myM = new MinCostPalindrome(); 
		String s = "????????????????????";
		int oCost = 50; 
		int xCost = 49; 
		int num = myM.getMinimum(s, oCost, xCost);
		System.out.println(num);
	}
}
