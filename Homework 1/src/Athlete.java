
class Athlete {
	
	ShootingResult shooting;
	SkiingResult skiing;
	
	Athlete(ShootingResult shooting,SkiingResult skiing){
		this.shooting = shooting;
		this.skiing = skiing;
	}
	
	/**
	 * Determines the better of two skiiers
	 * @param other - Athlete being compared to the activating athlete
	 */
	Athlete betterSkiier(Athlete other) {
		if(this.skiing.pointsEarned() < other.skiing.pointsEarned()) {
			return this;
		} 
		else {
			return other;
		}
	}
	
	/**
	 * Determines whether an athlete has beaten another
	 * @param other - Athlete being compared to the activating athlete
	 */
	boolean hasBeaten(Athlete other) {
		return (this.shooting.pointsEarned() > other.shooting.pointsEarned()) || 
				(this.skiing.pointsEarned() < other.skiing.pointsEarned());
	}
	
}