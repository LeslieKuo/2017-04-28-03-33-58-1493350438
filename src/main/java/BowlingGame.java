public class BowlingGame {

    public int getBowlingScore(String str) {
		//String str = bowlingCode;		
		int grades = 0;
		int round = 0;
		int j=0;
		int[] roundgrades = new int[12];// every round grades record
		for (int i = 0; i < str.length(); i++) {

			Character status = str.charAt(i);
			Character status2;
			Character status3;
			System.out.println(status);

			if (status.equals('|')) {
				round = round + 1;
				if(round == 11)
					break;
				System.out.println("roundnum= " + round);
				System.out.println("score[" + (round-1)+"]="+roundgrades[round-1]);
			}
			if (roundgrades[round] == 0) {
				if (status.equals('X')) // if first result is X; then we need 2
										// more scores
				{
					roundgrades[round] += 10;
					j = i+2;
					status2 = str.charAt(j);// Second Score except'|'
					if (status2.equals('|')) {
						status2 = str.charAt(++j);
					}
					if (status2.equals('X'))// ####if second is X
					{
						roundgrades[round] += 10;
						status3 = str.charAt(i + 4);// Third Score except"|"
						if (status3.equals('|')) {
							status3 = str.charAt(i + 5);
						}
						if (status3.equals('X')) {
							roundgrades[round] = roundgrades[round] + 10;
						}
						if (Character.isDigit(status3)) {
							roundgrades[round] = roundgrades[round] + Character.getNumericValue((int) status3);
						}

					}
					

					if (Character.isDigit(status2))// ####if second is number
					{
						status3 = str.charAt(++j);
						if (status3.equals('|')) {
							status3 = str.charAt(++j);
						}
						if (status3.equals('/')) {
							roundgrades[round] = roundgrades[round] + 10;
						} else if (Character.isDigit(status3)) {
							roundgrades[round] = roundgrades[round] + Character.getNumericValue((int) status3)
									+ Character.getNumericValue((int) status2);
						}
					}

					if (status2.equals('-')) // ####if second is --
					{
						status3 = str.charAt(++j);
						if (status3.equals('|')) {
							status3 = str.charAt(++j);
						}
						if (status3.equals('/')) {
							roundgrades[round] = roundgrades[round] + 10;
						} else if (Character.isDigit(status3)) {
							roundgrades[round] = roundgrades[round] + Character.getNumericValue((int) status3);
						}
					}

					System.out.println("roundgrade[round]= " + roundgrades[round]);
				}

				// if first result is number; then
			    // we need 1 more scores
				if (Character.isDigit(status))
				{
					status2 = str.charAt(i + 1);// Second ball
					if (status2.equals('|')) {
						status2 = str.charAt(i + 2);
					}
					if (status2.equals('/'))// need to see next score
					{
						roundgrades[round] = roundgrades[round] + 10;
						status3 = str.charAt(i + 3);// except"|"
						if (status3.equals('|')) {
							status3 = str.charAt(i + 4);
						}
						if (status3.equals('X')) {
							roundgrades[round] = roundgrades[round] + 10;
						}
						if (Character.isDigit(status3)) {
							roundgrades[round] = roundgrades[round] + Character.getNumericValue((int) status3);
						}
					} 
					
					else if (Character.isDigit(status2)) 
					{
						roundgrades[round] = roundgrades[round] + Character.getNumericValue((int) status)
								+ Character.getNumericValue((int) status2);
					}
					else if(status2.equals('-'))
					{
						roundgrades[round] = roundgrades[round] + Character.getNumericValue((int) status);
					}
					
				}

				if (status.equals('-')) {

					status2 = str.charAt(i + 1);// Second ball
					if (status2.equals('|')) {
						status2 = str.charAt(i + 2);
					}
					if (status2.equals('/'))// need to see next score
					{
						roundgrades[round] = roundgrades[round] + 10;
						status3 = str.charAt(i + 3);// except"|"
						if (status3.equals('|')) {
							status3 = str.charAt(i + 4);
						}
						if (status3.equals('X')) {
							roundgrades[round] = roundgrades[round] + 10;
						}
						if (Character.isDigit(status3)) {
							roundgrades[round] = roundgrades[round] + Character.getNumericValue((int) status3);
						}
					} else if (Character.isDigit(status2)) {
						roundgrades[round] = roundgrades[round]+ Character.getNumericValue((int) status2);
					}
				}
			}

		} // for end

		for (int i = 0; i < 10; i++) {
			grades = grades + roundgrades[i];
		}
		
        	return grades;
    }
}
