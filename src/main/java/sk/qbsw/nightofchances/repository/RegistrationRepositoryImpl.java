package sk.qbsw.nightofchances.repository;

import org.springframework.stereotype.Repository;
import sk.qbsw.nightofchances.dataprovider.RegistrationDataProvider;
import sk.qbsw.nightofchances.model.domain.Registration;

import java.util.List;

/**
 * The registration repository implementation.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository
{
	@Override
	public List<Registration> findAll ()
	{
		return RegistrationDataProvider.findAll();
	}
}
