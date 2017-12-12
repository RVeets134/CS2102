
class Reading {

	private Time time;
	private int temp;
	
	Reading(Time time, int temp) {
		this.time = time;
		this.temp = temp;
	}

	/**
	 * @return the time
	 */
	Time getTime() {
		return time;
	}

	/**
	 * @return the temp
	 */
	int getTemp() {
		return temp;
	}
	
}