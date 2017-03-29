package sk.qbsw.nightofchances.repository;

import sk.qbsw.nightofchances.model.domain.Registration;

import java.util.List;

/**
 * The registration repository.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public interface RegistrationRepository
{
	List<Registration> findAll ();
}
