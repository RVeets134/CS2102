
class ShootingResult implements IEvent{
	
	ShootingRound round1;
	ShootingRound round2;
	ShootingRound round3;
	ShootingRound round4;
	
	ShootingResult(ShootingRound one,ShootingRound two,ShootingRound three,ShootingRound four){
		this.round1 = one;
		this.round2 = two;
		this.round3 = three;
		this.round4 = four;
	}
	
	/**
	 * Calculates the total amount of points from all shooting rounds.
	 */
	public double pointsEarned() {
		return this.round1.targetsHit + this.round2.targetsHit + this.round3.targetsHit + this.round4.targetsHit;
	}
	
}
