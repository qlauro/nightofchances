package sk.qbsw.nightofchances.service;

import sk.qbsw.nightofchances.model.SyncCollection;
import sk.qbsw.nightofchances.model.domain.Registration;

/**
 * The registration service.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public interface RegistrationService
{
	SyncCollection<Registration> getSyncData (Long applicationId);
}
