import java.util.LinkedList;
import java.util.Scanner;

class VotingMachine {
	private Scanner keyboard = new Scanner(System.in);
	private ElectionData votes = new ElectionData();
	
	VotingMachine() {}
	
	// prints all names in the ballot
	public void printBallot() {
		System.out.println("The candidates are:");
		LinkedList<String> ballot = votes.getBallot();
		if (ballot.size() == 0) System.out.println("[none]");
		else for (String name : ballot) System.out.println(name);
	}

	// Asks the user to cast a vote
	public void screen() throws UnknownCandidateException, DuplicateVotesException {
		this.printBallot();
		System.out.println("Who is your first choice?");
		String first = keyboard.next();
		System.out.println("Who is your second choice?");
		String second = keyboard.next();
		System.out.println("Who is your third choice?");
		String third = keyboard.next();
		votes.processVote(first, second, third);
		System.out.println("You voted for " + first + " first choice.");
		System.out.println("You voted for " + second + " second choice.");
		System.out.println("You voted for " + third + " third choice.");
	}
	
	// adds a candidate to the ballot
	public void addCandidate() throws CandidateExistsException {
		this.printBallot();
		System.out.println("Who would you like to add?");
		String name = keyboard.next();
		votes.addCandidate(name);
		System.out.println("Added " + name + " to the ballot.");
	}
}