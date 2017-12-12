@SuppressWarnings("serial")
class UnknownCandidateException extends Exception {
	private String name;

	public UnknownCandidateException(String name) {
		this.name = name;
	}

	/**
	 * @return the candidate name
	 */
	String getName() {
		return name;
	}
}