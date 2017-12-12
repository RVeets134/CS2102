import java.util.HashMap;
import java.util.LinkedList;

class ElectionData {
	
	// The key set is the ballot, and each linked list contains the number
	// of first, second, and their choice votes for the candidate.
	private HashMap<String, LinkedList<Integer>> votes = new HashMap<>();

	ElectionData() {}

	// Checks if the vote is valid, then adds votes to each candidate respectively.
	// Votes consist of a first, second, and third choice.
	// A valid vote includes on names on the ballot and no duplicates. An invalid
	// vote is discarded.
	public void processVote(String first, String second, String third)
			throws UnknownCandidateException, DuplicateVotesException {
		if (!nameExists(first))
			throw new UnknownCandidateException(first);
		if (!nameExists(second))
			throw new UnknownCandidateException(second);
		if (!nameExists(third))
			throw new UnknownCandidateException(third);
		if (first.equals(second))
			throw new DuplicateVotesException(first);
		if (first.equals(third))
			throw new DuplicateVotesException(first);
		if (second.equals(third))
			throw new DuplicateVotesException(second);
		enterVote(first, 1);
		enterVote(second, 2);
		enterVote(third, 3);
	}

	// enters a single vote into its ballot name. Choice refers to which choice
	// the vote was (first, second or third).
	private void enterVote(String name, int choice) {
		LinkedList<Integer> list = votes.get(name);
		list.set(choice - 1, list.get(choice - 1) + 1);
	}

	// Checks if the candidate is already on the ballot. If not, it is added
	// to the ballot.
	public void addCandidate(String name) throws CandidateExistsException {
		if (nameExists(name))
			throw new CandidateExistsException(name);
		LinkedList<Integer> newCandidateVotes = new LinkedList<>();
		for (int i = 0; i < 3; i++)
			newCandidateVotes.add(0);
		votes.put(name, newCandidateVotes);
	}

	// Checks if a given name is on the ballot
	private boolean nameExists(String name) {
		return votes.containsKey(name);
	}

	// Determines the winner of the election from Most First Votes. A candidate
	// wins the election if they have more than 50% of the votes. If no candidate
	// meets this criteria, a runoff is required.
	public String findWinnerMostFirstVotes() {
		int totalVotes = countTotalFirstVotes();
		for (String name : votes.keySet()) {
			double percentOfVotes = (double) votes.get(name).getFirst() / totalVotes;
			if (percentOfVotes > 0.5)
				return name;
		}
		return "Runoff required";
	}

	// Counts the total number of first votes across all candidates.
	private int countTotalFirstVotes() {
		int total = 0;
		for (String name : votes.keySet())
			total += votes.get(name).getFirst();
		return total;
	}

	// Determines the winner of the election from Most Points.
	// The candidate with the highest score wis the election.
	// If there are ties, the first name in the ballot with the
	// highest score wins.
	public String findWinnerMostPoints() {
		String winner = "";
		int highScore = 0;
		for (String name : votes.keySet()) {
			int score = calculateScore(name);
			if (score > highScore) {
				winner = name;
				highScore = score;
			}
		}
		return winner;
	}

	// Calculates a candidate's score in the election.
	// A candidate's score is determined in the following manner:
	// 	- First choice votes are worth 3 points
	// 	- Second choice votes are worth 2 points
	// 	- Third choice votes are worth 1 point
	private int calculateScore(String name) {
		int score = 0;
		LinkedList<Integer> candidateVotes = votes.get(name);
		score += 3 * candidateVotes.get(0);
		score += 2 * candidateVotes.get(1);
		score += candidateVotes.get(2);
		return score;
	}

	// Returns a copy of the ballot.
	public LinkedList<String> getBallot() {
		LinkedList<String> ballot = new LinkedList<>();
		for (String name : votes.keySet())
			ballot.add(name);
		return ballot;
	}
}