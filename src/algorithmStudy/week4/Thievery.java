package algorithmStudy.week4;

import java.util.HashMap;

public class Thievery {
	
	//인터넷 풀이
	public int solution1(int[] money) {
        int answer = 0;
        int length = money.length;
        int[] dp =new int[length-1];
        int[] dp2= new int[length];
        
        dp[0]=money[0];
        dp[1]=money[0];
        dp2[0]=0;
        dp2[1]=money[1];
        for(int i=2;i<length-1;i++){
            dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);
        }
        for(int i=2;i<length;i++){
            dp2[i]=Math.max(dp2[i-2]+money[i],dp2[i-1]);
        }
        answer = Math.max(dp[length-2],dp2[length-1]);
        System.out.println(answer);
        return answer;
    }
	public int solution(int[] money) {
		int answer = 1;
		HashMap<Integer, Integer> mem1 = new HashMap<>();
		HashMap<Integer, Integer> mem2 = new HashMap<>();
		
		mem1.put(0, money[0]);
		mem1.put(1,  )
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thievery thieveryAgent = new Thievery();
		int [] money = {1, 2, 3, 1};
		thieveryAgent.solution(money);
	}

}
