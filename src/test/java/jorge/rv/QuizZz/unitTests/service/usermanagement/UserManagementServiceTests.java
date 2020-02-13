package jorge.rv.QuizZz.unitTests.service.usermanagement;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import it.contrader.exceptions.InvalidTokenException;
import it.contrader.model.ForgotPasswordToken;
import it.contrader.model.TokenType;
import it.contrader.model.User;
import it.contrader.service.UserService;
import it.contrader.service.usermanagement.UserManagementService;
import it.contrader.service.usermanagement.UserManagementServiceImpl;
import it.contrader.service.usermanagement.token.TokenDeliverySystem;
import it.contrader.service.usermanagement.token.TokenServiceForgotPassword;

public class UserManagementServiceTests {
	private static final String TOKEN = "token";

	UserManagementService userManagementService;

	// Mocks
	TokenServiceForgotPassword tokenService;
	TokenDeliverySystem tokenDeliverySystem;
	UserService userService;

	// Models
	User user = new User();
	ForgotPasswordToken token = new ForgotPasswordToken();;

	@Before
	public void before() {
		userService = mock(UserService.class);
		tokenService = mock(TokenServiceForgotPassword.class);
		tokenDeliverySystem = mock(TokenDeliverySystem.class);

		userManagementService = new UserManagementServiceImpl(userService, tokenService, tokenDeliverySystem);

		user.setEmail("a@a.com");
		user.setPassword("Password");

	}

	@Test
	public void resendPassword() {

		when(tokenService.generateTokenForUser(user)).thenReturn(token);

		userManagementService.resendPassword(user);

		verify(tokenDeliverySystem, times(1)).sendTokenToUser(token, user, TokenType.FORGOT_PASSWORD);

	}

	@Test(expected = InvalidTokenException.class)
	public void validateInvalidToken() {
		doThrow(new InvalidTokenException()).when(tokenService).validateTokenForUser(user, TOKEN);

		userManagementService.verifyResetPasswordToken(user, TOKEN);
	}

	@Test
	public void validateValidToken() {
		userManagementService.verifyResetPasswordToken(user, TOKEN);

		verify(tokenService, times(1)).validateTokenForUser(user, TOKEN);
	}

	@Test
	public void updatePassword() {
		userManagementService.updatePassword(user, "pass");

		verify(userService, times(1)).updatePassword(user, "pass");
	}
}
