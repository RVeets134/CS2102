@SuppressWarnings("serial")
class DuplicateVotesException extends Exception {
	private String name;

	public DuplicateVotesException(String name) {
		this.name = name;
	}

	/**
	 * @return the candidate name
	 */
	String getName() {
		return name;
	}
}