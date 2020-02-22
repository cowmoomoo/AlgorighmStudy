package algorithmStudy.week14;

public class DartGame {
	public int solution(String dartResult) {
		int answer = 0;

		int currentScore = 0;
		int preScore = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			int currentCh = (int) dartResult.charAt(i);

			if (('0' <= currentCh) && (currentCh <= '9')) {

				if ((currentCh == '0') && (i != 0) && (dartResult.charAt(i - 1) == '1')) {
					currentScore = 10;
				} else {

					preScore = currentScore;
					answer += preScore;
					currentScore = currentCh % 48;
				}

			} else if (currentCh == 'S') {
				currentScore = (int) Math.pow(currentScore, 1);
			} else if (currentCh == 'D') {
				currentScore = (int) Math.pow(currentScore, 2);
			} else if (currentCh == 'T') {
				currentScore = (int) Math.pow(currentScore, 3);

			} else if (currentCh == '*') {
				currentScore = currentScore * 2;
				answer += preScore;
			} else if (currentCh == '#') {
				currentScore = (-1) * currentScore;
			}

			if (i == (dartResult.length() - 1))
				answer += currentScore;
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DartGame agent = new DartGame();
		String dartResult = "1S2D*3T";
		System.out.println("expected answer : 37");
		agent.solution(dartResult);
	}
}