package it.contrader.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.contrader.model.RegistrationToken;

@Repository
public interface RegistrationTokenRepository extends TokenRepository<RegistrationToken> {
	@Modifying
	@Query("delete from RegistrationToken t where t.expirationDate <= ?1")
	void deletePreviousTo(Date date);
}
