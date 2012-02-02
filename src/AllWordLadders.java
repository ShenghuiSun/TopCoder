import java.util.*;

public class AllWordLadders {
      public int[] solve(String[] words,  String from, String to) {
    	  ArrayList<String> wordss = new ArrayList<String>();
    	  for (int i=0;i<words.length;i+=1){
    		  wordss.add(words[i]);
    	  }
    	  if (!wordss.contains(to)){
    		  wordss.add(to);
    	  }    	  
    	  HashMap<String,Integer> wordpaths = new HashMap<String,Integer>();
    	  Queue<String> wordqueue = new LinkedList<String>();
    	  HashMap<String,Integer> minpath = new HashMap<String,Integer>();
    	  wordqueue.add(from);
    	  wordpaths.put(from,1);
    	  minpath.put(from,1);
    	  String current=from;
    	  while (!wordqueue.isEmpty()){
    		  for (String word:wordss){
    			  if (isOneAway(current,word) && (current!=from || word!=to)){
    				  if (!wordpaths.containsKey(word)){
    					  wordpaths.put(word,1);
    					  minpath.put(word,minpath.get(current)+1);
    					  wordqueue.add(word);
    				  } else if (minpath.get(word)==minpath.get(current)+1){
    					  wordpaths.put(word,wordpaths.get(word)+1);
    					  wordqueue.add(word);
    				  } else if (minpath.get(current)+1<minpath.get(word)){
    					  wordpaths.put(word, 1);
    					  minpath.put(word,minpath.get(current)+1);
    					  wordqueue.add(word);
    				  }
    			  }
    		  }
    		  current=wordqueue.poll();
    	  }
    	  int[] finall = new int[2];
    	  if (minpath.containsKey(to)){
    		  finall[0]=minpath.get(to);
    		  finall[1]=wordpaths.get(to)/2;
    		  return finall;
    	  } else {
    		  finall[0]=0;
    		  finall[1]=0;
    		  return finall;
    	  }
      }
      
      public boolean isOneAway(String a, String b){
    	  int diff=0;
    	  for (int i=0;i<a.length();i+=1){
    		  if (a.charAt(i)!=b.charAt(i)){
    			  diff+=1;
    		  }
    	  }
    	  if (diff==1){
    		  return true;
    	  } else {
    		  return false;
    	  }
      }
   }
