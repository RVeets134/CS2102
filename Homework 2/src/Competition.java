import java.util.LinkedList;

class Competition {

	LinkedList<Athlete> athletes;
	int numShootingRounds;
	
	Competition(int numShootingRounds, LinkedList<Athlete> athletes) {
		this.athletes = athletes;
		this.numShootingRounds = numShootingRounds;
	}
	
	LinkedList<String> shootingDNF() {
		LinkedList<String> athletesWhoDNF = new LinkedList<>();
		for (Athlete athlete : this.athletes) 
			if (athlete.shooting.rounds.size() < this.numShootingRounds) athletesWhoDNF.add(athlete.name);
		return athletesWhoDNF;
	}
	
	double skiingScoreForAthlete(String name) {
		for (Athlete athlete : this.athletes)
			if (athlete.name.equals(name)) return athlete.skiing.pointsEarned();
		return 0;
	}
	
	boolean anySkiingImprovement(Competition otherComp) {
		for (Athlete athleteThisComp : this.athletes)
			for (Athlete athleteOtherComp : otherComp.athletes)
				if (athleteThisComp.name.equals(athleteOtherComp.name))
					if (athleteThisComp.skiing.pointsEarned() > athleteOtherComp.skiing.pointsEarned())
						return true;
		return false;
		
	}
	
}