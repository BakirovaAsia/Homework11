package controller;

import javax.servlet.http.HttpServletRequest;

import model.Candidate;
import model.Caucus;

public class CaucusUtil {

	public static Caucus getCaucusFromHttpRequest(HttpServletRequest request) {
		int numDelegates = Integer.parseInt(request.getParameter("numDelegates"));
		int numParticipants = Integer.parseInt(request.getParameter("numParticipants"));
		int count = Integer.parseInt(request.getParameter("count"));
		String precinctName = request.getParameter("precinctName");

		Caucus caucus = new Caucus();
		caucus.setName(precinctName);
		caucus.setNumDelegates(numDelegates);
		caucus.setNumParticipants(numParticipants);

		for (int i = 1; i <= count; i++) {
			String name = request.getParameter("candidate_" + Integer.toString(i));
			int votes = Integer.parseInt(request.getParameter("votes_" + Integer.toString(i)));
			Candidate c = new Candidate(name, votes);
			caucus.addCandidate(c);
		}
		caucus.validate();
		caucus.calculateDelegates();
		return caucus;
	}
}
