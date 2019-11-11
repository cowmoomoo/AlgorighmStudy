package algorithm.study;

import java.util.Arrays;
import java.lang.Math;

public class DartGame {
	public int solution(String dartResult) {
	      int answer = 0;
	      int score = 0;
	      
	      String[] bonus = {"S", "D", "T"};
	      String[] Option = {"*", "#"};
	      int idx = 0;
	      // int opCount = 3;
	      
	      String[] ch = dartResult.split("");
	      int currentScore = 0;
	      int preScore = 0;
	      
	      boolean numFlag = true;
	      boolean bonusFlag = false;
	      boolean opFlag = false;
	      
	      while(true)
	      {
	    	  System.out.println(idx);
	    	  System.out.println(numFlag);
	    	  System.out.println(bonusFlag);
	    	  System.out.println(opFlag);
	    	  
	    	  if(idx == dartResult.length())
	    		  break; 
	    	  if(numFlag)
	    	  {
	    		  System.out.println("number");
	    		  currentScore = Integer.parseInt(ch[idx]);
	    		  numFlag = false;
	    		  bonusFlag = true;
	    	  }
	    	  
	    	  if(bonusFlag)
	    	  {
	    		  System.out.println("bonus");
	    		  if (ch[idx] == "S")
	    			  currentScore = Integer.parseInt(ch[idx]);
	    		  if (ch[idx] == "D")
	    			  currentScore = (int) Math.pow(currentScore, 2);
	    		  if (ch[idx] == "T")
	    			  currentScore = (int) Math.pow(currentScore, 3);
	    		  if (idx != (dartResult.length()-1) && Arrays.asList(Option).contains(ch[idx+1]))
	    			  opFlag = true;
	    		  else
	    		  {
	    			  preScore = currentScore;
	    			  numFlag = true;
	    			  opFlag = false;
	    		  }
	    		  bonusFlag = false;
	    	  }
	    	  
	    	  if(opFlag)
	    	  {
	    		  System.out.println("op");
	    		  if (ch[idx] == "*")
	    		  {
	    			  currentScore = currentScore * 2;
	    			  if(idx >= 3)
	    			  {
	    				  score -= preScore;
	    			  	  preScore = preScore*2;
	    			  }
	    		  }
	    		  if (ch[idx] == "#")
	    			  currentScore = -1 * currentScore;
	    		  preScore = currentScore;
	    		  opFlag = false;
	    		  numFlag = true;
	    	  }
	    	  score += preScore;
	    	  idx += 1;
	      }
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dartResult = "1S2D*3T";
		DartGame dart = new DartGame();
		dart.solution(dartResult);
	}

}
