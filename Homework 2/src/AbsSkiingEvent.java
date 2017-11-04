abstract class AbsSkiingEvent implements IEvent {

	double time;
	int position;	// Ranking position
	
	AbsSkiingEvent(double time, int position) {
		this.time = time;
		this.position = position;
	}

	/**
	 * Calculates the amount of points earned from this skiing event.
	 * The amount of points earned is equal to the time by default.
	 */
	@Override
	public double pointsEarned() {
		return time;
	}

}