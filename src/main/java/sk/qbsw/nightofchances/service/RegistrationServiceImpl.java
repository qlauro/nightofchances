package sk.qbsw.nightofchances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.qbsw.nightofchances.model.SyncCollection;
import sk.qbsw.nightofchances.model.domain.Registration;
import sk.qbsw.nightofchances.model.domain.RegistrationState;
import sk.qbsw.nightofchances.repository.RegistrationRepository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

		return filterSyncData(registrations, applicationId);
	}

	private SyncCollection<Registration> filterSyncData (List<Registration> registrations, Long applicationId)
	{
		return new SyncCollection<>(extractUpdated(registrations, applicationId), extractDeleted(registrations, applicationId), extractLastUpdated(registrations, applicationId));
	}

	private List<Registration> extractUpdated (List<Registration> registrations, Long applicationId)
	{
		Collections.sort(registrations, getRegistrationIdComparator());

		List<Registration> updated = new ArrayList<>();
		for (Registration registration : registrations)
		{
			if (RegistrationState.VALID.equals(registration.getState()) && registration.getApplication().getId().equals(applicationId))
			{
				updated.add(registration);
			}
		}

		return updated;
	}

	private List<Long> extractDeleted (List<Registration> registrations, Long applicationId)
	{
		Collections.sort(registrations, getRegistrationIdComparator());

		List<Long> deleted = new ArrayList<>();
		for (Registration registration : registrations)
		{
			if ( (RegistrationState.INVALID.equals(registration.getState()) || RegistrationState.DUPLICATE.equals(registration.getState())) && registration.getApplication().getId().equals(applicationId))
			{
				deleted.add(registration.getId());
			}
		}

		return deleted;
	}

	private OffsetDateTime extractLastUpdated (List<Registration> registrations, Long applicationId)
	{
		OffsetDateTime lastUpdated = null;
		for (Registration registration : registrations)
		{
			if (registration.getApplication().getId().equals(applicationId))
			{
				if (lastUpdated == null)
				{
					lastUpdated = registration.getUpdated();
				}
				else
				{
					if (registration.getUpdated().isAfter(lastUpdated))
					{
						lastUpdated = registration.getUpdated();
					}
				}
			}
		}

		if (lastUpdated == null)
		{
			return OffsetDateTime.now();
		}
		else
		{
			return lastUpdated;
		}
	}

	private Comparator<Registration> getRegistrationIdComparator ()
	{
		return new Comparator<Registration>()
		{
			@Override
			public int compare (Registration o1, Registration o2)
			{
				return o1.getId().compareTo(o2.getId());
			}
		};
	}
}
