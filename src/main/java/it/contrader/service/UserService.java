package it.contrader.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import it.contrader.exceptions.ResourceUnavailableException;
import it.contrader.exceptions.UnauthorizedActionException;
import it.contrader.exceptions.UserAlreadyExistsException;
import it.contrader.model.User;

public interface UserService extends UserDetailsService {
	User saveUser(User user) throws UserAlreadyExistsException;

	User find(Long id) throws ResourceUnavailableException;;

	User findByEmail(String email) throws ResourceUnavailableException;

	User findByUsername(String username) throws ResourceUnavailableException;

	User updatePassword(User user, String password) throws ResourceUnavailableException;

	void delete(Long user_id) throws UnauthorizedActionException, ResourceUnavailableException;

	User setRegistrationCompleted(User user) throws ResourceUnavailableException;

	boolean isRegistrationCompleted(User user) throws ResourceUnavailableException;

}