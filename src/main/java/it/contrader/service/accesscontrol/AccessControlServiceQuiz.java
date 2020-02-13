package it.contrader.service.accesscontrol;

import org.springframework.stereotype.Service;

import it.contrader.exceptions.UnauthorizedActionException;
import it.contrader.model.AuthenticatedUser;
import it.contrader.model.Quiz;

@Service("AccessControlQuiz")
public class AccessControlServiceQuiz extends AccessControlServiceUserOwned<Quiz> {

	/*
	 * As long as the user is authenticated, it can create a Quiz.
	 */
	@Override
	public void canUserCreateObject(AuthenticatedUser user, Quiz object) throws UnauthorizedActionException {
		if (user == null) {
			throw new UnauthorizedActionException();
		}
	}

}
