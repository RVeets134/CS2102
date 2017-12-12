@SuppressWarnings("serial")
class CandidateExistsException extends Exception {
	private String name;
	
	public CandidateExistsException(String name) {
		this.name = name;
	}

	/**
	 * @return the candidate name
	 */
	String getName() {
		return name;
	}
}