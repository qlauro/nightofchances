package sk.qbsw.nightofchances.repository;

import sk.qbsw.nightofchances.model.domain.Notification;

import java.util.List;
import java.util.function.Consumer;

/**
 * The notification repository.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public interface NotificationRepository
{
	List<Notification> markAllAs (Consumer<Notification> behavior);

	void markAsSent (Notification notification);

	void markAsDelivered (Notification notification);

	List<Notification> findAll ();
}
