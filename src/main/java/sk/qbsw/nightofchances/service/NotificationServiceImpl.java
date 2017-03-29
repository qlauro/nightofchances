package sk.qbsw.nightofchances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.qbsw.nightofchances.model.domain.Notification;
import sk.qbsw.nightofchances.model.domain.NotificationState;
import sk.qbsw.nightofchances.model.domain.ValidityState;
import sk.qbsw.nightofchances.repository.NotificationRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The notification service.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class NotificationServiceImpl implements NotificationService
{
	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public List<Notification> markAllAsDelivered ()
	{
		return notificationRepository.markAllAs(notificationRepository::markAsDelivered);
	}

	@Override
	public Map<NotificationState, List<Notification>> generateStatisticsGroupedByState (Long applicationId)
	{
		List<Notification> notifications = notificationRepository.findAll();

		return notifications.stream().filter(notification -> {
			if (ValidityState.VALID.equals(notification.getMessage().getState()))
			{
				return notification.getMessage().getApplication().getId().equals(applicationId);
			}
			return false;
		}) //
			.collect(Collectors.groupingBy(notification -> notification.getState()));
		// .collect(Collectors.groupingBy(notification -> notification.getState(), counting()));
	}
}
