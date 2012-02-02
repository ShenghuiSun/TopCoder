
public class PairingPawns {

	public int savedPawnCount(int[] start){
		
		int numCells = start.length; 
		
		for(int i = numCells-1; i > 0; i --){

			while(start[i] > 0 && (start[i]-2>=0)){
				start[i] = start[i]-2; 
				start[i-1] = start[i-1] + 1; 
			}
			
		}
		return start[0]; 
	}

}
