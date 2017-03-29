package sk.qbsw.nightofchances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sk.qbsw.nightofchances.configuration.PathConfiguration;
import sk.qbsw.nightofchances.model.domain.Notification;
import sk.qbsw.nightofchances.model.domain.NotificationState;
import sk.qbsw.nightofchances.service.NotificationService;

import java.util.List;
import java.util.Map;

/**
 * The notification controller.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping (PathConfiguration.NOTIFICATIONS_ROOT_PATH)
public class NotificationController
{
	@Autowired
	private NotificationService notificationService;

	@RequestMapping (PathConfiguration.NOTIFICATIONS_MARK_AS_DELIVERED_PATH)
	@ResponseBody
	public List<Notification> markAsDelivered ()
	{
		return notificationService.markAllAsDelivered();
	}

	@RequestMapping (PathConfiguration.NOTIFICATIONS_GENERATE_BY_STATE)
	@ResponseBody
	public Map<NotificationState, List<Notification>> generateStatisticsGroupedByState (@RequestParam (name = PathConfiguration.APPLICATION_ID_PARAM) Long applicationId)
	{
		return notificationService.generateStatisticsGroupedByState(applicationId);
	}
}
