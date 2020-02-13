package it.contrader.service.usermanagement.token;

import java.util.Date;

import it.contrader.exceptions.InvalidTokenException;
import it.contrader.model.TokenModel;
import it.contrader.model.User;

public interface TokenService<T extends TokenModel> {
	T generateTokenForUser(User user);

	void validateTokenForUser(User user, String token) throws InvalidTokenException;

	void invalidateToken(String token);

	void invalidateExpiredTokensPreviousTo(Date date);
}
