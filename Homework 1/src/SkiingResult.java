
class SkiingResult implements IEvent{
	
	double time;
	int position;	// Ranking position
	ShootingResult shooting;
	
	SkiingResult(double time,int position,ShootingResult shooting){
		this.time = time;
		this.position = position;
		this.shooting = shooting;
	}
	
	/**
	 * Calculates the amount of points earned from this skiing result.
	 * The amount of points earned depends on the points earned by the
	 * shooting rounds, the skiing time, and ranking position.
	 */
	public double pointsEarned() {
		if(position == 1) {			// First place loses 10 pts.
			return addShootingPenalties(this.shooting) - 10;
		}
		else if(position == 2) {	// Second place loses 7 pts.
			return addShootingPenalties(this.shooting) - 7;
		}
		else if(position == 3) {	// Third place loses 3 pts.
			return addShootingPenalties(this.shooting) - 3;
		}
		else {						// Other places do not lose points
			return addShootingPenalties(this.shooting);
		}
	}
	
	/**
	 * Modifies the skiing time based on shooting penalties. Each target miss
	 * adds 20 seconds to the skiing time.
	 * @param result - the ShootingResult used to modify the skiing time
	 */
	double addShootingPenalties(ShootingResult result) {
		return ((20-result.pointsEarned())*20) + this.time;
	}

}
