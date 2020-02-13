package it.contrader.service.accesscontrol;

import org.springframework.stereotype.Service;

import it.contrader.model.Question;

@Service
public class AccessControlServiceQuestion extends AccessControlServiceUserOwned<Question> {

}
