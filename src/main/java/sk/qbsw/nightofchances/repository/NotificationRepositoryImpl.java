package sk.qbsw.nightofchances.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import sk.qbsw.nightofchances.dataprovider.NotificationDataProvider;
import sk.qbsw.nightofchances.model.domain.Notification;
import sk.qbsw.nightofchances.model.domain.NotificationState;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.function.Consumer;

/**
 * The notification repository implementation.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class NotificationRepositoryImpl implements NotificationRepository
{
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationRepositoryImpl.class);

	@Override
	public List<Notification> markAllAs (Consumer<Notification> behavior)
	{
		List<Notification> notifications = NotificationDataProvider.findAll();

		notifications.stream().forEach(behavior);

		return notifications;
	}

	@Override
	public void markAsSent (Notification notification)
	{
		if (NotificationState.NEW.equals(notification.getState()))
		{
			notification.setDelivered(OffsetDateTime.now());
			notification.setState(NotificationState.SENT);
			LOGGER.debug("The notification with id {} was set as {}", notification.getId(), NotificationState.SENT);
		}
	}

	@Override
	public void markAsDelivered (Notification notification)
	{
		if (NotificationState.SENT.equals(notification.getState()))
		{
			notification.setDelivered(OffsetDateTime.now());
			notification.setState(NotificationState.DELIVERED);
			LOGGER.debug("The notification with id {} was set as {}", notification.getId(), NotificationState.DELIVERED);
		}
	}

	@Override
	public List<Notification> findAll ()
	{
		return NotificationDataProvider.findAll();
	}
}
