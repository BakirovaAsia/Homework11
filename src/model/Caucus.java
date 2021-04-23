package model;

import java.util.ArrayList;
import java.util.List;

public class Caucus {
	private List<Candidate> candidates = new ArrayList<>();
	private String errors;
	private boolean isValid;
	private int numDelegates;
	private int numParticipants;
	private int viabilityThreshold;
	private String precinctName;
	
	public Caucus() {
		this.candidates = new ArrayList<>();
		this.numParticipants = 0;
		this.isValid = false;
		this.viabilityThreshold = 0;
		this.errors = "";
	}

	public void addCandidate(Candidate c) {
		this.candidates.add(c);
	}

	public void calculateDelegates() {
		int delegates;
		if (this.getIsValid()) {
			for (Candidate c : this.getCandidates()) {
				double calc = (double) ((c.getVotes() * this.getNumDelegates()) / (double) this.getNumParticipants());
				delegates = (int) Math.round(calc);
				c.setDelegates(delegates);
			}
		}
	}

	private void calcViabilityThreshold() {
		double num;
		switch (this.numDelegates) {
		case 1:
			num = this.numParticipants;
		case 2:
			num = (0.25 * this.numParticipants);
		case 3:
			num = this.numParticipants / 6;
		default:
			num = (this.numParticipants * .15);
		}
		this.viabilityThreshold = (int) Math.ceil(num);
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public String getErrors() {
		return errors;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public int getNumDelegates() {
		return numDelegates;
	}

	public int getNumParticipants() {
		return numParticipants;
	}

	public int getViabilityThreshold() {
		return viabilityThreshold;
	}

	public void validate() {
		this.setIsValid(validateParticipants() && validateAllAreViable());
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public void setNumDelegates(int numDelegates) {
		this.numDelegates = numDelegates;
		this.calcViabilityThreshold();
	}

	public void setNumParticipants(int numParticipants) {
		this.numParticipants = numParticipants;
		this.calcViabilityThreshold();
	}

	private boolean validateAllAreViable() {
		for (Candidate c : this.getCandidates()) {
			if (c.getVotes() < this.getViabilityThreshold()) {
				setErrors(getErrors() + "ERROR: " + c.getName() + " IS NOT VIABLE\n");
				return false;
			}
		}
		return true;
	}

	private boolean validateParticipants() {
		int sum = 0;
		for (Candidate c : this.candidates) {
			sum += c.getVotes();
		}
		if (sum > this.getNumParticipants()) {
			this.setErrors(this.getErrors() + "ERROR: SUM OF CANDIDATE VOTES GREATER THAN NUMBER OF PARTICIPANTS\n");
			return false;
		}
		return true;
	}

	public String getName() {
		return precinctName;
	}

	public void setName(String name) {
		this.precinctName = name;
	}
}
