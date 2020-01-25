package algorithmStudy.week10;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.Stack;

class CostInfo implements Comparable<CostInfo>
{
	int island1;
	int island2;
	int weight;
	
	public CostInfo(int island1, int island2, int weight)
	{
		super();
		this.island1 = island1;
		this.island2 = island2;
		this.weight = weight; 
	}
	
	@Override
	public int compareTo(CostInfo target)
	{
		// 오름차순
		if (this.weight > target.weight) {
			return 1;
		} else if (this.weight < target.weight) {
			return -1;
		}
		return 0;
	}
}

public class IslandConnect {
	public int solution(int n, int[][] costs) {
		int answer = 0;
		PriorityQueue<CostInfo> priorityQueue = new PriorityQueue<CostInfo>();
		int[][] adj = new int[n][n];
		// System.out.println("init Q");
		for(int[] costInfo : costs) {
			// System.out.println(costInfo[0]+", "+costInfo[1]+", "+ costInfo[2]);
			priorityQueue.add(new CostInfo(costInfo[0], costInfo[1], costInfo[2]));
		}
		// System.out.println("done");

//		왜 출력 순서가 다를까?
//		
//		저장 시 head는 최소값(우선순위가 높은 값)을 보장, minheap 방식으로 자료를 저장(완전이진트리)
//		해 놓기 때문에 foreach로 자료에 접근했을때 순서가 달라진다.
//
//		for(CostInfo costInfo : priorityQueue) {
//			System.out.println(costInfo.island1 +", "+costInfo.island2+", "+costInfo.weight);
//		}
//		
//		while(!priorityQueue.isEmpty()) {
//			CostInfo costInfo = priorityQueue.poll();
//			System.out.println(costInfo.island1 +", "+costInfo.island2+", "+costInfo.weight);
//		}
		
		int[] visited = new int[n];
		Arrays.fill(visited, 0);
		// System.out.println(Arrays.toString(visited));
		while(!priorityQueue.isEmpty()) {
			CostInfo costInfo = priorityQueue.poll();
			int island1 = costInfo.island1;
			int island2 = costInfo.island2;
			int weight = costInfo.weight;
			
			System.out.println(island1);
			System.out.println(island2);
			
			adj[island1][island2] = weight;
			
//			if(isNotLoop(adj, island1)) {
			if (visited[island1] > 0 && visited[island2] > 0) {
				continue;
			}
			if(visited[island1] == 0 || visited[island2] == 0) {
				System.out.println("in");
				System.out.println(island1 +", "+island2+", "+weight);
				visited[island1] += 1;
				visited[island2] += 1;
				System.out.println(Arrays.toString(visited));
			
				answer = answer + weight;
			}
			else {
				adj[island1][island2] = 0;
			}
			// System.out.println(IntStream.of(visited).anyMatch(x -> x ==0));
			
			if (!IntStream.of(visited).anyMatch(x -> x == 0)) {
				break;
			}
		}
		System.out.println(answer);
		return answer;
	}
	
	public boolean isNotLoop(int[][] adj, int startNode) {
		
		int nodeSize = adj.length;
		boolean[] visited = new boolean[nodeSize];
		Stack<Integer> stack = new Stack<Integer>();
		visited[startNode] = true;
		stack.add(startNode);
		
    	while(!stack.isEmpty()) {
        	startNode = stack.pop();
        	
        	for(int endNode = 0; endNode < nodeSize; endNode++) {
        		if (startNode == endNode)
        			continue;
        		if(adj[startNode][endNode] > 0) {
        			if (visited[startNode] && visited[endNode])
        			{
        				System.out.println("loop??");
        				System.out.println(startNode);
        				System.out.println(endNode);
        				return false;
        			}	
            		// 방문했으면 다음 노드 체크
            		if (visited[endNode])
            			continue;
            		else {
            			stack.add(endNode);
                		visited[endNode] = true;
            		}
        		}           			
        	}
        }
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IslandConnect agent = new IslandConnect();
		int n = 4;
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		
		agent.solution(n, costs);
	}

}
