import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class SpreadingNews {
	
	private boolean read; 
	private int value; 
	private List<SpreadingNews> children = new ArrayList<SpreadingNews>(); 
	private int maxChildren = 0; 
	
	public SpreadingNews(){
		
	}
	
	public SpreadingNews(int num){
		this.value = num; 
	}
	
	public void addChildren(SpreadingNews child){
		this.children.add(child); 
	}
	
	public int getValue(){
		return this.value; 
	}
	
	public void printChildren(){
		System.out.println("parent: " + this.getValue());
		System.out.print("children: ");
		for(SpreadingNews d: this.children){
			System.out.print(d.getValue() + " ");
		}
		System.out.println();
	}
	
	public int getNumChildren(){
		return this.children.size(); 
	}
	
	public int BFS(SpreadingNews head){
		List<SpreadingNews> q = new LinkedList<SpreadingNews>(); 
		HashSet<SpreadingNews> discovered = new HashSet<SpreadingNews>(); 
		q.add(head); 
		discovered.add(head);
		int level = 0; 
		while(!q.isEmpty()){
			SpreadingNews current = q.remove(0); 
			
			if(current.getNumChildren() > 0){
				for(int i = 0; i < current.getNumChildren(); i ++){
		
						SpreadingNews currentChild = current.children.get(i);
					
						if(discovered.contains(currentChild)) 
							continue; 
						
							q.add(currentChild);
							discovered.add(currentChild);
			}
			
				level ++; 
			}
		}
			
		return level; 
	} 
	
	public int minTime(int[] supervisors){
		SpreadingNews[] array = new SpreadingNews[supervisors.length];
		
		for(int i = 0; i < supervisors.length; i ++){
			SpreadingNews node = new SpreadingNews(i);
			array[i] = node; 
		} 
		
		for(int j = 1; j < array.length; j ++){
			int num = supervisors[j]; 
			array[num].addChildren(array[j]);
		}
		
		
		for(int j = 0; j < array.length; j ++){
			if(array[j].getNumChildren() > maxChildren){
				maxChildren = array[j].getNumChildren(); 
			}
		}
		int numlevels = BFS(array[0]);
		return Math.max(numlevels, maxChildren); 
	}
}
