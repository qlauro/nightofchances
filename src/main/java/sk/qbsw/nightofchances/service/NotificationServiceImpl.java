package sk.qbsw.nightofchances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.qbsw.nightofchances.model.domain.Notification;
import sk.qbsw.nightofchances.model.domain.NotificationState;
import sk.qbsw.nightofchances.model.domain.ValidityState;
import sk.qbsw.nightofchances.repository.NotificationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return notificationRepository.markAllAsDelivered();
	}

	@Override
	public Map<NotificationState, List<Notification>> generateStatisticsGroupedByState (Long applicationId)
	{
		List<Notification> notifications = notificationRepository.findAll();
		Map<NotificationState, List<Notification>> statistics = new HashMap<>();
		statistics.put(NotificationState.NEW, new ArrayList<>());
		statistics.put(NotificationState.SENT, new ArrayList<>());
		statistics.put(NotificationState.DELIVERED, new ArrayList<>());

		for (Notification notification : notifications)
		{
			if (ValidityState.VALID.equals(notification.getMessage().getState()) && notification.getMessage().getApplication().getId().equals(applicationId))
			{
				switch (notification.getState())
				{
					case NEW:
						statistics.get(NotificationState.NEW).add(notification);
						break;
					case SENT:
						statistics.get(NotificationState.SENT).add(notification);
						break;
					case DELIVERED:
						statistics.get(NotificationState.DELIVERED).add(notification);
						break;
				}
			}
		}

		return statistics;
	}
}
