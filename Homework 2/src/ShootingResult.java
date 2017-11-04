import java.util.LinkedList;

class ShootingResult implements IEvent{
	
	LinkedList<ShootingRound> rounds;
	
	ShootingResult(ShootingRound one, ShootingRound two, ShootingRound three, ShootingRound four){
		this.rounds = new LinkedList<>();
		this.rounds.add(one);
		this.rounds.add(two);
		this.rounds.add(three);
		this.rounds.add(four);
	}
	
	ShootingResult(LinkedList<ShootingRound> rounds) {
		this.rounds = rounds;
	}

	/**
	 * Calculates the total amount of points from all shooting rounds.
	 */
	@Override
	public double pointsEarned() {
		int total = 0;
		for (ShootingRound round : this.rounds) total += round.targetsHit;
		return total;
	}
	
	/**
	 * Calculates the best round out of this shooting result.
	 */
	ShootingRound bestRound() {
		ShootingRound currentBestRound = new ShootingRound(0);
		for (ShootingRound round : this.rounds)
			if (round.targetsHit > currentBestRound.targetsHit) currentBestRound = round;
		return currentBestRound;
	}
	
}