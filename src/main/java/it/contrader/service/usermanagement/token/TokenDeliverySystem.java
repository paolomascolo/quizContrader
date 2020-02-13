package it.contrader.service.usermanagement.token;

import org.springframework.scheduling.annotation.Async;

import it.contrader.model.TokenModel;
import it.contrader.model.TokenType;
import it.contrader.model.User;

public interface TokenDeliverySystem {
	@Async
	void sendTokenToUser(TokenModel token, User user, TokenType tokenType);
}
