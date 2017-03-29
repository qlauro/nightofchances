package sk.qbsw.nightofchances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.qbsw.nightofchances.model.SyncCollection;
import sk.qbsw.nightofchances.model.domain.Registration;
import sk.qbsw.nightofchances.model.domain.RegistrationState;
import sk.qbsw.nightofchances.repository.RegistrationRepository;

import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * The registration service.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class RegistrationServiceImpl implements RegistrationService
{
	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public SyncCollection<Registration> getSyncData (Long applicationId)
	{
		List<Registration> registrations = registrationRepository.findAll();

		return filterSyncData(registrations, //
			e -> e.getState() == RegistrationState.VALID && e.getApplication().getId().equals(applicationId), //
			e -> (e.getState() == RegistrationState.INVALID || e.getState() == RegistrationState.DUPLICATE) && e.getApplication().getId().equals(applicationId), //
			Comparator.comparing(Registration::getId));
	}

	private SyncCollection<Registration> filterSyncData (List<Registration> registrations, Predicate<Registration> updatedFilter, Predicate<Registration> deletedFilter, Comparator<Registration> sortComparator)
	{
		List<Registration> updated = registrations.stream().filter(updatedFilter).sorted(sortComparator).collect(toList());
		List<Long> deleted = registrations.stream().filter(deletedFilter).sorted(sortComparator).map(Registration::getId).collect(toList());

		OffsetDateTime lastUpdated = registrations.stream().map(Registration::getUpdated).max(OffsetDateTime::compareTo).orElseGet(OffsetDateTime::now);

		return new SyncCollection<>(updated, deleted, lastUpdated);
	}
}
