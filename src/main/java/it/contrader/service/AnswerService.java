package it.contrader.service;

import java.util.List;

import it.contrader.exceptions.ResourceUnavailableException;
import it.contrader.exceptions.UnauthorizedActionException;
import it.contrader.model.Answer;
import it.contrader.model.Question;

public interface AnswerService {
	Answer save(Answer answer) throws UnauthorizedActionException;

	Answer find(Long id) throws ResourceUnavailableException;

	Answer update(Answer newAnswer) throws UnauthorizedActionException, ResourceUnavailableException;

	void delete(Answer answer) throws UnauthorizedActionException, ResourceUnavailableException;

	List<Answer> findAnswersByQuestion(Question question);

	int countAnswersInQuestion(Question question);
}
