package sk.qbsw.nightofchances.repository;

import sk.qbsw.nightofchances.model.domain.Notification;

import java.util.List;

/**
 * The notification repository.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public interface NotificationRepository
{
	List<Notification> markAllAsDelivered ();

	List<Notification> findAll ();
}
