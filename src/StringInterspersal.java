
public class StringInterspersal {
	
	public String minimum(String[] W){
		
		StringBuilder myBuilder = new StringBuilder(); 
		String[] wDuplicate = W; 
		char temp = 100; 
		char startAt = 100; 
		int index = 0; 
		
		while(whileTrue(wDuplicate)){

			int j = 0;
			startAt = 400;
			temp = 400;
			while(j < wDuplicate.length){
				if(wDuplicate[j].length() > 0) {temp = wDuplicate[j].charAt(0);}	
				else{temp = 400;}
				
				if(startAt > temp)
				{
					startAt = temp; 
					index = j;
				}
				j++;
			}
			wDuplicate[index] = wDuplicate[index].substring(1); 

			myBuilder.append(startAt);
		}
		
		return myBuilder.toString(); 
	}

	public boolean whileTrue(String[] wDup){
		for(int i = 0; i < wDup.length; i ++){
			if(wDup[i].length() > 0){
				return true; 
			}
		}
		return false; 
	}
	
	
	
	public static void main(String[] args){
		StringInterspersal myS = new StringInterspersal();
		String[] array = {"DESIGN","ALGORITHM","MARATHON"};
		
		System.out.println(myS.minimum(array));
		System.out.println("ADELGMAORARISIGNTHMTHON");
	}
}
