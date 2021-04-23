package TestCaucus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Candidate;
import model.Caucus;

public class testCaucus {
	Caucus c;

	@Before
	public void setUp() throws Exception {
		c = new Caucus();

	}

	@Test
	public void testCalcViabilityThreshold() {
		c.setNumParticipants(47);
		c.setNumDelegates(8);
		int viability = c.getViabilityThreshold();
		assertEquals(8, viability);
	}

	@Test
	public void testIsNotValidIfMoreVotesThanParticipants() {
		c.setNumParticipants(1);
		c.setIsValid(true);
		c.addCandidate(new Candidate("A", 2));
		assertFalse(c.getIsValid());
		assertNotEquals("", c.getErrors());
	}

	@Test
	public void testIsNotValidIfCandidateDoesntMeetThreshold() {
		c.setNumParticipants(47);
		c.setNumDelegates(8);
		c.setIsValid(true);
		c.addCandidate(new Candidate("A", 2));
		assertFalse(c.getIsValid());
		assertNotEquals("", c.getErrors());
	}

	@Test
	public void testDelegateCalc() {
		c.setNumDelegates(8);
		c.setNumParticipants(47);

		Candidate x = new Candidate("X", 18);
		Candidate y = new Candidate("Y", 17);
		Candidate z = new Candidate("Z", 12);

		c.addCandidate(x);
		c.addCandidate(y);
		c.addCandidate(z);

		c.calculateDelegates();

		assertEquals(3, c.getCandidates().get(0).getDelegates());
		assertEquals(3, c.getCandidates().get(1).getDelegates());
		assertEquals(2, c.getCandidates().get(2).getDelegates());
	}
}
