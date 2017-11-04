class Athlete {
	
	ShootingResult shooting;
	SkiingResult skiing;
	String name;
	
	Athlete(ShootingResult shooting,SkiingResult skiing, String name){
		this.shooting = shooting;
		this.skiing = skiing;
		this.name = name;
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