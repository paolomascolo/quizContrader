package it.contrader.service.accesscontrol;

import org.springframework.stereotype.Service;

import it.contrader.exceptions.UnauthorizedActionException;
import it.contrader.model.AuthenticatedUser;
import it.contrader.model.User;

@Service
public class AccessControlServiceUser extends AccessControlServiceUserOwned<User> {

	/*
	 * Anyone can create a new user, including non authenticated.
	 */

	@Override
	public void canUserCreateObject(AuthenticatedUser user, User object) throws UnauthorizedActionException {

	}

	/*
	 * Unauthenticated users will have to modify users that have not gone
	 * through full registration yet. This is secured through tokens.
	 */

	@Override
	public void canUserUpdateObject(AuthenticatedUser user, User object) throws UnauthorizedActionException {
		if (user == null) {
			return;
		}

		super.canUserUpdateObject(user, object);
	}
}
