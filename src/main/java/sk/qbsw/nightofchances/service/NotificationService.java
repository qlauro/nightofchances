package sk.qbsw.nightofchances.service;

import sk.qbsw.nightofchances.model.domain.Notification;
import sk.qbsw.nightofchances.model.domain.NotificationState;

import java.util.List;
import java.util.Map;

/**
 * The notification service.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public interface NotificationService
{
	List<Notification> markAllAsDelivered ();

	Map<NotificationState, List<Notification>> generateStatisticsGroupedByState (Long applicationId);
}
